<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>addNotice.jsp</title>
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
	<form:form action="adminNotice/addNotice" method="post" modelAttribute="notice" onSubmit="return inputNull(this)">
		<table border=1 style="border-collapse: collapse" align="center">
			<caption>
				<font size=4 face=华文新魏>添加公告</font>
			</caption>
			<tr>
				<td>标题<font color="red">*</font></td>
				<td>
					<form:input path="ntitle"/>
				</td>
			</tr>
			<tr>
				<td>内容<font color="red">*</font></td>
				<td>
					<form:textarea path="ncontent"/>
				</td>
			</tr>
			<tr>
				<td align="center">
					<input type="submit" value="提交"/>
				</td>
				<td align="left">
					<input type="reset" value="重置"/>
				</td>
			</tr>
		</table>
	</form:form>
</body>
</html>
