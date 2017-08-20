<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
     <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My JSP 'user_index.jsp' starting page</title>
</head>
<frameset rows="200px,100%" bordercolor="red" frameborder="no">
	<frame src="login.jsp" name="top" noresize="noresize" scrolling="no"/>
	<frameset cols="" bordercolor="red" border="0">
		<frame src="login.jsp" name="center" scrolling="auto"/>
	</frameset>
</frameset>
<body>
	
</body>
</html>