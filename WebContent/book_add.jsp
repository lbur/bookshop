<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>书籍添加</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="./style/regist.css">		
<script src=" ${pageContext.request.contextPath }/jquery/jquery-1.11.3.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src=" ${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
<form action="AddBookServlet" method="post" enctype="multipart/form-data">
	<table border="0" class="table table-striped">
	    <tr > <td colspan="2" align="center"><h3>书籍新增</h3></td> </tr>
		<tr><td>图书编号：</td>
			<td><input class="form-control" type="text" name="bnum" placeholder="请填写图书编号"/></td>
		</tr>
		<tr><td>书名：</td>
			<td><input class="form-control" type="text" name="bname" placeholder="请填写书名"/></td>
		</tr>
		<tr><td>作者：</td>
			<td><input class="form-control" type="text" name="bauthor" placeholder="请填写作者"/></td>
		</tr>
		<tr><td>价格</td>
			<td><input class="form-control" type="text" name="bprice" placeholder="请填写书籍价格"/></td>
		</tr>
		<tr>
			<td>分类</td>
			<td><input class="form-control" type="text" name="bcate" placeholder="请填写书籍分类"/></td>
		</tr>
		
		<tr><td>出版日期</td>
			<td><input class="form-control" type="text" name="bprice" placeholder="请填写出版日期"/></td><td></td>
		</tr>
		<tr><td>出版社：</td>
			<td><input class="form-control" type="text" name="bpcom" placeholder="请填写出版社"/></td><td></td>
		</tr>
		<tr><td>简介：</td>
			<td><textarea class="form-control" type="text" name="bintro" placeholder="请填写本书的简介"></textarea></td>
		</tr>
		<tr><td>字数</td>
			<td> <input class="form-control" name="bword" placeholder="请填写字数"/></td>
		</tr>		
		<tr><td>封面图片：</td>
			<td><input class="form-control" type="file" name="bphoto"/></td><td></td>
		</tr>
	</table>
	   	<div class="login_button">
              <input id="btn" value="新增书籍" type="submit">
        </div>
</form>
</body>
</html>