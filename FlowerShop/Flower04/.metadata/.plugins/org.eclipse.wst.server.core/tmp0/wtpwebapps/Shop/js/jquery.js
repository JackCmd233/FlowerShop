//登录操作
$(document).ready(function(){
if(screen.width < 780 && $(window).width() < 780)
{
	$(".content_list").hide();

}else{
	$(".content_list").show();
}
     $(window).resize(function(){	
	 $(".content_list").show();
	 });
});
//登录操作
var phone =/[1][3-9][0-9]{9,9}$/;
var validCode=true;
function cliLogin() {
	var txtUser = $.trim($("#username").val());
	var txtPwd = $("#password").val();
	if ($.trim(txtUser) == "") {
		Tip('请输入你的手机号');
		$("#txtUser").focus();
		return false;
		
	}
	if(!phone.exec(txtUser)){
			Tip('手机输入格式不正确,请重新输入');
			$("#txtUser").focus();
		return false;
		}
	
	if ($.trim(txtPwd) == "") {
		Tip('请输入密码！');
		$("#Userpwd").focus();
		return false;
	}
	$.ajax({
	    url :'/Shop/user/loginin',// 获取自己系统后台用户信息接口
	    data :{username:txtUser,password:txtPwd},
	    type : 'post',
	    success : function(data) {
	        if (data){
	            if (data == "1" ) { //判断返回值，这里根据的业务内容可做调整
	            	//alert(data);
	                window.location.href = "/Shop/index2";//指向登录的页面地址
	            } else if(data == "-1" ){ 
	                Tip("该用户已被限制登录！") 
	            } else{
	                //alert(data);
	                //alert("登录失败，请重试!");
	                Tip('密码错误！');//显示登录失败的原因
	            }
	            }
	        },
	    error : function(data){
	           console.log(data.status);
               console.log(data.responseText);
	        alert("未知错误");
	        }
	});
	return;
}



//注册操作
var yzm = null;
//查询手机号
function selectuser(){
	$.ajax({
	    url :'selectuser',// 获取自己系统后台用户信息接口
	    data :{phone:$("#phone").val()},
	    type : 'post',
	    success : function(data) {
	        if (data){
	            if (data == "1") { //判断返回值，这里根据的业务内容可做调整
	                Tip('该手机号已注册！');
	                } 
	            }
	        },
	    error : function(data){
	           console.log(data.status);
	           console.log(data.responseText);
	        alert("未知错误");
	        }
	});
}

function Sendpwd(sender) {
	var time=60;
	var phone =/[1][3-9][0-9]{9,9}$/;
	var phones = $.trim($("#phone").val());
	if ($.trim(phones) == "") {
		Tip('请填写手机号码！');
		$("#phone").focus();
		return;
	}
	if(!phone.exec(phones)){
		Tip('手机输入格式不正确,请重新输入');
		$("#phones").focus();
	return;
	}
	
	
    //发送验证码
	$(function(){
	        $.ajax({
	        url:'send',//ajax提交表单
	        data:{phone:$("#phone").val()},
	        type:"post",
	        success:function(data){
	           if(data==0){
	        	   Tip('发送失败！');
	           }else
	        	   Tip('验证码已发送！');
	           alert(data);
	           yzm = data;
	        },
	        error:function(){
	            alert("未知错误！");
	       }
	    });
	});

	//倒计时功能
	var code=$(sender);
		if (validCode) {
			validCode=false;
			code.addClass("msgs1").attr("disabled",true);;//添加类
		var t=setInterval(function  () {
			time--;
			code.val(time+"秒");
			if (time==0) {
				clearInterval(t);
			code.val("重新获取");
				validCode=true;
			code.removeClass("msgs1").attr("disabled",false);//移除类

			}
		},1000);
    }
}

