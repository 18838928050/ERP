<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0061)http://115.28.87.22:8888/base/StafferListForSelect.html?type= -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>选择员工 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/Query.css" rel="stylesheet" type="text/css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script language="javascript">
			function selectStaffer(index) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var str = "";
				if(ob_arr.length >= index) {
					str = ob_arr[index - 1].value + ";" + ob_arr[index - 1].getAttribute("staffer_name") + ";" + ob_arr[index - 1].getAttribute("dep_id");
				}
				if(str != null && str != '') {
					parent.parent.popRetVal = str;
					parent.ClosePop();
					//					parent.parent.layer.closeAll();
				}
			}

			function DoubleClick(it) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var str = "";
				if(ob_arr.length >= it.getAttribute("index")) {
					str = ob_arr[it.getAttribute("index") - 1].value + ";" + ob_arr[it.getAttribute("index") - 1].getAttribute("staffer_name") + ";" + ob_arr[it.getAttribute("index") - 1].getAttribute("dep_id");
				}
				if(str == "") {
					return;
				}
				parent.parent.popRetVal = str;
				parent.ClosePop();
			}

			function doSearch() {
				var departmentId = "";
				var searchKey = encodeURIComponent(document.getElementById("search_key").value.trim());
				var searchAll = "";
				if(document.getElementById("search_all").checked) {
					searchAll = "1";
				}
				window.location = "base/StafferListForSelect.html?department_id=" + departmentId + "&search_key=" + searchKey + "&search_all=" + searchAll;
			}

			function doInit() {
				Window_Onload();
				document.getElementById("search_key").focus();
			}

			function checkSearchKey() {
				if(window.event.keyCode == 13) {
					doSearch();
				}
			}
		</script>
	</head>

	<body oncontextmenu="return false" onload="doInit();" scroll="no">
		<div id="scrollDiv" style="OVERFLOW-Y:auto;height:348px">
			<div class="main search-business">
				<div class="cue-info" style="padding: 0 25px; display: inline-block;">
					<h4>所有部门 - 员工</h4>
				</div>
				<div class="layui-form pull-right" style="padding: 0 25px;margin-top: 5px;">
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input type="text " class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();" value="" title="以员工姓名、姓名拼音字头进行模糊查询">
						</div>
					</div>
					<div class="layui-input-inline">
						<input type="checkbox" id="search_all" name="search_all" lay-skin="primary" title="在所有部门中查找" checked="">
					</div>

					<a type="button " class="layui-btn " onclick="doSearch();" title="以员工姓名、姓名拼音字头进行模糊查询">查 询</a>

				</div>

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
				<div class="table-list" style="width:97%; padding:15px 0 15px 10px; float:left;">
					<table width="100%">
						<tbody>
							<tr>
								<th width="30"></th>
								<th width="30%">部门</th>
								<th width="20%">姓名</th>
								<th width="30%">职位</th>
								<th width="20%">操作</th>
							</tr>
							
							<s:iterator value="staffers" status="indexs">
								<tr class="query_list_data_tr1" index="${indexs.index+1 }" style="cursor:pointer;" onmouseout="javascript:mouseout(this)" ondblclick="javascript:DoubleClick(this)" onmouseover="javascript:mouseover(this)" onclick="javascript:ClickCheck(this)">
									<td><input type="radio" name="query_checkbox" value="${indexs.index+1 }" staffer_name="${stafferName }" dep_id="${id }"></td>
									<td>财务部${indexs.index+1 }</td>
									<td>${stafferName }</td>
									<td></td>
									<td class="ListTd">
										<a href="javascript:selectStaffer(${indexs.index+1 });">选择</a>
									</td>
								</tr>
							</s:iterator>


						</tbody>
					</table>
				</div>
			</div>
		</div>

		<script src="layui/layui.all.js"></script>
	</body>

</html>