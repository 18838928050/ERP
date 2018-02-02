<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">安装单作废</h1>
	<hr color="red">
	<!-- 第一个Table -->
	<table>
		<s:iterator value="list2">
			<tr>
				<td>编号</td>
				<td>${a }
			</tr>
			<tr>
				<td>派单日期</td>
				<td>${b }</td>
			</tr>
			<tr>
				<th>订货单位：</th>
				<td>${c }</td>
				<th>联系人：</th>
				<td>${d }</td>
				<th>电话：</th>
				<td>${e }</td>
				<th>业务单号:</th>
				<td>${f }</td>
			</tr>
			<tr>
			</tr>
		</s:iterator>
	</table>

	<!-- 第二个Table -->
	<hr color="red">
	<table border="2" bordercolor="blue" align="center">
		<tr>
			<th>项目类型</th>
			<th>内容</th>
			<th>材质</th>
			<th>规格</th>
			<th>制作要求</th>
			<th>订货数量</th>
			<th>本次安装</th>
			<th>备注</th>
		</tr>
		<s:iterator value="list">
			<tr>
				<td>${z }</td>
				<td>${g }</td>
				<td>${h}</td>
				<td>${i }</td>
				<td>${j }</td>
				<td>${k }</td>
				<td>${k }</td>
				<td>${l }</td>
			</tr>
		</s:iterator>
	</table>
	<hr color="red">
	<!-- 第三个Table -->
	<table >
	<s:iterator value="list2">
			<tr>
				<td>安装人员</td>
				<td>${m }
			
				<td>安装地址：	</td>
				<td>${n }</td>
		
				<td>工程金额：</td>
				<td>${o }</td>
			</tr>
			<tr>
				<th>安装负责人：	</th>
				<td>${p }</td>
				<th>计划完工：</th>
				<td>${q }</td>
				<th>余额：</th>
				<td>${r }</td>
			</tr>
				<tr>
				<th>安装配备：	</th>
				<td>
					<s:if test='s.equals("Y")'>需要配车</s:if>
				<s:elseif test='s.equals("N")'>不需要配车</s:elseif>
				</td>
				<th>图样	</th>
				<td>
				一定要弄出来
				</td>
				<th>安装要求：	</th>
				<td>
		${t }
				</td>
				<th>备注	:</th>
				<td>
				${u }
				</td>
			</tr>
		</s:iterator>
	</table>
	
	<!-- 第四个table -->
	<hr color="red">
	<table align="center">
	<s:iterator value="list2">
	<tr>
	<th>开单人：</th>
	<td>${v } &nbsp;${w }</td>
	<th>审核人：</th>
	<td>${x }&nbsp;${y }</td>
	<th>单据账套：</th>
	<td>${tallySet }</td>
	</tr>
	<tr align="center">
<td><s:a action="anzhuangdanzuofei_zuofei?anzhuangdanzuofeiBean.a=%{a}">作废</s:a></td>
<td><s:a action="anzhuangdanzuofei_tuichu">退出</s:a></td>


</tr>
	</s:iterator>
	</table>
</body>
</html>