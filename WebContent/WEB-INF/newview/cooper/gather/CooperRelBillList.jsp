<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>外协单单据跟踪 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doCopy(code) {
				try {
					window.clipboardData.setData("Text", code);
					ShowAlert('复制成功！', {title:'提示框'});
				} catch(e) {
					ShowAlert('对不起，当前浏览器不支持剪帖板功能！', {title:'提示框'});
				}
			}

			function showBus(bbItemId) {
				showWin(['900px','600px'], "business/BusinessBillPrint.html?id=" + bbItemId + "&type=ITEM_SIMPLE");
			}

			function showGatherBill(id) {
				var url = "cooper/GatherBillEdit.html?id=" + id + "&alert_type=FORM";
				showWin(['1024px','600px'], url);
			}

			function showPayBill(id) {
				var url = "finance/PayBillEdit.html?id=" + id + "&alert_type=FORM";
				showWin(['1024px','600px'], url);
			}

			function showAdjustBill(id) {
				var url = "finance/AdjustBillEdit.html?id=" + id + "&alert_type=FORM";
				showWin(['1024px','600px'], url);
			}

			function doInit() {
				if(window.screen.availWidth > 900) {
					var w = window.screen.availWidth * 0.98;
					window.resizeTo(w, 600);
					document.getElementById("mainDiv").style.width = (w - 60) + "px";
					//居中
					var resizeWinTop = (window.screen.availHeight - 600) / 2;
					var resizeWinLeft = (window.screen.availWidth - w) / 2;
					window.moveTo(resizeWinLeft, resizeWinTop);
				}
			}

			function doEdit() {
				var url = "cooper/CooperBillEdit.html?edit_type=MODIFY&id=77&alert_type=FORM";
				showWin(['1280px','600px'], url);
			}

			function doDownload(fileName, sourceName) {
				window.location = "/FileDownload.html?file_name=" + encodeURIComponent(fileName) + "&source_name=" + encodeURIComponent(sourceName);
			}
		</script>
		<style>
			.layui-elem-field legend {
				font-size: 14px;
				font-weight: bold;
			}
			
			.layui-field-title {
				margin: 0 0 10px;
			}
		</style>
	</head>

	<body oncontextmenu="return false" class="sheet">
		<div class="sheet-main" id="mainDiv">
			<div class="sheet-top">
				<div class="content">
					<h2>U(2)2017120002单据跟踪&nbsp;&nbsp;<span style="font-size:14px"><a href="javascript:doEdit();">修改外协单</a></span></h2>
				</div>
			</div>
			<div class="sheet-list">
				<p style="line-height: 37px;">与外协单相关的单据，包括收货、付款、调账等</p>
				<div class="search-business">
					<div class="table-list">
						<fieldset class="layui-elem-field layui-field-title">
							<legend>附件</legend>
							<div class="layui-field-box">
								<table width="98%" align="center">
									<tbody>
										<tr>
											<th width="22%">文件</th>
											<th width="22%">资料路径</th>
											<th width="24%">文件说明</th>
											<th width="10%">上传人</th>
											<th width="14%">上传时间</th>
											<th width="8%">操作</th>
										</tr>

										<tr>
											<td colspan="6">没有附件</td>
										</tr>

									</tbody>
								</table>
							</div>
						</fieldset>

						<fieldset class="layui-elem-field layui-field-title">
							<legend>项目明细</legend>
							<div class="layui-field-box">
								<table width="98%" align="center">
									<tbody>
										<tr>
											<th width="12%">项目类型</th>
											<th width="16%">内容</th>
											<th width="14%">材质</th>
											<th width="14%">规格</th>
											<th width="6%">单位</th>
											<th width="8%">数量</th>
											<th width="18%">制作要求</th>
											<th width="12%">来源单号</th>
										</tr>

										<tr>
											<td>标牌</td>
											<td></td>
											<td>磁性板</td>
											<td>

												x 400
											</td>
											<td>
												平方米

											</td>
											<td>
												0

											</td>
											<td></td>
											<td>
												<a href="javascript:showBus('9126');">E(2)2017120013</a>
											</td>
										</tr>

									</tbody>
								</table>
							</div>
						</fieldset>

						<fieldset class="layui-elem-field layui-field-title">
							<legend>收货单</legend>
							<div class="layui-field-box">
								<table width="98%" align="center">
									<tbody>
										<tr>
											<th width="20%">收货单号</th>
											<th width="20%">日期</th>
											<th width="20%">开单人</th>
											<th width="20%">状态</th>
											<th width="20%">操作</th>
										</tr>

										<tr>
											<td colspan="5">没有收货单</td>
										</tr>

									</tbody>
								</table>
							</div>
						</fieldset>

						<fieldset class="layui-elem-field layui-field-title">
							<legend>付款单</legend>
							<div class="layui-field-box">
								<table width="98%" align="center">
									<tbody>
										<tr>
											<th width="20%">付款单号</th>
											<th width="20%">日期</th>
											<th width="20%">开单人</th>
											<th width="20%">状态</th>
											<th width="20%">操作</th>
										</tr>

										<tr>
											<td colspan="5">没有付款单</td>
										</tr>

									</tbody>
								</table>
							</div>
						</fieldset>

						<fieldset class="layui-elem-field layui-field-title">
							<legend>调帐单</legend>
							<div class="layui-field-box">
								<table width="98%" align="center">
									<tbody>
										<tr>
											<th width="20%">调账单号</th>
											<th width="20%">日期</th>
											<th width="20%">开单人</th>
											<th width="20%">状态</th>
											<th width="20%">操作</th>
										</tr>

										<tr>
											<td colspan="5">没有调账单</td>
										</tr>

									</tbody>
								</table>
							</div>
						</fieldset>
					</div>
				</div>
			</div>
		</div>
		<script src="layui/layui.all.js"></script>
	</body>

</html>