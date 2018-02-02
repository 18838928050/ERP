<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0063)http://115.28.87.22:8888cooper/BusinessBillListForCooComp.html -->
<html xmlns="http://www.w3.org/1999/xhtml"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="0">
<title>业务单外协完工 </title>
<link href="layui/css/layui.css" rel="stylesheet" />
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link href="css/Query.css" rel="stylesheet" type="text/css">
		<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" type="text/css" href="css/BillList.css">

		<script src="js/minierp.js"></script>
		<script src="js/QueryList.js"></script>
		<script src="js/popup.js"></script>
		<script src="js/dhtmlgoodies_calendar.js"></script>
<script language="javascript">
	function doJump(pageIndex){
		if(window.event.keyCode==13){
			doGo(pageIndex);
		}
	}
	function doCancel(){
		window.close();
	}
	function doInit(){
		//Window_Onload();
		document.getElementById("bill_code").focus();
	}
	function createPageParaStr(){
		var str="start_date="+encodeURIComponent(document.getElementById("start_date").value);
		str=str+"&end_date="+encodeURIComponent(document.getElementById("end_date").value);
		str=str+"&del_start="+encodeURIComponent(document.getElementById("del_start").value);
		str=str+"&del_end="+encodeURIComponent(document.getElementById("del_end").value);
		str=str+"&est_name="+encodeURIComponent(document.getElementById("est_name").value);
		str=str+"&bill_code="+encodeURIComponent(document.getElementById("bill_code").value);
		str=str+"&foll_name="+encodeURIComponent(document.getElementById("foll_name").value);
		str=str+"&ts_id="+document.getElementById("ts_id").value;
		str=str+"&order_by="+document.getElementById("order_by").value;
		str=str+"&order_sc="+document.getElementById("order_sc").value;
		
		return str;
	}
	
	function createProgramParaStr(){
		var str="start_date="+encodeURIComponent(document.getElementById("hid_start_date").value);
		str=str+"&end_date="+encodeURIComponent(document.getElementById("hid_end_date").value);
		str=str+"&del_start="+encodeURIComponent(document.getElementById("hid_del_start").value);
		str=str+"&del_end="+encodeURIComponent(document.getElementById("hid_del_end").value);
		str=str+"&est_name="+encodeURIComponent(document.getElementById("hid_est_name").value);
		str=str+"&bill_code="+encodeURIComponent(document.getElementById("hid_bill_code").value);
		str=str+"&foll_name="+encodeURIComponent(document.getElementById("hid_foll_name").value);
		str=str+"&ts_id=2";
		str=str+"&order_by=";
		str=str+"&order_sc=";
		
		return str;
	}
	function doSearch(){
		var str;
		if(IsAdvSearch){//高级
			str="search_type=1";
			if(document.getElementById("cb_bill_code").checked){
				var billCode=document.getElementById("bill_code").value.trim();
				if(billCode==null || billCode==""){
					ShowAlert('提示框','请输入业务单号',200,100);
					return;
				}
				str=str+"&cb_bill_code=1";
			}
			if(document.getElementById("cb_order_date").checked){
				if(!checkDateStr(document.getElementById("start_date").value,"订货开始日期")){
					return;
				}
				if(!checkDateStr(document.getElementById("end_date").value,"订货结束日期")){
					return;
				}
				str=str+"&cb_order_date=1";
			}
			if(document.getElementById("cb_del_date").checked){
				if(!checkDateStr(document.getElementById("del_start").value,"交货开始日期")){
					return;
				}
				if(!checkDateStr(document.getElementById("del_end").value,"交货结束日期")){
					return;
				}
				str=str+"&cb_del_date=1";
			}
			if(document.getElementById("cb_est").checked){
				var estName=document.getElementById("est_name").value.trim();
				if(estName==null || estName==""){
					ShowAlert('提示框','请输入订货单位',200,100);
					return;
				}
				str=str+"&cb_est=1";
			}
			if(document.getElementById("cb_foll").checked){
				var follName=document.getElementById("foll_name").value.trim();
				if(follName==null || follName==""){
					ShowAlert('提示框','请输入跟单员姓名',200,100);
					return;
				}
				str=str+"&cb_foll=1";
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
		}
		var paraStr=createPageParaStr();
		if(paraStr!=""){
			str=str+"&"+paraStr;
		}
		window.location="cooper/BusinessBillListForCooComp.html?"+str;
	}
	function doGo(pageIndex){
		var str=getSearchCondition();
		str=str+"&current_page="+pageIndex;

		window.location="cooper/BusinessBillListForCooComp.html?"+str;

	}
	function getSearchCondition(){
		var searchType="1";
		var str="search_type="+searchType;
		if(searchType=="1"){//高级
			
			
			
			
			
			str=str+"&cb_ts=1";
			
		}else{//快速
			
		}
		var paraStr=createProgramParaStr();
		if(paraStr!=""){
			str=str+"&"+paraStr;
		}
		return str;
	}
	function DoubleClick(it){
		var ob_arr = document.getElementsByName("query_checkbox");
		var id="";
		if(ob_arr.length>=it.getAttribute("index")){
			id=ob_arr[it.getAttribute("index")-1].value;
		}
		if(id==""){
			return;
		}
		doShow(id);
	}
	function doAutoCheck(objId){
		if(document.getElementById(objId).style.visibility!="hidden"){
			document.getElementById(objId).checked=true;
		}
	}
	function doShow(id){

		var url="cooper/BusinessBillInfoForCooComp.html?id="+id;

		ShowIframe("业务单外协完工",url,900,500,"refreshWin()",1024,600);
	}
	function refreshWin(){
		if(popRetVal!=null){
			window.location.reload(true);
		}
	}
	function selectStafferName(objId,checkObjId){
		var url="base/StafferMainForSelect.html";
		ShowIframe("选择员工",url,800,500,"selectStafferNameCallBack('"+objId+"','"+checkObjId+"')",1024,600);
	}
	function selectStafferNameCallBack(objId,checkObjId){
		if(popRetVal!=null){
			var arr=popRetVal.split(";");
			document.getElementById(objId).value=arr[1];
			doAutoCheck(checkObjId);
		}
	}
	function showSmsSubscribe(){
		
		showWin(520,640,'sms/SmsSubscribe.html');
		
		
	}
	function doComplete(idStr){
		ShowConfirm('确认框','确定将选择的业务单完工吗？',340,80,"doCompleteCallBack('"+idStr+"')");
	}
	function doCompleteCallBack(idStr){
		if(popRetVal!=null){

			var url="cooper/BusinessBillCooCompBatch.html?id_str="+idStr;

			ShowIframe("业务单完工",url,200,200,"refreshWin()");
		}
	}
	function doMutiComplete(){
		var ob_arr = document.getElementsByName("query_checkbox");
		var str="";
		for (i=0;i<ob_arr.length;i++){
			if ((ob_arr[i].checked == true)){
				if(str!=""){
					str=str+";";
				}
				str = str+ob_arr[i].value;
			}
		}
		if(str!=""){
			doComplete(str);
		}else{
			ShowAlert('提示框','请选择要完工的业务单',200,100);
		}
	}
	function showAccessories(id,billCode){
		var url="/make/AccessoryListAlone.html?acc_type=COOPER&agent_type=BUSINESS_BILL&agent_id="+id+"&mark="+encodeURIComponent("业务单："+billCode);
		showWin(900,600,url);
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
	}
	function checkInput(){
		if(window.event.keyCode==13){
			doSearch();
		}
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
	function doLabel(id){
		var url="business/BusinessBillInfoForLabel.html?id="+id+"&wc_id=0";
		showWin(900,600,url);
	}
</script>
</head>
<body oncontextmenu="return false">
<div class="Wrap"><!-- 页面主框架 -->
    
	<div id="ListContainer" class="Container">
		
	<!-- 主体容器 -->
	    
	    <!-- 标题栏 -->
	    <div class="Heading BillIcon">
	        <div class="HeadingContent">
	            <h1>业务单外协完工</h1>
	            
	            <div class="pull-right">
							<div class="layui-form" style=" display: inline-block;">
								<div class="layui-inline">
								<div class="layui-input-inline">
									<input type="text" class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();"placeholder="业务单号">
								</div>
							</div>
								<!--<input type="checkbox" name="cb_in_date" id="cb_in_date" title="入库日期" checked="true" lay-skin="primary">-->

								<!--<div class="layui-inline">
									<div class="layui-input-inline" style="width: 85px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_in_date');" id="start_date" name="start_date" value="2017-11-01">
										<input type="hidden" id="hid_start_date" value="2017-11-01">
									</div>
								</div>-->
								<!--<div class="layui-inline">
									<div class="layui-form-mid">至</div>
									<div class="layui-input-inline" style="width: 85px;">
										<input type="text" class="layui-input" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck('cb_in_date');" id="end_date" name="end_date" value="2017-11-24">
										<input type="hidden" id="hid_end_date" value="2017-11-24">
									</div>
								</div>-->
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
	            <!--<div class="SearchIcon"></div>-->
	            <span class="fl">
	            	<table class="MoreOption" cellpadding="0" cellspacing="0">
	            		<tbody>
	            	<tr>
	            		<!--<th class="c1" width="80px">
		            		<input type="checkbox" name="cb_bill_code" id="cb_bill_code" style="visibility:hidden;">
		            		业务单号
	            		</th>-->
	            		
	            		<td class="c1" width="260px">
	            			<a maxlength="50" name="bill_code" id="bill_code" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_bill_code&#39;);" value=""></a>
	            				
							<input type="hidden" id="hid_bill_code" value="">
	            		</td>
	            	</tr>
	            	</tbody>
	            </table>
	            </span>
				<!--<span class="fr">
	            	<a href="javascript:;" id="lnkMoreOption">更多查询选项</a>
		  			<input type="button" value=" 查 询" onclick="doSearch();" class="buttom search-but" id="sSearchButton" name="sSearchButton">
		  			<input type="button" class="buttom search-audit" value=" 完 工" onclick="doMutiComplete();" id="sCompleteButton" name="sCompleteButton">
	            </span>-->
				<div id="dvMoreOptionBox" class="MoreOptionBox" style="display:none;">
					<table class="MoreOption" cellpadding="0" cellspacing="0">
						<tbody><tr>
							
							
							<th class="c1" width="80px">
			        			<input type="checkbox" name="cb_order_date" id="cb_order_date">
			        			订货日期
			        		</th>
			    			<td width="240px">
			        			<input type="text" class="TextBox Datetime" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_order_date&#39;);" id="start_date" name="start_date" value="">
								<img src="images/calendar.gif" class="imgIconButton" onclick="displayCalendar(document.getElementById(&#39;start_date&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_order_date\&#39;)&#39;);">
								<input type="hidden" id="hid_start_date" value="">
								至
								<input type="text" class="TextBox Datetime" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_order_date&#39;);" id="end_date" name="end_date" value="">
								<img src="images/calendar.gif" class="imgIconButton" onclick="displayCalendar(document.getElementById(&#39;end_date&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_order_date\&#39;)&#39;);">
								<input type="hidden" id="hid_end_date" value="">
			    			</td>
			    			<th class="c2" width="80px">
			        			<input type="checkbox" name="cb_est" id="cb_est">
			        			订货单位
			        		</th>
			    			<td class="c3" width="280px">
			        			<input type="text" class="TextBox" maxlength="50" name="est_name" id="est_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_est&#39;);" value="">
								<img class="imgIconButton" src="images/make-a.gif" onclick="selectEstName();">
								<input type="hidden" id="hid_est_name" value="">
			    			</td>
			    		</tr>
			    		<tr>
			    			<th class="c1">
			        			<input name="" type="checkbox" id="cb_del_date">
			        			交货日期
			        		</th>
			        		<td>
			        			<input type="text" class="TextBox Datetime" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_del_date&#39;);" id="del_start" name="del_start" value="">
								<img src="images/calendar.gif" class="imgIconButton" onclick="displayCalendar(document.getElementById(&#39;del_start&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_del_date\&#39;)&#39;);">
								<input type="hidden" id="hid_del_start" value="">
								至
								<input type="text" class="TextBox Datetime" maxlength="15" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_del_date&#39;);" id="del_end" name="del_end" value="">
								<img src="images/calendar.gif" class="imgIconButton" onclick="displayCalendar(document.getElementById(&#39;del_end&#39;),&#39;yyyy-mm-dd&#39;,this,false,&#39;doAutoCheck(\&#39;cb_del_date\&#39;)&#39;);">
								<input type="hidden" id="hid_del_end" value="">
			    			</td>
							<th class="c2">
			        			<input type="checkbox" name="cb_foll" id="cb_foll">
			        			跟单员
			        		</th>
			    			<td class="c3">
			        			<input type="text" class="TextBox" maxlength="15" name="foll_name" id="foll_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_foll&#39;);" value="">
								<img class="imgIconButton" src="images/make-a.gif" onclick="selectStafferName(&#39;foll_name&#39;,&#39;cb_foll&#39;);" style="cursor:pointer;">
								<input type="hidden" id="hid_foll_name" value="">
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
			        		<th class="c2">&nbsp;</th>
	                    	<td class="c2">&nbsp;</td>
						</tr>
					</tbody></table>
					
					<div class="OptionOrderBy">
						<input type="checkbox" name="cb_order" id="cb_order">
	                    	排序类型
	                    <select name="order_by" id="order_by" onfocus="doAutoCheck(&#39;cb_order&#39;);">
						  	<option value="">==请选择==</option>
						  	<option value="ORDER_DATE">订货日期</option>
						  	<option value="DELIVER_DATE">交货日期</option>
						  	<option value="BILL_CODE">业务单号</option>
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
</tbody></table>
	        </div>
			
		    <div class="table-list">
		        <table width="100%">
		          	<tbody><tr>
					  	<th width="14"><input type="checkbox" onclick="javascript:checkall(this);"></th>
					  	<th width="14%">单号</th>
						<th width="8%">订货日期</th>
						<th width="24%">订货单位</th>
						<th width="16%">摘要</th>
						<th width="8%">交货日期</th>
						<th width="18%">跟单员</th>
						<th width="12%">操作</th>
		          	</tr>
					
		        <!-- 前台迭代获得后台从数据库传过来的值 -->
				<s:iterator value="cooperBill" status="indexs">
		          	<tr class="query_list_data_tr1" index="1" style="cursor:pointer;" ondblclick="javascript:DoubleClick(this)" onclick="javascript:ClickCheck(this,true)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
						<td><input type="checkbox" onclick="javascript:ClickCheck(this,true);" name="query_checkbox" value="378"></td>
						<td>${billCode}</td>
						<td>${createTime}</td>
						<td></td>
						<td>${content}</td>
						<td>${gatherDate}</td>
						<td>${managerName}</td>
						<td>
								<a href="javascript:doExamine('378');">审核通过</a>
								<a href="javascript:doShow('378');">查看</a>
						</td>
					</tr>
					</s:iterator>
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
	        document.getElementById('cb_bill_code').style.visibility = 'visible';
	        this.style.visibility = 'hidden';
	    };
	    lnkHiddenOption.onclick = function(){
	    	IsAdvSearch = false;
	        document.getElementById('dvMoreOptionBox').style.display = 'none';
	        document.getElementById('cb_bill_code').style.visibility = 'hidden';
	        lnkMoreOption.style.visibility = 'visible';
	    };
	})();
</script>
</body>
</html>