<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<!-- path="${pageContext.request.contextPath }" -->
<meta http-equiv="Expires" content="0">
<title>外协明细一览表</title>
<link href="${pageContext.request.contextPath }/layui/css/layui.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/base.css">
<link href="${pageContext.request.contextPath }/css/Query.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/BillList.css">

<script src="${pageContext.request.contextPath }/js/minierp.js"></script>
<script src="${pageContext.request.contextPath }/js/QueryList.js"></script>
<script src="${pageContext.request.contextPath }/js/popup.js"></script>
<script src="${pageContext.request.contextPath }/js/dhtmlgoodies_calendar.js"></script>
<script language="javascript">
	function createPageParaStr(){
		var str="start_date="+encodeURIComponent(document.getElementById("start_date").value);
		str=str+"&end_date="+encodeURIComponent(document.getElementById("end_date").value);
		str=str+"&gath_start="+encodeURIComponent(document.getElementById("gath_start").value);
		str=str+"&gath_end="+encodeURIComponent(document.getElementById("gath_end").value);
		
		var examined="A";
		if(document.getElementById("examine1").checked){
			examined="Y";
		}else if(document.getElementById("examine2").checked){
			examined="N";
		}
		str=str+"&examined="+examined;
		
		var gathered="A";
		if(document.getElementById("gather1").checked){
			gathered="Y";
		}else if(document.getElementById("gather2").checked){
			gathered="P";
		}else if(document.getElementById("gather3").checked){
			gathered="N";
		}
		str=str+"&gathered="+gathered;
		
		var paied="A";
		if(document.getElementById("paied1").checked){
			paied="Y";
		}else if(document.getElementById("paied2").checked){
			paied="N";
		}
		str=str+"&paied="+paied;
		
		str=str+"&manager_name="+encodeURIComponent(document.getElementById("manager_name").value);
		str=str+"&lm="+encodeURIComponent(document.getElementById("lm").value);
		str=str+"&phon="+encodeURIComponent(document.getElementById("phon").value);
		str=str+"&prod="+encodeURIComponent(document.getElementById("prod").value);
		str=str+"&dep="+document.getElementById("dep").value;
		str=str+"&creater_name="+encodeURIComponent(document.getElementById("creater_name").value);
		str=str+"&est_name="+encodeURIComponent(document.getElementById("est_name").value);
		str=str+"&bill_code="+encodeURIComponent(document.getElementById("bill_code").value);
		str=str+"&coo_cont="+encodeURIComponent(document.getElementById("coo_cont").value);
		str=str+"&bb_code="+encodeURIComponent(document.getElementById("bb_code").value);
		str=str+"&make_type="+document.getElementById("make_type").value;
		str=str+"&content="+encodeURIComponent(document.getElementById("content").value);
		str=str+"&require="+encodeURIComponent(document.getElementById("require").value);
		str=str+"&ts_id="+document.getElementById("ts_id").value;
		str=str+"&order_by="+document.getElementById("order_by").value;
		str=str+"&order_sc="+document.getElementById("order_sc").value;
		
		return str;
	}
	
	function createProgramParaStr(){
		var str="start_date="+encodeURIComponent(document.getElementById("hid_start_date").value);
		str=str+"&end_date="+encodeURIComponent(document.getElementById("hid_end_date").value);
		str=str+"&gath_start="+encodeURIComponent(document.getElementById("hid_gath_start").value);
		str=str+"&gath_end="+encodeURIComponent(document.getElementById("hid_gath_end").value);
		str=str+"&examined=";
		str=str+"&gathered=";
		str=str+"&paied=";
		str=str+"&manager_name="+encodeURIComponent(document.getElementById("hid_manager_name").value);
		str=str+"&lm="+encodeURIComponent(document.getElementById("hid_lm").value);
		str=str+"&phon="+encodeURIComponent(document.getElementById("hid_phon").value);
		str=str+"&prod="+encodeURIComponent(document.getElementById("hid_prod").value);
		str=str+"&dep=";
		str=str+"&creater_name="+encodeURIComponent(document.getElementById("hid_creater_name").value);
		str=str+"&est_name="+encodeURIComponent(document.getElementById("hid_est_name").value);
		str=str+"&bill_code="+encodeURIComponent(document.getElementById("hid_bill_code").value);
		str=str+"&coo_cont="+encodeURIComponent(document.getElementById("hid_coo_cont").value);
		str=str+"&bb_code="+encodeURIComponent(document.getElementById("hid_bb_code").value);
		str=str+"&make_type=";
		str=str+"&content="+encodeURIComponent(document.getElementById("hid_content").value);
		str=str+"&require="+encodeURIComponent(document.getElementById("hid_require").value);
		str=str+"&ts_id=2";
		str=str+"&order_by=";
		str=str+"&order_sc=";
		
		return str;
	}
	function doSearch(){
		var str;
		if(IsAdvSearch){//高级
			str="search_type=1";
			if(document.getElementById("cb_cooper_date").checked){
				if(!checkDateStr(document.getElementById("start_date").value,"外协开始日期")){
					return;
				}
				if(!checkDateStr(document.getElementById("end_date").value,"外协结束日期")){
					return;
				}
				str=str+"&cb_cooper_date=1";
			}
			if(document.getElementById("cb_gath_date").checked){
				if(!checkDateStr(document.getElementById("gath_start").value,"交货开始日期")){
					return;
				}
				if(!checkDateStr(document.getElementById("gath_end").value,"交货结束日期")){
					return;
				}
				str=str+"&cb_gath_date=1";
			}
			if(document.getElementById("cb_examine").checked){
				str=str+"&cb_examine=1";
			}
			if(document.getElementById("cb_gather").checked){
				str=str+"&cb_gather=1";
			}
			
			if(document.getElementById("cb_pay").checked){
				str=str+"&cb_pay=1";
			}
			if(document.getElementById("cb_manager").checked){
				var managerName=document.getElementById("manager_name").value.trim();
				if(managerName==null || managerName==""){
					ShowAlert('提示框','请输入业务员姓名',200,100);
					return;
				}
				str=str+"&cb_manager=1";
			}
			if(document.getElementById("cb_lm").checked){
				var lm=document.getElementById("lm").value.trim();
				if(lm==null || lm==""){
					ShowAlert('提示框','请输入联系人',200,100);
					return;
				}
				str=str+"&cb_lm=1";
			}
			if(document.getElementById("cb_phon").checked){
				var phon=document.getElementById("phon").value.trim();
				if(phon==null || phon==""){
					ShowAlert('提示框','请输入电话',200,100);
					return;
				}
				str=str+"&cb_phon=1";
			}
			if(document.getElementById("cb_prod").checked){
				var prod=document.getElementById("prod").value.trim();
				if(prod==null || prod==""){
					ShowAlert('提示框','请输入材质',200,100);
					return;
				}
				str=str+"&cb_prod=1";
			}
			if(document.getElementById("cb_creater").checked){
				var createrName=document.getElementById("creater_name").value.trim();
				if(createrName==null || createrName==""){
					ShowAlert('提示框','请输入开单人姓名',200,100);
					return;
				}
				str=str+"&cb_creater=1";
			}
			if(document.getElementById("cb_est").checked){
				var estName=document.getElementById("est_name").value.trim();
				if(estName==null || estName==""){
					ShowAlert('提示框','请输入外协单位',200,100);
					return;
				}
				str=str+"&cb_est=1";
			}
			if(document.getElementById("cb_bill_code").checked){
				var billCode=document.getElementById("bill_code").value.trim();
				if(billCode==null || billCode==""){
					ShowAlert('提示框','请输入外协单号',200,100);
					return;
				}
				str=str+"&cb_bill_code=1";
			}
			if(document.getElementById("cb_coo_cont").checked){
				var cooCont=document.getElementById("coo_cont").value.trim();
				if(cooCont==null || cooCont==""){
					ShowAlert('提示框','请输入摘要',200,100);
					return;
				}
				str=str+"&cb_coo_cont=1";
			}
			if(document.getElementById("cb_bb_code").checked){
				var bbCode=document.getElementById("bb_code").value.trim();
				if(bbCode==null || bbCode==""){
					ShowAlert('提示框','请输入业务单号',200,100);
					return;
				}
				str=str+"&cb_bb_code=1";
			}
			if(document.getElementById("cb_make_type").checked){
				var makeType=document.getElementById("make_type").value;
				if(makeType==null || makeType=="" || makeType=="0"){
					ShowAlert('提示框','请选择项目类型',200,100);
					return;
				}
				str=str+"&cb_make_type=1";
			}
			if(document.getElementById("cb_dep").checked){
				var dep=document.getElementById("dep").value;
				if(dep==null || dep=="" || dep=="0"){
					ShowAlert('提示框','请选择部门',200,100);
					return;
				}
				str=str+"&cb_dep=1";
			}
			if(document.getElementById("cb_content").checked){
				var content=document.getElementById("content").value.trim();
				if(content==null || content==""){
					ShowAlert('提示框','请输入内容',200,100);
					return;
				}
				str=str+"&cb_content=1";
			}
			if(document.getElementById("cb_require").checked){
				var require=document.getElementById("require").value.trim();
				if(require==null || require==""){
					ShowAlert('提示框','请输入制作要求',200,100);
					return;
				}
				str=str+"&cb_require=1";
			}
			if(document.getElementById("cb_ts").checked){
				var tsId=document.getElementById("ts_id").value;
				if(tsId==null || tsId=="" || tsId=="0"){
					ShowAlert('提示框','请选择帐套',200,100);
					return;
				}
				str=str+"&cb_ts=1";
			}
			if(document.getElementById("cb_order").checked){
				var orderBy=document.getElementById("order_by").value;
				if(orderBy==null || orderBy==""){
					ShowAlert('提示框','请选择排序类型',200,100);
					return;
				}
				str=str+"&cb_order=1";
			}
		}else{//快速
			str="search_type=2";
			if(!checkDateStr(document.getElementById("start_date").value,"外协开始日期")){
				return;
			}
			if(!checkDateStr(document.getElementById("end_date").value,"外协结束日期")){
				return;
			}
		}
		var paraStr=createPageParaStr();
		if(paraStr!=""){
			str=str+"&"+paraStr;
		}
		window.location="../cooper/CooperBillItemSearchResult.html?"+str;
	}
	function doGo(pageIndex){
		var str=getSearchCondition();
		str=str+"&current_page="+pageIndex;
		window.location="../cooper/CooperBillItemSearchResult.html?"+str;
	}
	function getSearchCondition(){
		var searchType="1";
		var str="search_type="+searchType;
		if(searchType=="1"){//高级
			str=str+"&cb_cooper_date=1";	
			str=str+"&cb_ts=1";
			
		}else{//快速
			
		}
		var paraStr=createProgramParaStr();
		if(paraStr!=""){
			str=str+"&"+paraStr;
		}
		return str;
	}
	function doJump(pageIndex){
		if(window.event.keyCode==13){
			doGo(pageIndex);
		}
	}
	function DoubleClick(it){
		
	}
	function doCancel(){
		window.close();
	}
	function doInit(){
		Window_Onload();
		if(window.screen.availWidth>1024){
			var w=window.screen.availWidth*0.98;
			window.resizeTo(w,600);
			//居中
			var resizeWinTop=(window.screen.availHeight-600)/2;
			var resizeWinLeft=(window.screen.availWidth-w)/2;
			window.moveTo(resizeWinLeft,resizeWinTop);
		}
	}
	function checkInput(){
		if(window.event.keyCode==13){
			doSearch();
		}
	}
	function doAutoCheck(objId){
		document.getElementById(objId).checked=true;
	}
	function selectStafferName(objId,checkObjId){
		var url="../base/StafferMainForSelect.html";
		ShowIframe("选择员工",url,800,500,"selectStafferNameCallBack('"+objId+"','"+checkObjId+"')");
	}
	function selectStafferNameCallBack(objId,checkObjId){
		if(popRetVal!=null){
			var arr=popRetVal.split(";");
			document.getElementById(objId).value=arr[1];
			doAutoCheck(checkObjId);
		}
	}
	function doDownload(){
		var str=getSearchCondition();
		window.location="../cooper/CooperBillItemSearchResult.html?content_type=EXCEL&"+str;
	}
	function setDate(type){
		var d=new Date();
		var startStr="";
		var endStr="";
		if(type=="CURRENT_MONTH"){
			startStr=d.getFullYear()+"-"+(d.getMonth()+1)+"-01";
			endStr=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
		}else if(type=="PREVIEW_MONTH"){
			d=new Date(d.getFullYear(),d.getMonth(),1);
			d.setDate(d.getDate()-1);
			startStr=d.getFullYear()+"-"+(d.getMonth()+1)+"-1";
			endStr=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
		}else if(type=="TODAY"){
			startStr=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
			endStr=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
		}else if(type=="YESTERDAY"){
			d.setDate(d.getDate()-1);
			startStr=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
			endStr=d.getFullYear()+"-"+(d.getMonth()+1)+"-"+d.getDate();
		}
		document.getElementById("start_date").value=startStr;
		document.getElementById("end_date").value=endStr;
		doAutoCheck("cb_cooper_date");
	}
	function selectEstName(){
		var url="../base/EstablishmentListForSelect.html?type=COOPERATOR";
		ShowIframe("选择外协商",url,900,500,"selectEstNameCallBack()");
	}
	function selectEstNameCallBack(){
		if(popRetVal!=null){
			document.getElementById("est_name").value=popRetVal[1];
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
					<h1>外协明细一览表</h1>
					<div class="pull-right">
						<div class="layui-form" style="display: inline-block;">
							<input type="checkbox" name="cb_in_date" id="cb_in_date" title="入库日期" checked="true" lay-skin="primary">

							<div class="layui-inline">
								<div class="layui-input-inline" style="width: 85px;">
									<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_in_date');" id="start_date" name="start_date" value="2017-11-01"> <input type="hidden" id="hid_start_date" value="2017-11-01">
								</div>
							</div>
							<div class="layui-inline">
								<div class="layui-form-mid">至</div>
								<div class="layui-input-inline" style="width: 85px;">
									<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_in_date');" id="end_date" name="end_date" value="2017-11-24"> <input type="hidden" id="hid_end_date" value="2017-11-24">
								</div>
							</div>
							<a type="button " class="layui-btn " href="javascript:;" id="lnkMoreOption">更多查询选项</a> <a type="button " class="layui-btn " onclick="doSearch();">查 询</a> <a type="button " class="layui-btn " id="sDownloadButton" name="sDownloadButton" onclick="doDownload();">导 出</a>
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
									<th class="c1" width="80px"><input type="checkbox" name="cb_bb_code" id="cb_bb_code"> 业务单号</th>
									<td class="c1" width="260px"><input type="text" class="TextBox" maxlength="50" name="bb_code" id="bb_code" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_bb_code&#39;);" value=""> <input type="hidden" id="hid_bb_code" value=""></td>
									<th class="c2" width="80px"><input type="checkbox" name="cb_plan_date" id="cb_plan_date"> 计划完工</th>
									<td width="280px"><input type="text" class="TextBox Datetime" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_plan_date&#39;);" id="plan_start" name="plan_start" value=""> <img src="../images/calendar.gif" class="imgIconButton"
										onclick="displayCalendar(document.getElementById(&#39;plan_start&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_plan_date\&#39;)&#39;);"> <input type="hidden" id="hid_plan_start" value=""> 至 <input type="text" class="TextBox Datetime" maxlength="15"
										onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_plan_date&#39;);" id="plan_end" name="plan_end" value=""> <img src="../images/calendar.gif" class="imgIconButton"
										onclick="displayCalendar(document.getElementById(&#39;plan_end&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_plan_date\&#39;)&#39;);"> <input type="hidden" id="hid_plan_end" value=""></td>
								</tr>
								<tr>
									<th class="c1"><input type="checkbox" name="cb_est" id="cb_est"> 订货单位</th>
									<td class="c1"><input type="text" class="TextBox" maxlength="50" name="est_name" id="est_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_est&#39;);" value=""> <img class="imgIconButton" src="../images/make-a.gif" onclick="selectEstName();"> <input type="hidden"
										id="hid_est_name" value=""></td>
									<th class="c2"><input type="checkbox" name="cb_real_date" id="cb_real_date"> 实际完工</th>
									<td><input type="text" class="TextBox Datetime" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_real_date&#39;);" id="real_start" name="real_start" value=""> <img src="../images/calendar.gif" class="imgIconButton"
										onclick="displayCalendar(document.getElementById(&#39;real_start&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_real_date\&#39;)&#39;);"> <input type="hidden" id="hid_real_start" value=""> 至 <input type="text" class="TextBox Datetime" maxlength="15"
										onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_real_date&#39;);" id="real_end" name="real_end" value=""> <img src="../images/calendar.gif" class="imgIconButton"
										onclick="displayCalendar(document.getElementById(&#39;real_end&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_real_date\&#39;)&#39;);"> <input type="hidden" id="hid_real_end" value=""></td>
								</tr>
								<tr>
									<th class="c1"><input type="checkbox" name="cb_lm" id="cb_lm"> 联系人</th>
									<td class="c1"><input type="text" class="TextBox" maxlength="50" name="lm" id="lm" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_lm&#39;);" value=""> <input type="hidden" id="hid_lm" value=""></td>
									<th class="c2"><input type="checkbox" name="cb_exam" id="cb_exam"> 审核状态</th>
									<td class="c3"><input type="radio" name="exam" id="exam1" onclick="doAutoCheck(&#39;cb_exam&#39;);" checked="true">已审核 <input type="radio" name="exam" id="exam2" onclick="doAutoCheck(&#39;cb_exam&#39;);">未审核 <input type="radio" name="exam" id="exam3"
										onclick="doAutoCheck(&#39;cb_exam&#39;);">全部</td>
								</tr>
								<tr>
									<th class="c1"><input type="checkbox" name="cb_phon" id="cb_phon"> 电话</th>
									<td class="c1"><input type="text" class="TextBox" maxlength="50" name="phon" id="phon" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_phon&#39;);" value=""> <input type="hidden" id="hid_phon" value=""></td>
									<th class="c2"><input type="checkbox" name="cb_comp" id="cb_comp"> 完工状态</th>
									<td class="c3"><input type="radio" name="comp" id="comp1" onclick="doAutoCheck(&#39;cb_comp&#39;);" checked="true">已完工 <input type="radio" name="comp" id="comp2" onclick="doAutoCheck(&#39;cb_comp&#39;);">未完工 <input type="radio" name="comp" id="comp3"
										onclick="doAutoCheck(&#39;cb_comp&#39;);">全部</td>
								</tr>
								<tr>
									<th class="c1"><input type="checkbox" name="cb_cont" id="cb_cont"> 业务单摘要</th>
									<td class="c1"><input type="text" class="TextBox" maxlength="50" name="cont" id="cont" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_cont&#39;);" value=""> <input type="hidden" id="hid_cont" value=""></td>
									<th class="c2"><input type="checkbox" name="cb_setu" id="cb_setu"> 安装人员</th>
									<td class="c3"><input type="text" class="TextBox" maxlength="15" name="setu_name" id="setu_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_setu&#39;);" value=""> <img class="imgIconButton" src="../images/make-a.gif"
										onclick="selectStafferName(&#39;setu_name&#39;,&#39;cb_setu&#39;);"> <input type="hidden" id="hid_setu_name" value=""></td>
								</tr>
								<tr>
									<th class="c1"><input type="checkbox" name="cb_bill_code" id="cb_bill_code"> 安装单号</th>
									<td class="c1"><input type="text" class="TextBox" maxlength="50" name="bill_code" id="bill_code" onfocus="doAutoCheck(&#39;cb_bill_code&#39;);" onkeyup="checkInput();" value=""> <input type="hidden" id="hid_bill_code" value=""></td>
									<th class="c2"><input type="checkbox" name="cb_mng" id="cb_mng"> 安装负责人</th>
									<td class="c3"><input type="text" class="TextBox" maxlength="15" name="mng_name" id="mng_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_mng&#39;);" value=""> <img class="imgIconButton" src="../images/make-a.gif"
										onclick="selectStafferName(&#39;mng_name&#39;,&#39;cb_mng&#39;);"> <input type="hidden" id="hid_mng_name" value=""></td>
								</tr>
								<tr>
									<th class="c1"><input type="checkbox" name="cb_ts" id="cb_ts" checked="true"> 账套</th>
									<td class="c1"><select name="ts_id" id="ts_id" onfocus="doAutoCheck(&#39;cb_ts&#39;);">
											<option value="0">==请选择账套==</option>

											<option value="1" selected="">新异</option>
											<option value="2">网络公司</option>
									</select></td>
									<th class="c2"><input type="checkbox" name="cb_creater" id="cb_crea"> 开单人</th>
									<td class="c3"><input type="text" class="TextBox" maxlength="15" name="crea_name" id="crea_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_crea&#39;);" value=""> <img class="imgIconButton" src="${pageContext.request.contextPath }/images/make-a.gif"
										onclick="selectStafferName(&#39;crea_name&#39;,&#39;cb_crea&#39;);"> <input type="hidden" id="hid_crea_name" value=""></td>
								</tr>
							</tbody>
						</table>

						<div class="OptionOrderBy">
							<input type="checkbox" name="cb_order" id="cb_order"> 排序类型 <select name="order_by" id="order_by" onfocus="doAutoCheck(&#39;cb_order&#39;);">
								<option value="">==请选择==</option>
								<option value="BILL_DATE">派单日期</option>
								<option value="BILL_CODE">安装单号</option>
								<option value="BB_CODE">业务单号</option>
								<option value="EST_NAME">订货单位</option>
							</select> <select name="order_sc" id="order_sc" onfocus="doAutoCheck(&#39;cb_order&#39;);">
								<option value="ASC">升序</option>
								<option value="DESC">降序</option>
							</select> <span class="fr"><a href="javascript:;" id="lnkHiddenOption">隐藏查询选项</a></span>
						</div>
					</div>
				</div>

				<!-- 提示信息显示栏 -->
				<div class="MsgBar">

					<table width="98%" border="0" cellpadding="0" cellspacing="0">
						<tbody>
							<tr id="errorMsgTr" style="display: none">
								<td>
									<div class="msg-error" id="errorMsgTd"></div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div class="TopToolBar">
					<table class="ListNoteInfo" cellpadding="0" cellspacing="0">
						<tbody>
							<tr>
								<td>安装单数：0&nbsp;&nbsp;安装金额：0元</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="table-list">
					<table width="100%">
						<tbody>
							<tr>
								第 0 页 共0页
								<th >外协单号</th>
								<th >业务单号</th>
								<th >外协日期</th>
								<th >外协单位</th>
								<th >联系人</th>
								<th >摘要</th>
								<th >项目类型</th>
								<th >内容</th>
								<th >材质</th>
								<th >规格</th>
								<th >制作要求</th>
								<th >单位</th>
								<th >数量</th>
								<th >单价</th>
								<th >金额</th>
								<th >备注</th>
								<th >业务员</th>
								<th >开单人</th>
								<th >部门</th>
							</tr>
							<s:iterator value="list">
							<tr>
								<td>${ a}</td>
								<td>${ b}</td>
								<td>${ c}</td>
								<td>${ d}</td>
								<td>${b }</td>
								<td>${f }</td>
								<td>${g}</td>
								<td>${h }</td>
								<td>${i}</td>
								<td>${ j}</td>
								<td>${ k}</td>
								<td>${ l}</td>
								<td>${m }</td>
								<td>${n}</td>
								<td>${o}</td>
								<td>${p }</td>
								<td>${ q}</td>
								<td>${ r}</td>
								<td>${ s}</td>
</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>

				<!-- 底栏 分页、操作等 -->
				<div class="table-bot clearfix">
					<div class="pull-right">
						<a style="cursor: pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but001.gif"></a> <a style="cursor: pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but002.gif"></a> 第
						<div class="layui-input-inline">
							<input class="layui-input" style="width: 30px" placeholder="" type="text" maxlength="15" onkeydown="javascript:doJump(this.value);" id="confirmPassword" name="pageNumber" value="1">
						</div>
						页&nbsp;&nbsp;共1页 <a style="cursor: pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but003.gif"></a> <a style="cursor: pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but004.gif"></a>
					</div>
				</div>

			</div>
		</div>
	</div>


	<script type="text/javascript">
	function ChangeWindowSize( container, maxWidth ){
	    setTimeout( function(){
	        var w1 = document.documentElement.clientWidth-40;
	        if( w1>maxWidth ) w1 = maxWidth;
	        else if( w1<970 ) w1 = 960;
	        container.style.width = w1+'px';
	    }, 300 );
	}
	var IsAdvSearch = false;
	(function(){
		doInit();
	    var ListContainer = document.getElementById('ListContainer');
	    ChangeWindowSize( ListContainer, 2020 );    // 超过 1280 的最大 1260 ，不全部铺满
	
	    var lnkMoreOption   = document.getElementById('lnkMoreOption');
	    var lnkHiddenOption = document.getElementById('lnkHiddenOption');
	    lnkMoreOption.onclick = function(){
	    	IsAdvSearch = true;
	        document.getElementById('dvMoreOptionBox').style.display = 'block';
	        document.getElementById('cb_cooper_date').style.visibility = 'visible';
	        this.style.visibility = 'hidden';
	    };
	    lnkHiddenOption.onclick = function(){
	    	IsAdvSearch = false;
	        document.getElementById('dvMoreOptionBox').style.display = 'none';
	        document.getElementById('cb_cooper_date').style.visibility = 'hidden';
	        lnkMoreOption.style.visibility = 'visible';
	    };
	})();
</script>
	<script src="../layui/layui.all.js"></script>
</body>
</html>
