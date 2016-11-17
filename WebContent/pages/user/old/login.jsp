<%@ page language="java" import="java.util.*,com.tyc.web.entity.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>自行车租赁——登录</title>
    <link rel="stylesheet" href="../css/common/normalize.css" type="text/css" >
    <link rel="stylesheet" href="../css/common/common.css" type="text/css" >
    <link rel="stylesheet" href="../css/common/header.css" type="text/css" >
    <link rel="stylesheet" href="../css/common/footer.css" type="text/css" >
    <link rel="stylesheet" href="../css/body/login.css" type="text/css" >
    <script type="text/javascript">
        //function goToMainpage() {
        //    window.location="./homepage.html"
        //}
        function login() {
            var username=document.getElementById("username").value;
            var password=document.getElementById("password").value;

            var reg_username = /^[a-zA-Z][a-zA-Z0-9_]{6,16}$/;
            var reg_password = /^[a-zA-Z0-9_]{6,12}$/;

            if(!reg_username.test(username)) //用户名判断
            {
                alert("用户名输入有误，必须以字母开头，只能包含字母、数字、下划线，6-16位");
            }
            else if(!reg_password.test(password))
            {
                alert("密码输入有误，只能是字母、数字、下划线6-12位");
            }
            else
            {
                alert("验证成功");
                //window.setTimeout("goToMainpage()",1000);
            }
        }
    </script>
</head>
<body>
<header class="header">
    <nav class="header_nav">
        <ul>
            <li class="logo"><a href="#">自行车logo</a></li>
            <li><a href="#">官网首页</a></li>
            <li><a href="#">最新活动</a></li>
            <li><a href="#">我要租车</a></li>
            <li><a href="#">我要卖车</a></li>
            <li><a href="#">个人中心</a></li>
            <li></li>
        </ul>
    </nav>
</header>

<div class="login_main">
    <div class="hr"></div>
    <form id="login_form" action="/springMVCT1/user/afterLogIn" method="post">
        <br/>
   手机号
        <input type="text" name="uphonenum" id="username">
        <br/>
        密码
        <input type="password" name="upasswd" id="password">
        <br/>
        <input type="submit" onclick="login()" value="登录">
        <input type="button"  onclick="location.href='/springMVCT1/user/toRegister'" value="注册">
    </form>
</div>c

<footer class="footer">
        <div class="hr"></div>
        <div class="hr1"></div>
    <div class="buttom_button">
        <button id="map">取车地图</button>
        <button id="callus">联系我们</button>
        <div class="buttom_text">
            <p>©zixinche.com 蜀ICP证8888888号 蜀ICP备88888888号 蜀公网安备88888888888号 蜀网文[2016]8888-8888号</p>
            <p>举报电话：134-xxxx-xxxx，本网站所列数据，除特殊说明，所有数据均出自我司实验室测试</p>
        </div>

    </div>

</footer>
</body>
</html>