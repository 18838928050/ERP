<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0065)http://115.28.87.22:8888/business/BusinessBillListForDeliver.html -->
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
				<title>送货 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
				<link rel="stylesheet" href="layui/css/layui.css">
					<link rel="stylesheet" type="text/css" href="css/base.css">
						<link href="css/Query.css" rel="stylesheet" type="text/css">
							<script src="js/minierp.js"></script>
							<script src="js/QueryList.js"></script>
							<script src="js/popup.js"></script>
							<script src="js/jquery-3.0.0.min.js"></script>
							<script language="javascript">
								function doDeliver(id, favCost) {
									var url = "business/DeliverBillNew.html?business_bill_id="
											+ id;
									ShowIframe([ '1024px', '500px' ], url, '',
											function() {
												doDeliverCallBack(id, favCost);
											}, '送货');
								}

								function doDeliverCallBack(id, favCost) {
									if (popRetVal != null) {
										var url = getProgramLocation()
												+ "&current_page=1";
										ShowConfirm('现在打印送货单？', {
											title : '确认框'
										}, function() {
											doDeliverCallBackPriExt(url,
													popRetVal, favCost);
										});
									} else {
										document.getElementById("search_key")
												.select();
									}
								}

								function doDeliverCallBackPriExt(url, id,
										favCost) {
									if (popRetVal != null) {

										//if(favCost==0){
										ShowConfirm('送货单打印金额？', {
											title : '确认框'
										}, function() {
											doDeliverCallBackCostExt(url, id);
										});
										//}

									} else {
										window.location = url;
									}
								}

								function doDeliverCallBackCostExt(url, id) {
									var printCost = "0";
									if (popRetVal != null) {
										printCost = "1";
									}
									var url = url + "&print_id=" + id
											+ "&print_cost=" + printCost;
									window.location = url;
								}

								function getProgramLocation() {
									var searchKey = encodeURIComponent("");
									return "business/BusinessBillListForDeliver.html?search_key="
											+ searchKey
											+ "&type=UN_DELI_COMP&order_by=&ts_id=1";
								}

								function doSearch() {
									var type = document.getElementById("type").value;
									var tsId = document.getElementById("ts_id").value;
									var orderBy = document
											.getElementById("order_by").value;
									var searchKey = encodeURIComponent(document
											.getElementById("search_key").value
											.trim());
									window.location = "business/BusinessBillListForDeliver.html?search_key="
											+ searchKey
											+ "&type="
											+ type
											+ "&ts_id="
											+ tsId
											+ "&order_by="
											+ orderBy + "&need_pop=Y"; //点查询时才需要自动弹窗
								}

								function doGo(pageIndex) {
									window.location = getProgramLocation()
											+ "&current_page=" + pageIndex;
								}

								function doJump(pageIndex) {
									if (window.event.keyCode == 13) {
										doGo(pageIndex);
									}
								}

								function DoubleClick(it) {
									var ob_arr = document
											.getElementsByName("query_checkbox");
									var str = "";
									var favCost = "0";
									if (ob_arr.length >= it
											.getAttribute("index")) {
										str = ob_arr[it.getAttribute("index") - 1].value;
										favCost = ob_arr[it
												.getAttribute("index") - 1]
												.getAttribute("fav_cost");
									}

									if (str == "") {
										return;
									}
									doDeliver(str, favCost - 0);
								}

								function doDownload() {
									window.location = getProgramLocation()
											+ "&content_type=EXCEL";
								}

								function doCancel() {
									window.close();
								}

								function doInit() {
									//Window_Onload();
									document.getElementById("search_key")
											.select();
									//				if(window.screen.availWidth > 1024) {
									//					var w = window.screen.availWidth * 0.98;
									//					window.resizeTo(w, 600);
									//					document.getElementById("mainDiv").style.width = (w - 60) + "px";
									//					//居中
									//					var resizeWinTop = (window.screen.availHeight - 600) / 2;
									//					var resizeWinLeft = (window.screen.availWidth - w) / 2;
									//					window.moveTo(resizeWinLeft, resizeWinTop);
									//				}

								}

								function checkSearchKey() {
									if (window.event.keyCode == 13) {
										doSearch();
									}
								}

								function doPrint(id) {
									top.showWin([ '900px', '600px' ],
											"business/BusinessBillPrint.html?type=SIMPLE&id="
													+ id);
								}

								function doSms(estIdStr, estName, billCode) {
									var url = "sms/SmsSendForm.html?est_id_str="
											+ estIdStr;
									if (estName != "") {
										var content = "尊敬的" + estName + "：您的订单"
												+ billCode + "已完工，请准备收货，谢谢！";
										url = url + "&content="
												+ encodeURIComponent(content);
									}
									top.showWin([ '900px', '500px' ], url);
								}

								function doMutiSms() {
									var ob_arr = document
											.getElementsByName("query_checkbox");
									var str = "";
									for (i = 0; i < ob_arr.length; i++) {
										if ((ob_arr[i].checked == true)) {
											if (str != "") {
												str = str + ";";
											}
											str = str
													+ ob_arr[i]
															.getAttribute("client_id");
										}
									}
									if (str != "") {
										doSms(str, "", "");
									} else {
										ShowAlert('请选择要发短信的客户', {
											titlt : '提示框'
										});
									}
								}

								function doMutiSend() {
									var ob_arr = document
											.getElementsByName("query_checkbox");
									var str = "";
									for (i = 0; i < ob_arr.length; i++) {
										if ((ob_arr[i].checked == true)) {
											if (str != "") {
												str = str + ";";
											}
											str = str + ob_arr[i].value;
										}
									}
									if (str != "") {
										ShowConfirm('确定将选择的业务单直接设置为已送完货状态吗？', {
											title : '确认框'
										}, function() {
											popRetVal = 'Y';
											doMutiSendCallBack(str);
											layer.closeAll();
										});
									} else {
										ShowAlert('请选择要送货的业务单', {
											titlt : '提示框'
										});
									}
								}

								function doMutiSendCallBack(str) {
									if (popRetVal != null) {
										document.getElementById("LoadProcess").style.top = getTopPos(document
												.getElementById("ts_id"))
												+ 50 + "px";
										document.getElementById("LoadProcess").style.left = getleftPos(document
												.getElementById("ts_id"))
												+ 100 + "px";
										$("#LoadProcess").show();
										$
												.post(
														"business/DeliverBillBatchNew.html",
														{
															bus_id_str : str
														},
														function(data, status) {
															doMutiSendCallBackExt(
																	data,
																	status);
														});
									}
								}

								function doMutiSendCallBackExt(data, status) {
									if (status == "success") {
										var obj = $.parseJSON(data);
										if (obj.status == "NO_LOGIN") {
											window.location = "/Login.html";
										} else if (obj.status == "ERROR") {
											$("#LoadProcess").hide();
											ShowAlert(obj.errMsg, {
												title : '提示框'
											});
										} else {
											$("#LoadProcess").hide();
											ShowConfirm('现在打印送货单？', {
												title : '确认框'
											}, function() {
												popRetVal = 'Y';
												doMutiSendPrint(obj.idStr);
												layer.closeAll();
											});
										}
									} else {
										$("#LoadProcess").hide();
										ShowAlert('系统错误：' + status, {
											title : '提示框'
										});
									}
								}

								function doMutiSendPrint(idStr) {
									if (popRetVal != null) {

										//if(favCost==0){
										ShowConfirm('送货单打印金额？', {
											title : '确认框'
										}, function() {
											popRetVal = 'Y';
											doMutiSendPrintExt(idStr);
											layer.closeAll();
										});
										//}

									} else {
										refreshWin();
									}
								}

								function doMutiSendPrintExt(idStr) {
									var printCost = "0";
									if (popRetVal != null) {
										printCost = "1";
									}
									var url = getProgramLocation()
											+ "&current_page=1";
									url = url + "&print_id=" + idStr
											+ "&print_cost=" + printCost
											+ "&print_type=MULTI";
									window.location = url;
								}

								function refreshWin() {
									window.location = getProgramLocation()
											+ "&current_page=1"; //有print_id,print_cost,need_pop这些参数,所以这里不能直接refresh
								}

								function doPrintCallBack() {
									var printId = "";
									var printCost = "";
									var printType = "";
									if (printId != null && printId != "") {
										if (printType != null
												&& printType == "MULTI") {
											var type = "IDS_NO_COST";
											if (printCost == "1") {
												type = "IDS_COST";
											}
											top.showWin([ '900px', '600px' ],
													"business/DeliverBillPrintMulti.html?ids="
															+ printId
															+ "&type=" + type);
										} else {
											top.showWin([ '900px', '600px' ],
													"business/DeliverBillPrint.html?id="
															+ printId
															+ "&print_cost="
															+ printCost);
										}
									} else {

									}
								}

								function showList(type) {
									window.location = "business/BusinessBillListForDeliver.html?type="
											+ type;
								}

								function doLabel(id) {
									var url = "business/BusinessBillInfoForLabel.html?id="
											+ id + "&wc_id=0";
									top.showWin([ '900px', '600px' ], url);
								}

								function showRelBill(code) {
									top.showWin([ '1024px', '600px' ],
											"business/BusinessRelBillList.html?code="
													+ encodeURIComponent(code));
								}
							</script>
