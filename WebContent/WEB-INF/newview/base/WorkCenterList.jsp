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
		<title>工作中心 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doNew() {
				var url = "WorkCenter_toNew";
				ShowIframeNoScroll(['320px','280px'], url, '', function(){
					refreshWin();
				}, '工作中心'  );
			}

			function refreshWin() {
				if(popRetVal != null) {
					window.location.reload(true);
				}
			}

			function doEdit(id) {
				var url = "WorkCenter_toEdit?id="+id;
				ShowIframeNoScroll(['320px','280px'], url, '', function(){
					refreshWin();
				}, '工作中心'  );
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
					<c:if test="${allView == 'Y' }">
					window.location = "WorkCenter_delNoWorkCenter?id="+id;
					</c:if>
					<c:if test="${allView == 'N' }">
					window.location = "WorkCenter_delWorkCenter?id="+id;
					</c:if>
				}
			}

			function doCancel() {
				window.close();
			}

			function proList(id) {
				var url = "WorkCenter_toWorkProcessList?id="+id;
				showWin(['500px','350px'], url);
			}

			function doPercentEdit(id) {
				var url = "base/SetWorkProcessPercentForm.html?wc_id=" + id;
				ShowIframe(['420px','300px'], url, '', function(){
					refreshWin();
				}, '工序占比');
			}

			function doPause(id, flag) {
				<c:if test="${allView == 'Y' }">
				window.location = "WorkCenter_sotpNoWorkCenter?id="+id;
				</c:if>
				<c:if test="${allView == 'N' }">
				window.location = "WorkCenter_sotpWorkCenter?id="+id;
				</c:if>
			}

			function doSearch() {
				/* var showPaus = "";
				if(document.getElementById("show_paus").checked) {
					showPaus = "Y";
				} */
				<c:if test="${allView == 'N' }">
					window.location = "WorkCenter_toNoWorkCenter";
				</c:if>
				<c:if test="${allView == 'Y' }">
					window.location = "WorkCenter_toWorkCenter";
				</c:if>
			}
		</script>
	</head>

	<body oncontextmenu="return false" class="sheet">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>工作中心管理</h2>
					<div class="pull-right">
						<div class="layui-form" style=" display: inline-block;">
							<input type="checkbox"
							<c:if test="${allView == 'Y' }">checked</c:if> name="show_paus" id="show_paus" lay-filter="show_paus" title="显示已停用工作中心" lay-skin="primary">
							<a type="button" class="layui-btn" onclick="doNew();">新 增</a>
						</div>
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

					<div class="TopToolBar" style="margin: 7px 0;">
						<table class="ListNoteInfo" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td>
										<!--<span class="Note">通过业务单查询，可以根据业务单状态进行编辑、打印、送货、收款、调账、结清等操作，可以查看业务单的完工进度。<span style="color:black">黑色</span>表示未审核、<span style="color:blue">蓝色</span>表示已审核、<span style="color:red">红色</span>表示已完工、<span style="color:purple">紫色</span>表示已送完货、<span style="color:green">绿色</span>表示已结清。</span>-->
										<p>工作中心指在工厂内执行工序和作业的场所，每个工作中心可以设置多个工序，同时设置每个工序的产值占比或者计件工资，以便统计制作人员的产值。</p>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="table-list">
	        <table width="100%">
	          <tbody><tr>	
					<th width="18%">名称</th>
					<th width="18%">仓库</th>
					<th width="24%">描述</th>
					<th width="10%">状态</th>
					<th width="30%">操作</th>
				</tr>   
				
				<s:iterator value="workCenters" status="indexs">
					<tr>
						<td>${wcName }</td>
						<td>
							<s:iterator value="storehouses" status="indexs">
								<c:if test="${storehouseId == id }">
									${stoName }
								</c:if>
							</s:iterator>
						</td>
						<td>${mark }</td>
						<td>
							<c:if test="${enabled == 'Y'}">
								正常
							</c:if>
							<c:if test="${enabled == 'N' }">
								<div style="color: red;">停止</div>
							</c:if>
						</td>
						<td>
							<a href="javascript:doEdit(${id });">编辑</a>
							<a href="javascript:doPause(${id },'N');">
								<c:if test="${enabled == 'Y'}">
									停止
								</c:if>
								<c:if test="${enabled == 'N' }">
									启用
								</c:if>
							</a>
							<a href="javascript:doDelete(${id });">删除</a>
							<br>
							<a href="javascript:proList(${id });">工序设置</a>
							<a href="javascript:doPercentEdit(${id });">工序占比设置</a>
						</td>
					</tr>
				</s:iterator>				
 					
			</tbody></table>				       	
	      </div>
				</div>
			</div>
		</div>
		<div class="blank12"></div>
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