<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ${pageContext.request.contextPath} -->
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>银行账号 | 管理易-广告加工制作管理软件  企业版 9.28  | 易凯软件</title>
<script src="${pageContext.request.contextPath}/js/minierp.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
<script src="${pageContext.request.contextPath}/js/popup_ext.js"></script>
<script language="javascript">
	function doNew(){
		var url="./BankAccountNew.html";
		ShowIframeNoScroll("银行账号",url,400,370,"refreshWin()");
	}
	function refreshWin(){
		window.location.reload(true);
	}
	function doEdit(id){
		var url="./BankAccountEdit.html?id="+id;
		ShowIframeNoScroll("银行账号",url,400,370,"refreshWin()");
	}
	function doDelete(id){
		ShowConfirm('确认框','确定删除吗？',340,80,"doDelAct("+id+")");
	}
	function doDelAct(id){
		if(popRetVal!=null){
			var fromUrl=getFromUrl();
			window.location="./BankAccountDelete.html?id="+id+"&from_url="+fromUrl;
		}
	}
	function doPause(id,flag){
		var fromUrl=getFromUrl();
		window.location="./BankAccountPause.html?id="+id+"&flag="+flag+"&from_url="+fromUrl;
	}
	function getFromUrl(){
		var fromUrl="./BankAccountList.html";
		return encodeURIComponent(fromUrl);
	}
	function doCancel(){
		window.close();
	}
</script>
</head>
<body oncontextmenu="return false" class="sheet" style="text-align:center;">
<div class="sheet-main" style="width:860px;text-align:left;margin:auto;">
  <div class="sheet-top">
    <div class="content">
      <h2>银行账户</h2>
      <p>设置资金收付的账户</p>
    </div>
  </div>
  <div class="sheet-list">
    <div class="search-business">
      <div class="add_content">
          <div align="right">
          
          	<%-- <s:a action="moneybill_addBankAccountUI">新增</s:a> --%>
          	<a href="moneybill_addBankAccountUI" target="_self">新增</a>
			<!-- <input type="button" class="buttom search-add" value=" 新 增" onclick="doNew();">   -->												         
			</div>
      </div>
	     
<table width="98%" border="0" cellpadding="0" cellspacing="0">
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
						<th width="6%">序号</th>
						<th width="16%">开户名</th>
						<th width="20%">开户银行</th>
						<th width="12%">所属帐套</th>
						<th width="10%">现金账户</th>
						<th width="16%">账户余额</th>
						<th width="6%">状态</th>
						<th width="14%">操作</th>
					</tr>
					
					<s:iterator value="bankAccountVOs">
		
			
	
			<tr >
				<td <s:if test='%{status=="N"}'>style="color:red" </s:if> >${sequenceCode }</td>
				<td <s:if test='%{status=="N"}'>style="color:red" </s:if>>${accountName}</td>
				<td <s:if test='%{status=="N"}'>style="color:red" </s:if>> ${bankName }</td>
				<td <s:if test='%{status=="N"}'>style="color:red" </s:if>><s:if test="%{tallySetId==1}">新异</s:if> <s:if test="%{tallySetId==2}">网络公司</s:if>
				<td <s:if test='%{status=="N"}'>style="color:red" </s:if>><s:if test='%{isTmp=="Y"}'>是</s:if><s:if test='%{isTmp=="N"}'>否</s:if></td>
				<td <s:if test='%{status=="N"}'>style="color:red" </s:if>>${currentCost }</td>
				<td <s:if test='%{status=="N"}'>style="color:red" </s:if>><s:if test='%{status=="Y"}'>正常</s:if> <s:if test='%{status=="N"}'>暂停</s:if></td>
				<td <s:if test='%{status=="N"}'>style="color:red" </s:if>>
				
				<s:a action="moneybill_edtiBankAccountUI?bankAccount.id=%{id}">编辑</s:a> 
				<s:if test='%{status=="Y"}'>
						<s:a action="moneybill_StopBankAccount?bankAccount.id=%{id}&bankAccount.str=1">停用</s:a>
					</s:if> 
					<s:if test='%{status=="N"}'>
						<s:a action="moneybill_StopBankAccount?bankAccount.id=%{id}&bankAccount.str=2">启用</s:a>
					</s:if>
					
					 <s:a action="moneybill_DeleteBankAccount?bankAccount.id=%{id}">删除</s:a></td>
			</tr>
		</s:iterator>
		
		
				</tbody></table>
				
				<form action="moneybill_BankAccountUI" method="post">
	
	<a href="${pageContext.request.contextPath}/moneybill_BankAccountUI?CurrentPageNum=${fenyeMode.currentPageNum-1}">上一页</a>
	第<span style="color:red">${fenyeMode.currentPageNum}</span>&nbsp;&nbsp;页&nbsp;&nbsp;
	GO第:<span style="color:red"><input type="text" name="CurrentPageNum" value="${fenyeMode.currentPageNum}"  size="2"></span>&nbsp;&nbsp;页&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/moneybill_BankAccountUI?CurrentPageNum=${fenyeMode.currentPageNum+1}">下一页</a>
