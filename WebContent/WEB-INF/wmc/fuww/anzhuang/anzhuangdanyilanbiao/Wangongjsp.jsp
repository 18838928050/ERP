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
<h1>安装单完工</h1>
<table border="1" bordercolor="red">
<tr>
<td>完工日期：</td>
<td>${compTime }</td>
</tr>
<s:iterator value="list">
<tr>
<td>安装单号：</td>
<td>${a }</td>
<td>派单日期：</td>
<td>${b}</td>
<td>业务单号：</td>
<td>${c }</td>
<td>客户：</td>
<td>${d }</td>

<td>安装人员：</td>
<td>${e }</td>
<td>工程金额：</td>
<td>${f }</td>

</tr>
</s:iterator>
<s:iterator value="list">

<tr>
<td><s:a action="anzhuangdanyilanbiaoo_wangongg?fBean.a=%{a}">完工</s:a></td>

</tr>

</s:iterator>

</table>
</body>
</html>