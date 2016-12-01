<%@ page language="java" import="java.util.*,com.tyc.web.entity.*"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>自行车租赁—— 个人中心</title>
    <link rel="stylesheet" href="../css/common/normalize.css">
    <link rel="stylesheet" href="../css/common/common.css">
    <link rel="stylesheet" href="../css/body/personalCenter_lx.css">
    <script type="text/javascript">
        function show(str) {
            var bar1=document.getElementById("personal_infor");
            var bar2=document.getElementById("rent_record");
            var bar3=document.getElementById("bike_circle");
            var bar4=document.getElementById("personal_account");
            var bar5=document.getElementById("credit_system");

//            var li1=document.getElementById("pi_list");
//            var li2=document.getElementById("rr_list");
//            var li3=document.getElementById("bc_list");
//            var li4=document.getElementById("pa_list");
//            var li5=document.getElementById("cs_list");

            var a1=document.getElementById("pi_a");
            var a2=document.getElementById("rr_a");
            var a3=document.getElementById("bc_a");
            var a4=document.getElementById("pa_a");
            var a5=document.getElementById("cs_a");
            switch(str){
                case "personal_infor":{
                    bar1.style.display="block";
                    bar2.style.display="none";
                    bar3.style.display="none";
                    bar4.style.display="none";
                    bar5.style.display="none";
                    a1.style.backgroundColor="#000000";
                    a2.style.backgroundColor="#009FCC";
                    a3.style.backgroundColor="#33FF33";
                    a4.style.backgroundColor="#9F88FF";
                    a5.style.backgroundColor="#FFA488";
                }
                break;
                case "rent_record":{
                    bar1.style.display="none";
                    bar2.style.display="block";
                    bar3.style.display="none";
                    bar4.style.display="none";
                    bar5.style.display="none";
                    a1.style.backgroundColor="#FF88C2";
                    a2.style.backgroundColor="#000000";
                    a3.style.backgroundColor="#33FF33";
                    a4.style.backgroundColor="#9F88FF";
                    a5.style.backgroundColor="#FFA488"

                }
                break;
                case "bike_circle":{
                    bar1.style.display="none";
                    bar2.style.display="none";
                    bar3.style.display="block";
                    bar4.style.display="none";
                    bar5.style.display="none";
                    a1.style.backgroundColor="#FF88C2";
                    a2.style.backgroundColor="#009FCC";
                    a3.style.backgroundColor="#000000";
                    a4.style.backgroundColor="#9F88FF";
                    a5.style.backgroundColor="#FFA488"
                }
                break;
                case "personal_account":{
                    bar1.style.display="none";
                    bar2.style.display="none";
                    bar3.style.display="none";
                    bar4.style.display="block";
                    bar5.style.display="none";
                    a1.style.backgroundColor="#FF88C2";
                    a2.style.backgroundColor="#009FCC";
                    a3.style.backgroundColor="#33FF33";
                    a4.style.backgroundColor="#000000";
                    a5.style.backgroundColor="#FFA488"
                }
                    break;
                case "credit_system":{
                    bar1.style.display="none";
                    bar2.style.display="none";
                    bar3.style.display="none";
                    bar4.style.display="none";
                    bar5.style.display="block";
                    a1.style.backgroundColor="#FF88C2";
                    a2.style.backgroundColor="#009FCC";
                    a3.style.backgroundColor="#33FF33";
                    a4.style.backgroundColor="#9F88FF";
                    a5.style.backgroundColor="#000000"
                }
                    break;
            }
        }
    </script>
</head>
<body style="overflow-x:hidden;overflow-y:hidden">
<!--/*中间部分*/-->
<div class="personal_mainpage">
    <!--/*侧边栏*/-->
    <div id="sidebar">
        <nav>
            <ul>
                <li id="pi_list"><a id="pi_a" href="#" onclick="show('personal_infor')">基本信息</a></li>
                <li id="rr_list"><a id="rr_a" href="#" onclick="show('rent_record')">租售记录</a></li>
                <li id="bc_list"><a id="bc_a" href="#" onclick="show('bike_circle')">骑行圈</a></li>
                <li id="pa_list"><a id="pa_a" href="#" onclick="show('personal_account')">个人账户</a></li>
                <li id="cs_list"><a id="cs_a" href="#" onclick="show('credit_system')">信用系统</a></li>
            </ul>

        </nav>
    </div>
    <!--/*侧边栏分割线*/-->
    <div id="cutoff_line"></div>
    <!--/*内容*/-->
    <div id="details">
        <div id="personal_infor">
            <table>
                <tr>
                    <td>电话号码</td> <td></td><td id="pi_name">${tmpUser.uphonenum }</td>
                </tr>
                <tr>
                    <td>性别</td> <td></td><td id="pi_gender">男</td>
                </tr>
                <tr>
                    <td>职业</td> <td></td><td id="pi_work">学生</td>
                </tr>
                <tr>
                    <td>所在地</td> <td></td><td id="pi_place">电子科技大学</td>
                </tr>
                <tr>
                    <td>邮箱地址</td> <td></td><td id="pi_email">lixiang@outlook.com</td>
                </tr>

            </table>
        </div>
        <div id="rent_record">
            <table>
               
                <c:forEach items="${tmpRent }" var="r">
                <form action="/springMVCT1/user/afterRequestRepair" method="post" enctype="multipart/form-data">
                <tr>
                
                     <td>应还时间：${r.rrenttime }天</td><td>订单ID:${r.rid }</td> <td></td> 
                     <td>租借ID为${r.bicycle.bid }的车一辆</td> <td></td> <td>租金:${r.bicycle.brentmoney }</td>
                      <td></td> <td>费用:${r.rfee }</td>  <td>
                      
                      <input type="hidden" name="rid" value="${r.rid }"/>
                      <input type="hidden" name="bid" value="${r.bicycle.bid }"/>
                      <input type="submit" value="报修"></input></td>
                </tr>
                </form>
                </c:forEach>
               
            </table>
        </div>
        <div id="bike_circle">
            <table>
                <tr>
                    <td>哔哩哔哩</td>
                </tr>
                <tr>
                    <td class="date_style">2016/8/5</td>
                </tr>
                <tr>
                    <td><img src="../images/example.jpg"></td>
                </tr>

                <tr>
                    <td>哔哩哔哩</td>
                </tr>
                <tr>
                    <td class="date_style">2016/8/5</td>
                </tr>
                <tr>
                    <td><img src="../images/example.jpg"></td>
                </tr>
            </table>
        </div>
        <div id="personal_account" >
            <div id="account_infor">
                <table>
                    <tr>
                        <td>账户余额</td> <td></td> <td>${tmpUser.umoney }</td><td>余额充足，请放心使用</td>
                    </tr>
                    <tr>
                        <td>在租车辆</td> <td></td> <td>IDxxxxxxxx</td><td></td>
                    </tr>
                    <tr>
                        <td>剩余天数</td> <td></td> <td>1天</td><td>快到期了，去续租吧</td>
                    </tr>
                </table>
            </div>
        </div>
        <div id="credit_system">

        </div>
    </div>
</div>
</body>
</html>