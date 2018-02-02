<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- {pageContext.request.contextPath} -->
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<META http-equiv=Content-Type content="text/html; charset=utf-8">
<META http-equiv=Pragma content=no-cache>
<META http-equiv=Cache-Control content=no-cache>
<META http-equiv=Expires content=0>
<TITLE>客户满意是我们的追求</TITLE>
<link href="./css.css?ver=ent9.27" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath}/jswf/minierp.js?ver=ent9.27"></script>
<script src="${pageContext.request.contextPath}/jswf/LodopFuncs.js?ver=ent9.27"></script>
<head>
<script src="${pageContext.request.contextPath}/jswf/popup_ext.js?ver=ent9.27"></script>
<script language="javascript">
	function doPrint(){
	//	ShowConfirm('确认框','确定开始打印吗？',340,80,"doPrintExt()");
			var len=2;
			var isIE = (navigator.userAgent.indexOf('MSIE')>=0) || (navigator.userAgent.indexOf('Trident')>=0);
			document.getElementById("noPrinSpan").style.display="none";
			if(len>200 && isIE){
				iePrint("wb","SELECT");
			}else{
				printContent("管理易-外协对账单","SELECT","ALL");
			}
			document.getElementById("noPrinSpan").style.display="";	
	}
	function doPrintExt(){
		if(popRetVal!=null){
			var len=2;
			var isIE = (navigator.userAgent.indexOf('MSIE')>=0) || (navigator.userAgent.indexOf('Trident')>=0);
			document.getElementById("noPrinSpan").style.display="none";
			if(len>200 && isIE){
				iePrint("wb","SELECT");
			}else{
				printContent("管理易-外协对账单","SELECT","ALL");
			}
			document.getElementById("noPrinSpan").style.display="";
		}
	}
	function doCancel(){
		window.close();
	}
	function doDownload(){
		var str=getSearchCondiction();
		window.location='/cooper/CooperBillListForAccount.ihtm?content_type=EXCEL&'+str;
	}
	function getSearchCondiction(){
		var cooperatorId="706";
		var startDate="";
		var endDate="2017-12-08";
		var type="JUST_UNPAIED";
		var orderBy="DATE_ASC";
		var tsId="0";
		return 'cooperator_id='+cooperatorId+'&start_date='+startDate+'&end_date='+endDate+'&type='+type+'&order_by='+orderBy+'&ts_id='+tsId;
	}
	function doPay(){
		var url="/finance/PayBillNew.ihtm?data_type=COO_ACCOUNT&"+getSearchCondiction();
		ShowIframe("付款",url,1024,500,"refreshWin()",900,600);
	}
	function refreshWin(){
		if(popRetVal!=null){
			var url='/cooper/CooperBillListForAccount.ihtm?'+getSearchCondiction();
			if(popRetVal.indexOf(";")!=-1){
				var arr=popRetVal.split(";");
				if(arr[1]!=null && arr[1]=="Y"){
					url=url+"&print_id="+arr[0]+"&print_bill=PAY";
					if(arr[2]!=null){
						url=url+"&print_detail="+arr[2];
					}
				}
			}
			window.location=url;
		}
	}
	function doRefresh(){
		var str=getSearchCondiction();
		window.location='/cooper/CooperBillListForAccount.ihtm?'+str;
	}
	function doPrintCallBack(){
		var printId="";
		var printBill="";
		var printDetail="";
		if(printId!=null && printId!=""){
			if(printBill=="PAY"){
				showWin(900,600,"/finance/PayBillPrint.ihtm?id="+printId+"&print_detail="+printDetail);
			}else if(printBill=="ADJ"){
				showWin(900,600,"/finance/AdjustBillPrint.ihtm?id="+printId);
			}
		}
	}
	function showRelBill(id,code){
		showWin(900,600,"/cooper/CooperRelBillList.ihtm?id="+id+"&code="+code);
	}
	function doSearch(){
		var url="/cooper/CooperBillListForAccountForm.ihtm";
		ShowIframeNoScroll("外协对帐",url,340,400,"doSearchExt()");
	}
	function doSearchExt(){
		if(popRetVal!=null){
			var startDate=popRetVal[0];
			var endDate=popRetVal[1];
			var type=popRetVal[2];
			var orderBy=popRetVal[3];
			var tsId=popRetVal[4];
			window.location='/cooper/CooperBillListForAccount.ihtm?cooperator_id=706&start_date='+startDate+'&end_date='+endDate+'&type='+type+'&order_by='+orderBy+'&ts_id='+tsId;
		}
	}
