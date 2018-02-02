<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>生产进度管理 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" href="css/base.css" />
		<link href="css/Query.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/BillList.css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script src="js/popup.js"></script>
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
				if(window.screen.availWidth > 1024) {
					var w = window.screen.availWidth * 0.98;
					window.resizeTo(w, 600);
					//居中
					var resizeWinTop = (window.screen.availHeight - 600) / 2;
					var resizeWinLeft = (window.screen.availWidth - w) / 2;
					window.moveTo(resizeWinLeft, resizeWinTop);
				}

				var interval = 1;
				if(interval <= 0) {
					interval = 1;
				}
				setTimeout("refreshWin()", 1000 * 60 * interval);
			}

			function createPageParaStr() {
				var str = "dep_id=" + document.getElementById("dep_id").value;
				str = str + "&est_name=" + encodeURIComponent(document.getElementById("est_name").value);
				str = str + "&bill_code=" + encodeURIComponent(document.getElementById("bill_code").value);
				str = str + "&ts_id=" + document.getElementById("ts_id").value;
				str = str + "&cont=" + encodeURIComponent(document.getElementById("cont").value);
				str = str + "&wc_id=" + document.getElementById("wc_id").value;
				return str;
			}

			function createProgramParaStr() {
				var str = "dep_id=17";
				str = str + "&est_name=" + encodeURIComponent(document.getElementById("hid_est_name").value);
				str = str + "&bill_code=" + encodeURIComponent(document.getElementById("hid_bill_code").value);
				str = str + "&ts_id=2";
				str = str + "&cont=" + encodeURIComponent(document.getElementById("hid_cont").value);
				str = str + "&wc_id=0";
				return str;
			}

			function doSearch() {
				var str;
				if(IsAdvSearch) { //高级
					str = "search_type=1";
					//if(document.getElementById("cb_dep").checked){
					var depId = document.getElementById("dep_id").value;
					if(depId == null || depId == "" || depId == "0") {
						ShowAlert('请选择部门', {
							title: '提示框'
						});
						return;
					}
					str = str + "&cb_dep=1";
					//}
					if(document.getElementById("cb_bill_code").checked) {
						var billCode = document.getElementById("bill_code").value.trim();
						if(billCode == null || billCode == "") {
							ShowAlert('请输入业务单号', {
								title: '提示框'
							});
							return;
						}
						str = str + "&cb_bill_code=1";
					}
					if(document.getElementById("cb_cont").checked) {
						var cont = document.getElementById("cont").value.trim();
						if(cont == null || cont == "") {
							ShowAlert('请输入内容', {
								title: '提示框'
							});
							return;
						}
						str = str + "&cb_cont=1";
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
					if(document.getElementById("cb_est").checked) {
						var estName = document.getElementById("est_name").value.trim();
						if(estName == null || estName == "") {
							ShowAlert('请输入订货单位名称', {
								title: '提示框'
							});
							return;
						}
						str = str + "&cb_est=1";
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
					var depId = document.getElementById("dep_id").value;
					if(depId == null || depId == "" || depId == "0") {
						ShowAlert('请选择部门', {
							title: '提示框'
						});
						return;
					}
				}
				var paraStr = createPageParaStr();
				if(paraStr != "") {
					str = str + "&" + paraStr;
				}
				window.location = "/make/BusinessBillListForTask.html?" + str;
			}

			function doGo(pageIndex) {
				var str = getSearchCondition();
				str = str + "&current_page=" + pageIndex;
				window.location = "/make/BusinessBillListForTask.html?" + str;
			}

			function getSearchCondition() {
				var searchType = "1";
				var str = "search_type=" + searchType;
				if(searchType == "1") { //高级
					str = str + "&cb_dep=1";

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

			}

			function doAutoCheck(objId) {
				document.getElementById(objId).checked = true;
			}

			function checkInput() {
				if(window.event.keyCode == 13) {
					doSearch();
				}
			}

			function doProComp(billId, itemId, proId) {
				ShowConfirm('确定设置为本道工序完工吗？', {
					title: '确认框'
				}, function(index) {
					popRetVal = 'Y';
					layer.close(index);
					doProCompCallBack(billId, itemId, proId);
				});
			}

			function doProCompCallBack(billId, itemId, proId) {
				if(popRetVal != null) {
					var url = "/make/BusinessProComplete.html?bill_id=" + billId + "&item_id=" + itemId + "&pro_id=" + proId;
					ShowIframe(['200px', '200px'], url, '', function() {
						refreshWin();
					}, '请稍候...');
				}
			}

			function refreshWin() {
				window.location.reload(true);
			}

			function doProBack(billId, itemId, proId) {
				ShowConfirm('确定退回上道工序吗？', {
					title: '确认框'
				}, function(index) {
					popRetVal = 'Y';
					layer.close(index);
					doProBackCallBack(billId, itemId, proId);
				});
			}

			function doProBackCallBack(billId, itemId, proId) {
				if(popRetVal != null) {
					var url = "/make/BusinessProBack.html?bill_id=" + billId + "&item_id=" + itemId + "&pro_id=" + proId;
					ShowIframe(['200px', '200px'], url, '', function() {
						refreshWin();
					}, '请稍候...');
				}
			}

			function doMultiComp() {
				var ob_arr = document.getElementsByName("query_checkbox");
				var billId = "",
					itemId = "",
					proId = "";
				for(i = 0; i < ob_arr.length; i++) {
					if((ob_arr[i].checked == true)) {
						if(billId != "") {
							billId = billId + ";";
						}
						if(itemId != "") {
							itemId = itemId + ";";
						}
						if(proId != "") {
							proId = proId + ";";
						}
						billId = billId + ob_arr[i].value;
						itemId = itemId + ob_arr[i].getAttribute("item_id");
						proId = proId + ob_arr[i].getAttribute("pro_id");
					}
				}
				if(billId != "") {
					ShowConfirm('确定设置为本道工序完工吗？', {
						title: '确认框'
					}, function(index) {
						popRetVal = 'Y';
						layer.close(index);
						doMultiCompCallBack(billId, itemId, proId);
					});
				} else {
					ShowAlert('请选择要完工的项目', {
						title: '提示框'
					});
				}
			}

			function doMultiCompCallBack(billId, itemId, proId) {
				if(popRetVal != null) {
					var url = "/make/BusinessProComplete.html?bill_id=" + billId + "&item_id=" + itemId + "&pro_id=" + proId;
					ShowIframe(['200px', '200px'], url, '', function() {
						refreshWin();
					}, '请稍候...');
				}
			}

			function doMultiBack() {
				var ob_arr = document.getElementsByName("query_checkbox");
				var billId = "",
					itemId = "",
					proId = "";
				for(i = 0; i < ob_arr.length; i++) {
					if((ob_arr[i].checked == true)) {
						if(billId != "") {
							billId = billId + ";";
						}
						if(itemId != "") {
							itemId = itemId + ";";
						}
						if(proId != "") {
							proId = proId + ";";
						}
						billId = billId + ob_arr[i].value;
						itemId = itemId + ob_arr[i].getAttribute("item_id");
						proId = proId + ob_arr[i].getAttribute("pro_id");
					}
				}
				if(billId != "") {
					ShowConfirm('确定将所选项目退回上道工序吗？', {
						title: '确认框'
					}, function(index) {
						popRetVal = 'Y';
						layer.close(index);
						doMultiBackCallBack(billId, itemId, proId)
					});
				} else {
					ShowAlert('请选择要退回的项目', {
						title: '提示框'
					});
				}
			}

			function doMultiBackCallBack(billId, itemId, proId) {
				if(popRetVal != null) {
					var url = "make/BusinessProBack.html?bill_id=" + billId + "&item_id=" + itemId + "&pro_id=" + proId;
					ShowIframe(['200px', '200px'], url, '', function() {
						refreshWin();
					}, '请稍候...');
				}
			}

			function doDownload() {
				var str = getSearchCondition();
				window.location = "/make/BusinessBillListForTask.html?content_type=EXCEL&" + str;
			}

			function showList(wcId) {
				var str = "search_type=1&cb_wc=1&wc_id=" + wcId + "&cb_dep=1&dep_id=" + document.getElementById("dep_id").value;
				window.location = "/make/BusinessBillListForTask.html?" + str;
			}

			function showSmsSubscribe() {

				showWin(['520px', '640px'], '/sms/SmsSubscribe.html');

			}

			function showAccessories(id, wcId, billCode) {
				var url = "make/AccessoryListAlone.html?acc_type=DESIGN&agent_type=BUSINESS_BILL&agent_id=" + id + "&ext_id=" + wcId + "&mark=" + encodeURIComponent("业务单：" + billCode);
				ShowIframe(['900px', '500px'], url, '', '', '图样');
			}

			function selectEstName() {
				var url = "/base/EstablishmentListForSelect.html?type=CLIENT";
				ShowIframe(['900px', '500px'], url, '', function() {
					selectEstNameCallBack();
				}, '选择客户');
			}

			function selectEstNameCallBack() {
				if(popRetVal != null) {
					document.getElementById("est_name").value = popRetVal[1];
					doAutoCheck("cb_est");
				}
			}

			function setCurPro(billId, itemId, wcId) {
				var url = "base/WorkProcessListForSelect.html?wc_id=" + wcId;
				ShowIframe(['300px', '400px'], url, '', function() {
					setCurProCallBack(billId, itemId, wcId);
				}, '选择工序');
			}

			function setCurProCallBack(billId, itemId, wcId) {
				if(popRetVal != null) {
					var url = "make/BusinessProSet.html?bill_id=" + billId + "&item_id=" + itemId + "&wc_id=" + wcId + "&pro_id=" + popRetVal[0];
					ShowIframe(['200px','200px'], url, '', function(){
						refreshWin();
					}, '请稍候...');
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
						<h1>生产进度管理</h1>
						<div class="pull-right">
							<div class="layui-form" style=" display: inline-block;">
								<input type="checkbox" name="cb_dep" id="cb_dep" title="部门" checked="true" lay-skin="primary">

								<div class="layui-inline">
									<div class="layui-input-inline">
										<select lay-filter="dep_id" name="dep_id" id="dep_id" onfocus="doAutoCheck('cb_dep');" onchange="doSearch();">
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
											<option value="17" selected="">标识加工车间</option>
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
									</div>
								</div>
								<a type="button " class="layui-btn " href="javascript:;" id="lnkMoreOption">更多查询选项</a>
								<a type="button " class="layui-btn " onclick="doSearch();" id="sSearchButton" name="sSearchButton">查 询</a>
								<a type="button " class="layui-btn " onclick="doMultiComp();" id="sCompButton" name="sCompButton" title="把选中的项目标记为完工，进入下一道工序">工序完工</a>
								<a type="button " class="layui-btn " onclick="doMultiBack();" id="sBackButton" name="sBackButton" title="把选中的项目退回上道工序">退 回</a>
								<a type="button " class="layui-btn " onclick="doDownload();" id="sDownButton" name="sDownButton">导 出</a>
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
											<input type="checkbox" name="cb_bill_code" id="cb_bill_code"> 业务单号
										</th>
										<td class="c1" width="240px">
											<input type="text" class="TextBox" maxlength="50" name="bill_code" id="bill_code" onkeyup="checkInput();" onfocus="doAutoCheck('cb_bill_code');" value="">
											<input type="hidden" id="hid_bill_code" value="">
										</td>
										<th class="c2" width="80px">
											<input type="checkbox" name="cb_wc" id="cb_wc"> 工作中心
										</th>
										<td class="c3" width="280px">
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
											<input type="checkbox" name="cb_cont" id="cb_cont"> 内容
										</th>
										<td class="c1">
											<input type="text" class="TextBox" maxlength="50" name="cont" id="cont" onkeyup="checkInput();" onfocus="doAutoCheck('cb_cont');" value="">
											<input type="hidden" id="hid_cont" value="">
										</td>
										<th class="c2">
											<input type="checkbox" name="cb_est" id="cb_est"> 订货单位
										</th>
										<td class="c3">
											<input type="text" class="TextBox" maxlength="50" name="est_name" id="est_name" onkeyup="checkInput();" onfocus="doAutoCheck('cb_est');" value="">
											<img class="imgIconButton" src="/images/make-a.gif" onclick="selectEstName();">
											<input type="hidden" id="hid_est_name" value="">
										</td>
									</tr>
									<tr>
										<th class="c1">
											<input type="checkbox" name="cb_ts" id="cb_ts" checked="true"> 账套
										</th>
										<td class="c1">
											<select name="ts_id" id="ts_id" onfocus="doAutoCheck('cb_ts');">
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

					<!-- 上栏 分页、操作等 -->
					<div class="TopToolBar">
						<table class="ListNoteInfo" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<td>
										<span class="Note">已开工的业务单才进入生产进度管理，用于管理当前工序需要制作的项目，上一道工序未完工，本道工序将不会出现。</span>
										<br /> 任务数量：14&nbsp;&nbsp; 数量合计：23522.3800&nbsp;&nbsp; 选择：

										<a href="javascript:showList(12);">标识部</a>

										<a href="javascript:showList(13);">标牌部</a>

										<a href="javascript:showList(14);">铝材加工</a>

										<a href="javascript:showList(16);">成品销售</a>

									</td>
								</tr>
							</tbody>
						</table>
					</div>

					<div class="table-list">
						<table width="100%">
							<tbody>
								<tr>
									<th width="20"><input type="checkbox" onclick="javascript:checkall(this);"></th>
									<th width="8%">日期</th>
									<th width="10%">单号</th>
									<th width="8%">订货单位</th>
									<th width="6%">项目类型</th>
									<th width="8%">内容</th>
									<th width="8%">材质</th>
									<th width="9%">规格</th>
									<th width="5%">单位
									</th>
									<th width="6%">数量
									</th>
									<th width="8%">制作要求
									</th>
									<th width="6%">当前工序</th>
									<th width="9%">完成情况</th>
									<th width="9%">操作</th>
								</tr>

								<tr class="query_list_data_tr1" index="1" style="color:#000000;cursor:pointer" defaultfontcolor="#000000" onclick="javascript:ClickCheck(this,true)" ondblclick="javascript:DoubleClick(this)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
									<td><input type="checkbox" onclick="javascript:ClickCheck(this,true);" name="query_checkbox" value="4017" item_id="8119" pro_id="51"></td>
									<td>2017-10-14</td>
									<td>E(2)2017100010</td>
									<td>如痴如醉</td>
									<td>标识</td>
									<td>内容</td>
									<td>20方管</td>
									<td>50m x 50m x 20</td>
									<td>

										米

									</td>
									<td>
										1000

									</td>
									<td>制作要求</td>
									<td>喷漆</td>
									<td></td>
									<td>
										<a href="javascript:showAccessories('4017','9','E(2)2017100010');">图样</a>
										<a href="javascript:setCurPro('4017','8119','9');">修改进度</a>
										<br>
										<a href="javascript:doProComp('4017','8119','51');">本道工序完工</a>
										<br>
										<a href="javascript:doProBack('4017','8119','51');">退回上道工序</a>
									</td>
								</tr>

								<tr class="query_list_data_tr2" index="2" style="color:#000000;cursor:pointer" defaultfontcolor="#000000" onclick="javascript:ClickCheck(this,true)" ondblclick="javascript:DoubleClick(this)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
									<td><input type="checkbox" onclick="javascript:ClickCheck(this,true);" name="query_checkbox" value="4466" item_id="9004" pro_id="1"></td>
									<td>2017-12-11</td>
									<td>E(2)2017120003</td>
									<td>付慧芳888</td>
									<td>快展背景墙</td>
									<td></td>
									<td></td>
									<td>5m x 6m x 10</td>
									<td>

										米

									</td>
									<td>
										60

									</td>
									<td>要求</td>
									<td>铝合金下料</td>
									<td></td>
									<td>
										<a href="javascript:showAccessories('4466','1','E(2)2017120003');">图样</a>
										<a href="javascript:setCurPro('4466','9004','1');">修改进度</a>
										<br>
										<a href="javascript:doProComp('4466','9004','1');">本道工序完工</a>

									</td>
								</tr>

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
			layui.use('form', function() {
				var form = layui.form;
				form.on('select(dep_id)', function(data) {
					doSearch();
				});
				//各种基于事件的操作，下面会有进一步介绍
			});
		</script>
		<script type="text/javascript">
			//			function ChangeWindowSize(container, maxWidth) {
			//				setTimeout(function() {
			//					var w1 = document.documentElement.clientWidth - 40;
			//					if(w1 > maxWidth) w1 = maxWidth;
			//					else if(w1 < 970) w1 = 960;
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
				document.getElementById('cb_dep').style.visibility = 'visible';
				this.style.visibility = 'hidden';
			};
			lnkHiddenOption.onclick = function() {
				IsAdvSearch = false;
				document.getElementById('dvMoreOptionBox').style.display = 'none';
				document.getElementById('cb_dep').style.visibility = 'hidden';
				lnkMoreOption.style.visibility = 'visible';
			};
			//			})();
		</script>
	</body>

</html>