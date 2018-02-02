<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>收货单 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/BillEdit.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script src="js/dhtmlgoodies_calendar.js"></script>
		<script language="javascript">
			function doSave() {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				ShowConfirm('是否同时审核？', {title:'确认框'}, function(index){
					popRetVal = 'Y';
					layer.close(index);
					doSaveCallBack();
				});

			}

			function doSaveCallBack() {
				if(popRetVal != null) {
					document.getElementById("examine").value = "1";
				}
				frm.submit();
			}

			function doCancel() {
				if(window.opener) {
					window.close();
				} else {
					ClosePop();
				}
			}

			function doPrint(id, favCost) {
				if(favCost == 0) {
					ShowConfirm('收货单打印金额？', {title:'确认框'}, function(index){
						popRetVal = 'Y';
						layer.close(index);
						doPrintCallBack(id);
					});
				} else {
					showWin(['900px','600px'], "cooper/GatherBillPrint.ihtm?id=" + id + "&print_cost=0");
				}
			}

			function doPrintCallBack(id) {
				var printCost = "0";
				if(popRetVal != null) {
					var printCost = "1";
				}
				showWin(['900px','600px'], "cooper/GatherBillPrint.ihtm?id=" + id + "&print_cost=" + printCost);
			}

			function doInit() {
				var itemNum = document.getElementById("item_num").value - 0;
				if(itemNum > 0) {
					document.getElementById("amount_0").select();
				} else {
					document.getElementById("cancelButton").focus();
				}
				showFormErrorMsg();
				resizePopwin();
			}
		</script>
		<style>
			.BillDetails .layui-input {
				display: inline;
			}
		</style>
	</head>

	<body onload="doInit();">
		<div>
			<form name="frm" method="post">
				<div class="Container">
					<div class="Contnet Paper">

						<!-- 编码框是否可点击 -->
						<!-- 编码框颜色 -->

						<!-- 是否可以编辑日期 -->

						<!-- 提示信息 -->

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

						<!--单标题-->
						<div class="BillHeading">
							<div class="layui-row">
								<div class="layui-col-sm4">
									<div class="CorpLogo"><img src="images/BIAO  SHI  HUI.png"></div>
								</div>
								<div class="layui-col-sm4">
									<h1>收货单</h1>
								</div>
								<div class="layui-col-sm4 tr" style="">
									<div class="layui-form-item" style="display: inline-block;margin-top: 10px;margin-bottom: 8px;">
										<div class="layui-input-inline">
											&nbsp;
										</div>
									</div>
									<div class="layui-form-item" style="display: inline-block;">
										<label class="layui-form-label"><span class="MustInput">*</span>编号：</label>
										<div class="layui-input-inline" style="width: 104px;">
											<input type="text" class="layui-input disabled readonly" readonly="readonly" maxlength="30" onkeyup="goNextInput('deliverDateStr');" id="gatherBill.billCode" name="gatherBill.billCode" value="">
											<script language="javascript">
												setFormErrorMsg('', 1, 'gatherBill.billCode');
											</script>
										</div>
									</div>
									<div class="layui-form-item" style="display: inline-block;">
										<label class="layui-form-label"><span class="MustInput">*</span>收货日期：</label>
										<div class="layui-input-inline" style="width: 85px;">
											<input type="text" class="layui-input" maxlength="15" onkeyup="goNextInput('gatherBill.linkman');" id="gatherDateStr" name="gatherDateStr" value="2017-12-21">
											<script language="javascript">
												setFormErrorMsg('', 2, 'gatherDateStr');
											</script>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="blank12"></div>
						<!-- 单头信息 -->
						<div class="layui-row">
							<div class="layui-col-sm3">
								<div class="layui-form-item">
									<label class="layui-form-label" style="width: 60px;">外协单位：</label>
									<div class="layui-form-mid">
										郑州南方标牌
									</div>
								</div>
							</div>
							<div class="layui-col-sm3 tc">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 60px;">联系人：</label>
									<div class="layui-input-inline" style="width: 110px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="goNextInput('gatherBill.phone');" id="gatherBill.linkman" name="gatherBill.linkman" value="">
										<script language="javascript">
											setFormErrorMsg('', 4, 'gatherBill.linkman');
										</script>
									</div>
								</div>
							</div>
							<div class="layui-col-sm3 tc">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 60px;">电话：</label>
									<div class="layui-input-inline" style="width: 110px;">
										<input type="text" class="layui-input" maxlength="40" onkeyup="goNextInput('gatherBill.content');" id="gatherBill.phone" name="gatherBill.phone" value="">
										<script language="javascript">
											setFormErrorMsg('', 5, 'gatherBill.phone');
										</script>
									</div>
								</div>
							</div>
							<div class="layui-col-sm3 tr">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 60px;">外协单号：</label>
									<div class="layui-form-mid">
										U(1)2017110016
									</div>
								</div>
							</div>
						</div>

						<!-- 明细 -->
						<input type="hidden" id="item_num" name="item_num" value="1">
						<table id="BillDetails" class="BillDetails" width="100%" cellspacing="0" cellpadding="0">
							<tbody id="itemRowTbl">
								<tr>
									<th width="10%">项目类型</th>
									<th width="15%">内容</th>
									<th width="15%">材质</th>
									<th width="15%">规格</th>
									<th width="25%">制作要求</th>
									<th width="10%">外协数量</th>
									<th width="10%">本次收货</th>
								</tr>

								<tr id="itemTr0">
									<td>
										<input class="layui-input readonly" readonly="readonly" type="text" style="width:68px" id="mt_name_0" name="mt_name_0" value="东厂">
										<input type="hidden" id="id_0" name="id_0" value="0">
										<input type="hidden" id="cb_item_id_0" name="cb_item_id_0" value="95">
									</td>
									<td>
										<input type="text" class="layui-input readonly" readonly="readonly" style="width:110px" id="cont_0" name="cont_0" value="拉丝不锈钢牌">
									</td>
									<td>
										<input type="text" class="layui-input readonly" readonly="readonly" style="width:110px" id="pro_name_0" name="pro_name_0" value="">
									</td>
									<td>
										<input type="text" class="layui-input readonly" readonly="readonly" style="width:110px" id="spe_0" name="spe_0" value="62.5*62.5cm">
									</td>
									<td>
										<input type="text" class="layui-input readonly" readonly="readonly" style="width:180px" id="req_0" name="req_0" value="">
									</td>
									<td>
										<input type="text" class="layui-input readonly" readonly="readonly" style="width:68px" id="amount_total_0" name="amount_total_0" value="3">
									</td>
									<td>
										<input type="text" class="layui-input" style="width:68px" maxlength="10" id="amount_0" name="amount_0" value="3">
									</td>
								</tr>

							</tbody>
						</table>

						<script language="javascript">
							setFormErrorMsg('', 9);
						</script>
						<hr />

						<!-- 单附加信息 -->
						<table class="BillElseInfo" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<th width="84px">业务员：</th>
									<td width="200px">邵丽萍</td>
									<th width="84px">摘要：</th>

									<td width="273px">
										<input type="text" class="tbInfo2 layui-input" maxlength="200" onkeyup="goNextInput('gatherBill.mark');" id="gatherBill.content" name="gatherBill.content" value="东厂   门市自提">
										<script language="javascript">
											setFormErrorMsg('', 11, 'gatherBill.content');
										</script>
									</td>

									<th width="84px">备注：</th>

									<td width="179px">
										<input type="text" class="layui-input" style="width:160px" maxlength="100" name="gatherBill.mark" id="gatherBill.mark" value="">
										<script language="javascript">
											setFormErrorMsg('', 12, 'deliverBill.mark');
										</script>
									</td>

								</tr>

							</tbody>
						</table>
						<br>
						<div class="BillNotes">
							<span>开单人：杨海波 </span>
							<span>审核人：</span>
							<span>单据帐套：网络公司</span>

							<script language="javascript">
								setFormErrorMsg('', 1);
							</script>

						</div>

					</div>

					<!-- 业务单 底栏按钮 -->
					<div class="Footer">
						<div id="buttonDiv">

							<input type="button" class="buttom-a" value=" 保 存 " onclick="doSave();">
							<input type="button" class="buttom-a" value=" 取 消 " onclick="doCancel();" id="cancelButton">
							<input type="hidden" id="examine" name="examine" value="0">
							<input type="hidden" name="sychronizeValue" value="0">
						</div>
						<div id="waitDiv" style="display:none">
							<span>请稍候...</span>
						</div>
					</div>

				</div>
			</form>
		</div>
		<script src="layui/layui.all.js"></script>
	</body>

</html>