<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>安装单审核</title>
</head>
<body>
<h1>安装单审核</h1>

<table align="center">
<tr>
<td>安装单号 </td>
<td>排单日期</td>
<td>订货单位</td>
<td>业务单号 </td>
<td>业务单摘要 </td>
<td>安装人员</td>
<td>开单人</td>
<td>操作</td>
</tr>
<s:iterator value="list">
<tr>
<td>${a}</td>
<td>${b}</td>
<td>${c}</td>
<td>${d}</td>
<td>${e}</td>
<td>${f}</td>
<td>${g}</td>
<td><s:a action="anzhuagndanshenhe_examined?anzhuangBean.a=%{a }">审核通过</s:a>&nbsp;<s:a action="anzhuagndanshenhe_chakan?anAzhuangdanchakanBean.a=%{a}">查看</s:a></td>
</tr>
</s:iterator>


<tr>


</tr>


</table>

</body>
</html>