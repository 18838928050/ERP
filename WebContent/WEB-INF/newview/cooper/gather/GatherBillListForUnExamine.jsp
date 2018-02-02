<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0063)http://115.28.87.22:8888cooper/GatherBillListForUnExamine.html -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>收货单反审核 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/Query.css" rel="stylesheet" type="text/css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script src="js/popup.js"></script>
		<script language="javascript">
			function doShow(id) {
				var url = "gatherEUn_toGatherBillInfoForUnExamine?id=" + id;
				/**var url="gatherEUn_toGatherBillInfoForUnExamine";*/
				ShowIframe(['900px', '500px'], url, '', function() {
					refreshWin();
				}, '收货单反审核');
			}

			function refreshWin() {
				if(popRetVal != null) {
					window.location = window.location;
				}
			}

			function doExamine(id) {
				ShowConfirm('确定反审核吗？', {
					title: '确认框'
				}, function(index) {
					popRetVal = 'Y';
					layer.close(index);
					refreshWin();
				//	doExamineCallBack(id);
				});
			}

			function doExamineCallBack(id) {
				if(popRetVal != null) {
					var url = "cooper/GatherBillExamine.html?id_str=" + id + "&flag=0";
					ShowIframe(['200px', '200px'], url, '', function() {
						refreshWin();
					}, '收货单反审核');
				}
			}

			function doMutiExamine() {
				var ob_arr = document.getElementsByName("query_checkbox");
				var str = "";
				for(i = 0; i < ob_arr.length; i++) {
					if((ob_arr[i].checked == true)) {
						if(str != "") {
							str = str + ";";
						}
						str = str + ob_arr[i].value;
					}
				}
				if(str != "") {
					doExamine(str);
				} else {
					ShowAlert('请选择要反审核的收货单', {
						title: '提示框'
					});
				}
			}

			function doSearch() {
				var searchKey = encodeURIComponent(document.getElementById("search_key").value.trim());
				var tsId = document.getElementById("ts_id").value;
				window.location = "cooper/GatherBillListForUnExamine.html?ts_id=" + tsId + "&search_key=" + searchKey;
			}

			function doGo(pageIndex) {
				var searchKey = encodeURIComponent("");
				window.location = "cooper/GatherBillListForUnExamine.html?ts_id=2&search_key=" + searchKey + "&current_page=" + pageIndex;
			}

			function doJump(pageIndex) {
				if(window.event.keyCode == 13) {
					doGo(pageIndex);
				}
			}

			function DoubleClick(it) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var str = "";
				if(ob_arr.length >= it.getAttribute("index")) {
					str = ob_arr[it.getAttribute("index") - 1].value;
				}
				if(str == "") {
					return;
				}
				doShow(str);
			}

			function doCancel() {
				window.close();
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
		</script>
	</head>

	<body oncontextmenu="return false" onload="doInit();" class="sheet">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>收货单反审核</h2>
					<div class="pull-right">
						<div class="layui-form" style=" display: inline-block;">
							<div class="layui-inline">
								<div class="layui-input-inline">
									<input type="text" class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();" style="width:100px" value="" title="允许以外协商名称、外协商拼音字头、收货单号、外协单号、收货单摘要进行模糊查询">
								</div>
							</div>
							<div class="layui-inline">
								<select name="ts_id" id="ts_id">
									<option value="0">==请选择账套==</option>

									<option value="1">新异</option>

									<option value="2" selected="">网络公司</option>

								</select>
							</div>
							<a type="button " class="layui-btn " onclick="doSearch();" title="允许以外协商名称、外协商拼音字头、收货单号、外协单号、收货单摘要进行模糊查询">查 询</a>
							<a type="button " class="layui-btn " onclick="doMutiExamine();">反审核</a>
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
					<p style="line-height: 25px;">将审核过的收货单恢复为未审核状态</p>
					<div class="table-list">
						<table width="100%">
							<tbody>
								<tr>
									<th width="20"><input type="checkbox" onclick="javascript:checkall(this);"></th>
									<th width="14%">单号</th>
									<th width="10%">收货日期</th>
									<th width="16%">外协单位</th>
									<th width="14%">外协单号</th>
									<th width="20%">摘要</th>
									<th width="8%">业务员</th>
									<th width="8%">开单人</th>
									<th width="10%">操作</th>
								</tr>
                              <s:iterator value="gatherBills" status="gatherBills">
								<tr class="query_list_data_tr1" index="1" style="cursor:pointer;" ondblclick="javascript:DoubleClick(this)" onclick="javascript:ClickCheck(this,true)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
									<td><input type="checkbox" onclick="javascript:ClickCheck(this,true);" name="query_checkbox" value="2"></td>
									<td>
										${billCode }
									</td>
									<td>${gatherDate}</td>
									<td></td>
								<td>
								<s:iterator value="cooperBills" status="cooperBills">
								<c:if test="id == cooperBillId">${billCode}</c:if>
								</s:iterator>
								</td>
									<td>${content }</td>
									<td>${examinerName}</td>
									<td>${createrName}</td>
									<td>
										<a href="javascript:doExamine(&#39;2&#39;);">反审核</a>
										<a href="javascript:doShow(&#39;2&#39;);">查看</a>
									</td>
								</tr>
                             </s:iterator>
							</tbody>
						</table>

						<div class="table-bot clearfix">
							<div class="pull-right">
								<a style="cursor:pointer" onclick=""><img src="images/but001.gif"></a>
								<a style="cursor:pointer" onclick=""><img src="images/but002.gif"></a>
								第
								<div class="layui-input-inline">
									<input class="layui-input" style="width:30px" placeholder="" type="text" maxlength="15" onkeydown="javascript:doJump(this.value);" id="confirmPassword" name="pageNumber" value="1">
								</div>
								页&nbsp;&nbsp;共1页
								<a style="cursor:pointer" onclick=""><img src="images/but003.gif"></a>
								<a style="cursor:pointer" onclick=""><img src="images/but004.gif"></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<script src="layui/layui.all.js"></script>
	</body>

</html>