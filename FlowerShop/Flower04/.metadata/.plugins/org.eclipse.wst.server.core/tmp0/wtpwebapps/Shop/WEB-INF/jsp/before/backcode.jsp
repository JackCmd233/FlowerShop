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
<script src="<%=basePath %>js/jquery.step.js"></script>
<script src="<%=basePath %>js/bootstrap.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/bootsnav.js" type="text/javascript"></script>
<script src="<%=basePath %>js/jquery.js" type="text/javascript"></script>
<!--[if IE]><script src="js/html5.js"></script><![endif]-->
<title>注册</title>
</head>

<body class="logobg_style">
  <div id="large-header" class="large-header login-page">
  	<canvas id="demo-canvas" width="1590" height="711"></canvas>
  	<div class="Retrieve_style">
  	  <div class="Retrieve-content step-body" id="myStep">
  		<h1 class="title_name">找回密码</h1>
  		<div class="step-header"> <ul><li><p>短信验证</p></li><li><p>重置密码</p></li><li><p>找回成功</p></li></ul></div>
 		  <div class="step-content">
  			<div class="step-list login_padding">
  				<form method="post" class="">
				 <div class="form-group clearfix">
				 				 <div class="input-group">
					<div class="input-group-addon"><i class="icon_phone"></i></div>
                    <input type="text"  class="form-control text_phone"  name="bphone" id="phone"  placeholder="你的手机号" >
					</div>
				</div>
				<div class="form-group clearfix">
									<div class="input-group col-lg-8 col-md-8 col-xs-8">
						<div class="input-group-addon"><i class="icon_yanzhen"></i></div>
                        <input type="text" class="form-control " name="code" id="Verification"  placeholder="短信验证码" >
					</div>
                        <div class="col-lg-4 col-md-4 col-xs-4 fl"><input type="button" id="btn" class="btn_mfyzm" value="获取验证码" onclick="Sendpwd(this)"/></div>
				</div>
             <div class="tishi"></div>
             </form> 
            <div class="form-group">
					<button  class="btn btn-danger btn-block btn-login" id="applyBtn" >下一步</button>
				</div>	
			<div style="float:right">
					<a class="" href="ind" >返回首页</a>
				</div>
				<div style="float:left">
					<a class="" href="log" >返回登录</a>
				</div>
			</div>
			<div class="step-list">
				<form method="post" class="login_padding">
				  <div class="form-group clearfix">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="icon_password"></i>
						</div>
						<input type="password" class="form-control" name="bpwd" id="password" placeholder="确认密码" >
					</div>

				</div>
				<div class="form-group clearfix">
					<div class="input-group">
						<div class="input-group-addon">
							<i class="icon_password"></i>
						</div>
						<input type="password" class="form-control" name="bpwd" id="confirmpwd" placeholder="再次确认密码" >
					</div>
				</div>
				 <div class="tishis"></div>
				<div class="form-group">
					<a type="button" class="btn btn-danger btn-block btn-login" id="buttonBtn">下一步</a>
				</div>
				<div style="float:right"><a class="" href="ind" >返回首页</a></div>
				<div style="float:left"><a class="" href="log" >返回登录</a></div>
				</form>
				</div>
					<div class="step-list">
					<div class="ok_style center">
                            <h2><img src="<%=basePath %>images/ok.png"></h2>
	                        <h5 class="color2 mtb20">你已成功重置密码！</h5>
	                        <a href="ind" class="btn btn-danger">首页</a>
	                        <a href="log" class="btn btn-primary">返回登录</a>
					</div>

				</div>
			</div>
  		</div> 			
  </div>
 </div> 	
<script src="<%=basePath %>js/TweenLite/TweenLite.min.js"></script>
<script src="<%=basePath %>js/TweenLite/EasePack.min.js"></script>
<script src="<%=basePath %>js/TweenLite/rAF.js"></script>
<script src="<%=basePath %>js/TweenLite/demo-1.js"></script>
<script type="text/javascript">

</script>

</body>
</html>