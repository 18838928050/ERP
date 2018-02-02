<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0063)http://115.28.87.22:8888/storehouse/InBillListForUnExamine.html -->
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
			<meta http-equiv="Expires" content="0">
				<title>我的通讯录</title>
				<link rel="stylesheet" href="layui/css/layui.css">
					<link rel="stylesheet" type="text/css" href="css/base.css">
						<link href="css/Query.css" rel="stylesheet" type="text/css">

							<script src="js/minierp.js"></script>
							<script src="js/QueryList.js"></script>
							<script src="js/popup.js"></script>
							<script src="layui/layui.all.js"></script>
							<script language="javascript">
								function doNew() {
									var url = "./PhoneBookNew.html";
									ShowIframeNoScroll("通讯录", url, 320, 440,
											"refreshWin()", 760, 400);
								}
								function refreshWin() {
									window.location.reload(true);
								}
								function doEdit(id) {
									var url = "phone_toPhoneBookEdit?id=" + id;
									ShowIframe(['330px','400px'], url, '', function() {
										doDisabledCallback(id);
									},'通讯录');
								}
								function doDelete(id) {
									ShowConfirm('确认框', '确定删除吗？', 340, 80,
											"doDelAct(" + id + ")");
								}
								function doDelAct(id) {
									if (popRetVal != null) {
										window.location = "phone_toPhoneBookEdit?id="
												+ id
												+ "&from_url="
												+ encodeURIComponent(window.location);
									}
								}
								function doCancel() {
									window.close();
								}
								function doGo(pageIndex) {
									var searchKey = encodeURIComponent("");
									window.location = "./PhoneBookList.html?search_key="
											+ searchKey
											+ "&current_page="
											+ pageIndex;
								}
								function doJump(pageIndex) {
									if (window.event.keyCode == 13) {
										doGo(pageIndex);
									}
								}
								function checkSearchKey() {
									if (window.event.keyCode == 13) {
										doSearch();
									}
								}
								function doSearch() {
									var searchKey = encodeURIComponent(document
											.getElementById("search_key").value
											.trim());
									window.location = "./PhoneBookList.html?search_key="
											+ searchKey;
								}
								function doSms(receiver) {
									showWin(
											900,
											500,
											"/sms/SmsSendForm.html?receiver="
													+ encodeURIComponent(receiver));
								}
								function doMutiSms() {
									var ob_arr = document
											.getElementsByName("query_checkbox");
									var str = "";
									for (i = 0; i < ob_arr.length; i++) {
										if ((ob_arr[i].checked == true)) {
											if (str != "") {
												str = str + "\n";
											}
											str = str
													+ ob_arr[i]
															.getAttribute("phone")
													+ "<"
													+ ob_arr[i]
															.getAttribute("per_name")
													+ ">";
										}
									}
									if (str != "") {
										doSms(str);
									} else {
										ShowAlert('提示框', '请选择要发短信的对象', 200, 100);
									}
								}
								function DoubleClick(it) {
								}
								function doInit() {
									//Window_Onload();
									document.getElementById("search_key")
											.focus();
								}
							</script>
</head>
<body oncontextmenu="return false" onload="doInit();" class="sheet">
	<div class="sheet-main">
		<div class="sheet-top">
			<div class="content">
				<h2>我的通讯录</h2>
				<div class="pull-right">
					<div class="layui-form" style="display: inline-block;">
						<div class="layui-inline">
							<div class="layui-input-inline">
								<input type="text" class="layui-input" id="search_key"
									name="search_key" onkeyup="checkSearchKey();"
									title="以联系人姓名、联系人姓名拼音字头进行模糊查询">
							</div>
						</div>
						<a type="button " class="layui-btn " onclick="doSearch();">查 询</a>
						<a type="button " class="layui-btn " onclick="doMutiExamine();">新增</a>
						<a type="text " class="layui-btn " onclick="doMutiSms();">发短信</a>
					</div>
				</div>
			</div>
		</div>
		<div class="blank24"></div>
		<div class="sheet-list">
			<div class="search-business">
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
								<th width="10%">姓名</th>
								<th width="12%">职位</th>
								<th width="23%">公司</th>
								<th width="14%">手机</th>
								<th width="24%">QQ</th>
								<th width="18%">操作</th>
							</tr>
							<s:iterator value="phoneBooks">
							<tr class="query_list_data_tr1" index="1"
								style="cursor: pointer;"
								ondblclick="javascript:DoubleClick(this)"
								onclick="javascript:ClickCheck(this,true)"
								onmouseout="javascript:mouseout(this)"
								onmouseover="javascript:mouseover(this)">
								<td><input type="checkbox"
									onclick="javascript:ClickCheck(this,true);"
									name="query_checkbox" value="125"></td>
								<td>${perName }</td>
								<td>${possie }</td>
								<td>${companyName }</td>
								<td>${mobile }</td>
								<td>${qq }</td>
								<td><a href="javascript:doEdit(${id });">编辑</a> <a
									href="javascript:doDelete(${id });">删除</a> <a
									href="javascript:doSms(&#39;125&#39;);">发短信</a></td>
							</tr>
							</s:iterator>
						</tbody>
					</table>

					<div class="table-bot clearfix">
						<div class="pull-right">
							<a style="cursor: pointer" onclick=""><img
								src="images/but001.gif"></a> <a style="cursor: pointer"
								onclick=""><img src="images/but002.gif"></a> 第
							<div class="layui-input-inline">
								<input class="layui-input" style="width: 30px" placeholder=""
									type="text" maxlength="15"
									onkeydown="javascript:doJump(this.value);" id="confirmPassword"
									name="pageNumber" value="1">
							</div>
							页&nbsp;&nbsp;共1页 <a style="cursor: pointer" onclick=""><img
								src="images/but003.gif"></a> <a style="cursor: pointer"
								onclick=""><img src="images/but004.gif"></a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="blank12"></div>
	</div>
	<audio controls="controls" style="display: none;"></audio>
	<script src="layui/layui.all.js"></script>
</body>
</html>