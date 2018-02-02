<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0097)http://115.28.87.22:8888/base/ProductListForSelect.html?type=&stock=&sto_id=&stoc_type=UPPER_ZERO -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>选择材料 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		
		<link rel="stylesheet" href="layui/css/layui.css">
		
		<script src="js/minierp.js"></script>

		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/Query.css" rel="stylesheet" type="text/css">
		<script src="js/QueryList.js"></script>
		<script language="javascript">
			function selectProduct(index) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var arr = new Array();
				if(ob_arr.length >= index) {
					var obj = ob_arr[index - 1];
					arr[0] = new Array(obj.value, obj.getAttribute("product_code"), obj.getAttribute("product_name"), obj.getAttribute("product_unit"), obj.getAttribute("stock"), obj.getAttribute("in_pric"));
				}
				if(arr != null) {
					parent.parent.popRetVal = arr;
					parent.parent.layer.closeAll();
				} else {
					parent.ShowAlert( '请选择材料！', {title:'提示框'});
				}
			}

			function DoubleClick(it) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var arr = new Array();
				if(ob_arr.length >= it.getAttribute("index")) {
					var obj = ob_arr[it.getAttribute("index") - 1];
					arr[0] = new Array(obj.value, obj.getAttribute("product_code"), obj.getAttribute("product_name"), obj.getAttribute("product_unit"), obj.getAttribute("stock"), obj.getAttribute("in_pric"));
				}
				if(arr == null) {
					return;
				}
				parent.parent.popRetVal = arr;
				parent.parent.layer.closeAll();
			}

			function doMutiSelect() {
				parent.doOk();
			}

			function doSearch() {
				var typeId = "";
				var type = "MULTI";
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
				window.location = "/base/ProductListForSelect.ihtm?stock=&sto_id=&type=" + type + "&type_id=" + typeId + "&search_key=" + searchKey + "&search_all=" + searchAll + "&stoc_type=" + stocType;
			}
			var normalHeight = 0;

			function doInit() {
				normalHeight = document.getElementById("scrollDiv").offsetHeight;
				document.getElementById("search_key").focus();
				var id = "";
				if(id != "") {
					var ob_arr = document.getElementsByName("query_checkbox");
					if(ob_arr.length > 0) {
						ob_arr[0].click();
					}
				}
			}

			function checkSearchKey() {
				if(window.event.keyCode == 13) {
					doSearch();
				}
			}

			function ClickCheckCallBack(obj) {
				var arr = new Array(obj.value, obj.getAttribute("product_code"), obj.getAttribute("product_name"), obj.getAttribute("product_unit"), obj.getAttribute("stock"), obj.getAttribute("in_pric"));
				parent.showSelected(arr, obj.checked);
			}

			function fixDivHeight(type) {
				if(type == "NORMAL") {
					document.getElementById("scrollDiv").style.height = normalHeight + "px";
				} else {
					document.getElementById("scrollDiv").style.height = (normalHeight - 100) + "px";
				}
			}

			function doNew() {
				var url = "base/ProductNew.html?type_id=";
				parent.ShowIframe(['900px','420px'], url, '', function(){
					parent.doProNewCallBack();
				}, '材料'); //doProNewCallBack是父窗口的
			}

			function doNewCallBack(id) { //父窗口的doProNewCallBack调用
				window.location = "/base/ProductListForSelect.ihtm?stock=&stoc_type=UPPER_ZERO&sto_id=&type=MULTI&id=" + id;
			}
		</script>
	</head>

	<body onload="doInit();" scroll="no">
		<div id="scrollDiv" style="OVERFLOW-Y:auto;height:348px">
			<div class="main search-business">
				<div class="cue-info" style="padding: 0 25px;">
					<h4 style="display: inline-block;">所有类别 - 材料</h4>
				</div>
					<div class="layui-form" style="padding: 0 25px;">
								<div class="layui-inline">
									<div class="layui-input-inline">
										<input  type="text " class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();" value="" title="以产品名称、产品名称拼音字头进行模糊查询">
									</div>
								</div>
								<div class="layui-input-inline">
      <input type="checkbox" id="search_all" name="search_all" lay-skin="primary" title="在所有类别中查找材料" checked="">
    </div>

								<a type="button " class="layui-btn " onclick="doSearch();" title="以产品名称、产品名称拼音字头进行模糊查询">查 询</a>
								<a type="button " class="layui-btn " onclick="doNew();">新 增</a>
								<a type="button " class="layui-btn " onclick="doMutiSelect();">选 择</a>

							</div>
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
								<th width="30"><input type="checkbox" onclick="javascript:checkall(this);"></th>
								<th width="16%">类别</th>
								<th width="13%">材料编号</th>

								<th width="21%">品名规格</th>
								<th width="10%">单位</th>
								<th width="25%">备注</th>

								<th width="15%">操作</th>
							</tr>

							
							<s:iterator value="products" status="indexs">
							<tr class="query_list_data_tr${indexs.index+1 }" index="${indexs.index+1 }" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)"><input type="checkbox" name="query_checkbox" onclick="javascript:ClickCheck(this,true);" value="${id }" product_code="${productCode }" product_name="${productName }" product_unit="${unit }" stock="0" in_pric="${inpric }"></td>
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)">类别${indexs.index+1 }</td>
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)">${productCode }</td>
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)">${productName }</td>
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)">${unit }</td>
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)">${mark }</td>
								<td>
									<a href="javascript:selectProduct('${indexs.index+1 }');">选择</a>

								</td>
							</tr>
							</s:iterator>
							
							<!-- <tr class="query_list_data_tr1" index="3" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)"><input type="checkbox" name="query_checkbox" onclick="javascript:ClickCheck(this,true);" value="16" product_code="C42-0003" product_name="KT板" product_unit="块" stock="0" in_pric="0.0000"></td>
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)">板材类</td>
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)">C42-0003</td>
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)">KT板</td>
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)">块</td>
								<td style="cursor:pointer;" ondblclick="javascript:DoubleClick(this.parentElement)" onclick="javascript:ClickCheck(this.parentElement,true)"></td>

								<td>
									<a href="javascript:selectProduct('3');">选择</a>

								</td>
							</tr> -->
						</tbody>
					</table>
				</div>
			</div>
		</div>

<script src="layui/layui.all.js"></script>

	</body>

</html>

