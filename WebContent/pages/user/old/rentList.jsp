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
	<!-- 传值给addBicycle action -->
	<form action="/springMVCT1/user/afterRequestRepair" method="post" enctype="multipart/form-data">
            <ul >
                
                <li>
                    <span  style="width:120px;">brentmoney：</span>
                    <input name="brentmoney"  type="text" class="textbox textbox_295" placeholder="设定价格..."/>
                    <!--<span class="errorTips"></span>-->
                </li>
                 
                <li>
                    <span style="width:120px;">上传图片：</span>
                    <label class="uploadImg" >
                        <input name="file" id="file" type="file" /><!-- 传值过去！ -->
                        <span>上传图片</span>
                    </label>
                </li>
                
                <li>
                	<input type="submit" class="link_btn"/>
                </li>
               
              
            </ul>
            </form>
</body>
</html>