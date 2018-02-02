<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- ${pageContext.request.contextPath} -->
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>关于管理易 | 管理易-广告加工制作管理软件  企业版 9.28  | 易凯软件</title>
<script src="${pageContext.request.contextPath}/js/minierp.js"></script>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
<script src="${pageContext.request.contextPath}/js/popup_ext.js"></script>
<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
<script language="javascript">
	function doCopy(){
		try{
			window.clipboardData.setData("Text","http://115.28.87.22:8888");
			ShowAlert('提示框','复制成功！',200,100);
		}catch(e){
			ShowAlert('提示框','对不起，当前浏览器不支持剪帖板功能！',200,100);
		}
	}
</script>
</head>
<body class="sheet" style="text-align:center;">
<div class="sheet-main" style="width:460px;text-align:left;margin:auto;">
  <div class="sheet-top">
    <div class="content">
      <h2>关于标识汇</h2>
    </div>
  </div>
  <div class="sheet-list">
    <div class="search-business">
    	<div class="blank24"></div>
	     <div class="table-list">
			 <table width="100%">
				<tbody><tr>
					<td style="text-align:left;height:30"><b>您正在使用：</b></td>
				</tr>
				<tr>
					<td style="text-align:left;height:30"><b>公司名称：</b>郑州标识标汇股份有限公司</td>
				</tr>
				<tr>
					<td style="text-align:left;height:30"><b>许可证数：</b>4个 软件升级有效期至：2028-09-09</td>
				</tr>
				
				<tr>
					<td style="text-align:left;height:30"><b>当前登录地址：</b><a href="index.html">http://115.28.87.22:8888</a> <a href="javascript:doCopy();">复制</a></td>
				</tr>
				<tr>
					<td style="text-align:left;height:30"><b>当前登录用户：</b>${username } （${ cateatename}） 上次登录时间：${lasttime }</td>
				</tr>
				<script language="javascript">
					if(window.screen.width<1024){//screen.width不准，有时比实际的小
						document.write("<tr><td style='text-align:left;height:30'><span style='color:#666;'>建议将屏幕分辨率宽度调整为不小于1280</span></td></tr>");
					}
				</script>
			 </tbody></table>
		 </div>  
	   </div>  
  </div>
</div>
<audio controls="controls" style="display: none;"></audio>
<script src="${pageContext.request.contextPath}/layui/layui.all.js"></script>
</body>



</html>