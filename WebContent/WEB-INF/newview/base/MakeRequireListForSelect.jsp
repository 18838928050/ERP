<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0059)http://115.28.87.22:8888/base/MakeRequireListForSelect.html -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>选择制作要求 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/Query.css" rel="stylesheet" type="text/css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doSelect(index) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var arr = new Array();
				if(ob_arr.length >= index) {
					arr[0] = new Array(ob_arr[index - 1].value);
					parent.popRetVal = arr;
				}
				ClosePop();
			}

			function DoubleClick(it) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var arr = new Array();
				if(ob_arr.length >= it.getAttribute("index")) {
					arr[0] = new Array(ob_arr[it.getAttribute("index") - 1].value);
					parent.popRetVal = arr;
				}
				ClosePop();
			}

			function doMutiSelect() {
				var ob_arr = document.getElementsByName("query_checkbox");
				var arr = new Array();
				for(i = 0; i < ob_arr.length; i++) {
					if((ob_arr[i].checked == true)) {
						arr.push(new Array(ob_arr[i].value, "1"));
					}
				}
				if(arr.length > 0) {
					parent.popRetVal = arr;
					ClosePop();
				} else {
					ShowAlert('请选择制作要求！', {title:'提示框'});
					return;
				}
			}

			function doCancel() {
				ClosePop();
			}

			function doInit() {
				//Window_Onload();
				document.getElementById("search_key").focus();
			}

			function checkSearchKey() {
				if(window.event.keyCode == 13) {
					doSearch();
				}
			}

			function doSearch() {
				var searchKey = encodeURIComponent(document.getElementById("search_key").value.trim());
				window.location = "base/MakeRequireListForSelect.html?search_key=" + searchKey;
			}
		</script>
	</head>

	<body oncontextmenu="return false" onload="doInit();" class="sheet">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>选择制作要求</h2>
					<div class="pull-right">
							<div class="layui-form" style=" display: inline-block;">
								<div class="layui-inline">
									<div class="layui-input-inline">
										<input type="text" class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();" value="" title="可以根据编号、制作要求进行模糊查询">
									</div>
								</div>
								<a type="button " class="layui-btn " onclick="doSearch();" title="可以根据编号、制作要求进行模糊查询">查 询</a>
								<a type="button " class="layui-btn " onclick="doMutiSelect();">选 择</a>
							</div>
						</div>
				</div>
			</div>
			<div class="sheet-list">
				<div class="search-business">
					<div class="table-list">
					<p style="line-height: 25px;">鼠标双击可以选中记录</p>
						<table width="100%">
							<tbody>
								<tr>
									<th width="14"></th>
									<th width="15%">编号</th>
									<th width="75%">制作要求</th>
									<th width="10%">操作</th>
								</tr>
								
								<s:iterator value="makeRequires" status="indexs">
									<tr class="query_list_data_tr1" index="${indexs.index+1 }" style="cursor:pointer;" ondblclick="javascript:DoubleClick(this)" onclick="javascript:ClickCheck(this,true)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
										<td><input type="checkbox" onclick="javascript:ClickCheck(this,true);" name="query_checkbox" value="${requireContent }"></td>
										<td>${sequenceCode }</td>
										<td>${requireContent }</td>
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
			<div class="blank12">
			</div>

		</div>
	</body>

</html>