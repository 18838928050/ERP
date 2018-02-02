<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- {pageContext.request.contextPath} -->
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<title>银行账号 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
<script src="${pageContext.request.contextPath}/jswf/minierp.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
<script language="javascript">
	function doSave(flag){
		document.getElementById("buttonDiv").style.display="none";
		document.getElementById("waitDiv").style.display="";
		document.getElementById("continue_flag").value=flag;
		frm.submit();
	}
	function doCancel(){
		parent.ClosePop();
	}
	function showMe(){
		showFormErrorMsg();
		document.getElementById("bankAccount.accountName").focus();
	}
	function changeIsTmp(){
		if(document.getElementById("r_isTmp1").checked){
			document.getElementById("bankAccount.isTmp").value="Y";
		}else{
			document.getElementById("bankAccount.isTmp").value="N";
		}
	}
	function changeStatus(){
		if(document.getElementById("r_status1").checked){
			document.getElementById("bankAccount.status").value="Y";
		}else{
			document.getElementById("bankAccount.status").value="N";
		}
	}
</script>
</head>
<h1></h1>
<body oncontextmenu="return false" onload="showMe();" class="sheet modal-dialog" style="padding-top: 15px;">
	<div class="sheet-main" id="bodyDiv" style="width: 365px;">

		<s:form method="post" action="moneybill_%{bankAccount.id==0?'addBankAccount':'edtiBankAccount'}">
			<input type="hidden" name="bankAccount.id" value="${bankAccount.id}">
			<div class="sheet-list" style="width: 100%">
				<div class="modal-main search-business">
					<div style="width: 100%;">



						<script language="javascript">
	var formErrorIndex=0;
	var formErrorMsg="";
	var formErrorObjId="";
	function setFormErrorMsg(msg,index,objId){
		if(formErrorIndex==0 || formErrorIndex>index){
			if(msg!=null && msg!=""){
				formErrorIndex=index;
				formErrorMsg=msg;
				formErrorObjId=objId;
			}
		}
	}
	function showFormErrorMsg(){
		if(formErrorIndex!=0){
			document.getElementById("errorMsgTr").style.display="";
			document.getElementById("errorMsgDiv").innerHTML=formErrorMsg;
			if(formErrorObjId!=null && formErrorObjId!=""){
				document.getElementById(formErrorObjId).focus();
			}
		}
	}
	function goNextInput(objId){
		var obj=null;
		if(objId!=null && objId!=''){
			obj=document.getElementById(objId);
		}
		if(window.event.keyCode==13){
			if(obj!=null){
				obj.focus();
			}else if(window.doSave){
				doSave();
			}
		}
	}
</script>
						<h3>新增银行账号</h3>
						<table width="96%" border="0" cellpadding="0" cellspacing="0" align="center">
							<tbody>
								<tr id="errorMsgTr" style="display: none">
									<td colspan="2">
										<div class="msg-error" id="errorMsgDiv"></div>
									</td>
								</tr>
							</tbody>
						</table>
						<table border="0" cellspacing="1" cellpadding="1" align="center" class="table-a">
							<tbody>
								<tr>
									<th><span class="MustInput">*</span>开户名：</th>

									<td><s:textfield class="TextBox" style="none" maxlength="" onkeyup="goNextInput(&#39;bankAccount.bankName&#39;);" id="bankAccount.accountName" name="bankAccount.accountName" value="%{bankAccount.accountName}" /> <!-- <input type="text" class="TextBox" maxlength="15" onkeyup="goNextInput(&#39;bankAccount.bankName&#39;);" id="bankAccount.accountName" name="bankAccount.accountName" value=""> -->
										<script language="javascript">
					          	setFormErrorMsg('',2,'bankAccount.accountName');
					          </script></td>

								</tr>
								<tr>
									<th><span class="MustInput">*</span>开户银行：</th>

									<td><s:textfield class="TextBox" maxlength="50" onkeyup="goNextInput(&#39;bankAccount.sequenceCode&#39;);" id="bankAccount.bankName" name="bankAccount.bankName" value="%{bankAccount.bankName}"></s:textfield> <script language="javascript">
					          	setFormErrorMsg('',3,'bankAccount.bankName');
					          </script></td>

								</tr>
								<tr>
									<th><span class="MustInput">*</span>所属帐套：</th>

									<td><s:select list="#{'1':'新异','2':'网络'}" headerValue="新异" id="bankAccount.tallySetId" listKey="key" listValue="value" size="1" name="bankAccount.tallySetId"></s:select> <script language="javascript">
					          	setFormErrorMsg('',4);
					          </script></td>

								</tr>
								<tr>
									<th><span class="MustInput">*</span>现金账户：</th>

									<td><s:radio name="bankAccount.isTmp" list="#{'Y':'是','N':'否'}" listKey="key" listValue="value" /></td>

								</tr>
								<tr>
									<th><span class="MustInput">*</span>状态：</th>
									<td><s:radio name="bankAccount.status" list="#{'Y':'正常','N':'停用'}" listKey="key" listValue="value" /></td>
								</tr>
								<tr>
									<th><span class="MustInput">*</span>序号：</th>

									<td><s:textfield name="bankAccount.sequenceCode" value="%{bankAccount.sequenceCode}" class="TextBox" maxlength="15" onkeyup="goNextInput(&#39;&#39;);" id="bankAccount.sequenceCode"></s:textfield></td>

								</tr>
								<tr>
									<th>账户余额：</th>
									<td><s:textfield readonly="true" name="bankAccount.currentCost" value="%{bankAccount.currentCost}" disabled=""></s:textfield></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="modal-buttom" id="buttonDiv">
				<input type="submit" class="buttom-a" value=" 保 存 "> <input type="submit" class="buttom-a" value="保存并新增" onclick="doSave(&#39;1&#39;);"> <input type="button" class="buttom-a" value=" 取 消 " onclick="doCancel();"> <input type="hidden" name="continue_flag" id="continue_flag"
					value="0">
			</div>
			<div class="modal-buttom" id="waitDiv" style="display: none">
				<span style="color: #ffffff">请稍候...</span>
			</div>
		</s:form>
	</div>

</body>
</html>