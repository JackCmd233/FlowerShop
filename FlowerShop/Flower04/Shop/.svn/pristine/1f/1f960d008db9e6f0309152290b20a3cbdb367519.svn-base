<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>商品详情信息（goodsDetail.jsp）</title>
</head>
<body>
	<table border=1 style="border-collapse: collapse" align="center">
		<caption>
			<font size=4 face=华文新魏>商品详情</font>
		</caption>
		<tr>
			<td>名称</td>
			<td>
				${goods.gname }
			</td>
		</tr>
		<tr>
			<td>原价</td>
			<td>
				${goods.goprice }
			</td>
		</tr>
		<tr>
			<td>折扣价</td>
			<c:if test="${goods.gdnow==1 }">
			<td>
				${goods.gdprice }
			</td>
			</c:if>
			<c:if test="${goods.gdnow==0 }">
			<td>
				--
			</td>
			</c:if>
		</tr>
		<tr>
			<td>单位计量</td>
			<td>
				${goods.gunit }
			</td>
		</tr>
		<tr>
			<td>库存</td>
			<td>
				${goods.gstore }
			</td>
		</tr>
		<tr>
			<td>图片</td>
			<td>
				<c:if test="${goods.gpicture != '' }">
					<img alt="" width="250" height="250"
					src="logos/${goods.gpicture}"/>
				</c:if>
			</td>
		</tr>
		<tr>
			<td>类型</td>
			<td>
				${goods.typename }
			</td>
		</tr>
	</table>
</body>
</html>