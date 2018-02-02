<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>this title</title>
</head>
<body>
${pList }
<table>
<tr>
								<th>材料编号</th>
								<th>品名规格</th>
								<th>单位</th>
								<th>数量</th>
								<th>单价</th>
								<th>金额</th>
								<th>当前库存</th>
								<th>操作</th>
							</tr>
<s:iterator value="pList">
							<tr>
							<td>${a}</td>
							<td>${b}</td>
							<td>${c}</td>
							<td>${d}</td>
							<td>${e}</td>
							<td>${f}</td>
							<td>0</td>
							</tr>
							</s:iterator>

</table>
</body>
</html>