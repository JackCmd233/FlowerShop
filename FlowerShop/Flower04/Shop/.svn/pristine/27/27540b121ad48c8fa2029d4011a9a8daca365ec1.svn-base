<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>搜索</title>

<script type="text/javascript" src="<%=basePath %>js/before/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/before/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/before/index.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/before/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/before/index.css">
</head>
<body>
	<!-- 类别框 -->
	<div class="type-box row">
		<div class="col-lg-6">
			  <a href="javascript:;" id="-1">全部</a> 
		</div>
	<c:forEach items="${goodsTypes }" var="sg" varStatus="status">
		<div class="col-lg-6">
			  <a href="javascript:;" id="${sg.tid}">${sg.typename}</a> 
		</div>
	</c:forEach>
	</div>
	
	<!-- 销量框 -->
	<div class="sale-box row">
			<div class="col-lg-6">
				  <a href="javascript:;"id="-1">全部</a> 
			</div>
			<div class="col-lg-6">
				  <a href="javascript:;"id="0-50">&lt; 50</a> 
			</div>
			<div class="col-lg-6">
				  <a href="javascript:;" id="50-100">50-100</a> 
			</div>
			<div class="col-lg-6">
				  <a href="javascript:;" id="100-200">100-200</a> 
			</div>
			<div class="col-lg-6">
				  <a href="javascript:;" id="200-">&gt;200</a> 
			</div>
	</div>

	<!-- 用户尚的用户下拉框 -->
	<ul class="user-box active">
		<li>
			<c:if test="${bruser!=null}">${bruser.bphone }</c:if>
			<c:if test="${bruser==null}"><a href="<%=basePath %>user/log"><img src="<%=basePath %>images/before/login.png" width="20px" height="20px;"><span class="user-box-name">登录</span></a></c:if>
		</li>
		<li>
		<c:if test="${bruser!=null}"><a href="<%=basePath %>user/exit">退出</a></c:if>
		<c:if test="${bruser==null}"><a href="<%=basePath %>toRegister"><img src="<%=basePath %>images/before/register.png" width="25px" height="25px;"><span class="user-box-name">注册</span></a>
		</c:if>
		</li>
		<li>
		<c:if test="${bruser!=null}"><a href="<%=basePath %>useC">用户中心</a></c:if>
		<c:if test="${bruser==null}"><a href="<%=basePath %>useC"><img src="<%=basePath %>images/before/usercontent.png" width="20px" height="20px;"><span class="user-box-name">用户中心</span></a>
		</c:if>
		
		</li>
	</ul>

	<!-- 头部 -->
	<div class="head">
		<img class="logo" src="<%=basePath %>images/before/mylogo.png">
		<div class="head-title">
			<a href="<%=basePath %>index2"><span>首页</span></a>
			<a href="<%=basePath %>search2/1"><span>所有花</span></a>
		</div>
		<div class="row">
			<div class="col-lg-3">
			    <div class="input-group" id="btn">
			    <input type="hidden" id="url" value="<%=basePath %>"/>
			      <input type="text" class="form-control" id="btn-content" placeholder="请输入您要查询的内容（花的名称或类型）">
			      <span class="input-group-btn">
			        <button class="btn btn-default" id="btn1" style="top: 0px;" type="button"><span>搜索</span></button>
			      </span>
			    </div>
			 </div>
		</div>
		<!-- 购物车 -->
		<a href="<%=basePath %>cart/selectCart"><img class="cart" src="<%=basePath %>images/before/cart.png" width="50px" height="50px"></a>
		<!-- 用户图标 -->
		<a href="javascript:;"><img src="<%=basePath %>images/before/user.png" class="user" ></a>
	</div>
	<!-- 搜索页面主内容 -->
	<div class="search-main">
		<div class="search-select ">
			<img src="<%=basePath %>images/before/fastchoose.PNG" width="100px" height="100px;">
			<div class="type-select type" >
				<span class="search-title-type">种类</span><br>
				<span class="search-type">全部</span><img src="<%=basePath %>images/before/search_type_down.png">
			</div>
			<div class="sale-select money">
				<span class="search-title-sale">价格</span><br>
				<span class="search-sale">全部</span><img src="<%=basePath %>images/before/search_sale_down.png">
			</div>
			
		</div>
		<div class="fenlan">
			<a href="<%=basePath %>search2/1" id="comprehensive " class="selected" style="margin-right: 10px;">全部</a>
			<a href="javascript:;" id="price"><span >价格</span></a>
			<a href="javascript:;" id="sales"><span >销量</span></a>
		</div>
		<div class="search-content row">
		<c:forEach items="${ goods }" var="sg" varStatus="status">
			<div class="col-md-3">
				<div class="item">
					<a href="<%=basePath %>/goodsDetail?id=${sg.id}"><img src="<%=basePath %>/logos/${sg.gpicture }" class="item-img"></a><br/>
					<span class="item-name">${sg.gname }</span><br/>
					<c:if test="${sg.grprice !=sg.goprice}"><span style="text-decoration:line-through ;color:#ccc;">￥${sg.goprice}</span>&nbsp;&nbsp;<span class="item-price">￥ ${sg.grprice}</span><br/></c:if>
					<c:if test="${sg.grprice ==sg.goprice}"><span class="item-price">￥ ${sg.goprice}</span><br/></c:if>
				</div>
			</div>
		</c:forEach>
		</div>
		<div class="btn-yema" id="${ pages }">
			<div class="btn-group page" id="${id}" role="group" aria-label="...">
			  <button type="button" class="btn btn-default" id="left">上一页</button>
			  <span class="btn">第<span class="currentIndex">${currentIndex}</span>页</span>
			  <button type="button" class="btn btn-default" id="right">下一页</button>
			</div>
		</div>
		
	</div>
	<!-- 底部 -->
	<div class="footer">
		<div class="footer-main">
			<span>Copyright © 2019 葱花房 All rights reserved.</span><br/>
			<span>Powered by Bo Wen Technology Co., Ltd.</span><br/>
			<span>工信部备：京ICP备xxx号-2</span><br/>
			<span>公安部备：xxxxx</span><br/>
		</div>
	</div>
</body>
</html>