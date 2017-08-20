<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="java.util.*" import="com.jishan.entity.User" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" type="image/x-icon" href="./style/images/icon.ico">
<link rel="stylesheet" type="text/css" href="./style/index.css">
	<script type="text/javascript" src="./js/jquery.js"></script>
	<script type="text/javascript" src="./js/index.js"></script>
	<script type="text/javascript" src="./js/js-tab.js"></script>
<title>瞄书网，你的线上书城</title>
</head>
<body>
<% User user = (User) request.getSession().getAttribute("users") ;
        String word=new String();
		//如果user对象为null，表示用户未登录
		if(user ==null){
		 word ="<a href='login.jsp' style='color:#ea4949;'>请登录</a>" ;
			
		}else{ 
	     word =session.getAttribute("username")+"<a href='LogoutServlet' style='color:#ea4949;float:left'>[注销]</a>" ;
		//return 0;
    }
    
    %>

<header id="pc-header">
    <div class="BHeader">
        <div class="yNavIndex">
            <ul class="BHeaderl">
                <li style="display:none;"><a href="#" style="float:left;">嘻哈杂货铺</a> <a href="#" style="float:left;">退出</a> </li>
                <li><span style="float:left">欢迎光临,</span><span style="display: inline-block;"><a href="#" style="color:#ea4949;float:left"><%=word%></a></span> </li>
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
<div class="time-lists  clearfix">
    <div class="time-list time-list-w fl">
        <div class="time-title time-clear-f2"><h2>图书列表</h2>
            <ul class="brand-tab H-table1 clearfix fr" id="H-table1">
                <li class="cur" id="tongshu"><a href="ShowChildBookServlet" target=main onclick="myFunction()">童书</a></li>
                <li><a href="ShowTeachBookServlet" target=teach>教辅</a></li>
                <li><a href="ShowNovelBookServlet" target=novel>小说</a></li>
                <li><a href="ShowSuccessBookServlet" target=success>成功励志</a></li>
                <li><a href="ShowYoungBookServlet" target=young>青春文学</a></li>
                <li><a href="ShowHistoryBookServlet" target=history>历史</a></li>
                <li><a href="ShowReligionBookServlet" target=religion>哲学宗教</a></li>
                <li><a href="ShowTechnologyBookServlet" target=technology>科技</a></li>
            </ul>
        </div>
        <div class="time-border time-border-h clearfix">
            <div class="brand-img fl">
                <ul>
                    <li><a href="#"><img src="./style/index/image/book_rank.png" width="125" height="47"></a></li>
                    <li><a href="#"><h2 style="display:inline-block">1st</h2><img src="./style/index/image/rank1.png" width="125" height="47"></a></li>
                    <li><a href="#"><h2 style="display:inline-block">2nd</h2><img src="./style/index/image/rank2.png" width="125" height="47"></a></li>
                    <li><a href="#"><h2 style="display:inline-block">3th</h2><img src="./style/index/image/rank3.png" width="125" height="47"></a></li>
                    <li><a href="#"><h2 style="display:inline-block">4th</h2><img src="./style/index/image/rank4.png" width="125" height="47"></a></li>
                    <li><a href="#"><h2 style="display:inline-block">5th</h2><img src="./style/index/image/rank5.png" width="125" height="47"></a></li>
                </ul>
            </div>

            <div class="brand-poa fl">
                <div class="brand-poa H-over1 clearfix">
                 <iframe src="book_children.jsp" name="main" width="100%" height="100%" frameborder="0" scrolling="auto"></iframe>      
                </div>
                <div class="brand-poa H-over1 clearfix" style="display:none;">
                    <iframe src="book_teach.jsp" name="teach" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
                </div>
                <div class="brand-poa H-over1 clearfix" style="display:none;">
                    <iframe src="book_novel.jsp" name="novel" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
                </div>
                <div class="brand-poa H-over1 clearfix" style="display:none;">
                    <iframe src="book_success.jsp" name="success" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
                </div> 
                <div class="brand-poa H-over1 clearfix" style="display:none;">
                    <iframe src="book_young.jsp" name="young" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
                </div> 
                <div class="brand-poa H-over1 clearfix" style="display:none;">
                    <iframe src="book_history.jsp" name="history" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
                </div> 
                <div class="brand-poa H-over1 clearfix" style="display:none;">
                    <iframe src="book_religion.jsp" name="religion" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
                </div>
                <div class="brand-poa H-over1 clearfix" style="display:none;">
                    <iframe src="book_technology.jsp" name="technology" width="100%" height="100%" frameborder="0" scrolling="yes"></iframe>
                </div>                                 
            </div>       <!-- end  -->
        </div>
    </div>
</div>
</header>
        <div class="aui-footer-bot">
        <div class="time-lists aui-footer-pd clearfix">
        <div class="aui-footer-list clearfix">
            <h4>
                <span><img src="style/images/icon-d1.png"></span>
                <em>消费者权益</em>
            </h4>
            <ul>
                <li><a href="#">保障范围 </a> </li>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">服务中心 </a> </li>
                <li><a href="#">服务中心</a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
            </ul>
        </div>
        <div class="aui-footer-list clearfix">
            <h4>
                <span><img src="style/images/icon-d2.png"></span>
                <em>新手上路</em>
            </h4>
            <ul>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">服务中心 </a> </li>
                <li><a href="#">服务中心</a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
            </ul>
        </div>
        <div class="aui-footer-list clearfix">
            <h4>
                <span><img src="style/images/icon-d3.png"></span>
                <em>保障正品</em>
            </h4>
            <ul>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">服务中心 </a> </li>
                <li><a href="#">服务中心</a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
            </ul>
        </div>
        <div class="aui-footer-list clearfix">
            <h4>
                <span><img src="style/images/icon-d1.png"></span>
                <em>消费者权益</em>
            </h4>
            <ul>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">服务中心 </a> </li>
                <li><a href="#">服务中心</a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
            </ul>
        </div>
    </div>
    <div style="border-bottom:1px solid #dedede"></div>
    <div class="time-lists aui-footer-pd time-lists-ls clearfix">
        <div class="aui-footer-list clearfix">
            <h4>购物指南</h4>
            <ul>
                <li><a href="#">保障范围 </a> </li>
                <li><a href="#">购物流程</a> </li>
                <li><a href="#">会员介绍 </a> </li>
                <li><a href="#">生活旅行</a> </li>
                <li><a href="#"> 常见问题 </a> </li>
                <li><a href="#"> 联系客服购物指南 </a> </li>
            </ul>
        </div>
        <div class="aui-footer-list clearfix">
            <h4>特色服务</h4>
            <ul>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">服务中心 </a> </li>
                <li><a href="#">服务中心</a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
            </ul>
        </div>
        <div class="aui-footer-list clearfix">
            <h4>帮助中心</h4>
            <ul>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">服务中心 </a> </li>
                <li><a href="#">服务中心</a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
            </ul>
        </div>
        <div class="aui-footer-list clearfix">
            <h4>新手指导</h4>
            <ul>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">退货退款流程</a> </li>
                <li><a href="#">服务中心 </a> </li>
                <li><a href="#">服务中心</a> </li>
                <li><a href="#">服务中心</a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
                <li><a href="#"> 更多特色服务 </a> </li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>