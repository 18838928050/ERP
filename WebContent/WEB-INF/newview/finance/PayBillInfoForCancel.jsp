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
		<title>付款单作废 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link href="layui/css/layui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/jquery-3.0.0.min.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doCancel() {
				ClosePop();
			}

			function doDisabled(id) {
				var url = "system/CancelReasonNew.html";
				ShowIframe(['600px', '260px'], url, '', function() {
					doDisabledCallback(id);
				}, '付款单作废');
			}

			function doDisabledCallback(id) {
				if(popRetVal != null) {
					$.post("finance/PayBillCancel.html", {
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
						ClosePop();
					}, 300);
				} else {
					ShowAlert('系统错误：' + status, {
						title: '提示框'
					});
				}
			}
		</script>
	</head>

	<body oncontextmenu="return false" class="sheet modal-dialog" style="min-width: 800px;">
		<div class="sheet-main" id="bodyDiv">
			<div class="sheet-list">
				<div class="modal-main search-business">
					<div style="width:100%;">
						<div class="BillHeading">
							<div class="layui-row">
								<div class="layui-col-sm4">
									<div class="CorpLogo"><img src="images/BIAO  SHI  HUI.png"></div>
								</div>
								<div class="layui-col-sm4">
									<h1>付款单作废</h1>
								</div>
								<div class="layui-col-sm4 tr" style="">
									<div class="layui-form-item" style="display: inline-block;margin-top: 10px;margin-bottom: 8px;">
										<div class="layui-input-inline">
											&nbsp;
										</div>
									</div>
									<div class="layui-form-item" style="float: right;">
										<div class="layui-form-mid">编号： ${payBill.billCode }</div>
									</div>
									<div class="layui-form-item" style="float: right;">
										<div class="layui-form-mid">付款日期：${payBill.billCode }</div>
									</div>
								</div>
							</div>
						</div>

						<div class="blank12"></div>
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-mid">收款单位:</div>
									<div class="layui-form-mid">${payBill.billCode }</div>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">付款账户:</div>
									<div class="layui-form-mid">现金</div>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: right;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">付款金额:</div>
									<div class="layui-form-mid">${payBill.cost }</div>
								</div>
							</div>
						</div>

						<hr style="margin-top: 0;" />

						<div class="table-list">
							<table width="100%" border="0" cellspacing="0" cellpadding="0" align="center" id="itemTbl">
								<tbody id="itemRowTbl">
									<tr>
										<th width="20%">单号</th>
										<th width="20%">日期</th>
										<th width="20%">金额（元）</th>
										<th width="20%">余额（元）</th>
										<th width="20%">本次付款</th>
									</tr>

									<tr>
										<td>${payBill.billCode }</td>
										<td><s:date name="payBill.payDate" format="yyyy-MM-dd" /></td>
										<td>${payBill.cost }</td>
										<td>${payBill.cost }</td>
										<td>${payBill.cost }</td>
									</tr>

								</tbody>
							</table>
						</div>
						<hr />
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-label">经办人:</div>
									<div class="layui-form-mid">${payBill.managerName }</div>
								</div>
							</div>
							<div class="layui-col-sm4">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">部门:</div>
									<div class="layui-form-mid">标识汇运营部</div>
								</div>
							</div>
							<div class="layui-col-sm4">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">付款类型:</div>
									<div class="layui-form-mid">采购付款</div>
								</div>
							</div>
						</div>
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-label">摘要:</div>
									<div class="layui-form-mid">${payBill.description }</div>
								</div>
							</div>
							<div class="layui-col-sm4">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">开户行:</div>
									<div class="layui-form-mid">bank_name1</div>
								</div>
							</div>
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-label">账号:</div>
									<div class="layui-form-mid">bank_acc_code1</div>
								</div>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-label">户名:</div>
							<div class="layui-form-mid">bank_acc_name1</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-label">备注:</div>
							<div class="layui-form-mid">${payBill.mark }</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-label">凭证:</div>
							<div class="layui-form-mid"></div>
						</div>

						<p class="give">
							<span>开单人：${payBill.createrName } <s:date name="payBill.createTime" format="yyyy-MM-dd" /></span>
							<span>审核人：${payBill.managerName } <s:date name="payBill.examineTime" format="yyyy-MM-dd" /></span>
							<span>单据帐套：网络公司</span>
						</p>
					</div>
				</div>
			</div>
			<div class="modal-buttom">
				<input type="button" class="buttom-a" value=" 作 废 " onclick="doDisabled('40');">
				<input type="button" class="buttom-a" value=" 退 出 " onclick="doCancel();">
			</div>

		</div>

	</body>

</html>