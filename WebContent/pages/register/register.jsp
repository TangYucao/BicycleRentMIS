<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h>注册界面</h>
<form action="/springMVCT1/user/afterRegister" method="post">
	请输入用户名:<input name="uid" type="text"/> <br>
	请输入密码:<input name="passwd" type="password"/> <br> 
	<input type="submit" value="注册"> 
	</form> 
	 
</body> 
</html>