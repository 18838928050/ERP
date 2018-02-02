<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<h1>安装单完工</h1>
	<hr>
	
	<table>

		<s:iterator value="list">
			<tr>
				<th>安装单号：</th>
				<td>${a }</td>
			</tr>
			<tr>
				<th>派单日期：</th>
				<td>${b}</td>
			</tr>
			<tr>
				<th>业务单号：</th>
				<td>${c }</td>
			</tr>
			<tr>
				<th>客户：</th>
				<td>${d}</td>
			<tr>
				<th>安装人员：</th>
				<td>${e }</td>
			</tr>
			<tr>
				<th>工程金额：：</th>
				<td>${f }</td>
			</tr>


			<tr>
				<td>完工日期：${date}</td>
			</tr>
			<tr>
			<td>
			
			<s:a href="anzhuandanwangong_wangong?setuBillVOO.billCode=%{a}">完工</s:a>
			
			</td>
			</tr>
		</s:iterator>
		
	</table>

</body>

</html>