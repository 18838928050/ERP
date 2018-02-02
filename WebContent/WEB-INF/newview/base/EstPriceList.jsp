<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0082)http://115.28.87.22:8888/base/EstPriceList.html?price_type=STA&est_type=COOPERATOR -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>项目价格目录 | 管理易-广告加工制作管理软件  企业版 9.28  | 易凯软件</title>
<script src="js/minierp.js"></script>

<link rel="stylesheet" type="text/css" href="css/base.css">
<link href="css/Query.css" rel="stylesheet" type="text/css">
<script src="js/QueryList.js"></script>
<script src="js/popup_ext.js"></script>
<script language="javascript">
	function doNew(){
		var url="base/EstPriceNew.html?est_type=COOPERATOR&price_type=STA";
		ShowIframe("项目价格",url,1024,400,"refreshWin()",1024,600);
	}
	function refreshWin(){
		if(popRetVal!=null){
			window.location.reload(true);
		}
	}
	function doEdit(id){
		var url="base/EstPriceEdit.html?id="+id;
		ShowIframeNoScroll("项目价格",url,400,520,"refreshWin()");
	}
	function doSearch(){
		var mtId=document.getElementById("mt_id").value;
		var proName=document.getElementById("pro_name").value.trim();
		if(proName=="录入材质名称查询"){
			proName="";
		}else{
			proName=encodeURIComponent(proName);
		}
		window.location="base/EstPriceList.html?est_type=COOPERATOR&price_type=STA&mt_id="+mtId+"&pro_name="+proName;
	}
	function doDownload(){
		var proName=encodeURIComponent("");
		window.location="base/EstPriceList.html?est_type=COOPERATOR&price_type=STA&mt_id=0&pro_name="+proName+"&content_type=EXCEL";
	}
	function doGo(pageIndex){
		var proName=encodeURIComponent("");
		window.location="base/EstPriceList.html?est_type=COOPERATOR&price_type=STA&mt_id=0&pro_name="+proName+"&current_page="+pageIndex;
	}
	function doJump(pageIndex){
		if(window.event.keyCode==13){
			doGo(pageIndex);
		}
	}
	function DoubleClick(it){
		var ob_arr = document.getElementsByName("query_checkbox");
		var str="";
		if(ob_arr.length>=it.getAttribute("index")){
			str=ob_arr[it.getAttribute("index")-1].value;
		}
		if(str==""){
			return;
		}
		doEdit(str);
	}
	function checkProName(){
		if(window.event.keyCode==13){
			doSearch();
		}
	}
	function proNameFocus(){
		if(document.getElementById("pro_name").value=="录入材质名称查询"){
			document.getElementById("pro_name").value="";
		}
	}
	function proNameBlur(){
		if(document.getElementById("pro_name").value==""){
			document.getElementById("pro_name").value="录入材质名称查询";
		}
	}
	function doDelete(id){
		ShowConfirm('确认框','确定删除吗？',340,80,"doDelAct('"+id+"')");
	}
	function doDelAct(id){
		if(popRetVal!=null){
			window.location="base/EstPriceDelete.html?est_type=COOPERATOR&id="+id+"&from_url="+encodeURIComponent(window.location);
		}
	}
	function selectEst(){
		var url="base/EstablishmentListForSelect.html?type=COOPERATOR&show_all=S";
		ShowIframe("选择外协商",url,900,500,"selectEstCallBack()");
	}
	function doInit(){
		document.getElementById("pro_name").focus();
	}
	function getMultiId(){
		var ob_arr = document.getElementsByName("query_checkbox");
		var str="";
		for (i=0;i<ob_arr.length;i++){
			if ((ob_arr[i].checked == true)){
				if(str!=""){
					str=str+";";
				}
				str = str+ob_arr[i].value;
			}
		}
		return str;
	}
	function doMultiDelete(){
		var str=getMultiId();
		if(str==""){
			ShowAlert('提示框','请选择要删除的记录!',200,100);
		}else{
			doDelete(str);
		}
	}
