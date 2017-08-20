package com.jishan.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishan.biz.IAdminBiz;
import com.jishan.biz.IUserBiz;
import com.jishan.biz.IUserloginBiz;
import com.jishan.biz.impl.AdminBizImpl;
import com.jishan.biz.impl.UserloginBizImpl;
import com.jishan.entity.Admin;
import com.jishan.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		// 获取登陆界面数据：前端页面填入的账号、密码、验证码
		String type = request.getParameter("type");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String yzm = request.getParameter("yzm");
		String yzm_session = request.getSession().getAttribute("yanzhengma") + "";
		request.getSession().setAttribute("username",username);
		//String adminname_session = request.getSession().getAttribute("yanzhengma") + "";
		System.out.println("前端输入的验证码为："+yzm);
		System.out.println("后台生成的验证码为："+yzm_session);
		
		//执行判断
		//如果登陆的是管理员
		if ("1".equals(type)) {
			// 创建Biz对象，对数据库进行查询操作，获取查询到的user对象
			IAdminBiz adminBiz = new AdminBizImpl();
			Admin admin = adminBiz.showAdminByName(username) ;
			// 先比较验证码，再比较用户名和密码。根据结果返回错误信息或者跳转到管理员界面
			String path = "";
			String resultStr = null;
			if (yzm_session.equalsIgnoreCase(yzm)) {
				//如果账号密码相同
				if (admin!= null && password.equals(admin.getPassword())) {
					path = "admin.jsp";
					//path = "ShowChildBookServlet";
					request.getSession().setAttribute("admin", admin);
					System.out.println("跳转路径为"+path);
					response.sendRedirect(path);
					return;
				} else {
					path = "login.jsp";
					resultStr = "用户名或密码有误!";
				}
			} else {
				path = "login.jsp";
				//request.getRequestDispatcher(path).forward(request, response);
				resultStr = "验证码有误，请重新输入!";
			}
			System.out.println(resultStr);
			request.setAttribute("resultStr", resultStr);
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		else if("2".equals(type)){
			IUserloginBiz userBiz = new UserloginBizImpl();
			//IAdminBiz adminBiz = new AdminBizImpl();
			User user = userBiz.showUserByName(username) ;
			// 先比较验证码，再比较用户名和密码。根据结果返回错误信息或者跳转到管理员界面
			String path = "";
			String resultStr = null;
			if (yzm_session.equalsIgnoreCase(yzm)) {
				//如果账号密码相同
				if (user!= null && password.equals(user.getPassword())) {
					path = "index.jsp";
					request.getSession().setAttribute("users", user);
					System.out.print(user.getUsername()+user.getAddr());
					System.out.println("跳转路径为"+path);
					response.sendRedirect(path);
					return;
				} else {
					path = "login.jsp";
					resultStr = "用户名或密码有误!";
				}
			} else {
				path = "login.jsp";
				//request.getRequestDispatcher(path).forward(request, response);
				resultStr = "验证码有误，请重新输入!";
			}
			System.out.println(resultStr);
			//System.out.println(user.getUsername());
			//System.out.println(user.getPassword());
			System.out.println(resultStr);
			request.setAttribute("resultStr", resultStr);
			request.getRequestDispatcher(path).forward(request, response);
		}
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
