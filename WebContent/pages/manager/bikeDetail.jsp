<%@ page language="java" import="java.util.*,com.tyc.web.entity.*"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>bikeDetail</title>
<link rel="stylesheet" type="text/css" href="../css/style/bikeDetail.css">
</head>
<body>
<p class="title">编辑车辆信息</p>
<hr class="titleLine">
<form action="/springMVCT1/bicycle/modBicycle" method="post" enctype="multipart/form-data">
<div class="detailBlock">
	<ul>
		<li>车辆ID:${tmpBicycle.bid }</li>
		<li><input type="hidden" name="bid" value="${bid }"/></li>
		<li>是否上架：
				<select name="bstatus">
					<option value="是">是</option>
					<option value="否">否</option>
				</select>
			</li>
			<li>是否需要维修：
				<select name="bdamage" >
					<option value="F">否</option>
					<option value="T">是</option>
				</select>
			</li>
			<li>车辆类型：
				<select name="btype" >
					<option value="shandi">山地车</option>
					<option value="nvshi">女式车</option>
					<option value="zhedie">折叠车</option>
					<option value="sifei">死飞</option>
					<option value="haohua">豪华车</option>
				</select>
			</li>
			<li>租金：<input type="text" name="brentmoney" value="${tmpBicycle.brentmoney }"></li>
			<li>单日价格：<input type="text" name="bpriceperday" value="${tmpBicycle.bpriceperday }"></li>
			<li id="upPhoto">上传照片：<input type="file" name="file" value="../imgBicycle/${tmpBicycle.bimageurl }"></li>
		<li><input type="submit" value="确认修改"  id="submit"></li>
	</ul>
</div>
	</form>
</body>
</html>