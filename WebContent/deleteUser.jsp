<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>  
	<h>deleteUser!</h><br>
	<form action="/springMVCT1/user/afterDeleteUser" method="post">
	选择删除的uid:<input name="uid" type="text"/> <br>
	 
	<input name="删除"type="submit">
	</form>   
	
</body>
</html>