<%@ page language="java" import="java.util.*,com.tyc.web.entity.*"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>展示车辆</title>
	<link rel="stylesheet" type="text/css" href="../css/style/showPage.css" />
</head>
<body>
<%
    String mid="";
     //System.out.println(request.getCookies());//第一次访问时，后台输出null，刷新一次即能输出相应内容
    if(null != request.getCookies()){
        Cookie[] cookie = request.getCookies();
        for(int i = 0; i < cookie.length; i++)
        {
            if(cookie[i].getName().equals("mid"))
            {
                mid = cookie[i].getValue();
                break;
            }
        }
    }
    if(!mid.equals("")){
    %> 
<!--自行车分类-->
<div class="classBlock">
	<div class="linkBox">
		<a href="/springMVCT1/manager/selectBicycle?btype=shandi" class="showPage" target="displayWindow">山地车</a>
		<b>|</b>
		<a href="/springMVCT1/manager/selectBicycle?btype=nvshi" class="showPage" target="displayWindow">女式车</a>
		<b>|</b>
		<a href="/springMVCT1/manager/selectBicycle?btype=zhedie" class="showPage" target="displayWindow">折叠车</a>
		<b>|</b>
		<a href="/springMVCT1/manager/selectBicycle?btype=sifei" class="showPage" target="displayWindow">死飞</a>
		<b>|</b>
		<a href="/springMVCT1/manager/selectBicycle?btype=haohua" class="showPage" target="displayWindow">豪华超跑</a>
		<b>|</b>
		<a href="/springMVCT1/manager/selectBicycle?btype=zhinengtuizou" class="showPage" target="displayWindow">只能推走</a>
	</div>
</div>
<!--自行车基本信息列表-->
<div class="bikePart">
	<ul>
		<c:forEach items="${tmpBicycleList }" var="bicycle">
		<li>
			<div class="bikeBox" style="height: 313px">
				<a href="/springMVCT1/manager/toBikeDetail?bid=${bicycle.bid }" class="bikePhotoToDis">
					<img src="../imgBicycle/${bicycle.bimageurl }"  class="bikePhoto" />
				</a>
				<div class="bikeDis">
					<p>编号：<b>${bicycle.bid }</b>  出租状态：<b>${bicycle.bstatus }</b> 损坏状态：<b>${bicycle.bdamage }</b></p>
					<p>类型：${bicycle.btype } </p>
					<p>租金：${bicycle.brentmoney }元</p>
					<p>价格：${bicycle.bpriceperday } 元/天</p>
				</div>
			</div>
		</li>
		</c:forEach>
	</ul>
</div>
<%}else 
	{%>
                        <a >用户还没有登录</a><p></p>
                        
                        <a href="/springMVCT1/manager/toLogIn">点击登录</a>
	<%} %>
</body>
</html>