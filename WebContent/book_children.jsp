<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/xhtml1/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="./js/jquery.js"></script>
<link rel="stylesheet" type="text/css" href="./style/index.css">
<link rel="stylesheet" type="text/css" href="./style/lunbo.css">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
//window.location.href="ShowChildBookServlet";

/* setTimeout(function(){  //使用  setTimeout（）方法设定定时2000毫秒
window.location.reload();//页面刷新
},2000); */
</script>
<div class="brand-poa H-over1 clearfix" style="display:block;">
<div class="tushu">
 <ul>
               <c:forEach items="${childrenbookList}" var="u">
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
      
      
      
      
      
      
      
      
      
         <div>
           
<h1 class="keTitle">带触摸移动端焦点图轮播代码特效</h1>
<div id="lunbo" class="kePublic" >
<!--效果html开始-->
	<div class="slider">
	  <ul>
	    <li><a href="" target="_blank"><img src="./style/index/image/ad1.jpg" alt="科e互联网站建设团队"></a></li>
		<li><a href="" target="_blank"><img src="./style/index/image/ad2.jpg"></a></li>
		<li><a href="" target="_blank"><img src="./style/index/image/ad3.jpg"></a></li>
		<li><a href="" target="_blank"><img src="./style/index/image/ad4.jpg"></a></li>
		<li><a href="" target="_blank"><img src="./style/index/image/ad5.jpg"></a></li>
	  </ul>
	</div>
  <script type="text/javascript" src="./js/yxMobileSlider.js"></script>
  <script>
    $(".slider").yxMobileSlider({width:640,height:320,during:3000})
  </script>
<!--效果html结束-->
</div>
</div>
     
 </div>
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    </div>
</body>
</html>