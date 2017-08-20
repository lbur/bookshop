<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*" import="com.jishan.entity.User" %>
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
<title>瞄书网_图书搜索结果</title>
<link rel="stylesheet" type="text/css" href="./style/index.css">
		
<script src=" ${pageContext.request.contextPath }/jquery/jquery-1.11.3.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src=" ${pageContext.request.contextPath }/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

<% User user = (User) request.getSession().getAttribute("users") ;
        String word=new String();
		//如果user对象为null，表示用户未登录
		if(user ==null){
		 word ="<a href='login.jsp' style='color:#ea4949;'>请登录</a>" ;
			
		}else{ 
	     word =session.getAttribute("username")+"<a href='LogoutServlet' style='color:#ea4949;float:right'>[注销]</a>" ;
		//return 0;
    }
    
    %>
    
    <div class="BHeader">
        <div class="yNavIndex">
            <ul class="BHeaderl">
                <li style="display:none;"><a href="#" style="float:left;">嘻哈杂货铺</a> <a href="#" style="float:left;">退出</a> </li>
                <li><span style="float:left">欢迎光临,</span><span style="display: inline-block;"><a href="#" style="color:#ea4949;float:right"><%=word%></a></span> </li>
                <li class="headerul">|</li>
                <li><a href="regist.jsp">免费注册</a> </li>
                <li class="headerul">|</li>
                <li><a href="my-d.html">订单查询</a> </li>
                <li class="headerul">|</li>
                <li><a href="ShowCollectionListServlet">我的收藏</a> </li>
                <li class="headerul">|</li>
                <li id="pc-nav" class="menu"><a href="my-user.html" class="tit">我的商城</a>
                    <div class="subnav">
                        <a href="ShowOrderServlet">我的订单</a>
                        <a href="ShowCollectionListServlet">我的收藏</a>
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
    <div class="container clearfix">
        <div class="header-logo fl"><h1><a href="index.jsp"><img src="./style/index/image/index1.png"></a> </h1></div>
        <div class="head-form fl">
            <form class="clearfix" action="SearchServlet">
                <input name="search_word" type="text" class="search-text" accesskey="" id="key" autocomplete="off"  placeholder="穆斯林的葬礼">
                <button class="button">搜索</button>
            </form>
            <div class="words-text clearfix">
                <a href="#" class="red">秒抢书</a>
                <a href="#">天才在左疯子在右</a>
                <a href="#">人间词话</a>
                <a href="#">平凡的世界</a>
                <a href="#">算法导论</a>
                <a href="#">追风筝的人</a>
                <a href="#">活着</a>
            </div>
        </div>
        <div class="header-cart fr">
            <a href=" ShowCartListServlet">
               <img src="./style/index/image/car.png">
            </a> 
            <i class="head-amount">3</i>
        </div>
        <div class="head-mountain"></div>
    </div>
    <hr>
<p>图书搜索>搜索结果</p>
<div class="brand-poa H-over1 clearfix" style="display:block;">
<div class="tushu">
 <ul>
               <c:forEach items="${searchbookList}" var="u">
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${u.bphoto }" style="width:220px height:165px;"></a></div>
                            <div class="brand-title"><a href="#"> ${u.bname}</a> </div>
                            <div class="brand-price">￥${u.bprice}</div>
                            <div class="brand-cart">
                                <a href="AddToCartServlet?bnum=${u.bnum}" target="_parent">加入购物车</a>
                                <a href="AddToCartServlet?bookid=${u.bnum}" target="_parent">立即购买</a>
                                <a class="collect_btn" href="AddToCollectionServlet?bnum=${u.bnum}" target="_parent">收藏</a>
                            </div>
                        </li>
               </c:forEach>
      </ul>
      
  </div>  
  </div> 
</body>
</html>