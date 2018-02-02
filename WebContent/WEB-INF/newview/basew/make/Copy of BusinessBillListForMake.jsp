<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ${pageContext.request.contextPath} -->
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>要制作的业务单 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>

		<link href="${pageContext.request.contextPath}/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/bootstrap-table.css" rel="stylesheet" />
		<link href="${pageContext.request.contextPath}/css/Query.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath}/css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/BillList.css">
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>

	<body>
		<div>
			<!-- 页面主框架 -->

			<div id="ListContainer" class="Container">
				<!-- 主体容器 -->

				<!-- 标题栏 -->
				<div class="Heading BillIcon">
					<div class="HeadingContent">
						<h1>要制作的业务单</h1>
						<div class="pull-right">
							<input type="text" class="form-control TextBox" maxlength="50" name="bill_code" id="bill_code" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_bill_code&#39;);" value="" placeholder="请输入业务单号">
							<a type="button" class="buttom btn btn-default" href="#">查询</a>
							<a type="button" class="buttom btn btn-default" href="#">开工</a>
							<a type="button" class="buttom btn btn-default" href="#">取消开工</a>
							<a type="button" class="buttom btn btn-default" href="#">打印</a>
						</div>
					</div>
				</div>

				<!-- 主内容 -->
				<div class="Content">

					<!-- 上栏 分页、操作等 -->
					<div class="TopToolBar">
						<table class="ListNoteInfo" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td>
										选择：
										<a href="javascript:showList(&#39;EXAMINE_TIME&#39;);">按审核时间降序</a>
										<a href="javascript:showList(&#39;ORDER_DATE&#39;);">按订货日期升序</a>
										<a href="javascript:showList(&#39;DELIVER_DATE&#39;);">按交货日期升序</a>
										<a href="javascript:showList(&#39;UN_MAKE&#39;);">未开工</a>
										<a href="javascript:showList(&#39;MAKE&#39;);">已开工</a>
										<a href="javascript:showList(&#39;URG&#39;);">加急单</a>

										<br> 制作单数：0
										<span>面积合计：0.00平方米</span>
										<span>长度合计：0.00米&nbsp;0.00公分</span>
										<span>成品数量合计：0</span>
									</td>
								</tr>
							</tbody>
						</table>
					</div>

					<table data-toggle="table" data-click-to-select="true">
						<thead>
							<tr>
								<th data-field="state" data-checkbox="true"></th>
								<th>单号</th>
								<th>订货日期</th>
								<th>订货单位</th>
								<th>摘要</th>
								<th>金额</th>
								<th>调账</th>
								<th>交货日期</th>
								<th>最近回款日期</th>
								<th>跟单员</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
							
		<s:iterator value="businessBillVOs" status="st">
			<tr>
				<td>${billCode }</td>
				<td><s:property  value="%{establishmentVOs[#st.index].estName}"/></td>
					<td>${content }</td> 
				<td>${orderDate}</td>
			<td>${ deliverDate}</td>
			<td><s:property  value="%{businessBillExtVOs[#st.index].examineTime}"/></td>
			<td>${followerNameStr}</td>
			<td>开工状态</td>
			<td>工作中心</td>
			<td>
			<s:a action="">打印</s:a>
			<s:a action="">打印工艺单</s:a>
			<s:a action="">下载图样</s:a>
			<s:a action="">取消开工</s:a>
			<s:a action="">取消加急</s:a>
			<s:a action="">进度跟踪</s:a>
			</td>
			</tr>
		</s:iterator>
						</tbody>
						<tfoot>
							<tr>
								<td colspan="14">
									<div class="pull-right">
										<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath}/images/but001.gif"></a>
										<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath}/images/but002.gif"></a>
										第 <input type="text" name="pageNumber" style="width:30px" value="1" onkeydown="javascript:doJump(this.value);" class="TextBox"> 页 共1页
										<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath}/images/but003.gif"></a>
										<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath}/images/but004.gif"></a>
									</div>
								</td>
							</tr>
						</tfoot>
					</table>

				
				
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