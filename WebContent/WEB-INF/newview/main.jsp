<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
		<title></title>
		<link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
		<link href="css/base.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/defualt.css">

		<link rel="stylesheet" href="layui/css/layui.css">

		<!--侧边栏-->
		<link href="css/sidebar-menu.css" rel="stylesheet" />
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>

	<body>
		<!--顶部固定栏-->
		<div class="top-fix-bar">
			<span style="margin-right: 20px;">欢迎来到标识汇！</span>
			<a href="#">消息（0）</a>
			<span class="show-vertical">|</span>
			<a style="margin-right: 10px;" href="#">手机标识汇</a>
			<a href="#">关注微信</a>
			<div class="pull-right">
				<span>张蒙蒙</span>
				<span class="show-vertical">|</span>
				<a href="#">联系客户</a>
				<span class="show-vertical">|</span>
				<a href="#">购物车（0）</a>
			</div>
		</div>
		<div class="top-bar">
			<select name="">
				<option value="">网络科技有限公司</option>
			</select>
			<a href="#"><img src="img/back.gif" />返回首页</a>
			<div class="pull-right">
				<input type="text" name="" id="" value="" placeholder="搜索" />
				<ul class="user-memu">
					<li>
						<a href="#">张蒙蒙</a>
					</li>
					<li>
						<a href="#"><img src="img/messag.gif" />消息</a>
					</li>
					<li>
						<a href="#"><img src="img/help.gif" />帮助</a>
					</li>
					<li>
						<a href="#"><img src="img/exit.gif" />退出</a>
					</li>
				</ul>
			</div>
		</div>

		<!--侧边栏-->
		<div class="side-bar">
			<img class="logo" src="images/erp-1.1.png" />
			<ul class="accordion" id="client-side"></ul>
		</div>
		<div class="main-content">
			<!--导航栏-->
			<div class="nav-bar">
				<ul class="nav-menu">
					<li>
						<a id="client" href="#">客户业务</a>
					</li>
					<li>
						<a id="make" href="#">加工制作</a>
					</li>
					<li>
						<a id="cooperator" href="#">标识汇交易</a>
					</li>
					<li>
						<a id="purchase" href="#">采购管理</a>
					</li>
					<li>
						<a id="stock" href="#">库存管理</a>
					</li>
					<li>
						<a id="accounts" href="#">财务管理</a>
					</li>
					<li>
						<a id="profit" href="#">产值管理</a>
					</li>
					<li>
						<a id="statistics" href="#">统计报表</a>
					</li>
					<li>
						<a id="data" href="#">基础数据</a>
					</li>
					<li>
						<a id="teamwork" href="#">团队管理</a>
					</li>
					<li>
						<a id="system" href="#">系统管理</a>
					</li>
				</ul>
			</div>

			<div class="content">
				<table width="100%" height="500" border="0" cellspacing="0" cellpadding="0">
					<tbody>
						<tr>
							<td width="8%" align="center"></td>
							<td width="6%" align="center"></td>
							<td width="7%" align="center">
								<a href="#"><img width="80" src="images/pur2.gif" /></a>
							</td>
							<td width="6%" align="center"><img src="images/bus002.gif" /></td>
							<td width="7%" align="center">
								<a href="#"><img width="80" src="images/pur1.gif" /></a>
							</td>
							<td width="6%" align="center"><img src="images/bus001.gif" /></td>
							<td width="7%" align="center">
								<a href="#"><img width="80" src="images/stock3.gif" /></a>
							</td>
							<td width="6%" align="center"><img src="images/bus001.gif" /></td>
							<td width="7%" align="center">
								<a href="#"><img width="80" src="images/stock1.gif" /></a>
							</td>
							<td width="6%" align="center"></td>
							<td width="7%" align="center"></td>
							<td width="6%" align="center"></td>
							<td width="8%" align="center"></td>
						</tr>
						<tr>
							<td colspan="8">&nbsp;</td>
							<td align="center"><img height="30" src="images/bus004.gif" /></td>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td align="center">
								<a href="#"><img width="80" src="images/pur2.gif" /></a>
							</td>
							<td align="center"><img src="images/bus001.gif" /></td>
							<td align="center">
								<a href="#"><img width="80" src="images/pur2.gif" /></a>
							</td>
							<td align="center"><img src="images/bus001.gif" /></td>
							<td align="center">
								<a href="#"><img width="80" src="images/pur1.gif" /></a>
							</td>
							<td align="center"><img src="images/bus001.gif" /></td>
							<td align="center">
								<a href="#"><img width="80" src="images/stock3.gif" /></a>
							</td>
							<td align="center"><img src="images/bus001.gif" /></td>
							<td align="center">
								<a href="#"><img width="80" src="images/stock1.gif" /></a>
							</td>
							<td align="center"><img src="images/bus001.gif" /></td>
							<td align="center">
								<a href="#"><img width="80" src="images/stock1.gif" /></a>
							</td>
							<td align="center"><img src="images/bus001.gif" /></td>
							<td align="center">
								<a href="#"><img width="80" src="images/stock1.gif" /></a>
							</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
							<td align="center"><img height="30" src="images/bus004.gif" /></td>
							<td colspan="3">&nbsp;</td>
							<td align="center"><img height="30" src="images/bus003.gif" /></td>
							<td colspan="4">&nbsp;</td>
						</tr>
						<tr>
							<td colspan="4">&nbsp;</td>
							<td align="center">
								<a href="#"><img width="80" src="images/pur2.gif" /></a>
							</td>
							<td align="center"><img src="images/bus001.gif" /></td>
							<td align="center">
								<a href="#"><img width="80" src="images/pur2.gif" /></a>
							</td>
							<td align="center"><img src="images/bus001.gif" /></td>
							<td align="center">
								<a href="#"><img width="80" src="images/pur1.gif" /></a>
							</td>
							<td align="center"><img src="images/bus001.gif" /></td>
							<td align="center">
								<a href="#"><img width="80" src="images/stock3.gif" /></a>
							</td>
							<td colspan="2">&nbsp;</td>
						</tr>
					</tbody>
				</table>
				<!--设置负边距使居中，绝对值=0.5容器宽度-0.5侧边栏宽度-->
				<!--<ul class="list" style="margin-left: -266px;">-->
				<ul class="list">
					<li>
						<img src="img/list.gif" />
						<a href="#">费用单</a>
					</li>
					<li>
						<img src="img/list.gif" />
						<a href="#">其他收入单</a>
					</li>
					<li>
						<img src="img/list.gif" />
						<a href="#">调账单</a>
					</li>
					<li>
						<img src="img/list.gif" />
						<a href="#">转账取款单</a>
					</li>
					<li>
						<img src="img/list.gif" />
						<a href="#">资金借入单</a>
					</li>
					<li>
						<img src="img/list.gif" />
						<a href="#">资金借出单</a>
					</li>
				</ul>
			</div>
		</div>

		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
		<script src="js/jquery-3.0.0.min.js"></script>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
		<script src="js/sidebar-mune.js"></script>
		<!--<script src="layer/layer.js"></script>-->

		<script src="layui/layui.all.js"></script>
		<script src="js/popup.js"></script>

		<script src="js/minierp.js"></script>
		<script>
