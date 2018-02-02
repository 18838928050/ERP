<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@taglib prefix="s" uri="/struts-tags" %>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查看业务单</title>
</head>
<body>
<h1 align="center">查看业务单</h1>
	<hr color="red">
	<!-- 第一个Table -->
	<table >
		<s:iterator value="list">
			<tr>
				<td>编号</td>
				<td>${a }
			</tr>
			<tr>
				<td>订货日期：</td>
				<td>${b }</td>
			</tr>
			<tr>
				<th>客户：</th>
				<td>${c }  &nbsp;${d }</td>
				<th>联系人：</th>
				<td>${e}</td>
				<th>电话：</th>
				<td>${f }</td>
				<th>合同号:</th>
				<td>${g }</td>
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
			<th>数量</th>
			<th>外协</th>
			<th>工作中心</th>
			<th>完工状态</th>
		</tr>
		<s:iterator value="list2">
			<tr>
				<td>${h }</td>
				<td>${i }</td>
				<td>${j}</td>
				<td>${k }</td>
				<td>${l }</td>
				<td>${m }</td>
				<td>
				<s:if test="n=='N'">否</s:if>
				<s:elseif test="n=='Y'">是</s:elseif>
				</td>
				<td>${o }</td>
				<td>
				<s:if test='p.equals("N")'>自制未完</s:if>
				<s:elseif test='p.equals("Y")'>自制已完</s:elseif><br>
				<s:if test='pp.equals("N")'>外协未完</s:if>
				<s:elseif test='pp.equals("Y")'>外协已完</s:elseif>
			    </td>
			</tr>
		</s:iterator>
	</table>
	<hr color="red">
	<!-- 第三个Table -->
	<table  >
	<s:iterator value="list">
			<tr>
				<td>部门：</td>
				<td>${q }
			
				<td>安装要求：	</td>
				<td>${r }</td>
		
				<td>摘要：</td>
				<td>${s }</td>
			</tr>
			<tr>
				<th>业务员：	</th>
				<td>${t }</td>
				<th>提货要求：</th>
				<td>${u }</td>
				<th>备注：</th>
				<td>${v}</td>
			</tr>
				<tr>
				<th>设计员	</th>
				<td>
					${w }
				</td>
				<th>交货日期	</th>
				<td>
				${x }
				</td>
			</tr>
		</s:iterator>
	</table>
	
	<!-- 第四个table -->
	<hr color="red">
	<table>
	<s:iterator value="list">
	<tr>
	<th>开单人：</th>
	<td>${y } &nbsp;${z }</td>
	<th>审核人：</th>
	<td>${aa }&nbsp;${bb }</td>
		<th>修改人：</th>
	<td>${cc }&nbsp;${dd }</td>
	<th>单据账套：</th>
	<td>${tallySet }</td>
	</tr>
	</s:iterator>
	</table>
	<table align="center">
	<tr>
	<td>
	
	<s:a href="anzhuang_tuichu">退出</s:a>
	
	</td>
	
	</tr>
	
	</table>
	
</body>

</html>