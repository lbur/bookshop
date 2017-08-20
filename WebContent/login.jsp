<%-- 
    Document   : login
    Created on : 2017-7-11, 
    Author     : bur
--%>

<%@page contentType="text/html" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>瞄书网_登录</title>
        <meta http-equiv="Content-Type" content="text/html;charset=gbk">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="./style/login.css">
        <link rel="shortcut icon" type="image/x-icon" href="./style/images/icon.ico">
    </head>
    <body>
    <SCRIPT language=javascript>
function Checklogin()
{
  if (myform.password.value=="")
  {
    alert("请填写用户名");
    myform.password.focus();
    return false;
  }
    if (myform.password.value=="")
  {
    alert("密码不能为空");
    myform.password.focus();
    return false;
  }
}
</SCRIPT>
	<div class="login-hd">
		<div class="left-bg"></div>
		<div class="right-bg"></div>
		<div class="hd-inner">
			<span class="logo"></span>
			<span class="split"></span>
		</div>
	</div>
    <div id="container">
    <br>
        <form name="myform" action="LoginServlet" method="post" onsubmit="return Checklogin();">
        <img src="./style/images/login_logo3.png">
            <table width="80%" border="0" align="center">
			      <c:if test="${resultStr!=null}">
   				    <tr>
   					   <td id="warn" colspan="3" align="center"><font color="red">${resultStr}</font></td>
   				   </tr>
   			    </c:if>	
                <tr>
                    <td align="center">
                        <div calss="left" align="center">用户名：</div>
                    </td>
                    <td width="57%"><div align="align">
                        <input type="text" name="username">
                    </div></td>
                </tr>
                <tr>
                	<td align="center" width="43%">
                        <div class="left" align="center">密   &nbsp;&nbsp;码：</div>
                    </td>
                    <td width="57%">
                      <div align="align">
                        <input type="password" name="password">
                      </div></td>
                </tr>
                <tr>
                <td style="text-align: center;">验证码：</td>
				<td><input type="text" name="yzm"></td>
				<!--改动 验证码 -->
				<td><img id="yzm" alt="" align="middle" src="ImageServlet"
					onclick="this.src='ImageServlet?d='+Math.random();" /></td>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<div style="float: left;">
						<!--改动 下拉框 -->
						<select name="type" style="height: 30px; font-size: 15px;">
							<option value="1">管理员</option>
							<option value="2" selected="selected">消费者</option>
						</select>
                </tr>
            </table>
            <p align="center">
                <input type="checkbox" name="remember" value="true">
                记住密码
            <p align="center">
                <input id="sub_btn" type="submit" name="Submit2" value="提交">
                <a href="regist.jsp">还没帐号？注册一下</a>
            </p>
        </form> 
        </div> 
        <div class="footer">
            <p>瞄书网&nbsp;版权所有&copy;2017</p>
             <p><a href="#">公司简介</a>&nbsp;|&nbsp;<a href="#">Investor Relations</a>&nbsp;|&nbsp;<a href="#">诚聘英才</a>&nbsp;|&nbsp;<a href="#">手机瞄书</a>&nbsp;|&nbsp;<a href="#">网站联盟</a>&nbsp;|&nbsp;<a href="#">瞄书招商</a>&nbsp;|&nbsp;<a href="#">机构销售</a>&nbsp;|&nbsp;<a href="#">官方Blog</a></p>
        </div>
<script type="text/javascript">banner()</script>
</body>
</html>

