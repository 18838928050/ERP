<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
查看所有外协商


<table width="60%" cellpadding="0" cellspacing="0" border="1" bordercolor="red" align="center">
	
	<tr height="10%">
		<td>外协名称</td>
		<td>联系人</td>
		<td>电话</td>
		<td>地址</td>
		<td>账套</td>
		<td>经办人</td>
		<td>创建日期</td>
		<td>备注</td>
		<td>相关记录</td>
		<td>操作</td>
	 </tr>
	 
	 <s:iterator value="establishmentVOs">
	 <tr>
	 	<td <s:if test='%{status=="N"}'>style="color:red" </s:if>  >${estCode }</td>
		<td <s:if test='%{status=="N"}'>style="color:red" </s:if>  >${estName }</td>
		<td <s:if test='%{status=="N"}'>style="color:red" </s:if>  >${ phone}</td>
		<td <s:if test='%{status=="N"}'>style="color:red" </s:if>  >${address }</td>
		<td <s:if test='%{status=="N"}'>style="color:red" </s:if>  ><s:if test="%{tallySetId==1}">新异</s:if><s:if test="%{tallySetId==2}">网络</s:if>  </td>
		<td <s:if test='%{status=="N"}'>style="color:red" </s:if>  >${ managerName}</td>
		<td <s:if test='%{status=="N"}'>style="color:red" </s:if>  >${createTime }</td>
		<td <s:if test='%{status=="N"}'>style="color:red" </s:if>  >${mark }</td>
		<td <s:if test='%{status=="N"}'>style="color:red" </s:if>  >  <s:a action="waixieshang_waixiexiangmu?establishment.id=%{id}">外协项目</s:a> </td>
		<td <s:if test='%{status=="N"}'>style="color:red" </s:if>  >
		
			
		<s:if test='%{status=="N"}'>  <s:a action="waixieshang_start?establishment.id=%{id}">启用  </s:a>  </s:if>
		<s:if test='%{status=="Y"}'>  <s:a action="waixieshang_stop?establishment.id=%{id}">停用  </s:a> </s:if>
		
		
		 <s:a action="waixieshang_delete?establishment.id=%{id}">删除 </s:a> 
		  <s:a action="waixieshang_update?establishment.id=%{id}">修改 </s:a> 
		</td>
		
	 </tr>
	 </s:iterator>
	 
</table> 



</body>
</html>