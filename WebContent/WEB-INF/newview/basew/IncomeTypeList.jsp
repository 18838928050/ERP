<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>收入类型 | 管理易-广告加工制作管理软件  企业版 9.28  | 易凯软件</title>
<script src="${pageContext.request.contextPath}/jswf/minierp.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
<script src="${pageContext.request.contextPath}/jswf/popup_ext.js"></script>
<script language="javascript">
	function doNew(){
		alert("12");
		var url="incometype_addIncomeTypeUI";
		ShowIframeNoScroll("收入类型",url,2320,2260,"refreshWin()");
	}
	function refreshWin(){
		window.location.reload(true);
	}
	function doEdit(id){
		var url="./IncomeTypeEdit.html?id="+id;
		ShowIframeNoScroll("收入类型",url,320,260,"refreshWin()");
	}
	function doDelete(id){
		ShowConfirm('确认框','确定删除吗？',340,80,"doDelAct("+id+")");
	}
	function doDelAct(id){
		if(popRetVal!=null){
			window.location="./IncomeTypeDelete.html?id="+id;
		}
	}
	function doCancel(){
		window.close();
	}
</script>
</head>
<body oncontextmenu="return false" class="sheet" style="text-align:center;">
<div class="sheet-main" style="width:560px;text-align:left;margin:auto;">
  <div class="sheet-top">
    <div class="content">
      <h2>收入类型</h2>
      <p>设置销售收入之外的收入类型</p>
    </div>
  </div>
  <div class="sheet-list">
    <div class="search-business">
	    <div class="add_content"> 	
	    	 <div align="right">
	    	 <s:a action="incometype_addIncomeTypeUI">新增</s:a>
 	    	 <input class="buttom search-add" value=" 新 增" onclick="doNew();" type="button"></div>
	     </div>
		 
<table width="98%" cellspacing="0" cellpadding="0" border="0">
	<tbody><tr id="errorMsgTr" style="display:none">
	  <td>
	  	<div class="msg-error" id="errorMsgTd">
	  	
	  	</div>
	  </td>
	</tr>
</tbody></table>
	     <div class="table-list">
	        <table width="100%">
	          <tbody><tr>
      				<th width="20%">序号</th>
					<th width="50%">名称</th>
					<th width="30%">操作</th>
				</tr>
				
				
				
				 <s:iterator value="IncomeTypeVOs">
	 <tr>
		<td>${sequenceCode}</td>
		<td>${typeName}</td>
	
		<td>
			<s:a action="incometype_editIncomeTypeUI?incomeType.id=%{id}">编辑</s:a>
			<s:a action="incometype_DeleteIncomeType?incomeType.id=%{id}">删除</s:a>
		</td>
	 </tr>
	 </s:iterator>
				
			</tbody></table>
		   </div>  
	   </div>  
  </div>
 <div class="blank12">
</div>

</div></body></html>