<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<META http-equiv=Content-Type content="text/html; charset=utf-8">
	<META http-equiv=Pragma content=no-cache>
	<META http-equiv=Cache-Control content=no-cache>
	<META http-equiv=Expires content=0>
	<TITLE>要外协的业务单 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</TITLE>
	<link href="layui/css/layui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/base.css">
	<link href="css/Query.css" rel="stylesheet" type="text/css">
	<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/BillList.css" />

	<script src="js/minierp.js"></script>
	<script src="js/QueryList.js"></script>
	<script src="js/popup.js"></script>
	<script src="js/dhtmlgoodies_calendar.js"></script>

	<head>
		<script language="javascript">
			function doJump(pageIndex) {
				if(window.event.keyCode == 13) {
					doGo(pageIndex);
				}
			}

			function doCancel() {
				window.close();
			}

			function doInit() {
				Window_Onload();
				document.getElementById("bill_code").focus();
			}

			function createPageParaStr() {
				var str = "start_date=" + encodeURIComponent(document.getElementById("start_date").value);
				str = str + "&end_date=" + encodeURIComponent(document.getElementById("end_date").value);
				str = str + "&del_start=" + encodeURIComponent(document.getElementById("del_start").value);
				str = str + "&del_end=" + encodeURIComponent(document.getElementById("del_end").value);
				str = str + "&est_name=" + encodeURIComponent(document.getElementById("est_name").value);
				str = str + "&bill_code=" + encodeURIComponent(document.getElementById("bill_code").value);
				str = str + "&foll_name=" + encodeURIComponent(document.getElementById("foll_name").value);
				str = str + "&ts_id=" + document.getElementById("ts_id").value;
				str = str + "&order_by=" + document.getElementById("order_by").value;
				str = str + "&order_sc=" + document.getElementById("order_sc").value;

				return str;
			}

			function createProgramParaStr() {
				var str = "start_date=" + encodeURIComponent(document.getElementById("hid_start_date").value);
				str = str + "&end_date=" + encodeURIComponent(document.getElementById("hid_end_date").value);
				str = str + "&del_start=" + encodeURIComponent(document.getElementById("hid_del_start").value);
				str = str + "&del_end=" + encodeURIComponent(document.getElementById("hid_del_end").value);
				str = str + "&est_name=" + encodeURIComponent(document.getElementById("hid_est_name").value);
				str = str + "&bill_code=" + encodeURIComponent(document.getElementById("hid_bill_code").value);
				str = str + "&foll_name=" + encodeURIComponent(document.getElementById("hid_foll_name").value);
				str = str + "&ts_id=2";
				str = str + "&order_by=";
				str = str + "&order_sc=";

				return str;
			}

			function doSearch() {
				var str;
				if(IsAdvSearch) { //高级
					str = "search_type=1";
					if(document.getElementById("cb_bill_code").checked) {
						var billCode = document.getElementById("bill_code").value.trim();
						if(billCode == null || billCode == "") {
							ShowAlert('请输入业务单号', {title:'提示框'});
							return;
						}
						str = str + "&cb_bill_code=1";
					}
					if(document.getElementById("cb_order_date").checked) {
						if(!checkDateStr(document.getElementById("start_date").value, "订货开始日期")) {
							return;
						}
						if(!checkDateStr(document.getElementById("end_date").value, "订货结束日期")) {
							return;
						}
						str = str + "&cb_order_date=1";
					}
					if(document.getElementById("cb_del_date").checked) {
						if(!checkDateStr(document.getElementById("del_start").value, "交货开始日期")) {
							return;
						}
						if(!checkDateStr(document.getElementById("del_end").value, "交货结束日期")) {
							return;
						}
						str = str + "&cb_del_date=1";
					}

					if(document.getElementById("cb_est").checked) {
						var estName = document.getElementById("est_name").value.trim();
						if(estName == null || estName == "") {
							ShowAlert('提示框', '请输入订货单位', 200, 100);
							return;
						}
						str = str + "&cb_est=1";
					}
					if(document.getElementById("cb_foll").checked) {
						var follName = document.getElementById("foll_name").value.trim();
						if(follName == null || follName == "") {
							ShowAlert('提示框', '请输入跟单员姓名', 200, 100);
							return;
						}
						str = str + "&cb_foll=1";
					}
					if(document.getElementById("cb_ts").checked) {
						var tsId = document.getElementById("ts_id").value;
						if(tsId == null || tsId == "" || tsId == "0") {
							ShowAlert('提示框', '请选择帐套', 200, 100);
							return;
						}
						str = str + "&cb_ts=1";
					}
					if(document.getElementById("cb_order").checked) {
						var orderBy = document.getElementById("order_by").value;
						if(orderBy == null || orderBy == "") {
							ShowAlert('提示框', '请选择排序类型', 200, 100);
							return;
						}
						str = str + "&cb_order=1";
					}
				} else { //快速
					str = "search_type=2";
				}
				var paraStr = createPageParaStr();
				if(paraStr != "") {
					str = str + "&" + paraStr;
				}
				window.location = "cooper/BusinessBillListForCooper.html?" + str;
			}

			function doGo(pageIndex) {
				var str = getSearchCondition();
				str = str + "&current_page=" + pageIndex;
				window.location = "cooper/BusinessBillListForCooper.html?" + str;
			}

			function getSearchCondition() {
				var searchType = "1";
				var str = "search_type=" + searchType;
				if(searchType == "1") { //高级

					str = str + "&cb_ts=1";

				} else { //快速

				}
				var paraStr = createProgramParaStr();
				if(paraStr != "") {
					str = str + "&" + paraStr;
				}
				return str;
			}

			function DoubleClick(it) {
				var ob_arr = document.getElementsByName("query_checkbox");
				var id = "";
				if(ob_arr.length >= it.getAttribute("index")) {
					id = ob_arr[it.getAttribute("index") - 1].value;
				}
				if(id == "") {
					return;
				}
				doPrint(id);
			}

			function doAutoCheck(objId) {
				if(document.getElementById(objId).style.visibility != "hidden") {
					document.getElementById(objId).checked = true;
				}
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

			function showItems(billId, billCode) {
				var url = "subcontract_toCooperBillItem?id="+billId;
				ShowIframe(['900px','500px'], url, '', '', '业务单明细');
			}

			function showAccessories(id, billCode) {
				var url = "make/AccessoryListAlone.html?acc_type=COOPER&agent_type=BUSINESS_BILL&agent_id=" + id + "&mark=" + encodeURIComponent("业务单：" + billCode);
				ShowIframe(['900px','500px'], url, '', '', '图样');
			}

			function setDate(type) {
				var d = new Date();
				var startStr = "";
				var endStr = "";
				if(type == "CURRENT_MONTH") {
					startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-01";
					endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				} else if(type == "LAST_MONTH") {
					endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
					d.setMonth(d.getMonth() - 1);
					startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				} else if(type == "LAST_WEEK") {
					endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
					d.setDate(d.getDate() - 7);
					startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				} else if(type == "PREVIEW_MONTH") {
					d = new Date(d.getFullYear(), d.getMonth(), 1);
					d.setDate(d.getDate() - 1);
					startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-1";
					endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				}
				document.getElementById("start_date").value = startStr;
				document.getElementById("end_date").value = endStr;
			}

			function doPrint(id) {
				var url = "business/BusinessBillPrint.html?type=COOPER&id=" + id;
				top.showWin(['900px','600px'], url);
			}

			function checkInput() {
				if(window.event.keyCode == 13) {
					doSearch();
				}
			}

			function doCooperNew(bbId) {
				var url = "cooper/CooperBillNew.html?type=BUSINESS&alert_type=FORM&bb_id=" + bbId;
				top.showWin(['1280px','600px'], url);
			}

			function doComplete(idStr) {
				//ShowConfirm('确认框','确定将选择的业务单完工吗？',340,80,"doCompleteCallBack('"+idStr+"')");
				var url = "/cooper/BusinessBillInfoForCooComp.html?id=" + idStr;
				ShowIframe(['900px','500px'], url, '', function(){
					refreshWin();
				}, '业务单外协完工');
			}
			/**
			function doCompleteCallBack(idStr){
				if(popRetVal!=null){
					var url="/cooper/BusinessBillCooCompBatch.html?id_str="+idStr;
					ShowIframe("业务单完工",url,200,200,"refreshWin()");
				}
			}
			**/
			function refreshWin() {
				if(popRetVal != null) {
					window.location.reload(true);
				}
			}

			function selectEstName() {
				var url = "base/EstablishmentListForSelect.html?type=CLIENT";
				ShowIframe(['900px','500px'], url, '', function(){
					selectEstNameCallBack();
				}, '选择客户');
			}

			function selectEstNameCallBack() {
				if(popRetVal != null) {
					document.getElementById("est_name").value = popRetVal[1];
					doAutoCheck("cb_est");
				}
			}

			function showRelBill(code) {
				var url = "business/BusinessRelBillList.html?code=" + encodeURIComponent(code);
				top.showWin(['1024px','600px'], url);
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
						<h1>要外协的业务单</h1>
						<div class="pull-right">
							<div class="layui-form" style=" display: inline-block;">
								<input type="checkbox" name="cb_bill_code" id="cb_bill_code" title="业务单号" checked="true" lay-skin="primary">
								<input type="hidden" id="hid_bill_code" value="">
								<div class="layui-input-inline">
									<input type="text" class="layui-input" maxlength="50" name="bill_code" id="bill_code" onKeyUp="checkInput();" onFocus="doAutoCheck('cb_bill_code');" value="">
								</div>
								<a type="button " class="layui-btn " href="javascript:;" id="lnkMoreOption">更多查询选项</a>
								<a type="button " class="layui-btn " id="sSearchButton" name="sSearchButton" onclick="doSearch();">查 询</a>
							</div>
						</div>
					</div>
				</div>

				<!-- 主内容 -->
				<div class="Content">
					<!-- 筛选控件栏 -->
					<div class="FilterBar ClearFix" style="margin: 15px 0;">
						<div id="dvMoreOptionBox" class="MoreOptionBox" style="display:none;">
							<table class="MoreOption" cellpadding="0" cellspacing="0">
								<tr>
									<th class="c1" width="80px">
										<input type="checkbox" name="cb_order_date" id="cb_order_date"> 订货日期
									</th>
									<td width="240px">
										<input type="text" class="TextBox Datetime" maxlength="15" onKeyUp="checkInput();" onFocus="doAutoCheck('cb_order_date');" id="start_date" name="start_date" value="">
										<img src="images/calendar.gif" class="imgIconButton" onClick="displayCalendar(document.getElementById('start_date'),'yyyy-mm-dd',this,false,'doAutoCheck(\'cb_order_date\')');">
										<input type="hidden" id="hid_start_date" value=""> 至
										<input type="text" class="TextBox Datetime" maxlength="15" onKeyUp="checkInput();" onFocus="doAutoCheck('cb_order_date');" id="end_date" name="end_date" value="">
										<img src="images/calendar.gif" class="imgIconButton" onClick="displayCalendar(document.getElementById('end_date'),'yyyy-mm-dd',this,false,'doAutoCheck(\'cb_order_date\')');">
										<input type="hidden" id="hid_end_date" value="">
									</td>
									<th class="c2" width="80px">
										<input type="checkbox" name="cb_est" id="cb_est"> 订货单位
									</th>
									<td class="c3" width="280px">
										<input type="text" class="TextBox" maxlength="50" name="est_name" id="est_name" onKeyUp="checkInput();" onFocus="doAutoCheck('cb_est');" value="">
										<img class="imgIconButton" src="images/make-a.gif" onClick="selectEstName();" />
										<input type="hidden" id="hid_est_name" value="">
									</td>
								</tr>
								<tr>
									<th class="c1">
										<input name="" type="checkbox" name="cb_del_date" id="cb_del_date"> 交货日期
									</th>
									<td>
										<input type="text" class="TextBox Datetime" maxlength="15" onKeyUp="checkInput();" onFocus="doAutoCheck('cb_del_date');" id="del_start" name="del_start" value="">
										<img src="images/calendar.gif" class="imgIconButton" onClick="displayCalendar(document.getElementById('del_start'),'yyyy-mm-dd',this,false,'doAutoCheck(\'cb_del_date\')');">
										<input type="hidden" id="hid_del_start" value=""> 至
										<input type="text" class="TextBox Datetime" maxlength="15" onKeyUp="checkInput();" onFocus="doAutoCheck('cb_del_date');" id="del_end" name="del_end" value="">
										<img src="images/calendar.gif" class="imgIconButton" onClick="displayCalendar(document.getElementById('del_end'),'yyyy-mm-dd',this,false,'doAutoCheck(\'cb_del_date\')');">
										<input type="hidden" id="hid_del_end" value="">
									</td>
									<th class="c2">
										<input type="checkbox" name="cb_foll" id="cb_foll"> 跟单员
									</th>
									<td class="c3">
										<input type="text" class="TextBox" maxlength="15" name="foll_name" id="foll_name" onKeyUp="checkInput();" onFocus="doAutoCheck('cb_foll');" value="">
										<img class="imgIconButton" src="images/make-a.gif" onClick="selectStafferName('foll_name','cb_foll');" style="cursor:pointer;" />
										<input type="hidden" id="hid_foll_name" value="">
									</td>
								</tr>
								<tr>
									<th class="c1">
										<input type="checkbox" name="cb_ts" id="cb_ts" checked="true"> 账套
									</th>
									<td class="c1">
										<select name="ts_id" id="ts_id" onFocus="doAutoCheck('cb_ts');">
											<option value="0">==请选择账套==</option>

											<option value="1">新异</option>
											<option value="2" selected>网络公司</option>
										</select>
									</td>
									<th class="c2">&nbsp;</th>
									<td class="c2">&nbsp;</td>
								</tr>
							</table>

							<div class="OptionOrderBy">
								<input type="checkbox" name="cb_order" id="cb_order"> 排序类型
								<select name="order_by" id="order_by" onFocus="doAutoCheck('cb_order');">
									<option value="">==请选择==</option>
									<option value="ORDER_DATE">订货日期</option>
									<option value="DELIVER_DATE">交货日期</option>
									<option value="BILL_CODE">业务单号</option>
								</select>
								<select name="order_sc" id="order_sc" onFocus="doAutoCheck('cb_order');">
									<option value="ASC">升序</option>
									<option value="DESC">降序</option>
								</select>
								<span class="fr"><a href="javascript:;" id="lnkHiddenOption">隐藏查询选项</a></span>
							</div>
						</div>
					</div>

					<!-- 提示信息显示栏 -->
					<div class="MsgBar">

						<table width="98%" border="0" cellpadding="0" cellspacing="0">
							<tr id="errorMsgTr" style="display:none">
								<td>
									<div class="msg-error" id="errorMsgTd">

									</div>
								</td>
							</tr>
						</table>
					</div>

					<div class="table-list">
						<table width="100%">
							<tr>
								<th width="14%">单号</th>
								<th width="8%">订货日期</th>
								<th width="22%">订货单位</th>
								<th width="16%">摘要</th>
								<th width="8%">交货日期</th>
								<th width="18%">跟单员</th>
								<th width="14%">操作</th>
							</tr>
							
							<s:iterator value="coopers" status="indexs">
							<tr class="query_list_data_tr${indexs.index+1 }" index="${indexs.index+1 }" style="color:black;cursor:pointer;" defaultfontcolor="black" onclick="javascript:ClickCheck(this)" ondblclick="javascript:DoubleClick(this)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
								<td>
									${billCode }
									<input type="radio" name="query_checkbox" value="${id }" style="display:none">
								</td>
								<td>${cooperDate }</td>
								<td>${cooperatorId }</td>
								<td>${mark }</td>
								<td>
									${gatherDate }
								</td>
								<td>${managerName }</td>
								<td>
									<a href="javascript:showRelBill('${billCode }');">查看</a>
									<a href="javascript:showAccessories('${id }','${billCode }');">图样</a>
									<a href="javascript:showItems('${id }','${billCode }');">明细</a>

									<br>
									<a href="javascript:doCooperNew('${id }');">开外协单</a>

								</td>
							</tr>
							</s:iterator>
							
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
			layui.use('laydate', function() {
				var laydate = layui.laydate;

				//执行一个laydate实例
				laydate.render({
					elem: '#start_date' //指定元素
				});
				laydate.render({
					elem: '#end_date'
				});
			});
		</script>
<script type="text/javascript">
//	function ChangeWindowSize(container, maxWidth) {
//		setTimeout(function() {
//			var w1 = document.documentElement.clientWidth - 40;
//			if(w1 > maxWidth) w1 = maxWidth;
//			else if(w1 < 970) w1 = 960;
//			container.style.width = w1 + 'px';
//		}, 300);
//	}
	var IsAdvSearch = false;
	var ListContainer = document.getElementById('ListContainer');
//	(function() {
//		doInit();
//		ChangeWindowSize(ListContainer, 2020); // 超过 1280 的最大 1260 ，不全部铺满

		var lnkMoreOption = document.getElementById('lnkMoreOption');
		var lnkHiddenOption = document.getElementById('lnkHiddenOption');
		lnkMoreOption.onclick = function() {
			IsAdvSearch = true;
			document.getElementById('dvMoreOptionBox').style.display = 'block';
			document.getElementById('cb_bill_code').style.visibility = 'visible';
			this.style.visibility = 'hidden';
		};
		lnkHiddenOption.onclick = function() {
			IsAdvSearch = false;
			document.getElementById('dvMoreOptionBox').style.display = 'none';
			document.getElementById('cb_bill_code').style.visibility = 'hidden';
			lnkMoreOption.style.visibility = 'visible';
		};
//	})();
</script>
	</body>

</html>