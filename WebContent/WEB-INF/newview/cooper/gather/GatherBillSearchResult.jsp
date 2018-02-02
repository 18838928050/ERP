<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>收货单一览表 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link href="layui/css/layui.css" rel="stylesheet" />
		<link href="css/Query.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/BillList.css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script src="js/popup.js"></script>
		<script src="js/dhtmlgoodies_calendar.js"></script>
		<script language="javascript">
			function doShow(id) {
				var url = "gatherD_toGatherBillEdit?id=" + id;
				ShowIframe(['1024px','500px'], url, '', function(){
					refreshWin();
				}, '收货单');
			}

			function refreshWin() {
				if(popRetVal != null) {
					window.location = window.location;
				}
			}

			function createPageParaStr() {
				var str = "start_date=" + encodeURIComponent(document.getElementById("start_date").value);
				str = str + "&end_date=" + encodeURIComponent(document.getElementById("end_date").value);

				var examined = "A";
				if(document.getElementById("examine1").checked) {
					examined = "Y";
				} else if(document.getElementById("examine2").checked) {
					examined = "N";
				}
				str = str + "&examined=" + examined;

				str = str + "&creater_name=" + encodeURIComponent(document.getElementById("creater_name").value);
				str = str + "&manager_name=" + encodeURIComponent(document.getElementById("manager_name").value);
				str = str + "&est_name=" + encodeURIComponent(document.getElementById("est_name").value);
				str = str + "&bill_code=" + encodeURIComponent(document.getElementById("bill_code").value);
				str = str + "&content=" + encodeURIComponent(document.getElementById("content").value);
				str = str + "&cb_code=" + encodeURIComponent(document.getElementById("cb_code").value);
				str = str + "&department=" + document.getElementById("department").value;
				str = str + "&ts_id=" + document.getElementById("ts_id").value;
				str = str + "&order_by=" + document.getElementById("order_by").value;
				str = str + "&order_sc=" + document.getElementById("order_sc").value;

				return str;
			}

			function createProgramParaStr() {
				var str = "start_date=" + encodeURIComponent(document.getElementById("hid_start_date").value);
				str = str + "&end_date=" + encodeURIComponent(document.getElementById("hid_end_date").value);
				str = str + "&examined=Y";
				str = str + "&creater_name=" + encodeURIComponent(document.getElementById("hid_creater_name").value);
				str = str + "&manager_name=" + encodeURIComponent(document.getElementById("hid_manager_name").value);
				str = str + "&cb_code=" + encodeURIComponent(document.getElementById("hid_cb_code").value);
				str = str + "&est_name=" + encodeURIComponent(document.getElementById("hid_est_name").value);
				str = str + "&bill_code=" + encodeURIComponent(document.getElementById("hid_bill_code").value);
				str = str + "&content=" + encodeURIComponent(document.getElementById("hid_content").value);
				str = str + "&department=0";
				str = str + "&ts_id=2";
				str = str + "&order_by=";
				str = str + "&order_sc=ASC";

				return str;
			}

			function doSearch() {
				var str;
				if(IsAdvSearch) { //高级
					str = "search_type=1";
					if(document.getElementById("cb_gather_date").checked) {
						if(!checkDateStr(document.getElementById("start_date").value, "开始日期")) {
							return;
						}
						if(!checkDateStr(document.getElementById("end_date").value, "结束日期")) {
							return;
						}
						str = str + "&cb_gather_date=1";
					}
					if(document.getElementById("cb_examine").checked) {
						str = str + "&cb_examine=1";
					}
					if(document.getElementById("cb_manager").checked) {
						var managerName = document.getElementById("manager_name").value.trim();
						if(managerName == null || managerName == "") {
							ShowAlert('请输入业务员姓名', {title:'提示框'});
							return;
						}
						str = str + "&cb_manager=1";
					}
					if(document.getElementById("cb_creater").checked) {
						var createrName = document.getElementById("creater_name").value.trim();
						if(createrName == null || createrName == "") {
							ShowAlert('请输入开单人姓名', {title:'提示框'});
							return;
						}
						str = str + "&cb_creater=1";
					}
					if(document.getElementById("cb_est").checked) {
						var estName = document.getElementById("est_name").value.trim();
						if(estName == null || estName == "") {
							ShowAlert('请输入外协单位', {title:'提示框'});
							return;
						}
						str = str + "&cb_est=1";
					}
					if(document.getElementById("cb_bill_code").checked) {
						var billCode = document.getElementById("bill_code").value.trim();
						if(billCode == null || billCode == "") {
							ShowAlert('请输入收货单号', {title:'提示框'});
							return;
						}
						str = str + "&cb_bill_code=1";
					}
					if(document.getElementById("cb_content").checked) {
						var content = document.getElementById("content").value.trim();
						if(content == null || content == "") {
							ShowAlert('请输入摘要', {title:'提示框'});
							return;
						}
						str = str + "&cb_content=1";
					}
					if(document.getElementById("cb_cb_code").checked) {
						var cbCode = document.getElementById("cb_code").value.trim();
						if(cbCode == null || cbCode == "") {
							ShowAlert('请输入外协单号', {title:'提示框'});
							return;
						}
						str = str + "&cb_cb_code=1";
					}
					if(document.getElementById("cb_dep").checked) {
						var department = document.getElementById("department").value;
						if(department == null || department == "" || department == "0") {
							ShowAlert('请选择部门', {title:'提示框'});
							return;
						}
						str = str + "&cb_dep=1";
					}
					if(document.getElementById("cb_ts").checked) {
						var tsId = document.getElementById("ts_id").value;
						if(tsId == null || tsId == "" || tsId == "0") {
							ShowAlert('请选择帐套', {title:'提示框'});
							return;
						}
						str = str + "&cb_ts=1";
					}
					if(document.getElementById("cb_order").checked) {
						var orderBy = document.getElementById("order_by").value;
						if(orderBy == null || orderBy == "") {
							ShowAlert('请选择排序类型', {title:'提示框'});
							return;
						}
						str = str + "&cb_order=1";
					}
				} else { //快速
					str = "search_type=2";
					if(!checkDateStr(document.getElementById("start_date").value, "开始日期")) {
						return;
					}
					if(!checkDateStr(document.getElementById("end_date").value, "结束日期")) {
						return;
					}
				}
				var paraStr = createPageParaStr();
				if(paraStr != "") {
					str = str + "&" + paraStr;
				}
				window.location = "/cooper/GatherBillSearchResult.html?" + str;
			}

			function doGo(pageIndex) {
				var str = getSearchCondition();
				str = str + "&current_page=" + pageIndex;
				window.location = "/cooper/GatherBillSearchResult.html?" + str;
			}

			function getSearchCondition() {
				var searchType = "1";
				var str = "search_type=" + searchType;
				if(searchType == "1") { //高级
					str = str + "&cb_gather_date=1";

					str = str + "&cb_ts=1";

				} else { //快速

				}
				var paraStr = createProgramParaStr();
				if(paraStr != "") {
					str = str + "&" + paraStr;
				}
				return str;
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
				Window_Onload();
			}

			function checkInput() {
				if(window.event.keyCode == 13) {
					doSearch();
				}
			}

			function doAutoCheck(objId) {
				document.getElementById(objId).checked = true;
			}

			function doPrint(id, favCost) {
				if(favCost == 0) {
					ShowConfirm('收货单打印金额？', {title:'确认框'}, function(index){
						popRetVal = 'Y';
						layer.close(index);
						doPrintCallBack(id);
					});
				} else {
					showWin(['900px','600px'], "/cooper/GatherBillPrint.html?id=" + id + "&print_cost=0");
				}
			}

			function doPrintCallBack(id) {
				var printCost = "0";
				if(popRetVal != null) {
					printCost = "1";
				}
				showWin(['900px','600px'], "cooper/GatherBillPrint.html?id=" + id + "&print_cost=" + printCost);
			}

			function selectStafferName(objId, checkObjId) {
				var url = "base/StafferMainForSelect.html";
				ShowIframe(['800px','500px'], url, '', function(){
					selectStafferNameCallBack(objId, checkObjId);
				}, '选择员工');
			}

			function selectStafferNameCallBack(objId, checkObjId) {
				if(popRetVal != null) {
					var arr = popRetVal.split(";");
					document.getElementById(objId).value = arr[1];
					doAutoCheck(checkObjId);
				}
			}

			function setDate(type) {
				var d = new Date();
				var startStr = "";
				var endStr = "";
				if(type == "CURRENT_MONTH") {
					startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-01";
					endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				} else if(type == "PREVIEW_MONTH") {
					d = new Date(d.getFullYear(), d.getMonth(), 1);
					d.setDate(d.getDate() - 1);
					startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-1";
					endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				} else if(type == "TODAY") {
					startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
					endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				} else if(type == "YESTERDAY") {
					d.setDate(d.getDate() - 1);
					startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
					endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				}
				document.getElementById("start_date").value = startStr;
				document.getElementById("end_date").value = endStr;
				doAutoCheck("cb_gather_date");
			}

			function showExaPage(id) {
				var url = "cooper/GatherBillInfoForExamine.html?id=" + id;
				ShowIframe(['900px','500px'], url, '', function(){
					refreshWin();
				}, '审核');
			}

			function showUnExaPage(id) {
				var url = "gatherD_toGatherBillForUnExamine?id=" + id;
				ShowIframe(['900px','500px'], url, '', function(){
					refreshWin();
				}, '反审核');
			}

			function selectEstName() {
				var url = "base/EstablishmentListForSelect.html?type=COOPERATOR";
				ShowIframe(['900px','500px'], url, '', function(){
					selectEstNameCallBack();
				}, '选择外协商');
			}

			function selectEstNameCallBack() {
				if(popRetVal != null) {
					document.getElementById("est_name").value = popRetVal[1];
					doAutoCheck("cb_est");
				}
			}
		</script>
	</head>

	<body oncontextmenu="return false">
		<div class="Wrap">
			<!-- 页面主框架 -->

			<div id="ListContainer" class="Container">
				<!-- 主体容器 -->

				<!-- 标题栏 -->
				<div class="Heading BillIcon">
					<div class="HeadingContent">
						<h1>收货单一览表</h1>
						<div class="pull-right">
							<div class="layui-form" style=" display: inline-block;">
								<input type="checkbox" name="cb_gather_date" id="cb_gather_date" title="收货日期" checked="true" lay-skin="primary">

								<div class="layui-inline">
									<div class="layui-input-inline" style="width: 85px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_gather_date');" id="start_date" name="start_date" value="">
			            	<input type="hidden" id="hid_start_date" value="2016-12-08">
									</div>
								</div>
								<div class="layui-inline">
									<div class="layui-form-mid">至</div>
									<div class="layui-input-inline" style="width: 85px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_gather_date');" id="end_date" name="end_date" value="">
			            	<input type="hidden" id="hid_end_date" value="">
									</div>
								</div>
								<a type="button " class="layui-btn " href="javascript:;" id="lnkMoreOption">更多查询选项</a>
								<a type="button " class="layui-btn " onclick="doSearch();" id="sSearchButton" name="sSearchButton">查 询</a>
							</div>
						</div>
					</div>
				</div>

				<!-- 主内容 -->
				<div class="Content">
					<!-- 筛选控件栏 -->
					<div class="FilterBar ClearFix">
						<div id="dvMoreOptionBox" class="MoreOptionBox" style="display:none;">
							<table class="MoreOption" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<th class="c1" width="80px">
											<input type="checkbox" name="cb_est" id="cb_est"> 外协单位
										</th>
										<td class="c1" width="260px">
											<input type="text" class="TextBox" maxlength="50" name="est_name" id="est_name" onkeyup="checkInput();" onfocus="doAutoCheck('cb_est');" value="">
											<img class="imgIconButton" src="/images/make-a.gif" onclick="selectEstName();">
											<input type="hidden" id="hid_est_name" value="">
										</td>
										<th class="c2" width="80px">
											<input type="checkbox" name="cb_examine" id="cb_examine"> 审核状态
										</th>
										<td class="c2" width="280px">
											<input type="radio" name="examined" id="examine1" onclick="doAutoCheck('cb_examine');" checked="true">已审核
											<input type="radio" name="examined" id="examine2" onclick="doAutoCheck('cb_examine');">未审核
											<input type="radio" name="examined" id="examine3" onclick="doAutoCheck('cb_examine');">全部
										</td>
									</tr>
									<tr>
										<th class="c1">
											<input type="checkbox" name="cb_bill_code" id="cb_bill_code"> 收货单号
										</th>
										<td class="c1">
											<input type="text" class="TextBox" maxlength="50" name="bill_code" id="bill_code" onfocus="doAutoCheck('cb_bill_code');" onkeyup="checkInput();" value="">
											<input type="hidden" id="hid_bill_code" value="">
										</td>
										<th class="c2">
											<input type="checkbox" name="cb_manager" id="cb_manager"> 业务员
										</th>
										<td class="c3">
											<input type="text" class="TextBox" maxlength="15" name="manager_name" id="manager_name" onkeyup="checkInput();" onfocus="doAutoCheck('cb_manager');" value="">
											<img class="imgIconButton" src="/images/make-a.gif" onclick="selectStafferName('manager_name','cb_manager');">
											<input type="hidden" id="hid_manager_name" value="">
										</td>
									</tr>
									<tr>
										<th class="c1">
											<input type="checkbox" name="cb_content" id="cb_content"> 摘要
										</th>
										<td class="c1">
											<input type="text" class="TextBox" maxlength="50" name="content" id="content" onkeyup="checkInput();" onfocus="doAutoCheck('cb_content');" value="">
											<input type="hidden" id="hid_content" value="">
										</td>
										<th class="c2">
											<input type="checkbox" name="cb_creater" id="cb_creater"> 开单人
										</th>
										<td class="c3">
											<input type="text" class="TextBox" maxlength="15" name="creater_name" id="creater_name" onkeyup="checkInput();" onfocus="doAutoCheck('cb_creater');" value="">
											<img class="imgIconButton" src="/images/make-a.gif" onclick="selectStafferName('creater_name','cb_creater');">
											<input type="hidden" id="hid_creater_name" value="">
										</td>
									</tr>
									<tr>
										<th class="c1">
											<input type="checkbox" name="cb_cb_code" id="cb_cb_code"> 外协单号
										</th>
										<td class="c1">
											<input type="text" class="TextBox" maxlength="50" name="cb_code" id="cb_code" onkeyup="checkInput();" onfocus="doAutoCheck('cb_cb_code');" value="">
											<input type="hidden" id="hid_cb_code" value="">
										</td>
										<th class="c2">
											<input type="checkbox" name="cb_dep" id="cb_dep"> 部门
										</th>
										<td class="c3">
											<select name="department" id="department" onfocus="doAutoCheck('cb_dep');" style="visibility: visible;">
												<option value="0">==请选择==</option>

												<option value="1">易凯管理员</option>
												<option value="50">&nbsp;|--1</option>
												<option value="13">总经办</option>
												<option value="22">&nbsp;|--财务</option>
												<option value="14">新异店</option>
												<option value="15">&nbsp;|--客服</option>
												<option value="23">&nbsp;|--设计</option>
												<option value="24">&nbsp;|--业务</option>
												<option value="16">业务来源</option>
												<option value="17">标识加工车间</option>
												<option value="21">合作伙伴</option>
												<option value="32">标识汇运营部</option>
												<option value="33">财务部</option>
												<option value="35">新异标识标牌有限公司</option>
												<option value="36">&nbsp;|--物流部</option>
												<option value="41">&nbsp;|--销售部</option>
												<option value="42">&nbsp;|--业务部</option>
												<option value="43">&nbsp;|--设计部</option>
												<option value="44">&nbsp;|--安装部</option>
												<option value="45">&nbsp;|--外协(东厂)</option>
												<option value="46">&nbsp;|--财务部</option>
												<option value="48">&nbsp;|--门市部</option>
												<option value="49">&nbsp;|--加工车间</option>
												<option value="37">&nbsp;&nbsp;|--标牌部</option>
												<option value="38">&nbsp;&nbsp;|--标识部</option>
												<option value="39">&nbsp;&nbsp;|--型材加工部</option>
												<option value="40">&nbsp;&nbsp;|--字加工部</option>
											</select>
										</td>
									</tr>
									<tr>
										<th class="c1">
											<input type="checkbox" name="cb_ts" id="cb_ts" checked="true"> 账套
										</th>
										<td class="c1">
											<select name="ts_id" id="ts_id" onfocus="doAutoCheck('cb_ts');" style="visibility: visible;">
												<option value="0">==请选择账套==</option>

												<option value="1">新异</option>
												<option value="2" selected="">网络公司</option>
											</select>
										</td>
										<th class="c2">&nbsp;</th>
										<td class="c2">&nbsp;</td>
									</tr>
								</tbody>
							</table>

							<div class="OptionOrderBy">
								<input type="checkbox" name="cb_order" id="cb_order"> 排序类型
								<select name="order_by" id="order_by" onfocus="doAutoCheck('cb_order');" style="visibility: visible;">
									<option value="">==请选择==</option>
									<option value="GATHER_DATE">收货日期</option>
									<option value="BILL_CODE">收货单号</option>
									<option value="CB_CODE">外协单号</option>
									<option value="CONTENT">摘要</option>
									<option value="EST_NAME">外协单位</option>
								</select>
								<select name="order_sc" id="order_sc" onfocus="doAutoCheck('cb_order');" style="visibility: visible;">
									<option value="ASC" selected="">升序</option>
									<option value="DESC">降序</option>
								</select>
								<span class="fr"><a href="javascript:;" id="lnkHiddenOption">隐藏查询选项</a></span>
							</div>

						</div>
					</div>

					<!-- 提示信息显示栏 -->
					<div class="MsgBar">

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
					</div>