</script>
</head>
<body onload="doInit();" class="sheet" style="padding-top:10px;text-align:center;">
<div class="sheet-main" style="width:980px;text-align:left;margin:auto;">
  <div class="sheet-top">
    <div class="content">
      <h2>项目价格目录</h2>
      <p>定义项目标准价格表，新增外协单时可以直接选择，提高开单效率</p>
    </div>
  </div>
  <div class="sheet-list">
    <div class="search-business">
		 <div class="content">
	        <table width="868" border="0">
	          <tbody>
	            <tr>
	              <td align="right">
	              	<select name="mt_id" id="mt_id" style="width:160px" onchange="doSearch();">
						<option value="0">请选择项目类型</option>
						
<option value="10">标牌</option>
<option value="11">标识</option>
<option value="109">标识标牌</option>
<option value="110">&nbsp;|--指示牌</option>
<option value="111">&nbsp;|--警示牌</option>
<option value="112">&nbsp;|--桌牌</option>
<option value="113">&nbsp;|--立牌</option>
<option value="114">&nbsp;|--展示牌</option>
<option value="115">&nbsp;|--户外标识</option>
<option value="116">广告字</option>
<option value="117">&nbsp;|--不发光立体字</option>
<option value="118">&nbsp;|--背光立体字</option>
<option value="119">&nbsp;|--发光立体字</option>
<option value="120">&nbsp;|--光树脂发光立体字</option>
<option value="121">&nbsp;|--立体发光立体字</option>
<option value="13">型材销售</option>
<option value="17">&nbsp;|--画框型材</option>
<option value="18">&nbsp;|--画框配件</option>
<option value="34">灯箱</option>
<option value="122">&nbsp;|--吸塑灯箱</option>
<option value="123">&nbsp;|--超薄灯箱</option>
<option value="124">&nbsp;|--落地式灯箱</option>
<option value="125">&nbsp;|--软膜灯箱</option>
<option value="126">&nbsp;|--动态灯箱</option>
<option value="127">&nbsp;|--LED灯箱</option>
<option value="128">门头店招</option>
<option value="129">&nbsp;|--彩条店招</option>
<option value="130">&nbsp;|--模组店招</option>
<option value="131">&nbsp;|--拉布内光店招</option>
<option value="132">&nbsp;|--异形店招</option>
<option value="97">标牌配件</option>
<option value="98">东厂</option>
<option value="133">快展器材</option>
<option value="134">&nbsp;|--快展背景墙</option>
<option value="135">&nbsp;|--X展架</option>
<option value="136">&nbsp;|--易拉宝</option>
<option value="137">&nbsp;|--注水旗杆</option>
<option value="138">&nbsp;|--快展套装</option>
<option value="99">成品标牌</option>
<option value="139">展柜展架</option>
<option value="140">&nbsp;|--靠墙柜</option>
<option value="141">&nbsp;|--中岛柜</option>
<option value="142">&nbsp;|--平柜</option>
<option value="143">&nbsp;|--收银台</option>
<option value="144">&nbsp;|--挂架</option>
<option value="145">&nbsp;|--端架</option>
<option value="146">&nbsp;|--地台</option>
<option value="147">印刷</option>
<option value="148">&nbsp;|--名片</option>
<option value="149">&nbsp;|--宣传单</option>
<option value="150">&nbsp;|--画册</option>
<option value="151">&nbsp;|--手提袋</option>
<option value="152">&nbsp;|--台挂历</option>
<option value="153">促销用品</option>
<option value="154">&nbsp;|--吊旗</option>
<option value="155">&nbsp;|--太阳伞</option>
<option value="156">&nbsp;|--条幅横幅</option>
<option value="157">&nbsp;|--挂墙展板</option>
<option value="158">&nbsp;|--拱门气球</option>
<option value="159">&nbsp;|--礼品</option>
<option value="103">喷绘</option>
<option value="104">&nbsp;|--挂画</option>
<option value="105">&nbsp;|--灯箱画片</option>
<option value="106">&nbsp;|--高精图像片</option>
<option value="107">&nbsp;|--户外彩喷</option>
<option value="108">&nbsp;|--车身彩绘</option>
				  	</select>
		            <input type="text" class="TextBox" id="pro_name" name="pro_name" onkeyup="checkProName();" onfocus="proNameFocus();" onblur="proNameBlur();" style="width:100px" value="录入材质名称查询" title="以材质名称或者材质的拼音字头进行模糊查询">
		            <input type="button" class="buttom search-but" value=" 查 询" onclick="doSearch();">
		            <input type="button" class="buttom search-out" value=" 导 出" onclick="doDownload();">
					
						<input type="button" value=" 删 除" class="buttom search-remo" onclick="javascript:doMultiDelete();">
					  	<input type="button" value=" 新 增" class="buttom search-add" onclick="doNew();" title="添加项目的外协标准价格">
					
				  </td>
	            </tr>    
	           </tbody>      
	        </table>
	      </div>
		 
