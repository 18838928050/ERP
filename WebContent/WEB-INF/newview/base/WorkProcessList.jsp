<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0058)http://115.28.87.22:8888/base/WorkProcessList.html?wc_id=1 -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>工序 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doNew() {
				var url = "base/WorkProcessNew.html?wc_id=1";
				ShowIframeNoScroll(['360px','320px'], url, '', function(){
					refreshWin();
				}, '工序');
			}

			function refreshWin() {
				window.location.reload(true);
			}

			function doEdit(id) {
				var url = "base/WorkProcessEdit.html?id=" + id;
				top.ShowIframeNoScroll(['360px','320px'], url, '', function(){
					refreshWin();
				}, '工序');
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
					window.location = "base/WorkProcessDelete.html?id=" + id + "&from_url=" + encodeURIComponent(window.location);
				}
			}

			function doCancel() {
				window.close();
			}

			function doPause(id, flag) {
				window.location = "base/WorkProcessPause.html?id=" + id + "&flag=" + flag + "&from_url=" + encodeURIComponent(window.location);
			}

			function doSearch() {
				var showPaus = "";
				if(document.getElementById("show_paus").checked) {
					showPaus = "Y";
				}
				alert("WorkCenter_toWorkProcessList?id=${id}&isAllView="+showPaus);
				window.location = "WorkCenter_toWorkProcessList?id=${id}&isAllView="+showPaus;
			}
		</script>
	</head>

	<body oncontextmenu="return false" class="sheet">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>工序</h2>
					<div class="pull-right">
						<div class="layui-form" style=" display: inline-block;">
							<input type="checkbox" name="show_paus"
							<c:if test="${allView == 'Y' }">checked</c:if>
							id="show_paus" lay-filter="show_paus" title="显示已停用工序" lay-skin="primary">
							<a type="button" class="layui-btn" id="newButton" onclick="doNew();">新 增</a>
						</div>
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
					<div class="TopToolBar" style="margin: 7px 0;">
						<table class="ListNoteInfo" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td>
					<p>设置默认工作中心的工序，每道工序对应一个部门</p>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="table-list">
						<table width="100%">
							<tbody>
								<tr>
									<th width="10%">序号</th>
									<th width="24%">名称</th>
									<th width="20%">所在部门</th>
									<th width="16%">计件单价</th>
									<th width="10%">状态</th>
									<th width="20%">操作</th>
								</tr>
								
								<s:iterator value="workPresses" status="indexs">
									<tr>
									<td>${indexs.index +1}</td>
									<td>${processName }</td>
									<td>
										<s:iterator value="departments" status="indexs">
											<c:if test="${depId == id}">
												${departmentName }
											</c:if>
										</s:iterator>
									</td>
									<td>${percent }</td>
									<td>
										<c:if test="${enabled == 'Y'}">
											正常
										</c:if>
										<c:if test="${enabled == 'N' }">
											<div style="color: red;">停止</div>
										</c:if>
									</td>
									<td>
										<a href="javascript:doEdit(&#39;58&#39;);">编辑</a>
										<a href="javascript:doPause(&#39;58&#39;,&#39;N&#39;);">
											<c:if test="${enabled == 'Y'}">
												停止
											</c:if>
											<c:if test="${enabled == 'N' }">
												启用
											</c:if>
										</a>
										<a href="javascript:doDelete(&#39;58&#39;);">删除</a>
									</td>
								</tr>
								</s:iterator>

							</tbody>
						</table>
					</div>
				</div>
			</div>
			<div class="blank12">
			</div>

		</div>
	<script src="layui/layui.all.js"></script>
	<script>
			layui.use('form', function() {
				var form = layui.form;
				form.on('checkbox(show_paus)', function(data) {
					doSearch();
					//			  console.log(data.elem); //得到checkbox原始DOM对象
					//			  console.log(data.elem.checked); //是否被选中，true或者false
					//			  console.log(data.value); //复选框value值，也可以通过data.elem.value得到
					//			  console.log(data.othis); //得到美化后的DOM对象
				});
				//各种基于事件的操作，下面会有进一步介绍
			});
		</script>
	</body>

</html>