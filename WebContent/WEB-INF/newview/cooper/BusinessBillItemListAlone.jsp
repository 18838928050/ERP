<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0128)http://115.28.87.22:8888/business/BusinessBillItemListAlone.ihtm?id=3307&mark=%E4%B8%9A%E5%8A%A1%E5%8D%95%EF%BC%9AE(1)2017070062 -->
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="Pragma" content="no-cache">
		<meta http-equiv="Cache-Control" content="no-cache">
		<meta http-equiv="Expires" content="0">
		<title>订货明细 | 管理易-广告加工制作管理软件 企业版 9.28 | 易凯软件</title>
		<link rel="stylesheet" type="text/css" href="css/base.css">

		<script src="js/minierp.js"></script>
	</head>

	<body oncontextmenu="return false" class="sheet">
		<div class="sheet-main">
			<div class="sheet-top">
				<div class="content">
					<h2>订货明细</h2>
					<p>业务单：E(1)2017070062</p>
				</div>
			</div>
			<div class="sheet-list">
				<div class="search-business">
					<div class="blank24"></div>
					<div class="table-list">
						<table width="100%">
							<tbody>
								<tr>
									<th width="15%">项目类型</th>
									<th width="15%">内容</th>
									<th width="15%">材质</th>
									<th width="15%">规格</th>
									<th width="18%">制作要求</th>
									<th width="9%">单位</th>
									<th width="9%">数量</th>
									<th width="4%">外协</th>
								</tr>
								
								<s:iterator value="cooperBillItems" status="indexs">
								<tr>
									<td>属性未找到</td>
									<td>${finishedContent }</td>
									<td>${proName }</td>
									<td>
										${specification }

									</td>
									<td>${makeRequire }</td>
									<td>
									${unit }
									</td>
									<td>
										${squareNum }
									</td>
									<td>
										<img src="images/calendarHook.gif">
									</td>
								</tr>
								</s:iterator>


							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
<div class="blank24"></div>
		<audio controls="controls" style="display: none;"></audio>
	</body>

</html>