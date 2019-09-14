<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=basePath %>css/bootstrap.min.css" type="text/css" rel="stylesheet">
<link href="<%=basePath %>css/font-awesome.min.css" type="text/javascript" rel="stylesheet">
<link href="<%=basePath %>css/bootsnav.css" type="text/css" rel="stylesheet">
<link href="<%=basePath %>css/normalize.css" type="text/css" rel="stylesheet">
<link href="<%=basePath %>css/css.css" rel="stylesheet" type="text/css">
<script src="<%=basePath %>js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/bootsnav.js" type="text/javascript"></script>
<script src="<%=basePath %>js/jquery.js" type="text/javascript"></script>
<!--[if IE]><script src="js/html5.js"></script><![endif]-->
	<script type="text/javascript">
	document.onkeydown = function(e){
	    if(e.keyCode == 13){
	    	document.getElementById("denglu").click();
	    }
	}
	</script>
<title>登录</title>
</head>

<body class="logobg_style">
  	<div id="large-header" class="large-header login-page">
  		<canvas id="demo-canvas" width="1590" height="711"></canvas>
  		<div class="login-form">
  			<div class="login-content">
  				<h1 class="title_name">账户登录</h1>
  				<form method="post" class="login_padding">
				<div class="form-group clearfix">

					<div class="input-group">
						<div class="input-group-addon">
							<i class="icon_user"></i>
						</div>

						<input type="text" class="form-control" name="bphone" id="username" placeholder="手机号">
					</div>

				</div>

				<div class="form-group clearfix">

					<div class="input-group">
						<div class="input-group-addon">
							<i class="icon_password"></i>
						</div>

						<input type="password" class="form-control" name="bpwd" id="password" placeholder="密码">
					</div>

				</div>
					<div class=" textright"><a href="back" class="forget">忘记密码?</a></div>
                  <div class="tishi"></div>
				<div class="form-group">
					<a type="button" id="denglu" class="btn btn-danger btn-block btn-login" onclick="cliLogin()">
						<i class="fa fa-sign-in"></i>登录	
					</a>
				</div>
<div style="float:right;"><a href="regi" class="forget">立即注册</a></div>
<div style="float:left;"><a href="ind" class="forget">返回首页</a></div>
				<!-- Implemented in v1.1.4 -->				<div class="form-group">
					
				</div>



	
			</form>
  			</div>
  			
  		</div>
  	</div>
  	
<script src="<%=basePath %>js/TweenLite/TweenLite.min.js"></script>
<script src="<%=basePath %>js/TweenLite/EasePack.min.js"></script>
<script src="<%=basePath %>js/TweenLite/rAF.js"></script>
<script src="<%=basePath %>js/TweenLite/demo-1.js"></script>
</body>
</html>
