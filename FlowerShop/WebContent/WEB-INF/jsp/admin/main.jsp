<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- request.getSchema()可以返回当前页面使用的协议，http 或是 https;
request.getServerName()可以返回当前页面所在的服务器的名字;
request.getServerPort()可以返回当前页面所在的服务器使用的端口,就是80;
request.getContextPath()可以返回当前页面所在的应用的名字;-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <!-- base标签是一个基本链接标记，网页上的所有相对路径在链接时都将在前面加上基链接指向的地址 -->
<base href="<%=basePath%>">
<title>后台主页面</title>
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	font-size: 12px;
	margin: 0px auto;
	height: auto;
	width: 1300px;
	border: 1px solid #006633;
}

#header {
	height: 90px;
	width: 1300px;
	background-image: url(images/admin/bb1.jpg);
	margin: 0px 0px 3px 0px;
}

#header h1 {
	text-align: center;
	font-family: 楷体;
	color: #000000;
	font-size: 50px；
}

#navigator {
	height: 25px;
	width: 1300px;
	font-size: 14px;
	background-image: url(images/admin/bb1.jpg);
}
#navigator ul {
	list-style-type: none;
}
#navigator li {
	float: left;
	position: relative;
}
#navigator li a {
	color: #ffffff;
	text-decoration: none;
	padding-top: 4px;
	display: block;
	width: 98px;
	height: 22px;
	text-align: center;
	background-color: #336666;
	margin-left: 2px;
}
#navigator li a:hover {
	background-color: #3d7878;
	color: #ffffff;
}
#navigator ul li ul {
   visibility: hidden;
   position: absolute;
}

#navigator ul li:hover ul,
#navigator ul a:hover ul{
   visibility: visible;
}

#content {
	height: auto;
	width: 1300px;
	padding: 10px;
}

#content iframe {
	height: 400px;
	width: 1300px;
}

#footer {
	height: 30px;
	width: 1280px;
	line-height: 2em;
	text-align: center;
	background-color: #336666;
	padding: 10px;
}
</style>
</head>
<body>
	<div id="header">
		<br>
		<br>
	</div>
	<div id="navigator">
		<ul>
			<li><a>商品管理</a>
				<ul>
					<li><a href="adminGoods/selectGoods" target="center">商品详情</a></li>
					<li><a href="adminGoods/toAddGoods" target="center">添加商品</a></li>
					<li><a href="adminGoods/selectGoods?act=deleteSelect" target="center">删除商品</a></li>
					<li><a href="adminGoods/selectGoods?act=updateSelect" target="center">修改商品</a></li>
				</ul>
			</li>
			<li><a>类型管理</a>
				<ul>
					<li><a href="adminType/toAddType" target="center">添加类型</a></li>
					<li><a href="adminType/toDeleteType" target="center">删除类型</a></li>
				</ul>
			</li>
			<li><a>用户管理</a>
				<ul>
					<li><a href="adminUser/userInfo" target="center">删除用户</a></li>
				</ul>
			</li>
			<li><a>订单管理</a>
				<ul>
					<li><a href="adminOrder/orderInfo" target="center">删除订单</a></li>
				</ul>
			</li>
			<li><a>公告管理</a>
				<ul>
					<li><a href="adminNotice/toAddNotice" target="center">添加公告</a></li>
					<li><a href="adminNotice/deleteNoticeSelect" target="center">删除公告</a></li>
				</ul>
			</li>
			<li><a href="exit">安全退出</a></li>
		</ul>
		
	</div>
	<div id="content">
		<iframe src="adminGoods/selectGoods"  name="center" frameborder="0"></iframe>
	</div>
	<div id="footer">@湖南理工学院信息学院</div>
</body>
</html>