</script>
</head>
<!-- 不显示信息 -->
<body style="background-color:#FFFFFF" onLoad="doPrintCallBack();">
<OBJECT classid="CLSID:8856F961-340A-11D0-A96B-00C04FD705A2" height=0 id=wb name=wb width=0></OBJECT>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td>
			<table width="98%" border="0" cellspacing="1" cellpadding="1" align="center">
				<tr>
					<td width="16%"><img src="/upload/1_1456975049379login.gif" /></td>
					<td width="68%" height="40px" align="center" class="FontLarge_Bold">郑州市新异标识标牌有限公司 外协对账单</td>
					<td width="16%">&nbsp;</td>
				</tr>
		  </table>			
		</td>
	</tr>
	<tr>
		<td>
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="ListTable">
				<tr class="ListTrPrint">
			      	<td class="FontSmall" width="35%">外协单位：郑州南方标牌</td>
			      	<td class="FontSmall" width="40%">起止日期： 至 2017-12-08</td>
				    <td class="FontSmall" width="25%" >合同金额：320.00</td>
				</tr>
				<tr class="ListTrPrint">
			      	<td class="FontSmall">已付金额：0.00</td>
					<td class="FontSmall">调账金额：0.00</td>
			      	<td class="FontSmall">尚欠金额：320.00</td>		      	
				</tr>	
				<tr class="ListTrPrint">
			      	<td class="FontSmall">地址：</td>
					<td class="FontSmall">联系人：小杨</td>
			      	<td class="FontSmall">电话：336302970</td>		      	
				</tr>							  
		  </table>			
		</td>
	</tr>
	<tr>
		<td height="3"></td>
	</tr>
	<tr>
		<td>
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="small_border">
				<tr class="ListTrPrint">
					<td width="12%" class="FontSmall_Bold">
				    <div align="center">单号</div></td>
					<td width="8%" class="FontSmall_Bold">
				    <div align="center">日期</div></td>
					<td width="10%" class="FontSmall_Bold">
				    <div align="center">项目类型</div></td>
					<td width="13%" class="FontSmall_Bold">
				    <div align="center">内容</div></td>
					<td width="9%" class="FontSmall_Bold">
				    <div align="center">材质</div></td>
					<td width="12%" class="FontSmall_Bold">
				    <div align="center">规格</div></td>
					<td width="6%" class="FontSmall_Bold">
					<div align="center">单位</div></td>
					<td width="6%" class="FontSmall_Bold">
				    <div align="center">数量</div></td>
					<td width="6%" class="FontSmall_Bold">
					<div align="center">单价</div></td>
					<td width="7%" class="FontSmall_Bold">
				    <div align="center">金额</div></td>
					<td width="11%" class="FontSmall_Bold">
				    <div align="center">制作要求</div></td>
				</tr>
				
				
				<s:iterator value="gatherBillVOs" status="st">
			<tr>
				<td><s:property value="%{cooperBillVOs[#st.index].billCode }"/></td><!-- 单号 -->
				<td><s:property value="%{cooperBillVOs[#st.index].gatherDate }"/></td><!--日期  --> 
				<td><s:property value="%{makeTypeVOs[#st.index].typeName}" /></td><!--项目类型  -->
				<td><s:iterator value="%{cooperbillitemvoSS[#st.index]}" >
						<s:property value="finishedContent" /><!-- 内容 -->
					</s:iterator></td>
				
				<td><s:iterator value="%{cooperbillitemvoSS[#st.index]}" >
						<s:property value="proName" /><!-- 材质 -->
					</s:iterator></td>
	
				<td><s:iterator value="%{cooperbillitemvoSS[#st.index]}" >
						<s:property value="specification" /><!-- 规格 -->
					</s:iterator></td>

				<td><s:iterator value="%{cooperbillitemvoSS[#st.index]}" >
						<s:property value="unit" /><!-- 单位 -->
					</s:iterator></td>

				<td><s:iterator value="%{cooperbillitemvoSS[#st.index]}" >
						<s:property value="amount" /><!-- 数量 -->
					</s:iterator></td>

				<td><s:iterator value="%{cooperbillitemvoSS[#st.index]}" >
						<s:property value="unitPrice" /><!-- 单价 -->
					</s:iterator></td>

				<td><s:iterator value="%{cooperbillitemvoSS[#st.index]}" >
						<s:property value="cost" /><!--  金额-->
					</s:iterator></td>

				<td><s:iterator value="%{cooperbillitemvoSS[#st.index]}" >
						<s:property value="makeRequire" /><!-- 制作要求 -->
					</s:iterator></td>
			</tr>
		</s:iterator>
				
				
				
				
				
				
				
				
				
				<tr  class="ListTrPrint" ><td colspan="11"  class="FontSmall" align="right">小计金额：320.00元&nbsp;扣除优惠金额：0.00元&nbsp;合同金额(实收)：320.00元</td></tr>
			</table>
			
		</td>
	</tr>
	<tr>
		<td height="3"></td>
	</tr>
	<tr>
		<td>
			<table width="98%" border="0" align="center" cellpadding="0" cellspacing="0" class="ListTable">
				<tr class="ListTrPrint">
			      	<td class="FontSmall" align="right" width="86%">外协商确认：</td>
					<td class="FontSmall" width="14%">&nbsp;</td>
				</tr>
		  </table>
		</td>
	</tr>
	
	<tr id="noPrinSpan">
		<td>
			<table width="98%" border="0" cellspacing="1" cellpadding="1" align="center">
				<tr>
					<td>
						<input type="button" id="printButton" class="Button" value="开始打印" onClick="doPrint();">
						
							<input type="button" id="printButton" class="Button" value=" 导 出 " onClick="doDownload();">
						
						<input type="button" id="refreshButton" class="Button" value=" 刷新 " onClick="doRefresh();">
						<input type="button" id="refreshButton" class="Button" value=" 重新查询 " onClick="doSearch();">
						
							<input type="button" id="receiveButton" class="Button" value=" 付款 " onClick="doPay();">
						
						<input type="button" id="cancelButton" class="Button" value=" 退 出 " onClick="doCancel();">
					</td>
				</tr>
				<tr>
					<td class="FontSmall" style="color:grey">注：红色表示无欠款，加粗蓝色表示已部分付款，蓝色表示无付款</td>
				</tr>
			</table>
		</td>
	</tr>
</table>
</body>
</html>