<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="s" uri="/struts-tags" %>
<title>Insert title here</title>
</head>
<body>
<h1 align="center" >其它收入一览表</h1>
<table border="1" align="center" bordercolor="red" width="85%">							
<tr>

<td>单号</td>
<td>银行账户</td>
<td>日期	</td>
<td>收入类型	</td>
<td>付款单位</td>
<td>金额（元）</td>
<td>摘要</td>
<td>经办人</td>
<td>开单人</td>
<td>状态</td>
<td>操作</td>
</tr>
<s:iterator value="list">
<tr>
<td>${a }</td>
<td>${b }</td>
<td>${c}</td>
<td>其它业务收入</td>
<td>${d }</td>
<td>${e }</td>
<td>${f }</td>
<td>${g }</td>
<td>${h }</td>

<td>
<s:if test='i.equals("Y")'><s:a action="qitashouruyilanbiao_fanshenhechakan?iBean.a=%{a }">已审核</s:a></s:if>
<s:elseif test='i.equals("N")'><s:a action="qitashouruyilanbiao_shenhechakan?iBean.a=%{a }">未审核</s:a></s:elseif>
</td>
<td>
<s:a action="qitashouruyilanbiao_qitashourudan?iBean.a=%{a}">修改</s:a>

</td>
</tr>
</s:iterator>
</table>
</body>
</html>