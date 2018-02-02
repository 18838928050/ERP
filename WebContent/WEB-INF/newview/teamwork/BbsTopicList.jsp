<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0058)http://115.28.87.22:8888/bbs/BbsTopicList.html?column_id=1 -->
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="Pragma" content="no-cache">
	<meta http-equiv="Cache-Control" content="no-cache">
	<meta http-equiv="Expires" content="0">
	<title>主题列表</title>
	<link rel="stylesheet" href="layui/css/layui.css">
	<script src="js/minierp.js"></script>

<link rel="stylesheet" type="text/css" href="css/base.css">
<script src="js/QueryList.js"></script>
<script language="javascript">
	function doSearch(){
		var searchKey=encodeURIComponent(document.getElementById("search_key").value.trim());
		window.location="./BbsTopicList.html?column_id=1&search_key="+searchKey;
	}
	function doNew(){
		window.location="./BbsArticleNew.html?column_id=1";
	}
	function doGo(pageIndex){
		var searchKey=encodeURIComponent("");
		window.location="/bbs/BbsTopicList.html?column_id=1&search_key="+searchKey+"&current_page="+pageIndex;
	}
	function doJump(pageIndex){
		if(window.event.keyCode==13){
			doGo(pageIndex);
		}
	}
	function doInit(){
		document.getElementById("search_key").focus();
	}
	function checkSearchKey(){
		if(window.event.keyCode==13){
			doSearch();
		}
	}
	function doMultiDelete(){
		var ids=getMultiIds();
		if(ids==""){
			parent.ShowAlert('提示框','请选择要删除的公告!',200,100);
		}else{
			parent.ShowConfirm('确认框','确定删除吗？',340,80,"doDelTopic('"+ids+"')");//doDelTopic是父窗口的
		}
	}
	function getMultiIds(){
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
		return str;
	}
	function doDeleteAct(id){
		window.location="/bbs/BbsTopicDelete.html?id="+id+"&from_url="+encodeURIComponent(window.location);
	}
	function doChangeColumn(){
		var ids=getMultiIds();
		if(ids==""){
			parent.ShowAlert('提示框','请选择要改栏目的公告',200,100);
		}else{
			var strFeatures = "dialogWidth:350px;dialogHeight:210px;scroll:no;center:yes;status:no";
			var url="/bbs/ChangeColumnForm.html?id_str="+ids;
			parent.ShowIframeNoScroll("修改栏目",url,340,210,"refreshArtWin()");//refreshArtWin是父窗口的
		}
	}
	function refreshWin(){//父窗口调用
		window.location.reload(true);
	}
</script>
</head>
<body onload="doInit();" scroll="no" >
	<div id="scrollDiv" style="OVERFLOW:auto;height:468px;">
		<div class="main search-business">
			   <div class="cue-info" style="padding: 0 25px;">
					<h4 style="display: inline-block;">内部公告</h4>
				</div>
				
			  <div class="add_content">		
	        	<div class="layui-form" style="padding: 0 25px;float: right;">
								<div class="layui-inline">
									<div class="layui-input-inline">
										<input  type="text " class="layui-input" id="search_key" name="search_key" onkeyup="checkSearchKey();" value="" title="以产品名称、产品名称拼音字头进行模糊查询">
									</div>
								</div>
								<div class="layui-input-inline">
							      <input type="checkbox" id="search_all" name="search_all" lay-skin="primary" title="在所有类别中查找材料" checked="">
							    </div>

								<a type="button " class="layui-btn " onclick="doSearch();" title="以产品名称、产品名称拼音字头进行模糊查询">查 询</a>
								<a type="button " class="layui-btn " onclick="doNew();">发表</a>
								
							</div>
        	  </div>			  
			  
<table width="98%" border="0" cellpadding="0" cellspacing="0">
	<tbody><tr id="errorMsgTr" style="display:none">
	  <td>
	  	<div class="msg-error" id="errorMsgTd">
	  	
	  	</div>
	  </td>
	</tr>
</tbody>
</table>

			  <div class="table-list" style="width:95%; padding:15px 0 15px 10px; float:left;">
				  <table width="100%">
				      <tbody><tr>
				      	
				        <th width="36%">主题</th>
				        <th width="12%">作者</th>
				        <th width="18%">发表时间</th>
				        <th width="10%">回复/浏览</th>
						<th width="24%">最后回复</th>
				      </tr>
					  
					  		<!--迭代获得从后台传过来的数据  -->
							<s:iterator value="bbsArticle" status="indexs">
							<tr>
									<td>${title }</td>
									<td>${createrName }</td>
									<td>${createTime }</td>
									<td>${replierName }</td>
									<td>${lastTime }</td>
							</tr>
							</s:iterator>
					  
					  
				  <!--       <tr>
				      	
				        <td>
							<a href="http://115.28.87.22:8888/bbs/BbsReplyList.html?topic_id=6&amp;column_id=1">123</a>	
						</td>
				        <td>邵丽萍</td>
				        <td>2017-06-29 09:54</td>
				        <td>0/5</td>
						<td class="ListTd"></td>
				      </tr>	-->  
		        	</tbody>
				  </table>
					  	
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



<audio controls="controls" style="display: none;"></audio>
<script src="layui/layui.all.js"></script>
</body>

</html>					  
