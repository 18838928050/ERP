<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0066)http://115.28.87.22:8888/business/DeliverBillItemSearchResult.html -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
			<meta http-equiv="Expires" content="0">
				<title>送货明细一览表 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title> <script
					src="js/minierp.js"></script>
				<%@ page language="java" contentType="text/html; charset=UTF-8"
					pageEncoding="UTF-8"%>
				<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
				<%@ taglib prefix="s" uri="/struts-tags"%>
				<link href="css/Query.css" rel="stylesheet" type="text/css">
					<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet"
						type="text/css">
						<link rel="stylesheet" type="text/css" href="css/BillList.css">
							<script src="js/QueryList.js"></script>
							<script src="js/popup_ext.js"></script>
							<script src="js/dhtmlgoodies_calendar.js"></script>
							<script language="javascript">
	function createPageParaStr(){
		var str="start_date="+encodeURIComponent(document.getElementById("start_date").value);
		str=str+"&end_date="+encodeURIComponent(document.getElementById("end_date").value);
		
		var exam="A";
		if(document.getElementById("examine1").checked){
			exam="Y";
		}else if(document.getElementById("examine2").checked){
			exam="N";
		}
		str=str+"&exam="+exam;
		str=str+"&bill_code="+encodeURIComponent(document.getElementById("bill_code").value);
		str=str+"&mt_id="+document.getElementById("mt_id").value;
		str=str+"&bb_code="+encodeURIComponent(document.getElementById("bb_code").value);
		str=str+"&cont="+encodeURIComponent(document.getElementById("cont").value);
		str=str+"&fc="+encodeURIComponent(document.getElementById("fc").value);
		str=str+"&prod="+encodeURIComponent(document.getElementById("prod").value);
		str=str+"&est_name="+encodeURIComponent(document.getElementById("est_name").value);
		str=str+"&pm_id="+document.getElementById("pm_id").value;
		str=str+"&ts_id="+document.getElementById("ts_id").value;
		str=str+"&order_by="+document.getElementById("order_by").value;
		str=str+"&order_sc="+document.getElementById("order_sc").value;
		return str;
	}
	
	function createProgramParaStr(){
		var str="start_date="+encodeURIComponent(document.getElementById("hid_start_date").value);
		str=str+"&end_date="+encodeURIComponent(document.getElementById("hid_end_date").value);
		str=str+"&exam=";
		str=str+"&bill_code="+encodeURIComponent(document.getElementById("hid_bill_code").value);
		str=str+"&mt_id=";
		str=str+"&bb_code="+encodeURIComponent(document.getElementById("hid_bb_code").value);
		str=str+"&cont="+encodeURIComponent(document.getElementById("hid_cont").value);
		str=str+"&fc="+encodeURIComponent(document.getElementById("hid_fc").value);
		str=str+"&prod="+encodeURIComponent(document.getElementById("hid_prod").value);
		str=str+"&est_name="+encodeURIComponent(document.getElementById("hid_est_name").value);
		str=str+"&pm_id=";
		str=str+"&ts_id=1";
		str=str+"&order_by=";
		str=str+"&order_sc=";
		return str;
	}

	function doSearch(){
		var str;
		if(IsAdvSearch){//高级
			str="search_type=1";
			if(document.getElementById("cb_deli_date").checked){
				if(!checkDateStr(document.getElementById("start_date").value,"开始日期")){
					return;
				}
				if(!checkDateStr(document.getElementById("end_date").value,"结束日期")){
					return;
				}
				str=str+"&cb_deli_date=1";
			}
			if(document.getElementById("cb_exam").checked){
				str=str+"&cb_exam=1";
			}
			if(document.getElementById("cb_bill_code").checked){
				var billCode=document.getElementById("bill_code").value.trim();
				if(billCode==null || billCode==""){
					ShowAlert('提示框','请输入送货单号',200,100);
					return;
				}
				str=str+"&cb_bill_code=1";
			}
			if(document.getElementById("cb_mt").checked){
				var mtId=document.getElementById("mt_id").value;
				if(mtId==null || mtId=="" || mtId=="0"){
					ShowAlert('提示框','请选择项目类型',200,100);
					return;
				}
				str=str+"&cb_mt=1";
			}
			if(document.getElementById("cb_bb_code").checked){
				var bbCode=document.getElementById("bb_code").value.trim();
				if(bbCode==null || bbCode==""){
					ShowAlert('提示框','请输入业务单号',200,100);
					return;
				}
				str=str+"&cb_bb_code=1";
			}
			if(document.getElementById("cb_cont").checked){
				var cont=document.getElementById("cont").value.trim();
				if(cont==null || cont==""){
					ShowAlert('提示框','请输入摘要',200,100);
					return;
				}
				str=str+"&cb_cont=1";
			}
			if(document.getElementById("cb_fc").checked){
				var fc=document.getElementById("fc").value.trim();
				if(fc==null || fc==""){
					ShowAlert('提示框','请输入内容',200,100);
					return;
				}
				str=str+"&cb_fc=1";
			}
			if(document.getElementById("cb_prod").checked){
			   //var prod=document.getElementById("prod").value.trim();
			   //if(prod==null || prod==""){
			   //   ShowAlert('提示框','请输入材质',200,100);
			   //   return;
			   //}
			   str=str+"&cb_prod=1";
			}
			if(document.getElementById("cb_est").checked){
				var estName=document.getElementById("est_name").value;
				if(estName==null || estName==""){
					ShowAlert('提示框','请输入订货单位',200,100);
					return;
				}
				str=str+"&cb_est=1";
			}
			if(document.getElementById("cb_pm").checked){
				var pmId=document.getElementById("pm_id").value;
				if(pmId==null || pmId=="" || pmId=="0"){
					ShowAlert('提示框','请选择付款方式',200,100);
					return;
				}
				str=str+"&cb_pm=1";
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
			if(!checkDateStr(document.getElementById("start_date").value,"开始日期")){
				return;
			}
			if(!checkDateStr(document.getElementById("end_date").value,"结束日期")){
				return;
			}
		}
		var paraStr=createPageParaStr();
		if(paraStr!=""){
			str=str+"&"+paraStr;
		}
		window.location="business/DeliverBillItemSearchResult.html?"+str;
	}
	function doGo(pageIndex){
		var str=getSearchCondition();
		str=str+"&current_page="+pageIndex;
		window.location="business/DeliverBillItemSearchResult.html?"+str;
	}
	function getSearchCondition(){
		var searchType="1";
		var str="search_type="+searchType;
		if(searchType=="1"){//高级
			str=str+"&cb_deli_date=1";
			
			
			
			
			
			
			
			
			
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
	function DoubleClick(id){
	}
	function refreshWin(){
		if(popRetVal!=null){
			window.location.reload(true);
		}
	}
	
	function doDownload(){
		var str=getSearchCondition();
		window.location="business/DeliverBillItemSearchResult.html?content_type=EXCEL&"+str;
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
		doAutoCheck("cb_order_date");
	}
	function selectEstName(){
		var url="base/EstablishmentListForSelect.html?type=CLIENT";
		ShowIframe("选择客户",url,900,500,"selectEstNameCallBack()");
	}
	function selectEstNameCallBack(){
		if(popRetVal!=null){
			document.getElementById("est_name").value=popRetVal[1];
			doAutoCheck("cb_est");
		}
	}
	function printBusi(id){
		showWin(900,600,"business/BusinessBillPrint.html?id="+id);
	}
</script>
</head>
<body oncontextmenu="return false">
	<div class="Wrap">
		<!-- 页面主框架 -->

		<div id="ListContainer" class="Container" style="width: 1501px;">
			<!-- 主体容器 -->

			<!-- 标题栏 -->
			<div class="Heading BillIcon">
				<div class="HeadingContent">
					<h1>送货明细一览表</h1>
					<span class="Note">查询送货的详细清单，<span style="color: black">黑色</span>表示未审核、<span
						style="color: blue">蓝色</span>表示已审核
					</span>
				</div>
			</div>

			<!-- 主内容 -->
			<div class="Content">
				<!-- 筛选控件栏 -->
				<div class="FilterBar ClearFix">
					<div class="SearchIcon"></div>
					<span class="fl">
						<table class="MoreOption" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<th class="c1" width="80px"><input type="checkbox"
										name="cb_deli_date" id="cb_deli_date" checked="true"
										style="visibility: hidden;"> 送货日期 </th>
									<td width="360px"><input type="text"
										class="TextBox Datetime" maxlength="15"
										onkeyup="checkInput();"
										onfocus="doAutoCheck(&#39;cb_deli_date&#39;);" id="start_date"
										name="start_date" value="2017-07-01"> <img
											src="images/calendar.gif" class="imgIconButton"
											onclick="displayCalendar(document.getElementById(&#39;start_date&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_deli_date\&#39;)&#39;);">
												<input type="hidden" id="hid_start_date" value="2017-07-01">
													至 <input type="text" class="TextBox Datetime"
													maxlength="15" onkeyup="checkInput();"
													onfocus="doAutoCheck(&#39;cb_deli_date&#39;);"
													id="end_date" name="end_date" value="2017-07-05"> <img
														src="images/calendar.gif" class="imgIconButton"
														onclick="displayCalendar(document.getElementById(&#39;end_date&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_deli_date\&#39;)&#39;);">
															<input type="hidden" id="hid_end_date" value="2017-07-05">
																<a href="javascript:setDate(&#39;CURRENT_MONTH&#39;);">本月</a>
																<a href="javascript:setDate(&#39;TODAY&#39;);">今天</a> <a
																href="javascript:setDate(&#39;YESTERDAY&#39;);">昨天</a> <a
																href="javascript:setDate(&#39;PREVIEW_MONTH&#39;);">上月</a></td>
								</tr>
							</tbody>
						</table>
					</span> <span class="fr"> <a href="javascript:;" id="lnkMoreOption">更多查询选项</a>
						<input type="button" value=" 查 询" onclick="doSearch();"
						class="buttom search-but" id="sSearchButton" name="sSearchButton">
							<input type="button" value=" 导 出" onclick="doDownload();"
							class="buttom search-out" id="sDownloadButton"
							name="sDownloadButton"></span>
					<div id="dvMoreOptionBox" class="MoreOptionBox"
						style="display: none;">
						<table class="MoreOption" cellpadding="0" cellspacing="0">
							<tbody>
								<tr>
									<th class="c1" width="80px"><input type="checkbox"
										name="cb_bill_code" id="cb_bill_code"> 送货单号 </th>
									<td class="c1" width="260px"><input type="text"
										class="TextBox" maxlength="50" name="bill_code" id="bill_code"
										onfocus="doAutoCheck(&#39;cb_bill_code&#39;);"
										onkeyup="checkInput();" value=""> <input type="hidden"
											id="hid_bill_code" value=""></td>
									<th class="c2" width="80px"><input type="checkbox"
										name="cb_exam" id="cb_exam"> 审核状态 </th>
									<td class="c2" width="280px"><input type="radio"
										name="examined" id="examine1"
										onclick="doAutoCheck(&#39;cb_exam&#39;);" checked="true">已审核
											<input type="radio" name="examined" id="examine2"
											onclick="doAutoCheck(&#39;cb_exam&#39;);">未审核 <input
												type="radio" name="examined" id="examine3"
												onclick="doAutoCheck(&#39;cb_exam&#39;);">全部 </td>
								</tr>
								<tr>
									<th class="c1"><input type="checkbox" name="cb_bb_code"
										id="cb_bb_code"> 业务单号 </th>
									<td class="c1"><input type="text" class="TextBox"
										maxlength="50" name="bb_code" id="bb_code"
										onkeyup="checkInput();"
										onfocus="doAutoCheck(&#39;cb_bb_code&#39;);" value="">
											<input type="hidden" id="hid_bb_code" value=""></td>
									<th class="c2"><input type="checkbox" name="cb_mt"
										id="cb_mt"> 项目类型 </th>
									<td class="c3"><select name="mt_id" id="mt_id"
										onfocus="doAutoCheck(&#39;cb_mt&#39;);">
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
									</select></td>
								</tr>
								<tr>
									<th class="c1"><input type="checkbox" name="cb_cont"
										id="cb_cont"> 摘要 </th>
									<td class="c1"><input type="text" class="TextBox"
										maxlength="50" name="cont" id="cont" onkeyup="checkInput();"
										onfocus="doAutoCheck(&#39;cb_cont&#39;);" value=""> <input
											type="hidden" id="hid_cont" value=""></td>
									<th class="c2"><input type="checkbox" name="cb_fc"
										id="cb_fc"> 内容 </th>
									<td class="c3"><input type="text" class="TextBox"
										maxlength="50" name="fc" id="fc" onkeyup="checkInput();"
										onfocus="doAutoCheck(&#39;cb_fc&#39;);" value=""> <input
											type="hidden" id="hid_fc" value=""></td>
								</tr>
								<tr>
									<th class="c1"><input type="checkbox" name="cb_est"
										id="cb_est"> 订货单位 </th>
									<td class="c1"><input type="text" class="TextBox"
										maxlength="50" name="est_name" id="est_name"
										onkeyup="checkInput();"
										onfocus="doAutoCheck(&#39;cb_est&#39;);" value=""> <img
											class="imgIconButton" src="images/make-a.gif"
											onclick="selectEstName();"> <input type="hidden"
												id="hid_est_name" value=""></td>
									<th class="c2"><input type="checkbox" name="cb_prod"
										id="cb_prod"> 材质 </th>
									<td class="c3"><input type="text" class="TextBox"
										maxlength="50" name="prod" id="prod" onkeyup="checkInput();"
										onfocus="doAutoCheck(&#39;cb_prod&#39;);" value=""> <input
											type="hidden" id="hid_prod" value=""></td>
								</tr>
								<tr>
									<th class="c1"><input type="checkbox" name="cb_ts"
										id="cb_ts" checked="true"> 账套 </th>
									<td class="c1"><select name="ts_id" id="ts_id"
										onfocus="doAutoCheck(&#39;cb_ts&#39;);">
											<option value="0">==请选择账套==</option>

											<option value="1" selected="">新异</option>
											<option value="2">网络公司</option>
									</select></td>
									<th class="c2"><input type="checkbox" name="cb_pm"
										id="cb_pm"> 付款方式 </th>
									<td class="c3"><select name="pm_id" id="pm_id"
										onfocus="doAutoCheck(&#39;cb_pm&#39;);">
											<option value="0">==请选择付款方式==</option>

											<option value="1">现结</option>
											<option value="2">月结</option>
											<option value="3">季结</option>
											<option value="4">公户转帐</option>
											<option value="5">支付宝转帐</option>
											<option value="6">银行转帐</option>
											<option value="7">物流代收</option>
											<option value="8">微信转帐</option>
											<option value="9">取货付款</option>
									</select></td>
								</tr>
							</tbody>
						</table>
						<div class="OptionOrderBy">
							<input type="checkbox" name="cb_order" id="cb_order">
								排序类型 <select name="order_by" id="order_by"
								onfocus="doAutoCheck(&#39;cb_order&#39;);">
									<option value="">==请选择==</option> option value="DELIVER_DATE"
									&gt;送货日期
									<option value="BILL_CODE">送货单号</option>
									<option value="BB_CODE">业务单号</option>
									<option value="EST_NAME">订货单位</option>
							</select> <select name="order_sc" id="order_sc"
								onfocus="doAutoCheck(&#39;cb_order&#39;);">
									<option value="ASC">升序</option>
									<option value="DESC">降序</option>
							</select> <span class="fr"><a href="javascript:;"
									id="lnkHiddenOption">隐藏查询选项</a></span>
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

				<div class="table-list">
					<table style="width: 1470px;">
						<tbody>
							<tr>
								<th style="width: 70px;">送货日期</th>
								<th style="width: 110px;">送货单号</th>
								<th style="width: 120px;">摘要</th>
								<th style="width: 80px;">项目类型</th>
								<th style="width: 120px;">内容</th>
								<th style="width: 100px;">材质</th>
								<th style="width: 130px;">规格</th>
								<th style="width: 50px;">单位</th>
								<th style="width: 70px;">数量</th>
								<th style="width: 70px;">单价</th>
								<th style="width: 100px;">金额</th>
								<th style="width: 130px;">订货单位</th>
								<th style="width: 80px;">付款方式</th>
								<th style="width: 60px;">业务员</th>
								<th style="width: 110px;">业务单号</th>
							</tr>
							<s:iterator value="deliverVTOs" var="deliverVTO" status="st">
									<tr class="query_list_data_trSelected"
										style="color: blue; cursor: pointer;" defaultfontcolor="blue"
										index="1" onclick="javascript:ClickCheck(this)"
										ondblclick="javascript:DoubleClick(2106)"
										onmouseout="javascript:mouseout(this)"
										onmouseover="javascript:mouseover(this)">
										<td><input type="radio" name="query_checkbox"
											value="2106" style="display: none"> <s:date
													name="deliverDate"
													format="yyyy-MM-dd" /></td>
										<td>${deliverVTO.billCode}</td>
										<td>${deliverVTO.content}</td>
										<td>${deliverVTO.typeName }</td>
										<td>${deliverVTO.finishedContent }</td>
										<td>${deliverVTO.proName }</td>
										<td>${deliverVTO.specification }</td>
										<td>&nbsp;${deliverVTO.unit }</td>
										<td>${deliverVTO.amount }</td>
										<td>${deliverVTO.unitPrice }</td>
										<td>${deliverVTO.cost }</td>
										<td>${deliverVTO.address }</td>
										<td>${deliverVTO.modeName }</td>
										<td>${deliverVTO.createrName }</td>
										<td><a href="javascript:printBusi(3205);">${deliverVTO.billCodeB }</a></td>
									</tr>
							</s:iterator>
						</tbody>
					</table>
				</div>

				<!-- 底栏 分页、操作等 -->
				<div class="BottomToolBar ClearFix">

					<div class="table-bot">



						<img src="images/but001.gif"> <img src="images/but002.gif">

								第 <input type="text" name="pageNumber" style="width: 30px"
								value="1" onkeydown="javascript:doJump(this.value);"
								class="TextBox"> 页 共3页 <a style="cursor: pointer"
									onclick="javascript:doGo(&quot;2&quot;);"><img
										src="images/but003.gif"></a> <a style="cursor: pointer"
									onclick="javascript:doGo(&quot;3&quot;);"><img
										src="images/but004.gif"></a>
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
	        document.getElementById('cb_deli_date').style.visibility = 'visible';
	        this.style.visibility = 'hidden';
	    };
	    lnkHiddenOption.onclick = function(){
	    	IsAdvSearch = false;
	        document.getElementById('dvMoreOptionBox').style.display = 'none';
	        document.getElementById('cb_deli_date').style.visibility = 'hidden';
	        lnkMoreOption.style.visibility = 'visible';
	    };
	})();
</script>
</body>
</html>