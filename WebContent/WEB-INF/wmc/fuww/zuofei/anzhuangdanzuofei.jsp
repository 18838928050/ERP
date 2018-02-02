<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <%@taglib prefix="s" uri="/struts-tags" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">安装单作废</h1>
<table align="center">
<tr>
<th>安装单号 </th>
<th>派单日期</th>
<th>订货单位</th>
<th>业务单号 </th>
<th>业务单摘要 </th>
<th>安装人员</th>
<th>开单人</th>
<th>状态</th>
<th>操作</th>
</tr>
<s:iterator value="list">
<tr>
<td>${ a}</td>
<td>${b }</td>
<td>${c }</td>
<td>${d }</td>
<td>${e }</td>
<td>${f }</td>
<td>${ g}</td>
<td>${h }</td>
<td><s:a action="anzhuangdanzuofei_zuofei?anzhuangdanzuofeiBean.a=%{a}">作废</s:a>&nbsp;<s:a action="anzhuangdanzuofei_chakan?anzhuangdanzuofeiBean.a=%{a}">查看D</s:a></td>
</tr>
</s:iterator>
</table>
</body>
</html>