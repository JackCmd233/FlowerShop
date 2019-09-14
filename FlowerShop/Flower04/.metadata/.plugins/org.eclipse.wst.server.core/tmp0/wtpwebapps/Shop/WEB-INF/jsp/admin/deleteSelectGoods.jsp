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
    <title>删除商品页面（selectGoods.jsp）</title>
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
		function changeColor(obj){
			obj.className = "bgcolor";
		}
		function changeColor1(obj){
			obj.className = "";
		}
	</script>
	<script type="text/javascript">
		//删除多个商品
  		function confirmDelete(){
  			var n = document.deleteForm.ids.length;
  			var count = 0;//统计没有选中的个数
  			for(var i = 0; i < n; i++){
  				if(!document.deleteForm.ids[i].checked){
  					count++;
  				}else{
  					break;
  				}
  			}
  			if(n > 1){
  				if(count == n){
  					alert("请选择被删除的商品！");
  	  				count = 0;
  	  				return false;
  				}
  			}else{
  	  			if(!document.deleteForm.ids.checked){
  	  					alert("请选择被删除的商品！");
  	  					return false;
  	  			}
  			}	
  		
  			if(window.confirm("是否删除所选商品？")){
  				document.deleteForm.submit();
  				return true;
  			}
  			return false;
  		}
		//删除一个商品
  		function checkDel(id){
  			if(window.confirm("是否删除该商品？")){
  				window.location.href = "/Shop/adminGoods/deleteAGoods?id="+id;
  			}
  		}
  </script>
</head>
<body>
	<c:if test="${allGoods.size() == 0 }">
		您还没有商品。
	</c:if>
	<c:if test="${allGoods.size() != 0 }">
		<form action="adminGoods/deleteGoods" name="deleteForm">
		<table border="1" bordercolor="DarkSalmon" width="98%">
			<tr>
				<th width="100px">ID</th>
				<th width="100px">名称</th>
				<th width="100px">原价</th>
				<th width="100px">折扣价</th>
				<th width="100px">单位计量</th>
				<th width="100px">库存</th>
				<th width="100px">详情</th>
				<th width="100px">操作</th>
			</tr>
			<c:forEach items="${allGoods }" var="goods">
				<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
					<td><input type="checkbox" name="ids" value="${goods.id }"/>${goods.id }</td>
					<td>${goods.gname }</td>
					<td>${goods.goprice }</td>
					<td>${goods.gdprice }</td>
					<td>${goods.gunit }</td>
					<td>${goods.gstore }</td>
					<td><a href="adminGoods/selectAGoods?id=${goods.id }" target="center">详情</a></td>
					<td>
						<a href="javascript:checkDel('${goods.id }')">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8">
					<input type="button" value="删除" onclick="confirmDelete()">
				</td>
			</tr>
			<tr>
				<td colspan="8" align="right">
					&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
					第${pageCur}页&nbsp;&nbsp;
					<c:url var="url_pre" value="adminGoods/selectGoods">
						<c:param name="pageCur" value="${pageCur - 1 }"/>
						<c:param name="act" value="deleteSelect"/>
					</c:url>
					<c:url var="url_next" value="adminGoods/selectGoods">
						<c:param name="pageCur" value="${pageCur + 1 }"/>
						<c:param name="act" value="deleteSelect"/>
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
				<td colspan="8">${msg }</td>
			</tr>
		</table>
		</form>
	</c:if>
</body>
</html>