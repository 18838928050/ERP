<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0046)http://115.28.87.22:8888/base/InnerPbMain.ihtm -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>内部通讯录 | 管理易-广告加工制作管理软件  企业版 9.28  | 易凯软件</title>
<link rel="stylesheet" href="layui/css/layui.css">
<script src="js/minierp.js"></script>

<link rel="stylesheet" type="text/css" href="css/base.css">
<script src="layui/layui.all.js"></script>
<script language="javascript">
	function doInit(){
		document.getElementById("mainDiv").style.width=(document.getElementById("mainTd").clientWidth-document.getElementById("Div").offsetWidth)+"px";
		document.getElementById("mainFrame").src="./InnerPbList.html";
	}
</script>
</head>

<body oncontextmenu="return false" onload="doInit();" class="sheet">
<div class="sheet-main" style="width:980px; text-align:left;margin:auto">
	<div class="sheet-top">
	  <div class="content">
	    <h2>内部通讯录</h2>
	  </div>
	</div>

	<div class="sheet-list" id="mainDiv" style="height:508px;">
		
		<div class="nav" id="Div" style="float:left;height:100%;">
			<iframe width="100%" height="100%" frameborder="0" id="leftFrame" scrolling="no" src="phone_toDepartmentListForInnerPb"></iframe>
		</div>
		<div id="mainDiv" class="main search-business" style="float: left; height: 100%; width: 740px;">
			<iframe width="100%" height="100%" frameborder="0" scrolling="no" id="mainFrame" src="phone_toInnerPbList"></iframe>
		</div>
  </div>
  <div class="blank12"></div>
</div>

<audio controls="controls" style="display: none;"></audio>
<script src="layui/layui.all.js"></script>
</body>

</html>