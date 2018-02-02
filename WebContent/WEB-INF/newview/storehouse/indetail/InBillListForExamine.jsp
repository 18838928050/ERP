<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>						
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/Query.css" rel="stylesheet" type="text/css">
	</head>

	<script language="javascript">
		function doShow(id){
			var url="storehouse/InBillInfoForExamine.html?id="+id;
			ShowIframe("入库单审核",url,900,500,"refreshWin()",900,600);
		}
		function refreshWin(){
			if(popRetVal!=null){
				window.location=window.location;
			}
		}
		function doExamineCallBack(id){
			if(popRetVal!=null){
				var url="storehouse/InBillExamine.html?id_str="+id+"&flag=1";
				ShowIframe("入库单审核",url,200,200,"refreshWin()");
			}
		}
		function doExamine(id){
			ShowConfirm('确认框','确定审核通过吗？',340,80,"doExamineCallBack('"+id+"')");
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
				ShowAlert('提示框','请选择要审核的单据',200,100);
			}
		}
		function doSearch(){
			var searchKey=encodeURIComponent(document.getElementById("search_key").value.trim());
			var tsId=document.getElementById("ts_id").value;
			window.location="storehouse/InBillListForExamine.html?ts_id="+tsId+"&search_key="+searchKey;
		}
		function doGo(pageIndex){
			var searchKey=encodeURIComponent("");
			window.location="storehouse/InBillListForExamine.html?ts_id=1&search_key="+searchKey+"&current_page="+pageIndex;
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

	<body oncontextmenu="return false" class="sheet" >
		<div class="sheet-main" >
	  		<div class="sheet-top">
	    		<div class="content">
	     			 <h2>入库单审核</h2>
	      				<div class="pull-right">
							<div class="layui-form" style=" display: inline-block;">
								<div class="layui-inline">
									<input type="text"  id="search_key" name="search_key" onkeyup="checkSearchKey();" value="">
									<input type="text" />							
								</div>
									<a type="button " class="layui-btn " id="sSearchButton " name="sSearchButton " href="doSearch(); ">查询</a>
									<a type="button " class="layui-btn " id="sDownloadButton " name="sDownloadButton " href="doDownload();">审核通过</a>
							</div>
						</div>
	   			 </div>
			</div>
			
	 	<div class="sheet-list">
	   		<div class="search-business">

		<div class="blank24"></div>	 
		<div class="table-list">
		    <table width="100%">
		        <tbody>
		        	<tr>   
						<th width="14"><input type="checkbox" onclick="javascript:checkall(this);"></th>
						<th width="16%">单号</th>
						<th width="12%">入库日期</th>
						<th width="14%">仓库名称</th>
						<th width="12%">入库类型</th>
						<th width="22%">供方单位</th>
						<th width="12%">经办人</th>
						<th width="12%">操作</th>
					</tr>
				<!-- 前台迭代获得后台从数据库传过来的值 -->
				<s:iterator value="inBills" status="inBills">
				<tr>
				    <td></td>
					<td>${billCode }</td>
					<td>${inDate }</td>
					<td>
					   <s:iterator value="storehouses" status="storehouses">
					   		<c:if test="${storehouseId == id }">${stoName }</c:if>
					   </s:iterator>
					</td>
					<td>
					   <s:iterator value="inTypes" status="inTypes">
					   		<c:if test="${id == inTypeId }">${typeName }</c:if>
					   </s:iterator>
					</td>
					<td></td>
					<td>${managerName }</td>
					<td>
						<a href="">审核通过</a>
						<a href="">查看</a>
					</td>
				</tr>
				</s:iterator>		
				</tbody>
		    </table>
						
		    <div class="table-bot clearfix">
				<div class="pull-right">
					<a style="cursor:pointer" onclick=""><img src="images/but001.gif"></a>
					<a style="cursor:pointer" onclick=""><img src="images/but002.gif"></a>
						第
					<div class="layui-input-inline">
						<input class="layui-input" style="width:30px" placeholder="" type="text" maxlength="15" onkeydown="javascript:doJump(this.value);" id="confirmPassword" name="pageNumber" value="1">
					</div>
						<a style="cursor:pointer" onclick=""><img src="images/but003.gif"></a>
						<a style="cursor:pointer" onclick=""><img src="images/but004.gif"></a>
				</div>
			</div>
		</div>     
		</div>
		</div>
	    </div>
		<script src="layui/layui.all.js "></script>
	</body>
</html>			
