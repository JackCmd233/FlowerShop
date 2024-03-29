<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户管理</title>
	<link href="css/admin/common.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		table{
			border: 1px solid black;
			text-align: center;
			border-collapse: collapse
		}
		.bgcolor{
		  	background-color: #3d7878;
		}
	</style>
	<script type="text/javascript">
		function changeColor(obj){
			obj.className = "bgcolor";
		}
		function changeColor1(obj){
			obj.className = "";
		}
		function checkDel(id){
  			if(window.confirm("是否修改该用户账号状态？")){
  				window.location.href="/Shop/adminUser/updateuserManager?id="+id; 
  			}
  		}
	</script>
</head>
<body>
	<table border="1" bordercolor="DarkSalmon" width="98%">
		<tr>
			<th width="200px">用户ID</th>
			<th width="200px">用户账号</th>
			<th width="200px">用户密码</th>
			<th width="200px">用户账号状态</th>
			<th width="250px">操作</th>
		</tr>
		<c:forEach var="n" items="${userList}">
		<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
			<td>${n.id}</td>
			<td>${n.bphone}</td>
			<td><input type="password" value="${n.bpwd}" readonly></td>
			<c:if test="${n.bcanlogin==1 }">
				<td>可登陆</td>
			</c:if>
			<c:if test="${n.bcanlogin==0 }">
				<td>限制登陆</td>
			</c:if>
			<td> 
				<a href="javaScript:checkDel('${n.id}')">更改用户状态</a>
			</td>
		</tr>
		</c:forEach>
		<tr>
				<td colspan="5" align="right">  
					&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
					第${pageCur}页&nbsp;&nbsp;
					<c:url var="url_pre" value="adminUser/userInfo">
						<c:param name="pageCur" value="${pageCur - 1 }"/>
					</c:url>
					<c:url var="url_next" value="adminUser/userInfo">
						<c:param name="pageCur" value="${pageCur + 1 }"/>
					</c:url>
					<!-- 第一页没有上一页 -->
					<c:if test="${pageCur != 1 }">
						<a href="${url_pre}">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
					</c:if>
					<!-- 最后一页，没有下一页 -->
					<c:if test="${pageCur != totalPage && totalPage != 0}">
						<a href="${url_next}">下一页</a>
					</c:if>
				</td>
			</tr> 
		<tr>
			<td colspan="5">${msg }</td>
		</tr>
	</table>
</body>
</html>