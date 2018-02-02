<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>入库单 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link href="calendar/dhtmlgoodies_calendar/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/BillEdit.css">

		<script src="js/minierp.js"></script>
		<script src="js/popup.js"></script>
		<script src="js/jquery-3.0.0.min.js"></script>
		<script src="/calendar/dhtmlgoodies_calendar/dhtmlgoodies_calendar.js"></script>
		<script language="javascript">
			function doSave(flag) {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				document.getElementById("continue_flag").value = flag;

				ShowConfirm('确认框', '是否同时审核？', 340, 80, "doSaveCallBack()");

			}

			function doSaveCallBack() {
				if(popRetVal != null) {
					document.getElementById("examine").value = "1";
				}
				frm.submit();
			}

			function doReorder(id) {
				window.location = "InBillNew.ihtm?alert_type=&data_type=COPY&template_id=" + id;
			}

			function doCancel() {
				if(window.opener) {
					window.close();
				} else {
					parent.ClosePop();
				}
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
				ShowIframe("选择材料", url, 900, 500, "selectProductCallBack(" + index + ")");
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
				var url = "/base/ProductMainForSelect.ihtm?type=MULTI";
				ShowIframe("选择材料", url, 900, 500, "doMultiSelectCallBack()");
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
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "product_code_" + itemNum);
				input.setAttribute("id", "product_code_" + itemNum);
				input.setAttribute("readOnly", true);
				input.setAttribute("className", "TextBox readonly");
				input.setAttribute("class", "TextBox readonly");
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.width = "160px";
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "product_name_" + itemNum);
				input.setAttribute("id", "product_name_" + itemNum);
				input.setAttribute("readOnly", true);
				input.setAttribute("className", "TextBox readonly");
				input.setAttribute("class", "TextBox readonly");
				input.onmouseover = inputOnMouseOver;
				td.appendChild(input);

				td.appendChild(document.createTextNode(" "));
				input = document.createElement("img");
				input.setAttribute("src", "/images/icon_add.gif");
				input.setAttribute("index", itemNum);
				input.style.cursor = "pointer";
				input.onclick = buttonOnClick;
				td.appendChild(input);

				input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "product_id_" + itemNum);
				input.setAttribute("id", "product_id_" + itemNum);
				input.setAttribute("value", "0");
				td.appendChild(input);

				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.width = "40px";
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "product_unit_" + itemNum);
				input.setAttribute("id", "product_unit_" + itemNum);
				input.setAttribute("readOnly", true);
				input.setAttribute("className", "TextBox readonly");
				input.setAttribute("class", "TextBox readonly");
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.cssText = "text-align:right";
				input.style.width = "50px";
				input.setAttribute("maxLength", "10");
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "amount_" + itemNum);
				input.setAttribute("id", "amount_" + itemNum);
				input.setAttribute("value", "");
				input.setAttribute("className", "TextBox");
				input.setAttribute("class", "TextBox");
				input.onchange = elementOnChnage;
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.cssText = "text-align:right";
				input.style.width = "50px";
				input.setAttribute("maxLength", "10");
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "unit_price_" + itemNum);
				input.setAttribute("id", "unit_price_" + itemNum);
				input.setAttribute("value", "");
				input.setAttribute("className", "TextBox");
				input.setAttribute("class", "TextBox");
				input.onchange = elementOnChnage;
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.cssText = "text-align:right";
				input.style.width = "50px";
				input.setAttribute("maxLength", "10");
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "cost_" + itemNum);
				input.setAttribute("id", "cost_" + itemNum);
				input.setAttribute("value", "0");
				input.setAttribute("readOnly", true);
				input.setAttribute("className", "TextBox readonly");
				input.setAttribute("class", "TextBox readonly");
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.width = "150px";
				input.setAttribute("maxLength", "200");
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "mark_" + itemNum);
				input.setAttribute("id", "mark_" + itemNum);
				input.setAttribute("value", "");
				input.setAttribute("className", "TextBox");
				input.setAttribute("class", "TextBox");
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

				resizePopwin();

				return itemNum; //当前行的index
			}

			function doItemDelete(index) {
				ShowConfirm('确认框', '确定删除吗？', 340, 80, "doItemDeleteCallBack(" + index + ")");
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
				var url = "/base/StafferMainForSelect.ihtm";
				ShowIframe("选择员工", url, 800, 500, "selectManagerCallBack()");
			}

			function selectManagerCallBack() {
				if(popRetVal != null) {
					var arr = popRetVal.split(";");
					document.getElementById("inBill.managerId").value = arr[0];
					document.getElementById("inBill.managerName").value = arr[1];
				}
			}

			function selectEstablishment(type) {
				var url = "/base/EstablishmentListForSelect.ihtm?type=" + type + "&ts_id=1";
				ShowIframe("供方单位", url, 900, 500, "selectOffererCallBack()");
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
					ShowIframe("供方单位", url, 310, 500, "selectOffererCallBack()");
				} else if(offererType == 'STOREHOUSE') {
					var url = "/base/StorehouseListForSelect.ihtm";
					ShowIframe("供方单位", url, 300, 300, "selectOffererCallBack()");
				} else if(offererType == 'WORK_CENTER') {
					var url = "/base/WorkCenterListForSelect.ihtm";
					ShowIframe("供方单位", url, 600, 400, "selectOffererCallBack()");
				} else {
					ShowAlert('提示框', '请选择供方类型', 200, 100);
				}
			}

			function selectBusinessBill() {
				var url = "/make/BusinessBillListForSelect.ihtm?search_type=STO&ts_id=1";
				ShowIframe("选择业务单", url, 900, 500, "selectBusinessBillCallBack()");
			}

			function selectBusinessBillCallBack() {
				if(popRetVal != null) {
					document.getElementById("inBill.businessBillCode").value = popRetVal[1];
				}
			}

			function doPrint(id) {
				showWin(900, 600, "/storehouse/InBillPrint.ihtm?id=" + id);
			}

			function doOut(id) {
				showWin(1024, 600, "/storehouse/OutBillNew.ihtm?alert_type=FORM&data_type=IN_BILL&in_bill_id=" + id);
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
					ShowAlert('提示框', '请输入条形码', 200, 100);
				} else {
					document.getElementById("LoadProcess").style.top = getTopPos(document.getElementById("pro_code")) + 50 + "px";
					document.getElementById("LoadProcess").style.left = getleftPos(document.getElementById("pro_code")) + 100 + "px";
					document.getElementById("LoadProcess").style.display = "";

					$.post("/base/GetProduct.ihtm", {
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

					document.getElementById("LoadProcess").style.display = "none";
				} else {
					$("#LoadProcess").hide();
					ShowAlert('提示框', '系统错误：' + status, 200, 100);
				}
			}

			function doUpload() {
				var storehouseId = document.getElementById("inBill.storehouseId").value;
				if(storehouseId == "" || storehouseId == "0") {
					ShowAlert('提示框', '请选择仓库', 200, 100);
				} else {
					ShowIframe("导入Excel", "/storehouse/InBillUploadForm.ihtm?storehouse_id=" + storehouseId, 560, 300, "doUploadCallBack()");
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
						ShowAlert('提示框', obj.errMsg, 200, 100);
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
					ShowAlert('提示框', '系统错误：' + status, 200, 100);
				}
			}
		</script>
	</head>

	<body onload="doInit();">
		<div class="Wrap">
			<form name="frm" method="post">
				<div class="Container">
					<div class="Contnet Paper">
						<!-- 保存按钮是否可点击 -->
						<!-- 编码框是否可点击 -->
						<!-- 编码框颜色 -->

						<!-- 是否可以编辑日期 -->

						<!-- 提示信息 -->

						<script language="javascript">
							var formErrorIndex = 0;
							var formErrorMsg = "";
							var formErrorObjId = "";

							function setFormErrorMsg(msg, index, objId) {
								if(formErrorIndex == 0 || formErrorIndex > index) {
									if(msg != null && msg != "") {
										formErrorIndex = index;
										formErrorMsg = msg;
										formErrorObjId = objId;
									}
								}
							}

							function showFormErrorMsg() {
								if(formErrorIndex != 0) {
									document.getElementById("errorMsgTr").style.display = "";
									document.getElementById("errorMsgDiv").innerHTML = formErrorMsg;
									if(formErrorObjId != null && formErrorObjId != "") {
										document.getElementById(formErrorObjId).focus();
									}
								}
							}

							function goNextInput(objId) {
								var obj = null;
								if(objId != null && objId != '') {
									obj = document.getElementById(objId);
								}
								if(window.event.keyCode == 13) {
									if(obj != null) {
										obj.focus();
									} else if(window.doSave) {
										doSave();
									}
								}
							}
						</script>
						<table width="96%" border="0" cellpadding="0" cellspacing="0" align="center">
							<tbody>
								<tr id="errorMsgTr" style="display:none">
									<td colspan="2">
										<div class="msg-error" id="errorMsgDiv">

										</div>
									</td>
								</tr>
							</tbody>
						</table>

						<!--单 标题-->
						<br>
						<table class="BillHeading" cellspacing="0" cellpadding="0">
							<tbody>
								<tr>
									<td width="301px;" rowspan="2">
										<div class="CorpLogo"><img src="images/1_1456975049379.gif"></div>
									</td>
									<td width="301px;" rowspan="2">
										<h1>编辑入库单</h1></td>
									<td width="301px;" class="tr vb codeTd">
										<span class="MustInput">*</span>编号：

										<input type="text" class="tbBillCode TextBox disabled" readonly="readonly" maxlength="30" onkeyup="goNextInput('inDateStr');" id="inBill.billCode" name="inBill.billCode" value="L(1)2017110006">
										<script language="javascript">
											setFormErrorMsg('', 1, 'inBill.billCode');
										</script>

									</td>
								</tr>
								<tr>
									<td class="tr">
										<span id="calPosi"></span>
										<span class="MustInput">*</span>入库日期：

										<input type="text" class="tbBillDate_sim TextBox " maxlength="15" id="inDateStr" name="inDateStr" value="2017-11-19">
										<img src="/images/calendar.gif" class="imgIconButton" onclick="displayCalendar(document.getElementById('inDateStr'),'yyyy-mm-dd',document.getElementById('calPosi'));">
										<script language="javascript">
											setFormErrorMsg('', 2, 'inDateStr');
										</script>

									</td>
								</tr>
							</tbody>
						</table>

						<!-- 单 头信息 -->
						<div class="TopBottom_Border">
							<table class="BillHeadInfo" cellspacing="0" cellpadding="0">
								<tbody>
									<tr>
										<td width="284px">
											<span class="MustInput">*</span>仓库：

											<select style="width:174px" id="inBill.storehouseId" name="inBill.storehouseId">
												<option value="0">==请选择==</option>

												<option value="1" selected="">标识加工仓库</option>

												<option value="2">中力门店仓库</option>

												<option value="7">标牌加工仓库</option>

												<option value="10">标牌配件仓库</option>

												<option value="9">铝型材仓库</option>

											</select>
											<script language="javascript">
												setFormErrorMsg('', 3);
											</script>

										</td>
										<th width="84px">供方类型：</th>
										<td width="313px">

											<select style="width:100px" id="inBill.offererType" name="inBill.offererType" onchange="doOffererTypeChange();">
												<option value="">==请选择==</option>
												<option value="WORK_CENTER">工作中心</option>
												<option value="PROVIDER" selected="">供应商</option>
												<option value="COOPERATOR">外协商</option>
												<option value="DEPARTMENT">部门</option>
												<option value="STOREHOUSE">仓库</option>
												<option value="CLIENT">客户</option>
											</select>
											<script language="javascript">
												setFormErrorMsg('', 6);
											</script>

											供方：

											<input type="text" class="TextBox readonly" readonly="readonly" style="width:104px" id="offererName" name="offererName" value="郑州合谦商贸有限公司">
											<img class="make-a" src="/images/make-a.gif" style="cursor:pointer;" onclick="selectOfferer();">

											<input type="hidden" id="inBill.offererId" name="inBill.offererId" value="499">
											<script language="javascript">
												setFormErrorMsg('', 7);
											</script>

										</td>
										<td width="223px;" class="tr">
											<span class="MustInput">*</span>入库类型：

											<select style="width:110px" id="inBill.inTypeId" name="inBill.inTypeId">
												<option value="0">==请选择==</option>

												<option value="1" selected="">采购入库</option>

												<option value="2">内部调拨</option>

												<option value="3">盘点入库</option>

											</select>
											<script language="javascript">
												setFormErrorMsg('', 4);
											</script>

										</td>
									</tr>
								</tbody>
							</table>
						</div>

						<!-- 明细 -->
						<input type="hidden" id="item_num" name="item_num" value="6">
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

								<tr id="itemTr0">
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:80px" id="product_code_0" name="product_code_0" value="C44-0020">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:160px" id="product_name_0" name="product_name_0" value="FD802 环氧灰底漆（老） 4L" onmouseover="this.title=this.value">
										<img src="/images/icon_add.gif" style="cursor:pointer;" onclick="selectProduct(0,'');">
										<input type="hidden" id="product_id_0" name="product_id_0" value="562">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:40px" id="product_unit_0" name="product_unit_0" value="罐">
									</td>
									<td>
										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="amount_0" name="amount_0" value="8" onchange="checkItemChange(0,this.id);">
									</td>
									<td>

										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="unit_price_0" name="unit_price_0" value="155" onchange="checkItemChange(0,this.id);">

									</td>
									<td>

										<input class="TextBox readonly" readonly="readonly" type="text" style="width:50px;text-align:right;" maxlength="10" id="cost_0" name="cost_0" value="1240">

									</td>
									<td>
										<input type="text" class="TextBox" style="width:150px" maxlength="200" id="mark_0" name="mark_0" value="" onchange="checkItemChange(0,this.id);">
									</td>
									<td>
										<a href="javascript:doItemDelete(0);">删除</a>
										<input type="hidden" id="status_0" name="status_0" value="UNCHANGE">
										<input type="hidden" id="id_0" name="id_0" value="667">
									</td>
								</tr>

								<tr id="itemTr1">
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:80px" id="product_code_1" name="product_code_1" value="C44-0036">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:160px" id="product_name_1" name="product_name_1" value="FD117 鲜红 4L" onmouseover="this.title=this.value">
										<img src="/images/icon_add.gif" style="cursor:pointer;" onclick="selectProduct(1,'');">
										<input type="hidden" id="product_id_1" name="product_id_1" value="578">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:40px" id="product_unit_1" name="product_unit_1" value="罐">
									</td>
									<td>
										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="amount_1" name="amount_1" value="16" onchange="checkItemChange(1,this.id);">
									</td>
									<td>

										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="unit_price_1" name="unit_price_1" value="189" onchange="checkItemChange(1,this.id);">

									</td>
									<td>

										<input class="TextBox readonly" readonly="readonly" type="text" style="width:50px;text-align:right;" maxlength="10" id="cost_1" name="cost_1" value="3024">

									</td>
									<td>
										<input type="text" class="TextBox" style="width:150px" maxlength="200" id="mark_1" name="mark_1" value="" onchange="checkItemChange(1,this.id);">
									</td>
									<td>
										<a href="javascript:doItemDelete(1);">删除</a>
										<input type="hidden" id="status_1" name="status_1" value="UNCHANGE">
										<input type="hidden" id="id_1" name="id_1" value="668">
									</td>
								</tr>

								<tr id="itemTr2">
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:80px" id="product_code_2" name="product_code_2" value="C44-0032">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:160px" id="product_name_2" name="product_name_2" value="FD129 玫瑰红 4L" onmouseover="this.title=this.value">
										<img src="/images/icon_add.gif" style="cursor:pointer;" onclick="selectProduct(2,'');">
										<input type="hidden" id="product_id_2" name="product_id_2" value="574">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:40px" id="product_unit_2" name="product_unit_2" value="罐">
									</td>
									<td>
										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="amount_2" name="amount_2" value="8" onchange="checkItemChange(2,this.id);">
									</td>
									<td>

										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="unit_price_2" name="unit_price_2" value="211.68" onchange="checkItemChange(2,this.id);">

									</td>
									<td>

										<input class="TextBox readonly" readonly="readonly" type="text" style="width:50px;text-align:right;" maxlength="10" id="cost_2" name="cost_2" value="1693.44">

									</td>
									<td>
										<input type="text" class="TextBox" style="width:150px" maxlength="200" id="mark_2" name="mark_2" value="" onchange="checkItemChange(2,this.id);">
									</td>
									<td>
										<a href="javascript:doItemDelete(2);">删除</a>
										<input type="hidden" id="status_2" name="status_2" value="UNCHANGE">
										<input type="hidden" id="id_2" name="id_2" value="669">
									</td>
								</tr>

								<tr id="itemTr3">
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:80px" id="product_code_3" name="product_code_3" value="C44-0018">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:160px" id="product_name_3" name="product_name_3" value="RE8708 快干固化剂 2L" onmouseover="this.title=this.value">
										<img src="/images/icon_add.gif" style="cursor:pointer;" onclick="selectProduct(3,'');">
										<input type="hidden" id="product_id_3" name="product_id_3" value="560">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:40px" id="product_unit_3" name="product_unit_3" value="罐">
									</td>
									<td>
										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="amount_3" name="amount_3" value="30" onchange="checkItemChange(3,this.id);">
									</td>
									<td>

										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="unit_price_3" name="unit_price_3" value="90" onchange="checkItemChange(3,this.id);">

									</td>
									<td>

										<input class="TextBox readonly" readonly="readonly" type="text" style="width:50px;text-align:right;" maxlength="10" id="cost_3" name="cost_3" value="2700">

									</td>
									<td>
										<input type="text" class="TextBox" style="width:150px" maxlength="200" id="mark_3" name="mark_3" value="" onchange="checkItemChange(3,this.id);">
									</td>
									<td>
										<a href="javascript:doItemDelete(3);">删除</a>
										<input type="hidden" id="status_3" name="status_3" value="UNCHANGE">
										<input type="hidden" id="id_3" name="id_3" value="670">
									</td>
								</tr>

								<tr id="itemTr4">
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:80px" id="product_code_4" name="product_code_4" value="C45-0124">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:160px" id="product_name_4" name="product_name_4" value="除尘布" onmouseover="this.title=this.value">
										<img src="/images/icon_add.gif" style="cursor:pointer;" onclick="selectProduct(4,'');">
										<input type="hidden" id="product_id_4" name="product_id_4" value="687">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:40px" id="product_unit_4" name="product_unit_4" value="片">
									</td>
									<td>
										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="amount_4" name="amount_4" value="200" onchange="checkItemChange(4,this.id);">
									</td>
									<td>

										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="unit_price_4" name="unit_price_4" value="0.6" onchange="checkItemChange(4,this.id);">

									</td>
									<td>

										<input class="TextBox readonly" readonly="readonly" type="text" style="width:50px;text-align:right;" maxlength="10" id="cost_4" name="cost_4" value="120">

									</td>
									<td>
										<input type="text" class="TextBox" style="width:150px" maxlength="200" id="mark_4" name="mark_4" value="" onchange="checkItemChange(4,this.id);">
									</td>
									<td>
										<a href="javascript:doItemDelete(4);">删除</a>
										<input type="hidden" id="status_4" name="status_4" value="UNCHANGE">
										<input type="hidden" id="id_4" name="id_4" value="671">
									</td>
								</tr>

								<tr id="itemTr5">
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:80px" id="product_code_5" name="product_code_5" value="C45-0152">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:160px" id="product_name_5" name="product_name_5" value="展业大遮蔽膜" onmouseover="this.title=this.value">
										<img src="/images/icon_add.gif" style="cursor:pointer;" onclick="selectProduct(5,'');">
										<input type="hidden" id="product_id_5" name="product_id_5" value="1183">
									</td>
									<td>
										<input type="text" class="TextBox readonly" readonly="readonly" style="width:40px" id="product_unit_5" name="product_unit_5" value="卷">
									</td>
									<td>
										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="amount_5" name="amount_5" value="100" onchange="checkItemChange(5,this.id);">
									</td>
									<td>

										<input type="text" class="TextBox" style="width:50px;text-align:right;" maxlength="10" id="unit_price_5" name="unit_price_5" value="8" onchange="checkItemChange(5,this.id);">

									</td>
									<td>

										<input class="TextBox readonly" readonly="readonly" type="text" style="width:50px;text-align:right;" maxlength="10" id="cost_5" name="cost_5" value="800">

									</td>
									<td>
										<input type="text" class="TextBox" style="width:150px" maxlength="200" id="mark_5" name="mark_5" value="" onchange="checkItemChange(5,this.id);">
									</td>
									<td>
										<a href="javascript:doItemDelete(5);">删除</a>
										<input type="hidden" id="status_5" name="status_5" value="UNCHANGE">
										<input type="hidden" id="id_5" name="id_5" value="672">
									</td>
								</tr>

							</tbody>
						</table>
						<div class="table-bot" style="margin-top:4px">
							<span style="float:right;PADDING-RIGHT:10px;color:#aaa">
					数量小计：<span id="amountSpan">362</span>&nbsp; 金额小计：

							<span id="costSpan">9577.44</span>元

							</span>

						</div>
						<br>

						<script language="javascript">
							setFormErrorMsg('', 8);
						</script>

						<!-- 附加信息 -->
						<div class="TopBottom_Border">
							<table class="BillElseInfo" cellspacing="0" cellpadding="0">
								<tbody>
									<tr>
										<th width="84px"><span class="MustInput">*</span>经办人：</th>
										<td width="200px">

											<input type="text" class="tbInfo1 TextBox readonly" readonly="readonly" id="inBill.managerName" name="inBill.managerName" value="邵丽萍">
											<img class="make-a" src="/images/make-a.gif" style="cursor:pointer;" onclick="selectManager();">

											<input type="hidden" id="inBill.managerId" name="inBill.managerId" value="43">
											<script language="javascript">
												setFormErrorMsg('', 8);
											</script>

										</td>
										<th width="84px">备注：</th>

										<td width="273px">
											<input type="text" class="tbInfo2 TextBox" maxlength="50" id="inBill.mark" name="inBill.mark" value="">
											<script language="javascript">
												setFormErrorMsg('', 10, 'inBill.mark');
											</script>
										</td>

										<th width="84px">&nbsp;</th>
										<td width="179px">&nbsp;</td>
									</tr>
								</tbody>
							</table>
						</div>
						<br>
						<div class="BillNotes">
							<span>开单人：邵丽萍 2017-11-19 16:30</span>
							<span>审核人：邵丽萍 2017-11-19 16:30</span>
							<span>单据帐套：新异</span>

							<script language="javascript">
								setFormErrorMsg('', 1);
							</script>

						</div>
					</div>

					<!-- 底栏按钮 -->
					<div class="Footer">
						<div id="buttonDiv">
							<input type="button" class="buttom-a" value=" 保 存 " onclick="doSave('0');" disabled="true">

							<input type="button" class="buttom-a" value="复制新增" onclick="doReorder(146);" title="把当前入库单复制生成新的入库单">
							<!--
					
					<input type="button" class="buttom-a" value="生成出库单" onClick="doOut(146);" >
					
					-->
							<input type="button" class="buttom-a" value=" 打 印 " onclick="doPrint(146);">

							<input type="button" class="buttom-a" value=" 取 消 " onclick="doCancel();">
							<input type="hidden" name="continue_flag" id="continue_flag" value="0">
							<input type="hidden" id="examine" name="examine" value="0">
							<input type="hidden" id="sychronizeValue" name="sychronizeValue" value="1511080249000">
							<input type="hidden" id="inDateHour" name="inDateHour" value="00">
							<input type="hidden" id="inDateMinute" name="inDateMinute" value="00">
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
							<img src="/images/loading.gif"> 请稍候...
						</td>
					</tr>
				</tbody>
			</table>
		</div>

	</body>

</html>
										