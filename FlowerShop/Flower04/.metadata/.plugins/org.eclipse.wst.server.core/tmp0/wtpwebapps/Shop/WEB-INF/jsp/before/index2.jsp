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
<title>首页</title>
<script type="text/javascript" src="<%=basePath %>js/before/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/before/bootstrap.min.js"></script>
<script type="text/javascript" src="<%=basePath %>js/before/index.js"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/before/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/before/index.css">
<script type="text/javascript">
$(function(){
	//设置图片的宽度：
	$('.box-img').css({'width':$(window).width()});
	$('.box').css({'width':$(window).width()});
	$('.headd-row').css({'width':$(window).width()});
	$('.swiper-row').css({'width':$(window).width()});
	var li = $('.box li');
    var len = li.length;
    var point = $('.point');
    var nowli = 0;
    var prevli= 0;
    var left = $('.left');
    var right = $('.right');
    var timer = null;
    var box = $('.main');
    var ismoving  = false;
    li.not(':first').css({'left':$(window).width()});
    for(var i=0;i<len;i++){
      var newli = $('<li>')
      if (i==0){
        newli.addClass('active');
      }
      newli.appendTo(point);

    }
    
    var point_con =$('.point li');
    //向前的按钮点击时切换
    left.click(function(){
      
      nowli--;
      move();
      point_con.eq(nowli).addClass('active').siblings().removeClass('active');

    })
    right.click(function() {
      nowli++;
      move();
      point_con.eq(nowli).addClass('active').siblings().removeClass('active');
    })

    //小原点点击事件
    
    point_con.click(function(){
      nowli = $(this).index();
      point_con.eq(nowli).addClass('active').siblings().removeClass('active');
      if(nowli==prevli){
        return;
      }
      move();
      
    })
    function autoplay(){
      nowli++;
      move();
      point_con.eq(nowli).addClass('active').siblings().removeClass('active');

    }

    timer = setInterval(autoplay,3000);

    box.mouseenter(function(){
      clearInterval(timer);
    });
    box.mouseleave(function(){
      timer = setInterval(autoplay,3000);
    });

    function move(){
      //第一张幻灯片往前的时候
      if(nowli<0){
        nowli = len-1;
        prevli = 0;
        li.eq(nowli).css({'left':-$(window).width()});
        li.eq(nowli).animate({'left':0});
        li.eq(prevli).animate({'left':$(window).width()});
        prevli= nowli;
        return;
      }
      //最后一张幻灯片往后的时候
      if(nowli>len-1){
        nowli = 0;
        prevli = len-1;
        li.eq(nowli).css({'left':$(window).width()});
        li.eq(nowli).animate({'left':0});
        li.eq(prevli).animate({'left':-$(window).width()});
        prevli= nowli;
        return;
      }
      if(nowli>prevli){
        li.eq(nowli).css({'left':$(window).width()})
        li.eq(nowli).animate({'left':0});
        li.eq(prevli).animate({'left':-$(window).width()})
        prevli = nowli;

      }else{
        li.eq(nowli).css({'left':-$(window).width()});
        li.eq(nowli).animate({'left':0});
        li.eq(prevli).stop().animate({'left':$(window).width()});
        prevli = nowli;
      }
      

      
    }
    
  })
	</script>
	<style type="text/css">
		 .box{
     position: relative;
    left: -355px;
    top: -49px;
    width: 1519.2px;
    height: 396px;
    background-color: pink;
    border: 1px solid #ccc;
    margin: 50px auto 0;
    padding: 0;
    overflow: hidden;
    z-index: 777;

    }
    .box li{
      position: absolute;
      left: 0;
      top: 0;
      list-style: none;
      float: left;
    }
    .point{
         position: absolute;
    top: 316px;
    left: -100%;
    list-style: none;
    display: block;
    width: 100px;
    height: 20px;
    padding: 0;
    z-index: 9999;
    }
    .point li{
      width: 10px;
      height: 10px;
      background-color: #fff;
      border-radius: 10px;
      float: left;
      margin-right: 5px;
      opacity: 0.3;
      z-index:99999;
    }
    
    .point .active{
      opacity: 1;
    }
    .arrow{
    position: absolute;
    top: 159px;
    left: -30px;
    width: 841px;
    height: 50px;

    }
    .main {
    position: relative;
    top: 0px;
    width: 300px;
    left: 354px;
}
	</style>
