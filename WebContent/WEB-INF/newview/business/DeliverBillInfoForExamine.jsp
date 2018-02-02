<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>送货单审核 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link href="layui/css/layui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doCancel() {
				ClosePop();
			}

			function doExamine(id) {
				ShowConfirm('确定审核通过吗？', {title:'确认框'}, function(){
					popRetVal = 'Y';
					doExamineCallBack(id);
					layer.closeAll();
				});
			}

			function doExamineCallBack(id) {
				if(popRetVal != null) {
					window.location = "DeliverBillExamine.html?id_str=" + id + "&flag=1";
				}
			}

			function doInit() {}
		</script>
	</head>

	<body oncontextmenu="return false" onload="doInit();" class="sheet modal-dialog">
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
									<h1>送货单审核</h1>
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
										<div class="layui-form-mid">编号：J(2)2017090016</div>
									</div>
									<div class="layui-form-item" style="float: right;">
										<div class="layui-form-mid">送货日期：2017-09-22</div>
									</div>
								</div>
							</div>
						</div>
						<div class="blank12"></div>
						<div class="layui-row">
							<div class="layui-col-sm3">
								<div class="layui-form-item">
									<div class="layui-form-mid">订货单位:</div>
									<div class="layui-form-mid">小星星</div>
								</div>
							</div>
							<div class="layui-col-sm3" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">联系人:</div>
									<div class="layui-form-mid">牛牛</div>
								</div>
							</div>
							<div class="layui-col-sm3" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">电话:</div>
									<div class="layui-form-mid">18632336966</div>
								</div>
							</div>
							<div class="layui-col-sm3" style="text-align: right;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">业务单号:</div>
									<div class="layui-form-mid">E(2)2017080011</div>
								</div>
							</div>
						</div>
						<hr style="margin-top: 0;" />

						<div class="table-list">
							<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center" id="itemTbl">
								<tbody id="itemRowTbl">
									<tr>
										<th width="10%">项目类型</th>
										<th width="15%">内容</th>
										<th width="15%">材质</th>
										<th width="15%">规格</th>
										<th width="25%">制作要求</th>
										<th width="10%">订货数量</th>
										<th width="10%">本次送货</th>
									</tr>

									<tr>
										<td>标识</td>
										<td>计件用</td>
										<td></td>
										<td>1.2m x 2.4m高</td>
										<td></td>
										<td>2</td>
										<td>2</td>
									</tr>

									<tr>
										<td>标识</td>
										<td>立牌</td>
										<td></td>
										<td>1.2*2.4</td>
										<td></td>
										<td>1</td>
										<td>1</td>
									</tr>

								</tbody>
							</table>
						</div>
						
						<hr />
						
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-label">部门:</div>
									<div class="layui-form-mid">业务来源</div>
								</div>
							</div>
							<div class="layui-col-sm4">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">送货地址:</div>
									<div class="layui-form-mid">送货地址</div>
								</div>
							</div>
							<div class="layui-col-sm4">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">摘要:</div>
									<div class="layui-form-mid">摘要</div>
								</div>
							</div>
						</div>
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-label">业务员:</div>
									<div class="layui-form-mid">邵丽萍</div>
								</div>
							</div>
							<div class="layui-col-sm4">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">物流公司:</div>
									<div class="layui-form-mid">changtong</div>
								</div>
							</div>
							<div class="layui-col-sm4">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">物流单号:</div>
									<div class="layui-form-mid">123456210</div>
								</div>
							</div>
						</div>
						<div class="layui-row">
							<div class="layui-col-sm8">
								<div class="layui-form-item">
									<div class="layui-form-label">备注:</div>
									<div class="layui-form-mid">备注</div>
								</div>
							</div>
							<div class="layui-col-sm4">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-label">付款方式:</div>
									<div class="layui-form-mid">银行转帐</div>
								</div>
							</div>
						</div>

						<p class="give">
							<span>开单人：邵丽萍 2017-08-11 15:59</span>
							<span>审核人：</span>
							<span>单据帐套：网络公司</span>
						</p>
					</div>
				</div>
			</div>
			<div class="modal-buttom">
				<input type="button" class="buttom-a" value=" 审核通过" onclick="doExamine('2248');">
				<input type="button" class="buttom-a" value=" 退 出 " onclick="doCancel();">
			</div>
		</div>
		<script src="layui/layui.all.js"></script>
	</body>
</html>