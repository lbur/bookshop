<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="com.jishan.entity.User"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="./style/images/icon.ico">
<link rel="stylesheet" type="text/css" href="./style/index.css">
<title>瞄书网_用户收藏</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css">

<script
	src=" ${pageContext.request.contextPath }/jquery/jquery-1.11.3.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script
	src=" ${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
html {
	cursor: url(img/01.png), auto;
}
.aa{
	background-color:#fa5000b3;
	height: 90px;
}
.aa p{
font-size: 26px;
color: white;

}
.tocalcu{
display: inline-block;
height: 33px;
width: 100px;
margin-left: 12px;
font: 12px/23px 'Microsoft YaHei';
overflow: hidden;
background-color: #f65b12cc;
color: #fff;
text-align: center;
border-radius: 3px;
line-height: -moz-block-height;
}
.tocalcu:hover{
text-decoration:none;
background-color: #fa5000;
color: #fff;

}
.footer{
	background:#ffffff /*#dbdbdb;*/
	width:100%;
	height:100px;
	clear:both;
	text-align: center;
}
.footer p{
	top:50px;
	padding-top:20px;
}
.footer p a{
	color:black;
	text-decoration:none;
}
.footer p a:hover{
	color:red;
}
</style>
</head>

<body>
<% User user = (User) request.getSession().getAttribute("users") ;
        String word=new String();
		//如果user对象为null，表示用户未登录
		if(user ==null){
		 word ="<a href='login.jsp' style='color:#ea4949;'>请登录</a>" ;
			
		}else{ 
	     word =""+session.getAttribute("username") ;
		//return 0;
    }
    
    %>
    <div class="BHeader">
        <div class="yNavIndex">
            <ul class="BHeaderl">
                <li style="display:none;"><a href="#" style="float:left;">嘻哈杂货铺</a> <a href="#" style="float:left;">退出</a> </li>
                <li><span>欢迎光临,</span><span style="display: inline-block;"><a href="#" style="color:#ea4949;"><%=word%></a></span> </li>
                <li class="headerul">|</li>
                <li><a href="regist.jsp">免费注册</a> </li>
                <li class="headerul">|</li>
                <li><a href="my-d.html">订单查询</a> </li>
                <li class="headerul">|</li>
                <li><a href="my-s.html">我的收藏</a> </li>
                <li class="headerul">|</li>
                <li id="pc-nav" class="menu"><a href="my-user.html" class="tit">我的商城</a>
                    <div class="subnav">
                        <a href="my-d.html">我的订单</a>
                        <a href="my-s.html">我的收藏</a>
                        <a href="my-user.html">账户安全</a>
                        <a href="my-add.html">地址管理</a>
                        <a href="my-p.html">我要评价</a>
                    </div>
                </li>
                <li class="headerul">|</li>
                <li id="pc-nav1" class="menu"><a href="#" class="tit M-iphone">手机瞄书</a>
                   <div class="subnav">
                       <a href="#"><img src="./style/index/image/ewm.png" width="115" height="115" title="扫一扫，有惊喜！"></a>
                   </div>
                </li>
            </ul>
        </div>
    </div>
    <div class="carttop">
    <img src="./style/index/image/top.png">
    </div>
	<form action="ShowOrderServlet" method="post">
		<table class="table table-bordered" align="center" border="0"
			style="margin-top: 5%; width: 900px;">
			<tr>
				<td class="aa" align="center" colspan="7"><p class="text-primary">我的收藏</p></td>
			</tr>
			<tr>
    			<td>书籍名</td>
    			<td>图书封面</td>
    			<td>单价</td>
    			<td>金额(元)</td>
    			<td>操作</td>
    		</tr>
    <!-- c set标签，表示赋值。下面语句相当于 int sum = 0 -->
			<c:set value="0" var="sum" />
    		<c:forEach items="${collectionList}" var="c">
    <!--fmt:formatNumber 这个标签和c标签一样，也属于jstl标签库。表示按格式转换数字 。下面pattern="#.00"表示将数字保留2位小数进行转换 -->
    		<fmt:formatNumber value="${c.book.bprice}" pattern="#.00" var="pprice"/>
    		<tr>
    			<td><input type="checkbox" checked="checked"></td>
    			<td>${c.book.bname}</td>
    			<td><img src ="${c.book.bphoto}" style="width:120px;height:92px;margin-left:96px;"></td>
    			<td>${pprice}</td>
    			<td><a href="DeleteCollectionServlet?bnum=${c.bnum}" target="_parent">删除</a></td>
    			<!-- 下面的c set 标签 相当于 sum = 每行金额 + sum 这样一个求和语句-->
    		</tr>
    		</c:forEach>
    		<tr>
    			<td colspan="7" align="right" ><a class="tocalcu" href="index.jsp">返回首页</a></td>
    		</tr>
			
		</table>

	</form>
	<div class="footer">
      <p>瞄书网&nbsp;版权所有&copy;2017</p>
       <p><a href="#">公司简介</a>&nbsp;|&nbsp;<a href="#">Investor Relations</a>&nbsp;|&nbsp;<a href="#">诚聘英才</a>&nbsp;|&nbsp;<a href="#">手机瞄书</a>&nbsp;|&nbsp;<a href="#">网站联盟</a>&nbsp;|&nbsp;<a href="#">瞄书招商</a>&nbsp;|&nbsp;<a href="#">机构销售</a>&nbsp;|&nbsp;<a href="#">官方Blog</a></p>
  </div>
</body>
</html>