<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title></title>
		<link rel="stylesheet" href="layui/css/layui.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script language="javascript">
			function doNew(){
				var url="unit_toUnitNew";
				ShowIframeNoScroll("计量单位",url,320,260,"refreshWin()");
			}
			function refreshWin(){
				window.location.reload(true);
			}
			function doEdit(id){
				var url="unit_toUnitEdit";
				ShowIframeNoScroll("计量单位",url,320,260,"refreshWin()");
			}
			function doDelete(id){
				ShowConfirm('确认框','确定删除吗？',340,80,"doDelAct("+id+")");
			}
			function doDelAct(id){
				if(popRetVal!=null){
					window.location="./UnitDelete.html?id="+id;
				}
			}
			function doCancel(){
				window.close();
			}
		</script>
	</head>
	<body oncontextmenu="return false" class="sheet" >
		<div class="sheet-main">
		  	<div class="sheet-top">
		    	<div class="content">
			      	<h2>计量单位</h2>
			      	<div class="pull-right"> 	
				    	<a type="button" class="layui-btn" onclick="doNew();">新增</a>
				    </div>
				</div>
		  	</div>
		  	
			<div class="sheet-list">
			    <div class="search-business">
					<div class="blank24"></div>
				    <div class="table-list">
				        <table width="100%">
				            <tbody>
				            	<tr>
					          		<th width="100">序号</th>
									<th width="150">单位名称</th>
									<th>操作</th>
								</tr>
				<!-- 前台迭代获得后台从数据库传过来的值 -->
				<s:iterator value="units" status="indexs">
					<tr>
						<td>${sequenceCode }</td>
						<td>${unitName }</td>
						<td>
							<a href="unit_toUnitEdit?id=${id}">编辑</a>
							<a href="unit_delUnit?id=${id }">删除</a>
						</td>
					</tr>
				</s:iterator>	
				            </tbody>
				        </table>
					   </div>  
				   </div>  
			  </div>
			  
		</div>
		<script src="layui/layui.all.js"></script>
	</body>
</html>