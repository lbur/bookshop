<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
</head>
<body>
<form action="UpdateBookServlet" method="post" enctype="multipart/form-data">
	<table border="0" class="table table-striped ">
		<tr>
			<td>图书编号：</td>
			<td><input class="form-control" type="text" readonly="readonly" name="bnum" value="${book.bnum}" /></td><td></td>
		</tr>
		<tr>
			<td>书名：</td>
			<td><input class="form-control" type="text" name="bname" value="${book.bname}"  /></td>
		</tr>
		<tr><td>作者：</td>
			<td><input class="form-control" type="text" name="bauthor" value="${book.bauthor}"  /></td>
		</tr>
		<tr><td>价格：</td>
			<td><input class="form-control" type="text" name="bprice"  value="${book.bprice}" /></td>
		</tr>
		<tr>
			<td>分类：</td>
			<td><input class="form-control"  type="text" name="bcate" value="${book.bcate}" /></td>
		</tr>	
		<tr><td>出版日期：</td>
			<td><input class="form-control" type="text" name="bpdate"  value="${book.bpdate}"  /></td>
		</tr>			
		<tr><td>出版社</td>
			<td><input class="form-control" name="bpcom"  value="${book.bpcom}" /></td>
		</tr>
		<tr><td>简介：</td>
			<td><textarea class="form-control"  name="bintro" >${book.bintro}</textarea></td>
		</tr>		
		<tr><td>字数：</td>
			<td><input class="form-control"  name="bword" value="${book.bword}" /></td>
		</tr>
		<tr>
			<td>封面图片：</td>
			<td><input class="form-control" type="file" name="bphoto"  value="${book.bphoto}"/></td>
		</tr>		
		<tr>
			<td colspan="2" align="center">
				<input  style="width:400px;" class="btn btn-info" value="完成" type="submit" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>