<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ${pageContext.request.contextPath} -->
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title></title>
		<!-- Bootstrap -->
		<link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/bootstrap-table.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
		<link href="${pageContext.request.contextPath}/css/Query.css" rel="stylesheet" type="text/css">

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>

	<body class="sheet">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>费用单审核</h2>
					<div class="pull-right">
						<input type="text" class="TextBox" id="search_key" name="search_key" onkeyup="checkSearchKey();" value="" title="以供应商名称、供应商拼音字头、摘要、采购单号进行模糊查询">
						<select name="ts_id" id="ts_id">
							<option value="0">==请选择账套==</option>

							<option value="1" selected="">新异</option>

							<option value="2">网络公司</option>

						</select>
						<a type="button" class="buttom btn btn-default" href="#">查 询</a>
						<a type="button" class="buttom btn btn-default" href="#">审核通过</a>
					</div>
				</div>
			</div>
			<div class="sheet-list">
				<div class="search-business">
					<div class="blank24"></div>
					<table data-toggle="table" data-click-to-select="true">
						<thead>
							<tr>
						
								<th data-field="state" data-checkbox="true"></th>
								<th>单号</th>
								<th>日期</th>
								<th>收款单位</th>
								<th>金额</th>
								<th>摘要</th>
								<th>经办人</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
						<s:iterator value="feeBillVOs" status="st">
			<tr>
			<td></td>
				<td>${billCode}</td>

				<td>${feeDate}</td>
				<td>${receiverName }</td>
				

				<td>${cost}</td>
				<td>${mark}</td>
				<td>${managerName}</td>
				<td><s:a action="feebillshenhe_ExaminedTongGuo?feeBillVO.id=%{id}">审核通过</s:a>&nbsp;&nbsp;<s:a action="feebillshenhe_ChaZhaoByPayBillId?feeBillVO.id=%{id}">查看</s:a></td>
			</tr>
		</s:iterator>
						</tbody>
						
					</table>
		
					<!-- 底栏 分页、操作等 -->
					<div class="BottomToolBar ClearFix">
								<form action="feebillshenhe_findAll" method="post">
	
	<a href="${pageContext.request.contextPath}/feebillshenhe_findAll?CurrentPageNum=${fenyeMode.currentPageNum-1}">上一页</a>
	第<span style="color:red">${fenyeMode.currentPageNum}</span>&nbsp;&nbsp;页&nbsp;&nbsp;
	GO第:<span style="color:red"><input type="text" name="CurrentPageNum" value="${fenyeMode.currentPageNum}"  size="2"></span>&nbsp;&nbsp;页&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/feebillshenhe_findAll?CurrentPageNum=${fenyeMode.currentPageNum+1}">下一页</a>
每页显示结果：<input type="text" name="maxNumEveryPage"  size="2">
	<input type="submit" value="提交">
	每页结果数：<span style="color:red">${fenyeMode.maxNumEveryPage}</span>&nbsp;&nbsp;
	一共多少页：<span style="color:red">${fenyeMode.allPageNum}</span>&nbsp;&nbsp;
	一共多少条结果:<span style="color:red">${fenyeMode.allResultNum}</span>&nbsp;&nbsp;

</form>
						<div class="pull-right">
							<a  type="button" class="buttom btn btn-default" style="width: 100px;" href="#">返回主菜单</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${pageContext.request.contextPath}/jswf/jquery-3.0.0.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/jswf/bootstrap-table.js"></script>
		<script src="${pageContext.request.contextPath}/jswf/bootstrap-table-zh-CN.min.js"></script>
	</body>

</html>