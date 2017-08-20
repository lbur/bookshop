 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加用户用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="./style/regist.css">		
    <script src=" ${pageContext.request.contextPath }/jquery/jquery-1.11.3.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src=" ${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="shortcut icon" type="image/x-icon" href="./style/images/favicon.ico">
	<link rel="stylesheet" type="text/css" href="./style/regist.css">

	<style>
		input{
			font-size:25px;
		}
	</style>
	
  </head>
  
  <body>
  <form action="AddUserServlet" method="post">
	<table border="0" class="table table-striped">
	    <tr > <td colspan="2" align="center"><h3>用户新增</h3></td> </tr>
		<tr><td>用户名：</td>
			<td><input class="form-control" type="text" name="username" placeholder="请填写用户名"/></td>
		</tr>
		<tr><td>用户密码</td>
			<td><input class="form-control" type="text" name="password" placeholder="请填写用户密码"/></td>
		</tr>
		<tr><td>真实姓名：</td>
			<td><input class="form-control" type="text" name="realname" placeholder="真实姓名"/></td>
		</tr>
		<tr><td>性别</td>
			<td><input class="" type="radio" name="sex" value="男" checked="checked"/>男
			    <input class="" type="radio" name="sex" value="女"/>女
			</td>
		</tr>
		<tr>
			<td>身份证号</td>
			<td><input class="form-control" type="text" name="idcard" placeholder="请填写身份证号"/></td>
		</tr>
		
		<tr><td>邮箱</td>
			<td><input class="form-control" type="text" name="email" placeholder="请填写邮箱"/></td><td></td>
		</tr>
		<tr><td>地址</td>
			<td><input class="form-control" type="text" name="addr" placeholder="请填写地址"/></td><td></td>
		</tr>
		<tr><td>电话</td>
			<td><input class="form-control" type="text" name="phone" placeholder="请填写电话"/></td><td></td>
		</tr>
	</table>
	   	<div class="login_button">
              <input id="btn" value="新增用户" type="submit">
        </div>
</form>
  
  </body>
</html>
                                                                                                                                                                                                                                                                                                                                                                                            