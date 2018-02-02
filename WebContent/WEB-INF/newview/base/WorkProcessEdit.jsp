<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0055)http://115.28.87.22:8888/base/WorkProcessEdit.ihtm?id=1 -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>工序 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doSave(flag) {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				document.getElementById("continue_flag").value = flag;
				frm.submit();
			}

			function doCancel() {
				ClosePop();
			}

			function showMe() {
				showFormErrorMsg();
				document.getElementById("processName").focus();
			}

			function changeStatus() {
				if(document.getElementById("r_status1").checked) {
					document.getElementById("status").value = "Y";
				} else {
					document.getElementById("status").value = "N";
				}
			}
		</script>
	</head>

	<body oncontextmenu="return false" scroll="no" onload="showMe();" class="sheet modal-dialog">
		<div class="sheet-main" id="bodyDiv">
			<form name="frm" method="post">
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
							<h3>编辑工序</h3>
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
							<table border="0" cellspacing="1" cellpadding="1" align="center" class="table-a layui-form">
								<tbody>
									<tr>
										<th><span class="MustInput">*</span>名称：</th>

										<td>
											<input type="text" class="layui-input" style="width: 140px;" maxlength="15" onkeyup="goNextInput(&#39;price&#39;);" id="processName" name="processName" value="铝合金下料">
											<script language="javascript">
												setFormErrorMsg('', 1, 'processName');
											</script>
										</td>

									</tr>
									<tr>
										<th><span class="MustInput">*</span>所属部门：</th>

										<td>
											<div class="layui-inline" style="width:140px">
												<select name="depId" id="depId">
												<option value="0">==请选择==</option>

												<option value="1">易凯管理员</option>
												<option value="13">总经办</option>
												<option value="22">&nbsp;|--财务</option>
												<option value="14">新异店</option>
												<option value="15">&nbsp;|--客服</option>
												<option value="23">&nbsp;|--设计</option>
												<option value="24">&nbsp;|--业务</option>
												<option value="16">业务来源</option>
												<option value="17" selected="">标识加工车间</option>
												<option value="21">合作伙伴</option>
												<option value="32">标识汇运营部</option>
												<option value="33">财务部</option>
											</select>
											<script language="javascript">
												setFormErrorMsg('', 2);
											</script>
											</div>
										</td>

									</tr>
									<tr>
										<th><span class="MustInput">*</span>计件单价：</th>

										<td>
											<input type="text" class="layui-input" style="width: 140px;" maxlength="15" onkeyup="goNextInput(&#39;sequenceCode&#39;);" id="price" name="price" value="0.0000">

										</td>

									</tr>
									<tr>
										<th><span class="MustInput">*</span>状态：</th>
										<td>
											<input type="radio" name="r_status" id="r_status1" value="正常" title="正常" onclick="changeStatus();" checked="">
											<input type="radio" name="r_status" id="r_status2" value="停用" title="停用" onclick="changeStatus();">

											<input type="hidden" name="status" id="status" value="Y">

										</td>
									</tr>
									<tr>
										<th><span class="MustInput">*</span>序号：</th>

										<td>
											<input type="text" class="layui-input" style="width: 140px;" maxlength="15" onkeyup="goNextInput(&#39;&#39;);" id="sequenceCode" name="sequenceCode" value="0">

										</td>

									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
				<div class="modal-buttom" id="buttonDiv">
					<input type="button" class="buttom-a" value="保 存" onclick="doSave(&#39;0&#39;);">
					<input type="button" class="buttom-a" value="保存并新增" onclick="doSave(&#39;1&#39;);">
					<input type="button" class="buttom-a" value="取 消" onclick="doCancel();">
					<input type="hidden" name="continue_flag" id="continue_flag" value="0">
				</div>
				<div class="modal-buttom" id="waitDiv" style="display:none">
					<span style="color:#ffffff">请稍候...</span>
				</div>
			</form>
		</div>
		<script src="layui/layui.all.js"></script>
	</body>

</html>