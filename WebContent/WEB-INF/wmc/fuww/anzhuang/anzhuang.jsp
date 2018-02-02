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
<h1 align="center">安装</h1>
<table border="1"  align="center">
<tr>
<td>单号 </td>
<td>订货日期</td>
<td>订货单位</td>
<td>摘要 </td>
<td>交货日期 </td>
<td>安装要求</td>
<td>是否完工</td>
<td>操作</td>
</tr>
<s:iterator  value="list">
<tr>
<td>${a}</td>  <!-- <td>单号 </td>     -->
<td>${b}</td>  <!-- <td>订货日期</td>  -->
<td>${c}</td>  <!-- <td>订货单位</td>  -->
<td>${d}</td>  <!-- <td>摘要 </td>     -->
<td>${f}</td>  <!-- <td>交货日期 </td> -->
<td>${e}</td> <!-- <td>安装要求</td>  -->
<td>
<s:if test='g.equals("Y")'>已完工</s:if>
<s:elseif test='g.equals("N")'>未完工</s:elseif>
</td><!-- 自己加的字段，是否完工 -->
      
<td><s:a action="anzhuang_chakan?chakanyewudanBean.a=%{a}">查看</s:a>&nbsp;
<s:a action="anzhuang_kaianzhuangdan?chakanyewudanBean.a=%{a}">开安装单</s:a></td>
</tr>
</s:iterator>


</table>
</body>
</html>