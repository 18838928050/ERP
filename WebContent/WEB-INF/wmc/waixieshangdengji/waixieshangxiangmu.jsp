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

<table width="60%" cellpadding="0" cellspacing="0" border="1" bordercolor="red" align="center">
	
	<tr height="10%">
		<td>外协日期</td>
		<td>项目类型</td>
		<td>内容</td>
		<td>规格</td>
		<td>制作要求</td>
		<td>单位</td>
		<td>数量</td>
		<td>单价</td>
		<td>金额</td>
	 </tr>
	 
	 <s:iterator value="cooperBillVOs" status="st">
	 <tr>
	 
	 <td>${cooperDate }</td>
		<td><s:iterator value="%{makeTypeVOs[#st.index]}" >
						<s:property value="typeName" /><!-- 材质 -->
					</s:iterator></td>
		<td><s:iterator value="%{cList[#st.index]}" >
						<s:property value="finishedContent" /><!-- 单位 -->
					</s:iterator></td>
		<td><s:iterator value="%{cList[#st.index]}" >
						<s:property value="specification" /><!-- 单位 -->
					</s:iterator></td>
		<td><s:iterator value="%{cList[#st.index]}" >
						<s:property value="makeRequire" /><!-- 单位 -->
					</s:iterator></td>
		<td><s:iterator value="%{cList[#st.index]}" >
						<s:property value="unit" /><!-- 单位 -->
					</s:iterator></td>
			<td><s:iterator value="%{cList[#st.index]}" >
						<s:property value="amount" /><!-- 单位 -->
					</s:iterator></td>
		<td>0.9</td>
		<td><s:iterator value="%{cList[#st.index]}" >
						<s:property value="cost" /><!-- 单位 -->
					</s:iterator></td>
	 </tr>
	 </s:iterator>
	 
</table> 




</body>
</html>