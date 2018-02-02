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
				<h2>项目价格目录</h2>
				<div class="pull-right">
					<select name="pg_id" id="pg_id" style="width:100px" onchange="doSearch();">
						<option value="1" selected="">标准价格手册</option>
						<option value="2">大客户价格表</option>
					</select>
					<select name="mt_id" id="mt_id" style="width:160px" onchange="doSearch();">
						<option value="0">请选择项目类型</option>

						<option value="10">标牌</option>
						<option value="11">标识</option>
						<option value="109">标识标牌</option>
						<option value="110">&nbsp;|--指示牌</option>
						<option value="111">&nbsp;|--警示牌</option>
						<option value="112">&nbsp;|--桌牌</option>
						<option value="113">&nbsp;|--立牌</option>
						<option value="114">&nbsp;|--展示牌</option>
						<option value="115">&nbsp;|--户外标识</option>
						<option value="116">广告字</option>
						<option value="117">&nbsp;|--不发光立体字</option>
						<option value="118">&nbsp;|--背光立体字</option>
						<option value="119">&nbsp;|--发光立体字</option>
						<option value="120">&nbsp;|--光树脂发光立体字</option>
						<option value="121">&nbsp;|--立体发光立体字</option>
						<option value="13">型材销售</option>
						<option value="17">&nbsp;|--画框型材</option>
						<option value="18">&nbsp;|--画框配件</option>
						<option value="34">灯箱</option>
						<option value="122">&nbsp;|--吸塑灯箱</option>
						<option value="123">&nbsp;|--超薄灯箱</option>
						<option value="124">&nbsp;|--落地式灯箱</option>
						<option value="125">&nbsp;|--软膜灯箱</option>
						<option value="126">&nbsp;|--动态灯箱</option>
						<option value="127">&nbsp;|--LED灯箱</option>
						<option value="128">门头店招</option>
						<option value="129">&nbsp;|--彩条店招</option>
						<option value="130">&nbsp;|--模组店招</option>
						<option value="131">&nbsp;|--拉布内光店招</option>
						<option value="132">&nbsp;|--异形店招</option>
						<option value="97">标牌配件</option>
						<option value="98">东厂</option>
						<option value="133">快展器材</option>
						<option value="134">&nbsp;|--快展背景墙</option>
						<option value="135">&nbsp;|--X展架</option>
						<option value="136">&nbsp;|--易拉宝</option>
						<option value="137">&nbsp;|--注水旗杆</option>
						<option value="138">&nbsp;|--快展套装</option>
						<option value="99">成品标牌</option>
						<option value="139">展柜展架</option>
						<option value="140">&nbsp;|--靠墙柜</option>
						<option value="141">&nbsp;|--中岛柜</option>
						<option value="142">&nbsp;|--平柜</option>
						<option value="143">&nbsp;|--收银台</option>
						<option value="144">&nbsp;|--挂架</option>
						<option value="145">&nbsp;|--端架</option>
						<option value="146">&nbsp;|--地台</option>
						<option value="147">印刷</option>
						<option value="148">&nbsp;|--名片</option>
						<option value="149">&nbsp;|--宣传单</option>
						<option value="150">&nbsp;|--画册</option>
						<option value="151">&nbsp;|--手提袋</option>
						<option value="152">&nbsp;|--台挂历</option>
						<option value="153">促销用品</option>
						<option value="154">&nbsp;|--吊旗</option>
						<option value="155">&nbsp;|--太阳伞</option>
						<option value="156">&nbsp;|--条幅横幅</option>
						<option value="157">&nbsp;|--挂墙展板</option>
						<option value="158">&nbsp;|--拱门气球</option>
						<option value="159">&nbsp;|--礼品</option>
						<option value="103">喷绘</option>
						<option value="104">&nbsp;|--挂画</option>
						<option value="105">&nbsp;|--灯箱画片</option>
						<option value="106">&nbsp;|--高精图像片</option>
						<option value="107">&nbsp;|--户外彩喷</option>
						<option value="108">&nbsp;|--车身彩绘</option>
					</select>
					<input type="text" class="TextBox" id="pro_name" name="pro_name" onkeyup="checkProName();" onfocus="proNameFocus();" onblur="proNameBlur();" style="width:100px" value="录入材质名称查询" title="以材质名称或者材质的拼音字头进行模糊查询">
					<a type="button" class="buttom btn btn-default" href="#">查询</a>
					<a type="button" class="buttom btn btn-default" href="#">导出</a>
					<a type="button" class="buttom btn btn-default" href="#">删除</a>
					<a type="button" class="buttom btn btn-default" href="estprice_addEstPriceUI">新增</a>
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
						<th>项目类型</th>
						<th>材质</th>
						<th>规格</th>
						<th>单位</th>
						<th>单价</th>
						<th>制作要求</th>
						<th>备注</th>
						<th>操作</th>
					</tr>
				</thead>
				 <s:iterator value="fenyeMode.estPriceList">
	 <tr align="center">
	 	<td>${id }</td>
			 	  <td>${makeTypeId }</td>
		<td>${proName}</td>
		<td>${specification  }</td>
		<td>${unit}</td>
		<td>${price}</td>
		<td>${makeRequire}</td>
		<td>${mark}</td>
		<td>
			<s:a action="estprice_editEstPriceUI?estPrice.id=%{id}">编辑</s:a>
			<s:a action="estprice_DeleteEstPriceVOById?estPrice.id=%{id}">删除</s:a>
		</td>
	 </tr>
	 </s:iterator>
				<tfoot>
					<tr>
						<td colspan="14">
							<form action="estprice_EstPriceUI" method="post">
	
	<a href="${pageContext.request.contextPath}/estprice_EstPriceUI?CurrentPageNum=${fenyeMode.currentPageNum-1}">上一页</a>
	第<span style="color:red">${fenyeMode.currentPageNum}</span>&nbsp;&nbsp;页&nbsp;&nbsp;
	GO第:<span style="color:red"><input type="text" name="CurrentPageNum" value="${fenyeMode.currentPageNum}"  size="2"></span>&nbsp;&nbsp;页&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/estprice_EstPriceUI?CurrentPageNum=${fenyeMode.currentPageNum+1}">下一页</a>
每页显示结果：<input type="text" name="maxNumEveryPage"  size="2">
	<input type="submit" value="提交">
	每页结果数：<span style="color:red">${fenyeMode.maxNumEveryPage}</span>&nbsp;&nbsp;
	一共多少页：<span style="color:red">${fenyeMode.allPageNum}</span>&nbsp;&nbsp;
	一共多少条结果:<span style="color:red">${fenyeMode.allResultNum}</span>&nbsp;&nbsp;

</form>
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