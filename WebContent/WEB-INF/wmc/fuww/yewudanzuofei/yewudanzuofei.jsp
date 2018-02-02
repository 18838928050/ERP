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
<h1 align="center">业务单作废</h1>
<table align="center">
<tr>
<th>单号	</th>
<th>订货日期	</th>
<th>订货单位</th>
<th>摘要</th>
<th>交货日期</th>
<th>业务员</th>
<th>状态</th>
<th>操作</th>
</tr>

<s:iterator value="list">
<tr>
<td>${a }</td>
<td>${b }</td>
<td>${c }</td>
<td>${d }</td>
<td>${e }</td>
<td>${f }</td>
<td>${g }</td>
<td><s:a action="yewudanzuofei_zuofei?businessBill.billCode=%{a}">作废</s:a>
<s:a><s:a action="yewudanzuofei_chakan?businessBill.billCode=%{a}">查看</s:a></s:a>
<s:a>关联数据</s:a>


</td>
</tr>
</s:iterator>
</table>
</body>
</html>