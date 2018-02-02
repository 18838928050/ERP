<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ${pageContext.request.contextPath} -->
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>费用类型 | 管理易-广告加工制作管理软件  企业版 9.28  | 易凯软件</title>
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
		document.getElementById("typeName").focus();
	}
</script>
</head>
<body oncontextmenu="return false" onload="showMe();" class="sheet modal-dialog" style=" padding-top:15px;">
<div class="sheet-main" id="bodyDiv" style="width:290px;">
<s:form action="feetype_%{feeType.id==0?'addFeeType':'editFeeType'}" method="post">
<s:hidden name="feeType.id" value="%{feeType.id}"></s:hidden>
	  <div class="sheet-list" style="width:100%">
	    <div class="modal-main search-business">
	    	<div style="width:100%;">
				
				
				
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
<h3>新增费用类型${pageContext.request.contextPath }</h3>
<table width="96%" border="0" cellpadding="0" cellspacing="0" align="center">
	<tbody><tr id="errorMsgTr" style="display:none">
	  <td colspan="2">
	  	<div class="msg-error" id="errorMsgDiv">
      	
      	</div>
	  </td>
	</tr>
</tbody></table> 
				<table border="0" cellspacing="1" cellpadding="1" align="center" class="table-a">
					<tbody><tr>
				      	<th><span class="MustInput">*</span>名称：</th>
				      	
				      	<td>
				      		<s:textfield label="名称" name="feeType.typeName" value="%{feeType.typeName}"  class="TextBox" maxlength="15" onkeyup="goNextInput(&#39;sequenceCode&#39;);" id="typeName"  />
				      		<!-- <input type="text" class="TextBox" maxlength="15" onkeyup="goNextInput(&#39;sequenceCode&#39;);" id="typeName" name="typeName" value=""> -->
							  <script language="javascript">
								setFormErrorMsg('',1,'typeName');
							  </script>
				     	</td>
				     	
					</tr>
					<tr>
				      	<th><span class="MustInput">*</span>序号：</th>
				      	
				      	<td>
				      	<s:textfield label="序号" name="feeType.sequenceCode" value="%{feeType.sequenceCode}" class="TextBox" maxlength="15" onkeyup="goNextInput(&#39;&#39;);" id="sequenceCode"></s:textfield>
				      		<!-- <input type="text" class="TextBox" maxlength="15" onkeyup="goNextInput(&#39;&#39;);" id="sequenceCode" name="sequenceCode" value="12"> -->
							
				     	</td>
				     	
					</tr>
				</tbody></table>
			</div>
	  	</div>
	  </div>
		<div class="modal-buttom" id="buttonDiv">
			<s:submit value="保存"  class="buttom-a"></s:submit>
			<!-- <input type="button" class="buttom-a" value=" 保 存 " onclick="doSave(&#39;0&#39;);"> -->
			<input type="button" class="buttom-a" value="保存并新增" onclick="doSave(&#39;1&#39;);">
			<input type="button" class="buttom-a" value=" 取 消 " onclick="doCancel();">
			<input type="hidden" name="continue_flag" id="continue_flag" value="0">
		</div>
		<div class="modal-buttom" id="waitDiv" style="display:none">
			<span style="color:#ffffff">请稍候...</span>
		</div>
			</s:form>
</div>		

</body></html>