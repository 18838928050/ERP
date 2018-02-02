<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0066)http://115.28.87.22:8888/business/DeliverBillListForUnExamine.html -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
			<meta http-equiv="Expires" content="0">
				<title>送货单反审核 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title> <script
					src="js/minierp.js"></script>
				<%@ page language="java" contentType="text/html; charset=UTF-8"
					pageEncoding="UTF-8"%>
				<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				<%@ taglib prefix="s" uri="/struts-tags"%>
				<link rel="stylesheet" type="text/css" href="css/base.css">
					<link href="css/Query.css" rel="stylesheet" type="text/css">
						<script src="js/QueryList.js"></script>
						<script src="js/popup_ext.js"></script>
						<script language="javascript">
	function doShow(id){
		var url="business/DeliverBillInfoForUnExamine.html?id="+id;
		ShowIframe("送货单反审核",url,900,500,"refreshWin()");
	}
	function refreshWin(){
		if(popRetVal!=null){
			window.location=window.location;
		}
	}
	function doExamine(id){
		ShowConfirm('确认框','确定反审核吗？',340,80,"doExamineCallBack('"+id+"')");
	}
	function doExamineCallBack(id){
		if(popRetVal!=null){
			var url="business/DeliverBillExamine.html?id_str="+id+"&flag=0";
			ShowIframe("送货单反审核",url,200,200,"refreshWin()");
		}
	}
	function doMutiExamine(){
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
		if(str!=""){
			doExamine(str);
		}else{
			ShowAlert('提示框','请选择要反审核的送货单',200,100);
		}
	}
	function doSearch(){
		var searchKey=encodeURIComponent(document.getElementById("search_key").value.trim());
		var tsId=document.getElementById("ts_id").value;
		window.location="business/DeliverBillListForUnExamine.html?ts_id="+tsId+"&search_key="+searchKey;
	}
	function doGo(pageIndex){
		var searchKey=encodeURIComponent("");
		window.location="business/DeliverBillListForUnExamine.html?ts_id=1&search_key="+searchKey+"&current_page="+pageIndex;
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
		doShow(str);
	}
	function doCancel(){
		window.close();
	}
	function doInit(){
		//Window_Onload();
		document.getElementById("search_key").focus();
	}
	function checkSearchKey(){
		if(window.event.keyCode==13){
			doSearch();
		}
	}
</script>
</head>
<body oncontextmenu="return false" onload="doInit();" class="sheet"
	style="text-align: center">
	<div class="sheet-main"
		style="width: 980px; text-align: left; margin: auto;">
		<div class="sheet-top">
			<div class="content">
				<h2>送货单反审核</h2>
				<p>将审核通过的送货单恢复为未审核状态</p>
			</div>
		</div>
		<div class="sheet-list">
			<div class="search-business">
				<div class="content">
					<table width="868">
						<tbody>
							<tr>
								<td align="right"><input type="text" class="TextBox"
									id="search_key" name="search_key" onkeyup="checkSearchKey();"
									style="width: 100px" value=""
									title="允许以客户名称、客户拼音字头、送货单号、业务单号、送货单摘要进行模糊查询"> <select
										name="ts_id" id="ts_id">
											<option value="0">==请选择账套==</option>

											<option value="1" selected="">新异</option>

											<option value="2">网络公司</option>

									</select> <input type="button" class="buttom search-but" value=" 查 询"
										onclick="doSearch();"
										title="允许以客户名称、客户拼音字头、送货单号、业务单号、送货单摘要进行模糊查询"> <input
											type="button" class="buttom  search-audit" value=" 反审核"
											onclick="doMutiExamine();"></td>
							</tr>
						</tbody>
					</table>
				</div>

				<table width="98%" border="0" cellpadding="0" cellspacing="0">
					<tbody>
						<tr id="errorMsgTr" style="display: none">
							<td>
								<div class="msg-error" id="errorMsgTd"></div>
							</td>
						</tr>
					</tbody>
				</table>
				<div class="table-list">
					<table width="100%">
						<tbody>
							<tr>
								<th width="14"><input type="checkbox"
									onclick="javascript:checkall(this);"></th>
								<th width="12%">单号</th>
								<th width="9%">送货日期</th>
								<th width="20%">订货单位</th>
								<th width="12%">业务单号</th>
								<th width="23%">摘要</th>
								<th width="8%">业务员</th>
								<th width="8%">开单人</th>
								<th width="8%">操作</th>
							</tr>

							<s:iterator value="deliverBills" var="deliverBill" status="st">
								<s:iterator value="businessBills" var="businessBill" status="st">
									<s:if test='#deliverBill.businessBillId==#businessBill.id'>

										<tr class="query_list_data_tr2" index="10"
											style="cursor: pointer;"
											ondblclick="javascript:DoubleClick(this)"
											onclick="javascript:ClickCheck(this,true)"
											onmouseout="javascript:mouseout(this)"
											onmouseover="javascript:mouseover(this)">
											<td><input type="checkbox"
												onclick="javascript:ClickCheck(this,true);"
												name="query_checkbox" value="2097"></td>
											<td>${deliverBill.billCode}</td>
											<td><s:date name="deliverDate" format="yyyy-MM-dd"></s:date></td>
											<td>${deliverBill.address}</td>
											<td>${businessBill.billCode}</td>
											<td>${deliverBill.content}</td>
											<td>${businessBill.createrName }</td>
											<td>${deliverBill.createrName }</td>
											<td><a href="javascript:doExamine(&#39;2097&#39;);">反审核</a>
												<a href="javascript:doShow(&#39;2097&#39;);">查看</a></td>
										</tr>
									</s:if>
								</s:iterator>
							</s:iterator>




						</tbody>
					</table>

					<div class="table-bot">



						<img src="images/but001.gif"> <img src="images/but002.gif">

								第 <input type="text" name="pageNumber" style="width: 30px"
								value="1" onkeydown="javascript:doJump(this.value);"
								class="TextBox"> 页 共207页 <a style="cursor: pointer"
									onclick="javascript:doGo(&quot;2&quot;);"><img
										src="images/but003.gif"></a> <a style="cursor: pointer"
									onclick="javascript:doGo(&quot;207&quot;);"><img
										src="images/but004.gif"></a>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>