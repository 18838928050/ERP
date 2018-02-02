<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
产值审核反反单审核



<table width="60%" cellpadding="0" cellspacing="0" border="1" bordercolor="red" align="center">
		<tr height="10%">
			<td>单号</td>
			<td>日期</td>
			<td>金额</td>
			<td>摘要</td>
			<td>经办人</td>
			<td>部门</td>
			<td>操作</td>
		</tr>
		<s:iterator value="ovBillVOs" status="st">
			<tr>
				<td>${billCode}</td>

				<td>${outDate}</td>
				<td>${cost}</td>
				<td>${description}</td>
				<td>${mark}</td>
				<td>${stafferName}</td>
				
				<td>业务</td>
				<td>
				<s:a action="chanzhi_fanshenhe?ovBillVO.id=%{id}">反审核</s:a>
 				</td>
				
				
				
			</tr>
		</s:iterator>
	</table>



</body>
</html>