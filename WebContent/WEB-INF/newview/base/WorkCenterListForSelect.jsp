<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>选择工作中心 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/Query.css" rel="stylesheet" type="text/css">

		<script src="js/popup.js"></script>
		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script language="javascript">
			function doSelect(index) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var arr = null;
				if(ob_arr.length >= index) {
					arr = new Array(ob_arr[index - 1].value, ob_arr[index - 1].getAttribute("wc_name"));
				}
				if(arr != null) {
					parent.popRetVal = arr;
					ClosePop();
				}
			}

			function doCancel() {
				ClosePop();
			}

			function DoubleClick(it) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var arr = null;
				if(ob_arr.length >= it.getAttribute("index")) {
					arr = new Array(ob_arr[it.getAttribute("index") - 1].value, ob_arr[it.getAttribute("index") - 1].getAttribute("wc_name"));
				}
				if(arr == null) {
					return;
				}
				parent.popRetVal = arr;
				ClosePop();
			}

			function doInit() {
				Window_Onload();
			}
		</script>
	</head>

	<body oncontextmenu="return false" onload="doInit();" class="sheet" style="min-width: 500px;">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>选择工作中心</h2>
				</div>
			</div>
			<div class="sheet-list">
				<div class="search-business">
					<p style="line-height: 24px;">鼠标双击可以选中工作中心</p>
					<div class="table-list">
						
						<table width="100%">
							<tbody>
								<tr>
									<th width="30"></th>
									<th width="25%">名称</th>
									<th width="60%">描述</th>
									<th width="15%">操作</th>
								</tr>
								
								<s:iterator value="workCenters" status="indexs">
									<tr class="query_list_data_tr2" index="${indexs.index+1 }" style="cursor:pointer;" ondblclick="javascript:DoubleClick(this)" onclick="javascript:ClickCheck(this)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
										<td><input type="radio" name="query_checkbox" value="${id }" wc_name="${wcName }"></td>
										<td>${wcName }</td>
										<td>${mark }</td>
										<td>
											<a href="javascript:doSelect(${indexs.index+1 });">选择</a>
										</td>
									</tr>
								</s:iterator>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</body>

</html>