<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
产值单
<form action="chanzhi_add" method="post">
经办人：<input type="text" name="ovBillVO.createrName">
产值金额：<input type="text" name="ovBillVO.cost">
摘要:<textarea rows="4" cols="6" name="ovBillVO.mark"></textarea>
备注:<textarea rows="4" cols="6" name="ovBillVO.description"></textarea>


<input type="submit" value="提交">
</form>


</body>
</html>