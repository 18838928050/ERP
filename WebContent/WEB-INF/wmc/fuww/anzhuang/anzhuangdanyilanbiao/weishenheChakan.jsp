<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>安装单审核</title>
</head>
<body>
<h1 align="center">安装单审核</h1>
	<hr color="red">
	<!-- 第一个Table -->
	<table >
		<s:iterator value="list2">
			<tr>
				<td>编号</td>
				<td>${a }
			</tr>
			<tr>
				<td>派单日期：</td>
				<td>${b }</td>
			</tr>
			
			<tr>
				<th>订货单位：</th>
				<td>${c }  
				<th>联系人：</th>
				<td>${d}</td>
				<th>电话：</th>
				<td>${e }</td>
				<th>业务单号:</th>
				<td>${f }</td>
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
				<td>${g }</td>
				<td>${h }</td>
				<td>${i}</td>
				<td>${j }</td>
				<td>${k }</td>
				<td>${l }</td>
				<td>${l }</td>
				<td>${n }</td>
			</tr>
		</s:iterator>
	</table>
	<hr color="red">
	<!-- 第三个Table -->
	<table  >
	<s:iterator value="list2">
			<tr>
				<td>安装人员：</td>
				<td>${o }
			
				<td>安装地址：	</td>
				<td>${p }</td>
		
				<td>工程金额：</td>
				<td>${q }</td>
			</tr>
			<tr>
				<th>安装负责人：	</th>
				<td>${r }</td>
				<th>计划完工：</th>
				<td>${b}</td>
				<th>余额：</th>
				<td>${t}</td>
			</tr>
				<tr>
				<th>安装配备	：</th>
				<td>
				<s:if test='u.equals("Y")'>配车</s:if><s:elseif test='u.equals("Y")'></s:elseif>
				<s:if test='uu.equals("Y")'>高空作业</s:if><s:elseif test='u.equals("Y")'></s:elseif>
				<s:if test='uuu.equals("Y")'>焊接作业</s:if><s:elseif test='u.equals("Y")'></s:elseif>
				<s:if test='uuuu.equals("Y")'>焊接作业</s:if><s:elseif test='u.equals("Y")'></s:elseif>
				
								</td>
				<th>图样	</th>
				<td>
				
				</td>
			</tr>
			<tr>
			<th>安装要求：</th>
			<td>${rr }</td>
			</tr>
			<tr>
			<th>备注：</th>
			<td>${n }</td>
			</tr>
		</s:iterator>
	</table>
	
	<!-- 第四个table -->
	<hr color="red">
	<table>
	<s:iterator value="list2">
	<tr>
	<th>开单人：</th>
	<td>${w } &nbsp;${x }</td>
	<th>审核人：</th>
	<td>${y }&nbsp;${z }</td>
		
	<th>单据账套：</th> 
	<td>${tallySet }</td>
	</tr>
	<tr>
	<td><s:a href="anzhuangdanyilanbiaoo_examined2?anAzhuangdanchakanBean.a=%{a}">审核通过</s:a></td>
	<td>	<s:a href="anzhuangdanyilanbiaoo_tuichu">退出</s:a></td>
	</tr>
	
	</s:iterator>
	</table>
	<table align="center">
	<tr>
	<td>

	
	</td>
	
	</tr>
	
	</table>
	
</body>

</html>