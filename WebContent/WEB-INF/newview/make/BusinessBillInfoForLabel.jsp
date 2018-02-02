<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>打印标签 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doCancel() {
				ClosePop();
//				window.close();
			}

			function printLabel(billId) {
				var ob_arr = document.getElementsByName("itemCb");
				var itemIdStr = "";
				for(i = 0; i < ob_arr.length; i++) {
					if((ob_arr[i].checked == true)) {
						if(itemIdStr != "") {
							itemIdStr = itemIdStr + ";";
						}
						itemIdStr = itemIdStr + ob_arr[i].value;
					}
				}
				if(itemIdStr == "") {
					ShowAlert('请选择要打印的项目', {
						title: '提示框'
					});
				} else {
					showWin(['400px', '300px'], "business/BusinessBillPrint.html?type=LABEL&item_id_str=" + itemIdStr + "&id=" + billId);
				}
			}

			function printPackage(billId) {
				var ob_arr = document.getElementsByName("itemCb");
				var itemIdStr = "";
				//for (i=0;i<ob_arr.length;i++){
				//	if ((ob_arr[i].checked == true)){
				//		if(itemIdStr!=""){
				//			itemIdStr=itemIdStr+";";
				//		}
				//		itemIdStr = itemIdStr+ob_arr[i].value;
				//	}
				//}
				//if(itemIdStr==""){
				//	ShowAlert('提示框','请选择要打印的项目',200,100);
				//}else{
				showWin(['400px', '300px'], "/business/BusinessBillPrint.html?type=PACKAGE&item_id_str=" + itemIdStr + "&id=" + billId);
				//}
			}

			function checkItemAll(obj) {
				var ob_arr = document.getElementsByName("itemCb");
				for(i = 0; i < ob_arr.length; i++) {
					if(obj.checked) {
						ob_arr[i].checked = true;
					} else {
						ob_arr[i].checked = false;
					}
				}
			}

			function doInit() {

			}
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
										<h2>打印产品标签</h2></td>
									<td style="width:34%" class="tr">编号：E(2)2017100002</td>
								</tr>
								<tr>
									<td class="tr">订货日期：2017-10-05 16:23</td>
								</tr>
							</tbody>
						</table>

						<hr />

						<table border="0" cellspacing="0" cellpadding="0" align="center" class="table-a2 BillElseInfo">
							<tbody>
								<tr>
									<th style="width:10%">客户：</th>
									<td style="width:90%" colspan="5">西雅图设计公司</td>
								</tr>
								<tr>
									<th>工作中心：</th>
									<td style="width:23%"></td>
									<th style="width:10%">交货日期：</th>
									<td style="width:23%">2017-10-05 16:23</td>
									<th style="width:10%">摘要：</th>
									<td style="width:24%"></td>
								</tr>
							</tbody>
						</table>

						<hr />

						<div class="table-list">
							<table border="0" cellspacing="0" cellpadding="0" align="center" width="100%">
								<tbody>
									<tr>
										<th width="20"><input type="checkbox" onclick="javascript:checkItemAll(this);"></th>
										<th width="12%">项目类型</th>
										<th width="14%">内容</th>
										<th width="14%">材质</th>
										<th width="14%">规格</th>
										<th width="16%">制作要求</th>
										<th width="6%">单位</th>
										<th width="8%">数量</th>
										<th width="16%">上次打印时间</th>
									</tr>

									<tr>
										<td><input type="checkbox" name="itemCb" index="0" value="7640" checked="true"></td>
										<td>东厂</td>
										<td>水晶</td>
										<td></td>
										<td>

										</td>
										<td></td>
										<td>

											个
										</td>
										<td>

											3
										</td>
										<td></td>
									</tr>

								</tbody>
							</table>
						</div>

						<div class="blank12">&nbsp;</div>

					</div>
				</div>
			</div>
			<div class="modal-buttom">
				<input type="button" class="buttom-a" value=" 打 印 " onclick="printLabel('3950');">
				<input type="button" class="buttom-a" value="打印配送标签" onclick="printPackage('3950');">
				<input type="button" class="buttom-a" value=" 退 出 " onclick="doCancel();">
			</div>
		</div>
		<script src="layui/layui.all.js"></script>
	</body>

</html>