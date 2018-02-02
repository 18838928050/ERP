<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>帐套 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/jquery-3.0.0.min.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doSave() {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				frm.submit();
			}

			function doCancel() {
				ClosePop();
			}

			function showMe() {
				showFormErrorMsg();
			}

			function doCheck() {
				var tsName = $("#title").val();
				var expId = "0";
				if(tsName != "") {
					$.post("/system/CheckTs.html", {
						ts_name: tsName,
						exp_id: expId
					}, function(data, status) {
						parseCheckData(data, status);
					});
				}
			}

			function parseCheckData(data, status) {
				if(status == "success") {
					var obj = $.parseJSON(data);
					if(obj.status == "ERROR") {
						ShowAlert('提示框', obj.errMsg, 200, 100);
					} else if(obj.status == "EXIST") {
						ShowConfirm('名称已经存在，恢复帐套吗？', {title:'确认框'}, function(index){
							popRetVal = 'Y';
							layer.close(index);
							doCheckCallBack();
						});
					} else {
						ShowAlert('没有存在此名称的帐套', {title:'提示框'});
					}
				} else {
						ShowAlert('系统错误：' + status, {title:'提示框'});
				}
			}

			function doCheckCallBack() {
				if(popRetVal != null) {
					var tsName = $("#title").val();
					$.post("/system/RecoverTs.html", {
						ts_name: tsName
					}, function(data, status) {
						parseRecoverData(data, status);
					});
				}
			}

			function parseRecoverData(data, status) {
				if(status == "success") {
					var obj = $.parseJSON(data);
					if(obj.status == "ERROR") {
						ShowAlert(obj.errMsg, {title:'提示框'});
					} else {
						//ie有时候会报个莫名其妙的错误(jquery.js里),设置个timeout看看有没有效果
						setTimeout(function() {
							parent.popRetVal = "OK";
							ClosePop();
						}, 500);
					}
				} else {
						ShowAlert('系统错误：' + status, {title:'提示框'});
				}
			}
		</script>
	</head>

	<body oncontextmenu="return false" scroll="no" onload="showMe();" class="sheet modal-dialog">
		<div class="sheet-main" id="bodyDiv">
			<form name="TallySet_tallySetNew" method="post">
				<div class="sheet-list">
					<div class="modal-main search-business" style="+zoom:1">
						<div style="width:100%;">

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
							<h3>新增帐套</h3>
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
							<table border="0" cellspacing="1" cellpadding="1" align="center" class="table-a" style="margin-bottom: 0;">
								<tbody>
									<tr>
										<th><span class="MustInput">*</span>账套名称：</th>

										<td>
											<div class="layui-inline">
											<input type="text" class="layui-input" style="width: 140px;" maxlength="15" id="title" name="title">
											</div>
											<a href="javascript:doCheck();" title="查出哪些是重名的，已删除的重名帐套可以在这里恢复">检查</a>
											<script language="javascript">
												setFormErrorMsg('', 1, 'title');
											</script>
										</td>

									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="modal-buttom" id="buttonDiv">
					<input type="submit" class="buttom-a" value=" 保 存 " onclick="doSave();">
					<input type="button" class="buttom-a" value=" 取 消 " onclick="doCancel();">
					<input type="hidden" name="flag" id="flag" value="1">
				</div>
				<div class="modal-buttom" id="waitDiv" style="display:none">
					<span style="color:#ffffff">请稍候...</span>
				</div>
			</form>
		</div>
<script src="layui/layui.all.js"></script>
	</body>

</html>