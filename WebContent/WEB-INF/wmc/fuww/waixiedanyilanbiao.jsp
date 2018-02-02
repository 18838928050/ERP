<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>外协单一览表</title>
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
	function doShow(id,examined){
		var editType="";
		if(examined=='Y'){
			editType="MODIFY";
		}
		var url="../cooper/CooperBillEdit.html?id="+id+"&edit_type="+editType;
		ShowIframe("外协单",url,1280,600,"refreshWin()");
	}
	function refreshWin(){
		if(popRetVal!=null){
			window.location="../cooper/CooperBillSearchResult.html?"+getSearchCondition()+"&current_page=0";
		}
	}
	function doPrint(id){
		showWin(900,600,"../cooper/CooperBillPrint.html?id="+id);
	}
	function createPageParaStr(){
		var str="start_date="+encodeURIComponent(document.getElementById("start_date").value);
		str=str+"&end_date="+encodeURIComponent(document.getElementById("end_date").value);
		
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
		str=str+"&creater_name="+encodeURIComponent(document.getElementById("creater_name").value);
		str=str+"&est_name="+encodeURIComponent(document.getElementById("est_name").value);
		str=str+"&bill_code="+encodeURIComponent(document.getElementById("bill_code").value);
		str=str+"&min_cost="+encodeURIComponent(document.getElementById("min_cost").value.trim());
		str=str+"&max_cost="+encodeURIComponent(document.getElementById("max_cost").value.trim());
		str=str+"&content="+encodeURIComponent(document.getElementById("content").value);
		str=str+"&ts_id="+document.getElementById("ts_id").value;
		str=str+"&order_by="+document.getElementById("order_by").value;
		str=str+"&order_sc="+document.getElementById("order_sc").value;
		
		return str;
	}
	
	function createProgramParaStr(){
		var str="start_date="+encodeURIComponent(document.getElementById("hid_start_date").value);
		str=str+"&end_date="+encodeURIComponent(document.getElementById("hid_end_date").value);
		str=str+"&examined=";
		str=str+"&gathered=";
		str=str+"&paied=";
		str=str+"&manager_name="+encodeURIComponent(document.getElementById("hid_manager_name").value);
		str=str+"&creater_name="+encodeURIComponent(document.getElementById("hid_creater_name").value);
		str=str+"&est_name="+encodeURIComponent(document.getElementById("hid_est_name").value);
		str=str+"&bill_code="+encodeURIComponent(document.getElementById("hid_bill_code").value);
		str=str+"&min_cost="+encodeURIComponent(document.getElementById("hid_min_cost").value);
		str=str+"&max_cost="+encodeURIComponent(document.getElementById("hid_max_cost").value);
		str=str+"&content="+encodeURIComponent(document.getElementById("hid_content").value);
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
				if(!checkDateStr(document.getElementById("start_date").value,"开始日期")){
					return;
				}
				if(!checkDateStr(document.getElementById("end_date").value,"结束日期")){
					return;
				}
				str=str+"&cb_cooper_date=1";
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
			if(document.getElementById("cb_cost").checked){
				var minCost=document.getElementById("min_cost").value.trim();
				if(minCost==null || minCost==""){
					ShowAlert('提示框','请输入最小金额',200,100);
					return;
				}else if(isNaN(minCost)){
					ShowAlert('提示框','最小金额只能是数字',200,100);
					return;
				}
				var maxCost=document.getElementById("max_cost").value.trim();
				if(maxCost==null || maxCost==""){
					ShowAlert('提示框','请输入最大金额',200,100);
					return;
				}else if(isNaN(maxCost)){
					ShowAlert('提示框','最大金额只能是数字',200,100);
					return;
				}
				str=str+"&cb_cost=1";
			}
			if(document.getElementById("cb_content").checked){
				var content=document.getElementById("content").value.trim();
				if(content==null || content==""){
					ShowAlert('提示框','请输入摘要',200,100);
					return;
				}
				str=str+"&cb_content=1";
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
		window.location="../cooper/CooperBillSearchResult.html?"+str;
	}
	function doGo(pageIndex){
		var str=getSearchCondition();
		str=str+"&current_page="+pageIndex;
		window.location="../cooper/CooperBillSearchResult.html?"+str;
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
		var ob_arr = document.getElementsByName("query_checkbox");
		var id="";
		var examined="";
		if(ob_arr.length>=it.getAttribute("index")){
			id=ob_arr[it.getAttribute("index")-1].value;
			examined=ob_arr[it.getAttribute("index")-1].getAttribute("examined");
		}
		if(id==""){
			return;
		}
		doShow(id,examined);
	}
	
	function doCancel(){
		window.close();
	}
	function doInit(){
		Window_Onload();
		if(window.screen.availWidth>1280){
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
		var cb="selectStafferNameCallBack('"+objId+"','"+checkObjId+"')";
		ShowIframe("选择员工",url,800,500,cb);
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
		window.location="../cooper/CooperBillSearchResult.html?content_type=EXCEL&"+str;
	}
	function showExaPage(id){
		var url="../cooper/CooperBillInfoForExamine.html?id="+id;
		ShowIframe("外协单审核",url,900,500,"refreshWin()");
	}
	function showUnExaPage(id){
		var url="../cooper/CooperBillInfoForUnExamine.html?id="+id;
		ShowIframe("外协单反审核",url,900,500,"refreshWin()");
	}
	function showGatPage(id){
		var url="../cooper/GatherBillNew.html?cooper_bill_id="+id;
		ShowIframe("外协单收货",url,1024,500,"refreshWin()");
	}
	function showGatSearchPage(bbCode){
		showWin(900,600,'../cooper/GatherBillSearchResult.html?search_type=1&cb_cb_code=1&cb_code='+encodeURIComponent(bbCode));
	}
	function showPayPage(id){
		var url="../finance/PayBillNew.html?data_type=COOPER&bill_id_str="+id;
		ShowIframe("外协单付款",url,1024,500,"refreshPrintWin('PAY')");
	}
	function refreshPrintWin(type){
		if(popRetVal!=null){
			var url="../cooper/CooperBillSearchResult.html?"+getSearchCondition()+"&current_page=0";
			if(popRetVal.indexOf(";")!=-1){
				var arr=popRetVal.split(";");
				if(arr[1]!=null && arr[1]=="Y"){
					url=url+"&print_id="+arr[0]+"&print_bill="+type;
					if(arr[2]!=null){
						url=url+"&print_detail="+arr[2];
					}
				}
			}
			window.location=url;
		}
	}
	function showAdjPage(id){
		var url="../finance/AdjustTypeSelect.html?bill_type=COOPER_BILL";
		ShowIframeNoScroll("选择调帐类型",url,240,230,"doAdjNew("+id+")");
	}
	function doAdjNew(id){
		if(popRetVal!=null){
			var url="../finance/AdjustBillNew.html?data_type=BILL&adjust_type="+popRetVal+"&bill_id_str="+id;
			ShowIframe("调帐单",url,1024,500,"refreshPrintWin('ADJ')");
		}
	}
	function doPrintCallBack(){
		var printId="";
		var printBill="";
		var printDetail="";
		if(printId!=null && printId!=""){
			if(printBill=="PAY"){
				showWin(900,600,"../finance/PayBillPrint.html?id="+printId+"&print_detail="+printDetail);
			}else if(printBill=="ADJ"){
				showWin(900,600,"../finance/AdjustBillPrint.html?id="+printId);
			}
		}
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
	function showList(type){
		var str="search_type=1&cb_ts=1&ts_id=DF_TS_ID";
		if(type=='CAN_EXAM'){
			str=str+"&cb_examine=1&examined=N";
		}else if(type=='CAN_GATH'){
			str=str+"&cb_examine=1&examined=Y&cb_gather=1&gathered=N";
		}else if(type=='UN_PAY'){
			str=str+"&cb_examine=1&examined=Y&cb_pay=1&paied=N";
		}else if(type=='ZERO_COST'){
			str=str+"&cb_cost=1&min_cost=0&max_cost=0";
		}else{
			return;
		}
		window.location="../cooper/CooperBillSearchResult.html?"+str;
	}
	function showRelBill(id,code){
		showWin(900,600,"../cooper/CooperRelBillList.html?id="+id+"&code="+code);
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
<div class="Wrap"><!-- 页面主框架 -->
    
	<div id="ListContainer" class="Container"><!-- 主体容器 -->
	    
	    <!-- 标题栏 -->
	    <div class="Heading BillIcon">
	        <div class="HeadingContent">
	            <h1>外协单一览表</h1>
	           <div class="pull-right">
							<div class="layui-form" style=" display: inline-block;">
								<input type="checkbox" name="cb_in_date" id="cb_in_date" title="入库日期" checked="true" lay-skin="primary">

								<div class="layui-inline">
									<div class="layui-input-inline" style="width: 85px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_in_date');" id="start_date" name="start_date" value="2017-11-01">
										<input type="hidden" id="hid_start_date" value="2017-11-01">
									</div>
								</div>
								<div class="layui-inline">
									<div class="layui-form-mid">至</div>
									<div class="layui-input-inline" style="width: 85px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_in_date');" id="end_date" name="end_date" value="2017-11-24">
										<input type="hidden" id="hid_end_date" value="2017-11-24">
									</div>
								</div>
								<a type="button " class="layui-btn " href="javascript:;" id="lnkMoreOption">更多查询选项</a>
								<a type="button " class="layui-btn " onclick="doSearch();">查 询</a>
								<a type="button " class="layui-btn " id="sDownloadButton" name="sDownloadButton" onclick="doDownload();">导 出</a>
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
						<tbody><tr>
							<th class="c1" width="80px">
			        			<input type="checkbox" name="cb_bill_code" id="cb_bill_code">
			        			外协单号
			        		</th>
			        		<td class="c1" width="260px">
			        			<input type="text" class="TextBox" maxlength="50" name="bill_code" id="bill_code" onfocus="doAutoCheck(&#39;cb_bill_code&#39;);" onkeyup="checkInput();" value="">
								<input type="hidden" id="hid_bill_code" value="">
			    			</td>
			    			<th class="c2" width="80px">
	                        	<input type="checkbox" name="cb_examine" id="cb_examine">
	                        	审核状态
	                        </th>
	                    	<td class="c2" width="280px">
	                        	<input type="radio" name="examined" id="examine1" onclick="doAutoCheck(&#39;cb_examine&#39;);" checked="true">已审核
	                        	<input type="radio" name="examined" id="examine2" onclick="doAutoCheck(&#39;cb_examine&#39;);">未审核
	                        	<input type="radio" name="examined" id="examine3" onclick="doAutoCheck(&#39;cb_examine&#39;);">全部
	                    	</td>
			    		</tr>
						<tr>
			    			<th class="c1">
			        			<input type="checkbox" name="cb_est" id="cb_est">
			        			外协单位
			        		</th>
			    			<td class="c1">
			        			<input type="text" class="TextBox" maxlength="50" name="est_name" id="est_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_est&#39;);" value="">
								<img class="imgIconButton" src="../images/make-a.gif" onclick="selectEstName();">
								<input type="hidden" id="hid_est_name" value="">
			    			</td>
	                    	<th class="c2">
	                        	<input type="checkbox" name="cb_gather" id="cb_gather">
	                        	收货状态
	                        </th>
	                    	<td class="c2">
	                        	<input type="radio" name="gather" id="gather1" onclick="doAutoCheck(&#39;cb_gather&#39;);" checked="true">已收完
								<input type="radio" name="gather" id="gather2" onclick="doAutoCheck(&#39;cb_gather&#39;);">未收完
								<input type="radio" name="gather" id="gather3" onclick="doAutoCheck(&#39;cb_gather&#39;);">未收货
								<input type="radio" name="gather" id="gather4" onclick="doAutoCheck(&#39;cb_gather&#39;);">全部
	                    	</td>
	                	</tr>
						<tr>
			    			<th class="c1">
			        			<input type="checkbox" name="cb_content" id="cb_content">
			        			摘要
			        		</th>
			    			<td class="c1">
			        			<input type="text" class="TextBox" maxlength="50" name="content" id="content" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_content&#39;);" value="">
								<input type="hidden" id="hid_content" value="">
			    			</td>
	                    	<th class="c2">
	                        	<input type="checkbox" name="cb_pay" id="cb_pay">
	                        	付款状态
	                        </th>
	                    	<td class="c2">
	                        	<input type="radio" name="paied" id="paied1" onclick="doAutoCheck(&#39;cb_pay&#39;);">已付完
								<input type="radio" name="paied" id="paied2" onclick="doAutoCheck(&#39;cb_pay&#39;);">未付完
								<input type="radio" name="paied" id="paied3" onclick="doAutoCheck(&#39;cb_pay&#39;);" checked="true">全部
	                    	</td>
	                	</tr>
						<tr>
			    			<th class="c1">
			        			<input type="checkbox" name="cb_cost" id="cb_cost">
			        			金额
			        		</th>
			    			<td>
			        			<input type="text" class="TextBox Money" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_cost&#39;);" id="min_cost" name="min_cost" value="">
								至
								<input type="text" class="TextBox Money" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_cost&#39;);" id="max_cost" name="max_cost" value="">
								<input type="hidden" id="hid_min_cost" value="">
								<input type="hidden" id="hid_max_cost" value="">
			    			</td>
	                    	<th class="c2">
			        			<input type="checkbox" name="cb_manager" id="cb_manager">
			        			业务员
			        		</th>
			    			<td class="c3">
			    				<input type="text" class="TextBox" maxlength="15" name="manager_name" id="manager_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_manager&#39;);" value="">
								<img class="imgIconButton" src="../images/make-a.gif" onclick="selectStafferName(&#39;manager_name&#39;,&#39;cb_manager&#39;);">
			        			<input type="hidden" id="hid_manager_name" value="">
			    			</td>
	                	</tr>
						<tr>
			    			<th class="c1">
			        			<input type="checkbox" name="cb_ts" id="cb_ts" checked="true">
	                        	账套
			        		</th>
			    			<td class="c1">
			        			<select name="ts_id" id="ts_id" onfocus="doAutoCheck(&#39;cb_ts&#39;);">
				    				<option value="0">==请选择账套==</option>
				    				
									<option value="1">新异</option>
									<option value="2" selected="">网络公司</option>
								</select>
			        		</td>
			        		<th class="c2">
			        			<input type="checkbox" name="cb_creater" id="cb_creater">
			        			开单人
			        		</th>
			    			<td class="c3">
			        			<input type="text" class="TextBox" maxlength="15" name="creater_name" id="creater_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_creater&#39;);" value="">
								<img class="imgIconButton" src="../images/make-a.gif" onclick="selectStafferName(&#39;creater_name&#39;,&#39;cb_creater&#39;);">
								<input type="hidden" id="hid_creater_name" value="">
			    			</td>
	                	</tr>
					</tbody></table>
				
					<div class="OptionOrderBy">
	                	<input type="checkbox" name="cb_order" id="cb_order">
	                    	排序类型
	                    <select name="order_by" id="order_by" onfocus="doAutoCheck(&#39;cb_order&#39;);">
	                        <option value="">==请选择==</option>
					  		<option value="COOPER_DATE">外协日期</option>
					  		<option value="COST">金额</option>
					  		<option value="BILL_CODE">单号</option>
					  		<option value="CONTENT">摘要</option>
					  		<option value="EST_NAME">外协单位</option>
	                    </select>
	                    <select name="order_sc" id="order_sc" onfocus="doAutoCheck(&#39;cb_order&#39;);">
	                        <option value="ASC">升序</option>
	                        <option value="DESC">降序</option>
	                    </select>
	                    <span class="fr"><a href="javascript:;" id="lnkHiddenOption">隐藏查询选项</a></span>
	                </div>
				</div>
			</div>
			
			<!-- 提示信息显示栏 -->
	        <div class="MsgBar">
	            
<table width="98%" border="0" cellpadding="0" cellspacing="0">
	<tbody><tr id="errorMsgTr" style="display:none">
	  <td>
	  	<div class="msg-error" id="errorMsgTd">
	  	
	  	</div>
	  </td>
	</tr>
</tbody>
</table>
	       </div>


      		<div class="table-list">
        		<table width="100%">
		          	<tbody><tr>
					  	<th width="10%">单号
						</th><th width="7%">外协日期
						</th><th width="12%">外协单位
						</th><th width="14%">摘要
						</th><th width="7%">交货日期
						</th><th width="6%">金额
						</th><th width="6%">调账
						</th><th width="6%">已付
						</th><th width="6%">欠款
						</th><th width="5%">业务员
						</th><th width="5%">开单人
						</th><th width="8%">状态
						</th><th width="8%">操作
		          	</th></tr>
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
<td>欠款</td>
<td>${j }</td>
<td>${k }</td>
<td>
<s:if test='l.equals("Y")'><s:a action="">已审核</s:a></s:if>
<s:elseif test='l.equals("N")'><s:a action="">未审核</s:a></s:elseif>
<s:if test='m.equals("Y")'><s:a action="">已收货</s:a></s:if>
<s:elseif test='m.equals("N")'><s:a action="">未收货</s:a></s:elseif>
<s:if test='n.equals("Y")'><s:a action="">已结清</s:a></s:if>
<s:elseif test='n.equals("N")'><s:a action="">未结清</s:a></s:elseif>
</td>
<td>操作</td>
					
					</tr>
					
					</s:iterator>
		  		</tbody></table>  
      		</div>

      		<!-- 底栏 分页、操作等 -->
	         <div class="table-bot clearfix">
						<div class="pull-right">
							<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but001.gif"></a>
							<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but002.gif"></a>
							第
							<div class="layui-input-inline">
								<input class="layui-input" style="width:30px" placeholder="" type="text" maxlength="15" onkeydown="javascript:doJump(this.value);" id="confirmPassword" name="pageNumber" value="1">
							</div>
							页&nbsp;&nbsp;共1页
							<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but003.gif"></a>
							<a style="cursor:pointer" onclick=""><img src="${pageContext.request.contextPath }/images/but004.gif"></a>
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
		doPrintCallBack();
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
<script src="${pageContext.request.contextPath }/layui/layui.all.js"></script>
</body>
</html>