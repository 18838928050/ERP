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
<h1 align="center">业务单作废查看</h1>
<h5>这个地方有查不出来的是因为department的id是0，数据库不对</h5>
<table align="center">

<s:iterator value="list2">
<tr>
<td>编号</td>
<td>${a }</td>
<td>订货日期</td>
<td>${b }</td>

</tr>
<tr>
<td>客户</td>
<td>${ b}</td>
<td>联系人</td>
<td>${c }</td>
<td>电话</td>
<td>${ d}</td>
<td>合同号</td>
<td></td>
</tr>
</s:iterator>

</table>
<table align="center" border="1" bordercolor="red">
<tr>								
<th>项目类型</th>
<th>内容</th>
<th>材质</th>
<th>规格</th>
<th>制作要求</th>
<th>数量</th>
<th>平方数</th>
<th>单价</th>
<th>金额</th>
<th>外协</th>
<th>安装</th>
</tr>
<tr>
<s:iterator value="list">
<tr>
<td>${f }</td>
<td>${g }</td>
<td>${h }</td>
<td>${ i}</td>
<td>${j }</td>
<td>${k }</td>
<td>${ l}</td>
<td>${m }</td>
<td>${n }</td>
<td>${o }</td>
<td>${p }</td>
</tr>
</s:iterator>


</table>
<table align="center">

<s:iterator value="list2">
<tr>
<td>业务来源：</td>
<td>${q }</td>
<td>安装要求：</td>
<td>${r }</td>
<td>合计金额:</td>
<td></td>
</tr>
<tr>
<td>部门：</td>
<td>${s }</td>
<td>提货要求：</td>
<td>${t }</td>
<td>优惠金额：</td>
<td></td>
</tr>
<tr>
<td>业务员：</td>
<td>${u }</td>
<td>交货日期：</td>
<td>${v }</td>
<td>折后金额：</td>
<td></td>
</tr>
<tr>
<td>跟单员：</td>
<td>${ w}</td>
<td>送货地址：</td>
<td>${ x}</td>
<td>预付款：</td>
<td>${y }</td>
<td>付款方式：</td>
<td>${z }</td>
</tr>
<tr>
<td>设计类型：</td>
<td>公司设计</td>
<td>摘要：</td>
<td>${ aa}</td>
<td>收款账户：	</td>
<td></td>
</tr>
<tr>
<td>设计员：</td>
<td>${w }</td>
<td>备注：	</td>
<td>${ cc}</td>
<td>	结账日期：</td>
<td>${dd }</td>
</tr>
<tr>
<td>开单人：</td>
<td>${ ee}</td><td>${ ff}</td>
<td> 审核人：</td>
<td>${gg }</td><td>${ hh}</td>
<td>单据帐套：</td>
<td>${ii }</td>
</tr>
<tr align="center">
<td><s:a action="yewudanzuofei_zuofei?businessBill.billCode=%{a}">作废</s:a></td>
<td><s:a action="yewudanzuofei_tuichu">退出</s:a></td>
</tr>
</s:iterator>


</table>
</body>
</html>