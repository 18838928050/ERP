<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>付款方式 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doNew() {
				var url = "PayMode_toNew";
				ShowIframeNoScroll(['320px','230px'], url, '', function(){
					refreshWin();
				}, '付款方式');
			}

			function refreshWin() {
				window.location.reload(true);
			}

			function doEdit(id) {
				var url = "PayMode_toEdit?id="+id;
				ShowIframeNoScroll(['320px','230px'], url, '', function(){
					refreshWin();
				}, '付款方式');
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
					window.location = "PayMode_del?id="+id;
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
					<h2>付款方式</h2>
					<div class="pull-right">
						<a type="button" class="layui-btn" onclick="doNew();">新 增</a>
					</div>
				</div>
			</div>
			<div class="sheet-list">
				<div class="search-business">

					<table width="98%" cellspacing="0" cellpadding="0" border="0">
						<tbody>
							<tr id="errorMsgTr" style="display:none">
								<td>
									<div class="msg-error" id="errorMsgTd">

									</div>
								</td>
							</tr>
						</tbody>
					</table>
					<p style="line-height: 25px;">设置业务与采购的付款方式</p>
					<div class="table-list">
						<table width="100%">
							<tbody>
								<tr>
									<th width="20%">序号</th>
									<th width="50%">名称</th>
									<th width="30%">操作</th>
								</tr>
								
								<s:iterator value="payModes" status="indexs">
									<tr>
										<td>${sequenceCode }</td>
										<td>${modeName }</td>
										<td>
											<a href="javascript:doEdit('${id }');">编辑</a>
											<a href="javascript:doDelete('${id }');">删除</a>
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
	</body>

</html>