<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">业务对账</h1>
<table align="center" border="1" width="80%">
<tr>
<th>编号</th>
<th>名称</th>
<th>联系人</th>
<th>备注</th>
<th>经办人</th>
<th>操作</th>
</tr>
<s:iterator value="establishmentVOs" status="st">
<tr>
<td>${estCode }</td>
<td>${estName}</td>
<td>${linkman }</td>
<td>${mark}</td>
<td>${managerName }</td>
<td><s:a action="yewuduizhang_duizhang?establishmentVO.estCode=%{estCode}">选择</s:a></td>
</tr>

</s:iterator>


</table>
	<form action="yewuduizhang_findAll" method="post">
	
	<a href="${pageContext.request.contextPath}/yewuduizhang_findAll?CurrentPageNum=${fenyeMode.currentPageNum-1}">上一页</a>
	第<span style="color:red">${fenyeMode.currentPageNum}</span>&nbsp;&nbsp;页&nbsp;&nbsp;
	GO第:<span style="color:red"><input type="text" name="CurrentPageNum" value="${fenyeMode.currentPageNum}"  size="2"></span>&nbsp;&nbsp;页&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/yewuduizhang_findAll?CurrentPageNum=${fenyeMode.currentPageNum+1}">下一页</a>
每页显示结果：<input type="text" name="maxNumEveryPage"  size="2">
	<input type="submit" value="提交">
	<br><hr width="90%" color="red">
	每页结果数：<span style="color:red">${fenyeMode.maxNumEveryPage}</span>&nbsp;&nbsp;
	一共多少页：<span style="color:red">${fenyeMode.allPageNum}</span>&nbsp;&nbsp;
	一共多少条结果:<span style="color:red">${fenyeMode.allResultNum}</span>&nbsp;&nbsp;

</form>
</body>
</html>