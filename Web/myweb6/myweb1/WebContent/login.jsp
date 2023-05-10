<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width-device-width,initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="sie-edge" />
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>登录注册页面</title>

<!--图标库-->
<script src="https://unpkg.com/ionicons@4.2.2/dist/ionicons.js"></script>

</head>

<body>
	<% String type= request.getParameter("type");
		String className="";
		if("2".equals(type)){
			className="container right-panel-active";
		}else{
			className="container";
		}
	%>
	
<div class="<%=className%>" id="container">
  <div class="form-container sign-up-container">
    <form action="UserServlet" method="post">
    	<input type="hidden" name="me" value="register"/>
      <h1>第三方按钮注册</h1>
      <div class="social-container"> <a href="#" class="social">
        <ion-icon name="logo-facebook"></ion-icon>
        </a> <a href="#" class="social"> 
        <ion-icon name="logo-googleplus"></ion-icon>
        </a> <a href="#" class="social">
        <ion-icon name="logo-linkedin"></ion-icon>
        </a> </div>
      <span style="color:red;">
     	 <% String msg=request.getParameter("msg"); 
     	 	if("2".equals(msg)){
     	 		msg="注册失败";
     	 	}else{
     	 		msg="";
     	 	}
     	 %>
     	 <%= msg %>
      </span>
      <input type="text" placeholder="用户名" name="username"/>
      <input type="text" placeholder="电话" name="phone"/>
      <input type="password" placeholder="密码" name="password"/>
      <input type="submit" value="注册"/>
    </form>
  </div>
  <div class="form-container sign-in-container">
    <form action="UserServlet" method="post">
    <input type="hidden" name="me" value="login"/>
      <h1>第三方登录</h1>
      <div class="social-container"> <a href="#" class="social">
        <ion-icon name="logo-facebook"></ion-icon>
        </a> <a href="#" class="social">
        <ion-icon name="logo-googleplus"></ion-icon>
        </a> <a href="#" class="social">
        <ion-icon name="logo-linkedin"></ion-icon>
        </a> </div>
      <span style="color:red;">${msg}</span>
      <input type="text" placeholder="用户名" name="username"/>
      <input type="password" placeholder="密码" name="password"/>
      <input type="submit" value="登录" />
    </form>
  </div>
  <div class="overlay-container">
    <div class="overlay">
      <div class="overlay-panel overlay-left">
        <h1>欢迎回来</h1>
        <p>与我们保持联系请登录您的个人信息</p>
        <button class="ghost" id="signIn">登录</button>
      </div>
      <div class="overlay-panel overlay-right">
        <h1>欢迎光临</h1>
        <p>输入您的个人资料，并与我们一起开始旅程</p>
        <button class="ghost" id="signUp">注册</button>
      </div>
    </div>
  </div>
</div>

<script  src="js/script.js"></script> 
	
</body>
</html>

    
    
    