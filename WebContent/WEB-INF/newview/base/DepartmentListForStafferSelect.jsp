<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0083)http://115.28.87.22:8888/base/DepartmentListForStafferSelect.html?type=&default_id= -->
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="0">
	<title>部门 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
	<script src="js/minierp.js"></script>

	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link href="css/dtree.css" rel="stylesheet" type="text/css">
	<script src="js/dtree.js"></script>
	<script language="javascript">
		function doTreeNodeClick(id) {
			if (document.getElementById("currentId") != null) {
				document.getElementById("currentId").value = id;
			}
			/* 加载 */ 
			parent.document.getElementById("mainFrame").src = "InBillNew_toProductTypeListForProductSelect?productIdType="+id;
		}
		var normalHeight = 0;

		function doInit() {
			normalHeight = document.getElementById("scrollDiv").offsetHeight;
			d.openAll();
			var defaultId = "";
			if (defaultId != "") {
				doTreeNodeClick(defaultId);
			} else {
				//d.openAll();
			}
		}

		function fixDivHeight(type) {
			if (type == "NORMAL") {
				document.getElementById("scrollDiv").style.height = normalHeight + "px";
			} else {
				document.getElementById("scrollDiv").style.height = (normalHeight - 100) + "px";
			}
		}
	</script>
</head>

<body onload="doInit();" style="text-align:center" scroll="no">
	<div class="nav" id="scrollDiv" style="text-align:left;overflow-x:hidden;overflow-y:auto;height:348px;width:160px">
		<h3 class="title">部门</h3>
		<div class="nav-link nav-mail" style="width:100%">
			<div class="blank12"></div>
			<script language="javascript">
				var isOpen = false;
				var d = new dTree('d', 'images/');

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
			<div class="dtree">
			</div>
		</div>
	</div>

</body>

</html>