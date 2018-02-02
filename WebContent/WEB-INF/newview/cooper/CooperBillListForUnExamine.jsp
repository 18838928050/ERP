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
					<h2><s:if test="%{isCheck==1}">外协审核单</s:if>
						<s:if test="%{isCheck!=1}">外协反审核单</s:if></h2>
					<div class="pull-right">
						<input type="text" class="TextBox" id="search_key" name="search_key" onkeyup="checkSearchKey();" style="width:100px" value="" title="以外协单位名称、外协单位拼音字头、摘要、外协单号进行模糊查询">
						<input type="hidden" id="hid_search_key" name="hid_search_key" value="">
						<select name="ts_id" id="ts_id">
							<option value="0">==请选择账套==</option>

							<option value="1">新异</option>

							<option value="2" selected="">网络公司</option>

						</select>
						<a type="button" class="buttom btn btn-default" href="#">查 询</a>
						<s:if test="%{isCheck==1}"><a type="button" class="buttom btn btn-default" href="#">审核</a></s:if>
						<s:if test="%{isCheck!=1}"><a type="button" class="buttom btn btn-default" href="#">反审核</a></s:if>
						
						
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
								<th>外协日期</th>
								<th>外协单位</th>
								<th>摘要</th>
								<th>交货日期</th>
								<th>业务员</th>
								<th>操作</th>
							</tr>
						</thead>
						 <s:iterator value="pageVO.resultlist">
	 <tr>
	 <td>${billCode }</td>
		<td>${billCode }</td>
		<td>${cooperDate}</td>
		<td>${estName}</td>
		<td>${content }</td>
		<td>${gatherDate }</td>
		<td>${ managerName}</td>
		<td>
		<s:if test="%{isCheck==1}">
		<s:a action="CooperAgaincheck_isCheckOrNo?cooperBillVO.id=%{id}">审核</s:a><s:a action="CooperAgaincheck_listUIDetailByBillCode?cooperBillVO.billCode=%{billCode}&cooperBillVO.id=%{id}">查看</s:a></s:if>
		
		<s:if test="%{isCheck!=1 }">
			<s:a action="CooperAgaincheck_isCheckOrNo?cooperBillVO.id=%{id}">反审核</s:a><s:a action="CooperAgaincheck_listUIDetailByBillCode?cooperBillVO.billCode=%{billCode}&cooperBillVO.id=%{id}">查看</s:a></s:if></td>
	 
	 </tr>
	 </s:iterator>
	 
	 
						<tfoot>
							<tr>
								
							</tr>
						</tfoot>
					</table>
					<!-- 底栏 分页、操作等 -->
					<div class="BottomToolBar ClearFix">
					
					 <form action="CooperAgaincheck_listUI" method="post">

			<a href="${pageContext.request.contextPath}/CooperAgaincheck_listUI?CurrentPageNum=1&isCheck=${isCheck}">第一页</a>
			 <a href="${pageContext.request.contextPath}/CooperAgaincheck_listUI?CurrentPageNum=${pageVO.currentPageNum-1}&isCheck=${isCheck}">上一页</a> 
			 第<span style="color: red">${pageVO.currentPageNum}</span>&nbsp;&nbsp;页&nbsp;&nbsp; GO第:<span
				style="color: red">
				<input type="hidden" name="isCheck" value="${isCheck}" >
				<input type="text" name="CurrentPageNum" value="${pageVO.currentPageNum}" size="2"></span>&nbsp;&nbsp;页&nbsp;&nbsp;
				  <input type="submit" value="提交">
			一共多少页：<span style="color: red">${pageVO.allPageNum}</span>&nbsp;&nbsp;
				 <a href="${pageContext.request.contextPath}/CooperAgaincheck_listUI?CurrentPageNum=${pageVO.currentPageNum+1}&isCheck=${isCheck}">下一页</a>
			 <a href="${pageContext.request.contextPath}/CooperAgaincheck_listUI?CurrentPageNum=${pageVO.allPageNum}&isCheck=${isCheck}">最后一页</a>
			 
		</form>
						<div class="pull-right">
							<a type="button" class="buttom btn btn-default" style="width: 100px;" href="#">返回主菜单</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="${pageContext.request.contextPath}/js/jquery-3.0.0.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap-table.js"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap-table-zh-CN.min.js"></script>
	</body>

</html>