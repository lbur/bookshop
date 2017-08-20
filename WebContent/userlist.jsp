<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href=" ${pageContext.request.contextPath }/bootstrap/css/bootstrap.min.css">
		
<script src=" ${pageContext.request.contextPath }/jquery/jquery-1.11.3.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src=" ${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<!-- 下面script标签里内容为js代码，用于触发《跳转 》按钮的点击事件，跳转到相应的页-->
<script type="text/javascript">
		function getPageNoValue(){
			var  pageNoValue = document.getElementById("pageNoValue");
			var  url ="ShowUserListServlet?pageNo="+pageNoValue.value ;
			window.location =url ;
		}
</script>
</head>
<body>
	<table class="table table-hover table-striped">
		<tr align="center">
				<td ><p class="lead">用户id</p></td>
				<td ><p class="lead">用户名</p></td>
				<td ><p class="lead">密码</p></td>
				<td ><p class="lead">真实姓名</p></td>
				<td ><p class="lead">性别</p></td>
				<td ><p class="lead">身份证</p></td>
				<td ><p class="lead">邮箱</p></td>
				<td ><p class="lead">地址</p></td>
				<td ><p class="lead">电话</p></td>
				<td ><p class="lead">操作</p></td>
			</tr>
			<c:forEach items="${userList}" var="u">
				<tr align="center">
					<td>${u.uid}</td>
					<td>${u.username}</td>
					<td>${u.password}</td>
					<td>${u.realname}</td>
					<td>${u.sex}</td>
					<td>${u.idcard}</td>
					<td>${u.email}</td>
					<td>${u.addr}</td>
					<td>${u.phone}</td>
					<td><a href="ToUpdateUserServlet?uid=${u.uid}">修改</a> <a href="DeleteUserServlet?uid=${u.uid}">删除</a></td>
				</tr>
			</c:forEach>
			<!-- 以下为分页的控件，按功能分为 首页、上一页、当前页/总页数 、下一页、尾页、页面跳转 -->
			<tr>
    		<td colspan="10" align="center">
    			<a href="ShowUserListServlet?pageNo=1">首页</a>&nbsp;
    			<a <c:if test="${pageNo !=1}"> href="ShowUserListServlet?pageNo=${pageNo-1}"</c:if>>上一页</a>&nbsp;
    			${pageNo}/${maxPageNo}页&nbsp;
    			<a <c:if test="${pageNo !=maxPageNo}">href="ShowUserListServlet?pageNo=${pageNo+1}" </c:if>>下一页</a>&nbsp;
    			<a href="ShowUserListServlet?pageNo=${maxPageNo}">尾页</a>&nbsp;
    			<input id="pageNoValue" type="text" name="pageNoValue" style="width:20px"/>页<input type="button" value="跳转" onclick="getPageNoValue()"/>
    		</td>
    	</tr>
	</table>
</body>
</html>