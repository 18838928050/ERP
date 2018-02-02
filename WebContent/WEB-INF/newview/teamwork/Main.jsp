<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0038)http://115.28.87.22:8888/bbs/Main.ihtm -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="0">
	<title>信息公告</title>
	<link rel="stylesheet" href="layui/css/layui.css">
	<script src="js/minierp.js"></script>
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<script src="js/popup_ext.js"></script>
	<script language="javascript">
	function doCancel(){
		window.close();
	}
	function doInit(){
		document.getElementById("rightDiv").style.width=(document.getElementById("mainDiv").clientWidth-document.getElementById("leftDiv").offsetWidth)+"px";
    	var defaultUrl=encodeURIComponent("");
    	var defaultId="";
    	var url="./BbsColumnList.html?default_id="+defaultId+"&default_url="+defaultUrl
    	document.getElementById("leftFrame").src=url;
	}
	//子窗口调用
	function doDelAcc(id){
		if(popRetVal!=null){
			document.getElementById("mainFrame").contentWindow.doItemDeleteAct(id);
		}
	}
	function refreshColWin(){
		if(popRetVal!=null){
			document.getElementById("leftFrame").src="./BbsColumnList.html?default_id="+popRetVal;
		}
	}
	function doDelCol(id){
		if(popRetVal!=null){
			document.getElementById("leftFrame").src="./BbsColumnDelete.html?id="+id;
		}
	}
	function doDelRep(id){
		if(popRetVal!=null){
			document.getElementById("mainFrame").src="./BbsArticleDelete.html?id="+id;
		}
	}
	function doDelTopic(id){
		if(popRetVal!=null){
			document.getElementById("mainFrame").contentWindow.doDeleteAct(id);
		}
	}
	function showAddedAcc(){
		if(popRetVal!=null){
			document.getElementById("mainFrame").contentWindow.showAddedAccAct(popRetVal[0],popRetVal[1]);
		}
	}
	function refreshArtWin(){
		document.getElementById("mainFrame").contentWindow.refreshWin();
	}
</script>
	</head>

<body class="sheet" style="text-align:center;" oncontextmenu="return false" onload="doInit();">
<div class="sheet-main" style="width:950px; text-align:left;margin:auto;">
	<div class="sheet-top">
	  <div class="content">
	    <h2>信息公告</h2>
	    
	  </div>
	</div>

	<div class="sheet-list" id="mainDiv" style="height:468px;">	
		<div class="nav" id="navDiv" style="float:left;height:100%;">
			<iframe width="100%" height="100%" scrolling="no" frameborder="0" id="leftFrame" src="main_toBbsColumnList"></iframe>
		</div>
		<div class="main search-business" id="mainDiv" style="float:left; height: 100%;width: 648px;">
			<iframe width="100%" height="100%" scrolling="no" frameborder="0" id="mainFrame" src="main_toBbsTopicList"></iframe>
		</div>
  </div>

</div>

<audio controls="controls" style="display: none;"></audio>
</body>
</html>


	