</head>
<body>
	<!-- 用户尚未登录的用户下拉框 -->
	<ul class="user-box active">
		<li>
			<c:if test="${bruser!=null}"> ${bruser.bphone }</c:if>
			<c:if test="${bruser==null}"><a href="<%=basePath %>user/log"><img src="<%=basePath %>images/before/login.png" width="20px" height="20px;"><span class="user-box-name">登录</span></a></c:if>
		</li>
		<li>
		<c:if test="${bruser!=null}"><a href="<%=basePath %>user/exit">退出</a></c:if>
		<c:if test="${bruser==null}"><a href="<%=basePath %>user/regi"><img src="<%=basePath %>images/before/register.png" width="25px" height="25px;"><span class="user-box-name">注册</span></a>
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
			<a href="index2"><span>首页</span></a>
			<a href="<%=basePath %>search2/1"><span>所有花</span></a>
		</div>
		<div class="row headd-row">
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
	<!-- 轮播图 -->
	
	<div class="row swiper-row">
		<div class="col-md-12">
			<div class="swiper">
			<div class="main">
			    <ul class="box">
			      <li><a href="#"><img src="<%=basePath %>images/before/index_1.jpg" class="box-img" height="396px"></a></li>
			      <li><a href="#"><img src="<%=basePath %>images/before/index_2.jpg" class="box-img" height="396px"></a></li>
			      <li><a href="#"><img src="<%=basePath %>images/before/index_3.jpg" class="box-img" height="396px"></a></li>
			    </ul>
			    <ul class="point"></ul>
	  		</div>
			</div>
		</div>
	</div>
	
	<!-- 公告 -->
	<div class="notice-main">
		<img src="<%=basePath %>images/before/notice.png" style="float:left">
		<div  class="box2">
		<ul class="notice" data-toggle="modal" data-target="#myModal">
		<c:forEach items="${noticelist}" var="nt">
		<li id="${nt.id }">
			<a href="javascript:;">
				<span class="notice-title" >${nt.ntitle }</span>
			</a>
		</li><br/>
		</c:forEach>

		</ul>
		
	<!-- Modal 点击显示相应的公告信息-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">公告</h4>
	      </div>
	      <div class="modal-body" id="li-main">
	    	<div class="model_main">
	    		<h4 class="model_name">公告标题</h4>
	    		<div class="model_content">公告内容</div>
	    		<div class="model_time">公告时间</div>	
	    	</div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	      </div>
	    </div>
	  </div>
	</div>
	</div>
		
	</div>


	<!-- 热销商品 -->
	<div class="hot">
		<div class="hot-title">
			<span class="hot-name">热销商品</span>
			<a href="<%=basePath %>search/more/hot/1"  class="more">更多>></a>
		</div>
		<!-- 获取销量前8的商品 -->
		<div class="hot-main row">
		<c:forEach items="${salelist }" var="sg" varStatus="status">
			<div class="col-md-3">
				<div class="item">
					<a href="<%=basePath %>goodsDetail?id=${sg.id }"><img src="logos/${sg.gpicture}" class="item-img"></a><br/>
					<span class="item-name">${sg.gname }</span><br/>
					<c:if test="${sg.grprice !=sg.goprice}"><span style="text-decoration:line-through ;color:#ccc;">￥${sg.goprice}</span>&nbsp;&nbsp;<span class="item-price">￥ ${sg.grprice}</span><br/></c:if>
					<c:if test="${sg.grprice ==sg.goprice}"><span class="item-price">￥ ${sg.goprice}</span><br/></c:if>
					<c:if test="${sg.shopnumber !=null}"><span class="item-sale">销量:${sg.shopnumber }</span></c:if>
					<c:if test="${sg.shopnumber ==null}"><span class="item-sale">销量:0</span></c:if>
					
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
	<!-- 人气商品 -->
	<div class="popularity">
		<div class="hot-title">
			<span class="hot-name">人气商品</span>
			<a href="<%=basePath %>search/more/popularity/1"  class="more">更多>></a>
		</div>
		<div class="popularity-main row">
			<c:forEach items="${focuslist }" var="sg" varStatus="status">
			<div class="col-md-3">
				<div class="item">
					<a href="<%=basePath %>goodsDetail?id=${sg.id }"><img src="logos/${sg.gpicture}" class="item-img"></a><br/>
					<span class="item-name">${ sg.gname }</span><br/>
					<c:if test="${sg.grprice !=sg.goprice}"><span style="text-decoration:line-through ;color:#ccc;">￥${sg.goprice}</span>&nbsp;&nbsp;<span class="item-price">￥ ${sg.grprice}</span><br/></c:if>
					<c:if test="${sg.grprice ==sg.goprice}"><span class="item-price">￥ ${sg.goprice}</span><br/></c:if>
					<c:if test="${sg.gfocusnum !=null}"><span class="item-sale">关注数:${sg.gfocusnum }</span></c:if>
					<c:if test="${sg.gfocusnum ==null}"><span class="item-sale">关注数:0</span></c:if>
				</div>	
			</div>
			</c:forEach>
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