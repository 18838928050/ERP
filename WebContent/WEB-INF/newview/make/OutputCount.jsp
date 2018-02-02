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
		<title>产量统计表 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
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
			function createPageParaStr() {
				var str = "start_date=" + encodeURIComponent(document.getElementById("start_date").value);
				str = str + "&end_date=" + encodeURIComponent(document.getElementById("end_date").value);
				str = str + "&maker_name=" + encodeURIComponent(document.getElementById("maker_name").value);
				str = str + "&maker_id=" + document.getElementById("maker_id").value;
				str = str + "&wc_id=" + document.getElementById("wc_id").value;
				str = str + "&pro_id=" + document.getElementById("pro_id").value;
				str = str + "&mt_id=" + document.getElementById("mt_id").value;
				str = str + "&ts_id=" + document.getElementById("ts_id").value;
				str = str + "&dep_id=" + document.getElementById("dep_id").value;
				return str;
			}

			function createProgramParaStr() {
				var str = "start_date=" + encodeURIComponent(document.getElementById("hid_start_date").value);
				str = str + "&end_date=" + encodeURIComponent(document.getElementById("hid_end_date").value);
				str = str + "&maker_name=" + encodeURIComponent(document.getElementById("hid_maker_name").value);
				str = str + "&maker_id=";
				str = str + "&wc_id=";
				str = str + "&pro_id=";
				str = str + "&mt_id=";
				str = str + "&ts_id=2";
				str = str + "&dep_id=";
				return str;
			}

			function doSearch() {
				var str;
				if(IsAdvSearch) { //高级
					str = "search_type=1";
					if(document.getElementById("cb_make_date").checked) {
						if(!checkDateStr(document.getElementById("start_date").value, "开始日期")) {
							return;
						}
						if(!checkDateStr(document.getElementById("end_date").value, "结束日期")) {
							return;
						}
						str = str + "&cb_make_date=1";
					}
					if(document.getElementById("cb_wc").checked) {
						var wcId = document.getElementById("wc_id").value;
						if(wcId == null || wcId == "" || wcId == "0") {
							ShowAlert('请选择工作中心', {
								title: '提示框'
							});
							return;
						}
						str = str + "&cb_wc=1";
					}
					if(document.getElementById("cb_dep").checked) {
						var depId = document.getElementById("dep_id").value;
						if(depId == null || depId == "" || depId == "0") {
							ShowAlert('请选择部门', {
								title: '提示框'
							});
							return;
						}
						str = str + "&cb_dep=1";
					}
					if(document.getElementById("cb_maker").checked) {
						var makerId = document.getElementById("maker_id").value;
						if(makerId == null || makerId == "" || makerId == "0") {
							ShowAlert('请选择制作人', {
								title: '提示框'
							});
							return;
						}
						str = str + "&cb_maker=1";
					}
					if(document.getElementById("cb_mt").checked) {
						var mtId = document.getElementById("mt_id").value;
						if(mtId == null || mtId == "" || mtId == "0") {
							ShowAlert('请选择项目类型', {
								title: '提示框'
							});
							return;
						}
						str = str + "&cb_mt=1";
					}
					if(document.getElementById("cb_ts").checked) {
						var tsId = document.getElementById("ts_id").value;
						if(tsId == null || tsId == "" || tsId == "0") {
							ShowAlert('请选择帐套', {
								title: '提示框'
							});
							return;
						}
						str = str + "&cb_ts=1";
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
				window.location = "/make/OutputCount.html?" + str;
			}

			function doGo(pageIndex) {
				var str = getSearchCondition();
				str = str + "&current_page=" + pageIndex;
				window.location = "/make/OutputCount.html?" + str;
			}

			function getSearchCondition() {
				var searchType = "1";
				var str = "search_type=" + searchType;
				if(searchType == "1") { //高级
					str = str + "&cb_make_date=1";

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

			}

			function doDownload() {
				var str = getSearchCondition();
				window.location = "/make/OutputCount.html?content_type=EXCEL&" + str;
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

			function selectStafferName() {
				var url = "/base/StafferMainForSelect.html";
				var cb = "selectStafferNameCallBack()";
				ShowIframe(['800px', '500px'], url, '', cb, '选择员工');
			}

			function selectStafferNameCallBack() {
				if(popRetVal != null) {
					var arr = popRetVal.split(";");
					document.getElementById("maker_id").value = arr[0];
					document.getElementById("maker_name").value = arr[1];
					doAutoCheck("cb_maker");
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
				doAutoCheck("cb_make_date");
			}

			function doWcChange() {
				var proSele = document.getElementById("pro_id");
				proSele.options.length = 0; //删除所有选项
				var opt = document.createElement("option");
				opt.setAttribute("value", "0");
				if(checkNavigator()[0] != "msie") {
					opt.innerText = "==工序==";
				} else {
					opt.text = "==工序==";
					//opt.setAttribute("text","==工序==");//ie
				}
				try {
					proSele.options.add(opt, null);
				} catch(ex) {
					proSele.options.add(opt); //ie
				}
				var wcId = document.getElementById("wc_id").value;
				if(wcId != "" && wcId != "0") {
					var xmlHttp = createXMLHttpRequest();
					xmlHttp.open("GET", "/base/GetWorkCenterProcess.html?wc_id=" + wcId, true);
					xmlHttp.onreadystatechange = function() {
						if(xmlHttp.readyState == 4) {
							if(xmlHttp.status == 200) {
								var arr = xmlHttp.responseXML.getElementsByTagName("process");
								if(arr.length > 0) {
									for(var i = 0; i < arr.length; i++) {
										var children = arr[i].childNodes;
										var proId = "0";
										var proName = "";
										for(var j = 0; j < children.length; j++) {
											if(children[j].tagName == "id") {
												proId = children[j].firstChild.data;
											} else if(children[j].tagName == "proName") {
												proName = children[j].firstChild.data;
											}
										}
										opt = document.createElement("option");
										opt.setAttribute("value", proId);
										if(checkNavigator()[0] != "msie") {
											opt.innerText = proName;
										} else {
											opt.text = proName;
											//opt.setAttribute("text",proName);//ie
										}
										try {
											proSele.add(opt, null);
										} catch(ex) {
											proSele.add(opt); //ie
										}
									}
								}
							}
						}
					};
					xmlHttp.send(null);
				}
			}
		</script>
	</head>

	<body>
		<div class="Wrap">
			<!-- 页面主框架 -->

			<div id="ListContainer" class="Container">
				<!-- 主体容器 -->

				<!-- 标题栏 -->
				<div class="Heading BillIcon">
					<div class="HeadingContent">
						<h1>产量统计表</h1>
						<div class="pull-right">
							<div class="layui-form" style=" display: inline-block;">
								<input type="checkbox" name="cb_make_date" id="cb_make_date" title="制作日期" checked="true" lay-skin="primary">

								<div class="layui-inline">
									<div class="layui-input-inline" style="width: 85px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_make_date');" id="start_date" name="start_date" value="">
										<input type="hidden" id="hid_start_date" value="">
									</div>
								</div>
								<div class="layui-inline">
									<div class="layui-form-mid">至</div>
									<div class="layui-input-inline" style="width: 85px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_make_date');" id="end_date" name="end_date" value="">
										<input type="hidden" id="hid_end_date" value="">
									</div>
								</div>
								<a type="button " class="layui-btn " href="javascript:;" id="lnkMoreOption">更多查询选项</a>
								<a type="button " class="layui-btn " onclick="doSearch();" id="sSearchButton" name="sSearchButton">查 询</a>
								<a type="button " class="layui-btn " onclick="doDownload();" id="sDownloadButton" name="sDownloadButton">导 出</a>
							</div>
						</div>
					</div>
				</div>

				<!-- 主内容 -->
				<div class="Content">
					<!-- 筛选控件栏 -->
					<div class="FilterBar ClearFix">
						<div id="dvMoreOptionBox" class="MoreOptionBox" style="display: none;">
							<table class="MoreOption" cellpadding="0" cellspacing="0">
								<tbody>
									<tr>
										<th class="c1" width="80px">
											<input type="checkbox" name="cb_wc" id="cb_wc"> 工作中心
										</th>
										<td class="c1" width="260px">
											<select style="width:99px" name="wc_id" id="wc_id" onfocus="doAutoCheck('cb_wc');" onchange="doWcChange();">
												<option value="0">==请选择==</option>

												<option value="12">标识部</option>

												<option value="13">标牌部</option>

												<option value="14">铝材加工</option>

												<option value="16">成品销售</option>

											</select>
											<select style="width:99px" name="pro_id" id="pro_id" onfocus="doAutoCheck('cb_wc');">
												<option value="0">==工序==</option>

											</select>
										</td>
									</tr>
									<tr>
										<th class="c1">
											<input type="checkbox" name="cb_dep" id="cb_dep"> 部门
										</th>
										<td class="c1">
											<select name="dep_id" id="dep_id" onfocus="doAutoCheck('cb_dep');">
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
											<input type="checkbox" name="cb_maker" id="cb_maker"> 制作人
										</th>
										<td class="c1">
											<input type="text" class="TextBox readonly" maxlength="15" name="maker_name" id="maker_name" readonly="true" onfocus="doAutoCheck('cb_maker');" value="">
											<img class="imgIconButton" src="/images/make-a.gif" onclick="selectStafferName();">
											<input type="hidden" id="hid_maker_name" value="">
											<input type="hidden" id="maker_id" value="">
										</td>
									</tr>
									<tr>
										<th class="c1">
											<input type="checkbox" name="cb_mt" id="cb_mt"> 项目类型
										</th>
										<td class="c1">
											<select name="mt_id" id="mt_id" onfocus="doAutoCheck('cb_mt');">
												<option value="0">==请选择==</option>

												<option value="10">标牌</option>
												<option value="11">标识</option>
												<option value="109">标识标牌</option>
												<option value="110">&nbsp;|--指示牌</option>
												<option value="111">&nbsp;|--警示牌</option>
												<option value="112">&nbsp;|--桌牌</option>
												<option value="113">&nbsp;|--立牌</option>
												<option value="114">&nbsp;|--展示牌</option>
												<option value="115">&nbsp;|--户外标识</option>
												<option value="116">广告字</option>
												<option value="117">&nbsp;|--不发光立体字</option>
												<option value="118">&nbsp;|--背光立体字</option>
												<option value="119">&nbsp;|--发光立体字</option>
												<option value="120">&nbsp;|--光树脂发光立体字</option>
												<option value="121">&nbsp;|--立体发光立体字</option>
												<option value="13">型材销售</option>
												<option value="17">&nbsp;|--画框型材</option>
												<option value="18">&nbsp;|--画框配件</option>
												<option value="34">灯箱</option>
												<option value="122">&nbsp;|--吸塑灯箱</option>
												<option value="123">&nbsp;|--超薄灯箱</option>
												<option value="124">&nbsp;|--落地式灯箱</option>
												<option value="125">&nbsp;|--软膜灯箱</option>
												<option value="126">&nbsp;|--动态灯箱</option>
												<option value="127">&nbsp;|--LED灯箱</option>
												<option value="128">门头店招</option>
												<option value="129">&nbsp;|--彩条店招</option>
												<option value="130">&nbsp;|--模组店招</option>
												<option value="131">&nbsp;|--拉布内光店招</option>
												<option value="132">&nbsp;|--异形店招</option>
												<option value="163">&nbsp;|--王明超</option>
												<option value="97">标牌配件</option>
												<option value="98">东厂</option>
												<option value="133">快展器材</option>
												<option value="134">&nbsp;|--快展背景墙</option>
												<option value="135">&nbsp;|--X展架</option>
												<option value="136">&nbsp;|--易拉宝</option>
												<option value="137">&nbsp;|--注水旗杆</option>
												<option value="138">&nbsp;|--快展套装</option>
												<option value="99">成品标牌</option>
												<option value="139">展柜展架</option>
												<option value="140">&nbsp;|--靠墙柜</option>
												<option value="141">&nbsp;|--中岛柜</option>
												<option value="142">&nbsp;|--平柜</option>
												<option value="143">&nbsp;|--收银台</option>
												<option value="144">&nbsp;|--挂架</option>
												<option value="145">&nbsp;|--端架</option>
												<option value="146">&nbsp;|--地台</option>
												<option value="147">印刷</option>
												<option value="148">&nbsp;|--名片</option>
												<option value="149">&nbsp;|--宣传单</option>
												<option value="150">&nbsp;|--画册</option>
												<option value="151">&nbsp;|--手提袋</option>
												<option value="152">&nbsp;|--台挂历</option>
												<option value="153">促销用品</option>
												<option value="154">&nbsp;|--吊旗</option>
												<option value="155">&nbsp;|--太阳伞</option>
												<option value="156">&nbsp;|--条幅横幅</option>
												<option value="157">&nbsp;|--挂墙展板</option>
												<option value="158">&nbsp;|--拱门气球</option>
												<option value="159">&nbsp;|--礼品</option>
												<option value="103">喷绘</option>
												<option value="104">&nbsp;|--挂画</option>
												<option value="105">&nbsp;|--灯箱画片</option>
												<option value="106">&nbsp;|--高精图像片</option>
												<option value="107">&nbsp;|--户外彩喷</option>
												<option value="108">&nbsp;|--车身彩绘</option>
												<option value="161">铝型材配件(塑料)</option>
												<option value="162">铝型材(销售用)</option>
											</select>
										</td>
									</tr>
									<tr>
										<th class="c1">
											<input type="checkbox" name="cb_ts" id="cb_ts" checked="true"> 帐套
										</th>
										<td class="c1">
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

					<div class="TopToolBar">
						<table class="ListNoteInfo" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td>
										<span class="Note">统计制作人员在各个工序的完工量和计件产值</span>
										<br /> 完工量合计：10&nbsp;&nbsp; 计件产值合计：0.00&nbsp;&nbsp;
									</td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="table-list">
						<table width="100%">
							<tbody>
								<tr>
									<th width="10%">工作中心</th>
									<th width="10%">工序</th>
									<th width="8%">部门</th>
									<th width="8%">制作人</th>
									<th width="12%">项目类型</th>
									<th width="14%">材质</th>
									<th width="8%">计量单位</th>
									<th width="10%">完工量</th>
									<th width="10%">计件单价</th>
									<th width="10%">计件产值</th>
								</tr>
				           <s:iterator value="workProcesss" status="indexs">
								<tr class="query_list_data_trSelected" index="1" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
							      <td>
						           <s:iterator value="workCenters" status="workCenters">
					   		              <c:if test="${id == workCenterId }">${wcName}</c:if>
					   		              <input type="radio" name="query_checkbox" value="0" style="display:none">
					               </s:iterator>
								  </td>
								  <td>${processName}</td>
								  <td>
								  <s:iterator value="departs" status="departs">
								  <c:if test="${id == depId}">${departmentName}</c:if>
								  </s:iterator>
								  </td>
                                  <td>
                                  <s:iterator value="outPuts" status="outPuts">
                                  <c:if test="${processId == id }">${makerName}</c:if>
                                  </s:iterator>
                                  </td>
                                  <td>
                                  <s:iterator value="makeTypes" status="makeTypes">  
                                         <c:if test="${workCenterId == workCenterid }">${typeName}</c:if>
                                  </s:iterator>
                                  </td>
                                  <td></td>
                                  <td>
                                  <s:iterator value="makeTypes" status="makeTypes">
                                         <c:if test="${workCenterId == workCenterid }">${unit}</c:if>
                                  </s:iterator>
                                  </td>
                                 <td>
								<s:iterator value="outPuts" status="outPuts">
								 <c:if test="${processId == id }">${amount}</c:if>
								</s:iterator>
								</td>
								<td>${price}</td>
							    <td>${percent}</td>
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
				document.getElementById('cb_make_date').style.visibility = 'visible';
				this.style.visibility = 'hidden';
			};
			lnkHiddenOption.onclick = function() {
				IsAdvSearch = false;
				document.getElementById('dvMoreOptionBox').style.display = 'none';
				document.getElementById('cb_make_date').style.visibility = 'hidden';
				lnkMoreOption.style.visibility = 'visible';
			};
			//			})();
		</script>
	</body>

</html>