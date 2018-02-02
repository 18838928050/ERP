<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>出库单反审核 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		
		<script src="layui/layui.all.js"></script>
		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doCancel() {
				parent.layer.closeAll();
			}

			function doExamine(id) {
				ShowConfirm('确定反审核吗？', {title:'确认框'}, function(){
					popRetVal = 'Y';
					doExamineCallBack(id);
				});
			}

			function doExamineCallBack(id) {
				if(popRetVal != null) {
					window.location = "InBillExamine.html?id_str=" + id + "&flag=0";
				}
			}

			function doInit() {}
		</script>
	</head>

	<body oncontextmenu="return false" onload="doInit();" class="sheet modal-dialog">
		<div class="sheet-main" id="bodyDiv">
			<form name="frm" method="post">
				<div class="sheet-list">
					<div class="modal-main search-business">
						<div style="width:100%;">
							<div class="BillHeading">
							<div class="layui-row">
								<div class="layui-col-sm4">
									<div class="CorpLogo"><img src="images/BIAO  SHI  HUI.png"></div>
								</div>
								<div class="layui-col-sm4">
									<h1>出库单反审核</h1>
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
										<div class="layui-form-mid">入库日期：2017-09-22</div>
									</div>
								</div>
							</div>
						</div>
							
<div class="blank12"></div>
						<div class="layui-row">
							<div class="layui-col-sm3">
								<div class="layui-form-item">
									<div class="layui-form-mid">仓库:</div>
									<div class="layui-form-mid">你好，仓库</div>
								</div>
							</div>
							<div class="layui-col-sm3" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">供方类型:</div>
									<div class="layui-form-mid">仓库</div>
								</div>
							</div>
							<div class="layui-col-sm3" style="text-align: center;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">供方:</div>
									<div class="layui-form-mid">中力门店仓库</div>
								</div>
							</div>
							<div class="layui-col-sm3" style="text-align: right;">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">出库类型:</div>
									<div class="layui-form-mid">采购入库</div>
								</div>
							</div>
						</div>
						<hr style="margin-top: 0;" />


							<div class="table-list">
								<table width="98%" border="0" cellspacing="0" cellpadding="0" align="center" id="itemTbl">
									<tbody id="itemRowTbl">
										<tr>
											<th width="15%">材料编号</th>
											<th>品名规格</th>
											<th width="10%">单位</th>
											<th width="10%">数量</th>
											<th width="10%">单价</th>
											<th width="10%">金额</th>
											<th width="20%">备注</th>
										</tr>

										<tr>
											<td>C72-0001</td>
											<td>刀刮布</td>
											<td>平方米</td>
											<td>
												<div align="right">100</div>
											</td>
											<td>
												<div align="right">5</div>
											</td>
											<td>
												<div align="right">500</div>
											</td>
											<td></td>
										</tr>

									</tbody>
								</table>
							</div>

							<hr />
							
							<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<div class="layui-form-mid">经办人:</div>
									<div class="layui-form-mid">黄秀娟</div>
								</div>
							</div>
							<div class="layui-col-sm4">
								<div class="layui-form-item" style="display: inline-block;">
									<div class="layui-form-mid">备注:</div>
									<div class="layui-form-mid"></div>
								</div>
							</div>
						</div>


							<p class="give">
								<span>开单人：杨海波 2017-09-14 19:08</span>
								<span>审核人：杨海波 2017-09-14 19:14</span>
								<span>单据帐套：网络公司</span>
							</p>
						</div>
					</div>
				</div>
				<div class="modal-buttom">
					<input type="button" class="buttom-a" value=" 反审核 " onclick="doExamine('139');">
					<input type="button" class="buttom-a" value=" 退 出 " onclick="doCancel();">
				</div>
			</form>
		</div>
	</body>
</html>