<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<%@taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Expires" content="0">
<title>安装单审核 </title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
		<link href="${pageContext.request.contextPath }/css/Query.css" rel="stylesheet" type="text/css">

		<script src="${pageContext.request.contextPath }/js/minierp.js"></script>
		<script src="${pageContext.request.contextPath }/js/QueryList.js"></script>
		<script src="${pageContext.request.contextPath }/js/popup.js"></script>
		<script src="${pageContext.request.contextPath }/layui/layui.all.js"></script>
<script language="javascript">
	function doShow(id){
		var url="../business/SetuBillInfoForExam.html?id="+id;
		ShowIframe(['900px','500px'], url, '', function(){
					refreshWin();
				}, '安装单审核');
	}
	function refreshWin(){
		if(popRetVal!=null){
			window.location=window.location;
		}
	}
	function doExamine(id){
		ShowConfirm('确认框','确定审核通过吗？',340,80,"doExamineCallBack('"+id+"')");
	}
	function doExamineCallBack(id){
		if(popRetVal!=null){
			var url="../business/SetuBillExam.html?id_str="+id+"&flag=1";
			ShowIframe("安装单审核",url,200,200,"refreshWin()");
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
			ShowAlert('提示框','请选择要审核的安装单',200,100);
		}
	}
	function doSearch(){
		var searchKey=encodeURIComponent(document.getElementById("search_key").value.trim());
		var tsId=document.getElementById("ts_id").value;
		window.location="../business/SetuBillListForExam.html?ts_id="+tsId+"&search_key="+searchKey;
	}
	function doGo(pageIndex){
		var searchKey=encodeURIComponent("");
		window.location="../business/SetuBillListForExam.html?ts_id=1&search_key="+searchKey+"&current_page="+pageIndex;
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
<body oncontextmenu="return false" onload="doInit();" class="sheet">
<div class="sheet-main">
  <div class="sheet-top">
    <div class="content">
      <h2>安装单审核</h2>
<div class="pull-right">
			<div class="layui-form" style=" display: inline-block;">
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input type="text" class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();">
						</div>
					</div>
				<div class="layui-inline">
				<select name="ts_id" id="ts_id">
				<option value="0">==请选择账套==</option>

				<option value="1" selected="">新异</option>

				<option value="2">网络公司</option>

				</select>
				</div>
				<a type="button " class="layui-btn " onclick="doSearch();">查 询</a>
				<a type="button " class="layui-btn " onclick="doMutiExamine();">审核通过</a>
			</div>
		</div>
    </div>
  </div>
  <div class="sheet-list">
    <div class="search-business">
       
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
				<th width="12%">安装单号
				</th><th width="9%">排单日期</th>
				<th width="20%">订货单位</th>
				<th width="12%">业务单号
				</th><th width="17%">业务单摘要
				</th><th width="12%">安装人员</th>
				<th width="8%">开单人</th>
				<th width="10%">操作</th>
			</tr>	
			<s:iterator value="list">
<tr>
	<th width="14"><input type="checkbox" onclick="javascript:checkall(this);"></th>
<td>${a}</td>
<td>${b}</td>
<td>${c}</td>
<td>${d}</td>
<td>${e}</td>
<td>${f}</td>
<td>${g}</td>
<td><s:a action="anzhuagndanshenhe_examined1?anzhuangBean.a=%{a }">审核通过</s:a>&nbsp;<s:a action="anzhuagndanshenhe_chakan?anAzhuangdanchakanBean.a=%{a}">查看</s:a></td>
</tr>
</s:iterator>
		</tbody>
        </table>
			<div class="table-bot clearfix">
				<div class="pull-right">
					<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but001.gif"></a>
					<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but002.gif"></a>
					第
					<div class="layui-input-inline">
						<input class="layui-input" style="width:30px" placeholder="" type="text" maxlength="15" onkeydown="javascript:doJump(this.value);" id="confirmPassword" name="pageNumber" value="1">
					</div>
					页&nbsp;&nbsp;共1页
					<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but003.gif"></a>
					<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but004.gif"></a>
				</div>
			</div>
      </div>
    </div>
  </div>
</div>
		<audio controls="controls" style="display: none;"></audio>
		<script src="${pageContext.request.contextPath }/layui/layui.all.js"></script>
</body>
</html>