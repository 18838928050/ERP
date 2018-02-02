<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="s" uri="/struts-tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>业务单反完工 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/Query.css" rel="stylesheet" type="text/css">
		<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/BillList.css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script src="js/popup.js"></script>
		<script src="js/dhtmlgoodies_calendar.js"></script>
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
				//Window_Onload();
			}

			function createPageParaStr() {
				var str = "start_date=" + encodeURIComponent(document.getElementById("start_date").value);
				str = str + "&end_date=" + encodeURIComponent(document.getElementById("end_date").value);
				str = str + "&del_start=" + encodeURIComponent(document.getElementById("del_start").value);
				str = str + "&del_end=" + encodeURIComponent(document.getElementById("del_end").value);
				str = str + "&est_name=" + encodeURIComponent(document.getElementById("est_name").value);
				str = str + "&bill_code=" + encodeURIComponent(document.getElementById("bill_code").value);
				str = str + "&content=" + encodeURIComponent(document.getElementById("content").value);
				str = str + "&mng_name=" + encodeURIComponent(document.getElementById("mng_name").value);
				str = str + "&foll_name=" + encodeURIComponent(document.getElementById("foll_name").value);
				str = str + "&wc_id=" + document.getElementById("wc_id").value;
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
				str = str + "&content=" + encodeURIComponent(document.getElementById("hid_content").value);
				str = str + "&mng_name=" + encodeURIComponent(document.getElementById("hid_mng_name").value);
				str = str + "&foll_name=" + encodeURIComponent(document.getElementById("hid_foll_name").value);
				str = str + "&wc_id=";
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
							ShowAlert('请输入订货单位', {title:'提示框'});
							return;
						}
						str = str + "&cb_est=1";
					}
					if(document.getElementById("cb_wc").checked) {
						var wcId = document.getElementById("wc_id").value;
						if(wcId == null || wcId == "" || wcId == "0") {
							ShowAlert('请选择工作中心', {title:'提示框'});
							return;
						}
						str = str + "&cb_wc=1";
					}
					if(document.getElementById("cb_content").checked) {
						var content = document.getElementById("content").value.trim();
						if(content == null || content == "") {
							ShowAlert('请输入摘要', {title:'提示框'});
							return;
						}
						str = str + "&cb_content=1";
					}
					if(document.getElementById("cb_mng").checked) {
						var mngName = document.getElementById("mng_name").value.trim();
						if(mngName == null || mngName == "") {
							ShowAlert('请输入业务员姓名', {title:'提示框'});
							return;
						}
						str = str + "&cb_mng=1";
					}
					if(document.getElementById("cb_foll").checked) {
						var follName = document.getElementById("foll_name").value.trim();
						if(follName == null || follName == "") {
							ShowAlert('请输入跟单员姓名', {title:'提示框'});
							return;
						}
						str = str + "&cb_foll=1";
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
					if(!checkDateStr(document.getElementById("start_date").value, "订货开始日期")) {
						return;
					}
					if(!checkDateStr(document.getElementById("end_date").value, "订货结束日期")) {
						return;
					}
				}
				var paraStr = createPageParaStr();
				if(paraStr != "") {
					str = str + "&" + paraStr;
				}
				window.location = "/business/BusinessBillListForUnComplete.html?" + str;
			}

			function doGo(pageIndex) {
				var str = getSearchCondition();
				str = str + "&current_page=" + pageIndex;
				window.location = "/business/BusinessBillListForUnComplete.html?" + str;
			}

			function getSearchCondition() {
				var searchType = "1";
				var str = "search_type=" + searchType;
				if(searchType == "1") { //高级
					str = str + "&cb_order_date=1";

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
				var id = "",
					wcId = "";
				if(ob_arr.length >= it.getAttribute("index")) {
					id = ob_arr[it.getAttribute("index") - 1].value;
					wcId = ob_arr[it.getAttribute("index") - 1].getAttribute("wcId");
				}
				if(id == "") {
					return;
				}
				doShow(id, wcId);
			}

			function doAutoCheck(objId) {
				if(document.getElementById(objId).style.visibility != "hidden") {
					document.getElementById(objId).checked = true;
				}
			}

			function doShow(id, wcId) {
				/**var url = "business/BusinessBillInfoForUnComplete.html?id=" + id + "&wc_id=" + wcId;*/
				var url="businessUnFinish_toInfoForUnComplete";
				ShowIframe(['900px','500px'], url, '', function(){
					refreshWin();
				}, '业务单反完工');
			}

			function refreshWin() {
				if(popRetVal != null) {
					window.location = window.location;
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

			function checkInput() {
				if(window.event.keyCode == 13) {
					doSearch();
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
				doAutoCheck("cb_order_date");
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
						<h1>业务单反完工</h1>
						<div class="pull-right">
							<div class="layui-form" style=" display: inline-block;">
								<input type="checkbox" name="cb_order_date" id="cb_order_date" title="订货日期" checked="true" lay-skin="primary">

								<div class="layui-inline">
									<div class="layui-input-inline" style="width: 85px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_order_date');" id="start_date" name="start_date" value="">
			            				<input type="hidden" id="hid_start_date" value="">
									</div>
								</div>
								<div class="layui-inline">
									<div class="layui-form-mid">至</div>
									<div class="layui-input-inline" style="width: 85px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_order_date');" id="end_date" name="end_date" value="">
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
											<input name="" type="checkbox" id="cb_del_date"> 交货日期
										</th>
										<td width="260px">
											<input type="text" class="TextBox Datetime" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_del_date');" id="del_start" name="del_start" value="">
											<img src="/images/calendar.gif" class="imgIconButton" onclick="displayCalendar(document.getElementById('del_start'),'yyyy-mm-dd',this,false,'doAutoCheck(\'cb_del_date\')');">
											<input type="hidden" id="hid_del_start" value=""> 至
											<input type="text" class="TextBox Datetime" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_del_date');" id="del_end" name="del_end" value="">
											<img src="/images/calendar.gif" class="imgIconButton" onclick="displayCalendar(document.getElementById('del_end'),'yyyy-mm-dd',this,false,'doAutoCheck(\'cb_del_date\')');">
											<input type="hidden" id="hid_del_end" value="">
										</td>
										<th class="c2" width="80px">
											<input type="checkbox" name="cb_mng" id="cb_mng"> 业务员
										</th>
										<td class="c3" width="250px">
											<input type="text" class="TextBox" maxlength="15" name="mng_name" id="mng_name" onkeyup="checkInput();" onfocus="doAutoCheck('cb_mng');" value="">
											<img class="imgIconButton" src="/images/make-a.gif" onclick="selectStafferName('mng_name','cb_mng');">
											<input type="hidden" id="hid_mng_name" value="">
										</td>
									</tr>
									<tr>
										<th class="c1">
											<input type="checkbox" name="cb_bill_code" id="cb_bill_code"> 业务单号
										</th>
										<td class="c1">
											<input type="text" class="TextBox" maxlength="50" name="bill_code" id="bill_code" onfocus="doAutoCheck('cb_bill_code');" onkeyup="checkInput();" value="">
											<input type="hidden" id="hid_bill_code" value="">
										</td>
										<th class="c2">
											<input type="checkbox" name="cb_foll" id="cb_foll"> 跟单员
										</th>
										<td class="c3">
											<input type="text" class="TextBox" maxlength="15" name="foll_name" id="foll_name" onkeyup="checkInput();" onfocus="doAutoCheck('cb_foll');" value="">
											<img src="/images/make-a.gif" class="imgIconButton" onclick="selectStafferName('foll_name','cb_foll');">
											<input type="hidden" id="hid_foll_name" value="">
										</td>
									</tr>
									<tr>
										<th class="c1">
											<input type="checkbox" name="cb_est" id="cb_est"> 订货单位
										</th>
										<td class="c1">
											<input type="text" class="TextBox" maxlength="50" name="est_name" id="est_name" onkeyup="checkInput();" onfocus="doAutoCheck('cb_est');" value="">
											<img class="imgIconButton" src="/images/make-a.gif" onclick="selectEstName();">
											<input type="hidden" id="hid_est_name" value="">
										</td>
										<th class="c2">
											<input type="checkbox" name="cb_wc" id="cb_wc"> 工作中心
										</th>
										<td class="c3">
											<select name="wc_id" id="wc_id" onfocus="doAutoCheck('cb_wc');" onchange="doWcIdChange();">
												<option value="0">==请选择==</option>

												<option value="12">标识部</option>

												<option value="13">标牌部</option>

												<option value="14">铝材加工</option>

												<option value="16">成品销售</option>

											</select>
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
											<input type="checkbox" name="cb_ts" id="cb_ts" checked="true"> 账套
										</th>
										<td class="c3">
											<select name="ts_id" id="ts_id" onfocus="doAutoCheck('cb_ts');">
												<option value="0">==请选择账套==</option>

												<option value="1">新异</option>
												<option value="2" selected="">网络公司</option>
											</select>
										</td>
									</tr>
								</tbody>
							</table>
							<div class="OptionOrderBy">
								<input type="checkbox" name="cb_order" id="cb_order"> 排序类型
								<select name="order_by" id="order_by" onfocus="doAutoCheck('cb_order');">
									<option value="">==请选择==</option>
									<option value="ORDER_DATE">订货日期</option>
									<option value="DELIVER_DATE">交货日期</option>
									<option value="BILL_CODE">业务单号</option>
								</select>
								<select name="order_sc" id="order_sc" onfocus="doAutoCheck('cb_order');">
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
					
					<p style="line-height: 25px;">将业务单项目恢复为未完工状态</p>

					<div class="table-list">
						<table width="100%">
							<tbody>
								<tr>
									<th width="14%">单号</th>
									<th width="10%">订货日期</th>
									<th width="18%">订货单位</th>
									<th width="16%">摘要</th>
									<th width="10%">交货日期</th>
									<th width="16%">跟单员</th>
									<th width="10%">工作中心</th>
									<th width="6%">操作</th>
								</tr>
						<s:iterator value="businessBills" status="businessBills">
						<tr class="query_list_data_tr1" index="1" style="cursor:pointer;" onclick="javascript:ClickCheck(this)" ondblclick="javascript:DoubleClick(this)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
						<td>
							${billCode}
							<input type="radio" name="query_checkbox" value="4018" wcid="15" style="display:none">
						</td>
						<td>${orderDate}</td>
						<td>
							<s:iterator value="establishments" status="establishments">
							<c:if test=""></c:if>
							</s:iterator>
						</td>
                        <td>${content}</td>
						<td>
							${deliverDate}
						</td>
						<td>${followerNameStr}</td>
						<td></td>
						<td>
							<a href="javascript:doShow('${id}','15');">查看</a>
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
			layui.use('laydate', function() {
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
					document.getElementById('cb_order_date').style.visibility = 'visible';
					this.style.visibility = 'hidden';
				};
				lnkHiddenOption.onclick = function() {
					IsAdvSearch = false;
					document.getElementById('dvMoreOptionBox').style.display = 'none';
					document.getElementById('cb_order_date').style.visibility = 'hidden';
					lnkMoreOption.style.visibility = 'visible';
				};
//			})();
		</script>
	</body>

</html>