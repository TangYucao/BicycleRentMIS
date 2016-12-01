<%@ page language="java" import="java.util.*,com.tyc.web.entity.*"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="../css/body/rentDetail_feng.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript" src="../js/detail.js"></script>
	<script>  
	$(function () {
		$.ms_DatePicker({
	            YearSelector: ".sel_year",
	            MonthSelector: ".sel_month",
	            DaySelector: ".sel_day"
	    });
		$.ms_DatePicker();
	}); 
	</script>
	<script type="text/javascript">
		function back(){
			window.location="/springMVCT1/user/toRentPage";
		}
		function tip(){
			alert("1");
			var result=confirm("确定要租车吗？");
			if (result==true){
				alert("此自行车已成功租借！请于租借日之前归还");
				document.getElementById('rentBicycle').submit(); 
				//location.href="/springMVCT1/user/afterLogIn";
			}else{
				window.location="rentPage_feng.html";
			}
		}
		function op()
		{
			var selected=document.getElementById("day");
			var index=selected.selectedIndex;
			var value=selected.options[index].value;
			var currentTime=${currentTime };
			value=Math.abs(value-currentTime)
			document.getElementById("dayselect").value=value;
			var totalprice=${tmpBicycle.bpriceperday }*value;
			document.getElementById("totalprice").value=totalprice;
		}
    </script>
    <title>详细信息</title>
</head>
<body>

	<div>
		<input type="button" value="Return" id="return" onclick="back();" />
	</div>
	<div id="picture">
		<img src="../imgBicycle/${tmpBicycle.bimageurl }" style="width:500px;">
	</div>
	<form id="rentBicycle" action="/springMVCT1/user/afterRent" method="post" enctype="multipart/form-data">
	<div id="information">
		<p id="bicycleclass">类别：${tmpBicycle.btype }</p>
		<p id="state">是否上架：${tmpBicycle.bstatus }</p>
		<div id="price">
			<p>开始时间：年月日</p>
			<p>
				<label>结束日期：</label>  
				<!-- <select class="sel_year" rel="2016"> </select> --> 2016年 
				<select class="sel_month" rel="12"> </select> 月 
				<select class="sel_day" rel="30" id="day" onchange="op()"> </select> 日
			</p>
			<p>费用：${tmpBicycle.bpriceperday }(单价)X(天数)<input id="dayselect" type="text" name="rrenttime" style="border:0px;background:none;width:20px"/>= 
			<input name="rfee" id="totalprice" type="text" style="width:20px;border:0px;background:none;"/>元</p>
		</div>
		<div id="push">
			<input type="hidden" value="${tmpBicycle.bid }" name="bid" />
			<input type="button" value="我要租车" id="rent" onclick="tip()" />
		</div>
	</div>
	</form>
</body>
</html>