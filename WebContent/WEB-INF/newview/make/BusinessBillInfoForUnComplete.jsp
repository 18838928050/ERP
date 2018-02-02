<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>业务单反完工 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doCancel() {
				ClosePop();
			}

			function doUnComplete(billId) {
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
					ShowAlert('请选择要反完工的项目', {title:'提示框'});
				} else {
					ShowConfirm('确定所选项目反完工吗？', {title:'确认框'}, function(index){
						popRetVal = 'Y';
						layer.close(index);
						doUnCompleteCallBack(itemIdStr, billId);
					});
				}
			}

			function doUnCompleteCallBack(itemIdStr, billId) {
				if(popRetVal != null) {
					window.location = "/business/BusinessBillUnComplete.ihtm?item_id_str=" + itemIdStr + "&wc_id=13&bill_id=" + billId;
				}
			}

			function doDownload(id, fileName, sourceName) {
				var xmlHttp = createXMLHttpRequest();
				xmlHttp.open("GET", "/FileDownloadLog.ihtm?id=" + id);
				xmlHttp.onreadystatechange = function() {
					doDownloadCallback(xmlHttp, fileName, sourceName);
				};
				xmlHttp.send(null);
			}

			function doDownloadCallback(xmlHttp, fileName, sourceName) {
				if(xmlHttp.readyState == 4) {
					if(xmlHttp.status == 200) {
						var resTxt = xmlHttp.responseText;
						if(resTxt == "NO_LOGIN") {
							ShowAlert('你还没登录或已经超时，请重新登录。', {title:'提示框'});
						} else if(resTxt == "OK") {
							window.location = "/FileDownload.ihtm?file_name=" + encodeURIComponent(fileName) + "&source_name=" + encodeURIComponent(sourceName);
						}
					}
				}
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
										<h2>业务单反完工</h2></td>
									<td style="width:34%" class="tr">
										编号：E(2)2017090013
									</td>
								</tr>
								<tr>
									<td class="tr">订货日期：2017-09-22 09:07</td>
								</tr>
							</tbody>
						</table>

						<hr />

						<table border="0" cellspacing="0" cellpadding="0" align="center" class="table-a2 BillElseInfo">
							<tbody>
								<tr>
									<th style="width:10%">客户：</th>
									<td style="width:90%" colspan="5">格力电器</td>
								</tr>
								<tr>
									<th>工作中心：</th>
									<td style="width:23%">标牌部</td>
									<th style="width:10%">交货日期：</th>
									<td style="width:23%">2017-09-22 09:07</td>
									<th style="width:10%">摘要：</th>
									<td style="width:24%">需求摘要</td>
								</tr>
							</tbody>
						</table>

						<hr />

						<div class="table-list">
							<table border="0" cellspacing="0" cellpadding="0" align="center" width="100%">
								<tbody>
									<tr>
										<th width="14"><input type="checkbox" onclick="javascript:checkItemAll(this);" checked="true"></th>
										<th width="12%">项目类型</th>
										<th width="14%">内容</th>
										<th width="14%">材质</th>
										<th width="14%">规格</th>
										<th width="16%">制作要求</th>
										<th width="6%">单位</th>
										<th width="8%">计划量</th>
										<th width="16%">完成情况</th>
									</tr>

									<tr>
										<td><input type="checkbox" name="itemCb" index="0" value="7849" checked="true"></td>
										<td>标牌</td>
										<td>标牌标牌</td>
										<td></td>
										<td>
											10m x 10m高 x 10
										</td>
										<td>制作要求无</td>
										<td>
											平方米

										</td>
										<td>
											1000

										</td>
										<td></td>
									</tr>

								</tbody>
							</table>
						</div>

						<div class="blank12">&nbsp;</div>
						<p class="give">
							<span>开单人：贾文博 2017-09-22 09:10</span>
							<span>审核人：贾文博 2017-09-21 09:21</span>
							<span>结清： </span>
							<span>最后打印：管理员 / 已打印1次</span>
							<span>修改人：</span>
							<span>单据帐套：网络公司</span>
						</p>
					</div>
				</div>
			</div>
			<div class="modal-buttom">
				<input type="button" class="buttom-a" value=" 反完工 " onclick="doUnComplete('');">
				<input type="button" class="buttom-a" value=" 退 出 " onclick="doCancel();">
			</div>
		</div>

	</body>

</html>