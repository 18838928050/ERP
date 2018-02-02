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
	<h1 align="center">开安装单</h1>
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
	<table border="2" bordercolor="blue">
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
	<table>
		<s:iterator value="list2">
			<tr>
				<td>安装人员</td>
				<td><input type="text" name=""></td>

				<td>安装地址：</td>
				<td><input type="text" name=""></td>

				<td>工程金额：</td>
				<td>${o }</td>
			</tr>
			<tr>
				<th>安装负责人：</th>
				<td>${p }</td>
				<th>计划完工：</th>
				<td>${q }</td>
				<th>余额：</th>
				<td>${r }</td>
			</tr>
			<tr>
				<th>安装配备：</th>
				<td>需要配车：<input type="checkbox" name="needCar" value="c">
				</td>
				<td>高空作业：<input type="checkbox" name="needCar" value="c"></td>
				<td>焊接作业：<input type="checkbox" name="needCar" value="c"></td>
				<td>不锈钢：<input type="checkbox" name="needCar" value="c"></td>
			</tr>
			<tr>
				<td>图样：</td>
				<td>安装要求：
				<td><input type="text" name=""></td>
				<td>备注：<input type="text" name=""></td>
			</tr>
		</s:iterator>
	</table>
	<form action="wangongtu_"></form>
	<!-- 第四个table -->
	<hr color="red">
	<table>
		<s:iterator value="list2">
			<tr>
				<th>开单人：</th>
				<td>${v }&nbsp;${w }</td>
				<th>审核人：</th>
				<td>${x }&nbsp;${y }</td>
				<th>账套：</th>
				<td>${tallySet }</td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>