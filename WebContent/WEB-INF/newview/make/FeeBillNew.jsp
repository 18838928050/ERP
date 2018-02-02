<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0064)http://115.28.87.22:8888/finance/FeeBillNew.html?alert_type=SHOW -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>费用单 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/BillEdit.css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script src="js/popup.js"></script>
		<script src="js/dhtmlgoodies_calendar.js"></script>
		<script language="javascript">
			function doSave(contFlag) {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				document.getElementById("continue_flag").value = contFlag;

				ShowConfirm('是否同时审核？', {title:'确认框'}, function(index){
					popRetVal = "Y";
					layer.close(index);
					doSaveExt(contFlag);
				});

			}

			function doSaveExt(contFlag) {
				if(popRetVal != null) {
					document.getElementById("examine").value = "1";
				} else {
					document.getElementById("examine").value = "0";
				}

				if(contFlag != 'NEW' && contFlag != 'COPY') {
					ShowConfirm('是否现在打印？', {title:'确认框'}, function(index){
						popRetVal = 'Y';
						layer.close(index);
						doSavePrint();
					});
				} else {
					frm.submit();
				}

			}

			function doSavePrint() {
				if(popRetVal != null) {
					document.getElementById("print_flag").value = "1";
				}
				frm.submit();
			}

			function doCancel() {
				if(window.opener) {
					window.close();
				} else {
					var retVal = "";
					if(retVal != "") {
						parent.popRetVal = retVal;
					}
					ClosePop();
				}
			}

			function selectStaffer() {
				var url = "base/StafferMainForSelect.html";
				ShowIframe(['910px','500px'], url, '', function(){
					selectStafferCallBack();
				}, '选择员工');
			}

			function selectStafferCallBack() {
				if(popRetVal != null) {
					var arr = popRetVal.split(";");
					document.getElementById("feeBill.managerId").value = arr[0];
					document.getElementById("feeBill.managerName").value = arr[1];
					var depObj = document.getElementById("feeBill.departmentId");
					for(var i = 0; i < depObj.options.length; i++) {
						if(arr[2] == depObj.options[i].value) {
							depObj.options[i].selected = true;
							break;
						}
					}
				}
			}

			function bbButtOnClick() {
				selectBusinessBill(this.getAttribute("index"));
			}

			function selectBusinessBill(index) {
				var url = "make/BusinessBillListForSelect.html?search_type=FEE&ts_id=1";
				ShowIframe(['900px','500px'], url, '', function(){
					selectBusinessBillCallBack(index);
				}, '选择业务单');
			}

			function selectBusinessBillCallBack(index) {
				if(popRetVal != null) {
					document.getElementById("bb_id_" + index).value = popRetVal[0];
					document.getElementById("bb_code_" + index).value = popRetVal[1];
					checkItemChange(index);
				}
			}

			function bbDelOnClick() {
				clearBusinessBill(this.getAttribute("index"));
			}

			function bbPriOnClick() {
				printBusi(this.getAttribute("index"));
			}

			function clearBusinessBill(index) {
				document.getElementById("bb_id_" + index).value = "0";
				document.getElementById("bb_code_" + index).value = "";
				checkItemChange(index);
			}

			function showMe() {
				document.getElementById("feeBill.receiverName").focus();
				showFormErrorMsg();
			}

			function doPrint(id) {
				showWin(['900px','370px'], "finance/FeeBillPrint.html?id=" + id);
			}

			function doWinUnload() {
				var retVal = '';
				if(retVal != '' && !window.opener) {
					parent.popRetVal = retVal;
				}
			}

			function elementOnChnage() {
				checkItemChange(this.getAttribute("index"), this.id);
			}

			function ftButtOnClick() {
				selectFeeType(this.getAttribute("index"));
			}

			function selectFeeType(index) {
				var url = "base/FeeTypeListForSelect.html";
				ShowIframe(['300px','400px'], url, '', function(){
					selectFeeTypeCallBack(index);
				}, '选择费用类型');
			}

			function selectFeeTypeCallBack(index) {
				if(popRetVal != null) {
					document.getElementById("ft_id_" + index).value = popRetVal[0];
					document.getElementById("ft_name_" + index).value = popRetVal[1];
					document.getElementById("cost_" + index).focus();
					checkItemChange(index);
				}
			}

			function checkItemChange(index) {
				if(document.getElementById("id_" + index).value == "" || document.getElementById("id_" + index).value == "0") {
					document.getElementById("status_" + index).value = "NEW";
				} else {
					document.getElementById("status_" + index).value = "EDIT";
				}

				doCount();
			}

			function doCount() {
				var itemNum = document.getElementById("item_num").value - 0;
				var itemCost;
				var costTotal = 0;
				for(var i = 0; i < itemNum; i++) {
					if(document.getElementById("status_" + i).value != "DELETE") {
						if(document.getElementById("cost_" + i) != null) {
							itemCost = document.getElementById("cost_" + i).value;
							if(!isNaN(itemCost)) {
								costTotal = addMul(costTotal, itemCost);
							}
						}
					}
				}
				document.getElementById("feeBill.cost").value = costTotal;
			}

			function doItemDelete(index) {
				ShowConfirm('确定删除吗？', {title:'确认框'}, function(layer_index){
					popRetVal = 'Y';
					layer.close(layer_index);
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
				input.style.width = "130px";
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "ft_name_" + itemNum);
				input.setAttribute("id", "ft_name_" + itemNum);
				input.setAttribute("readOnly", true);
				input.setAttribute("className", "layui-input readonly");
				input.setAttribute("class", "layui-input readonly");
				td.appendChild(input);
				tr.appendChild(td);

				td.appendChild(document.createTextNode(" "));
				input = document.createElement("img");
				input.setAttribute("src", "images/icon_add.gif");
				input.setAttribute("index", itemNum);
				input.style.cursor = "pointer";
				input.onclick = ftButtOnClick;
				td.appendChild(input);

				input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "ft_id_" + itemNum);
				input.setAttribute("id", "ft_id_" + itemNum);
				input.setAttribute("value", "0");
				td.appendChild(input);

				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.cssText = "text-align:right";
				input.style.width = "100px";
				input.setAttribute("maxLength", "10");
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "cost_" + itemNum);
				input.setAttribute("id", "cost_" + itemNum);
				input.setAttribute("value", "");
				input.setAttribute("className", "layui-input");
				input.setAttribute("class", "layui-input");
				input.onchange = elementOnChnage;
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.width = "310px";
				input.setAttribute("maxLength", "50");
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "mark_" + itemNum);
				input.setAttribute("id", "mark_" + itemNum);
				input.setAttribute("value", "");
				input.setAttribute("className", "layui-input");
				input.setAttribute("class", "layui-input");
				input.onchange = elementOnChnage;
				td.appendChild(input);
				tr.appendChild(td);

				td = document.createElement("td");
				input = document.createElement("input");
				input.setAttribute("type", "text");
				input.style.width = "130px";
				input.setAttribute("index", itemNum);
				input.setAttribute("name", "bb_code_" + itemNum);
				input.setAttribute("id", "bb_code_" + itemNum);
				input.setAttribute("readOnly", true);
				input.setAttribute("className", "layui-input readonly");
				input.setAttribute("class", "layui-input readonly");
				td.appendChild(input);
				tr.appendChild(td);

				td.appendChild(document.createTextNode(" "));
				input = document.createElement("img");
				input.setAttribute("src", "images/icon_add.gif");
				input.setAttribute("index", itemNum);
				input.style.cursor = "pointer";
				input.onclick = bbButtOnClick;
				td.appendChild(input);

				td.appendChild(document.createTextNode(" "));

				input = document.createElement("img");
				input.setAttribute("src", "images/icon_del.gif");
				input.setAttribute("index", itemNum);
				input.style.cursor = "pointer";
				input.onclick = bbDelOnClick;
				td.appendChild(input);

				td.appendChild(document.createTextNode(" "));

				input = document.createElement("img");
				input.setAttribute("src", "images/ico-bar.gif");
				input.setAttribute("index", itemNum);
				input.style.cursor = "pointer";
				input.onclick = bbPriOnClick;
				td.appendChild(input);

				input = document.createElement("input");
				input.setAttribute("type", "hidden");
				input.setAttribute("name", "bb_id_" + itemNum);
				input.setAttribute("id", "bb_id_" + itemNum);
				input.setAttribute("value", "0");
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

				selectFeeType(itemNum); //当前行的index

				resizePopwin();
			}

			function printBusi(index) {
				var id = document.getElementById("bb_id_" + index).value;
				if(id != null && id != "" && id != "0") {
					showWin(['900px','600px'], "business/BusinessBillPrint.html?id=" + id);
				}
			}
		</script>
		<style>
			.BillDetails .layui-input {
				display: inline!important;
			}
		</style>
	</head>

	<body onload="showMe();" onunload="doWinUnload();">
		<div>
			<form name="frm" method="post" enctype="multipart/form-data">
				<div class="Container">
					<div class="Contnet Paper">

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

						<div class="BillHeading">
							<div class="layui-row">
								<div class="layui-col-sm4">
									<div class="CorpLogo"><img src="images/BIAO  SHI  HUI.png"></div>
								</div>
								<div class="layui-col-sm4">
									<h1>费用单</h1>
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
											<input type="text" class="layui-input disabled readonly" readonly="readonly" maxlength="30" onkeyup="goNextInput(&#39;feeDateStr&#39;);" id="feeBill.billCode" name="feeBill.billCode" value="">
											<script language="javascript">
												setFormErrorMsg('', 1, 'feeBill.billCode');
											</script>
										</div>
									</div>
									<div class="layui-form-item" style="display: inline-block;">
										<label class="layui-form-label"><span class="MustInput">*</span>日期：</label>
										<div class="layui-input-inline" style="width: 85px;">
											<input type="text" class="layui-input" maxlength="15" onkeyup="goNextInput(&#39;feeBill.receiverName&#39;);" id="feeDateStr" name="feeDateStr" value="2017-07-09">
											<script language="javascript">
												setFormErrorMsg('', 2, 'feeDateStr');
											</script>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="blank12"></div>
						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<label class="layui-form-label" style="width: 60px;">收款单位：</label>
									<div class="layui-input-inline" style="width: 120px;">
										<input class="layui-input" type="text" maxlength="50" onkeyup="goNextInput(&#39;costStr&#39;);" id="feeBill.receiverName" name="feeBill.receiverName" value="">

										<script language="javascript">
											setFormErrorMsg('', 3, 'feeBill.receiverName');
										</script>
									</div>
								</div>
							</div>
							<div class="layui-col-sm4 tc layui-form">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 70px;"><span class="MustInput">*</span>付款账户：</label>
									<div class="layui-input-inline" style="text-align: left;">
										<select id="feeBill.bankAccountId" name="feeBill.bankAccountId" class="ddlInfo_sim">

											<option value="10">建行(秦朝阳)</option>

											<option value="12">黄秀娟(长通物流(6116))</option>

											<option value="9">工行(黄秀娟)</option>

											<option value="8">交行(秦朝阳)</option>

											<option value="13">黄秀娟(创新物流(5165))</option>

											<option value="14">黄秀娟(豫鑫物流（73035）)</option>

											<option value="4">农行(黄秀娟)</option>

											<option value="15">黄秀娟(微信15225099188)</option>

											<option value="11">中行(秦朝阳)</option>

											<option value="7"> 浦发(公司一般户)</option>

											<option value="2">中行(公司基本户)</option>

											<option value="1">现金(会计)</option>

											<option value="5">浦发(POS机刷卡)</option>

											<option value="6">淘宝 黄秀娟(支付宝 15225099188)</option>

											<option value="16">浦发(黄秀娟)</option>

											<option value="17">秦朝阳(微信13608675408)</option>

										</select>
										<script language="javascript">
											setFormErrorMsg('', 4);
										</script>
									</div>
								</div>
							</div>
							<div class="layui-col-sm4 tr">
								<div class="layui-form-item" style="display: inline-block;">
									<label class="layui-form-label" style="width: 70px;"><span class="MustInput">*</span>付款金额：</label>
									<div class="layui-input-inline" style="width: 140px; text-align: center;">
										<input type="text" class="layui-input readonly" readonly="readonly" name="feeBill.cost" id="feeBill.cost" value="0">
									</div>
								</div>
							</div>
						</div>

						<!-- 明细 -->
						<input type="hidden" id="item_num" name="item_num" value="1">
						<table id="BillDetails" class="BillDetails" width="100%" cellspacing="0" cellpadding="0">
							<tbody id="itemRowTbl">
				<tr>
					<th width="20%">费用类型</th>
					<th width="14%">金额(元)</th>
					<th width="36%">备注</th>
					<th width="24%">业务单号</th>
					<th width="6%">操作</th>
				</tr>
				
				<tr id="itemTr0">
					<td>
						<input type="text" class="layui-input readonly" readonly="readonly" style="width:130px" id="ft_name_0" name="ft_name_0" value="">
						<img src="images/icon_add.gif" style="cursor:pointer;" onclick="selectFeeType(0);">
						<input type="hidden" id="ft_id_0" name="ft_id_0" value="0">
					</td>
					<td>
						<input class="layui-input" type="text" style="width:100px;text-align:right;" maxlength="10" id="cost_0" name="cost_0" value="0" onchange="checkItemChange(0,this.id);">
					</td>
					<td>
						<input type="text" class="layui-input" style="width:310px" maxlength="50" id="mark_0" name="mark_0" value="" onchange="checkItemChange(0,this.id);">
					</td>
					<td>
						<input type="text" class="layui-input readonly" readonly="readonly" style="width:130px" id="bb_code_0" name="bb_code_0" value="E(2)2017120003">
						<img src="images/icon_add.gif" style="cursor:pointer;" onclick="selectBusinessBill(0);">
						<img src="images/icon_del.gif" style="cursor:pointer;" onclick="clearBusinessBill(0);">
						<img src="images/ico-bar.gif" style="cursor:pointer;" onclick="printBusi(0);">
						<input type="hidden" id="bb_id_0" name="bb_id_0" value="4466">
					</td>
					<td>
						<a href="javascript:doItemDelete(0);">删除</a>
						<input type="hidden" id="status_0" name="status_0" value="NEW">
						<input type="hidden" id="id_0" name="id_0" value="0">
					</td>
				</tr>
				
				</tbody>
						</table>
						<div class="table-bot" style="margin-top:4px">
							<a href="javascript:doItemAdd();">增加费用明细</a>
							<span style="color:#aaa">（点击这里添加费用明细项目）</span>
						</div>

						<script language="javascript">
							setFormErrorMsg('', 5);
						</script>

						<hr />

						<div class="layui-row">
							<div class="layui-col-sm4">
								<div class="layui-form-item">
									<label class="layui-form-label" style="width: 70px;"><span class="MustInput">*</span>经办人：</label>
									<div class="layui-input-inline" style="width: 140px;">
										<input class="layui-input readonly" type="text" id="feeBill.managerName" name="feeBill.managerName" value="标识汇">
										<input type="hidden" id="feeBill.managerId" name="feeBill.managerId" value="65">
									</div>
									<div class="layui-form-mid">
										<a href="javascript:selectStaffer();">选择</a>
									</div>
									<script language="javascript">
										setFormErrorMsg('', 6);
									</script>
								</div>
							</div>
							<div class="layui-col-sm4 layui-form">
								<div class="layui-form-item">
									<label class="layui-form-label" style="width: 70px;"><span class="MustInput">*</span>部门：</label>
									<div class="layui-input-block" style="margin-left: 100px;">
										<select id="feeBill.departmentId" name="feeBill.departmentId" class="ddlInfo_sim" style="background:#f6f6f6;">
											<option value="0">==请选择==</option>

											<option value="1">易凯管理员</option>
											<option value="13">总经办</option>
											<option value="22">&nbsp;|--财务</option>
											<option value="14">新异店</option>
											<option value="15">&nbsp;|--客服</option>
											<option value="23">&nbsp;|--设计</option>
											<option value="24">&nbsp;|--业务</option>
											<option value="16">业务来源</option>
											<option value="17">标识加工车间</option>
											<option value="21">合作伙伴</option>
											<option value="32" selected="">标识汇运营部</option>
											<option value="33">财务部</option>
										</select>
										<script language="javascript">
											setFormErrorMsg('', 7);
										</script>
									</div>
								</div>
							</div>
						</div>

						<div class="layui-form-item">
							<label class="layui-form-label" style="width: 70px;">摘要：</label>
							<div class="layui-input-block" style="margin-left: 100px;">
								<textarea class="layui-textarea" name="feeBill.mark" id="feeBill.mark" style="min-height: 40px;"></textarea>
								<script language="javascript">
									setFormErrorMsg('', 8, 'feeBill.mark');
								</script>
							</div>
						</div>

						<div class="layui-row">
							<div class="layui-col-sm8">
								<div class="layui-form-item">
									<label class="layui-form-label" style="width: 70px;">上传凭证：</label>
									<div class="layui-input-inline" style="width:410px;">
										<div style="position:relative;  height:28px; overflow:hidden; float:left;">
											<input type="text" class="layui-input readonly" readonly="readonly" style="width:410px;" name="tmp_att" id="tmp_att">
										</div>

									</div>
									<div class="layui-form-mid">
										<div style="position:relative;width:40px;height:28px;overflow:hidden;float:left;">
											<div style="position:absolute;top:0px;left:0px;width:100%;height:100%;">
												<a href="javascript:;">选择</a>
											</div>
											<input type="file" name="attach_file" id="attach_file" onchange="document.getElementById(&#39;tmp_att&#39;).value=this.value" style="position:absolute;top:0px;right:0px;cursor:pointer;opacity:0;filter:alpha(opacity:0);z-index:99;">
										</div>
									</div>
									<script language="javascript">
										setFormErrorMsg('', 12);
									</script>
								</div>

							</div>
						</div>

						<div class="BillNotes">
							<span>开单人：标识汇 </span>
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

							<input type="button" class="buttom-a" value=" 保 存 " onclick="doSave(&#39;&#39;);">

							<input type="button" class="buttom-a" value="保存并新增" onclick="doSave(&#39;NEW&#39;);">
							<input type="button" class="buttom-a" value="保存并复制" onclick="doSave(&#39;COPY&#39;);">

							<input type="button" class="buttom-a" value=" 取 消 " onclick="doCancel();">
							<input type="hidden" name="continue_flag" id="continue_flag" value="">
							<input type="hidden" id="examine" name="examine" value="0">
							<input type="hidden" name="print_flag" id="print_flag" value="">
						</div>
						<div id="waitDiv" style="display:none">
							<span>请稍候...</span>
						</div>
					</div>

				</div>
			</form>
		</div>
		<script src="layui/layui.all.js"></script>
		<script>
			layui.use('laydate', function() {
				var laydate = layui.laydate;

				//执行一个laydate实例
				laydate.render({
					elem: '#feeDateStr' //指定元素
				});
			});
		</script>
	</body>

</html>