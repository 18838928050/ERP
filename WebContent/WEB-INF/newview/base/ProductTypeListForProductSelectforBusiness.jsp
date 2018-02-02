<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>材料类别 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<script src="js/minierp.js"></script>

		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/dtree.css" rel="stylesheet" type="text/css">
		<script src="js/dtree.js"></script>
		<script language="javascript">
			function doTreeNodeClick(id) {
				if(document.getElementById("currentId") != null) {
					document.getElementById("currentId").value = id;
				}
				parent.document.getElementById("mainFrame").src = "Business_toProductTypeListForProductSelect?ProductIdType="+id;
			}
			var normalHeight = 0;

			function doInit() {
				normalHeight = document.getElementById("scrollDiv").offsetHeight;
				var defaultId = "";
				if(defaultId != "") {
					doTreeNodeClick(defaultId);
					d.openTo(defaultId, true, false);
				}
			}

			function fixDivHeight(type) {
				if(type == "NORMAL") {
					document.getElementById("scrollDiv").style.height = normalHeight + "px";
				} else {
					document.getElementById("scrollDiv").style.height = (normalHeight - 100) + "px";
				}
			}
		</script>
	</head>

	<body oncontextmenu="return false" onload="doInit();" style="text-align:center" scroll="no">
		<div class="nav" id="scrollDiv" style="text-align:left;overflow-x:hidden;overflow-y:auto;width:190px;height:348px">
			<h3 class="title">材料类别</h3>
			<div class="nav-link nav-mail" style="width:100%;">
				<div class="blank12"></div>
				<script language="javascript">
					var isOpen = false;
					var d = new dTree('d', 'images');

					d.config.useCookies = false;
					d.config.useLines = true;
					d.config.useIcons = true;

					d.add(0, -1, 'Root');
					
					<s:iterator value="productTypes">
						d.add(${id}, ${parentId}, '${typeName}', "javascript:doTreeNodeClick('${id}');", '', '', '', false);
					</s:iterator>

					document.write(d);
					d.closeAll();
				</script>
			</div>
		</div>

	</body>

</html>