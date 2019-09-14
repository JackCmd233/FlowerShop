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
  		function checkDel(tid){
  			if(window.confirm("删除该类型时与它有关的商品都会被删除，您真的要删除该商品类型吗？")){
  				window.location.href = "/Shop/adminType/deleteAGoodsType?tid="+tid;
  			}
  		}
  </script>
</head>
<body>
	<c:if test="${allGoodsType.size() == 0 }">
		您还没有类型。
	</c:if>
	<c:if test="${allGoodsType.size() != 0 }">
		<table border="1" bordercolor="DarkSalmon" width="98%">
			<tr>
				<th width="200px">类型ID</th>
				<th width="200px">类型编号</th>
				<th width="200px">类型名称</th>
				<th width="400px">类型描述</th>
				<th width="200px">操作</th>
			</tr>
			<c:forEach items="${allGoodsType }" var="goodsType">
				<tr>
					<td>${goodsType.id }</td>
					<td>${goodsType.tid }</td>
					<td>${goodsType.typename }</td>
					<td>${goodsType.describ }</td>
					<td><a href="javascript:checkDel('${goodsType.tid }')">删除</a></td>
				</tr> 
			</c:forEach>
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
			</tr> 
				<td colspan="5">${msg }</td>
			</tr>
		</table>	
	</c:if>
</body>
</html>