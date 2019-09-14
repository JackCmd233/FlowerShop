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
    <title>selectGoods.jsp</title>
	<link href="css/admin/common.css" type="text/css" rel="stylesheet">
	<script type="text/javascript" src="<%=basePath %>js/before/jquery-3.1.1.min.js"></script>
	<style type="text/css">
		table{
			border: 1px solid black;
			text-align: center;
			border-collapse: collapse;
		}
		.bgcolor{
		  	background-color: #3d7878;
		}
		/*弹出层*/
        #popBox {
            display: none;
            background-color:  #FFFFFF;
            border-style:solid; border-width:1px; border-color:#000;
            z-index: 11;
            width: 200px;
            height: 200px;
            position:fixed;
            top:0;
            right:0;
            left:0;
            bottom:0;
            margin:auto;
        }
 
        #popBox .close{
            text-align: right;
            background-color: #B3B3B3;
        }

        /*关闭按钮*/
        #popBox .close a {
            text-decoration: none;
            color: #2D2C3B;
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
  		function checkDel(id){
  			if(window.confirm("是否删除该公告？")){
  				window.location.href = "/Shop/adminNotice/deleteNotice?id="+id;
  			}
  		}
  </script>
  <script>
	//使用z-index属性设置背景层和弹出层的上下位置，值越大越靠上显示
    //设置弹出层和背景层
    /*点击弹出按钮*/
    function popBox(id,pageCur) { 
        window.location.href = "/Shop/adminNotice/selectANoticeById?id="+id+"&pageCur="+pageCur;
    };
 
    /*点击关闭按钮*/
    function closeBox() {
        var popBox = document.getElementById("popBox");
        popBox.style.display = "none";
    }
    
    function display(flag){
    	if(flag==1){
    		var popBox = document.getElementById("popBox");
    		popBox.style.display = "block";
    	}
    }
  </script>
</head>
<body onload="display(${flag})">
	<c:if test="${allNotices.size() == 0 }">
		您还没有添加任何公告！
	</c:if>
	<c:if test="${allNotices.size() != 0 }">
		<table border="1" bordercolor="DarkSalmon" width="98%">
			<tr>
				<th width="200px">ID</th>
				<th width="200px">标题</th>
				<th width="200px">创建时间</th>
				<th width="200px">详情</th>
				<th width="200px">操作</th>
			</tr>
			<c:forEach items="${allNotices}" var="notice">
				<tr onmousemove="changeColor(this)" onmouseout="changeColor1(this)">
					<td>${notice.id}</td>
					<td>${notice.ntitle}</td>
					<td>${notice.ntime}</td>
					<td>
					 <a onclick="popBox(${notice.id},${pageCur})">详情</a>
					<!--  <a href="adminNotice/selectANotice?id=${notice.id}" target="_blank" onclick="window.open(this.href,'','width=800,height=400')">详情</a>  -->
					</td>
					<td>
						<a href="javascript:checkDel('${notice.id}')">删除</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right">
					&nbsp;&nbsp;&nbsp;
					&nbsp;&nbsp;&nbsp;共${totalCount}条记录&nbsp;&nbsp;共${totalPage}页&nbsp;&nbsp;
					第${pageCur}页&nbsp;&nbsp;
					<c:url var="url_pre" value="adminNotice/deleteNoticeSelect">
						<c:param name="pageCur" value="${pageCur - 1 }"/>
					</c:url>
					<c:url var="url_next" value="adminNotice/deleteNoticeSelect">
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
		</table>
	</c:if>
	<div id="popBox">
     <div class="close">
      <a href="javascript:void(0)" onclick="closeBox()">关闭</a>
     </div>
     <div class="content">
      <input  disabled="true" style="width:-webkit-fill-available;text-align:center;" type="text" value="${notice.ntitle}">
      <textarea readonly="readonly" cols="26" rows="9" style="OVERFLOW:hidden">${notice.ncontent}</textarea>
      <input  disabled="true" style="width:-webkit-fill-available;height: 22px;text-align:right;" type="text" value="${notice.ntime}">
     </div>
    </div>
</body>
</html>