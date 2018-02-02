<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0061)http://115.28.87.22:8888/system/CodeRuleMain.ihtm?list_type=1 -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title></title>

		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/dtree.css" rel="stylesheet" type="text/css">
		<script src="js/dtree.js"></script>
	</head>

<body oncontextmenu="return false" onload="doInit();" style="text-align:center" scroll="no">
	<div class="nav" id="scrollDiv" style="text-align:left;overflow-x:hidden;overflow-y:auto;height:508px;width:160px">
		<h3 class="title">部门</h3>
		<div class="nav-link nav-mail" style="width:100%">
			<img src="images/icon_add.gif" title="新增部门" onclick="doNew();" style="cursor:pointer;" border="0">&nbsp;
			<img src="images/icon_edit.gif" title="修改部门" onclick="doEdit();" style="cursor:pointer;" border="0">&nbsp;
			<img src="images/icon_del.gif" title="删除部门" onclick="doDelete();" style="cursor:pointer;" border="0">
			<input name="currentId" id="currentId" value="" type="hidden">
			<div class="blank12"></div>
			<!--用s标签,js获得后台传过来的数据-->
			<s:iterator value="departList" status="indexs" var="depart">
				<a href="departStaff_toStafferList?department.id=${depart.id}" target="mainFrame" >${departmentName}</a>
				<br/>
			</s:iterator>

			<script language="javascript">

				<!--
				var isOpen = false;
				var d = new dTree('d', 'images/');

				d.config.useCookies = false;
				d.config.useLines = true;
				d.config.useIcons = true;

				d.add(0, -1, 'Root');

				d.add(1, 0, '易凯管理员', "javascript:doTreeNodeClick('1');", '', '', '', false);

				d.add(13, 0, '总经办', "javascript:doTreeNodeClick('13');", '', '', '', false);

				d.add(14, 0, '新异店', "javascript:doTreeNodeClick('14');", '', '', '', false);

				d.add(16, 0, '业务来源', "javascript:doTreeNodeClick('16');", '', '', '', false);

				d.add(17, 0, '标识加工车间', "javascript:doTreeNodeClick('17');", '', '', '', false);

				d.add(21, 0, '合作伙伴', "javascript:doTreeNodeClick('21');", '', '', '', false);

				d.add(32, 0, '标识汇运营部', "javascript:doTreeNodeClick('32');", '', '', '', false);

				d.add(33, 0, '财务部', "javascript:doTreeNodeClick('33');", '', '', '', false);

				d.add(22, 13, '财务', "javascript:doTreeNodeClick('22');", '', '', '', false);

				d.add(15, 14, '客服', "javascript:doTreeNodeClick('15');", '', '', '', false);

				d.add(23, 14, '设计', "javascript:doTreeNodeClick('23');", '', '', '', false);

				d.add(24, 14, '业务', "javascript:doTreeNodeClick('24');", '', '', '', false);


				document.write(d);
				d.closeAll();
				//-->
			</script>
			
			<div class="dtree">
			</div>
		</div>
	</div>

</body>

</html>


