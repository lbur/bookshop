package com.jishan.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishan.biz.IUserBiz;
import com.jishan.biz.impl.UserBizImpl;
import com.jishan.entity.User;

/**
 * Servlet implementation class UpdataUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		User user= new User();
		System.out.println("我的id是什么：" + request.getParameter("uid"));
		int uid = Integer.valueOf(request.getParameter("uid"));
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String realname=request.getParameter("realname");
		String sex=request.getParameter("sex");
		String idcard=request.getParameter("idcard");
		String email=request.getParameter("email");
		String addr=request.getParameter("addr");
		String phone=request.getParameter("phone");
		
		user.setUid(uid);
		user.setUsername(username);
		user.setPassword(password);
		user.setRealname(realname);
		user.setSex(sex);
		user.setIdcard(idcard);
		user.setEmail(email);
		user.setAddr(addr);
		user.setPhone(phone);
		
		
		IUserBiz userbiz = new UserBizImpl();
		userbiz.updateUser(user);
		
		String path="ShowUserListServlet";
		//重定向
				response.sendRedirect(path);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
