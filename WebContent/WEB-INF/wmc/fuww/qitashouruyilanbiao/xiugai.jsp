<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<title>其它收入单</title>
</head>
<body>
<table align="center">
<h1 align="center">其它收入单</h1>
<s:iterator value="list">
<tr>
<th>编号：</th>
<td>${a }</td>
 <th>日期：</th>
<td>${b}</td>
</tr>
<tr>
<th>付款单位：</th>
<td><input type="text" value='${c }'></td>
<th>经办人：</th>
<td><input type="text" value='${d }'></td>
<td>
<s:select label="部门" list="list2"  listKey="id" listValue="departmentName"  value="%{e}"  headerKey="请选择部门" name="department"></s:select>
</td>
</tr>
<tr>
<th>收入类型：	</th>
<td>	其它业务收入</td>
<td><s:select label="收款账户" list="list3" value="现金(黄秀娟(5165))"   listKey="id" listValue="bankName+'('+accountName+')'"  headerKey="请选择" name="bankName"></s:select></td>
<th>收款金额：</th>
<td>${g }</td>
</tr>
<tr>
<th>摘要：	</th>
<td><s:textarea value="%{k}" rows="5" cols="20"  title="mark"></s:textarea></td>
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
<s:a action="">打印</s:a>
<s:a action="">保存</s:a></td></tr>
</s:iterator>



</table>
</body>
</html>