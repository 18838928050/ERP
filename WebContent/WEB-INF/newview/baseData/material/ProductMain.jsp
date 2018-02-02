<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title></title>
		<link rel="stylesheet" href="layui/css/layui.css">

		<link rel="stylesheet" type="text/css" href="css/base.css">
	</head>

	<body oncontextmenu="return false" class="sheet" onload="doInit();" scroll="no">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>材料管理</h2>
					<div class="pull-right">

						<div class="layui-form" style=" display: inline-block;">
							<div class="layui-inline">
								<div class="layui-input-inline">
									<input type="text" class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();" title="以员工姓名、姓名拼音字头进行模糊查询" placeholder="">
								</div>
							</div>
							<div class="layui-inline">
								<div class="layui-input-inline ">
									<input type="checkbox" id="search_all" name="search_all" title="在所有部门中查找" lay-skin="primary" checked>
								</div>
							</div>
							<a href="javascript:; " id="lnkMoreOption ">更多查询选项</a>
							<a type="button " class="layui-btn " href="doSearch(); ">查 询</a>
							<a type="button " class="layui-btn " href="doNew();">新 增</a>
							
							<a type="button " class="layui-btn " href="# ">改类别</a>
							<a type="button " class="layui-btn " href="#">删除</a>
							<a type="button " class="layui-btn " href="# ">盘点表</a>
							
							<a type="button " class="layui-btn " href="doDownload(); ">导 出</a>
						
						</div>		
					</div>
				</div>
			</div>

			<div class="sheet-list" id="mainDiv" style="height:508px;">
			<div class="blank24"></div>
				<div class="nav" id="leftDiv" style="float:left;height:100%;width:15%; border:1px solid #CCCCCC;">
					<iframe id="leftFrame" scrolling="no" src="product_toProductTypeList" height="508px" frameborder="0" width="100%"></iframe>
				</div>
				<div class="main search-business" id="rightDiv" style="float: right; height: 100%; width: 83%; border:1px solid #CCCCCC;">
					<iframe id="mainFrame" scrolling="no" src="product_toProductList" height="100%" frameborder="0" width="100%"></iframe>
				</div>
			</div>
		</div>
			<script src="layui/layui.all.js"></script>
	</body>

</html>