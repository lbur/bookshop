package com.jishan.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishan.biz.IUserBiz;
import com.jishan.biz.impl.UserBizImpl;
import com.jishan.entity.User;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//设置字符编码
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//注册逻辑
		//获得前端页面数据
		
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		String realname = request.getParameter("realname");
		String sex  = request.getParameter("sex");
		String idcard  = request.getParameter("idcard");
		String email  = request.getParameter("email");
		String addr  = request.getParameter("addr");
		String phone  = request.getParameter("phone");
		//将数据与User类的属性一一对应，构建一个User类的对象
		//uid会在user对象插入数据库时自动添加
		User user = new User() ;
		user.setUsername(username);
		user.setPassword(password);
		user.setRealname(realname);
		user.setSex(sex);
		user.setIdcard(idcard);
		user.setEmail(email);
		user.setAddr(addr);
		user.setPhone(phone);
		//构建操作数据库的IUserBiz对象，操作数据库，将user对象的数据插入数据库
		IUserBiz biz = new UserBizImpl();
		biz.AddUser(user);
		//PrintWriter out = response.getWriter();
        //out.println("<script>alert('登录成功！');</script>");
		//重定向到登陆界面
		String path = "login.jsp" ;
		response.sendRedirect(path);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