每页显示结果：<input type="text" name="maxNumEveryPage"  size="2">
	<input type="submit" value="提交">
	每页结果数：<span style="color:red">${fenyeMode.maxNumEveryPage}</span>&nbsp;&nbsp;
	一共多少页：<span style="color:red">${fenyeMode.allPageNum}</span>&nbsp;&nbsp;
	一共多少条结果:<span style="color:red">${fenyeMode.allResultNum}</span>&nbsp;&nbsp;

</form>
      </div>     
    </div>
  </div>
 <div class="blank12">
</div>

</div><audio controls="controls" style="display: none;"></audio></body><style type="text/css">#yddContainer{display:block;font-family:Microsoft YaHei;position:relative;width:100%;height:100%;top:-4px;left:-4px;font-size:12px;border:1px solid}#yddTop{display:block;height:22px}#yddTopBorderlr{display:block;position:static;height:17px;padding:2px 28px;line-height:17px;font-size:12px;color:#5079bb;font-weight:bold;border-style:none solid;border-width:1px}#yddTopBorderlr .ydd-sp{position:absolute;top:2px;height:0;overflow:hidden}.ydd-icon{left:5px;width:17px;padding:0px 0px 0px 0px;padding-top:17px;background-position:-16px -44px}.ydd-close{right:5px;width:16px;padding-top:16px;background-position:left -44px}#yddKeyTitle{float:left;text-decoration:none}#yddMiddle{display:block;margin-bottom:10px}.ydd-tabs{display:block;margin:5px 0;padding:0 5px;height:18px;border-bottom:1px solid}.ydd-tab{display:block;float:left;height:18px;margin:0 5px -1px 0;padding:0 4px;line-height:18px;border:1px solid;border-bottom:none}.ydd-trans-container{display:block;line-height:160%}.ydd-trans-container a{text-decoration:none;}#yddBottom{position:absolute;bottom:0;left:0;width:100%;height:22px;line-height:22px;overflow:hidden;background-position:left -22px}.ydd-padding010{padding:0 10px}#yddWrapper{color:#252525;z-index:10001;background:url(chrome-extension://eopjamdnofihpioajgfdikhhbobonhbb/ab20.png);}#yddContainer{background:#fff;border-color:#4b7598}#yddTopBorderlr{border-color:#f0f8fc}#yddWrapper .ydd-sp{background-image:url(chrome-extension://eopjamdnofihpioajgfdikhhbobonhbb/ydd-sprite.png)}#yddWrapper a,#yddWrapper a:hover,#yddWrapper a:visited{color:#50799b}#yddWrapper .ydd-tabs{color:#959595}.ydd-tabs,.ydd-tab{background:#fff;border-color:#d5e7f3}#yddBottom{color:#363636}#yddWrapper{min-width:250px;max-width:400px;}</style></html>