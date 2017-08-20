<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/xhtml1/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="./style/index.css">
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
 <ul>
               <c:forEach items="${historybookList}" var="n">
                        <li>
                            <div class="brand-imgss"><a href="#"><img src="${n.bphoto }" style="width:220px height:165px;"></a></div>
                            <div class="brand-title"><a href="#"> ${n.bname}</a> </div>
                            <div class="brand-price">￥${n.bprice}</div>
                            <div class="brand-cart">
                                <a href="AddToCartServlet?bnum=${n.bnum}">加入购物车</a>
                                <a href="AddToCartServlet?bookid=${n.bnum}">立即购买</a>
                                <a class="collect_btn"  href="AddToCollectionServlet?bnum=${u.bnum}" target="_parent">收藏</a>
                            </div>
                        </li>
               </c:forEach>
 </ul>
                    </div>
</body>
</html>