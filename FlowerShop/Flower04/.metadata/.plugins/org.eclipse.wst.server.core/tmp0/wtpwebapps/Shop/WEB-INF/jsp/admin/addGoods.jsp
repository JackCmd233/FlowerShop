<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<title>添加商品信息页面（addGoods.jsp）</title>
<link href="css/admin/common.css" type="text/css" rel="stylesheet">
<script language="javascript" type="text/javascript">
	//判断所有信息是否都填了（判空）
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
	<form:form action="adminGoods/addGoods" method="post" modelAttribute="goods" enctype="multipart/form-data" onSubmit="return inputNull(this)">
		<table border=1 style="border-collapse: collapse" align="center">
			<caption>
				<font size=4 face=华文新魏>添加商品</font>
			</caption>
			<tr>
				<td>名称<font color="red">*</font></td>
				<td>
					<form:input path="gname"/> <!-- 绑定表单中的对象 -->
				</td>
			</tr>
			<tr>
				<td>价格<font color="red">*</font></td>
				<td>
					<form:input path="goprice"/>
				</td>
			</tr>
			<tr>
				<td>折扣价<font color="red">*</font></td>
				<td>
					<form:input path="gdprice"/>
				</td>
			</tr>
			<tr>
				<td>单位计量<font color="red">*</font></td>
				<td>
					<form:input path="gunit"/>
				</td>
			</tr>
			<tr>
				<td>库存<font color="red">*</font></td>
				<td>
					<form:input path="gstore"/>
				</td>
			</tr>
			<tr>
				<td>图片<font color="red">*</font></td>
				<td>
					<input type="file" name="logoImage"/>
				</td>
			</tr>
			<tr>
				<td>类型<font color="red">*</font></td>
				<td>
					<!-- 下拉选择框（商品类型） -->
					<form:select path="goodstype_tid">
         				<form:options items="${goodsType }" itemLabel="typename" itemValue="tid"/>
   					</form:select>
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