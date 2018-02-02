<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>收款单作废 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link href="layui/css/layui.css" rel="stylesheet" />
		<script src="js/minierp.js"></script>

		<link rel="stylesheet" type="text/css" href="css/base.css">
		<script src="js/jquery-3.0.0.min.js"></script>
		<script src="layui/layui.all.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doCancel() {
				parent.ClosePop();
			}

			function doDisabled(id) {
				var url = "Accounts_toDisabledReceiveBill";
				ShowIframe(['600px', '260px'], url, '', function() {
					doDisabledCallback(id);
				});
			}

			function doDisabledCallback(id) {
				if(popRetVal != null) {
					$.post("Accounts_disabledReceiveBill", {
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
					//ie有时候会报个莫名其妙的错误(jquery.js里),好像是在parseData后马上返回就会出现
					setTimeout(function() {
						parent.popRetVal = "OK";
						parent.layer.closeAll();
					}, 300);
				} else {
					ShowAlert('系统错误：' + status, {
						title: '提示框'
					}, );
				}
			}
		</script>
	</head>

	<body oncontextmenu="return false" class="sheet modal-dialog">
		<div class="sheet-main" id="bodyDiv" style="width:860px;">
			<div class="sheet-list">
				<div class="modal-main search-business">
					<div style="width:100%;">
						<div class="BillHeading">
							<div class="layui-row">
								<div class="layui-col-sm4">
									<div class="CorpLogo"><img src="images/BIAO  SHI  HUI.png"></div>
								</div>
								<div class="layui-col-sm4">
									<h1>收款单作废</h1>
								</div>
								<div class="layui-col-sm4 tr" style="">
									<div class="layui-form-item" style="display: inline-block;margin-top: 10px;margin-bottom: 8px;">
										<!--<label class="layui-form-label"><span class="MustInput">*</span>编号：</label>-->
										<div class="layui-input-inline">
											&nbsp;
											<!--<input class="layui-input" readonly placeholder="" type="text" maxlength="30" onkeyup="goNextInput('cooperDateStr');" id="cooperBill.billCode" name="cooperBill.billCode" value="">-->
										</div>
									</div>
									<div class="layui-form-item" style="float: right;">
										<div class="layui-form-mid">编号：${ receiveBill.billCode }</div>
									</div>
									<div class="layui-form-item" style="float: right;">
										<div class="layui-form-mid">收款日期：<s:date name="receiveBill.createTime" format="yyyy-MM-dd" /></div>
									</div>
								</div>
							</div>
						</div>
						<div class="blank12"></div>
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-mid">付款单位:</div>
									<div class="layui-form-mid">${ receiveBill.attachFile }</div>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">收款账户:</div>
									<div class="layui-form-mid">${ receiveBill.managerName }</div>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: right;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">收款金额:</div>
									<div class="layui-form-mid">${ receiveBill.cost }</div>
								</div>
							</div>
						</div>
						<hr style="margin-top: 0;" />

						<div class="table-list">
							<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" id="itemTbl">
								<tbody id="itemRowTbl">
									<tr>
										<th width="16%">业务单号</th>
										<th width="10%">日期</th>
										<th width="10%">联系人</th>
										<th width="28%">摘要</th>
										<th width="12%">金额（元）</th>
										<th width="12%">余额（元）</th>
										<th width="12%">本次收款</th>
									</tr>

									<tr>
										<td>${ receiveBill.billCode }</td>
										<td><s:date name="receiveBill.createTime" format="yyyy-MM-dd" /></td>
										<td>${ receiveBill.managerName }</td>
										<td>${ receiveBill.description }</td>
										<td>${ receiveBill.cost }</td>
										<td>${ receiveBill.cost }</td>
										<td>${ receiveBill.cost }</td>
									</tr>

								</tbody>
							</table>
						</div>

						<hr />

						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-mid">经办人:</div>
									<div class="layui-form-mid">${ receiveBill.managerName }</div>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">部门:</div>
									<div class="layui-form-mid">标识汇运营部</div>
								</div>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-mid">摘要:</div>
							<div class="layui-form-mid">${ receiveBill.description }</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-mid">备注:</div>
							<div class="layui-form-mid">${ receiveBill.mark }</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-mid">凭证:</div>
							<div class="layui-form-mid"></div>
						</div>

						<div class="blank12">&nbsp;</div>
						<p class="give">
							<span>开单人：贾文博 2017-09-22 09:25</span>
							<span>审核人：贾文博 2017-09-22 09:25</span>
							<span>单据帐套：网络公司</span>
						</p>
					</div>
				</div>
			</div>
			<div class="modal-buttom">
				<input type="button" class="buttom-a" value=" 作 废 " onclick="doDisabled(${id });">
				<input type="button" class="buttom-a" value=" 退 出 " onclick="doCancel();">
			</div>
		</div>

	</body>

</html>