</head>

<body oncontextmenu="return false" onload="doInit();doPrintCallBack();"
	class="sheet">
	<div class="sheet-main" id="mainDiv">
		<div class="sheet-top">
			<div class="content">
				<h2>送货</h2>
				<div class="pull-right">
					<div class="layui-form" style="display: inline-block;">
						<div class="layui-inline">
							<select name="ts_id" id="ts_id">
								<option value="0">==请选择账套==</option>

								<option value="1" selected="">新异</option>

								<option value="2">网络公司</option>

							</select>
						</div>
						<div class="layui-inline">
							<select name="type" id="type">
								<option value="">==全部==</option>
								<option value="UN_DELIVER">全部未送货(不包括已部分送货的单)</option>
								<option value="UN_DELI_COMP" selected="">完工未送货</option>
								<option value="UN_DELI_TIMEOUT">超期未送货</option>
								<option value="UN_DELI_TIMEOUT_UN_COMP">未完工且超期未送货</option>
								<option value="UN_DELI_TIMEOUT_COMP">已完工但超期未送货</option>
								<option value="PART_DELI">部分送货</option>
							</select>
						</div>
						<div class="layui-inline">
							<select name="order_by" id="order_by">
								<option value="">==排序==</option>
								<option value="EXAM_DATE">按审核日期</option>
								<option value="CREA_DATE">按开单日期</option>
								<option value="ORDE_DATE">按订货日期</option>
								<option value="DELI_DATE">按交货日期</option>
							</select>
						</div>


						<div class="layui-inline">
							<div class="layui-input-inline">
								<input type="text" class="layui-input" id="search_key"
									name="search_key" onkeyup="checkSearchKey();"
									style="width: 80px" value=""
									title="以客户名称、客户拼音字头、摘要、业务单号、电话进行模糊查询">
							</div>
						</div>
						<a type="button " class="layui-btn " onclick="doSearch();"
							title="以客户名称、客户拼音字头、摘要、业务单号、电话进行模糊查询">查 询</a> <a type="button "
							class="layui-btn " onclick="doMutiSend();"
							title="直接将已选中的业务单设置为已送货，如果是同家客户，可以同时合并成一张送货单打印">送 货</a> <a
							type="button " class="layui-btn " id="sSmsButton"
							name="sSmsButton" onclick="doMutiSms();"
							title="直接将已选中的业务单设置为已送货，如果是同家客户，可以同时合并成一张送货单打印">短 信</a>
					</div>
				</div>
				<!--<p>根据业务单的交货日期、完工状态、送货状态进行分类查询，生成送货单。<span style="color:blue">蓝色</span>表示业务单已开过送货单</p>-->
			</div>
		</div>
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
				<div class="cue-info">
					<p style="line-height: 1.5;">
						根据业务单的交货日期、完工状态、送货状态进行分类查询，生成送货单。<span style="color: blue">蓝色</span>表示业务单已开过送货单
					</p>
					选择： <a href="javascript:showList(&#39;&#39;);">全部</a> <a
						href="javascript:showList(&#39;UN_DELI_COMP&#39;);">完工未送货</a> <a
						href="javascript:showList(&#39;UN_DELI_TIMEOUT_COMP&#39;);">已完工且超期未送货</a>
					<a href="javascript:showList(&#39;UN_DELI_TIMEOUT&#39;);">超期未送货</a>
					<a href="javascript:showList(&#39;UN_DELI_TIMEOUT_UN_COMP&#39;);">未完工且超期未送货</a>
					<a href="javascript:showList(&#39;PART_DELI&#39;);">部分送货</a>
				</div>
				<div class="table-list">
					<table width="100%">
						<tbody>
							<tr>
								<th width="20"><input type="checkbox"
									onclick="javascript:checkall(this);"></th>
								<th width="10%">单号</th>
								<th width="8%">订货日期</th>
								<th width="10%">订货单位</th>
								<th width="10%">电话</th>
								<th width="10%">摘要</th>
								<th width="8%">交货日期</th>
								<th width="8%">欠款</th>
								<th width="10%">提货要求</th>
								<th width="10%">安装要求</th>
								<th width="6%">状态</th>
								<th width="10%">操作</th>
							</tr>