function Tip(msg) {
	$(".tishi").show(200).delay(1000).hide(200).html("<div class='prompt'><i class='tishi_icon'></i>"+msg+"</div>");
}
function Tips(msg) {
	
	$(".tishis").show(200).delay(1000).hide(200).html("<div class='prompt'><i class='tishi_icon'></i>"+msg+"</div>");
}
jQuery(function(){
	"use strict";
		$(".navList .navLi").hover(function(){
		$(this).addClass("active");
		$(this).find(".navSub").stop().slideDown();	
	},function(){
		$(this).removeClass("active");
		$(this).find(".navSub").stop().slideUp();
		$(".navThrList").slideUp();
		$(".navFouList").slideUp();
	});
	function scro(){
			if($(document).scrollTop()>50){$(".headerbg").addClass("active");}else{$(".headerbg").removeClass("active");}
		}
		scro();
		$(window).scroll(function(){
			scro();
		});
			$(".benefits_name").hover(function(){
			$(this).addClass("hover");
			$(this).stop().animate({bottom: "0px", opacity:1 , height:"400px"}, "fast");
		},function(){
			$(this).removeClass("hover");
			$(this).stop().animate({bottom: "0px", opacity:1 , height:"400px"}, "fast") ; 			
		}
	);
		$(".Program_name ").hover(function() {
	    $(this).addClass("hover");
		$(this).find(".Program_title").stop()
		.animate({ opacity:1 , height:"100%"}, "fast")
		.css("display","block");

	}, function() {
	    $(this).removeClass("hover");  
		$(this).find(".Program_title").stop()
		.animate({ opacity: 1,height:"40px"}, "fast")
		.css("display","block");
	});
		$(".user_casestyle").hover(function(){
			$(this).addClass("hover");
			$(this).find(".hd a").css("display","block");
			//$(this).stop().animate({bottom: "0px", opacity:1 , height:""}, "fast")
		},function(){
			$(this).removeClass("hover");
			$(this).find(".hd a").css("display","none");
			//$(this).stop().animate({bottom: "0px", opacity:1 , height:""}, "fast")  			
		}
	);
	//置顶图标显示
$('#top-back').hide();
$(window).scroll(function(){
	 if($(this).scrollTop() > 350){
		$("#top-back").fadeIn();
	 }
	 else{
		$("#top-back").fadeOut();
	 }
  });
$(".bannerNimg").css("background-image", "url(" + $(".bannerNimg").find("img").attr("src") + ")");
//置顶事件
function topBack(){
  $('body,html').animate({scrollTop:0},300);
}
});

$.fn.countTo = function (options) {
	"use strict";
	options = options || {};	
	return $(this).each(function () {
		// set options for current element
		var settings = $.extend({}, $.fn.countTo.defaults, {
			from:            $(this).data('from'),
			to:              $(this).data('to'),
			speed:           $(this).data('speed'),
			refreshInterval: $(this).data('refresh-interval'),
			decimals:        $(this).data('decimals')
		}, options);
		
		// how many times to update the value, and how much to increment the value on each update
		var loops = Math.ceil(settings.speed / settings.refreshInterval),
			increment = (settings.to - settings.from) / loops;
		
		// references & variables that will change with each update
		var self = this,
			$self = $(this),
			loopCount = 0,
			value = settings.from,
			data = $self.data('countTo') || {};
		
		$self.data('countTo', data);
		
		// if an existing interval can be found, clear it first
		if (data.interval) {
			clearInterval(data.interval);
		}
		data.interval = setInterval(updateTimer, settings.refreshInterval);
		
		// initialize the element with the starting value
		render(value);
		
		function updateTimer() {
			value += increment;
			loopCount++;
			
			render(value);
			
			if (typeof(settings.onUpdate) == 'function') {
				settings.onUpdate.call(self, value);
			}
			
			if (loopCount >= loops) {
				// remove the interval
				$self.removeData('countTo');
				clearInterval(data.interval);
				value = settings.to;
				
				if (typeof(settings.onComplete) == 'function') {
					settings.onComplete.call(self, value);
				}
			}
		}
		
		function render(value) {
			var formattedValue = settings.formatter.call(self, value, settings);
			$self.html(formattedValue);
		}
	});
};

$.fn.countTo.defaults = {
	from: 0,               // the number the element should start at
	to: 0,                 // the number the element should end at
	speed: 300,           // how long it should take to count between the target numbers
	refreshInterval: 100,  // how often the element should be updated
	decimals: 0,           // the number of decimal places to show
	formatter: formatter,  // handler for formatting the value before rendering
	onUpdate: null,        // callback method for every time the element is updated
	onComplete: null       // callback method for when the element finishes updating
};

function formatter(value, settings) {
	return value.toFixed(settings.decimals);
}