<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0046)http://115.28.87.22:8888/base/InnerPbList.html -->
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>内部通讯录</title>
<link rel="stylesheet" href="layui/css/layui.css">
<script src="js/minierp.js"></script>

<link rel="stylesheet" type="text/css" href="css/base.css">
<link href="css/Query.css" rel="stylesheet" type="text/css">
<script src="js/QueryList.js"></script>
<script src="layui/layui.all.js"></script>
<script language="javascript">
	function doSearch(){
		var departmentId="";
		var searchKey=encodeURIComponent(document.getElementById("search_key").value.trim());
		var searchAll="";
		if(document.getElementById("search_all").checked){
			searchAll="1";
		}
		window.location="./InnerPbList.html?department_id="+departmentId+"&search_key="+searchKey+"&search_all="+searchAll;
	}
	function doDownload(){
		var departmentId="";
		var searchKey=encodeURIComponent("");
		var searchAll="1";
		window.location="./InnerPbList.html?content_type=EXCEL&department_id="+departmentId+"&search_key="+searchKey+"&search_all="+searchAll;
	}
	function doInit(){
		Window_Onload();
		document.getElementById("search_key").focus();
	}
	function checkSearchKey(){
		if(window.event.keyCode==13){
			doSearch();
		}
	}
	function showSms(mobile,recName){
		showWin(900,500,"sms/SmsSendForm.html?mobile="+mobile+"&rec_name="+encodeURIComponent(recName));
	}
	function DoubleClick(it){
	}
</script>
</head>


<body oncontextmenu="return false" onload="doInit();" scroll="no">
		<div id="scrollDiv" style="OVERFLOW:auto;height:508px;">
		  <div class="main search-business">
		  	<div class="blank24"></div>
			   <!--<div class="cue-info" style="padding: 0 25px;">
					<h4 style="display: inline-block;">所有部门</h4>
				</div>-->
							<div class="layui-form" style="padding: 0 25px;float: right;">
								<div class="layui-inline">
									<div class="layui-input-inline">
										<input  type="text " class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();" value="" title="以产品名称、产品名称拼音字头进行模糊查询">
									</div>
								</div>
								<div class="layui-input-inline">
							      <input type="checkbox" id="search_all" name="search_all" lay-skin="primary" title="在所有类别中查找材料" checked="">
							    </div>
								<a type="button " class="layui-btn " onclick="doSearch();" title="以产品名称、产品名称拼音字头进行模糊查询">查 询</a>
								<a type="button " class="layui-btn " onclick="doNew();">发表</a>
							</div>		  
			  
			  <div class="table-list" style="width:98%; padding:15px 0 15px 10px; float:left;">
					<table width="100%">
						<tbody><tr>
							<th width="12%">部门</th>
							<th width="8%">姓名</th>
							<th width="10%">职位</th>
							<th width="12%">手机</th>
							<th width="10%">移动短号</th>
							<th width="12%">QQ</th>
							<th width="14%">邮箱</th>
							<th width="14%">电话</th>
							<th width="8%">分机</th>
						</tr>
						<s:iterator value="staffers">
						<tr class="query_list_data_tr2" index="20" style="cursor:pointer;" onmouseout="javascript:mouseout(this)" ondblclick="javascript:DoubleClick(this)" onmouseover="javascript:mouseover(this)" onclick="javascript:ClickCheck(this)">
							<td>
								<input type="radio" onclick="javascript:ClickCheck(this);" name="query_checkbox" value="-1" style="display:none">
								${departmentId }
							</td>
							<td>${stafferName }</td>
							<td></td>
							<td style="word-wrap:break-word;word-break:break-all;"><a href="javascript:showSms(&#39;13608675408&#39;,&#39;管理员&#39;);">${mobile }</a></td>
							<td style="word-wrap:break-word;word-break:break-all;">${subMobile }</td>
							<td style="word-wrap:break-word;word-break:break-all;">${qq }<a href="http://wpa.qq.com/msgrd?V=1&amp;Uin=&amp;Site=eking;&amp;Menu=no"></a></td>
							<td style="word-wrap:break-word;word-break:break-all;">${email}<a href="mailto:"></a></td>
							<td style="word-wrap:break-word;word-break:break-all;">${phone }</td>
							<td style="word-wrap:break-word;word-break:break-all;">${subPhone }</td>
						</tr>
						</s:iterator>
						</tbody>
					</table>
			  </div>
			</div>
		</div>

<audio controls="controls" style="display: none;"></audio>
<script src="layui/layui.all.js"></script>
</body>

</html>