<%@ page language="java" import="java.util.*,com.tyc.web.entity.*"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<link href="../css/body/rentPage_feng.css" rel="stylesheet" type="text/css" />
	<link rel="stylesheet" type="text/css" href="../csshake/dist/csshake.min.css">
	<title>租车</title>
</head>
<body>
	<ul id="menu">
		<li>
			<a href="/springMVCT1/user/selectBicycle?btype=shandi"><img src="../images/shandi.jpg" id="shandi" class="shake-chunk"></a>
			<p>山地车</p>
		</li>
	    <li>
			<a href="/springMVCT1/user/selectBicycle?btype=gonglu"><img src="../images/gonglu.jpg" id="gonglu" class="shake-chunk"></a>
			<p>公路车</p>
		</li>
	    <li>
			<a href="/springMVCT1/user/selectBicycle?btype=nvshi"><img src="../images/xiuxian.jpg" id="xiuxian" class="shake-chunk"></a>
			<p>女士车</p>
		</li>
	    <li>
			<a href="/springMVCT1/user/selectBicycle?btype=zhedie"><img src="../images/zhedie.jpg" id="zhedie" class="shake-chunk"></a>
			<p>折叠车</p>
		</li>
	    <li>
			<a href="/springMVCT1/user/selectBicycle?btype=sifei"><img src="../images/sifei.jpg" id="sifei" class="shake-chunk"></a>
			<p>死飞</p>
		</li>
	</ul>
	<hr/>
	<div id="content" style="width: 1020px;height: 500px;overflow-y: scroll;">
		<c:forEach items="${tmpBicycleList }" var="bicycle">
		<div id="list">
			<a href="/springMVCT1/user/toBicycleDetial?bid=${bicycle.bid }">
				<img src="../imgBicycle/${bicycle.bimageurl }" id="listimage">
			</a>
				<p>车辆ID:${bicycle.bid } <br/>价格：${bicycle.bpriceperday }元/天  租金：${bicycle.brentmoney }元</p>
		</div>
		</c:forEach>
	</div>
</body>
</html>