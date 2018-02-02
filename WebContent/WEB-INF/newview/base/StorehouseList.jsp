<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0049)http://115.28.87.22:8888/base/StorehouseList.html -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>仓库 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doNew() {
				var url = "./StorehouseNew.html";
				ShowIframeNoScroll(['320px','310px'], url, '', function(){
					refreshWin();
				}, '仓库');
			}

			function refreshWin() {
				window.location.reload(true);
			}

			function doEdit(id) {
				var url = "Storehouse_toEdit?id=" + id;
				ShowIframeNoScroll(['320px','310px'], url, '', function(){
					refreshWin();
				}, '仓库');
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
					window.location = "Storehouse_doDel?id="+id;
				}
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
					<h2>仓库</h2>
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
					<p style="line-height: 25px;">设置材料、产品的存放地点</p>
						<table width="100%">
							<tbody>
								<tr>
									<th width="20%">序号</th>
									<th width="30%">名称</th>
									<th width="30%">帐套</th>
									<th width="20%">操作</th>
								</tr>
								
								<s:iterator value="storehouses" status="indexs">
									<tr>
										<td>${sequenceCode }</td>
										<td>${stoName }</td>
										<td>
											<s:iterator value="tallySet" status="indexs">
												<c:if test="${tallySetId == id}">
													${title }
												</c:if>
											</s:iterator>
										</td>
										<td>
											<a href="javascript:doEdit(${id });">编辑</a>
											<a href="javascript:doDelete(${id });">删除</a>
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
		<audio controls="controls" style="display: none;"></audio>
		<script src="layui/layui.all.js"></script>
	</body>
</html>