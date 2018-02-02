<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0071)http://115.28.87.22:8888/base/EstablishmentCommunicateSearchResult.html -->
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="0">
	<title>我的日程 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
	<link rel="stylesheet" type="text/css" href="css/base.css">
	<link href="layui/css/layui.css" rel="stylesheet" type="text/css" />
	<link href="css/Query.css" rel="stylesheet" type="text/css">
	<link href="css/dhtmlgoodies_calendar.css" rel="stylesheet" type="text/css">
	<link rel="stylesheet" type="text/css" href="css/BillList.css">

	<script src="js/minierp.js"></script>
	<script src="js/QueryList.js"></script>
	<script src="js/popup.js"></script>
	<script src="js/dhtmlgoodies_calendar.js"></script>

	<script language="javascript">
		function doNew() {
			var url = "./EstablishmentCommunicateNew.html";
			ShowIframe(['930px','440px'], url, '', function(){
				refreshWin(0);
			}, '日程');
		}

		function refreshWin(flag) {
			if(flag == 1) {
				if(popRetVal != null) {
					window.location.reload(true);
				}
			} else {
				window.location.reload(true);
			}
		}

		function showComm(id) {
			var url = "./EstablishmentCommunicateEdit.html?id=" + id;
			ShowIframe(['930px','440px'], url, '', function(){
				refreshWin(0);
			}, '日程');
		}

		function createPageParaStr() {
			var str = "start_date=" + encodeURIComponent(document.getElementById("start_date").value);
			str = str + "&end_date=" + encodeURIComponent(document.getElementById("end_date").value);

			var type = "A";
			if(document.getElementById("type1").checked) {
				type = "LOG";
			} else if(document.getElementById("type2").checked) {
				type = "PLAN";
			}
			str = str + "&type=" + type;

			var completed = "A";
			if(document.getElementById("complete1").checked) {
				completed = "Y";
			} else if(document.getElementById("complete2").checked) {
				completed = "N";
			}
			str = str + "&completed=" + completed;

			str = str + "&creater_id=" + encodeURIComponent(document.getElementById("creater_id").value);
			str = str + "&creater_name=" + encodeURIComponent(document.getElementById("creater_name").value);

			var fromType = "A";
			if(document.getElementById("from_type1").checked) {
				fromType = "C";
			} else if(document.getElementById("from_type2").checked) {
				fromType = "J";
			}
			str = str + "&from_type=" + fromType;

			return str;
		}

		function createProgramParaStr() {
			var str = "start_date=" + encodeURIComponent(document.getElementById("hid_start_date").value);
			str = str + "&end_date=" + encodeURIComponent(document.getElementById("hid_end_date").value);
			str = str + "&type=";
			str = str + "&completed=";
			str = str + "&creater_id=";
			str = str + "&creater_name=" + encodeURIComponent(document.getElementById("hid_creater_name").value);
			str = str + "&from_type=";
			return str;
		}

		function doSearch() {
			var str;
			if(IsAdvSearch) { //高级
				str = "search_type=1";
				if(document.getElementById("cb_comm_date").checked) {
					if(!checkDateStr(document.getElementById("start_date").value, "开始日期")) {
						return;
					}
					if(!checkDateStr(document.getElementById("end_date").value, "结束日期")) {
						return;
					}
					str = str + "&cb_comm_date=1";
				}
				if(document.getElementById("cb_type").checked) {
					str = str + "&cb_type=1";
				}
				if(document.getElementById("cb_complete").checked) {
					str = str + "&cb_complete=1";
				}

				if(document.getElementById("cb_creater").checked) {
					var createrId = document.getElementById("creater_id").value;
					if(createrId == null || createrId == "" || createrId == "0") {
						ShowAlert('请选择创建人', {titel:'提示框'});
						return;
					}
					str = str + "&cb_creater=1";
				}
				if(document.getElementById("cb_from").checked) {
					str = str + "&cb_from=1";
				}
			} else { //快速
				str = "search_type=2";
				if(!checkDateStr(document.getElementById("start_date").value, "开始日期")) {
					return;
				}
				if(!checkDateStr(document.getElementById("end_date").value, "结束日期")) {
					return;
				}
			}
			var paraStr = createPageParaStr();
			if(paraStr != "") {
				str = str + "&" + paraStr;
			}
			window.location = "./EstablishmentCommunicateSearchResult.html?" + str;
		}

		function doGo(pageIndex) {
			var str = getSearchCondition();
			str = str + "&current_page=" + pageIndex;
			window.location = "./EstablishmentCommunicateSearchResult.html?" + str;
		}

		function getSearchCondition() {
			var searchType = "2";
			var str = "search_type=" + searchType;
			if(searchType == "1") { //高级

			} else { //快速

			}
			var paraStr = createProgramParaStr();
			if(paraStr != "") {
				str = str + "&" + paraStr;
			}
			return str;
		}

		function doJump(pageIndex) {
			if(window.event.keyCode == 13) {
				doGo(pageIndex);
			}
		}

		function DoubleClick(it) {
			var ob_arr = document.getElementsByName("query_checkbox");
			var str = "";
			if(ob_arr.length >= it.getAttribute("index")) {
				str = ob_arr[it.getAttribute("index") - 1].value;
			}
			if(str == "") {
				return;
			}
			showComm(str);
		}

		function doCancel() {
			window.close();
		}

		function doInit() {
			Window_Onload();
		}

		function checkInput() {
			if(window.event.keyCode == 13) {
				doSearch();
			}
		}

		function doAutoCheck(objId) {
			document.getElementById(objId).checked = true;
		}

		function selectCreaterName() {
			var url = "./StafferMainForSelect.html";
			ShowIframe(['800px','500px'], url, '', function(){
				selectCreaterNameCallBack();
			}, '选择员工');
		}

		function selectCreaterNameCallBack() {
			if(popRetVal != null) {
				var arr = popRetVal.split(";");
				document.getElementById("creater_id").value = arr[0];
				document.getElementById("creater_name").value = arr[1];
				doAutoCheck("cb_creater");
			}
		}

		function setDate(type) {
			var d = new Date();
			var startStr = "";
			var endStr = "";
			if(type == "CURRENT_MONTH") {
				startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-01";
				endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
			} else if(type == "PREVIEW_MONTH") {
				d = new Date(d.getFullYear(), d.getMonth(), 1);
				d.setDate(d.getDate() - 1);
				startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-1";
				endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
			} else if(type == "TODAY") {
				startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
			} else if(type == "YESTERDAY") {
				d.setDate(d.getDate() - 1);
				startStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
				endStr = d.getFullYear() + "-" + (d.getMonth() + 1) + "-" + d.getDate();
			}
			document.getElementById("start_date").value = startStr;
			document.getElementById("end_date").value = endStr;
			doAutoCheck("cb_comm_date");
		}

		function doDownload() {
			var str = getSearchCondition();
			window.location = "./EstablishmentCommunicateSearchResult.html?content_type=EXCEL&" + str;
		}

		function doComp(id) {
			var url = "./EstCommCompForm.html?id=" + id;
			ShowIframe(['600px','300px'], url, '', function(){
				refreshWin(1);
			}, '完成情况');
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
					<h1>我的日程</h1>
					<div class="pull-right">
						<div class="layui-form" style=" display: inline-block;">
							<input type="checkbox" name="cb_comm_date" id="cb_comm_date" title="日期" checked="true" lay-skin="primary"> 
	            			<!--<input type="checkbox" name="cb_comm_date" id="cb_comm_date" checked="true" style="visibility:hidden;">-->
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
							<a type="button " class="layui-btn " id="sNewButton" name="sNewButton" onclick="doNew();">新 增</a>
							<a type="button " class="layui-btn " id="sDownloadButton" name="sDownloadButton" onclick="doDownload();">导 出</a>
						</div>
					</div>
				</div>
			</div>

			<!-- 主内容 -->
			<div class="Content">
				<!-- 筛选控件栏 -->
				<div class="FilterBar ClearFix">
					<div id="dvMoreOptionBox" class="MoreOptionBox" style="display:none; margin-top: 5px;">
					<table class="MoreOption" cellpadding="0" cellspacing="0">
						<tbody><tr>
							<th class="c1" width="80px">
			        			<input type="checkbox" name="cb_type" id="cb_type">
			        			类型
			        		</th>
			    			<td class="c1" width="260px">
			        			<input type="radio" name="type" id="type1" onclick="doAutoCheck(&#39;cb_type&#39;);">日志
								<input type="radio" name="type" id="type2" onclick="doAutoCheck(&#39;cb_type&#39;);">任务
								<input type="radio" name="type" id="type3" onclick="doAutoCheck(&#39;cb_type&#39;);" checked="true">全部
			    			</td>
			    		</tr>
			    		<tr>
			    			<th class="c1">
			        			<input type="checkbox" name="cb_complete" id="cb_complete">
			        			进度
			        		</th>
			    			<td class="c1">
			        			<input type="radio" name="completed" id="complete1" onclick="doAutoCheck(&#39;cb_complete&#39;);">已完成
								<input type="radio" name="completed" id="complete2" onclick="doAutoCheck(&#39;cb_complete&#39;);" checked="true">进行中
			    			</td>
			    		</tr>
			    		<tr>
			    			<th class="c1">
			        			<input type="checkbox" name="cb_creater" id="cb_creater">
			        			创建人
			        		</th>
			    			<td class="c3">
			        			<input type="text" class="TextBox readonly" readonly="true" maxlength="15" name="creater_name" id="creater_name" onkeyup="checkInput();" onfocus="doAutoCheck(&#39;cb_creater&#39;);" value="">
								<img class="imgIconButton" src="images/make-a.gif" onclick="selectCreaterName();">
								<input type="hidden" id="hid_creater_name" value="">
								<input type="hidden" id="creater_id" value="">
			    			</td>
			    		</tr>
			    		<tr>
			    			<th class="c1">
			        			<input type="checkbox" name="cb_from" id="cb_from">
			        			来源
			        		</th>
			    			<td class="c1">
			        			<input type="radio" name="from_type" id="from_type1" onclick="doAutoCheck(&#39;cb_from&#39;);">自己创建
								<input type="radio" name="from_type" id="from_type2" onclick="doAutoCheck(&#39;cb_from&#39;);">作为参与者
								<input type="radio" name="from_type" id="from_type3" onclick="doAutoCheck(&#39;cb_from&#39;);" checked="true">全部
			    			</td>
			    		</tr>
			    	</tbody></table>
					
					<div class="OptionOrderBy">
						<span class="fr"><a href="javascript:;" id="lnkHiddenOption">隐藏查询选项</a></span>
	                </div>
				</div>
				</div>

				<!-- 提示信息显示栏 -->
				<div class="MsgBar">

					<table width="98%" border="0" cellpadding="0" cellspacing="0">
						<tbody>
							<tr id="errorMsgTr" style="display:none">
								<td>
									<div class="msg-error" id="errorMsgTd">

									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div class="table-list">
					<div class="blank24"></div>
					<table width="100%">
						<tbody>
							<tr>
								<th width="4%">类型</th>
								<th width="12%">日期</th>
								<th width="14%">主题</th>
								<th width="16%">内容</th>
								<th width="16%">客户</th>
								<th width="8%">创建人</th>
								<th width="6%">进度</th>
								<th width="16%">完成情况</th>
								<th width="8%">操作</th>
							</tr>
							
							
							<s:iterator value="myCommunicates" status="indexs">
					
							<tr class="query_list_data_trSelected" style="cursor:pointer;color:#000000" defaultfontcolor="#000000" index="1" ondblclick="javascript:DoubleClick(this)" onclick="javascript:ClickCheck(this)" onmouseout="javascript:mouseout(this)" onmouseover="javascript:mouseover(this)">
						<td>
							<input type="radio" name="query_checkbox" value="12" style="display:none">
							<img src="/images/comm_log.gif">
							
						</td>
						<td>${communicateTime }</td>
						<td>${title }</td>
						<td>${content }</td>
						<td>${estId }</td>
						<td>${createrName }</td>
						<td>
							已完成
							
						</td>
						<td>
							
						</td>
						<td>
							<a href="javascript:showComm('${id }');">查看</a>
							
							
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
		//			更多查询选项
				var IsAdvSearch = false;
				var lnkMoreOption = document.getElementById('lnkMoreOption');
				var lnkHiddenOption = document.getElementById('lnkHiddenOption');
				lnkMoreOption.onclick = function() {
					IsAdvSearch = true;
					document.getElementById('dvMoreOptionBox').style.display = 'block';
					document.getElementById('cb_comm_date').style.visibility = 'visible';
					this.style.visibility = 'hidden';
				};
				lnkHiddenOption.onclick = function() {
					IsAdvSearch = false;
					document.getElementById('dvMoreOptionBox').style.display = 'none';
					document.getElementById('cb_comm_date').style.visibility = 'hidden';
					lnkMoreOption.style.visibility = 'visible';
				};
		
//		function ChangeWindowSize(container, maxWidth) {
//			setTimeout(function() {
//				var w1 = document.documentElement.clientWidth - 40;
//				if(w1 > maxWidth) w1 = maxWidth;
//				else if(w1 < 870) w1 = 860;
//				container.style.width = w1 + 'px';
//			}, 300);
//		}
//		var IsAdvSearch = false;
//		(function() {
//			doInit();
//			var ListContainer = document.getElementById('ListContainer');
////			ChangeWindowSize(ListContainer, 2020); // 超过 1280 的最大 1260 ，不全部铺满
//
//			var lnkMoreOption = document.getElementById('lnkMoreOption');
//			var lnkHiddenOption = document.getElementById('lnkHiddenOption');
//			lnkMoreOption.onclick = function() {
//				IsAdvSearch = true;
//				document.getElementById('dvMoreOptionBox').style.display = 'block';
//				document.getElementById('cb_comm_date').style.visibility = 'visible';
//				this.style.visibility = 'hidden';
//			};
//			lnkHiddenOption.onclick = function() {
//				IsAdvSearch = false;
//				document.getElementById('dvMoreOptionBox').style.display = 'none';
//				document.getElementById('cb_comm_date').style.visibility = 'hidden';
//				lnkMoreOption.style.visibility = 'visible';
//			};
//		})();
	</script>
	<audio controls="controls" style="display: none;"></audio>
		<script src="layui/layui.all.js"></script>
		<script>
			layui.use('laydate', function() {
				var laydate = layui.laydate;

				//常规用法
				laydate.render({
					elem: '#start_date'
				});

				laydate.render({
					elem: '#end_date'
				});
			});
		</script>
</body>

</html>