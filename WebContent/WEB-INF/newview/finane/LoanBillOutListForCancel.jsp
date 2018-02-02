<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

<body oncontextmenu="return false" onload="doInit();" class="sheet">
	<div class="sheet-main">
		<div class="sheet-top">
			<div class="content">
				<h2>资金借出单作废</h2>
				<div class="pull-right">
					<div class="layui-form" style="display: inline-block;">
						<div class="layui-inline">
							<div class="layui-input-inline">
								<input type="text" class="layui-input" id="search_key"
									name="search_key" onkeyup="checkSearchKey();">
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
					</div>
				</div>
			</div>
		</div>
		<div class="sheet-list">
			<div class="search-business">

				<div class="TopToolBar" style="margin: 5px 0;">
					<table class="ListNoteInfo" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td>金额合计：0元</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="table-list">
					<table width="100%">
						<tbody>
							<tr>
								<th width="15%">单号</th>
								<th width="10%">日期</th>
								<th width="12%">借款人</th>
								<th width="10%">金额</th>
								<th width="27%">摘要</th>
								<th width="9%">经办人</th>
								<th width="7%">状态</th>
								<th width="10%">操作</th>
							</tr>
							<s:iterator value="loanBills" var="loanBill">
								<tr class="query_list_data_tr2" index="2"
									style="cursor: pointer;"
									ondblclick="javascript:DoubleClick(this)"
									onclick="javascript:ClickCheck(this)"
									onmouseout="javascript:mouseout(this)"
									onmouseover="javascript:mouseover(this)">
									<td><input type="radio" name="query_checkbox" value="2039"
										style="display: none"> ${billCode }</td>
									<td><s:date name="loanDate" format="yyyy-MM-dd"></s:date></td>
									<td>${rpName }</td>
									<td>${cost }</td>
									<td>${mark }</td>
									<td>${managerName }</td>
									<s:if test=' #loanBill.examined.equals("Y") '>
										<td>已审核</td>
									</s:if>
									<s:elseif test=' #loanBill.examined.equals("N") '>
										<td>未审核</td>
									</s:elseif>
									<td><a href="javascript:doDisabled(${ id });">作废</a> <a
										href="javascript:doShow(${ id });">查看</a></td>
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
	</div>
	<script src="layui/layui.all.js"></script>
	<script src="js/minierp.js"></script>
	<script src="js/QueryList.js"></script>
	<script src="js/jquery-3.0.0.min.js"></script>
	<script src="js/popup.js"></script>

	<script language="javascript">
			function doShow(id) {
				var url = "Accounts_toOutLoanBill?id=" + id;
				ShowIframe(['860px','500px'], url, '', function callBack(){
					refreshWin();
				},'资金借出单作废');
			}

			function refreshWin() {
				if(popRetVal != null) {
					window.location = window.location;
				}
			}

			function doDisabled(id) {
				var url = "Accounts_toDisabledOutLoanBill";
				ShowIframe(['480px','250px'], url, id, function callBack(){
					doDisabledCallback(id);
				},'资金借出单作废');
			}

			function doDisabledCallback(id) {
				if(popRetVal != null) {
					$.post("Accounts_disabledOutLoanBill", {
						id: id,
						reason: popRetVal,
						show_aler: "Y"
					}, function(data, status) {
						parseDisaData(data, status);
					});
				}
			}

			function parseDisaData(data, status) {
				if(status == "success") {
					window.location = window.location;
				} else {
					ShowAlert('系统错误：' + status,{title:'提示框'},);
				}
			}

			function doSearch() {
				var searchKey = encodeURIComponent(document.getElementById("search_key").value.trim());
				var type = "OUT";
				var tsId = document.getElementById("ts_id").value;
				window.location = "finance/LoanBillListForCancel.html?ts_id=" + tsId + "&type=" + type + "&search_key=" + searchKey;
			}

			function doGo(pageIndex) {
				var searchKey = encodeURIComponent("");
				var type = "OUT";
				window.location = "finance/LoanBillListForCancel.html?ts_id=1&type=" + type + "&search_key=" + searchKey + "&current_page=" + pageIndex;
			}

			function doJump(pageIndex) {
				if(window.event.keyCode == 13) {
					doGo(pageIndex);
				}
			}

			function DoubleClick(it) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var str = "";
				if(ob_arr.length >= it.getAttribute("index")) {
					str = ob_arr[it.getAttribute("index") - 1].value;
				}
				if(str == "") {
					return;
				}
				doShow(str);
			}

			function doCancel() {
				window.close();
			}

			function doInit() {
				Window_Onload();
				document.getElementById("search_key").focus();
			}

			function checkSearchKey() {
				if(window.event.keyCode == 13) {
					doSearch();
				}
			}
		</script>

</body>

</html>