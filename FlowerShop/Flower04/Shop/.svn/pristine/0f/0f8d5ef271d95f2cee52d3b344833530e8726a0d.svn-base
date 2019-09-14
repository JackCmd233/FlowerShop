<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品类型页面</title>
<link href="css/admin/common.css" type="text/css" rel="stylesheet">
<script language="javascript" type="text/javascript">
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
	<form:form action="adminType/addType" method="post" modelAttribute="goodstype" enctype="multipart/form-data" onSubmit="return inputNull(this)">
	<table border=1 style="border-collapse: collapse" align="center">
			<caption>
				<font size=4 face=华文新魏>添加类型</font>
			</caption>
			<tr>
				<td>名称<font color="red">*</font></td> 
				<td>
					<form:input path="typename"/>
				</td>
			</tr>
			<tr>
				<td>编号<font color="red">*</font></td>
				<td>
					<form:input path="tid"/>
				</td>
			</tr>
			<tr> 
				<td>描述<font color="red">*</font></td>
				<td> 
					<form:textarea path="describ"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" value="添加"/>
				</td>
				<td align="left">
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table> 
	</form:form>
</body>
</html>