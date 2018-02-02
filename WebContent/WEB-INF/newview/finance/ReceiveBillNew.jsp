<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>收款单 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link href="layui/css/layui.css" rel="stylesheet" />
		<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/BillEdit.css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script src="js/popup.js"></script>
		<script src="js/jquery-3.0.0.min.js"></script>
		<script src="js/dhtmlgoodies_calendar.js"></script>
		<script language="javascript">
			function doSavePrinLitt() {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				document.getElementById("continue_flag").value = "";
				document.getElementById("print_detail").value = "L";
				if(window.opener) {
					document.getElementById("print_flag").value = "SHOW";
				} else {
					document.getElementById("print_flag").value = "CALLBACK";
				}

				ShowConfirm('是否同时审核？', {title:'确认框'}, function(){
					popRetVal = 'Y';
					doSavePrinLittExt();
				});

			}

			function doSavePrinLittExt() {
				if(popRetVal != null) {
					document.getElementById("examine").value = "1";
				} else {
					document.getElementById("examine").value = "0";
				}
				frm.submit();
			}

			function doSave(contFlag) {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				document.getElementById("continue_flag").value = contFlag;

				ShowConfirm('是否同时审核？', {title:'确认框'}, function(){
					popRetVal = 'Y';
					doSaveExt(contFlag);
				});

			}

			function doSaveExt(contFlag) {
				if(popRetVal != null) {
					document.getElementById("examine").value = "1";
				} else {
					document.getElementById("examine").value = "0";
				}

				if(contFlag != 'NEW') {
					ShowConfirm('是否现在打印？', {title:'确认框'}, function(){
						popRetVal = 'Y';
						doSavePrint();
					});
				} else {
					frm.submit();
				}

			}

			function doSavePrint() {
				if(popRetVal != null) {
					ShowConfirm('是否同时打印收款明细？', {title:'确认框'}, function(){
						doSavePrintExt();
					});
				} else {
					frm.submit();
				}
			}

			function doSavePrintExt() {
				if(popRetVal != null) {
					document.getElementById("print_detail").value = "Y";
				} else {
					document.getElementById("print_detail").value = "N";
				}
				var printFlag;
				if(window.opener) {
					printFlag = "SHOW";
				} else {
					printFlag = "CALLBACK";
				}
				document.getElementById("print_flag").value = printFlag;
				frm.submit();
			}

			function doCancel() {
				if(window.opener) {
					window.close();
				} else {
					var retVal = "";
					if(retVal != "") {
						parent.popRetVal = retVal;
					}
					ClosePop();
				}
			}

			function printBusi(id) {
				var url = "business/BusinessBillPrint.html?id=" + id;
				top.showWin(['900px','600px'], url);
			}

			function selectClient() {
				var url = "base/EstablishmentListForSelect.html?type=CLIENT&order_type=BUS_TIME&ts_id=2";
				ShowIframe(['900px','500px'], url, '', function(){
					selectClientCallBack();
				}, '选择付款单位');
			}

			function selectClientCallBack() {
				alert(popRetVal);
				if(popRetVal != null) {
					var url = "finance/BusinessBillByDateForReceive.html?bill_type=business";
					var estId = popRetVal[0];
					var estName = popRetVal[1];
					var mngId = popRetVal[2];
					var mngName = popRetVal[3];

					ShowIframeNoScroll(['580px','300px'], url, '', function(){
						selectClientCallBackBill(estId, estName, mngId, mngName);
					}, '选择日期起止');
					
				}
			}

			function selectClientCallBackBill(estId, estName, mngId, mngName) {
				if(popRetVal != null) {
					$("#LoadProcess").css("top", getTopPos(document.getElementById("clientName")) + 50 + "px");
					$("#LoadProcess").css("left", getleftPos(document.getElementById("clientName")) + 100 + "px");
					$("#LoadProcess").show();

					document.getElementById("receiveBill.clientId").value = estId; //名字带点jquery不认
					document.getElementById("clientName").value = estName;
					if(mngId != "0") {
						document.getElementById("receiveBill.managerId").value = mngId;
						document.getElementById("receiveBill.managerName").value = mngName;
					}

					var tsId = "2";
					$.post("finance/GetBusiForRece.html", {
						est_id: estId,
						ts_id: tsId,
						start_date: popRetVal[0],
						end_date: popRetVal[1]
					}, function(data, status) {
						parseItemData(data, status);
					});

				}
			}

			function parseItemData(data, status) {
				if(status == "success") {
					var obj = $.parseJSON(data);
					if(obj.status == "ERROR") {
						$("#LoadProcess").hide();
						ShowAlert(obj.errMsg, {title:'提示框'});
					} else {
						var tbl = $("#itemRowTbl");
						var itemNum = $("#item_num").val() - 0;
						var i;
						for(var i = 0; i < itemNum; i++) {
							$("#itemTr" + i).hide();
							$("#status_" + i).val("DELETE");
						}

						$("#item_num").val(obj.items.length + itemNum);

						$.each(obj.items, function(index, item) {
							var rowInd = index + itemNum;
							var tr = $("<tr></tr>");
							tr.prop({
								"id": "itemTr" + rowInd,
								"class": "ListTr"
							});

							var td;
							var input;

							td = $("<td></td>");
							input = $("<input type='checkbox' name='query_checkbox' checked>");
							input.val(rowInd);
							input.click(function() {
								doItemClick(this);
							});
							td.append(input);
							tr.append(td);

							td = $("<td></td>");
							input = $("<input type='text' name='business_bill_code_" + rowInd + "' id='business_bill_code_" + rowInd + "' class='TextBox readonly' readonly='readonly' />");
							input.prop("index", rowInd); //自定义的属性要显式设置,否则后面用prop取不出来(写在上面的字符串的话,只能用attr才取得到)
							input.css("width", "120px");
							input.val(item.code);
							td.append(input);

							input = $("<img src='/images/ico-bar.gif' />");
							input.prop("index", rowInd);
							input.css("cursor", "pointer");
							input.click(function() {
								printBusi($("#business_bill_id_" + $(this).prop("index")).val());
							});
							td.append(input);

							input = $("<input type='hidden' name='business_bill_id_" + rowInd + "' id='business_bill_id_" + rowInd + "' />");
							input.val(item.id);
							td.append(input);

							input = $("<input type='hidden' name='id_" + rowInd + "' id='id_" + rowInd + "' />");
							input.val("0");
							td.append(input);

							input = $("<input type='hidden' name='status_" + rowInd + "' id='status_" + rowInd + "' />");
							input.val("NEW");
							td.append(input);
							tr.append(td);

							td = $("<td></td>");
							input = $("<input type='text' name='order_date_" + rowInd + "' id='order_date_" + rowInd + "' class='TextBox readonly' readonly='readonly' />");
							input.prop("index", rowInd);
							input.css("width", "70px");
							input.val(item.date);
							td.append(input);
							tr.append(td);

							td = $("<td></td>");
							input = $("<input type='text' name='linkman_" + rowInd + "' id='linkman_" + rowInd + "' class='TextBox readonly' readonly='readonly' />");
							input.prop("index", rowInd);
							input.css("width", "70px");
							input.val(item.linkman);
							td.append(input);
							tr.append(td);

							td = $("<td></td>");
							input = $("<input type='text' name='content_" + rowInd + "' id='content_" + rowInd + "' class='TextBox readonly' readonly='readonly' />");
							input.prop("index", rowInd);
							input.css("width", "200px");
							input.val(item.cont);
							td.append(input);
							tr.append(td);

							td = $("<td></td>");
							input = $("<input type='text' name='total_cost_" + rowInd + "' id='total_cost_" + rowInd + "' class='TextBox readonly' readonly='readonly' />");
							input.prop("index", rowInd);
							input.css("width", "80px");
							input.val(item.totaCost);
							td.append(input);
							tr.append(td);

							td = $("<td></td>");
							input = $("<input type='text' name='remain_cost_" + rowInd + "' id='remain_cost_" + rowInd + "' class='TextBox readonly' readonly='readonly' />");
							input.prop("index", rowInd);
							input.css("width", "80px");
							input.val(item.remaCost);
							td.append(input);
							tr.append(td);

							td = $("<td></td>");
							input = $("<input type='text' name='this_cost_" + rowInd + "' id='this_cost_" + rowInd + "' class='TextBox' maxlength='10' />");
							input.prop("index", rowInd);
							input.css("width", "80px");
							input.val(item.remaCost);
							td.append(input);
							tr.append(td);

							tbl.append(tr);
						});

						document.getElementById("all_item_cb").checked = true;
						doCount();
						resizePopwin();
						setFocus("costStr");
						$("#LoadProcess").hide();
					}
				} else {
					$("#LoadProcess").hide();
					ShowAlert('系统错误：' + status, {title:'提示框'});
				}
			}

			function doCount() {
				var itemNum = Number(document.getElementById("item_num").value);
				var costTotal = 0;
				var itemCost;
				for(var i = 0; i < itemNum; i++) {
					if(document.getElementById("status_" + i).value != "DELETE") {
						itemCost = document.getElementById("this_cost_" + i).value;
						if(!isNaN(itemCost)) {
							costTotal = addMul(costTotal, itemCost);
						}
					}
				}
				document.getElementById("costStr").value = costTotal;
			}

			function checkItemChange(index) {
				if(document.getElementById("id_" + index).value == "" || document.getElementById("id_" + index).value == "0") {
					document.getElementById("status_" + index).value = "NEW";
				} else {
					document.getElementById("status_" + index).value = "EDIT";
				}
			}

			function doAllItem(obj) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var i;
				for(i = 0; i < ob_arr.length; i++) {
					var index = ob_arr[i].value;
					if(document.getElementById("status_" + index).value != "DELETE") {
						if(obj.checked) {
							ob_arr[i].checked = true;
							document.getElementById("this_cost_" + index).value = document.getElementById("remain_cost_" + index).value;
						} else {
							ob_arr[i].checked = false;
							document.getElementById("this_cost_" + index).value = "0";
						}
						checkItemChange(index);
					}
				}
			}

			function doItemClick(obj) {
				var index = obj.value;
				if(obj.checked) {
					document.getElementById("this_cost_" + index).value = document.getElementById("remain_cost_" + index).value;
				} else {
					document.getElementById("this_cost_" + index).value = "0";
				}
				checkItemChange(index);
			}

			function selectStaffer() {
				var url = "base/StafferMainForSelect.html";
				ShowIframe(['910px','500px'], url, '', function(){
					selectStafferCallBack();
				}, '选择员工');
			}

			function selectStafferCallBack() {
				if(popRetVal != null) {
					var arr = popRetVal.split(";");
					document.getElementById("receiveBill.managerId").value = arr[0];
					document.getElementById("receiveBill.managerName").value = arr[1];
					var depObj = document.getElementById("receiveBill.departmentId");
					for(var i = 0; i < depObj.options.length; i++) {
						if(arr[2] == depObj.options[i].value) {
							depObj.options[i].selected = true;
							break;
						}
					}
				}
			}

			function autoAssign() {
				var cost = document.getElementById("costStr").value;
				var itemNum = Number(document.getElementById("item_num").value);
				var i;
				for(i = 0; i < itemNum; i++) {
					var status = document.getElementById("status_" + i).value;
					if(status != "DELETE") {
						var remainCost = document.getElementById("remain_cost_" + i).value;
						if(Number(cost) <= Number(remainCost)) {
							document.getElementById("this_cost_" + i).value = cost;
							cost = 0;
						} else {
							cost = abateMul(cost, remainCost);
							document.getElementById("this_cost_" + i).value = remainCost;
						}
						checkItemChange(i);
					}
				}
			}

			function doPrint(id) {
				ShowConfirm('是否同时打印收款明细？', {title:'确认框'}, function(){
					showPrintCallBack(id);
				});
			}

			function showPrintCallBack(id) {
				var printDetail = "N";
				if(popRetVal != null) {
					printDetail = "Y";
				}
				var url = "finance/ReceiveBillPrint.html?id=" + id + "&print_detail=" + printDetail;
				top.showWin(['900px','600px'], url);
			}

			function doPrintLitt(id) {
				var url = "finance/ReceiveBillPrint.html?id=" + id + "&print_detail=L";
				top.showWin(['900px','600px'], url);
			}

			function doInit() {
				showFormErrorMsg();

				var allCheck = true;
				var ob_arr = document.getElementsByName("query_checkbox");
				var i;
				for(i = 0; i < ob_arr.length; i++) {
					var index = ob_arr[i].value;
					if(document.getElementById("status_" + index).value != "DELETE") {
						var thisCost = document.getElementById("this_cost_" + index).value;
						var remaCost = document.getElementById("remain_cost_" + index).value;
						if(!isNaN(thisCost)) {
							if(thisCost - 0 == remaCost - 0) {
								ob_arr[i].checked = true;
							} else {
								ob_arr[i].checked = false;
								allCheck = false;
							}
						}
					}
				}
				document.getElementById("all_item_cb").checked = allCheck;

				resizePopwin();
				document.getElementById("costStr").focus();
			}

			function doWinUnload() {
				var retVal = '';
				if(retVal != '' && !window.opener) {
					parent.popRetVal = retVal;
				}
			}

			function changeClosBusi() {
				alert('5');
				if(document.getElementById("clos_busi_cb").checked) {
					document.getElementById("receiveBill.closBusi").value = "Y";
				} else {
					document.getElementById("receiveBill.closBusi").value = "N";
				}
			}
		</script>
	</head>

	<body onload="doInit();" onunload="doWinUnload();">
		<div>
			<form class="layui-form" name="frm" method="post" enctype="multipart/form-data">
				<div class="Container">
					<div class="Contnet Paper">

						<script language="javascript">
							var formErrorIndex = 0;
							var formErrorMsg = "";
							var formErrorObjId = "";

							function setFormErrorMsg(msg, index, objId) {
								if(formErrorIndex == 0 || formErrorIndex > index) {
									if(msg != null && msg != "") {
										formErrorIndex = index;
										formErrorMsg = msg;
										formErrorObjId = objId;
									}
								}
							}

							function showFormErrorMsg() {
								if(formErrorIndex != 0) {
									document.getElementById("errorMsgTr").style.display = "";
									document.getElementById("errorMsgDiv").innerHTML = formErrorMsg;
									if(formErrorObjId != null && formErrorObjId != "") {
										document.getElementById(formErrorObjId).focus();
									}
								}
							}

							function goNextInput(objId) {
								var obj = null;
								if(objId != null && objId != '') {
									obj = document.getElementById(objId);
								}
								if(window.event.keyCode == 13) {
									if(obj != null) {
										obj.focus();
									} else if(window.doSave) {
										doSave();
									}
								}
							}
						</script>
						<table width="96%" border="0" cellpadding="0" cellspacing="0" align="center">
							<tbody>
								<tr id="errorMsgTr" style="display:none">
									<td colspan="2">
										<div class="msg-error" id="errorMsgDiv">

										</div>
									</td>
								</tr>
							</tbody>
						</table>

						<!--单 标题-->
						<div class="BillHeading">
							<div class="layui-row">
								<div class="layui-col-sm4">
									<div class="CorpLogo"><img src="images/BIAO  SHI  HUI.png"></div>
								</div>
								<div class="layui-col-sm4">
									<h1>收款单</h1>
								</div>
								<div class="layui-col-sm4 tr" style="">
									<div class="layui-form-item" style="display: inline-block;margin-top: 10px;margin-bottom: 8px;width: 100%;">
										<!--<label class="layui-form-label"><span class="MustInput">*</span>编号：</label>-->
										<div class="layui-input-inline" style="width: 100%;">
											&nbsp;
											<!--<input class="layui-input" readonly placeholder="" type="text" maxlength="30" onkeyup="goNextInput('cooperDateStr');" id="cooperBill.billCode" name="cooperBill.billCode" value="">-->
										</div>
									</div>
									<div class="layui-form-item" style="float: right;">
										<div class="layui-form-mid"><span class="MustInput">*</span>编号：</div>
										<div class="layui-input-inline" style="width: 110px;">
											<input type="text" class="layui-input disabled" disabled="" readonly="readonly" maxlength="30" onkeyup="goNextInput('receiveDateStr');" id="receiveBill.billCode" name="receiveBill.billCode" value="">
										</div>
										<script language="javascript">
											setFormErrorMsg('', 1, 'receiveBill.billCode');
										</script>
									</div>
									<div class="layui-form-item" style="float: right;">
										<div class="layui-form-mid"><span class="MustInput">*</span>收款日期：</div>
										<div class="layui-input-inline" style="width: 110px;">
											<input type="text" class="layui-input" maxlength="15" id="receiveDateStr" name="receiveDateStr" value="">
											<script language="javascript">
												setFormErrorMsg('', 2, 'receiveDateStr');
											</script>
										</div>
									</div>
								</div>
							</div>
						</div>

						<!-- 单 头信息 -->
						<div class="blank12"></div>
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-mid"><span class="MustInput">*</span>付款单位:</div>
									<div class="layui-input-inline" style="width: 140px;">
										<input class="layui-input" readonly="readonly" type="text" id="clientName" name="clientName" value="">
										<input type="hidden" id="receiveBill.clientId" name="receiveBill.clientId" value="0">
										<script language="javascript">
											setFormErrorMsg('', 3);
										</script>
										<input type="hidden" id="receiveBill.clientId" name="receiveBill.clientId" value="0">
									</div>
									<div class="layui-form-mid">
										<a href="javascript:selectClient();">选择</a>
									</div>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid"><span class="MustInput">*</span>收款账户:</div>
									<div class="layui-input-inline">
										<select class="ddlInfo3_long" id="receiveBill.bankAccountId" name="receiveBill.bankAccountId">

										</select>
										<script language="javascript">
											setFormErrorMsg('', 6);
										</script>
									</div>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: right;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid"><span class="MustInput">*</span>收款金额:</div>
									<div class="layui-input-inline">
										<input type="text" class="layui-input" maxlength="10" id="costStr" name="costStr" value="" onchange="autoAssign();">
										<script language="javascript">
											setFormErrorMsg('', 5, 'costStr');
										</script>
									</div>
								</div>
							</div>
						</div>
						<hr style="margin-top: 0;" />

						<!-- 明细 -->
						<input type="hidden" id="item_num" name="item_num" value="0">
						<table id="BillDetails" class="BillDetails" width="100%" cellspacing="0" cellpadding="0">
							<tbody id="itemRowTbl">
								<tr>
									<th width="34"><input lay-ignore type="checkbox" id="all_item_cb" onclick="javascript:doAllItem(this);"></th>
									<th width="18%">业务单号</th>
									<th width="10%">订货日期</th>
									<th width="10%">联系人</th>
									<th width="24%">摘要</th>
									<th width="12%">金额（元）</th>
									<th width="12%">余额（元）</th>
									<th width="12%">本次收款</th>
								</tr>

							</tbody>
						</table>
						
						<div class="table-bot" style="height:20px;">
							<span style="float:right;PADDING-RIGHT:10px;color:#aaa;">
					<input type="button" style="font-size:12px;" value="汇总到收款金额" onclick="doCount();">
				</span> &nbsp;
						</div>

						<hr />

						<div class="layui-row">
							<div class="layui-col-sm6">
								<div class="layui-form-item">
									<div class="layui-form-label"><span class="MustInput">*</span>经办人:</div>
									<div class="layui-input-inline">
										<input type="text" class="layui-input" readonly="true" id="receiveBill.managerName" name="receiveBill.managerName" value="" title="选择经办人，用于计算该经办人的收欠费产值">
										<input type="hidden" id="receiveBill.managerId" name="receiveBill.managerId" value="51">
										<script language="javascript">
											setFormErrorMsg('', 7);
										</script>
									</div>
									<div class="layui-form-mid">
										<a href="javascript:selectStaffer();"  title="选择经办人，用于计算该经办人的收欠费产值 ">选择</a>
									</div>
								</div>
							</div>
							<div class="layui-col-sm6" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid"><span class="MustInput">*</span>部门:</div>
									<div class="layui-input-inline">
										<select id="receiveBill.departmentId" name="receiveBill.departmentId" class="ddlInfo3_long" style="background:#f6f6f6;">
											<option value="0">==请选择==</option>

											<option value="1">易凯管理员</option>
											<option value="50">&nbsp;|--1</option>
											<option value="13">总经办</option>
											<option value="22">&nbsp;|--财务</option>
											<option value="14">新异店</option>
											<option value="15">&nbsp;|--客服</option>
											<option value="23">&nbsp;|--设计</option>
											<option value="24">&nbsp;|--业务</option>
											<option value="16">业务来源</option>
											<option value="17">标识加工车间</option>
											<option value="21">合作伙伴</option>
											<option value="32" selected="">标识汇运营部</option>
											<option value="33">财务部</option>
											<option value="35">新异标识标牌有限公司</option>
											<option value="36">&nbsp;|--物流部</option>
											<option value="41">&nbsp;|--销售部</option>
											<option value="42">&nbsp;|--业务部</option>
											<option value="43">&nbsp;|--设计部</option>
											<option value="44">&nbsp;|--安装部</option>
											<option value="45">&nbsp;|--外协(东厂)</option>
											<option value="46">&nbsp;|--财务部</option>
											<option value="48">&nbsp;|--门市部</option>
											<option value="49">&nbsp;|--加工车间</option>
											<option value="37">&nbsp;&nbsp;|--标牌部</option>
											<option value="38">&nbsp;&nbsp;|--标识部</option>
											<option value="39">&nbsp;&nbsp;|--型材加工部</option>
											<option value="40">&nbsp;&nbsp;|--字加工部</option>
										</select>
										<script language="javascript">
											setFormErrorMsg('', 8);
										</script>
									</div>
								</div>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-label">摘要:</div>
							<div class="layui-input-inline" style="width: 600px;">
								<textarea class="layui-textarea" name="receiveBill.description" id="receiveBill.description" style="min-height: 50px;"></textarea>
								<script language="javascript">
									setFormErrorMsg('', 9, 'receiveBill.description');
								</script>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-label">备注:</div>
							<div class="layui-input-inline" style="width: 600px;">
								<textarea class="layui-textarea" name="receiveBill.mark" id="receiveBill.mark" style="min-height: 50px;"></textarea>
								<script language="javascript">
									setFormErrorMsg('', 10, 'receiveBill.mark');
								</script>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-label">上传凭证:</div>
							<div class="layui-input-inline" style="width: 600px;">
								<div style="position:relative; width:480px; height:28px; overflow:hidden; float:left;">
									<input type="text" class="layui-input" readonly="readonly" style="width:470px;" name="tmp_att" id="tmp_att">
								</div>
								<div style="position:relative;width:40px;height:28px;overflow:hidden;float:left;">
									<div style="position:absolute;top:0px;left:0px;width:100%;height:100%;">
										<a href="javascript:;">选择</a>
									</div>
									<input type="file" name="attach_file" id="attach_file" onchange="document.getElementById('tmp_att').value=this.value" style="position:absolute;top:0px;right:0px;cursor:pointer;opacity:0;filter:alpha(opacity:0);z-index:99;">
								</div>
							</div>
							<script language="javascript">
								setFormErrorMsg('', 11);
							</script>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-label"></div>
							<div class="layui-input-inline" style="width: 600px;">
								<input lay-ignore type="checkbox" id="clos_busi_cb" onclick="changeClosBusi();"> 同时结清已收齐款的业务单
								<input type="hidden" name="receiveBill.closBusi" id="receiveBill.closBusi" value="N">
							</div>
						</div>

						<div class="BillNotes">
							<span>开单人：杨海波 </span>
							<span>审核人：</span>
							<span>单据帐套：网络公司</span>

							<script language="javascript">
								setFormErrorMsg('', 1);
							</script>

						</div>
					</div>

					<!-- 底栏按钮 -->
					<div class="Footer">
						<div id="buttonDiv">

							<input type="button" class="buttom-a" value=" 保 存 " onclick="doSave('');">

							<input type="button" class="buttom-a" value="保存打小票" onclick="doSavePrinLitt();">
							<input type="button" class="buttom-a" value="保存并新增" onclick="doSave('NEW');">

							<!--
				<input type="button" class="buttom-a" value="向下分配" onClick="autoAssign();">
				<input type="button" class="buttom-a" value="向上汇总" onClick="doCount();">
				-->
							<input type="button" class="buttom-a" value=" 取 消 " onclick="doCancel();">
							<input type="hidden" id="examine" name="examine" value="0">
							<input type="hidden" name="continue_flag" id="continue_flag" value="">
							<input type="hidden" name="print_flag" id="print_flag" value="">
							<input type="hidden" name="print_detail" id="print_detail" value="">
							<input type="hidden" name="sychronizeValue" id="sychronizeValue" value="0">
						</div>
						<div id="waitDiv" style="display:none">
							<span>请稍候...</span>
						</div>
					</div>

				</div>
			</form>
		</div>

		<div id="LoadProcess" style="position:absolute; left:50%;top:50%; width:200px; height:100px; margin-top:-50px;margin-left:-100px;z-index:1; border:solid #000 5px;background-color:White;display:none">
			<table border="0" align="center" style="height:100%;">
				<tbody>
					<tr>
						<td style="valign:middle">
							<img src="images/loading.gif"> 请稍候...
						</td>
					</tr>
				</tbody>
			</table>
		</div>
		<script src="layui/layui.all.js"></script>
	</body>
</html>