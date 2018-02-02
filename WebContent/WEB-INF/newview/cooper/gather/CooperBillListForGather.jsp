<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0060)http://115.28.87.22:8888/cooper/CooperBillListForGather.html -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>收货 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/Query.css" rel="stylesheet" type="text/css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doGather(id, favCost) {
				/**var url = "cooper/GatherBillNew.html?cooper_bill_id=" + id;*/
				var url ="cooperGather_toGatherBillNew";
				ShowIframe(['1024px', '500px'], url, '', function() {
					doGatherCallBack(favCost);
				}, '收货');
			}

			function doGatherCallBack(favCost) {
				if(popRetVal != null) {
					var url = getProgramLocation() + "&current_page=0";
					ShowConfirm('现在打印收货单？', {
						title: '确认框'
					}, function(index) {
						popRetVal = 'Y';
						layer.close(index);
						doGatherCallBackPriExt(url, popRetVal, favCost);
					});
				}
			}

			function doGatherCallBackPriExt(url, id, favCost) {
				if(popRetVal != null) {
					if(favCost == 0) {
						ShowConfirm('收货单打印金额？', {
							title: '确认框'
						}, function(index) {
							popRetVal = 'Y';
							layer.close(index);
							doGatherCallBackCostExt(url, id);
						});
					} else {
						window.location = url + "&print_id=" + id;
					}
				} else {
					window.location = url;
				}
			}

			function doGatherCallBackCostExt(url, id) {
				var printCost = "0";
				if(popRetVal != null) {
					printCost = "1";
				}
				var url = url + "&print_id=" + id + "&print_cost=" + printCost;
				window.location = url;
			}

			function getProgramLocation() {
				var searchKey = encodeURIComponent("");
				return "cooper/CooperBillListForGather.html?search_key=" + searchKey + "&type=&ts_id=2";
			}

			function doSearch() {
				var type = document.getElementById("type").value;
				var tsId = document.getElementById("ts_id").value;
				var searchKey = encodeURIComponent(document.getElementById("search_key").value.trim());
				window.location = "cooper/CooperBillListForGather.html?search_key=" + searchKey + "&type=" + type + "&ts_id=" + tsId;
			}

			function doGo(pageIndex) {
				window.location = getProgramLocation() + "&current_page=" + pageIndex;
			}

			function doJump(pageIndex) {
				if(window.event.keyCode == 13) {
					doGo(pageIndex);
				}
			}

			function DoubleClick(it) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var str = "";
				var favCost = "0";
				if(ob_arr.length >= it.getAttribute("index")) {
					str = ob_arr[it.getAttribute("index") - 1].value;
					favCost = ob_arr[it.getAttribute("index") - 1].getAttribute("fav_cost");
				}
				if(str == "") {
					return;
				}
				doGather(str, favCost - 0);
			}

			function doCancel() {
				window.close();
			}

			function doInit() {
				//Window_Onload();
				document.getElementById("search_key").focus();
			}

			function checkSearchKey() {
				if(window.event.keyCode == 13) {
					doSearch();
				}
			}

			function doPrint(id) {
				showWin(['900px', '600px'], "cooper/CooperBillPrint.html?id=" + id);
			}

			function doSms(estName, estId, billContent) {
				var url = "sms/SmsSendForm.html?est_id_str=" + estId;
				if(estName != "") {
					if(billContent != null && billContent != "") {
						billContent = "(" + billContent + ")";
					}
					var content = estName + "：订单" + billContent + "什么时候可以完工？";
					url = url + "&content=" + encodeURIComponent(content);
				}
				showWin(['900px', '500px'], url);
			}

			function doMutiSms() {
				var ob_arr = document.getElementsByName("query_checkbox");
				var str = "";
				for(i = 0; i < ob_arr.length; i++) {
					if((ob_arr[i].checked == true)) {
						if(str != "") {
							str = str + ";";
						}
						str = str + ob_arr[i].getAttribute("cooperator_id");
					}
				}
				if(str != "") {
					doSms("", str, "");
				} else {
					ShowAlert('请选择要发短信的外协商', {
						title: '提示框'
					});
				}
			}

			function doMutiGather() {
				var ob_arr = document.getElementsByName("query_checkbox");
				var str = "";
				for(i = 0; i < ob_arr.length; i++) {
					if((ob_arr[i].checked == true)) {
						if(str != "") {
							str = str + ";";
						}
						str = str + ob_arr[i].value;
					}
				}
				if(str != "") {
					ShowConfirm('确定将选择的外协单直接设置为已收完货状态吗？', {
						title: '确认框'
					}, function(index) {
						popRetVal = 'Y';
						layer.close(index);
						doMutiGatherCallBack(str);
					});
				} else {
					ShowAlert('请选择要收货的外协单', {
						title: '提示框'
					});
				}
			}

			function doMutiGatherCallBack(str) {
				if(popRetVal != null) {
					var url = "cooper/GatherBillBatchNew.html?coo_id_str=" + str;
					ShowIframe(['200px', '200px'], url, '', function() {
						refreshWin();
					}, '收货');
				}
			}

			function refreshWin() {
				if(popRetVal != null) {
					window.location = getProgramLocation() + "&current_page=0";
				}
			}

			function showSmsSubscribe() {

				showWin(['520px', '640px'], 'sms/SmsSubscribe.html');

			}

			function doPrintCallBack() {
				var printId = "";
				var printCost = "";
				if(printId != null && printId != "") {
					showWin(['900px', '600px'], "cooper/GatherBillPrint.html?id=" + printId + "&print_cost=" + printCost);
				}
			}

			function showRelBill(id, code) {
				/**showWin(['900px', '600px'], "cooper/CooperRelBillList.html?id=" + id + "&code=" + code);*/
				showWin(['900px', '600px'], "cooperGather_toCooperRelBill?id=" + id + "&code=" + code);
				
			}
		</script>
	</head>

	<body oncontextmenu="return false" onload="doInit();doPrintCallBack();" class="sheet">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>收货</h2>
					<div class="pull-right">
						<div class="layui-form" style=" display: inline-block;">
							<div class="layui-inline">
								<select name="ts_id" id="ts_id">
									<option value="0">==请选择账套==</option>

									<option value="1">新异</option>

									<option value="2" selected="">网络公司</option>

								</select>
							</div>
							<div class="layui-inline">
								<select name="type" id="type">
									<option value="">==请选择==</option>
									<option value="UN_GATHER">全部未收货</option>
									<option value="UN_GATH_TIMEOUT">超期未收货</option>
									<option value="PART_GATH">部分收货</option>
								</select>
							</div>

							<div class="layui-inline">
								<div class="layui-input-inline">
									<input type="text" class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();" style="width:80px" value="" title="以外协单位名称、外协单位拼音字头、摘要、外协单号进行模糊查询">
								</div>
							</div>
							<a type="button " class="layui-btn " onclick="doSearch();" title="以外协单位名称、外协单位拼音字头、摘要、外协单号进行模糊查询">查 询</a>
							<a type="button " class="layui-btn " onclick="doMutiGather();" title="直接将已选中的外协单设置为已收完货状态">收 货</a>
							<a type="button " class="layui-btn " onclick="doMutiSms();" id="sSmsButton" name="sSmsButton">短 信</a>
						</div>
					</div>
				</div>
			</div>
			<div class="sheet-list">
				<div class="search-business">

					<table width="98%" border="0" cellpadding="0" cellspacing="0">
						<tbody>
							<tr id="errorMsgTr" style="display:none">
								<td>
									<div class="msg-error" id="errorMsgTd">

									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<p style="line-height: 25px;">根据外协单的交货日期、收货状态进行分类查询，生成收货单。<span style="color:blue">蓝色</span>表示外协单已开过收货单</p>
					<div class="table-list">
						<table width="100%">
							<tbody>
								<tr>
									<th width="20"><input type="checkbox" onclick="javascript:checkall(this);"></th>
									<th width="13%">单号</th>
									<th width="9%">外协日期</th>
									<th width="19%">外协单位</th>
									<th width="15%">摘要</th>
									<th width="9%">交货日期</th>
									<th width="15%">交货要求</th>
									<th width="8%">业务员</th>
									<th width="12%">操作</th>
								</tr>
								<s:iterator value="cooperBills" status="cooperBills">
								<tr class="query_list_data_tr1" index="1" style="cursor:pointer;color:black" defaultfontcolor="black" ondblclick="javascript:DoubleClick(this)" onclick="javascript:ClickCheck(this,true)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
									<td><input type="checkbox" onclick="javascript:ClickCheck(this,true);" name="query_checkbox" value="75" fav_cost="0.00" cooperator_id="706"></td>
									<td>${billCode}</td>
									<td>${cooperDate}</td>
									<td>${address}</td>
									<td>${content}</td>
									<td>${gatherDate}</td>
									<td></td>
									<td>${managerName}</td>
									<td>
										<a href="javascript:showRelBill('${id}','${billCode}');">查看</a>
										<a href="#" onclick="doGather('${id}',0.00);">收货</a>
										<a href="javascript:doSms('郑州南方标牌','706','东厂   门市自提');">短信</a>
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
								页&nbsp;&nbsp;共1页
								<a style="cursor:pointer" onclick=""><img src="images/but003.gif"></a>
								<a style="cursor:pointer" onclick=""><img src="images/but004.gif"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="layui/layui.all.js"></script>
	</body>

</html>