<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- {pageContext.request.contextPath} -->
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>this title</title>
</head>
<body>
上传文件一览表
<table width="60%" cellpadding="0" cellspacing="0" border="1" bordercolor="red" align="center">
		<tr height="10%">
			<td>时间</td>
			<td>人</td>
			<td>文件</td>
			<td>资料</td>
			<td>说明</td>
			<td>中心</td>
			<td>单号</td>
			<td>单位</td>
			<td>设计</td>
			<td>操作</td>
			
		</tr>
		<s:iterator value="accessoryVOs" status="st">
			<tr>
				<td>${createTime}</td>

				<td>${createrName}</td>
					<td>${sourceName}</td>
				<td>资料</td>
			<td>说明</td>
			
			
				<td><s:property value="%{workCenterVOs[#st.index].wcName}" /></td>
				<td><s:property value="%{businessBillVOs[#st.index].billCode}" /></td>
				<td><s:property value="%{establishmentVOs[#st.index].estName}" /></td>
				<td><s:property value="%{businessBillVOs[#st.index].designerNameStr}" /></td>
				<td><s:a action="">查看也是下载</s:a>
				<s:a action="">下载</s:a>
				</td>
			</tr>
		</s:iterator>
	</table>



</body>
</html>