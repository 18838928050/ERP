<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>


<body oncontextmenu="return false" onload="doInit();" class="sheet" scroll="no">
<div class="sheet-main">
	<div class="sheet-top">
	  <div class="content">
	    <h2>选择员工</h2>
	  </div>
	</div>

	<div class="sheet-list" id="mainTd" style="height:348px;">
		<div class="blank24"></div>
		<div class="nav" id="navDiv" style="float:left;height:100%;border:1px solid #CCCCCC;">
			<iframe width="100%" height="100%" frameborder="0" id="leftFrame" scrolling="no" src="Business_findDepartment"></iframe>
		</div>
		<div id="mainDiv" class="main search-business" style="float: right; height: 100%; width: 648px;border:1px solid #CCCCCC;">
			<iframe width="100%" height="100%" frameborder="0" id="mainFrame" scrolling="no" src="./StafferListForSelect.html"></iframe>
		</div>
	</div>
	
	<div class="sheet-list" id="selectedTr" style="height:100px;display:none;OVERFLOW:auto">
	  <table width="100%" border="0" cellspacing="0" cellpadding="0">
	  <tbody><tr>
		<td>
			<table width="100%" border="0" cellspacing="1" cellpadding="1" class="table-list">
				 <tbody id="selectedTbl">
				 
				</tbody>
			</table>
		</td>
	  </tr>
	  </tbody></table>
	</div>
	<div id="buttonDiv" style="display:none;float:right;margin-right:16px">
  		<input type="button" class="buttom search-select" value=" 选 择" onclick="doOk();">
    </div>
</div>
<script src="js/minierp.js"></script>

<script src="js/popup.js"></script>
<script language="javascript">
	var selectedArr=new Array();
	Array.prototype.del=function(n) {　//n表示第几项，从0开始算起。
		//prototype为对象原型，注意这里为对象增加自定义方法的方法。
　		if(n<0)　//如果n<0，则不进行任何操作。
　　			return this;
　		else
　　			return this.slice(0,n).concat(this.slice(n+1,this.length));
	　　/*
	　　　concat方法：返回一个新数组，这个新数组是由两个或更多数组组合而成的。
	　　　　　　　　　这里就是返回this.slice(0,n)/this.slice(n+1,this.length)
	　　 　　　　　　组成的新数组，这中间，刚好少了第n项。
	　　　slice方法： 返回一个数组的一段，两个参数，分别指定开始和结束的位置。
	　　*/
	}
	
	function showSelected(arr,isChecked){
		var tmpArr;
		var found=false;
		var index=0;
		var i;
		for(i=0;i<selectedArr.length;i++){
			tmpArr=selectedArr[i];
			if(tmpArr[0]==arr[0]){
				found=true;
				index=i;
				break;
			}
		}
		if(isChecked){//add
			if(!found){
				selectedArr[selectedArr.length]=arr;
				
				var tbl=document.getElementById("selectedTbl");
				var tr=document.createElement("tr");
				tr.setAttribute("id","itemTr"+arr[0]);
				
				var td=document.createElement("td");
				td.setAttribute("width","30%");
				td.appendChild(document.createTextNode(arr[3]));
				tr.appendChild(td);
				
				td=document.createElement("td");
				td.setAttribute("width","20%");
				td.appendChild(document.createTextNode(arr[2]));
				tr.appendChild(td);
				
				td=document.createElement("td");
				td.setAttribute("width","30%");
				td.appendChild(document.createTextNode(arr[4]));
				tr.appendChild(td);
				
				td=document.createElement("td");
				td.setAttribute("width","20%");
				var delLink=document.createElement("a");
				delLink.setAttribute("href","javascript:doItemDelete("+arr[0]+");");
				delLink.appendChild(document.createTextNode("删除"));
				td.appendChild(delLink);
				tr.appendChild(td);
				
				tbl.appendChild(tr);
			}
		}else{//删除
			if(found){
				selectedArr=selectedArr.del(index);
				var tbl=document.getElementById("selectedTbl");
				var tr=document.getElementById("itemTr"+arr[0]);
				tbl.removeChild(tr);
			}
		}
		showOrHidDiv();
	}
	function showOrHidDiv(){
		if(selectedArr.length==0){
			document.getElementById("mainTd").style.height="348px";
			document.getElementById("selectedTr").style.display="none";
			document.getElementById("buttonDiv").style.display="none";
			document.getElementById("leftFrame").contentWindow.fixDivHeight("NORMAL");
			document.getElementById("mainFrame").contentWindow.fixDivHeight("NORMAL");
		}else if(document.getElementById("selectedTr").style.display=="none")
		{
			document.getElementById("mainTd").style.height="248px";
			document.getElementById("selectedTr").style.display="";
			document.getElementById("buttonDiv").style.display="";
			document.getElementById("leftFrame").contentWindow.fixDivHeight("UNNORMAL");
			document.getElementById("mainFrame").contentWindow.fixDivHeight("UNNORMAL");
		}
	}
	function doItemDelete(id){
		var tmpArr;
		var found=false;
		var index=0;
		var i;
		for(i=0;i<selectedArr.length;i++){
			tmpArr=selectedArr[i];
			if(tmpArr[0]==id){
				found=true;
				index=i;
				break;
			}
		}
		if(found){
			selectedArr=selectedArr.del(index);
			var tbl=document.getElementById("selectedTbl");
			var tr=document.getElementById("itemTr"+id);
			tbl.removeChild(tr);
		}
		showOrHidDiv();
	}
	function doOk(){
		if(selectedArr.length>0){
			parent.popRetVal=selectedArr;
			parent.ClosePop();
		}else{
			ShowAlert('提示框','请选择员工',200,100);
		}
	}
	function doInit(){
//		document.getElementById("mainDiv").style.width=(document.getElementById("mainTd").clientWidth-document.getElementById("navDiv").offsetWidth)+"px";
		var defaultId="";
		if(defaultId==""){
			document.getElementById("mainFrame").src="./StafferListForSelect.html?type=";
		}
	}
</script>
</body></html>