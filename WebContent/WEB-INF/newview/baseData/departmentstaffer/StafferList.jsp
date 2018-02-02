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

	</head>

	<body scroll="no">
		<div id="scrollDiv" style="OVERFLOW:auto;height:508px">
			<div class="main search-business">
				<div class="cue-info">
					<h3>
						所有部门 - 员工
					</h3>
				</div>

				<div class="table-list" style="width:97%; padding:15px 0 15px 10px; float:left;">
					<h4>在职人数：${stafferEnable}　　离职人数：${stafferEnableN}　</h4>
					<table width="100%">
						<tbody>
							<tr>
								<th width="15%">部门</th>
								<th width="15%">姓名</th>
								<th width="13%">职位</th>
								<th width="15%">上级</th>
								<th width="16%">入职日期</th>
								<th width="10%">状态</th>
								<th width="16%">操作</th>
							</tr>

									<!--  
									<s:iterator value="staffers" status="staffers">
									<c:if test="${superiorId==id}">${stafferName}</c:if>
									</s:iterator>
									-->
							<!--迭代获得从后台传过来的数据  -->
							<s:iterator value="staffers" status="indexs">
							<tr>
							        <td>
							            <s:iterator value="departs" status="departs">
					   		            <c:if test="${departmentId == id }">${departmentName }</c:if>
					                    </s:iterator>
							        </td>
									<td>${stafferName }</td>
									<td>${possie}</td>
									<td>${mark}</td>
									<td>${inDate}</td>
									<td>${enabled}</td>
								<td>	
							     <a href="departStaff_toStafferEdit?id=${id}">编辑</a>
							     <a href="javascript:doPause('61');">停用</a>
							    <!--   <a href="departStaff_delStaffer?id=${id }">删除</a>-->
							     <a href="javascript:doDelete(${id });">删除</a>
								</td>
							</tr>
							</s:iterator>
							

						</tbody>
					</table>
				</div>
			</div>
		</div>
		<script src="layui/layui.all.js"></script>
		<script>
//			function doEdit(id) {
//				var url = "base/StafferEdit.html?id=" + id;
//				parent.ShowIframe("员工", url, 900, 475, "refreshStaWin()", 900, 640); //refreshStaWin是父窗口的
//			}
			function doEdit(id) {
				var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
				alert(index);
//				window.top.layer.close(index);
//				var url = "base/StafferEdit.html?id=" + id;
//				var json = {
//					type: 2,
//					title: false,
//					content: '',
//					area: ['1200px', '700px'],
//					shadeClose: true,
//					closeBtn: 0, //关闭按钮
//					resize: false, //是否允许拉伸
//					scrollbar: false, //是否允许浏览器出现滚动条
//					moveOut: true
//				};
//				json['content'] = url;
////				layer.open(json);
//				top.layer.open(json);
			}
				
		</script>
	</body>

</html>