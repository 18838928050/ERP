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
		<title>其他收入单作废 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link href="layui/css/layui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/popup.js"></script>
		<script src="js/minierp.js"></script>
		<script>
			function doCancel() {
				ClosePop();
			}

			function doDisabled(id) {
				var url = "system/CancelReasonNew.ihtm";
				ShowIframe(['600px', '260px'], url, '', function() {
					doDisabledCallback(id);
				}, '其他收入单作废');
			}

			function doDisabledCallback(id) {
				if(popRetVal != null) {
					$.post("/finance/IncomeBillCancel.ihtm", {
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
		<style>
			.layui-form-label{
				width: 70px;
			}
		</style>
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
									<h1>其他收入作废</h1>
								</div>
								<div class="layui-col-sm4 tr" style="">
									<div class="layui-form-item" style="display: inline-block;margin-top: 10px;margin-bottom: 8px;">
										<div class="layui-input-inline">
											&nbsp;
										</div>
									</div>
									<div class="layui-form-item" style="float: right;">
										<div class="layui-form-mid">编号：${ incomeBill.billCode }</div>
									</div>
									<div class="layui-form-item" style="float: right;">
										<div class="layui-form-mid">日期：<s:date name="incomeBill.incomeDate" format="yyyy-MM-dd" /></div>
									</div>
								</div>
							</div>
						</div>

						<div class="blank12"></div>
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-label">付款单位:</div>
									<div class="layui-form-mid">${ incomeBill.payerName }</div>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">经办人:</div>
									<div class="layui-form-mid">${ incomeBill.managerName }</div>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: right;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">部门:</div>
									<div class="layui-form-mid"></div>
								</div>
							</div>
						</div>
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-label">收入类型:</div>
									<div class="layui-form-mid">
									<%-- <s:if test=' #incomeBill.payModeId == (1) '>现结</s:if>
									<s:elseif test=' #incomeBill.payModeId == (2) '>月结</s:elseif>
									<s:elseif test=' #incomeBill.payModeId == (3) '>季结</s:elseif>
									<s:elseif test=' #incomeBill.payModeId == (4) '>公户转帐</s:elseif>
									<s:elseif test=' #incomeBill.payModeId == (5) '>支付宝转帐</s:elseif>
									<s:elseif test=' #incomeBill.payModeId == (6) '>银行转帐</s:elseif>
									<s:elseif test=' #incomeBill.payModeId == (7) '>物流代收</s:elseif>
									<s:elseif test=' #incomeBill.payModeId == (8) '>微信转帐</s:elseif>
									<s:elseif test=' #incomeBill.payModeId == (9) '>取货付款</s:elseif> --%>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">银行账号:</div>
									<div class="layui-form-mid"></div>
								</div>
							</div>
							<div class="layui-col-sm4" style="text-align: right;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">收款金额:</div>
									<div class="layui-form-mid">${ incomeBill.cost }</div>
								</div>
							</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-label">摘要:</div>
							<div class="layui-form-mid">${ incomeBill.mark }</div>
						</div>
						<div class="layui-form-item">
							<div class="layui-form-label">凭证:</div>
							<div class="layui-form-mid">${ incomeBill.managerName }</div>
						</div>

						<hr />

						<p class="give">
							<span>开单人：${ incomeBill.createrName } <s:date name="incomeBill.createTime" format="yyyy-MM-dd" /></span>
							<span>审核人：${ incomeBill.examinerName } <s:date name="incomeBill.examineTime" format="yyyy-MM-dd" /></span>
							<span>单据帐套：	
									<s:if test=' #incomeBill.tallySetId.equals(1)'>网络公司</s:if>
									<s:elseif test=' #incomeBill.tallySetId.equals(2)'>新异</s:elseif>
							</span>
						</p>
					</div>
				</div>
			</div>
			<div class="modal-buttom">
				<input type="button" class="buttom-a" value=" 作 废 " onclick="doDisabled('1');">
				<input type="button" class="buttom-a" value=" 退 出 " onclick="doCancel();">
			</div>
		</div>

	</body>

</html>