//			function setIframeDisplay(flag) {
//				//nnd,iframe里的东西在平板的触摸屏里模式窗的div挡不住,链接还是有效
//				//只好在弹出模式框时隐藏一下iframe
//				document.getElementById("MainFrame").style.display = flag;
//			}

			function showTsSelect(needTsSelect) {
				if(needTsSelect != null && needTsSelect == "Y") {
					setIframeDisplay("none");
					var url = "../system/UserTsSelect.html";
					ShowIframeNoScroll("选择当前帐套", url, 300, 200, "refreshTs()");
				}
			}

			function refreshTs() {
				if(popRetVal != null) {
					document.getElementById("df_ts_span").innerHTML = popRetVal.substring(0, 7);
				}
				setIframeDisplay("");
			}

			function doLogout() {

				setIframeDisplay("none");
				ShowConfirmWithMark('确认框', '是否自动备份数据库？', 340, 80, "doLogoutBackup()",
					'<a href="http://www.ekingcn.com/school/cjwtjjff_1753_253.html" target="_blank">如何设置双重备份到云盘<img src="../images/play_button.gif"></a>'
				);

			}

			function doLogoutBackup() {
				if(popRetVal != null) {
					var url = "../system/DbBackupNew.html";
					ShowIframe("数据备份", url, 400, 200, "doLogoutCallBack()");
				} else {
					window.location = "/Logout.html";
				}
			}

			function doLogoutCallBack() {
				window.location = "/Logout.html";
			}

			function doCommNew() {
//				setIframeDisplay("none");
				var url = "MyComm_toNewComm";
				ShowIframe(['980px','440px'], url, '', function callBack(){
//					setIframeDisplay('');
				}, '日程');
			}

			function refreshDesktopWin() { //Desktop.ihtm使用
				if(popRetVal != null) {
					document.getElementById("MainFrame").contentWindow.refreshWin();
				}
				setIframeDisplay("");
			}

			function showAdvicePage() {
				var name = encodeURIComponent("郑州市新异标识标牌有限公司");
				var linkman = encodeURIComponent("管理员");
				var phone = encodeURIComponent("15238022122");
				document.getElementById("MainFrame").src = "http://www.ekingcn.com/ask_eking_jg.html?name=" + name + "&linkman=" +
					linkman + "&phone=" + phone;
			}

			function showClientDialog() {
				var alertType = "SHOW";

				alertType = "NONE";

//				setIframeDisplay("none");
				var url = "customer_toAddCustomer";
//				ShowIframe("客户", url, 980, 500, "showClientDialogCallBack()");
				ShowIframe(['1200px', '700px'], url, '', function callBack(){
					showClientDialogCallBack();
				},'客户');
			}

			function showClientDialogCallBack() {
//				alert(popRetVal);
				if(popRetVal != null) {
					ShowConfirm('现在是否开业务单？', {title:'确认框'}, function yes(){
						showClientDialogCallBackExt(popRetVal);
					});

				} 
//				else {
//					setIframeDisplay("");
//				}
			}

			function showClientDialogCallBackExt(id) {
				if(popRetVal != null) {
					doBusinessBillNew(id);
				}
				setIframeDisplay("");
			}

			function doBusinessBillNew(clientId) {
				var url = "Business_toBusinessBegian?id="+clientId;
				showWin(['1280px','600px'], url);
			}

			function showEstMoveDialog(estType) {
//				setIframeDisplay("none");
				var url = "base/EstablishmentMoveForm-purchase.html?est_type=" + estType;
				var etName = "";
				if(estType == "CLIENT") {
					etName = "客户";
				} else if(estType == "COOPERATOR") {
					etName = "外协商";
				} else if(estType == "PROVIDER") {
					etName = "供应商";
				}
				ShowIframeNoScroll(['340px','220px'], url, '', '', etName);
			}

			function showBusinessBillDialog() {
//				setIframeDisplay("none");
				var url = "Business_toBusinessBillSearchResult";
				ShowIframe(['900px','500px'], url, '', function callBack(){
					showBusinessBillDialogCallBack();
				}, false);
			}

			function showBusinessBillDialogCallBack() {
				if(popRetVal != null) {
					if(popRetVal[12] == "RE_ORDER") {
						var url = "../business/BusinessBillListForReorder.html?client_id=" + popRetVal[0];
						ShowIframe("选择业务单", url, 900, 500, "showBusinessBillReorderDialogCallBackExt()");
					} else {
						doBusinessBillNew(popRetVal[0]);
					//	setIframeDisplay("");
					}
				} else {
				//	setIframeDisplay("");
				}
			}

			function showBusinessFileDialog() {
//				setIframeDisplay("none");
				if(window.applicationCache) { //html5
					ShowIframe(['560px','340px'], 'business/BusinessFileUpload.html', '', function callBack(){
						showBusinessFileDialogCallBack();
					}, '传图下单');
				} else {
					ShowIframe(['560px','340px'], 'business/BusinessFileForm.html', '', function callBack(){
						showBusinessFileDialogCallBack();
					}, '传图下单');
				}
			}

			function showBusinessFileDialogCallBack() {
				if(popRetVal != null) {
					var locFn = popRetVal[0];
					var remFn = popRetVal[1];
					var estName = locFn.split(".")[0];
					var xmlHttp = createXMLHttpRequest();
					var url = "../base/GetEstablishment.html?est_type=CLIENT&est_name=" + encodeURIComponent(estName);
					xmlHttp.open("GET", url, true);
					xmlHttp.onreadystatechange = function() {
						if(xmlHttp.readyState == 4) {
							if(xmlHttp.status == 200) {
								var clientId = xmlHttp.responseText;
								if(clientId != "0") {
									url = "../business/BusinessBillNew.html?type=FILE&client_id=" + clientId + "&rem_fn=" + encodeURIComponent(
										remFn) + "&alert_type=FORM";
									showWin(1280, 600, url);
								} else {
									setIframeDisplay("none");
									url = "../base/EstablishmentListForSelect.html?type=CLIENT&ts_id=DF_TS_ID&order_type=BUS_TIME&search_key=" +
										encodeURIComponent(estName);
									ShowIframe("选择客户", url, 900, 500, "showBusinessFileDialogCallBackExt('" + remFn + "')");
								}
							}
						}
					}
					xmlHttp.send(null);
				}
				setIframeDisplay("");
			}

			function showBusinessFileDialogCallBackExt(remFn) {
				if(popRetVal != null) {
					var url = "../business/BusinessBillNew.html?type=FILE&client_id=" + popRetVal[0] + "&rem_fn=" + encodeURIComponent(
						remFn) + "&alert_type=FORM";
					showWin(1280, 600, url);
				}
				setIframeDisplay("");
			}

			function showBusAccountDialog() {
//				setIframeDisplay("none");
				var url = "base/EstablishmentListForSelect.html?type=CLIENT&show_all=S&order_type=BUS_TIME";
				ShowIframe(['900px','500px'], url, '', function (){
					showBusAccountDialogCallBack();
				}, '选择客户');
			}

			function showBusAccountDialogCallBack() {
				if(popRetVal != null) {
					var clientId = popRetVal[0];
					var url = "business/BusinessBillListForAccountForm.html";
					ShowIframeNoScroll(['900px','500px'], url, '', function callBack(){
						showBusAccountDialogCallBackExt(clientId);
					}, '业务对帐');
				}
//				else {
//					setIframeDisplay("");
//				}
			}

			function showBusAccountDialogCallBackExt(clientId) {
				if(popRetVal != null) {
					var startDate = popRetVal[0];
					var endDate = popRetVal[1];
					var type = popRetVal[2];
					var includeSub = popRetVal[3];
					var orderBy = popRetVal[4];
					var linkman = popRetVal[5];
					var tsId = popRetVal[6];
					showWin(900, 620, '../business/BusinessBillListForAccount.html?client_id=' + clientId + '&start_date=' + startDate +
						'&end_date=' + endDate + '&linkman=' + linkman + '&type=' + type + '&include_sub=' + includeSub + '&order_by=' +
						orderBy + '&ts_id=' + tsId);
				}
//				setIframeDisplay("");
			}

			function showDelAccountDialog() {
//				setIframeDisplay("none");
				var url = "base/EstablishmentListForSelect.html?type=CLIENT&show_all=S&order_type=BUS_TIME";
				ShowIframe(['900px','500px'], url, '', function callBack(){
					showDelAccountDialogCallBack();
				}, '选择客户');
			}

			function showDelAccountDialogCallBack() {
				if(popRetVal != null) {
					var clientId = popRetVal[0];
					var url = "business/DeliverBillListForAccountForm.html";
					ShowIframeNoScroll(['340px','400px'], url, '', function callBack(){
						showDelAccountDialogCallBackExt(clientId);
					}, '送货对帐');
				}
//				else {
//					setIframeDisplay("");
//				}
			}

			function showDelAccountDialogCallBackExt(clientId) {
				if(popRetVal != null) {
					var startDate = popRetVal[0];
					var endDate = popRetVal[1];
					var includeSub = popRetVal[2];
					var orderBy = popRetVal[3];
					var linkman = popRetVal[4];
					var url = 'business/DeliverBillListForAccount.html?client_id=' + clientId + '&start_date=' + startDate +
						'&end_date=' + endDate + '&linkman=' + linkman + '&include_sub=' + includeSub + '&order_by=' + orderBy;
					showWin(['900px','620px'], url);
				}
//				setIframeDisplay("");
			}

			function showCooperatorDialog() {
//				setIframeDisplay("none");
				var alertType = "SHOW";

				alertType = "NONE";

				var url = "base/EstablishmentNew.html?type=COOPERATOR&alert_type=" + alertType;
				ShowIframe(['980px','500px'], url, '', function callBack(){
					showCooperatorDialogCallBack();
				}, '外协商');
			}

			function showCooperatorDialogCallBack() {
				if(popRetVal != null) {

					ShowConfirm('现在是否开外协单？', {title:'确认框'}, function yes(){
						showCooperatorDialogCallBackExt(popRetVal);
					});

				}
//				else {
//					setIframeDisplay("");
//				}
			}

			function showCooperatorDialogCallBackExt(id) {
				if(popRetVal != null) {
					doCooperBillNew(id);
				}
//				setIframeDisplay("");
			}

			function doCooperBillNew(cooperatorId) {
				var url = "cooper/CooperBillNew.html?cooperator_id=" + cooperatorId + "&alert_type=FORM";
				showWin(['1280px','600px'], url);
			}

			function showCooperBillDialog() {
//				setIframeDisplay("none");
				var url = "base/EstablishmentListForSelect.html?type=COOPERATOR&ts_id=DF_TS_ID&order_type=BUS_TIME";
				ShowIframe(['900px','500px'], url, '', function callBack(){
					showCooperBillDialogCallBack();
				}, '选择外协商');
			}

			function showCooperBillDialogCallBack() {
				if(popRetVal != null) {
					doCooperBillNew(popRetVal[0]);
				}
//				setIframeDisplay("");
			}

			function showCooAccountDialog() {
//				setIframeDisplay("none");
				var url = "base/EstablishmentListForSelect.html?type=COOPERATOR&show_all=S&order_type=BUS_TIME";
				ShowIframe(['900px','500px'], url, '', function callBack(){
					showCooAccountDialogCallBack();
				}, '选择外协商');
			}

			function showCooAccountDialogCallBack() {
				if(popRetVal != null) {
					var estId = popRetVal[0];
					var url = "cooper/CooperBillListForAccountForm.html";
					ShowIframeNoScroll(['340px','400px'], url, '', function callBack(){
						showCooAccountDialogCallBackExt(estId);
					}, '外协对帐');
				}
//				else {
//					setIframeDisplay("");
//				}
			}

			function showCooAccountDialogCallBackExt(estId) {
				if(popRetVal != null) {
					var startDate = popRetVal[0];
					var endDate = popRetVal[1];
					var type = popRetVal[2];
					var orderBy = popRetVal[3];
					var tsId = popRetVal[4];
					
					var url = '../cooper/CooperBillListForAccount.html?cooperator_id=' + estId + '&start_date=' + startDate +
						'&end_date=' + endDate + '&type=' + type + '&order_by=' + orderBy + '&ts_id=' + tsId;

					showWin(['900px','620px'], url);

				}
//				setIframeDisplay("");
			}

			function showGatAccountDialog() {
//				setIframeDisplay("none");
				var url = "base/EstablishmentListForSelect.html?type=COOPERATOR&show_all=S&order_type=BUS_TIME";
				ShowIframe(['900px','500px'], url, '', function callBack(){
					showGatAccountDialogCallBack();
				}, '选择外协商');
			}

			function showGatAccountDialogCallBack() {
				if(popRetVal != null) {
					var estId = popRetVal[0];
					var url = "cooper/GatherBillListForAccountForm.html";
					ShowIframeNoScroll(['340px','400px'], url, '', function callBack(){
						showGatAccountDialogCallBackExt(estId);
					}, '收货对帐');
				}
//				else {
//					setIframeDisplay("");
//				}
			}

			function showGatAccountDialogCallBackExt(estId) {
				if(popRetVal != null) {
					var startDate = popRetVal[0];
					var endDate = popRetVal[1];
					var orderBy = popRetVal[2];
					var url = '../cooper/GatherBillListForAccount.html?cooperator_id=' + estId + '&start_date=' + startDate +
						'&end_date=' + endDate + '&order_by=' + orderBy;
					showWin(['900px','620px'], url);

				}
//				setIframeDisplay("");
			}

			function showProviderDialog() {
//				setIframeDisplay("none");
				var alertType = "SHOW";

				alertType = "NONE";

				var url = "base/EstablishmentNew-purchase.html?type=PROVIDER&alert_type=" + alertType;
				ShowIframe(['980px','500px'], url, '', function callBack(){
					showProviderDialogCallBack();
				}, '供应商');
			}

			function showProviderDialogCallBack() {
				if(popRetVal != null) {

					ShowConfirm('现在是否开采购单？', {title:'确认框'}, function yes(){
						showProviderDialogCallBackExt('BUY', popRetVal)
					});
				}
//				else {
//					setIframeDisplay("");
//				}
			}

			function showProviderDialogCallBackExt(type, id) {
				if(popRetVal != null) {
					doPurchaseBillNew(type, id);
				}
//				setIframeDisplay("");
			}

			function doPurchaseBillNew(type, providerId) {
				var url = "purchase/PurchaseBillNew.html?type=" + type + "&provider_id=" + providerId + "&alert_type=FORM";
				showWin(['1024px','600px'], url);
			}

			function showPurAccountDialog() {
//				setIframeDisplay("none");
				var url = "base/EstablishmentListForSelect.html?type=PROVIDER&show_all=S&order_type=BUS_TIME";
				ShowIframe(['900px','500px'], url, '', function callBack(){
					showPurAccountDialogCallBack();
				}, '选择供应商');
			}

			function showPurAccountDialogCallBack() {
				if(popRetVal != null) {
					var estId = popRetVal[0];
					var url = "purchase/PurchaseBillListForAccountForm.html";
					ShowIframeNoScroll(['340px','400px'], url, '', function callBack(){
						showPurAccountDialogCallBackExt(estId);
					}, '采购对帐');
				}
//				else {
//					setIframeDisplay("");
//				}
			}

			function showPurAccountDialogCallBackExt(estId) {
				if(popRetVal != null) {
					var startDate = popRetVal[0];
					var endDate = popRetVal[1];
					var type = popRetVal[2];
					var orderBy = popRetVal[3];
					var tsId = popRetVal[4];
					var url = 'purchase/PurchaseBillListForAccount.html?provider_id=' + estId + '&start_date=' + startDate +
						'&end_date=' + endDate + '&type=' + type + '&order_by=' + orderBy + '&ts_id=' + tsId;
					showWin(['900px','620px'], url);
				}
//				setIframeDisplay("");
			}

			function showPayBillDialog() {
				setIframeDisplay("none");
				var url = "../finance/PayTypeSelect.html";
				ShowIframeNoScroll("选择付款类型", url, 240, 240, "showPayBillDialogCallBack()");
			}

			function showPayBillDialogCallBack() {
				if(popRetVal != null) {
					var url = "../finance/PayBillNew.html?alert_type=SHOW&pay_type=" + popRetVal;
					showWin(1024, 600, url);
				}
				setIframeDisplay("");
			}

			function showAdjustBillDialog() {
//				setIframeDisplay("none");
				var url = "finance/AdjustTypeSelect.html";
				ShowIframeNoScroll(['240px','380px'], url, '', function callBack(){
					showAdjustBillDialogCallBack();
				}, '选择调帐类型');
			}

			function showAdjustBillDialogCallBack() {
				if(popRetVal != null) {
					var url = "finance/AdjustBillNew.html?adjust_type=" + popRetVal + "&alert_type=SHOW";
					showWin(['1024px','600px'], url);
				}
//				setIframeDisplay("");
			}

			function showBusinessBillReorderDialogCallBack() {
				if(popRetVal != null) {
					var url = "../business/BusinessBillListForReorder.html?client_id=" + popRetVal[0];
					ShowIframe("选择业务单", url, 900, 500, "showBusinessBillReorderDialogCallBackExt()");
				} else {
					setIframeDisplay("");
				}
			}

			function showBusinessBillReorderDialogCallBackExt() {
				if(popRetVal != null) {
					var url = "../business/BusinessBillNew.html?type=TEMPLATE&template_id=" + popRetVal + "&alert_type=FORM";
					showWin(1280, 600, url);
				}
				setIframeDisplay("");
			}

			function showStatus() {
				window.status = "时间：2017-07-04 Tue  当前操作员：管理员  使用单位：郑州市新异标识标牌有限公司";
			}

			function showTsPage() {
				// setTimeout("showTsSelect('Y');", 1000);
			}
			window.onbeforeunload = function() {
				var n = window.event.screenX - window.screenLeft;
				var b = n > document.documentElement.scrollWidth - 20;
				if(b && window.event.clientY < 0 || window.event.altKey) {
					var xmlHttp = createXMLHttpRequest();
					xmlHttp.open("GET", "/Logout.html", true);
					xmlHttp.send(null);
				}
			}

			function doImpo(formUrl, targetUrl) {
				ShowIframe(['560px','300px'], formUrl, '', function callBack(){
					doImpoCallBack(targetUrl);
				}, '导入Excel');
			}

			function doImpoCallBack(targetUrl) {
				if(popRetVal) {
					document.getElementById("LoadProcess").style.top = (document.body.clientHeight / 2 - 50) + "px";
					document.getElementById("LoadProcess").style.left = (document.body.clientWidth / 2 - 100) + "px";
					document.getElementById("LoadProcess").style.display = "";
					var fileName = popRetVal;
					var url;
					if(targetUrl.indexOf("?") == -1) {
						url = targetUrl + "?file_name=" + encodeURIComponent(fileName);
					} else {
						url = targetUrl + "&file_name=" + encodeURIComponent(fileName);
					}
					var xmlHttp = createXMLHttpRequest();
					xmlHttp.open("GET", url, true);
					xmlHttp.onreadystatechange = function() {
						if(xmlHttp.readyState == 4) {
							if(xmlHttp.status == 200) {
								document.getElementById("LoadProcess").style.display = "none";
								showWin(560, 300, "/ImpoSuccess.html");
							}
						}
					};
					xmlHttp.send(null);
				}
			}

			function showBankLog() {
				var d = new Date();
				var startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				var endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				var url = "finance/AccountLogList.html?start_date=" + startStr + "&end_date=" + endStr;
				showWin(['900px','600px'], url);
			}

			function showBusinessDragDialog() {
//				setIframeDisplay("none");
				ShowIframe(['560px','340px'], 'business/BusinessDragForm.html', '', function callBack(){
					showBusinessDragCallBack();
				}, '拖图下单');
			}

			var busiDragJson;

			function showBusinessDragCallBack() {
				setIframeDisplay("");
				if(popRetVal) {
					busiDragJson = popRetVal;
					if(busiDragJson.estId == "0") {
						var url = "../base/EstablishmentListForSelect.html?type=CLIENT&ts_id=DF_TS_ID&order_type=BUS_TIME&search_key=" +
							encodeURIComponent(busiDragJson.estName);
						ShowIframe("选择客户", url, 900, 500, "showBusinessDragCallBackExt()");
					} else {
						var dataStr = JSON.stringify(busiDragJson); //dataStr太长,直接用get方式会被截掉
						jQuery.noConflict(); //与prototype.js的$有冲突
						jQuery.post("../business/BusinessDragData.html", {
							data: dataStr
						}, function(data, status) {
							parseDragData(data, status);
						});
						//showWin(1280,600,"../business/BusinessBillNew.html?type=DRAG&data="+encodeURIComponent(dataStr)+"&alert_type=FORM");
					}
				}
			}

			function showBusinessDragCallBackExt() {
				if(popRetVal) {
					busiDragJson.estId = popRetVal[0];
					busiDragJson.estName = popRetVal[1];
					var dataStr = JSON.stringify(busiDragJson); //dataStr太长,直接用get方式会被截掉
					jQuery.noConflict(); //与prototype.js的$有冲突
					jQuery.post("../business/BusinessDragData.html", {
						data: dataStr
					}, function(data, status) {
						parseDragData(data, status);
					});
					//showWin(1280,600,"../business/BusinessBillNew.html?type=DRAG&data="+encodeURIComponent(dataStr)+"&alert_type=FORM");
				}
			}

			function parseDragData(data, status) {
				if(status == "success") {
					showWin(1280, 600, "../business/BusinessBillNew.html?type=DRAG&alert_type=FORM");
				} else {
					ShowAlert('提示框', '系统错误：' + status, 200, 100);
				}
			}
		</script>

	</body>

</html>