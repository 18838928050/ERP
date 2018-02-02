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
<h1>安装单反完工</h1>
<table>
<tr>
<td>安装单号 </td>
<td>派单日期</td>
<td>订货单位</td>
<td>业务单号 </td>
<td>业务摘要 </td>
<td>金额 </td>
<td>计划完工</td>
<td>安装人员</td>
<td>负责人</td>
<td>完工人</td>
<td>操作</td>
</tr>
<s:iterator  value="list">
<tr>
<td>${a}</td>     <!-- <td>安装单号 </td>   -->
<td>${b}</td>     <!-- <td>派单日期</td>    -->
<td>${c}</td>     <!-- <td>订货单位</td>    -->
<td>${d}</td>     <!-- <td>业务单号 </td>   -->
<td>${e}</td>     <!-- <td>业务摘要 </td>   -->
<td>${f}</td>     <!-- <td>金额 </td>       -->
<td>${g}</td>     <!-- <td>计划完工</td>    -->
<td>${h}</td>     <!-- <td>安装人员</td>    -->
<td>${i}</td>     <!-- <td>负责人</td>      -->
<td>${j}</td>     <!-- <td>完工人</td>      -->
<td><s:a action="anzhuandanfanwangong_fanwangong?setuBillVOO.billCode=%{a}"><font color="blue">反完工</font></s:a></td>
</tr>

</s:iterator>


</table>
</body>
</html>