<table width="98%" border="0" cellpadding="0" cellspacing="0">
	<tbody><tr id="errorMsgTr" style="display:none">
	  <td>
	  	<div class="msg-error" id="errorMsgTd">
	  	
	  	</div>
	  </td>
	</tr>
</tbody></table>
	     <div class="table-list">
	        <table width="100%">
	          <tbody><tr>
	          	<th width="14"><input type="checkbox" onclick="javascript:checkall(this);"></th>
				<th width="12%">项目类型</th>
				<th width="14%">材质</th>
				<th width="14%">规格</th>
				<th width="8%">单位</th>
				<th width="10%">单价</th>
				<th width="14%">制作要求</th>
				
					<th width="16%">备注</th>
					<th width="12%">操作</th>
				
				
			 </tr>
			
			
			
			<tr class="query_list_data_tr1" index="1" style="cursor:pointer;" ondblclick="javascript:DoubleClick(this)" onclick="javascript:ClickCheck(this,true)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
				<td><input type="checkbox" onclick="javascript:ClickCheck(this,true);" name="query_checkbox" value="296"></td>
				<td>标识</td>
				<td>4厘白玻</td>
				<td>2m x 5m高</td>
				<td>平方米</td>
				<td>36</td>
				<td>闪闪亮亮的~</td>
				<td></td>
				
					<td>
						
						<a href="javascript:doEdit(&#39;296&#39;);">编辑</a>
						<a href="javascript:doDelete(&#39;296&#39;);">删除</a>
					</td>
				
			</tr>
			
			
			
			<tr class="query_list_data_tr2" index="2" style="cursor:pointer;" ondblclick="javascript:DoubleClick(this)" onclick="javascript:ClickCheck(this,true)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
				<td><input type="checkbox" onclick="javascript:ClickCheck(this,true);" name="query_checkbox" value="297"></td>
				<td>警示牌</td>
				<td>防雨LED电源</td>
				<td>1m x 4m高</td>
				<td>个</td>
				<td>100</td>
				<td></td>
				<td></td>
				
					<td>
						
						<a href="javascript:doEdit(&#39;297&#39;);">编辑</a>
						<a href="javascript:doDelete(&#39;297&#39;);">删除</a>
					</td>
				
			</tr>
			
		</tbody></table>
			
    <div class="table-bot">
    	
    	
    	 
    	  <img src="images/but001.gif">
    	  <img src="images/but002.gif">
    	    	
    	第 <input type="text" name="pageNumber" style="width:30px" value="1" onkeydown="javascript:doJump(this.value);" class="TextBox"> 页 
    	共1页
		
		
        <img src="images/but003.gif">
        <img src="images/but004.gif">
		
    </div>
     </div>  
   </div>  
  </div>
<div class="blank12">
</div>

</div></body></html>