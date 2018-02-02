<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>送货单审核 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doCancel() {
				ClosePop();
			}

			function doExamine(id) {
				ShowConfirm('确定审核通过吗？', {title:'确认框'}, function(index){
					popRetVal = 'Y';
					layer.close(index);
					doExamineCallBack(id);
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
						<table border="0" cellspacing="0" cellpadding="0" align="center" class="table-0">
							<tbody>
								<tr>
									<td style="width:33%" rowspan="2"></td>
									<td style="width:33%;text-align:center" rowspan="2">
										<h2>送货单审核</h2></td>
									<td style="width:34%" class="tr">
										编号：I2016030016
									</td>
								</tr>
								<tr>
									<td class="tr">送货日期：2016-03-21</td>
								</tr>
							</tbody>
						</table>

						<hr />

						<table border="0" cellspacing="0" cellpadding="0" align="center" class="table-0">
							<tbody>
								<tr>
									<th style="width:10%">订货单位：</th>
									<td style="width:22%">个人</td>
									<th style="width:8%">联系人：</th>
									<td style="width:16%">张宝建</td>
									<th style="width:6%">电话：</th>
									<td style="width:16%">13849181842
									</td>
									<td class="tr" style="width:22%">业务单号：E2016030103</td>
								</tr>
							</tbody>
						</table>

						<hr />

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
										<td>标牌</td>
										<td>60面板</td>
										<td></td>
										<td>60*780mm</td>
										<td></td>
										<td>2</td>
										<td>2</td>
									</tr>

								</tbody>
							</table>
						</div>

						<hr />

						<table border="0" cellspacing="0" cellpadding="0" align="center" class="table-a2 BillElseInfo">
							<tbody>
								<tr>
									<th>部门：</th>
									<td>客服</td>
									<th>送货地址：</th>
									<td></td>
									<th>摘要：</th>
									<td>标牌部 同城快递</td>
								</tr>
								<tr>
									<th>业务员：</th>
									<td>温艳丽</td>
									<th>物流公司：</th>
									<td></td>
									<th>物流单号：</th>
									<td></td>
								</tr>
								<tr>
									<th>备注：</th>
									<td colspan="3">3.9号转账80元</td>
									<th>付款方式：</th>
									<td>现结</td>
								</tr>
							</tbody>
						</table>

						<div class="blank12">&nbsp;</div>
						<p class="give">
							<span>开单人：温艳丽 2016-03-21 16:35</span>
							<span>审核人：</span>
							<span>单据帐套：新异</span>
						</p>
					</div>
				</div>
			</div>
			<div class="modal-buttom">

				<input type="button" class="buttom-a" value=" 审核通过" onclick="doExamine('16');">

				<input type="button" class="buttom-a" value=" 退 出 " onclick="doCancel();">
			</div>
		</div>
<script src="layui.all"></script>
	</body>

</html>