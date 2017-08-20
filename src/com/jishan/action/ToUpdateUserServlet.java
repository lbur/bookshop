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
 * Servlet implementation class ToUpdataUserServlet
 */
public class ToUpdateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUpdateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int uid=Integer.valueOf(request.getParameter("uid"));//String 转换int
		IUserBiz userbiz=new UserBizImpl();//创建biz对象
		
		User user =userbiz.showUserById(uid);//调用方法id去查询用户  并返回一个用户的对象
		
		request.setAttribute("user", user);//设置
		
		String path="upuser.jsp";//页面
		request.getRequestDispatcher(path).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
