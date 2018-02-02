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
		<div class="Wrap">
			<!-- 页面主框架 -->

			<div id="ListContainer" class="Container">
				<!-- 主体容器 -->

				<!-- 标题栏 -->
				<div class="Heading BillIcon">
					<div class="HeadingContent">
						<h1>业务单一览表</h1>
						<div class="pull-right">
							<span class="fl">
	            	<table class="MoreOption" cellpadding="0" cellspacing="0">
	            		<tbody><tr><th class="c1" width="80px">
	            			<input type="checkbox" name="cb_order_date" id="cb_order_date" checked="true" style="visibility:hidden;">
	            			订货日期
	            		</th>
	            		<td width="360px">
	            			<input type="text" class="TextBox Datetime" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_order_date&#39;);" id="start_date" name="start_date" value="2017-07-01">
			            	<img src="${pageContext.request.contextPath}/images/calendar.gif" class="imgIconButton" onclick="displayCalendar(document.getElementById(&#39;start_date&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_order_date\&#39;)&#39;);">
			            	<input type="hidden" id="hid_start_date" value="2017-07-01">
			            	至
			            	<input type="text" class="TextBox Datetime" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_order_date&#39;);" id="end_date" name="end_date" value="2017-07-05">
			            	<img src="${pageContext.request.contextPath}/images/calendar.gif" class="imgIconButton" onclick="displayCalendar(document.getElementById(&#39;end_date&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_order_date\&#39;)&#39;);">
			            	<input type="hidden" id="hid_end_date" value="2017-07-05">
			            	<a href="javascript:setDate(&#39;CURRENT_MONTH&#39;);">本月</a>
							<a href="javascript:setDate(&#39;TODAY&#39;);">今天</a>
							<a href="javascript:setDate(&#39;YESTERDAY&#39;);">昨天</a>
							<a href="javascript:setDate(&#39;PREVIEW_MONTH&#39;);">上月</a>
	            		</td>
	            	</tr></tbody></table>
	            </span>
							<span class="fr">
	            	<a href="javascript:;" id="lnkMoreOption">更多查询选项</a>
						<a type="button" class="buttom btn btn-default" href="#">查询</a>
						<a type="button" class="buttom btn btn-default" href="#">导出</a>
						<a type="button" class="buttom btn btn-default" href="#">打印</a>
	            </span>
						</div>
					</div>
				</div>

				<!-- 主内容 -->
				<div class="Content">
					
					<!-- 上栏 分页、操作等 -->
	        <div class="TopToolBar">
	            <table class="ListNoteInfo" cellpadding="0" cellspacing="0">
	            	<tbody><tr>
	                	<td>
	                		选择：
	                		<a href="javascript:showList(&#39;CAN_EXAM&#39;);">待审核</a>
		  	    			<a href="javascript:showList(&#39;CAN_MAKE&#39;);">要制作</a>
					  	    <a href="javascript:showList(&#39;UN_DELI_COMP&#39;);">完工未送货</a>
					  	    <a href="javascript:showList(&#39;UN_DELI&#39;);">未送货</a>
					  	    <a href="javascript:showList(&#39;UN_RECE&#39;);">未收完款</a>
					  	    <a href="javascript:showList(&#39;CAN_CLOSE&#39;);">待结清</a>
					  	    <a href="javascript:showList(&#39;ZERO_COST&#39;);">零金额</a>
					  	    <a href="javascript:showList(&#39;UN_PRINT&#39;);">未打印</a>
							
								<br>
								
		            				<span>合同：${huizongSum[0]}元（已优惠：${huizongSum[1]}元） 调账：${huizongSum[2]}元</span>
		                			<span>已收：${huizongSum[3]}元（其中预付款： ${huizongSum[4]}元） 欠款：${huizongSum[5]}元</span>
								
		            			<span>面积合计：${huizongSum[6]}平方米</span>
			        			<span>长度合计：${huizongSum[7]}米&nbsp;${huizongSum[8]}公分</span>
			        			<span>合同单数：${huizongSum[9]}笔</span>
			        			<span>回款率：${huikuanlv }</span>
							
	                	</td>
	            	</tr>
	            </tbody></table>
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
								<th>已收</th>
								<th>欠款</th>
								<th>已优惠</th>
								<th>设计</th>
								<th>跟单员</th>
								<th>最后打印</th>
								<th>交货日期</th>
								<th>状态</th>
								<th>操作</th>
							</tr>
						</thead>
						<tbody>
								<s:iterator value="businessBillVOs" status="s">
			
			
			<tr  >
				<td>${billCode}</td>
				<td>${orderDate}</td>
				<td><s:property value="%{establishmentVOs[#s.index].estName}" />(<s:property value="%{establishmentVOs[#s.index].linkman}" />)</td>
				<td>${content }</td>
				<td>${ cost}</td>
				 <td><s:property value="%{zhangtaos[#s.index]}"/></td>
				<!-- 已收 --><td><s:property value="%{yishous[#s.index]}"/></td>
				<td><s:property value="%{qianMoneys[#s.index]}"/></td>
				<td>${ favCost}</td>
				<td>${designerNameStr}</td>
				<td>${followerNameStr}</td>
				<td><s:property value="%{businessBillExtVOs[#s.index].lastPrinter}"/>
				<s:if test='businessBillExtVOs[#s.index].printNum!=0'>
						/<s:property value="%{businessBillExtVOs[#s.index].printNum}"/>次
				 </s:if>
				 </td>
				<td>${ deliverDate}</td>
				<td>
				
				 
				 <s:if test='businessBillExtVOs[#s.index].examined=="Y"'>已审核</s:if> 
				 <s:else>
				 	未审核
				 </s:else>
				 
				 
				  <s:if test='businessBillExtVOs[#s.index].collected=="Y"'>已完工</s:if> 
				 <s:else>
				 	未完工
				 </s:else>
				 
				  
				  
				    <s:if test='businessBillExtVOs[#s.index].completed="Y"'>已送完</s:if> 
				 <s:else>
				 	未送完
				 </s:else>
				  
				  
				  
				    <s:if test='businessBillExtVOs[#s.index].delivered=="Y"'>已结清</s:if> 
				 <s:else>
				 	未结清
				 </s:else>
				  
				  
				  
				  
				  
				  </td>

				<td>
				<s:if test='businessBillExtVOs[#s.index].delivered=="Y"'>
				    <s:a action="business_updateUI?businessBillVO.billCode=%{billCode}">查看</s:a>
				</s:if>
				<s:else>
				    <s:a action="business_updateUI?businessBillVO.billCode=%{billCode}">修改</s:a>
				
				</s:else>
				
				 <s:a action="">收款</s:a> <s:a action="">调账</s:a> <s:a action="">打印</s:a> <s:a action="">单据跟踪</s:a></td>
			</tr>
			
			
			
			
		</s:iterator>
		
						</tbody>
						<tfoot>
							<tr>
								<td colspan="16">
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
					<!-- 底栏 分页、操作等 -->
					<div class="BottomToolBar ClearFix">
						<div class="pull-right">
							<a type="button" class="buttom btn btn-default" style="width: 100px;" href="#">返回主菜单</a>
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