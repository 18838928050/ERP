<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

               
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0060)http://115.28.87.22:8888/storehouse/OutBillSearchResult.html -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>出库单一览表</title>
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
			function doShow(id){
				var url="storehouse/OutBillEdit.html?id="+id;
				ShowIframe(['1024px', '500px'], url, '', function() {
					refreshWin();
				}, '入库单');
			}
			function refreshWin(){
				if(popRetVal!=null){
					window.location.reload(true);
				}
			}
			function createPageParaStr(){
				var str="start_date="+encodeURIComponent(document.getElementById("start_date").value);
				str=str+"&end_date="+encodeURIComponent(document.getElementById("end_date").value);
				
				var exa="A";
				if(document.getElementById("exa1").checked){
					exa="Y";
				}else if(document.getElementById("exa2").checked){
					exa="N";
				}
				str=str+"&exa="+exa;
				
				str=str+"&out_type="+document.getElementById("out_type").value;
				str=str+"&bill_code="+encodeURIComponent(document.getElementById("bill_code").value);
				str=str+"&manager_name="+encodeURIComponent(document.getElementById("manager_name").value);
				str=str+"&requirer_type="+document.getElementById("requirer_type").value;
				str=str+"&requirer_name="+encodeURIComponent(document.getElementById("requirer_name").value);
				str=str+"&bb_code="+encodeURIComponent(document.getElementById("bb_code").value);
				str=str+"&sto_id="+document.getElementById("sto_id").value;
				str=str+"&mark="+encodeURIComponent(document.getElementById("mark").value);
				str=str+"&ts_id="+document.getElementById("ts_id").value;
				str=str+"&order_by="+document.getElementById("order_by").value;
				str=str+"&order_sc="+document.getElementById("order_sc").value;
				
				return str;
			}
			
			function createProgramParaStr(){
				var str="start_date="+encodeURIComponent(document.getElementById("hid_start_date").value);
				str=str+"&end_date="+encodeURIComponent(document.getElementById("hid_end_date").value);
				str=str+"&exa=";
				str=str+"&out_type=";
				str=str+"&bill_code="+encodeURIComponent(document.getElementById("hid_bill_code").value);
				str=str+"&manager_name="+encodeURIComponent(document.getElementById("hid_manager_name").value);
				str=str+"&requirer_type=";
				str=str+"&requirer_name="+encodeURIComponent(document.getElementById("hid_requirer_name").value);
				str=str+"&bb_code="+encodeURIComponent(document.getElementById("hid_bb_code").value);
				str=str+"&mark="+encodeURIComponent(document.getElementById("hid_mark").value);
				str=str+"&sto_id=";
				str=str+"&ts_id=1";
				str=str+"&order_by=";
				str=str+"&order_sc=";
				
				return str;
			}
			function doSearch(){
				var str;
				if(IsAdvSearch){//高级
					str="search_type=1";
					if(document.getElementById("cb_out_date").checked){
						if(!checkDateStr(document.getElementById("start_date").value,"开始日期")){
							return;
						}
						if(!checkDateStr(document.getElementById("end_date").value,"结束日期")){
							return;
						}
						str=str+"&cb_out_date=1";
					}
					if(document.getElementById("cb_exa").checked){
						str=str+"&cb_exa=1";
					}
					if(document.getElementById("cb_out_type").checked){
						var outType=document.getElementById("out_type").value;
						if(outType==null || outType=="" || outType=="0"){
							ShowAlert('提示框','请选择出库类型',200,100);
							return;
						}
						str=str+"&cb_out_type=1";
					}
					if(document.getElementById("cb_bill_code").checked){
						var billCode=document.getElementById("bill_code").value.trim();
						if(billCode==null || billCode==""){
							ShowAlert('提示框','请输入单号',200,100);
							return;
						}
						str=str+"&cb_bill_code=1";
					}
					if(document.getElementById("cb_manager").checked){
						var managerName=document.getElementById("manager_name").value.trim();
						if(managerName==null || managerName==""){
							ShowAlert('提示框','请输入经办人姓名',200,100);
							return;
						}
						str=str+"&cb_manager=1";
					}
					if(document.getElementById("cb_requirer").checked){
						str=str+"&cb_requirer=1";
					}
					if(document.getElementById("cb_bb_code").checked){
						var bbCode=document.getElementById("bb_code").value.trim();
						if(bbCode==null || bbCode==""){
							ShowAlert('提示框','请输入业务单号',200,100);
							return;
						}
						str=str+"&cb_bb_code=1";
					}
					if(document.getElementById("cb_sto").checked){
						var stoId=document.getElementById("sto_id").value;
						if(stoId==null || stoId=="" || stoId=="0"){
							ShowAlert('提示框','请选择仓库',200,100);
							return;
						}
						str=str+"&cb_sto=1";
					}
					if(document.getElementById("cb_ts").checked){
						var tsId=document.getElementById("ts_id").value;
						if(tsId==null || tsId=="" || tsId=="0"){
							ShowAlert('提示框','请选择帐套',200,100);
							return;
						}
						str=str+"&cb_ts=1";
					}
					if(document.getElementById("cb_mark").checked){
						var mark=document.getElementById("mark").value.trim();
						if(mark==null || mark==""){
							ShowAlert('提示框','请输入备注',200,100);
							return;
						}
						str=str+"&cb_mark=1";
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
				window.location="/storehouse/OutBillSearchResult.html?"+str;
			}
			
			function doGo(pageIndex){
				var str=getSearchCondition();
				str=str+"&current_page="+pageIndex;
				window.location="/storehouse/OutBillSearchResult.html?"+str;
			}
			function getSearchCondition(){
				var searchType="1";
				var str="search_type="+searchType;
				if(searchType=="1"){//高级
					str=str+"&cb_out_date=1";
					
					
					
					
					
					
					
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
				if(ob_arr.length>=it.getAttribute("index")){
					id=ob_arr[it.getAttribute("index")-1].value;
				}
				if(id==""){
					return;
				}
				doShow(id);
			}
			
			function doCancel(){
				window.close();
			}
			function doInit(){
				Window_Onload();
			}
			function checkInput(){
				if(window.event.keyCode==13){
					doSearch();
				}
			}
			function doPrint(id){
				
					ShowConfirm('确认框','是否打印金额？',340,80,"doPrintCallBack("+id+")");
				
				
			}
			function doPrintCallBack(id){
				var printCost="0";
				if(popRetVal!=null){
					printCost="1";
				}
				showWin(900,600,"/storehouse/OutBillPrint.html?id="+id+"&print_cost="+printCost);
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
				doAutoCheck("cb_out_date");
			}
			function showExaPage(id){
				var url="/storehouse/OutBillInfoForExamine.html?id="+id;
				ShowIframe("出库单审核",url,900,500,"refreshWin()",1024,600);
			}
			function showUnExaPage(id){
				var url="storehouse/OutBillInfoForUnExamine.html?id="+id;
				ShowIframe(['900px', '500px'], url, '', function() {
					refreshWin();
				}, '出库单反审核');
			}
			function doIn(id){
				showWin(1024,600,"/storehouse/InBillNew.html?alert_type=FORM&data_type=OUT_BILL&out_bill_id="+id);
			}
			function changeReqType(){
				if(document.getElementById("requirer_type").value=="NOT_STO"){
					document.getElementById("requirer_name").style.visibility="hidden";
				}else{
					document.getElementById("requirer_name").style.visibility="visible";
				}
			}
			function doMultiPrint(){
				var ob_arr = document.getElementsByName("query_checkbox");
				var idStr="",stoId="",requType="",requId="",canPrin="Y",moreOne="N";
				for (i=0;i<ob_arr.length;i++){
					if ((ob_arr[i].checked == true)){
						if(idStr!=""){
							if(stoId!=ob_arr[i].getAttribute("sto_id") || requType!=ob_arr[i].getAttribute("requ_type") || requId!=ob_arr[i].getAttribute("requ_id")){
								canPrin="N";
							}
							idStr=idStr+";";
							moreOne="Y";
						}else{
							stoId=ob_arr[i].getAttribute("sto_id");
							requType=ob_arr[i].getAttribute("requ_type");
							requId=ob_arr[i].getAttribute("requ_id");
						}
						idStr = idStr+ob_arr[i].value;
					}
				}
				if(canPrin=="N"){
					ShowAlert('提示框','同一个仓库与需方单位才可以合并打印',200,100);
				}else if(idStr==""){
					ShowAlert('提示框','请选择要打印的出库单',200,100);
				}else{
					
						ShowConfirm('确认框','是否打印金额？',340,80,"doMultiPrintCallBack('"+idStr+"','"+moreOne+"')");
					
					
				}
			}
			function doMultiPrintCallBack(idStr,moreOne){
				var printCost="0";
				if(popRetVal!=null){
					printCost="1";
				}
				if(moreOne=="Y"){
					showWin(900,600,"/storehouse/OutBillPrint.html?id="+idStr+"&print_cost="+printCost+"&type=MULTI");
				}else{
					showWin(900,600,"/storehouse/OutBillPrint.html?id="+idStr+"&print_cost="+printCost);
				}
			}
			function doDownload(){
				var str=getSearchCondition();
				window.location="/storehouse/OutBillSearchResult.html?content_type=EXCEL&"+str;
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
	            <h1>出库单一览表</h1>
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
	      
	        <div class="FilterBar ClearFix">
				<div id="dvMoreOptionBox" class="MoreOptionBox" style="display:none;">
					<table class="MoreOption" cellpadding="0" cellspacing="0">
						<tbody><tr>
							<th class="c1" width="80px">
			        			<input type="checkbox" name="cb_requirer" id="cb_requirer">
			        			需方单位
			        		</th>
			        		<td class="c1" width="240px">
			        			<select style="width:78px" name="requirer_type" id="requirer_type" onfocus="doAutoCheck(&#39;cb_requirer&#39;);" onchange="changeReqType();">
								  	<option value="WORK_CENTER">工作中心</option>
									<option value="DEPARTMENT">部门</option>
									<option value="CLIENT">客户</option>
									<option value="STOREHOUSE">仓库</option>
									<option value="PROVIDER">供应商</option>
									<option value="COOPERATOR">外协商</option>
									<option value="NOT_STO">仓库除外</option>
							  	</select>
							  	<input type="text" class="TextBox" style="width:116px;" maxlength="50" name="requirer_name" id="requirer_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_requirer&#39;);" value="">
							  	<input type="hidden" id="hid_requirer_name" value="">
			    			</td>
			    			<th class="c2" width="80px">
	                        	<input type="checkbox" name="cb_exa" id="cb_exa">
	                        	审核状态
	                        </th>
	                    	<td class="c2" width="250px">
	                        	<input type="radio" name="exa" id="exa1" onclick="doAutoCheck(&#39;cb_exa&#39;);" checked="true">已审核
	                        	<input type="radio" name="exa" id="exa2" onclick="doAutoCheck(&#39;cb_exa&#39;);">未审核
	                        	<input type="radio" name="exa" id="exa3" onclick="doAutoCheck(&#39;cb_exa&#39;);">全部
	                    	</td>
			    		</tr>
						<tr>
							<th class="c1">
			        			<input type="checkbox" name="cb_bill_code" id="cb_bill_code">
			        			出库单号
			        		</th>
			        		<td class="c1">
			        			<input type="text" class="TextBox" maxlength="50" name="bill_code" id="bill_code" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_bill_code&#39;);" value="">
								<input type="hidden" id="hid_bill_code" value="">
			    			</td>
			    			<th class="c2">
			        			<input type="checkbox" name="cb_out_type" id="cb_out_type">
			        			出库类型
			        		</th>
			    			<td class="c3">
			        			<select name="out_type" id="out_type" onfocus="doAutoCheck(&#39;cb_out_type&#39;);">
					  				<option value="0">==请选择==</option>
					  				
					  				<option value="1">销售出库</option>
					  				
					  				<option value="2">内部调拨</option>
					  				
					  				<option value="3">盘亏出库</option>
					  				
					  				<option value="4">加工制作</option>
					  				
					  				<option value="5">低值易耗品</option>
					  				
				  				</select>
			    			</td>
			    		</tr>
						<tr>
							<th class="c1">
			        			<input type="checkbox" name="cb_bb_code" id="cb_bb_code">
			        			业务单号
			        		</th>
			    			<td class="c1">
			        			<input type="text" class="TextBox" maxlength="50" name="bb_code" id="bb_code" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_bb_code&#39;);" value="">
								<input type="hidden" id="hid_bb_code" value="">
			    			</td>
							<th class="c2">
			        			<input type="checkbox" name="cb_sto" id="cb_sto">
			        			仓库
			        		</th>
			    			<td class="c3">
			        			<select name="sto_id" id="sto_id" onfocus="doAutoCheck(&#39;cb_sto&#39;);">
					  				<option value="0">==请选择==</option>
					  				
					  				<option value="1">标识加工仓库</option>
					  				
					  				<option value="2">中力门店仓库</option>
					  				
					  				<option value="3">车间型材仓库</option>
					  				
					  				<option value="4">车间耗材仓库</option>
					  				
					  				<option value="5">车间工具仓库</option>
					  				
					  				<option value="6">你好，仓库</option>
					  				
				  				</select>
			    			</td>
			    		</tr>
			    		<tr>
			    			<th class="c1">
			        			<input type="checkbox" name="cb_manager" id="cb_manager">
			        			经办人
			        		</th>
			        		<td class="c1">
			        			<input type="text" class="TextBox" maxlength="15" name="manager_name" id="manager_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_manager&#39;);" value="">
								<input type="hidden" id="hid_manager_name" value="">
			    			</td>
	                    	<th class="c2">
			        			<input type="checkbox" name="cb_ts" id="cb_ts" checked="true">
	                        	账套
			        		</th>
			    			<td class="c3">
			        			<select name="ts_id" id="ts_id" onfocus="doAutoCheck(&#39;cb_ts&#39;);">
				    				<option value="0">==请选择账套==</option>
				    				
									<option value="1" selected="">新异</option>
									<option value="2">网络公司</option>
								</select>
			        		</td>
	                	</tr>
	                	<tr>
	                    	<th class="c1">
			        			<input type="checkbox" name="cb_mark" id="cb_mark">
			        			备注
			        		</th>
			        		<td class="c1">
			        			<input type="text" class="TextBox" maxlength="15" name="mark" id="mark" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_mark&#39;);" value="">
								<input type="hidden" id="hid_mark" value="">
			    			</td>
			        		<th class="c2">&nbsp;</th>
			    			<td class="c3">&nbsp;</td>
	                	</tr>
					</tbody></table>
					
			    	<div class="OptionOrderBy">
	                	<input type="checkbox" name="cb_order" id="cb_order">
	                    	排序类型
	                    <select name="order_by" id="order_by" onfocus="doAutoCheck(&#39;cb_order&#39;);">
	                        <option value="">==请选择==</option>
					  		<option value="OUT_DATE">出库日期</option>
					  		<option value="BILL_CODE">单号</option>
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
			
			<div class="TopToolBar">
				<table class="ListNoteInfo" cellpadding="0" cellspacing="0">
	            	<tbody><tr>
	                	<td>出库金额合计：0元</td>
	            	</tr>
	            </tbody></table>
			</div>
			
     		<div class="table-list">
		        <table width="100%">
		          	<tbody><tr>
		          		<th width="14"><input type="checkbox" onclick="javascript:checkall(this);"></th>
						<th width="12%">单号</th>
						<th width="8%">出库日期</th>
						<th width="10%">仓库名称</th>
						<th width="8%">出库类型</th>
						<th width="14%">需方单位</th>
						<th width="14%">备注</th>
						<th width="8%">经办人</th>
						<th width="12%">业务单号</th>
						<th width="6%">状态</th>
						<th width="8%">操作</th>
					</tr>
					 <!-- 前台迭代获得后台从数据库传过来的值 -->
				<s:iterator value="outBills" status="outBills">
				<tr>
				    <td></td>
					<td>${billCode }</td>
					<td>${outDate }</td>
					<td>
					   <s:iterator value="storehouses" status="storehouses">
					   		<c:if test="${storehouseId == id }">${stoName }</c:if>
					   </s:iterator>
					</td>
					<td>
					   <s:iterator value="outTypes" status="outTypes">
					   		<c:if test="${id == outTypeId }">${typeName }</c:if>
					   </s:iterator>
					</td>
					<td></td>
					<td>${mark }</td>
					<td>${managerName }</td>
					<td>${businessBillCode }</td>
					<td><a href="outResult_tohadExamine">已审核</a>	</td>
					<td>
						<a href="outResult_toOutBillEdit">修改</a>
						<a href="#">打印</a>
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
	        document.getElementById('cb_out_date').style.visibility = 'visible';
	        this.style.visibility = 'hidden';
	    };
	    lnkHiddenOption.onclick = function(){
	    	IsAdvSearch = false;
	        document.getElementById('dvMoreOptionBox').style.display = 'none';
	        document.getElementById('cb_out_date').style.visibility = 'hidden';
	        lnkMoreOption.style.visibility = 'visible';
	    };
	})();
</script>
<audio controls="controls" style="display: none;"></audio>
<script src="layui/layui.all.js"></script>
<script>
			layui.use('laydate', function() {
				var laydate = layui.laydate;

				//执行一个laydate实例
				laydate.render({
					elem: '#start_date' //指定元素
				});
				laydate.render({
					elem: '#end_date'
				});
			});
		</script>
</body>
</html>					
