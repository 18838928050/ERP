<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/BillEdit.css">
		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	</head>

	<body>
		<div>
			<form class="layui-form" name="frm" action="InBillNew_saveInBills" method="post">
				<div class="Container">
					<div class="Contnet Paper">

						<!--单 标题-->
						<div class="BillHeading">
							<div class="layui-row">
								<div class="layui-col-sm4">
									<div class="CorpLogo"><img src="images/BIAO  SHI  HUI.png"></div>
								</div>
								<div class="layui-col-sm4">
									<h1>新增入库单</h1>
								</div>
								<div class="layui-col-sm4 tr" style="">
									<div class="layui-form-item" style="display: inline-block;margin-top: 10px;margin-bottom: 8px;">
										<!--<label class="layui-form-label"><span class="MustInput">*</span>编号：</label>-->
										<div class="layui-input-inline">
											&nbsp;
											<!--<input class="layui-input" readonly placeholder="" type="text" maxlength="30" onkeyup="goNextInput('cooperDateStr');" id="cooperBill.billCode" name="cooperBill.billCode" value="">-->
										</div>
									</div>
									<div class="layui-form-item" style="display: inline-block;">
										<label class="layui-form-label"><span class="MustInput">*</span>编号：</label>
										<div class="layui-input-inline">
											<input class="layui-input" readonly placeholder="" type="text" maxlength="30" onkeyup="goNextInput(&#39;inDateStr&#39;);" id="inBill.billCode" name="inBill.billCode" value="">
										</div>
									</div>
									<div class="layui-form-item" style="display: inline-block;">
										<label class="layui-form-label"><span class="MustInput">*</span>入库日期：</label>
										<div class="layui-input-inline" style="width: 85px;">
											<input class="layui-input" placeholder="" type="text" maxlength="15" id="inDateStr" name="inDateStr" value="2017-11-21">
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="blank12"></div>
						<!-- 单 头信息 -->
						<div class="layui-row">
							<div class="layui-col-sm3">
								<div class="layui-form-item">
									<label class="layui-form-label" style="width: 50px;"><span class="MustInput">*</span>仓库：</label>
									<div class="layui-input-inline" style="width: 120px;">
										<select id="inBill.storehouseId" name="inBill.storehouseId">
											<option value="0">==请选择==</option>

											<option value="1">标识加工仓库</option>

											<option value="2">中力门店仓库</option>

											<option value="3">车间型材仓库</option>

											<option value="4">车间耗材仓库</option>

											<option value="5">车间工具仓库</option>

										</select>
									</div>
								</div>
							</div>
							<div class="layui-col-sm3 tc">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 70px;">供方类型：</label>
									<div class="layui-input-inline" style="width: 120px;">
										<select id="inBill.offererType" name="inBill.offererType" onchange="doOffererTypeChange();">
											<option value="">==请选择==</option>
											<option value="WORK_CENTER">工作中心</option>
											<option value="PROVIDER">供应商</option>
											<option value="COOPERATOR">外协商</option>
											<option value="DEPARTMENT">部门</option>
											<option value="STOREHOUSE">仓库</option>
											<option value="CLIENT">客户</option>
										</select>
									</div>
								</div>
							</div>
							<div class="layui-col-sm3 tc">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 70px;">供方：</label>
									<div class="layui-input-inline" style="width: 140px;">
										<input class="layui-input" readonly placeholder="" type="text" id="offererName" name="offererName" value="">
									</div>
								</div>
							</div>
							<div class="layui-col-sm3 tr">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 70px;"><span class="MustInput">*</span>入库类型：</label>
									<div class="layui-input-inline" style="width: 140px; text-align: center;">
										<select style="width:110px" id="inBill.inTypeId" name="inBill.inTypeId">
											<option value="0">==请选择==</option>

											<option value="1">采购入库</option>

											<option value="2">内部调拨</option>

											<option value="3">盘点入库</option>

										</select>
									</div>
								</div>
							</div>
						</div>

						<!-- 明细 -->
						<input type="hidden" id="item_num" name="item_num" value="0">
						<table id="BillDetails" class="BillDetails" width="100%" cellspacing="0" cellpadding="0">
							<tbody id="itemRowTbl">
								<tr>
									<th width="12%">材料编号</th>
									<th width="25%">品名规格</th>
									<th width="8%">单位</th>
									<th width="10%">数量</th>
									<th width="10%">单价(元)</th>
									<th width="10%">金额(元)</th>
									<th width="20%">备注</th>
									<th width="5%">操作</th>
								</tr>

							</tbody>
						</table>
						<div class="table-bot" style="margin-top:4px">
							<span style="float:right;PADDING-RIGHT:10px;color:#aaa">
					数量小计：<span id="amountSpan">0</span>&nbsp; 金额小计：

							<span id="costSpan">0</span>元

							</span>

							请输入条形码：
							<input type="text" class="layui-input" style="width:120px; display: inline;" id="pro_code" name="pro_code" onkeyup="checkProCode();" title="材料编号作为材料的条形码，可以在这里直接扫描出入库">
							<input type="button" style="font-size:12px;" value="加入" onclick="addProCode();">
							<a href="javascript:doMultiSelect();">增加入库明细</a>
							<span style="color:#aaa">（点击这里添加入库的材料）</span>
							<a id="uplo_link" href="javascript:doUpload();">从Excel导入</a>

						</div>

						<hr />
						<!-- 附加信息 -->
						<div class="layui-row">
							<div class="layui-col-sm3">
								<div class="layui-form-item">
									<label class="layui-form-label" style="width: 50px;">供方：</label>
									<div class="layui-input-inline" style="width: 140px;">
										<input class="layui-input" readonly placeholder="" type="text" id="inBill.managerName" name="inBill.managerName" value="">
									</div>
									<div class="layui-form-mid">
										<a href="javascript:selectManager();">选择</a>
									</div>
								</div>
							</div>
							<div class="layui-col-sm3">
								<div class="layui-form-item" style="width: 300px;">
									<label class="layui-form-label" style="width: 70px;">备注：</label>
									<div class="layui-input-inline">
										<input class="layui-input" placeholder="" type="text" maxlength="50" id="inBill.mark" name="inBill.mark" value="">
									</div>
								</div>
							</div>
						</div>
						<br>
						<div class="BillNotes">
							<span>开单人：标识汇 </span>
							<span>审核人：</span>
							<span>单据帐套：新异</span>

						</div>
					</div>

					<!-- 底栏按钮 -->
					<div class="Footer">
						<div id="buttonDiv">
							<input type="button" class="buttom-a" value=" 保 存 " onclick="doSave(&#39;0&#39;);">

							<input type="button" class="buttom-a" value="保存并新增" onclick="doSave(&#39;1&#39;);">
							<input type="button" class="buttom-a" value="保存并复制" onclick="doSave(&#39;2&#39;);">

							<input type="button" class="buttom-a" value=" 取 消 " onclick="doCancel();">
							<input type="hidden" name="continue_flag" id="continue_flag" value="0">
							<input type="hidden" id="examine" name="examine" value="0">
							<input type="hidden" id="sychronizeValue" name="sychronizeValue" value="0">
							<input type="hidden" id="inDateHour" name="inDateHour" value="17">
							<input type="hidden" id="inDateMinute" name="inDateMinute" value="19">
						</div>
						<div id="waitDiv" style="display:none">
							<span>请稍候...</span>
						</div>
					</div>

				</div>
			</form>
		</div>

		<div id="LoadProcess" style="position:absolute; left:50%;top:50%; width:200px; height:100px; margin-top:-50px;margin-left:-100px;z-index:1; border:solid #000 5px;background-color:White;display:none">
			<table border="0" align="center" style="height:100%;">
				<tbody>
					<tr>
						<td style="valign:middle">
							<img src="images/loading.gif"> 请稍候...
						</td>
					</tr>
				</tbody>
			</table>
		</div>

		<audio controls="controls" style="display: none;"></audio>
		<script src="js/jquery-3.0.0.min.js"></script>
		<script src="layui/layui.all.js"></script>
		<script src="js/popup.js"></script>
		<script src="js/minierp.js"></script>
		<script>
			layui.use('laydate', function() {
				var laydate = layui.laydate;

				laydate.render({
					elem: '#inDateStr'
				});
			});
		</script>
		
		
		<script>
			var indexTr = null;

			function doSave(flag) {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				document.getElementById("continue_flag").value = flag;
				
				ShowConfirm('是否同时审核？',{title:'确认框'}, function doSaveCallBack() {
					if(popRetVal != null) {
						document.getElementById("examine").value = "1";
					}
					frm.submit();
				});
			}

		function doReorder(id) {
				window.location = "InBillNew.ihtm?alert_type=FORM&data_type=COPY&template_id=" + id;
			}

			function doCancel() {
//				if(window.opener) {
//					window.close();
//				} else {
//					parent.ClosePop();
//				}
				parent.layer.closeAll();
			}

			function elementOnChnage() {
				checkItemChange(this.getAttribute("index"), this.id);
			}

			function productOnChnage() {
				checkProductChange(this.getAttribute("index"));
			}

			function inputOnMouseOver() {
				this.title = this.value;
			}

			function checkProductChange(index) {
				if(window.event.keyCode == 13) {
					selectProduct(index);
				}
			}

			function buttonOnClick() {
				selectProduct(this.getAttribute("index"));
			}

			function selectProduct(index) {
				var url = "/base/ProductMainForSelect.ihtm";
				ShowIframe(['900px','500px'], url, '', function(layui_index){
					selectProductCallBack(index);
				}, '选择材料');
			}

			function selectProductCallBack(index) {
				if(popRetVal != null) {
					document.getElementById("product_id_" + index).value = popRetVal[0];
					document.getElementById("product_code_" + index).value = popRetVal[1];
					document.getElementById("product_name_" + index).value = popRetVal[2];
					document.getElementById("product_unit_" + index).value = popRetVal[3];
					if(document.getElementById("unit_price_" + index) != null) {
						document.getElementById("unit_price_" + index).value = popRetVal[5];
					}
					checkItemChange(index);
				}
			}
			function doMultiSelect() {
				
				var url = "InBillNew_toProductMainForSelect";
				ShowIframe(['915px', '500px'], url, '', function(){
					doMultiSelectCallBack();
				}, '' );
			}
			
			function doMultiSelectCallBack() {
					if(popRetVal != null) {
						for(i = 0; i < popRetVal.length; i++) {
							var newIndex = doItemAdd();
							document.getElementById("product_id_" + newIndex).value = popRetVal[i][0];
							document.getElementById("product_code_" + newIndex).value = popRetVal[i][1];
							document.getElementById("product_name_" + newIndex).value = popRetVal[i][2];
							document.getElementById("product_unit_" + newIndex).value = popRetVal[i][3];
							document.getElementById("unit_price_" + newIndex).value = popRetVal[i][5];
							checkItemChange(newIndex);
						}
					}
			}

			function doItemAdd() {
				var tbl = document.getElementById("itemRowTbl");
				var itemNum = document.getElementById("item_num").value - 0;

				var tr = document.createElement("tr");
				tr.setAttribute("id", "itemTr" + itemNum);

				var td;
				var input;

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.width = "80px";
				input.style.display= "inline";
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "product_code_" + itemNum);
				input.setAttribute("id", "product_code_" + itemNum);
				input.setAttribute("readOnly", true);
				input.setAttribute("className", "layui-input readonly");
				input.setAttribute("class", "layui-input readonly");
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.width = "160px";
				input.style.display= "inline";
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "product_name_" + itemNum);
				input.setAttribute("id", "product_name_" + itemNum);
				input.setAttribute("readOnly", true);
				input.setAttribute("className", "layui-input readonly");
				input.setAttribute("class", "layui-input readonly");
				input.onmouseover = inputOnMouseOver;
				td.appendChild(input);

				td.appendChild(document.createTextNode(" "));
				input = document.createElement("img");
				input.setAttribute("src", "images/icon_add.gif");
				input.setAttribute("index", itemNum);
				input.style.cursor = "pointer";
				input.onclick = buttonOnClick;
				td.appendChild(input);

				input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "inBillItem[" + itemNum + "].productId");
				input.setAttribute("id", "product_id_" + itemNum);
				input.setAttribute("value", "0");
				td.appendChild(input);

				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.width = "40px";
				input.style.display= "inline";
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "product_unit_" + itemNum);
				input.setAttribute("id", "product_unit_" + itemNum);
				input.setAttribute("readOnly", true);
				input.setAttribute("className", "layui-input readonly");
				input.setAttribute("class", "layui-input readonly");
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.cssText = "text-align:right";
				input.style.width = "50px";
				input.style.display= "inline";
				input.setAttribute("maxLength", "10");
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "inBillItem[" + itemNum +"].amount");
				input.setAttribute("id", "amount_" + itemNum);
				input.setAttribute("value", "");
				input.setAttribute("className", "layui-input");
				input.setAttribute("class", "layui-input");
				input.onchange = elementOnChnage;
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.cssText = "text-align:right";
				input.style.width = "50px";
				input.style.display= "inline";
				input.setAttribute("maxLength", "10");
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "inBillItem[" + itemNum + '].unitPrice');
				input.setAttribute("id", "unit_price_" + itemNum);
				input.setAttribute("value", "");
				input.setAttribute("className", "layui-input");
				input.setAttribute("class", "layui-input");
				input.onchange = elementOnChnage;
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.cssText = "text-align:right";
				input.style.width = "50px";
				input.style.display= "inline";
				input.setAttribute("maxLength", "10");
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "inBillItem[" + itemNum + "].cost");
				input.setAttribute("id", "cost_" + itemNum);
				input.setAttribute("value", "0");
				input.setAttribute("readOnly", true);
				input.setAttribute("className", "layui-input readonly");
				input.setAttribute("class", "layui-input readonly");
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.width = "150px";
				input.style.display= "inline";
				input.setAttribute("maxLength", "200");
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "inBillItem[" + itemNum + "].mark");
				input.setAttribute("id", "mark_" + itemNum);
				input.setAttribute("value", "");
				input.setAttribute("className", "layui-input");
				input.setAttribute("class", "layui-input");
				input.onchange = elementOnChnage;
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				var delLink = document.createElement("a");
				delLink.setAttribute("href", "javascript:doItemDelete(" + itemNum + ");");
				delLink.appendChild(document.createTextNode("删除"));
				td.appendChild(delLink);

				input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "status_" + itemNum);
				input.setAttribute("id", "status_" + itemNum);
				input.setAttribute("value", "UNCHANGE");
				td.appendChild(input);

				input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "id_" + itemNum);
				input.setAttribute("id", "id_" + itemNum);
				input.setAttribute("value", "0");
				td.appendChild(input);
				tr.appendChild(td);

				tbl.appendChild(tr);
				document.getElementById("item_num").value = itemNum + 1;


				return itemNum; //当前行的index
			}
			

			function doItemDelete(index) {
				indexTr = index;
				ShowConfirm('确定删除吗？',{title:'确认框'}, function(layui_index){
					popRetVal = 'Y';
					layer.close(layui_index);
					doItemDeleteCallBack(index);
				});
			}
			

			function doItemDeleteCallBack(index) {
				if(popRetVal != null) {
					document.getElementById("itemTr" + index).style.display = "none";
					document.getElementById("status_" + index).value = "DELETE";
					doCount();

					resizePopwin();
				}
			}

			function checkItemChange(index, id) {
				if(document.getElementById("id_" + index).value == "" || document.getElementById("id_" + index).value == "0") {
					document.getElementById("status_" + index).value = "NEW";
				} else {
					document.getElementById("status_" + index).value = "EDIT";
				}

				if(document.getElementById("cost_" + index) != null) {
					var itemAmount = document.getElementById("amount_" + index).value;
					var itemUnitPrice = document.getElementById("unit_price_" + index).value;
					var itemCost;

					//金额
					if(!isNaN(itemAmount) && !isNaN(itemUnitPrice)) {
						itemCost = accMul(itemAmount, itemUnitPrice);
						document.getElementById("cost_" + index).value = parseScale(itemCost, 2);
					}
				}

				doCount();
			}

			function doCount() {
				var itemNum = document.getElementById("item_num").value - 0;
				var itemCost;
				var itemAmount;
				var costTotal = 0;
				var amountTotal = 0;
				for(var i = 0; i < itemNum; i++) {
					if(document.getElementById("status_" + i).value != "DELETE") {
						if(document.getElementById("cost_" + i) != null) {
							itemCost = document.getElementById("cost_" + i).value;
							if(!isNaN(itemCost)) {
								costTotal = addMul(costTotal, itemCost);
							}
						}
						if(document.getElementById("amount_" + i) != null) {
							itemAmount = document.getElementById("amount_" + i).value;
							if(!isNaN(itemAmount)) {
								amountTotal = addMul(amountTotal, itemAmount);
							}
						}
					}
				}
				if(document.getElementById("amountSpan") != null) {
					document.getElementById("amountSpan").innerHTML = amountTotal;
				}
				if(document.getElementById("costSpan") != null) {
					document.getElementById("costSpan").innerHTML = costTotal;
				}
			}

			function selectManager() {
				var url = "base/StafferMainForSelect.html";
				ShowIframe(['1000px', '500px'], url, '', '', '' );
			}
			function selectManagerCallBack() {
				if(popRetVal != null) {
					var arr = popRetVal.split(";");
					document.getElementById("inBill.managerId").value = arr[0];
					document.getElementById("inBill.managerName").value = arr[1];
				}
			}

			function selectEstablishment(type) {
				var url = "/base/EstablishmentListForSelect.ihtm?type=" + type + "&ts_id=2";
				ShowIframe(['900px','500px'], url, '', function(){
					selectOffererCallBack();
				}, '供方单位');
			}

			function selectOffererCallBack() {
				if(popRetVal != null) {
					document.getElementById("inBill.offererId").value = popRetVal[0];
					document.getElementById("offererName").value = popRetVal[1];
				}
			}

			function changeTimeSelect(obj, targetName) {
				document.getElementById(targetName).value = obj.value;
			}

			function doOffererTypeChange() {
				document.getElementById("inBill.offererId").value = "0";
				document.getElementById("offererName").value = "";
			}

			function selectOfferer() {
				var offererType = document.getElementById("inBill.offererType").value;
				if(offererType == 'CLIENT' || offererType == 'PROVIDER' || offererType == 'COOPERATOR') {
					selectEstablishment(offererType);
				} else if(offererType == 'DEPARTMENT') {
					var url = "/base/DepartmentListForSelect.ihtm";
					ShowIframe(['310px','500px'], url, '', function(){
						selectOffererCallBack();
					}, '供方单位');
				} else if(offererType == 'STOREHOUSE') {
					var url = "/base/StorehouseListForSelect.ihtm";
					ShowIframe(['300px','300px'], url, '', function(){
						selectOffererCallBack();
					}, '供方单位');
				} else if(offererType == 'WORK_CENTER') {
					var url = "/base/WorkCenterListForSelect.ihtm";
					ShowIframe(['600px','400px'], url, '', function(){
						selectOffererCallBack();
					}, '供方单位');
				} else {
					ShowAlert('提示框', {title:'请选择供方类型'});
				}
			}

			function selectBusinessBill() {
				var url = "/make/BusinessBillListForSelect.ihtm?search_type=STO&ts_id=2";
				ShowIframe(['900px','500px'], url, '', function(){
					selectBusinessBillCallBack();
				}, '选择业务单');
			}

			function selectBusinessBillCallBack() {
				if(popRetVal != null) {
					document.getElementById("inBill.businessBillCode").value = popRetVal[1];
				}
			}

			function doPrint(id) {
				showWin(['900px','600px'], "/storehouse/InBillPrint.ihtm?id=" + id);
			}

			function doOut(id) {
				showWin(['1024px','600px'], "/storehouse/OutBillNew.ihtm?alert_type=FORM&data_type=IN_BILL&in_bill_id=" + id);
			}

			function doInit() {
				showFormErrorMsg();
				resizePopwin();
				if(document.getElementById("pro_code")) {
					document.getElementById("pro_code").focus();
				}
			}

			function checkProCode() {
				if(window.event.keyCode == 13) {
					addProCode();
				}
			}

			function addProCode() {
				var proCode = document.getElementById("pro_code").value.trim();
				if(proCode == "") {
					ShowAlert('请输入条形码',{title:'提示框'});
				} else {
					document.getElementById("LoadProcess").style.top = getTopPos(document.getElementById("pro_code")) + 50 + "px";
					document.getElementById("LoadProcess").style.left = getleftPos(document.getElementById("pro_code")) + 100 + "px";
					document.getElementById("LoadProcess").style.display = "";

					$.post("InBillAjax", {
						pro_code: proCode
					}, function(data, status) {
						parseProData(data, status);
					});
					document.getElementById("pro_code").value = "";
				}
			}

			function parseProData(data, status) {
				if(status == "success") {
					var obj = $.parseJSON(data);
					if(obj != null){
						if(obj.prodId - 0 != 0) {
							var found = false;
							var itemNum = document.getElementById("item_num").value - 0;
							for(var i = 0; i < itemNum; i++) {
								if(document.getElementById("status_" + i).value != "DELETE") {
									if(document.getElementById("product_code_" + i).value == obj.prodCode) {
										var amount = document.getElementById("amount_" + i).value;
										if(!isNaN(amount)) {
											amount = amount - 0 + 1;
										} else {
											amount = 1;
										}
										document.getElementById("amount_" + i).value = amount;
										checkItemChange(i);
										found = true;
										break;
									}
								}
							}
							if(!found) {
								var newIndex = doItemAdd();
								document.getElementById("product_id_" + newIndex).value = obj.prodId;
								document.getElementById("product_code_" + newIndex).value = obj.prodCode;
								document.getElementById("product_name_" + newIndex).value = obj.prodName;
								document.getElementById("product_unit_" + newIndex).value = obj.unit;
								document.getElementById("amount_" + newIndex).value = "1";
								document.getElementById("unit_price_" + newIndex).value = obj.inPric;
								checkItemChange(newIndex);
							}
						}
					}
					document.getElementById("LoadProcess").style.display = "none";
				} else {
					$("#LoadProcess").hide();
					ShowAlert('系统错误：' + status, {title:'提示框'});
				}
			}

			function doUpload() {
				var storehouseId = document.getElementById("inBill.storehouseId").value;
				var url = "/storehouse/InBillUploadForm.html?storehouse_id=" + storehouseId
				if(storehouseId == "" || storehouseId == "0") {
					ShowAlert('请选择仓库', {title:'提示框'});
				} else {
					
					ShowIframe(['560px', '300px'], url);
//					ShowIframe("导入Excel", "/storehouse/InBillUploadForm.ihtm?storehouse_id=" + storehouseId, 560, 300, "doUploadCallBack()");
				}
			}

			function doUploadCallBack() {
				if(popRetVal) {
					document.getElementById("LoadProcess").style.top = getTopPos(document.getElementById("uplo_link")) + 50 + "px";
					document.getElementById("LoadProcess").style.left = getleftPos(document.getElementById("uplo_link")) + 100 + "px";
					document.getElementById("LoadProcess").style.display = "";

					var fileName = popRetVal;
					$.post("/storehouse/ImportInBillItem.ihtm", {
						file_name: fileName
					}, function(data, status) {
						parseUploadData(data, status);
					});
				}
			}

			function parseUploadData(data, status) {
				if(status == "success") {
					var obj = $.parseJSON(data);
					if(obj.status == "ERROR") {
						$("#LoadProcess").hide();
						ShowAlert(obj.errMsg, {title:'提示框'});
					} else {
						$.each(obj.items, function(index, item) {
							var newIndex = doItemAdd();
							document.getElementById("product_id_" + newIndex).value = item.prodId;
							document.getElementById("product_code_" + newIndex).value = item.prodCode;
							document.getElementById("product_name_" + newIndex).value = item.prodName;
							document.getElementById("product_unit_" + newIndex).value = item.prodUnit;
							document.getElementById("amount_" + newIndex).value = item.prodAmou;
							document.getElementById("unit_price_" + newIndex).value = item.prodPric;
							document.getElementById("mark_" + newIndex).value = item.prodMark;
							checkItemChange(newIndex);
						});
						$("#LoadProcess").hide();
					}
				} else {
					$("#LoadProcess").hide();
					ShowAlert('系统错误：' + status, {title:'提示框'});
				}
			}
		</script>

	</body>

</html>