<p style="line-height: 25px;">
	<span class="Note">通过查询收货单，可以对收货单进行编辑与打印，<span style="color:black">黑色</span>表示未审核、<span style="color:blue">蓝色</span>表示已审核</span>
</p>
					<div class="table-list">
						<table width="100%">
							<tbody>
								<tr>
									<th width="12%">单号
									</th>
									<th width="10%">收货日期</th>
									<th width="16%">外协单位</th>
									<th width="12%">外协单号</th>
									<th width="16%">摘要</th>
									<th width="8%">业务员</th>
									<th width="8%">开单人</th>
									<th width="8%">状态</th>
									<th width="10%">操作</th>
								</tr>
<s:iterator value="gatherBills" status="gatherBills">
								<tr class="query_list_data_trSelected" index="1" style="color:blue;cursor:pointer;" defaultfontcolor="blue" ondblclick="javascript:DoubleClick(this)" onclick="javascript:ClickCheck(this)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
									<td>
										${billCode}
										<input type="radio" name="query_checkbox" value="36" style="display:none">
									</td>
									<td>${gatherDate}</td>
									<td>逐鹿问鼎</td>
									<td>U(2)2017090001</td>
									<td>${content }</td>
									<td>${linkMan}</td>
									<td>${createrName}</td>
									<td>
										<a href="javascript:showUnExaPage('${id}');">已审核</a>
									</td>
									<td>
										<a href="javascript:doShow('${id}');">修改</a>
										<a href="javascript:doPrint('36',50.00);">打印</a>
									</td>
								</tr>
