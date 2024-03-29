$(function(){
	//------------------------------主页
	// 点击用户图标，显示登录注册等信息
	var user = $('.user');
	var user_box = $('.user-box');
	var flag = 0;//没有点击时
	user_box.css({'display':'none'});//默认情况下的隐藏
	user.click(function(){
		if(flag==0){
			//当点击的时候，将用户框显示 并将flag=1
			user_box.css({'display':'block'});
			flag = 1;
		}else{
			user_box.css({'display':'none'});
			flag = 0;
		}
	});
	//公告的动态变换
	var length =  0;//公告的长度
	var isSpeed = -1;
	var len = "";
	var ul= $('.notice');//获取公告的ul
	var ul_html = ul.html();
	var li = $('.notice li');
	var li_length = li.length;//公告的Li的个数
	ul.html( ul_html +ul_html);
	function moving(){
		length = length + isSpeed;
		len = length + "px";
		if(length>-li_length*40){
			ul.css({'top':len});
		}
		if(length<=-li_length*40){//当Ul
			length=0;
			
			// clearInterval(time);
		}
	}
	$('.notice').mouseover(function(){
		isSpeed = 0;
	}) ;
	$('.notice').mouseout(function(){
		isSpeed = -1;
	})
	//设置定时器：
	var time = setInterval(moving,50);
	 //公告
	$('.notice').delegate('li','click',function(){
		var li_main = $('#li-main');//模态框的获取
		var id = $(this).attr("id");//当前的公告的id值
		//使用ajax向后端获取数据
		 $.ajax({
	            url: 'selectANotice/'+id,
	            type: 'get',
	            dataType: 'json',
	            success: function (data) {
	            	//将获取到的数据填充到公告的模态框中
	            	//公告标题
	            	$('.model_name').html(data.notice.ntitle);
	            	$('.model_content').html(data.notice.ncontent);//公告内容
	            	$('.model_time').html(data.notice.ntime);//公告时间
	            }
	        })
		li_main.html();
	});
	
	//----------------------------------------------搜索页面
	//当没有数据的时候将分页去掉

	if($('.search-content') == ''){
		$('.btn-yema').css({'display':'none'});
	}
	
	
	var search_type = -1;
	var search_sale = -1;
	var search_method = -1;
	var items = $('.item');//获取到填充位置
	//点击类别的时候显示所有的类别数据
	var flag_type = 0;
	var	type_box = $('.type-box');
	type_box.css({'display':'none'});//默认情况下隐藏
	$('.type').click(function(){
		if(flag_type==0){
			type_box.css({'display':'block'});
			flag_type =1;
		}else{
			type_box.css({'display':'none'});
			flag_type = 0;
		}
	});
	//当点击类别下面的花的种类的时候将选中的花种类替换“全部”
	$('.type-box').delegate('div','click',function(){
		$('.page').attr("id",2);//
		//当选中当前的种类之后替换字样
		$('.search-type').html($(this).children().html());
		//获取当前选中的元素的id值
		search_type = $(this).children().attr("id");
		//点击之后就将所有要查询的数据都返回给后端
		$.ajax({
            url: '/Shop/selectInfo/'+search_type+"/"+search_sale+"/"+search_method+"/1",
            type: 'get',
            dataType: 'json',
            success: function (data) {
            //设置
            	console.log(data)
            	$('.currentIndex').html(data.currentIndex);
            	$('.btn-yema').attr("id",data.page);
            //获取到的数据
            //清空html中原来的数据
	          $('.search-content').empty();
	         //动态生成数据
	          html = "";//最终填充到html页面上的所有字符串元素
	          for(var i=0;i<data.goods.length;i++){
	        	  html = html + "<div class='col-md-3'>"+
				"<div class='item'>"+
					"<a href='/Shop/goodsDetail?id="+data.goods[i].id+"'><img src='/Shop/logos/"+data.goods[i].gpicture+"' class='item-img'></a><br/>"+
					"<span class='item-name'>"+data.goods[i].gname+"</span><br/>";
	        	  if(data.goods[i].grprice != data.goods[i].goprice){
	        		  html = html +"<span style='text-decoration:line-through ;color:#ccc;'>￥"+data.goods[i].goprice.toFixed(1)+"</span>&nbsp;&nbsp;<span class='item-price'>￥"+ data.goods[i].grprice.toFixed(1)+"</span><br/>";
	        	  }else{
	        		  html = html + "<span class='item-price'>￥"+ data.goods[i].goprice.toFixed(1)+"</span><br/>"
	        	  }
	        	  html  = html + "</div></div>";  
	          }
	          //将元素添加到页面中
	          $('.search-content').append(html);
	          
            	
            }
        });
	
	});
		
	
	//点击销量的时候
	var flag_sale = 0;
	var sale_box = $('.sale-box')
	sale_box.css({'display':'none'});//默认情况下隐藏
	$('.money').click(function(){
		if(flag_sale==0){
			sale_box.css({'display':'block'});
			flag_sale =1;
		}else{
			sale_box.css({'display':'none'});
			flag_sale = 0;
		}
	});
	
	$('.sale-box').delegate('div','click',function(){
		$('.page').attr("id",2);
		//当选中当前的种类之后替换字样
		$('.search-sale').html($(this).children().html());
		search_sale = $(this).children().attr("id");
		
		//点击之后就将所有要查询的数据都返回给后端
		$.ajax({
            url: '/Shop/selectInfo/'+search_type+"/"+search_sale+"/"+search_method+"/1",
            type: 'get',
            dataType: 'json',
            success: function (data) {
            	//获取到的数据
                //清空html中原来的数据
            	$('.currentIndex').html(data.currentIndex);
            	$('.btn-yema').attr("id",data.page);
    	          $('.search-content').empty();
    	         //动态生成数据
    	          html = "";//最终填充到html页面上的所有字符串元素
    	          for(var i=0;i<data.goods.length;i++){
    	        	  html = html + "<div class='col-md-3'>"+
    				"<div class='item'>"+
    					"<a href='/Shop/goodsDetail?id="+data.goods[i].id+"'><img src='/Shop/logos/"+data.goods[i].gpicture+"' class='item-img'></a><br/>"+
    					"<span class='item-name'>"+data.goods[i].gname+"</span><br/>";
    	        	  if(data.goods[i].grprice != data.goods[i].goprice){
    	        		  html = html +"<span style='text-decoration:line-through ;color:#ccc;'>￥"+data.goods[i].goprice.toFixed(1)+"</span>&nbsp;&nbsp;<span class='item-price'>￥"+ data.goods[i].grprice.toFixed(1)+"</span><br/>";
    	        	  }else{
    	        		  html = html + "<span class='item-price'>￥"+ data.goods[i].goprice.toFixed(1)+"</span><br/>"
    	        	  }
    	        	  html  = html + "</div></div>";  
    	          }
    	          //将元素添加到页面中
    	          $('.search-content').append(html);
    	          
            }
        });
	});
	
	//搜索页面的搜索框的点击事件
	var btn1 = $('#btn1');
	var url = $('#url').val();//获取根目录
	btn1.click(function(){
		//当点击之后就跳转到收缩页面并提交输入框中的信息
		var btn_content = $('#btn-content').val();//获取搜索输入框中的数据
		if(btn_content == ''){ //当没有输入数据的时候就点击搜索的时候，将不采取任何事件
			return;
		}
		location.href= url+"search/"+btn_content;
	});
	//当点击价格 销量或全部的时候将被点击的元素的颜色高亮 但是是其他同辈的元素变成黑色
	$('.fenlan').delegate('a','click',function(){
		//当选中当前的种类之后替换字样
		$('.page').attr("id",2);
		$(this).addClass('selected').siblings().removeClass('selected');
		search_method = $(this).attr("id");
		//点击之后就将所有要查询的数据都返回给后端
		$.ajax({
            url: '/Shop/selectInfo/'+search_type+"/"+search_sale+"/"+search_method+"/1",
            type: 'get',
            dataType: 'json',
            success: function (data) {
            	//获取到的数据
                //清空html中原来的数据
            	$('.currentIndex').html(data.currentIndex);
            	$('.btn-yema').attr("id",data.page);
    	          $('.search-content').empty();
    	         //动态生成数据
    	          html = "";//最终填充到html页面上的所有字符串元素
    	          for(var i=0;i<data.goods.length;i++){
    	        	  html = html + "<div class='col-md-3'>"+
    				"<div class='item'>"+
    					"<a href='/Shop/goodsDetail?id="+data.goods[i].id+"'><img src='/Shop/logos/"+data.goods[i].gpicture+"' class='item-img'></a><br/>"+
    					"<span class='item-name'>"+data.goods[i].gname+"</span><br/>";
    	        	  if(data.goods[i].grprice != data.goods[i].goprice){
    	        		  html = html +"<span style='text-decoration:line-through ;color:#ccc;'>￥"+data.goods[i].goprice.toFixed(1)+"</span>&nbsp;&nbsp;<span class='item-price'>￥"+ data.goods[i].grprice.toFixed(1)+"</span><br/>";
    	        	  }else{
    	        		  html = html + "<span class='item-price'>￥"+data.goods[i].goprice.toFixed(1)  +"</span><br/>"
    	        	  }
    	        	  html  = html + "</div></div>";  
    	          }
    	          //将元素添加到页面中
    	          $('.search-content').append(html);
    	          
            }
        });
	});
	
	//页码
	//上一页
	$('#left').click(function(){
		//获取当前的页码数
		var url = null;
		var  currentIndex = $('.currentIndex').html();
		//上一页判断
		//当前页数是1的时候按上一页无效
		if(currentIndex == '1'){
			return;
		}
		//判断应该发送数据给哪个url
		//获取id值
		var id = $('.page').attr("id");
		var leftpage = parseInt(currentIndex)-1;
		if(id == 0){
			//id值是0的时候是向热销的数据进行排行
			url = "/Shop/search/more/hot/"+leftpage;
			location.href = url;//修改当前的页数
		}else if(id == 1){
			url = "/Shop/search/more/popularity/"+leftpage;
			location.href = url;//修改当前的页数
		}else if(id =='2'){
			url = '/Shop/selectInfo/'+search_type+"/"+search_sale+"/"+search_method+"/"+leftpage;
			$.ajax({
	            url: url,
	            type: 'get',
	            dataType: 'json',
	            success: function (data) {
	            	//获取到的数据
	                //清空html中原来的数据
	            	$('.currentIndex').html(data.currentIndex);
	            	$('.btn-yema').attr("id",data.page);
	    	         $('.search-content').empty();
	    	         //动态生成数据
	    	          html = "";//最终填充到html页面上的所有字符串元素
	    	          for(var i=0;i<data.goods.length;i++){
	    	        	  html = html + "<div class='col-md-3'>"+
	    				"<div class='item'>"+
	    					"<a href='/Shop/goodsDetail?id="+data.goods[i].id+"'><img src='/Shop/logos/"+data.goods[i].gpicture+"' class='item-img'></a><br/>"+
	    					"<span class='item-name'>"+data.goods[i].gname+"</span><br/>";
	    	        	  if(data.goods[i].grprice != data.goods[i].goprice){
	    	        		  html = html +"<span style='text-decoration:line-through ;color:#ccc;'>￥"+data.goods[i].goprice.toFixed(1)+"</span>&nbsp;&nbsp;<span class='item-price'>￥"+ data.goods[i].grprice.toFixed(1)+"</span><br/>";
	    	        	  }else{
	    	        		  html = html + "<span class='item-price'>￥"+data.goods[i].goprice.toFixed(1)  +"</span><br/>"
	    	        	  }
	    	        	  html  = html + "</div></div>";  
	    	          }
	    	          //将元素添加到页面中
	    	          $('.search-content').append(html);
	    	      
	            }
	        });
			
		}else if(id == '3'){
			console.log("demo44444")
			url = "/Shop/search2/"+leftpage;
			location.href = url;//修改当前的页数
		}
	});
	
	
	//下一页
	$('#right').click(function(){
		//获取当前的页码数
		var url = null;
		var  currentIndex = $('.currentIndex').html();
		//下一页
		//当前页数是1的时候按上一页无效
		//获取全部的页数
		if(parseInt(currentIndex) >= parseInt($('.btn-yema').attr("id"))){
			return;
		}
		//判断应该发送数据给哪个url
		//获取id值
		var id = $('.page').attr("id");
		var nextpage = parseInt(currentIndex)+1;
		if(id == '0'){
			//id值是0的时候是向热销的数据进行排行
			url = "/Shop/search/more/hot/"+nextpage;
			location.href = url;//修改当前的页数
		}else if(id == '1'){
			url = "/Shop/search/more/popularity/"+nextpage;
			location.href = url;//修改当前的页数
		}else if(id == '2'){
			url = '/Shop/selectInfo/'+search_type+"/"+search_sale+"/"+search_method+"/"+nextpage;
			$.ajax({
	            url: url,
	            type: 'get',
	            dataType: 'json',
	            success: function (data) {
	            	//获取到的数据
	                //清空html中原来的数据
	            	$('.currentIndex').html(data.currentIndex);
	            	$('.btn-yema').attr("id",data.page);
	    	         $('.search-content').empty();
	    	         //动态生成数据
	    	          html = "";//最终填充到html页面上的所有字符串元素
	    	          for(var i=0;i<data.goods.length;i++){
	    	        	  html = html + "<div class='col-md-3'>"+
	    				"<div class='item'>"+
	    					"<a href='/Shop/goodsDetail?id="+data.goods[i].id+"'><img src='/Shop/logos/"+data.goods[i].gpicture+"' class='item-img'></a><br/>"+
	    					"<span class='item-name'>"+data.goods[i].gname+"</span><br/>";
	    	        	  if(data.goods[i].grprice != data.goods[i].goprice){
	    	        		  html = html +"<span style='text-decoration:line-through ;color:#ccc;'>￥"+data.goods[i].goprice.toFixed(1)+"</span>&nbsp;&nbsp;<span class='item-price'>￥"+ data.goods[i].grprice.toFixed(1)+"</span><br/>";
	    	        	  }else{
	    	        		  html = html + "<span class='item-price'>￥"+data.goods[i].goprice.toFixed(1)  +"</span><br/>"
	    	        	  }
	    	        	  html  = html + "</div></div>";  
	    	          }
	    	          //将元素添加到页面中
	    	          $('.search-content').append(html);
	    	      
	            }
	        });
		}else if (id =='3'){
			url = "/Shop/search2/"+nextpage;
			location.href = url;//修改当前的页数
		}
	});
	
	//用户中心设置
	//点击标签显示子标签
	$('.leftSide').delegate('li','click',function(){
		$(this).addClass("leftSideActive").siblings().removeClass("leftSideActive");	
		var className = $(this).attr("class").split(" ")[0]+"-main";
		$('.'+className).css({'display':'block'}).siblings().css({'display':'none'});
	});
	//订单中心
	var orderFlag = 0;//默认是子标签不显示的
	$('.orders').click(function(){
		//点击订单显示订单下的子页面
		if(orderFlag == 0){
			$('.paid').fadeIn();
			$('.unpaid').fadeIn();
			$('.order').fadeIn();
			orderFlag = 1;
		}else{
			$('.paid').fadeOut();
			$('.unpaid').fadeOut();
			$('.order').fadeOut();
			orderFlag = 0;
		}
		
	});
	//账户设置
	var accountFlag = 0;
	$('.AccountSetting').click(function(){
		//点击订单显示订单下的子页面
		if(accountFlag == 0){
			$('.personInfo').fadeIn();
			$('.address').fadeIn();
			$('.password').fadeIn();
			accountFlag = 1;
		}else{
			$('.personInfo').fadeOut();
			$('.address').fadeOut();
			$('.password').fadeOut();
			accountFlag = 0;
		}
		
	});
	//---------下订单详情页OrderDetail-----------------------
	//一进入页面就先判断地址栏中是否有数据
	

	$.ajax({
		 url: "/Shop/getAddressInfo",
         type: 'get',
         dataType: 'json',
		success:function (data) {
			//填充到模态框
			html="";
			for(var i=0;i<data.address.length;i++){
				html= html + "<li class='col-md-3' id='name-"+data.address[i].id+"'>"+data.address[i].receiver+"</li>"+
					  "<li class='col-md-3' id='phone-"+data.address[i].id+"'>"+data.address[i].receiverphone+"</li>"+
					  "<li class='col-md-3' id='address-"+data.address[i].id+"'>"+data.address[i].address+"</li>"+
					 "<li class='col-md-3' ><button  id='"+data.address[i].id+"' type='button' class='btn btn-default' data-dismiss='modal'>选择</button></li>";
			}
			$('.model-table').append(html);//将数据插入到页面中
			
		}
	});
		
	//点击
	$('.model-table').delegate('li button','click',function(){
		var id = $(this).attr("id");
		var name = $('#name-'+id).html();
		var phone = $('#phone-'+id).html();
		var address = $('#address-'+id).html();
		$('.detail-name').html(name);
		$('.detail-phone').html(phone);
		$('.detail-address').html(address);
		$('.detail-name').attr("id",id);
	});
	
	
	//未支付的订单商品的价格总和
	var goodOrderCounts = $('.no-paid-orderDetail .goods-ordercount');
	var sum = 0;
	for(var i=0;i<goodOrderCounts.length;i++){
		sum = sum +parseFloat(goodOrderCounts.eq(i).html());
		
	}
	$('.sum-paid').html(sum);
	
	//点击支付的时候添加边框,支付方式
	$('.pay-method').delegate('img','click',function(){
		$(this).addClass('add').siblings().removeClass('add');
		
	});
})