<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.jishan.entity.Admin" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/xhtml1/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="./style/admin.css">
<link rel="shortcut icon" type="image/x-icon" href="./style/images/icon.ico">
<script type="text/javascript" src="./jquery/jquery-1.11.3.min.js"></script>
<title>瞄书网后台管理系统</title>
<style type="text/css">
body{min-width: 960px;max-width: 1200px;margin: auto;background: #e9e7e7;}
@media screen and(min-width: 960)

</style>
</head>
<body>
<% Admin admin = (Admin) request.getSession().getAttribute("admin") ;
		//如果user对象为null，表示用户未登录
		if(admin ==null){
			String path ="login.jsp" ;
			request.getRequestDispatcher(path).forward(request, response);
		}else{  
		//return 0;
    }
    
    %>

  <div class="container">
	<div class="login-hd">
		<div class="left-bg"></div>
		<div class="right-bg"></div>
		<div class="hd-inner">
			<span class="logo"></span>
			<span class="split"></span>
			<span class="sys-name">欢迎您,管理员&nbsp;<span style="color:red"><%=session.getAttribute("username")%></span></span>
		</div>
	</div>
	<!-- 菜单选择javascript代码 -->
<script type="text/javascript">
$(function(){	
	var $div_li=$("#menu_ul li");
	
	$div_li.click(function(){
		/*alert("hello");*/
		$(this).addClass("selected").siblings().removeClass("selected");
	});
});
</script>
  <div class="menu_bar">
		<p id="menu">功能菜单</p>
			<ul id="menu_ul">
			<span>用户管理</span>
				<li class=""><a href="ShowUserListServlet" target=main>用户列表</a></li>
				<li class=""><a href="user_add.jsp" target=main>新增用户</a></li>
				<span>书籍管理</span>
				<li class=""><a href="ShowBookListServlet" target=main>书籍列表</a></li>
				<li class=""><a href="book_add.jsp" target=main>新增书籍</a></li>
				<span>订单管理</span>
				<li class=""><a href="menu1.html" target=main>订单列表</a></li>
				<!--  <li class=""><a href="menu2.html" target=main>菜单名称6</a></li>-->
			</ul>
 </div>
  <div class="content">
    <iframe src="menu_default.html" name="main" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
  </div>
<!--   <div class="advertise"></div>  --> 
  <div class="footer">
      <p>瞄书网&nbsp;版权所有&copy;2017</p>
       <p><a href="#">公司简介</a>&nbsp;|&nbsp;<a href="#">Investor Relations</a>&nbsp;|&nbsp;<a href="#">诚聘英才</a>&nbsp;|&nbsp;<a href="#">手机瞄书</a>&nbsp;|&nbsp;<a href="#">网站联盟</a>&nbsp;|&nbsp;<a href="#">瞄书招商</a>&nbsp;|&nbsp;<a href="#">机构销售</a>&nbsp;|&nbsp;<a href="#">官方Blog</a></p>
  </div>
  </div>	
</body>
</html>