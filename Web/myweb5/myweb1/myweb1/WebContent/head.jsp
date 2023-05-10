<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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

<!-- 顶部 开始 -->
	<div class="index_head1">
		<div class="w1200 clearFloat">
			<div class="head1_left fl">
				<span>欢迎来到贵州肉交所!</span>
				<a class="a1" href="login.jsp?type=1">立即登录</a>
				<a class="a2" href="login.jsp?type=2">免费注册</a>
			</div>
			<div class="head1_right fr">
				<a class="a1" href="javascript:;">我的账户</a>
				<a class="a2">关注手机端</a>
				<span class="sp1">客服热线：400-123-1213</span>
			</div>
		</div>
	</div>
	<!-- 顶部 结束 -->
	<!-- 头部logo 开始 -->
	<div class="index_head2">
		<div class="w1200 clearFloat">
			<div class="head2_left fl">
				<a href="javascript:;">
					<img src="images/index1.png" />
					<img src="images/index2.png" />
				</a>
			</div>
			<div class="head2_right fr clearFloat">
				<div class="sub_box clearFloat fl">
					<div class="sub1 fl">
						<span class="sp1">商品</span>
						<div class="sub" style="display: none;">
							<span>商品</span>
							<span>供应</span>
							<span>采购</span>
						</div>
					</div>
					<input class="txt1 fl" type="text" name="keyword" placeholder="输入货品名称" id="keyword"  />
					<input class="btn1 fr" type="button" value="搜索"  onclick="searchproduct();"/>
				</div>
				<div class="a1 fl" href="javascript:;">
					<span>发布求购信息</span>
					<dl class="a1_slide">
						<dd><a href="javascript:;">发布供应信息</a></dd>
						<dd><a href="javascript:;">发布采购信息</a></dd>
					</dl>
				</div>
			</div>
		</div>
	</div>
	<!-- 头部logo 结束 -->
	
</body>
</html>