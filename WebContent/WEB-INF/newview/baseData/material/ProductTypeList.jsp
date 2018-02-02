<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
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
	<div class="nav" id="scrollDiv" style="text-align:left;overflow-x:hidden;overflow-y:auto;height:508px;width:190px">
		<h3 class="title">材料类别</h3>
		<div class="nav-link nav-mail" style="width:100%">
			<img src="images/icon_add.gif" title="新增部门" onclick="doNew();" style="cursor:pointer;" border="0">&nbsp;
			<img src="images/icon_edit.gif" title="修改部门" onclick="doEdit();" style="cursor:pointer;" border="0">&nbsp;
			<img src="images/icon_del.gif" title="删除部门" onclick="doDelete();" style="cursor:pointer;" border="0">
			<input name="currentId" id="currentId" value="" type="hidden">
			<div class="blank12"></div>
				<!--用s标签,js获得后台传过来的数据-->
				<s:iterator value="productTypes" status="index" var="typelist">
				<a href="product_toProductList?productType.id=${typelist.id}"  target="mainFrame" >${typeName}</a>
				<br/>
				</s:iterator>
			<script language="javascript">

			</script>
			
			<div class="dtree">
			</div>
		</div>
	</div>
  	</body>
</html>
    