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

	</head>

	<body onload="doInit();" style="min-width: 1090px;">
		<div>
			<form class="layui-form" action="OutBill_saveOutBill" name="frm" method="post">
				<div class="Container">
					<div class="Contnet Paper">

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
						<div class="BillHeading">
							<div class="layui-row">
								<div class="layui-col-sm4">
									<div class="CorpLogo"><img src="images/BIAO  SHI  HUI.png"></div>
								</div>
								<div class="layui-col-sm4">
									<h1>新增出库单</h1>
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
										<div class="layui-input-inline" style="width: 85px;">
											<input class="layui-input" readonly placeholder="" type="text" maxlength="30" onkeyup="goNextInput(&#39;outDateStr&#39;);" id="outBill.billCode" name="outBill.billCode" value="">
										</div>
										<script language="javascript">
											setFormErrorMsg('', 1, 'outBill.billCode');
										</script>
									</div>
									<div class="layui-form-item" style="display: inline-block;">
										<label class="layui-form-label"><span class="MustInput">*</span>出库日期：</label>
										<div class="layui-input-inline" style="width: 85px;">
											<input class="layui-input" placeholder="" type="text" maxlength="15" id="outDateStr" name="outDateStr" value="2017-11-21">
										</div>
										<script language="javascript">
											setFormErrorMsg('', 2, 'outDateStr');
										</script>
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
										<select style="width:174px" id="outBill.storehouseId" name="outBill.storehouseId">
												<option value="0">==请选择==</option>

												<option value="1">标识加工仓库</option>

												<option value="2">中力门店仓库</option>

												<option value="3">车间型材仓库</option>

												<option value="4">车间耗材仓库</option>

												<option value="5">车间工具仓库</option>

											</select>
											<script language="javascript">
												setFormErrorMsg('', 3);
											</script>
									</div>
								</div>
							</div>
							<div class="layui-col-sm3 tc">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 70px;">需方类型：</label>
									<div class="layui-input-inline" style="width: 120px;">
										<select style="width:100px" id="outBill.requirerType" name="outBill.requirerType" onchange="doRequirerTypeChange();">
												<option value="">==请选择==</option>
												<option value="WORK_CENTER" selected="">工作中心</option>
												<option value="DEPARTMENT">部门</option>
												<option value="CLIENT">客户</option>
												<option value="STOREHOUSE">仓库</option>
												<option value="PROVIDER">供应商</option>
												<option value="COOPERATOR">外协商</option>
											</select>
											<script language="javascript">
												setFormErrorMsg('', 6);
											</script>
									</div>
								</div>
							</div>
							<div class="layui-col-sm3 tc">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 70px;">需方：</label>
									<div class="layui-input-inline" style="width: 100px;">
										<input class="layui-input" readonly placeholder="" type="text" id="requirerName" name="requirerName" value="">
									</div>
											<input type="hidden" id="outBill.requirerId" name="outBill.requirerId" value="0">
											<script language="javascript">
												setFormErrorMsg('', 7);
											</script>
									<div class="layui-form-mid">
										<a href="javascript:selectRequirer();">选择</a>
									</div>
								</div>
							</div>
							<div class="layui-col-sm3 tr">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 70px;"><span class="MustInput">*</span>出库类型：</label>
									<div class="layui-input-inline" style="width: 140px; text-align: center;">
										<select style="width:110px" id="outBill.outTypeId" name="outBill.outTypeId">
												<option value="0">==请选择==</option>

												<option value="1">销售出库</option>

												<option value="2">内部调拨</option>

												<option value="3">盘亏出库</option>

												<option value="4">加工制作</option>

												<option value="5">低值易耗品</option>

											</select>
											<script language="javascript">
												setFormErrorMsg('', 4);
											</script>
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
							<a href="javascript:doMultiSelect();">增加出库明细</a>
							<span style="color:#aaa">(审核后单价显示为库存单价)</span>
							<a id="uplo_link" href="javascript:doUpload();">从Excel导入</a>

						</div>

						<script language="javascript">
							setFormErrorMsg('', 8);
						</script>
						
						<hr />
						
						<!-- 附加信息 -->
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<label class="layui-form-label" style="width: 70px;"><span class="MustInput">*</span>经办人：</label>
									<div class="layui-input-inline" style="width: 140px;">
										<input class="layui-input" readonly placeholder="" type="text" id="outBill.managerName" name="outBill.managerName" value="">
							<input type="hidden" id="outBill.managerId" name="outBill.managerId" value="">
									</div>
									<div class="layui-form-mid">
										<a href="javascript:selectManager();">选择</a>
									</div>
									<script language="javascript">
												setFormErrorMsg('', 8);
											</script>
								</div>
							</div>
							<div class="layui-col-sm5">
								<div class="layui-form-item">
									<label class="layui-form-label" style="width: 70px;">备注：</label>
									<div class="layui-input-block" style="margin-left: 100px;">
										<input class="layui-input" placeholder="" type="text" maxlength="50" id="outBill.mark" name="outBill.mark" value="">
										<script language="javascript">
												setFormErrorMsg('', 10, 'outBill.mark');
											</script>
									</div>
								</div>
							</div>
						</div>
								<div class="layui-form-item">
									<label class="layui-form-label" style="width: 70px;">业务单号：</label>
									<div class="layui-input-inline">
										<input class="layui-input" placeholder="" type="text" maxlength="30" id="outBill.businessBillCode" name="outBill.businessBillCode" value="" onchange="checkBbCode();">
										<script language="javascript">
												setFormErrorMsg('', 9, 'outBill.mark');
											</script>
									</div>
									<div class="layui-form-mid">
										<a href="javascript:selectBusinessBill();">选择</a>
									</div>
									<div class="layui-form-mid">
										<a href="javascript:clearBusinessBill();">清除</a>
									</div>
								</div>
						<div class="BillNotes">
							<span>开单人：标识汇 2017-07-09 17:20</span>
							<span>审核人：</span>
							<span>单据帐套：新异</span>

							<script language="javascript">
								setFormErrorMsg('', 1);
							</script>

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
							<input type="hidden" id="outDateHour" name="outDateHour" value="17">
							<input type="hidden" id="outDateMinute" name="outDateMinute" value="20">
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
		<script src="js/dhtmlgoodies_calendar.js"></script>
		<script>
			var layer_index = parent.layer.getFrameIndex(window.name);
			
			function doSave(flag) {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				document.getElementById("continue_flag").value = flag;

				ShowConfirm('是否同时审核？', {title:'确认框'}, function(){
					popRetVal = 'Y';
					doSaveCallBack();
				});

			}

			function doSaveCallBack() {
				if(popRetVal != null) {
					document.getElementById("examine").value = "1";
				}
				frm.submit();
			}

			function doCancel() {
				if(window.opener) {
					window.close();
				} else {
					parent.layer.close(layer_index);
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
				var stoId = document.getElementById("outBill.storehouseId").value;
				var url = "/base/ProductMainForSelect.html?stock=Y&sto_id=" + stoId;
				ShowIframe(['900px','500px'], url, '', function(){
					alert(index);
					selectProductCallBack(index);
				},'选择材料');
			}

			function selectProductCallBack(index) {
				if(popRetVal != null) {
					document.getElementById("product_id_" + index).value = popRetVal[0];
					document.getElementById("product_code_" + index).value = popRetVal[1];
					document.getElementById("product_name_" + index).value = popRetVal[2];
					document.getElementById("product_unit_" + index).value = popRetVal[3];
					document.getElementById("amount_" + index).value = popRetVal[4];
					checkItemChange(index);
				}
			}

			function doMultiSelect() {
				var stoId = document.getElementById("outBill.storehouseId").value;
				var url = "InBillNew_toProductMainForSelect";
				ShowIframe(['900px','500px'], url, '', function(){
					doMultiSelectCallBack();
				}, '选择材料');
			}

			function doMultiSelectCallBack() {
				if(popRetVal != null) {
					for(i = 0; i < popRetVal.length; i++) {
						var newIndex = doItemAdd();
						document.getElementById("product_id_" + newIndex).value = popRetVal[i][0];
						document.getElementById("product_code_" + newIndex).value = popRetVal[i][1];
						document.getElementById("product_name_" + newIndex).value = popRetVal[i][2];
						document.getElementById("product_unit_" + newIndex).value = popRetVal[i][3];
						document.getElementById("amount_" + newIndex).value = popRetVal[i][4];
						checkItemChange(newIndex);
					}
				}
			}

			function doItemAdd() {
				var tbl = document.getElementById("itemRowTbl");
				var itemNum = document.getElementById("item_num").value - 0;

				var tr = document.createElement("tr");
				tr.setAttribute("className", "ListTr");
				tr.setAttribute("class", "ListTr");
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
				input.setAttribute("className", "TextBox");
				input.setAttribute("class", "TextBox");
				input.setAttribute("value", "");
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
				input.setAttribute("value", "0");
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
				input.setAttribute("className", "TextBox");
				input.setAttribute("class", "TextBox");
				input.setAttribute("value", "");
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
				//doCount();

				resizePopwin();

				return itemNum; //当前行的index
			}

			function doItemDelete(index) {
				ShowConfirm('确定删除吗？', {title:'确认框'}, function(){
					alert(index);
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
				ShowIframe(['800px','500px'], url, '', function(){
					selectManagerCallBack();
				}, '选择员工');
			}

			function selectManagerCallBack() {
				if(popRetVal != null) {
					var arr = popRetVal.split(";");
					document.getElementById("outBill.managerId").value = arr[0];
					document.getElementById("outBill.managerName").value = arr[1];
				}
			}

			function selectEstablishment(type) {
				var url = "base/EstablishmentListForSelect.html?type=" + type + "&ts_id=1";
				ShowIframe(['900px','500px'], url, '', function(){
					selectRequirerCallBack();
				}, '需方单位');
			}

			function selectRequirerCallBack() {
				if(popRetVal != null) {
					document.getElementById("outBill.requirerId").value = popRetVal[0];
					document.getElementById("requirerName").value = popRetVal[1];
				}
			}

			function changeTimeSelect(obj, targetName) {
				document.getElementById(targetName).value = obj.value;
			}

			function doRequirerTypeChange() {
				document.getElementById("outBill.requirerId").value = "0";
				document.getElementById("requirerName").value = "";
			}

			function selectRequirer() {
				var requirerType = document.getElementById("outBill.requirerType").value;
				if(requirerType == 'CLIENT' || requirerType == 'PROVIDER' || requirerType == 'COOPERATOR') {
					selectEstablishment(requirerType);
				} else if(requirerType == 'DEPARTMENT') {
					var url = "base/DepartmentListForSelect.html";
					ShowIframe(['310px','500px'], url, '', function(){
						selectRequirerCallBack();
					}, '需方单位');
				} else if(requirerType == 'STOREHOUSE') {
					var url = "base/StorehouseListForSelect.html";
					ShowIframe(['300px','300px'], url, '', function(){
						selectRequirerCallBack();
					}, '需方单位');
				} else if(requirerType == 'WORK_CENTER') {
					var url = "base/WorkCenterListForSelect.html";
					ShowIframe(['600px','400px'], url, '', function(){
						selectRequirerCallBack();
					}, '需方单位');
				} else {
					ShowAlert('请选择需方类型', {title:'提示框'});
				}
			}

			function selectBusinessBill() {
				var url = "make/BusinessBillListForSelect.html?search_type=STO&ts_id=1";
				ShowIframe(['900px','500px'], url, '', function(){
					selectBusinessBillCallBack();
				}, '选择业务单');
			}

			function selectBusinessBillCallBack() {
				if(popRetVal != null) {
					document.getElementById("outBill.businessBillCode").value = popRetVal[1];
					selectBusinessBillCallBackExt("ID", popRetVal[0]);
				}
			}

			function selectBusinessBillCallBackExt(type, key) {
				document.getElementById("LoadProcess").style.top = getTopPos(document.getElementById("pro_code")) + 50 + "px";
				document.getElementById("LoadProcess").style.left = getleftPos(document.getElementById("pro_code")) + 100 + "px";
				document.getElementById("LoadProcess").style.display = "";

				$.post("/business/BusinessBillItemProductSelect.html", {
					type: type,
					key: key
				}, function(data, status) {
					parseSelectBusinessBillData(data, status);
				});
			}

			function parseSelectBusinessBillData(data, status) {
				if(status == "success") {
					var obj = $.parseJSON(data);
					var busiProd = "SELECT";
					if(busiProd == "SELECT") {
						$("#outBill\\.requirerType").val("CLIENT"); //带点的id加两个斜杠
						$("#outBill\\.requirerId").val(obj.estId);
						$("#requirerName").val(obj.estName);
					}

					$.each(obj.items, function(index, item) {
						var newIndex = doItemAdd();
						$("#product_id_" + newIndex).val(item.prodId);
						$("#product_code_" + newIndex).val(item.prodCode);
						$("#product_name_" + newIndex).val(item.prodName);
						$("#product_unit_" + newIndex).val(item.unit);
						$("#amount_" + newIndex).val(item.amou);
						checkItemChange(newIndex);
					});

				}
				document.getElementById("LoadProcess").style.display = "none";
			}

			function clearBusinessBill() {
				document.getElementById("outBill.businessBillCode").value = "";
			}

			function doPrint(id) {
				var url = "/storehouse/OutBillPrint.html?id=" + id;
				showWin(['900px','600px'], url);
			}

			function doIn(id) {
				var url = "/storehouse/InBillNew.html?alert_type=FORM&data_type=OUT_BILL&out_bill_id=" + id;
				showWin(['1024px','600px'], url);
			}

			function doInit() {
				showFormErrorMsg();
				resizePopwin();
				//if(document.getElementById("pro_code")){
				//	document.getElementById("pro_code").focus();
				//}

				document.getElementById("outBill.businessBillCode").focus();

			}

			function checkBbCode() {
				var bbCode = document.getElementById("outBill.businessBillCode").value;
				if(bbCode != '') {
					selectBusinessBillCallBackExt("CODE", bbCode);
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
					ShowAlert('请输入条形码', {title:'提示框'});
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
							checkItemChange(newIndex);
						}
					}
					$("#LoadProcess").hide();
				} else {
					$("#LoadProcess").hide();
					ShowAlert('系统错误：' + status, {title:'提示框'});
				}
			}

			function clearStorehouse() {
				var storId = document.getElementById("outBill.storehouseId").value;
				if(storId == "" || storId == "0") {
					ShowAlert('请选择仓库', {title:'提示框'});
				} else {
					document.getElementById("LoadProcess").style.top = getTopPos(document.getElementById("all_stor")) + 50 + "px";
					document.getElementById("LoadProcess").style.left = getleftPos(document.getElementById("all_stor")) + 100 + "px";
					document.getElementById("LoadProcess").style.display = "";

					$.post("/base/ExistingProduct.html", {
						stor_id: storId
					}, function(data, status) {
						parseExisProData(data, status);
					});
				}
			}

			function parseExisProData(data, status) {
				if(status == "success") {
					var obj = $.parseJSON(data);
					var selectedArr = new Array();
					$.each(obj.items, function(index, item) {
						// 数组支取需要用到的材料属性值，并且各个属性值与选择材料页所返回的数组中的对应属性值位置相同
						selectedArr[index] = new Array(item.prodId, item.prodCode, item.prodName, item.prodUnit, item.prodAmou);
					});
					popRetVal = selectedArr;
					// 填入明细项
					doMultiSelectCallBack();
					$("#LoadProcess").hide();
				} else {
					$("#LoadProcess").hide();
					ShowAlert('系统错误：' + status, {title:'提示框'});
				}
			}

			function doUpload() {
				var storehouseId = document.getElementById("outBill.storehouseId").value;
				//if(storehouseId=="" || storehouseId=="0"){
				//	ShowAlert('提示框','请选择仓库',200,100);
				//}else{
					var url = "storehouse/OutBillUploadForm.html?storehouse_id=" + storehouseId;
				ShowIframe(['560px','300px'], url, '', function(){
					doUploadCallBack();
				}, '导入Excel');
				//}
			}

			function doUploadCallBack() {
				if(popRetVal) {
					document.getElementById("LoadProcess").style.top = getTopPos(document.getElementById("uplo_link")) + 50 + "px";
					document.getElementById("LoadProcess").style.left = getleftPos(document.getElementById("uplo_link")) + 100 + "px";
					document.getElementById("LoadProcess").style.display = "";

					var fileName = popRetVal;
					$.post("/storehouse/ImportOutBillItem.html", {
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
		<script>
			layui.use('laydate', function() {
				var laydate = layui.laydate;

				laydate.render({
					elem: '#outDateStr'
				});
			});
		</script>
	</body>
</html>