 <%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>瞄书网—用户注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
    <link rel="shortcut icon" type="image/x-icon" href="./style/images/icon.ico">
	<link rel="stylesheet" type="text/css" href="./style/regist.css">

	<style>
	</style>
	
  </head>
  
  <body>
    <form action="RegistServlet"  method="post">
    	<table border="0" style="border-spacing:10px 20px;">
    		<tr > <td colspan="2" align="center">瞄书网_用户注册</td> </tr>
    		<tr> 
    		<td align="right">用户名：</td>
    		<td><input name ="username" type="text" /></td>
    		<td><font color="red">*</font></td>
    		</tr>
    		<tr> 
    		<td align="right">用户密码：</td>
    		<td><input name ="password" type="password" /></td>
    		<td><font color="red">*</font></td>
    		</tr>
    		<tr> 
    		<td align="right">真实姓名：</td>
    		<td><input name ="realname" type="text" /></td>
    		<td><font color="red">*</font></td>
    		</tr>
    		<tr> 
    		<td align="right">性别：</td>
    		<td><input name ="sex" type="radio" value="男" checked="checked"/>男
    			<input name ="sex" type="radio" value="女"/>女
    			<input name ="sex" type="radio" value="其他"/>其他
    		</td>
    		</tr>
    		<tr> 
    		<td align="right">身份证号码：</td>
    		<td><input name ="idcard" type="text" /></td>
    		</tr>
    		<tr> 
    		<td align="right">邮箱：</td>
    		<td><input name ="email" type="text" /></td>
    		</tr>
    		<tr> 
    		<td align="right">地址：</td>
    		<td><input name ="addr" type="text" /></td>
    		</tr>
    		<tr> 
    		<td align="right">电话：</td>
    		<td><input name ="phone" type="text" /></td>
    		</tr>		
    	</table>
        		<div class="login_button">
                       <input id="btn" value="立即注册" type="submit"><a href="login.jsp">已有帐号，直接登录</a>
                </div>
    		
    		</td>
    </form>
  </body>
</html>
                                                                                                                                                                                                                                                                                                                                                                                            