<!--<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>部门 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/dtree.css" rel="stylesheet" type="text/css">
		<script src="js/dtree.js"></script>
		<script language="javascript">
			function doTreeNodeClick(id) {
				document.getElementById("currentId").value = id;
				parent.document.getElementById("mainFrame").src = "base/StafferList.html?department_id=" + id;
			}

			function doNew() {
				var parentId = document.getElementById("currentId").value;
				var url = "base/DepartmentNew.html?parent_id=" + parentId;
				parent.ShowIframeNoScroll("部门", url, 320, 280, "refreshDepWin()"); //refreshDepWin是父窗口的
			}

			function refreshWin(defId) { //父窗口的refreshDepWin调用
				window.location = "base/DepartmentList.html?default_id=" + defId;
			}

			function doEdit() {
				var id = document.getElementById("currentId").value;
				if(id == "") {
					parent.ShowAlert('提示框', '请选择要修改的部门', 200, 100);
				} else {
					var url = "base/DepartmentEdit.html?id=" + id;
					parent.ShowIframeNoScroll("部门", url, 320, 280, "refreshDepWin()"); //refreshDepWin是父窗口的
				}
			}

			function doDelete() {
				var id = document.getElementById("currentId").value;
				if(id == "") {
					parent.ShowAlert('提示框', '请选择要删除的部门', 200, 100);
				} else {
					parent.ShowConfirm('确认框', '确定删除吗？', 340, 80, "doDelDep(" + id + ")"); //doDelDep是父窗口的
				}
			}

			function doDelAct(id) { //父窗口的doDelDep调用
				var fromUrl = getFromUrl();
				window.location = "base/DepartmentDelete.html?id=" + id + "&from_url=" + fromUrl;
			}

			function doInit() {
				var defaultId = "";
				if(defaultId != "") {
					doTreeNodeClick(defaultId);
					d.openTo(defaultId, true, false);
				}
			}

			function getFromUrl() {
				var defaultId = "";
				var fromUrl = "base/DepartmentList.html?default_id=" + defaultId;
				return encodeURIComponent(fromUrl);
			}
		</script>
		<style>
			.layui-nav {
				background: #FFFFFF;
			}
			
			.layui-nav .layui-nav-item a {
				color: #000;
				height: 30px;
				line-height: 30px;
			}
			
			.layui-nav-tree .layui-nav-item a:hover {
				background-color: #FDCF42;
				color: #000;
				text-decoration: none;
			}
			
			.layui-nav .layui-nav-more {
				border-color: #000 transparent transparent;
			}
			
			.layui-nav .layui-nav-mored,
			.layui-nav-itemed .layui-nav-more {
				border-color: transparent transparent #000;
			}
			
			.layui-nav-itemed>a,
			.layui-nav-tree .layui-nav-title a,
			.layui-nav-tree .layui-nav-title a:hover {
				color: #000!important;
			}
			
			.layui-nav-itemed .layui-nav-child {
				background: #fff!important;
			}
			
			.layui-nav-tree .layui-nav-child a {
				padding-left: 40px;
			}
			.layui-nav-tree .layui-nav-child dd.layui-this, .layui-nav-tree .layui-nav-child dd.layui-this a, .layui-nav-tree .layui-this, .layui-nav-tree .layui-this>a, .layui-nav-tree .layui-this>a:hover {
				background: #FDCF42;
				color: #000;
			}
			.layui-nav-tree .layui-nav-bar {
				display: none;
			}
			.layui-nav-tree .layui-nav-more {
				top: 12px;
			}
			.layui-nav-itemed .layui-nav-more{
				top: 7px;
			}
		</style>
	</head>

	<body oncontextmenu="return false" onload="doInit();" style="text-align:center" scroll="no">
		<div class="nav" id="scrollDiv" style="text-align:left;overflow-x:hidden;overflow-y:auto;height:508px;width: 333px;">
			<ul class="layui-nav layui-nav-tree layui-inline" lay-filter="">

				<ul class="layui-nav layui-nav-tree" lay-filter="">
					<li>
						<h3 class="title">部门</h3>
					</li>
					<li style="padding-left: 20px;">
						<img src="images/icon_add.gif" title="新增部门" onclick="doNew();" style="cursor:pointer;" border="0">&nbsp;
					<img src="images/icon_edit.gif" title="修改部门" onclick="doEdit();" style="cursor:pointer;" border="0">&nbsp;
					<img src="images/icon_del.gif" title="删除部门" onclick="doDelete();" style="cursor:pointer;" border="0">
					</li>
					<li class="layui-nav-item">
						<li class="layui-nav-item">
							<a href="javascript:;">易凯管理员</a>
						</li>
						
						
						<li class="layui-nav-item">
						<a href="javascript:;">总经办</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">财务</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">新异店</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="javascript:;">移动模块</a>
							</dd>
							<dd>
								<a href="javascript:;">后台模版</a>
							</dd>
							<dd>
								<a href="javascript:;">电商平台</a>
							</dd>
						</dl>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">业务来源</a>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">标识加工车间</a>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">合作伙伴</a>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">标识汇运营部</a>
					</li>
					<li class="layui-nav-item">
						<a href="javascript:;">财务部</a>
					</li>
				</ul>

		</div>
		<script src="js/jquery-3.0.0.min.js"></script>
		<script src="layui/layui.all.js"></script>
		<script>
			$('.layui-nav .layui-nav-item a').click(function(){
				$('.layui-this').removeClass('layui-this');
				$(this).addClass('layui-this');
			})
		</script>
	</body>

</html>-->