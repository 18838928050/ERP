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
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">

		<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
		<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
		<!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    	.layui-form-label {
    		padding-left: 0;
    		width: 70px;
    	}
    </style>
    
	</head>

	<body onload="showMe();" class="sheet modal-dialog">
		<div class="sheet-main" id="bodyDiv">
			<form class="layui-form" name="frm" action="MyComm_saveNewComm" method="post" enctype="multipart/form-data">
				<div class="sheet-list">
					<div class="modal-main search-business">
						<div style="width:100%;">

							<h3>新增日程</h3>
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
							<div class="blank24"></div>
							<div class="layui-row">
								<div class="layui-col-sm4">
									<div class="layui-form-item">
										<label class="layui-form-label"><span class="MustInput">*</span>主题：</label>
										<div class="layui-input-inline">
											<input class="layui-input" placeholder="" type="text" maxlength="50" id="communicate.title" onkeyup="goNextInput(&#39;communicate.content&#39;);" name="title" value="">
										</div>
										<script language="javascript">
											setFormErrorMsg('', 2, 'communicate.title');
										</script>
									</div>
								</div>
								<div class="layui-col-sm4">
									<div class="layui-form-item">
										<label class="layui-form-label" style="width: 50px;"><span class="MustInput">*</span>日期：</label>
										<div class="layui-input-inline" style="width: 85px;">
											<input type="text" class="layui-input" maxlength="15" id="communicateTimeStr" name="communicateTimeStr" value="2017-07-05">
										</div>
										<div class="layui-input-inline" style="width: 55px;">
											<select id="orderDateHourSelect" onchange="changeTimeSelect(this,&#39;communicateTimeHour&#39;);">
												<option value="00">00</option>
												<option value="01">01</option>
												<option value="02">02</option>
												<option value="03">03</option>
												<option value="04">04</option>
												<option value="05">05</option>
												<option value="06">06</option>
												<option value="07">07</option>
												<option value="08">08</option>
												<option value="09">09</option>
												<option value="10">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16" selected="">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="23">23</option>
											</select>
										</div>
										<div class="layui-input-inline" style="width: 55px;">
											<select id="orderDateMinuteSelect" onchange="changeTimeSelect(this,&#39;communicateTimeMinute&#39;);">
												<option value="00">00</option>
												<option value="01">01</option>
												<option value="02">02</option>
												<option value="03">03</option>
												<option value="04">04</option>
												<option value="05">05</option>
												<option value="06">06</option>
												<option value="07">07</option>
												<option value="08">08</option>
												<option value="09">09</option>
												<option value="10" selected="">10</option>
												<option value="11">11</option>
												<option value="12">12</option>
												<option value="13">13</option>
												<option value="14">14</option>
												<option value="15">15</option>
												<option value="16">16</option>
												<option value="17">17</option>
												<option value="18">18</option>
												<option value="19">19</option>
												<option value="20">20</option>
												<option value="21">21</option>
												<option value="22">22</option>
												<option value="23">23</option>
												<option value="24">24</option>
												<option value="25">25</option>
												<option value="26">26</option>
												<option value="27">27</option>
												<option value="28">28</option>
												<option value="29">29</option>
												<option value="30">30</option>
												<option value="31">31</option>
												<option value="32">32</option>
												<option value="33">33</option>
												<option value="34">34</option>
												<option value="35">35</option>
												<option value="36">36</option>
												<option value="37">37</option>
												<option value="38">38</option>
												<option value="39">39</option>
												<option value="40">40</option>
												<option value="41">41</option>
												<option value="42">42</option>
												<option value="43">43</option>
												<option value="44">44</option>
												<option value="45">45</option>
												<option value="46">46</option>
												<option value="47">47</option>
												<option value="48">48</option>
												<option value="49">49</option>
												<option value="50">50</option>
												<option value="51">51</option>
												<option value="52">52</option>
												<option value="53">53</option>
												<option value="54">54</option>
												<option value="55">55</option>
												<option value="56">56</option>
												<option value="57">57</option>
												<option value="58">58</option>
												<option value="59">59</option>
											</select>
										</div>
										<script language="javascript">
											setFormErrorMsg('', 3, 'communicateTimeStr');
										</script>
									</div>
								</div>
								<div class="layui-col-sm4">
									<div class="layui-form-item">
										<label class="layui-form-label" style="width: 50px;">客户：</label>
										<div class="layui-input-inline">
											<input class="layui-input" placeholder="" readonly type="text" id="estName" name="estName" value="">
										</div>
										<label class="layui-form-mid"><a href="javascript:selectEst();">选择</a></label>
									</div>
									<input type="hidden" id="communicate.estId" name="estId" value="757">
									<script language="javascript">
										setFormErrorMsg('', 4);
									</script>
								</div>
							</div>
							<div class="layui-form-item layui-form-text">
								<label class="layui-form-label"><span class="MustInput">*</span>内容：</label>
								<div class="layui-input-inline">
									<textarea style="width: 600px;" placeholder="" id="communicate.content" name="content" class="layui-textarea"></textarea>
								</div>
								<script language="javascript">
									setFormErrorMsg('', 5, 'communicate.content');
								</script>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">附件：</label>
								<div class="layui-input-inline">
									<input type="file" name="attach_file" id="attach_file">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label"><span class="MustInput">*</span>类型：</label>
								<div class="layui-input-inline">
									<span onclick="changeCommType();">
									<input type="radio" name="commType" id="commType1" value="0" title="日志" checked="">
									</span>
									<span onclick="changeCommType();">
									<input type="radio" name="commType" id="commType2" value="1" title="任务">
									</span>
									<input type="hidden" name="commType" id="communicate.commType" value="LOG">
								</div>
								<div class="layui-form-mid">
									<a id="extSpan" href="javascript:showExt();">展开更多内容</a>
								</div>
							</div>

							<div id="extTbl" style="display:none">

								<div class="layui-form-item">
									<label class="layui-form-label">上级任务：</label>
									<div class="layui-input-inline" style="width:300px">
										<input class="layui-input" placeholder="" readonly type="text" name="parentTitle" id="parentTitle" value="">
									</div>
								</div>
								<div class="layui-form-item" id="forAllTr" style="display:none">
									<label class="layui-form-label"><span class="MustInput">*</span>是否公开：</label>
									<div class="layui-input-inline" style="width:300px">
										<input type="radio" name="forAll" id="forAll1" onclick="changeForAll();" title="全员公开">
										<input type="radio" name="forAll" id="forAll2" onclick="changeForAll();" checked="" title="指定参与人">
									</div>
									<div class="layui-form-mid">
										<a href="javascript:showReceiver();">设置参与人员...</a>
									</div>
									<input type="hidden" name="forAll" id="communicate.forAll" value="N">
								</div>
								<div class="layui-form-item" id="smsRemindTr" style="display:none">
									<label class="layui-form-label"><span class="MustInput">*</span>定时提醒：</label>
									<div class="layui-input-inline" style="width:55px">
										<select lay-filter="communicate.smsRemind" name="smsRemind" id="communicate.smsRemind" onchange="changeSmsRemind();">
											<option value="Y">是</option>
											<option value="N" selected="">否</option>
										</select>
									</div>
									
									<div id="srDate" style="display: none;">
									
									<div class="layui-input-inline" style="width: 80px;">
										<input type="text" class="layui-input" maxlength="15" id="srDateStr" name="srDateStr" value="2017-07-05">
									</div>
									<div class="layui-input-inline" style="width:55px">
										<select lay-filter="srDateHourSelect" id="srDateHourSelect" onchange="changeTimeSelect(this,&#39;srDateHour&#39;);">

											<option value="00">00</option>
											<option value="01">01</option>
											<option value="02">02</option>
											<option value="03">03</option>
											<option value="04">04</option>
											<option value="05">05</option>
											<option value="06">06</option>
											<option value="07">07</option>
											<option value="08">08</option>
											<option value="09">09</option>
											<option value="10">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18" selected="">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
										</select>

									</div>
									<div class="layui-input-inline" style="width:55px">
										<select lay-filter="srDateMinuteSelect" id="srDateMinuteSelect" onchange="changeTimeSelect(this,&#39;srDateMinute&#39;);">
											<option value="00">00</option>
											<option value="01">01</option>
											<option value="02">02</option>
											<option value="03">03</option>
											<option value="04">04</option>
											<option value="05">05</option>
											<option value="06">06</option>
											<option value="07">07</option>
											<option value="08">08</option>
											<option value="09">09</option>
											<option value="10" selected="">10</option>
											<option value="11">11</option>
											<option value="12">12</option>
											<option value="13">13</option>
											<option value="14">14</option>
											<option value="15">15</option>
											<option value="16">16</option>
											<option value="17">17</option>
											<option value="18">18</option>
											<option value="19">19</option>
											<option value="20">20</option>
											<option value="21">21</option>
											<option value="22">22</option>
											<option value="23">23</option>
											<option value="24">24</option>
											<option value="25">25</option>
											<option value="26">26</option>
											<option value="27">27</option>
											<option value="28">28</option>
											<option value="29">29</option>
											<option value="30">30</option>
											<option value="31">31</option>
											<option value="32">32</option>
											<option value="33">33</option>
											<option value="34">34</option>
											<option value="35">35</option>
											<option value="36">36</option>
											<option value="37">37</option>
											<option value="38">38</option>
											<option value="39">39</option>
											<option value="40">40</option>
											<option value="41">41</option>
											<option value="42">42</option>
											<option value="43">43</option>
											<option value="44">44</option>
											<option value="45">45</option>
											<option value="46">46</option>
											<option value="47">47</option>
											<option value="48">48</option>
											<option value="49">49</option>
											<option value="50">50</option>
											<option value="51">51</option>
											<option value="52">52</option>
											<option value="53">53</option>
											<option value="54">54</option>
											<option value="55">55</option>
											<option value="56">56</option>
											<option value="57">57</option>
											<option value="58">58</option>
											<option value="59">59</option>

										</select>

									</div>
									</div>
									<script language="javascript">
										setFormErrorMsg('', 6, 'srDateStr');
									</script>
									<div class="layui-form-mid">（发送消息提醒自己与参与人）</div>
									<input type="hidden" name="forAll" id="communicate.forAll" value="N">
								</div>
							</div>

							<div class="layui-form-item">
								<label class="layui-form-label"></label>
								<label class="layui-form-mid">	