</s:iterator>
							</tbody>
						</table>
					</div>

					<!-- 底栏 分页、操作等 -->
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
		<script src="layui/layui.all.js"></script>
		<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  laydate.render({
    elem: '#start_date'
  });
  laydate.render({
    elem: '#end_date'
  });
});
</script>
		<script type="text/javascript">
//			function ChangeWindowSize(container, maxWidth) {
//				setTimeout(function() {
//					var w1 = document.documentElement.clientWidth - 40;
//					if(w1 > maxWidth) w1 = maxWidth;
//					else if(w1 < 870) w1 = 860;
//					container.style.width = w1 + 'px';
//				}, 300);
//			}
			var IsAdvSearch = false;
//			(function() {
				doInit();
				var ListContainer = document.getElementById('ListContainer');
//				ChangeWindowSize(ListContainer, 2020); // 超过 1280 的最大 1260 ，不全部铺满

				var lnkMoreOption = document.getElementById('lnkMoreOption');
				var lnkHiddenOption = document.getElementById('lnkHiddenOption');
				lnkMoreOption.onclick = function() {
					IsAdvSearch = true;
					document.getElementById('dvMoreOptionBox').style.display = 'block';
					document.getElementById('cb_gather_date').style.visibility = 'visible';
					this.style.visibility = 'hidden';
				};
				lnkHiddenOption.onclick = function() {
					IsAdvSearch = false;
					document.getElementById('dvMoreOptionBox').style.display = 'none';
					document.getElementById('cb_gather_date').style.visibility = 'hidden';
					lnkMoreOption.style.visibility = 'visible';
				};
