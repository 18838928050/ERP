<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="s" uri="/struts-tags" %>
<title>其它收入单反审核</title>
</head>
<body>
<table align="center">
<h1 align="center">其它收入反审核</h1>
<s:iterator value="list">
<tr>
<th>编号：</th>
<td>${a }</td>
 <th>日期：</th>
<td>${b}</td>
</tr>
<tr>
<th>付款单位：</th>
<td>${c }</td>
<th>经办人：</th>
<td>${d }</td>
<th>部门：</th>
<td>${e }</td>
</tr>
-----------------------------------------------------------------------------------------
<tr>
<th>收入类型：	</th>
<td>	其它业务收入</td>
<th>银行账号：</th>
<td>${f }</td>
<th>收款金额：</th>
<td>${g }</td>
</tr>
<tr>
<th>摘要：	</th>
<td>${ k}</td>
</tr>
<tr>
<th>凭证：</th>
<td></td>
</tr>
<tr>
<th>开单人：	</th>
<td>${h }</td>
<td>${hh }</td>
<th>审核人：</th>
<td>${i }</td>
<td>${ii }</td>
<th>单据账套：</th>
<td>${j }</td>
</tr>
<tr align="center">
<td>
<s:a action="qitashouruyilanbiao_fanshenhe?qitashourufangshenheBean.a=%{a}">反审核</s:a>
<s:a action="qitashouruyilanbiao_tuichu">退出</s:a></td></tr>
</s:iterator>



</table>
</body>
</html>