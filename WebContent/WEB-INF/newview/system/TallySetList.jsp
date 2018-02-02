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
		<title>帐套 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doNew() {
				var url = "TallySet_toTallySetNew";
				ShowIframeNoScroll(['350px','225px'], url, '', function(){
					refreshWin();
				}, '帐套');
			}

			function refreshWin() {
				if(popRetVal != null) {
					window.location.reload(true);
				}
			}

			function doEdit(id) {
				var url = "TallySet_toTallySetEdit?id=" +id;
				ShowIframeNoScroll(['350px','225px'], url, '', function(){
					refreshWin();
				}, '帐套');
			}

			function doDelete(id) {
				ShowConfirm('确定删除吗？', {title:'确认框'}, function(index){
					popRetVal = 'Y';
					layer.close(index);
					doDelAct(id);
				});
			}

			function doDelAct(id) {
				if(popRetVal != null) {
					window.location = "TallySet_delTallySet?id=" +id;
				}
			}

			function doPause(id, flag) {
				var fromUrl = encodeURIComponent(window.location);
				window.location = "system/TallySetPause.html?id=" + id + "&flag=" + flag + "&from_url=" + fromUrl;
			}

			function doCancel() {
				window.close();
			}
		</script>
	</head>

	<body oncontextmenu="return false" class="sheet">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>帐套管理</h2>
					<div class="pull-right">
						<a type="button" class="layui-btn" onclick="doNew();">新 增</a>
					</div>
				</div>
			</div>
			<div class="sheet-list">
				<div class="search-business">

					<table width="98%" border="0" cellpadding="0" cellspacing="0">
						<tbody>
							<tr id="errorMsgTr" style="display:none">
								<td>
									<div class="msg-error" id="errorMsgTd">

									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<div class="table-list">
						<p style="margin: 7px 0;">账套主要用于业务数据的独立核算，每个人只能看到得到授权的账套数据<br>
						<a href="http://www.ekingcn.com/school/spjt_1656_181.html" target="_blank">如何应用多帐套实现分店分公司独立核算管理<img src="images/play_button.gif"></a>
					</p>
						<table width="100%">
							<tbody>
								<tr>
									<th width="50%">名称</th>
									<th width="15%">状态</th>
									<th width="35%">操作</th>
								</tr>
				<s:iterator value="tallySet" status="indexs">
						<tr>
						     <td>${title }</td>
						     <td>${enabled}</td>
						     <td>
								<a href="javascript:doEdit(${id});">编辑</a>
								<a href="javascript:doPause(${id},'P');">停用</a>
								<a href="javascript:doDelete(${id})">删除</a>
							</td>
						</tr>
                </s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
		<script src="layui/layui.all.js"></script>
	</body>

</html>