<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">郑州市新异标识标牌有限公司 业务对账单</h1>
</body>
<table align="center" width="80%" border="1" bordercolor="red">
<tr>
<td>日期</td>
<td>单号</td>
<td>项目类型</td>
<td>内容</td>
<td>材质</td>
<td>规格</td>
<td>单位</td>
<td>数量</td>
<td>单价</td>
<td>金额</td>
<td>制作要求</td>
<td>部门/经手人</td>
</tr>
<s:iterator value="list">
<tr>
<td>${a }</td>
<td>${b }</td>
<td>${c }</td>
<td>${d }</td>
<td>${e }</td>
<td>${f }</td>
<td>${g}</td>
<td>${h }</td>
<td>${i }</td>
<td>${j }</td>
<td>${k }</td>
<td>${l}</td>
</tr>
</s:iterator>



</table>
</html>