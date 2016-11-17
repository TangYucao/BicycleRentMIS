<%@ page language="java" import="java.util.*,com.tyc.web.entity.*"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body> 
<%
    String uphonenum="";
     //System.out.println(request.getCookies());//第一次访问时，后台输出null，刷新一次即能输出相应内容
    if(null != request.getCookies()){
        Cookie[] cookie = request.getCookies();
        for(int i = 0; i < cookie.length; i++)
        {
            if(cookie[i].getName().equals("uphonenum"))
            {
                uphonenum = cookie[i].getValue();
                break;
            }
        }
    }
    if(!uphonenum.equals("")){
    %> 
	<br>
		<tr>
			<td>${tmpUser.uid }</td>
			<td>${tmpUser.umoney }</td>
			<td>${tmpUser.upasswd }</td>
			<td>${tmpUser.uphonenum }</td>
		</tr>
	<br>所有订单
	<c:forEach items="${tmpRent }" var="r">
		<ul>
			<li>rid:${r.rid }</li>
			<li>bid:${r.bicycle.bid }</li>
			<li>uphonenum:${r.user.uphonenum }</li>
			<li>/imgBicycle/${r.bicycle.bimageurl }</li>
			<li><img src="../imgBicycle/123.jpg"></li>
		</ul>
	</c:forEach>
	
	<%} else 
	{%>
	 	<ul class="nav">
                        <li><a >用户还没有登录</a></li>
                        
                        
                        <li><a href="http://localhost:8080/springMVCT1/user/toLogIn">点击登录</a></li>
                    </ul>
	<%} %>
</body>
</html>