<s:iterator value="businessBills" var="businessBill">


							<tr class="query_list_data_tr2" index="2"
								style="color: black; cursor: pointer;" defaultfontcolor="black"
								ondblclick="javascript:DoubleClick(this)"
								onclick="javascript:ClickCheck(this,true)"
								onmouseout="javascript:mouseout(this)"
								onmouseover="javascript:mouseover(this)">
								<td><input type="checkbox"
									onclick="javascript:ClickCheck(this,true);"
									name="query_checkbox" value="3178" fav_cost="0.00"
									client_id="13"></td>
								<td>${billCode }</td>
								<td><s:date format="yyyy-MM-dd" name="deliverDate"></s:date></td>
								<td>${mark }</td>
								<td>${phone }</td>
								<td>${content }</td>
								<td><s:date format="yyyy-MM-dd" name="orderDate"></s:date></td>
								<td>${imprest }</td>
								<td>${ladingRequire }</td>
								<td>${setupRequire }</td>
								<td>${sourType }</td>
								<td><a href="javascript:doDeliver(&#39;3178&#39;,0.00);">送货</a>
									<a href="javascript:showRelBill(&#39;E(1)2017060148&#39;);">查看</a>
									<a
									href="javascript:doSms(&#39;13&#39;,&#39;郑州中力博奇广告&#39;,&#39;E(1)2017060148&#39;);">发短信</a>
									<br> <a href="javascript:doLabel(&#39;3178&#39;);">打印标签</a>
										<a href="javascript:doPrint(&#39;3178&#39;);">打印制作单</a></td>
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
								<input class="layui-input"
									style="width: 30px; text-align: center;" placeholder=""
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

	<div id="LoadProcess"
		style="position: absolute; left: 50%; top: 50%; width: 200px; height: 100px; margin-top: -50px; margin-left: -100px; z-index: 1; border: solid #000 5px; background-color: White; display: none">
		<table border="0" align="center" style="height: 100%;">
			<tbody>
				<tr>
					<td style="valign: middle"><img src="images/loading.gif">
							请稍候... </td>
				</tr>
			</tbody>
		</table>
	</div>
	<script src="layui/layui.all.js"></script>
</body>

</html>