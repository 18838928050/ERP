/*! EkImgParser v1.0 | (c) 2016 Eking Soft, Inc. */
/**
* if jpg is mxif then need EXIF.js
*/
;(function(){
	var widt="";
	var heig="";
	var dpi="";
	var EkImgParser={
		parse:function(arraBuff){//arraBuff:ArrayBuffer
			//clear
			widt="";
			heig="";
			dpi="";
	
			var dv=new DataView(arraBuff);
			if(dv.getUint8(0).toString(16)=='ff' && dv.getUint8(1).toString(16)=='d8'){//jpg
				var jpgType=dv.getUint8(6).toString(16) + dv.getUint8(7).toString(16) + dv.getUint8(8).toString(16) + dv.getUint8(9).toString(16);
				
				if(jpgType=='4a464946'){//4A 46 49 46 JFIF
					var unit=dv.getUint8(13);
					var xdpi=dv.getUint16(14);//[14][15]:xdpi [16][17]:ydpi
					
					//计算APPn(FFEX x=0~F)和DQT(FFDB)的长度(有可能这些内容里有跟SOF0段落标记一样的内容,要跳过)
					var startInde=2;//APP0开始位置
					while(dv.getUint8(startInde)==255 && (dv.getUint8(startInde+1)>=224 && dv.getUint8(startInde+1)<=239 || dv.getUint8(startInde+1)==219)){//255:FF 224~239:E0~EF 219:DB
						var leng=parseInt2Bina(dv.getUint8(startInde+2),dv.getUint8(startInde+3),false);
						startInde=startInde+leng+2;//2:标记的长度
					}
					
					for(var i=startInde;i<dv.byteLength-8;i++){
						if(dv.getUint8(i).toString(16)=='ff' && dv.getUint8(i+1).toString(16)=='c0'){//SOF0段落
							heig=dv.getUint16(i+5);
							widt=dv.getUint16(i+7);
							break;
						}
					}
					
					//unit:0 无单位 1 点数/英寸 2 点数/厘米
					if(unit=='1'){
						widt=widt/xdpi*2.54;
						heig=heig/xdpi*2.54;
						dpi=xdpi;
					}else if(unit=='2'){
						widt=widt/xdpi;
						heig=heig/xdpi;
						dpi=xdpi*2.54;
					}
					
				}else if(jpgType=='45786966'){//45 78 69 66 Exif
					//alert(arraBuff instanceof window.ArrayBuffer);
					EXIF.getData(arraBuff, function() {//exif.js的getData私自增加了对ArrayBuffer的处理,替换包时要加上
        				widt=EXIF.getTag(this,"PixelXDimension");//ImageWidth不准确?
        				heig=EXIF.getTag(this,"PixelYDimension");
        				var xdpi=EXIF.getTag(this,"XResolution");
        				var unit=EXIF.getTag(this,"ResolutionUnit");//1没有单位 2点数/英寸 3点数/厘米
        				
        				if(unit=="2"){
	        				dpi=xdpi;
	        				widt=widt/xdpi*2.54;
							heig=heig/xdpi*2.54;
        				}else if(unit=="3"){//点数/厘米
        					dpi=xdpi*2.54;
	        				widt=widt/xdpi;
							heig=heig/xdpi;
        				}
        				
    				});
				}
			}else if(dv.getUint8(0).toString(16)=='42' && dv.getUint8(1).toString(16)=='4d'){//bmp
				//[18][19][20][21]:width 高位在后
				widt=parseInt4Bina(dv.getUint8(18),dv.getUint8(19),dv.getUint8(20),dv.getUint8(21),true);
				//[22][23][24][25]:height 高位在后
				heig=parseInt4Bina(dv.getUint8(22),dv.getUint8(23),dv.getUint8(24),dv.getUint8(25),true);
				//[38][39][40][41]:xdpi [42][43][44][45]:ydpi 高位在后 每米 n像素
				var xdpi=parseInt4Bina(dv.getUint8(38),dv.getUint8(39),dv.getUint8(40),dv.getUint8(41),true);
				
				dpi=xdpi/100*2.54;
				widt=widt/xdpi*100;
				heig=heig/xdpi*100;
			}else if(dv.getUint8(0).toString(16)=='89' && dv.getUint8(1).toString(16)=='50' && dv.getUint8(2).toString(16)=='4e' && dv.getUint8(3).toString(16)=='47' && dv.getUint8(4).toString(16)=='d'  && dv.getUint8(5).toString(16)=='a' && dv.getUint8(6).toString(16)=='1a' && dv.getUint8(7).toString(16)=='a'){//89 50 4E 47 0D 0A 1A 0A png
				widt=dv.getUint32(16);
				heig=dv.getUint32(20);
				var xdpi="";
				for(var i=0;i<dv.byteLength-8;i++){
					if(dv.getUint8(i).toString(16)=='70' && dv.getUint8(i+1).toString(16)=='48' && dv.getUint8(i+2).toString(16)=='59' && dv.getUint8(i+3).toString(16)=='73'){//pHYs段落
						xdpi=dv.getUint32(i+4);//[i+4]to[i+7]:xdpi [i+8]to[i+11]ydpi 每米 n像素
						break;
					}
				}
				
				if(xdpi!=""){
					dpi=xdpi/100*2.54;
					widt=widt/xdpi*100;
					heig=heig/xdpi*100;
				}
				
			}else if(dv.getUint8(0).toString(16)=='4d' && dv.getUint8(1).toString(16)=='4d' || dv.getUint8(0).toString(16)=='49' && dv.getUint8(1).toString(16)=='49'){//tiff
				var lowHigh=false;
				if(dv.getUint8(0).toString(16)=='49' && dv.getUint8(1).toString(16)=='49'){
					lowHigh=true;//II:高位在后 MM:高位在前
				}
				var offs=parseInt4Bina(dv.getUint8(4),dv.getUint8(5),dv.getUint8(6),dv.getUint8(7),lowHigh);//偏移量
				var deCount=parseInt2Bina(dv.getUint8(offs),dv.getUint8(offs+1),lowHigh);//de的数量
				var deBlockSize=2+deCount*12+4;//每个DE占用12字节,加前面的Directory Entry Count占用的2字节,再加后面Offset to next IFD占用的4字节
				
				var startInde=offs+2;//前面的Directory Entry Count占用的2字节
				var xdpi="";
				for(var i=0;i<deCount;i++){
					var tagId=parseStr2Bina(dv.getUint8(startInde+i*12),dv.getUint8(startInde+i*12+1),lowHigh);
					
					if(tagId=='0100'){//宽
						widt=parseInt4Bina(dv.getUint8(startInde+i*12+8),dv.getUint8(startInde+i*12+9),dv.getUint8(startInde+i*12+10),dv.getUint8(startInde+i*12+11),lowHigh);
					}else if(tagId=='0101'){//高
						heig=parseInt4Bina(dv.getUint8(startInde+i*12+8),dv.getUint8(startInde+i*12+9),dv.getUint8(startInde+i*12+10),dv.getUint8(startInde+i*12+11),lowHigh);
					}else if(tagId=='011a'){//水平分辩率偏移量 011B:垂直分辩率偏移量 类型为0005(即RATIONAL,前4位分母后4位分子)
						var dpiOffs=parseInt4Bina(dv.getUint8(startInde+i*12+8),dv.getUint8(startInde+i*12+9),dv.getUint8(startInde+i*12+10),dv.getUint8(startInde+i*12+11),lowHigh);
						var dpiFm=parseInt4Bina(dv.getUint8(dpiOffs),dv.getUint8(dpiOffs+1),dv.getUint8(dpiOffs+2),dv.getUint8(dpiOffs+3),lowHigh);
						var dpiFz=parseInt4Bina(dv.getUint8(dpiOffs+4),dv.getUint8(dpiOffs+5),dv.getUint8(dpiOffs+6),dv.getUint8(dpiOffs+7),lowHigh);
						xdpi=dpiFm/dpiFz;//点数/英寸
					}
				}
				
				if(xdpi!=""){
					dpi=xdpi;
					widt=widt/xdpi*2.54;
					heig=heig/xdpi*2.54;
				}
			}
			
			return {"width":widt,"height":heig,"dpi":dpi};
			//alert("dpi:"+dpi+" heig:"+heig+" widt:"+widt);
			
			function formatInt16Hex(str){
				var str=str.toString(16);
				if(str.length % 2==1){
					str="0"+str;
				}
				return str;
			};
			function parseInt4Bina(b1,b2,b3,b4,lowHigh){//传字节的int进来
				b1=formatInt16Hex(b1);
				b2=formatInt16Hex(b2);
				b3=formatInt16Hex(b3);
				b4=formatInt16Hex(b4);
				if(lowHigh){
					return parseInt(""+b4+b3+b2+b1,16);
				}else{
					return parseInt(""+b1+b2+b3+b4,16);
				}
			};
			function parseInt2Bina(b1,b2,lowHigh){//传字节的int进来
				b1=formatInt16Hex(b1);
				b2=formatInt16Hex(b2);
				if(lowHigh){
					return parseInt(""+b2+b1,16);
				}else{
					return parseInt(""+b1+b2,16);
				}
			};
			function parseStr2Bina(b1,b2,lowHigh){//传字节的int进来
				b1=formatInt16Hex(b1);
				b2=formatInt16Hex(b2);
				if(lowHigh){
					return ""+b2+b1;
				}else{
					return ""+b1+b2;
				}
			};
		}
	};
	
	window.EkImgParser=EkImgParser;
})();