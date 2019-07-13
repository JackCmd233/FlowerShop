<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>删除类型页面</title>
<link href="css/admin/common.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		table{
			border: 1px solid black;
			text-align: center;
			border-collapse: collapse;
		}
		.bgcolor{
		  	background-color: #3d7878;
		}
	</style>
	<script type="text/javascript">
  		function checkDel(id){
  			if(window.confirm("是否删除该商品类型？")){
  				window.location.href = "/FlowerShop/adminType/deleteType?id="+id;
  			}
  		}
  </script>
</head>
<body>
	<c:if test="${allTypes.size() == 0 }">
		您还没有类型。
	</c:if>
	<c:if test="${allTypes.size() != 0 }">
		<table border="1" bordercolor="DarkSalmon" >
			<tr>
				<th width="200px">类型ID</th>
				<th width="300px">类型名称</th>
				<th width="300px">删除操作</th>
			</tr>
			<c:forEach items="${allTypes }" var="goodsType">
				<tr>
					<td>${goodsType.id }</td>
					<td>${goodsType.typename }</td>
					<td><a href="javascript:checkDel('${goodsType.id }')">删除</a></td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="3">${msg }</td>
			</tr>
		</table>
	</c:if>
</body>
</html>