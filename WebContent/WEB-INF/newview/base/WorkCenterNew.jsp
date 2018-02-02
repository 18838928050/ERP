<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0048)http://115.28.87.22:8888/base/WorkCenterNew.ihtm -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>工作中心 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doSave() {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				parent.popRetVal = 'Y';
				ClosePop();
				frm.submit();
			}

			function doCancel() {
				ClosePop();
			}

			function showMe() {
				showFormErrorMsg();
				document.getElementById("wcName").focus();
			}

			function changeStatus() {
				if(document.getElementById("r_status1").checked) {
					document.getElementById("status").value = "Y";
				} else {
					document.getElementById("status").value = "N";
				}
			}
		</script>
		<style>
			.layui-form-label {
				width: 50px;
			}
		</style>
	</head>

	<body oncontextmenu="return false" onload="showMe();" class="sheet modal-dialog">
		<div class="sheet-main" id="bodyDiv">
			<form name="frm" action="WorkCenter_doNew" method="post">
				<div class="sheet-list">
					<div class="modal-main search-business">
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
							<h3>新增工作中心</h3>
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
							<table style="margin-bottom: 0;" border="0" cellspacing="1" cellpadding="1" align="center" class="table-a layui-form">
								<tbody>
									<tr>
										<th><span class="MustInput">*</span>名称：</th>

										<td>
											<input class="layui-input" style="width: 140px;" type="text" maxlength="15" onkeyup="goNextInput('mark');" id="wcName" name="wcName" value="">
											<script language="javascript">
												setFormErrorMsg('', 2, 'wcName');
											</script>
										</td>

									</tr>
									<tr>
										<th>描述：</th>

										<td>
											<input class="layui-input" style="width: 140px;" type="text" maxlength="50" id="mark" name="mark" value="">
											<script language="javascript">
												setFormErrorMsg('', 3, 'mark');
											</script>
										</td>

									</tr>
									<tr>
										<th><span class="MustInput">*</span>仓库：</th>

										<td>
											<div class="layui-inline" style="width:140px">
												<select id="storehouseId" name="storehouseId">
												<option value="0">==请选择==</option>
												
												<s:iterator value="storehouses" status="indexs">
													<option value="${id }">${stoName }</option>
												</s:iterator>
											</select>
											</div>
											
											<script language="javascript">
												setFormErrorMsg('', 4);
											</script>
										</td>

									</tr>
									<tr>
										<th><span class="MustInput">*</span>状态：</th>
										<td>
											<input type="radio" name="enabled" id="r_status1" onclick="changeStatus();" value="Y" title="正常" checked="">
										<input type="radio" name="enabled" id="r_status2" onclick="changeStatus();" value="N" title="停用">

											<input type="hidden" name="status" id="status" value="Y">

										</td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="modal-buttom" id="buttonDiv">
					<input type="button" class="buttom-a" value=" 保 存 " onclick="doSave();">
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