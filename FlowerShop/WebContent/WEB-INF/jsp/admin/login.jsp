<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>  
  <base href="<%=basePath%>">
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>管理员登录页面</title>
	<style type="text/css">
	table{
		text-align: center; 
	}
	.center-in-center{
            position: absolute;
            top: 16%;
            left: 30%;
    }
	.textSize{
		width: 150px;
		height: 25px;
	}
	* {
		margin: 0px;
		padding: 0px;
	}
	body {
		font-family: Arial, Helvetica, sans-serif;
		font-size: 12px;
		margin: 10px 10px auto;
		background-image: url(images/admin/t.jpg);
	}
	</style>
	<script type="text/javascript">
	//确定按钮
	function gogo(){
		document.forms[0].submit();
	}
	//取消按钮
	function cancel(){
		document.forms[0].action = "";
	}
	function inputNull(form){
		for(i=0;i<form.length;i++){
            //form属性的elements的首字母e要小写
			if(form.elements[i].value == ""){ 
				alert("请填写所有文本框！");
				form.elements[i].focus();	
				return false;
			}
		}
	}
	</script>
  </head>
  <body>
  	<form:form action="admin/login" modelAttribute="auser" method="post" onSubmit="return inputNull(this)">
  	<div class="center-in-center">
	<table>
		<tr>
			<td colspan="2"><img src="images/admin/admin.png"></td>
		</tr>
		<tr>
			<td>姓名：</td>
			<td>
				<form:input path="aname" cssClass="textSize"/>
			</td>
		</tr>
		<tr>
			<td>密码：</td>
			<td>
				<form:password path="apwd" cssClass="textSize" maxlength="20"/>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="提交" onclick="gogo()" >
				<input type="reset" value="取消" onclick="cancel()" >
			</td>
		</tr>
	</table>
	<span style="color:red;text-align:center">${msg }</span>
	</div>
	</form:form>
  </body>
</html>