//			})();
		</script>

		<span id="dialogCase"><div id="dialogBoxBG" style="position: absolute; top: 0px; left: 0px; width: 100%; height: 576px; z-index: 10001; opacity: 0.4; background-color: rgb(0, 0, 0); display: none;"></div><div id="dialogBox" style="border: 1px solid rgb(230, 239, 248); z-index: 10003; position: absolute; width: 900px; left: 194px; top: 42px; display: none;"><table width="100%" border="0" cellpadding="0" cellspacing="0" bgcolor="#FFFFFF"><tbody><tr height="24" id="dialogBoxTitleTr" bgcolor="#E6EFF8"><td><table style="-moz-user-select:none;height:24px;" width="100%" border="0" cellpadding="0" cellspacing="0"><tbody><tr><td width="6" height="24"></td><td id="dialogBoxTitle" style="color: rgb(0, 0, 0); font-size: 14px; font-weight: bold; text-align: left; cursor: move;">反审核&nbsp;</td><td id="dialogClose" width="20" align="right" valign="middle"><img id="dialogBoxClose" src="/images/dialogclose.gif" border="0" align="absmiddle" style="cursor:pointer;" title="关闭"></td><td width="6"></td></tr></tbody></table></td></tr><tr id="dialogTr" style="height:500px" valign="top"><td id="dialogBody" style="position:relative;"></td></tr></tbody></table></div><div id="dialogBoxShadow" style="z-index: 10001; position: absolute; background: rgb(0, 0, 0); opacity: 0.2; top: 46px; left: 198px; width: 902px; height: 526px; display: none;"></div></span>

	</body>

</html>