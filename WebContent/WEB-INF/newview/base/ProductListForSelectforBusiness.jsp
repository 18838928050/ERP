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
		<title>选择材料 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/Query.css" rel="stylesheet" type="text/css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script language="javascript">
			function selectProduct(index) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var arr;
				if(ob_arr.length >= index) {
					var obj = ob_arr[index - 1];
					arr = new Array(obj.value, obj.getAttribute("product_code"), obj.getAttribute("product_name"), obj.getAttribute("product_unit"), obj.getAttribute("stock"), obj.getAttribute("in_pric"));
				}
				if(arr != null) {
					parent.parent.popRetVal = arr; //上面有一个iframe,所以要用两个parent
					parent.ClosePop();
				}
			}

			function DoubleClick(it) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var arr;
				if(ob_arr.length >= it.getAttribute("index")) {
					var obj = ob_arr[it.getAttribute("index") - 1];
					arr = new Array(obj.value, obj.getAttribute("product_code"), obj.getAttribute("product_name"), obj.getAttribute("product_unit"), obj.getAttribute("stock"), obj.getAttribute("in_pric"));
				}
				if(arr == null) {
					return;
				}
				parent.parent.popRetVal = arr;
				parent.ClosePop();
			}

			function doSearch() {
				var typeId = "";
				var searchKey = encodeURIComponent(document.getElementById("search_key").value.trim());
				var searchAll = "",
					stocType = "";
				if(document.getElementById("search_all").checked) {
					searchAll = "1";
				}
				if(document.getElementById("stoc_type")) {
					if(document.getElementById("stoc_type").checked) {
						stocType = "UPPER_ZERO";
					}
				}
				window.location = "base/ProductListForSelect.html?stock=&sto_id=&type_id=" + typeId + "&search_key=" + searchKey + "&search_all=" + searchAll + "&stoc_type=" + stocType;
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

			function doNew() {
				var url = "base/ProductNew.html?type_id=";
				parent.ShowIframe(['900px', '420px'], url, '', function() {
					doProNewCallBack();
				}, '材料'); //doProNewCallBack是父窗口的
			}

			function doNewCallBack(id) { //父窗口的doProNewCallBack调用
				window.location = "base/ProductListForSelect.html?stock=&stoc_type=UPPER_ZERO&sto_id=&type=&id=" + id;
			}
		</script>
	</head>

	<body oncontextmenu="return false" onload="doInit();" scroll="no">
		<div id="scrollDiv" style="OVERFLOW-Y:auto;height:348px">
			<div class="main search-business">
				<div class="cue-info" style="padding: 0 25px;">
					<h4 style="display: inline-block;">所有类别 - 材料</h4>
				</div>
				<div class="layui-form" style="padding: 0 25px;">
					<div class="layui-inline">
						<div class="layui-input-inline">
							<input type="text " class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();" value="" title="以产品名称、产品名称拼音字头进行模糊查询">
						</div>
					</div>
					<div class="layui-input-inline">
						<input type="checkbox" id="search_all" name="search_all" lay-skin="primary" title="在所有类别中查找材料" checked="">
					</div>

					<a type="button " class="layui-btn " onclick="doSearch();" title="以产品名称、产品名称拼音字头进行模糊查询">查 询</a>
					<a type="button " class="layui-btn " onclick="doNew();">新 增</a>

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
								<th width="14"></th>
								<th width="17%">类别</th>
								<th width="13%">材料编号</th>

								<th width="21%">品名规格</th>
								<th width="10%">单位</th>
								<th width="24%">备注</th>

								<th width="15%">操作</th>
							</tr>


							<!-- <tr class="query_list_data_trSelected" index="1" style="cursor:pointer;" onmouseout="javascript:mouseout(this)" ondblclick="javascript:DoubleClick(this)" onmouseover="javascript:mouseover(this)" onclick="javascript:ClickCheck(this)">
								<td><input type="radio" name="query_checkbox" value="14" product_code="C42-0001" product_name="玻璃" product_unit="块" stock="0" in_pric="0.0000"></td>
								<td>板材类</td>
								<td>C42-0001</td>
								<td>玻璃</td>
								<td>块</td>
								<td></td>

								<td class="ListTd">
									<a href="javascript:selectProduct('1');">选择</a>

								</td>
							</tr> -->
							<s:iterator value="products" status="indexs">
								<tr class="query_list_data_trSelected" index="${indexs.index+1 }" style="cursor:pointer;" onmouseout="javascript:mouseout(this)" ondblclick="javascript:DoubleClick(this)" onmouseover="javascript:mouseover(this)" onclick="javascript:ClickCheck(this)"">
									<td><input type="radio" name="query_checkbox" value="${id }" product_code="${productCode }" product_name="${productName }" product_unit="${unit }" stock="0" in_pric="${inpric }"></td>
									<td>类别${indexs.index+1 }</td>
									<td>${productCode }</td>
									<td>${productName }</td>
									<td>${unit }</td>
									<td>${mark }</td>
									<td>
										<a href="javascript:selectProduct('${indexs.index+1 }');">选择</a>
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