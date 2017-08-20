<%-- 
    Document   : order
    Created on : 2017
    Author     : Administrator
--%>
<%--response.sendRedirect("order.jsp")
else response.sendRedirect("loginfail.jsp");;
--%>
<%@page  language="java" %>
<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="utf-8"%>
<%
        java.sql.Connection conn =null;
        java.lang.String strConn;
        java.sql.Statement sqlStmt=null;
        java.sql.ResultSet sqlRst=null;
        try{
        conn=java.sql.DriverManager.getConnection("jdbc:mysql://localhost/bookshop","root","root");
        sqlStmt=conn.createStatement();
        String username=(String)request.getParameter("username");
        String password=(String)request.getParameter("password");
        String sqlQuery="select user_name from t_user where user_name='"+username+"'";
        String sqlQuery2="select password from t_user where password='"+password+"'";
        sqlRst=sqlStmt.executeQuery(sqlQuery);
        sqlRst=sqlStmt.executeQuery(sqlQuery);
%>
<% if(sqlRst.next()){
    String user=sqlRst.getString("user_name");
    String pass=sqlRst.getString("password");
    if( user.equals(username)&pass.equals(password) ){
        response.sendRedirect("index.jsp");
         }
    else {
       response.sendRedirect("loginfail.jsp");
       }
} else{
 response.sendRedirect("loginfail.jsp");
}
        }catch(java.sql.SQLException e){
        /* out.print(e.toString());*/
        }
        finally{
            //close
            if(sqlRst!=null)sqlRst.close();
            if(sqlStmt!=null)sqlStmt.close();
            if(conn!=null)conn.close();
        }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
