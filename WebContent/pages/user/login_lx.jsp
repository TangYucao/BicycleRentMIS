
<%@ page language="java" import="java.util.*,com.tyc.web.entity.*"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="../css/common/normalize.css">
    <link rel="stylesheet" href="../css/body/login_lx.css">
    <title>自行车租赁系统——登录</title>
    <script type="text/javascript">
        function go(){
            location.href="/springMVCT1/user/afterLogIn";
        }
        function login() {
            var username=document.getElementById("uphone").value;
            var password=document.getElementById("password").value;

            var reg_password = /^[a-zA-Z0-9_]{6,12}$/;
            var reg_phone = /^1\d{10}$/;

            if(!reg_phone.test(username)) //手机号判断
            {
                alert("手机号码输入有误，11位数字");
            }
            else if(!reg_password.test(password))
            {
                alert("密码输入有误，只能是字母、数字、下划线，6-12位");
            }
            else
            {
                //alert("验证成功");
                window.setTimeout(go(),2000);
            }
        }
    </script>
</head>
<body class="login_body">
<div id="login_main">
    <form id="login_form" action="/springMVCT1/user/afterLogIn" method="post">
        <br/>
        手机号
        <input type="text" name="uphonenum" id="uphone">
        <br/>
        密&nbsp;&nbsp;码
        <input type="password" name="upasswd" id="password">
        <br/>
        <input type="submit" onclick="login()" value="登录">
        <input type="button" onclick="location.href='/springMVCT1/user/toRegister'" value="注册">
    </form>
</div>

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