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
			var  url ="ShowBookListServlet?pageNo="+pageNoValue.value ;
			window.location =url ;
		}
</script>
<style>
table>tbody>tr>td{vertical-align: middle;}
.table > tbody > tr > td, .table > tbody > tr > th, .table > tfoot > tr > td, .table > tfoot > tr > th, .table > thead > tr > td, .table > thead > tr > th {
    padding: 8px;
    line-height: 1.42857143;
    vertical-align: middle;
    border-top: 1px solid #ddd;
}
img{
width:100px;
height:100px;
}
</style>
</head>
<body>
	<table class="table table-hover table-striped">
		<tr align="center">
				<td ><p class="lead">图书编号</p></td>
				<td ><p class="lead">书名</p></td>
				<td ><p class="lead">图书封面</p></td>
				<td ><p class="lead">作者</p></td>
				<td ><p class="lead">价格</p></td>
				<td ><p class="lead">分类</p></td>
				<td ><p class="lead">出版日期</p></td>
				<td ><p class="lead">出版社</p></td>
				<td ><p class="lead">字数</p></td>
				<td ><p class="lead">简介</p></td>
				<td ><p class="lead">操作</p></td>
			</tr>
			<c:forEach items="${bookList}" var="u">
				<tr align="center">
					<td>${u.bnum}</td>
					<td>${u.bname}</td>
					<td><img src="${u.bphoto }"></img></td>
					<td>${u.bauthor}</td>
					<td>${u.bprice}</td>
					<td>${u.bcate}</td>
					<td>${u.bpdate}</td>
					<td>${u.bpcom}</td>
					<td>${u.bword}</td>
					<td>${u.bintro}</td>
					<td><a href="ToUpdateBookServlet?bnum=${u.bnum }">修改</a> <a href="DeleteBookServlet?bnum=${u.bnum }">删除</a></td>
				</tr>
			</c:forEach>
			<!-- 以下为分页的控件，按功能分为 首页、上一页、当前页/总页数 、下一页、尾页、页面跳转 -->
			<tr>
    		<td colspan="10" align="center">
    			<a href="ShowBookListServlet?pageNo=1">首页</a>&nbsp;
    			<a <c:if test="${pageNo !=1}"> href="ShowBookListServlet?pageNo=${pageNo-1}"</c:if>>上一页</a>&nbsp;
    			${pageNo}/${maxPageNo}页&nbsp;
    			<a <c:if test="${pageNo !=maxPageNo}">href="ShowBookListServlet?pageNo=${pageNo+1}" </c:if>>下一页</a>&nbsp;
    			<a href="ShowBookListServlet?pageNo=${maxPageNo}">尾页</a>&nbsp;
    			<input id="pageNoValue" type="text" name="pageNoValue" style="width:20px"/>页<input type="button" value="跳转" onclick="getPageNoValue()"/>
    		</td>
    	</tr>
	</table>
</body>
</html>