注：日志只能当天修改，过期只有系统管理员admin可删除；任务的修改删除不受限制</label>
							</div>

						</div>
					</div>
				</div>
				<div class="modal-buttom" id="buttonDiv">
					<input type="button" class="buttom-a" value=" 保 存 " onclick="doSave(&#39;&#39;);">

					<input type="button" class="buttom-a" value="保存并新增" onclick="doSave(&#39;1&#39;);">

					<input type="button" class="buttom-a" value=" 取 消 " onclick="doCancel();">
					<input type="hidden" name="continue_flag" id="continue_flag" value="0">

					<input type="hidden" id="communicateTimeHour" name="communicateTimeHour" value="17">
					<input type="hidden" id="communicateTimeMinute" name="communicateTimeMinute" value="00">
					<input type="hidden" id="srDateHour" name="srDateHour" value="18">
					<input type="hidden" id="srDateMinute" name="srDateMinute" value="00">
					<input type="hidden" id="tmpCode" name="tmpCode" value="25_1499245222861">

					<input type="hidden" id="communicateTimeHour" name="communicateTimeHour" value="16">
					<input type="hidden" id="communicateTimeMinute" name="communicateTimeMinute" value="10">
					<input type="hidden" id="srDateHour" name="srDateHour" value="17">
					<input type="hidden" id="srDateMinute" name="srDateMinute" value="10">
					<input type="hidden" id="tmpCode" name="tmpCode" value="1_1499328651427">
				</div>
				<div class="modal-buttom" id="waitDiv" style="display:none">
					<span style="color:#ffffff">请稍候...</span>
				</div>

			</form>
		</div>

		<audio controls="controls" style="display: none;"></audio>

		<script src="js/minierp.js"></script>
		<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
		<script src="js/popup.js"></script>
		<script src="js/dhtmlgoodies_calendar.js"></script>
		<script src="layui/layui.all.js "></script>

		<script language="javascript">
			function doSave(contFlag) {
				document.getElementById("buttonDiv").style.display = "none";
				document.getElementById("waitDiv").style.display = "";
				document.getElementById("continue_flag").value = contFlag;
				frm.submit();
			}

			function doReply(parentId) {
				window.location = "EstablishmentCommunicateNew.html?parent_id=" + parentId;
			}

			function doCancel() {
				parent.layer.closeAll();
			}

			function showMe() {
				if(checkNavigator()[0] != "msie" && parent.document.getElementById("dialogBox")) {
					document.getElementById("attach_file").className = "";
				}
				showFormErrorMsg();
				var childrenNum = 0;
				if(childrenNum > 0) {
					document.getElementById("childrenDiv").style.display = "";
				}
				document.getElementById("communicate.title").focus();
			}

			function changeTimeSelect(obj, targetName) {
				document.getElementById(targetName).value = obj.value;
			}

			function selectCommunicater() {
				var url = "./StafferMainForSelect.html";
				ShowIframe(['800px','500px'], url, '', function(){
					selectCommunicaterCallBack();
				}, '选择员工');
			}

			function selectCommunicaterCallBack() {
				if(popRetVal != null) {
					var arr = popRetVal.split(";");
					document.getElementById("communicate.communicaterName").value = arr[1];
				}
			}

			function selectEst() {
				var url = "./EstablishmentListForSelect.html?type=CLIENT";
				ShowIframe(['900px','500px'], url, '', function(){
					selectEstCallBack();
				}, '选择客户');
			}

			function selectEstCallBack() {
				if(popRetVal != null) {
					document.getElementById("communicate.estId").value = popRetVal[0];
					document.getElementById("estName").value = popRetVal[1];
				}
			}

			function changeCommType() {
				if(document.getElementById("commType1").checked) {
					document.getElementById("communicate.commType").value = "LOG";
					document.getElementById("forAllTr").style.display = "none";
					document.getElementById("smsRemindTr").style.display = "none";
				} else {
					document.getElementById("communicate.commType").value = "PLAN";
					document.getElementById("forAllTr").style.display = "";
					document.getElementById("smsRemindTr").style.display = "";
				}
			}

			function changeForAll() {
				if(document.getElementById("forAll1").checked) {
					document.getElementById("communicate.forAll").value = "Y";
				} else {
					document.getElementById("communicate.forAll").value = "N";
				}
			}

			function changeSmsRemind() {
				if(document.getElementById("communicate.smsRemind").value == "Y") {
					document.getElementById("srDateStr").disabled = false;
					document.getElementById("srDateHourSelect").disabled = false;
					document.getElementById("srDateMinuteSelect").disabled = false;
				} else {
					document.getElementById("srDateStr").disabled = true;
					document.getElementById("srDateHourSelect").disabled = true;
					document.getElementById("srDateMinuteSelect").disabled = true;
				}
			}

			function showReceiver() {

				if(document.getElementById("forAll2").checked) {
					var url = "./EstCommReceiverList.html";
					url = url + "?tmp_code=1_1499328651427";

					ShowIframe(['350px','400px'], url, '', '','参与人员');
				}

			}

			function doDelete(id) {
				ShowConfirm('确定删除吗？', {title:'确认框'}, function(){
					doDelAct(id);
				});
			}

			function doDelAct(id) {
				if(popRetVal != null) {
					window.location = "./EstablishmentCommunicateDelete.html?id=" + id;
				}
			}

			function doComplete(id) {
				var url = "./EstCommCompForm.html?id=" + id;
				ShowIframe(['600px','300px'], url, '', function(){
					doCompCallback();
				}, '完成情况');
			}

			function doCompCallback() {
				if(popRetVal != null) {
					window.location.reload(true);
				}
			}

			function doSms(commId) {
				var content = "07-05 17:00 ";
				var content = "07-06 16:10 ";
				var url = "/sms/SmsSendForm.html?comm_id=" + commId + "&content=" + encodeURIComponent(content);
				showWin(['900px','500px'], url);
			}

			function showExt() {
				if(document.getElementById("extTbl").style.display == "none") {
					document.getElementById("extTbl").style.display = "";
					document.getElementById("extSpan").innerHTML = "隐藏更多内容";
				} else {
					document.getElementById("extTbl").style.display = "none";
					document.getElementById("extSpan").innerHTML = "展开更多内容";
				}
			}
		</script>
		<script>
			layui.use('laydate', function() {
				var laydate = layui.laydate;

				//常规用法
				laydate.render({
					elem: '#communicateTimeStr'
				});
				laydate.render({
					elem: '#srDateStr'
				});
				
			});
			layui.use('form', function() {
				var form = layui.form;
				
				form.on('select(communicate.smsRemind)', function(data){
//				  console.log(data.elem); //得到select原始DOM对象
//				  console.log(data.value); //得到被选中的值
//				  console.log(data.othis); //得到美化后的DOM对象


				  if(data.value == "Y") {
				  	document.getElementById("srDate").style.display = '';
//				  	document.getElementById("srDateStr").disabled = false;
//					document.getElementById("srDateHourSelect").disabled = false;
//					document.getElementById("srDateMinuteSelect").disabled = false;
				  } else {
				  	document.getElementById("srDate").style.display = 'none';
				  	
//				  	document.getElementById("srDateStr").disabled = true;
//					document.getElementById("srDateHourSelect").disabled = true;
//					document.getElementById("srDateMinuteSelect").disabled = true;
//					formRender();
				  }
				}); 
			});
			
		</script>
	</body>

</html>