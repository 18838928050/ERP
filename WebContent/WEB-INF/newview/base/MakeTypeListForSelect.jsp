<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0056)http://115.28.87.22:8888/base/MakeTypeListForSelect.ihtm -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>选择项目类型 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/dtree.css" rel="stylesheet" type="text/css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script src="js/dtree.js"></script>
		<script src="js/jquery-3.0.0.min.js"></script>
		<script language="javascript">
			function doTreeNodeClick(id) {
				var node = d.get(id);
				if(node != null) {
					var arr = node.urlParas;
					parent.popRetVal = arr;
					ClosePop();
				}
			}

			function doCancel() {
				ClosePop();
			}

			function doInit() {

			}
		</script>
	</head>

	<body onload="doInit();" class="sheet">
		<div class="sheet-main" id="bodyDiv">
			<div class="sheet-top">
				<div class="content">
					<h2>选择项目类型</h2>
					<!--<p>鼠标单击可以选中记录</p>-->
				</div>
			</div>
			
			<div class="sheet-list">
				<div align="left" >
					<div class="blank12"></div>
					<script language="javascript">
						var obj = {
							"errMsg": "",
							"items": ${info},
							"status": "OK"
						}; //出来就是{}形式的json对象,不需要$.parseJSON

						var isOpen = false;
						var d = new dTree('d', 'images');

						d.config.useCookies = false;
						d.config.useLines = true;
						d.config.useIcons = true;

						d.add(0, -1, 'Root');
						$.each(obj.items, function(index, item) {
							var arr = new Array(item.id, item.typeName, item.wcId, item.wcName, item.unit, item.type);
							d.add(item.id, item.pareId, item.typeName, "javascript:doTreeNodeClick('" + item.id + "');", '', '', '', false, false, arr);
						});

						document.write(d);
						//d.openAll();
					</script>
					<div class="dtree">
						</div>
					</div>
				</div>
			</div>
		</div>

	</body>

</html>