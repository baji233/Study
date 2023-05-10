<%@ page language="java" import="java.util.*,entity.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/public.css"/>
    <script src="js/jquery-1.11.3.min.js"></script>
    <script src="js/jquery.SuperSlide.2.1.1.js"></script>
    <script src="js/page.js"></script>
    <script src="js/highcharts.js"></script>
	<title>首页</title>
</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
	<!-- 导航 开始 -->
	<div class="index_nav">
		<div class="w1200 clearFloat">
			<div class="nav_left fl">
				<div class="top1">
					<a href="javascript:;"><span>产品分类</span></a>
				</div>
				<div class="top2">
					<ul>
						<%
							Map map=(Map)request.getAttribute("map");
							List types=(List)map.get("types");
							for(int i=0;i<types.size();i++){
								Type t=(Type)types.get(i);
							
						%>
						<li>
							<a href="javascript:;">
								<i><img src="images/index8.png" /></i><span><%=t.getTypeName()%></span>
							</a>
						</li>
						<% 
							}
						%>
						<li>
							<a href="javascript:;">
								<span>地标产品</span>
							</a>
						</li>
						<li>
							<a href="javascript:;">
								<span>其他肉类</span>
							</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="nav_center fl">
				<ul>
					<li>
						<a class="add_bg" href="wholesale.html">批发首页</a>
					</li>
					<li>
						<a href="selected-Meat.html">精选肉类</a>
					</li>
					<li>
						<a href="wholesale.html">供应大厅</a>
					</li>
					<li>
						<a href="buy-information.html">采购大厅</a>
					</li>
					<li>
						<a href="market-condition.html">市场行情</a>
					</li>
					<li>
						<a href="industry-new.html">行业资讯</a>
					</li>
				</ul>
			</div>
			<div class="nav_right fr">
				<div class="top3"><a href="javascript:;"><img src="images/index7.png" />委托采购</a></div>
				<div class="top4">
					<div class="up1">
						<a href="javascript:;">
							<img src="images/index44.png" />
							<p>HI!欢迎来到贵州肉类交易平台</p>
						</a>
					</div>
					<div class="up2">
						<a href="javascript:;"><img src="images/index14.png" />请登录</a>
						<a href="javascript:;"><img src="images/index15.png" />入驻开店</a>
					</div>
					<div class="up3">
						<div class="title clearFloat">
							<span class="fl">求购信息</span>
							<a class="fr" href="javascript:;">MORE</a>
						</div>
						<ul>
							<li><a href="javascript:;">阿里求购100斤山羊肉</a></li>
							<li><a href="javascript:;">马先生求购200斤土猪</a></li>
							<li><a href="javascript:;">杨先生求购500斤野猪猪肉</a></li>
							<li><a href="javascript:;">龙先生求购500斤佘鸥</a></li>
							<li><a href="javascript:;">凯里学院求购500斤鸭肉</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- 导航 结束 -->
	
	<!-- 轮播 开始 -->
	<div class="focusBox">  
	    <ul class="pic">  
	        <li><a href="#" target="_blank"><img src="images/index18.jpg"/></a></li>  
	    </ul>  
	    <ul class="num">  
	        <li><a>1</a><span></span></li>  
	        <li><a>2</a><span></span></li>  
	        <li><a>3</a><span></span></li>  
	        <li><a>4</a><span></span></li>  
	    </ul>  
	</div>  
	<!-- 轮播 结束 -->
	<style>
		.fui-notice{border: #666666 1px solid ;padding: 16px;height: auto;padding: 5px;margin-top: 20px;height: 30px;position: relative;overflow: hidden;}
		.fui-notice .img_gonggao{height: 30px;width: auto;position: relative;float: left;padding-left: 3px;}
		.bd_a_a ul li{line-height: 30px;margin-left: 20px;}
		.bd_a_a ul li a:hover{color: #059a32;}
	</style>
	<!--公告 star-->
	<div class="fui-notice w1200">
		<div class="img_gonggao"><img src="images/gg.png" width="30" height="30"/></div>
		<div class="txtScroll-top_a_a">
					<div class="bd_a_a">
						<ul class="infoList">
							<li class="clearFloat">
								<a href="javascript:">这是滚动的该公司的公告1！</a>
							</li>
							<li class="clearFloat">
								<a href="javascript:">这是滚动的该公司的公告2！</a>
							</li>
							<li class="clearFloat">
								<a href="javascript:">这是滚动的该公司的公告3！</a>
							</li>
							<li class="clearFloat">
								<a href="javascript:">这是滚动的该公司的公告4！</a>
							</li>
						</ul>
					</div>
		</div>
	</div>
	<script type="text/javascript">
		jQuery(".txtScroll-top_a_a").slide({titCell:".hd ul",mainCell:".bd_a_a ul",autoPage:true,effect:"top",autoPlay:true,vis:1});
	</script>
	<!--公告 end-->
	<!-- 限时采购 开始 -->
	<div class="index_time">
		<div class="w1200">
			<div class="title clearFloat">
				<span class="fl"><img src="images/index19.png" /><i>首页推荐</i></span>
				<a class="fr" href="javascript:;">MORE</a>
			</div>
			<ul class="clearFloat">
				<%
							
							List shops=(List)map.get("shops");
							for(int i=0;i<shops.size();i++){
								Shop s=(Shop)shops.get(i);
							
				%>
				<li>
					<div class="d"><img src="images/index20.jpg" /></div>
					<h3><%=s.getShopName() %></h3>
					<div class="d1 clearFloat">
						<span class="sp1 fl">¥<%=s.getPrice() %></span>
						<span class="sp2 fr"><i>50斤</i>起批</span>
					</div>
					<div class="d2 clearFloat">
						<span class="sp1 fl">贵州凯里</span>
						<span class="sp2 fr">10小时前</span>
					</div>
					<div class="d3">
						<span>剩余时间：<i>23天</i></span>
					</div>
					<a class="d4" href="ShopServlet?shopId=<%=s.getShopId()%>">立即抢购</a>
				</li>
				<%
							}
				%>
			</ul>
		</div>
	</div>
	<!-- 限时采购 结束 -->
</body>
</html>
<script>
	
</script>    