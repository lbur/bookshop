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

		// ��ȡ��½�������ݣ�ǰ��ҳ��������˺š����롢��֤��
		String type = request.getParameter("type");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String yzm = request.getParameter("yzm");
		String yzm_session = request.getSession().getAttribute("yanzhengma") + "";
		request.getSession().setAttribute("username",username);
		//String adminname_session = request.getSession().getAttribute("yanzhengma") + "";
		System.out.println("ǰ���������֤��Ϊ��"+yzm);
		System.out.println("��̨���ɵ���֤��Ϊ��"+yzm_session);
		
		//ִ���ж�
		//�����½���ǹ���Ա
		if ("1".equals(type)) {
			// ����Biz���󣬶����ݿ���в�ѯ��������ȡ��ѯ����user����
			IAdminBiz adminBiz = new AdminBizImpl();
			Admin admin = adminBiz.showAdminByName(username) ;
			// �ȱȽ���֤�룬�ٱȽ��û��������롣���ݽ�����ش�����Ϣ������ת������Ա����
			String path = "";
			String resultStr = null;
			if (yzm_session.equalsIgnoreCase(yzm)) {
				//����˺�������ͬ
				if (admin!= null && password.equals(admin.getPassword())) {
					path = "admin.jsp";
					//path = "ShowChildBookServlet";
					request.getSession().setAttribute("admin", admin);
					System.out.println("��ת·��Ϊ"+path);
					response.sendRedirect(path);
					return;
				} else {
					path = "login.jsp";
					resultStr = "�û�������������!";
				}
			} else {
				path = "login.jsp";
				//request.getRequestDispatcher(path).forward(request, response);
				resultStr = "��֤����������������!";
			}
			System.out.println(resultStr);
			request.setAttribute("resultStr", resultStr);
			request.getRequestDispatcher(path).forward(request, response);
			
		}
		else if("2".equals(type)){
			IUserloginBiz userBiz = new UserloginBizImpl();
			//IAdminBiz adminBiz = new AdminBizImpl();
			User user = userBiz.showUserByName(username) ;
			// �ȱȽ���֤�룬�ٱȽ��û��������롣���ݽ�����ش�����Ϣ������ת������Ա����
			String path = "";
			String resultStr = null;
			if (yzm_session.equalsIgnoreCase(yzm)) {
				//����˺�������ͬ
				if (user!= null && password.equals(user.getPassword())) {
					path = "index.jsp";
					request.getSession().setAttribute("users", user);
					System.out.print(user.getUsername()+user.getAddr());
					System.out.println("��ת·��Ϊ"+path);
					response.sendRedirect(path);
					return;
				} else {
					path = "login.jsp";
					resultStr = "�û�������������!";
				}
			} else {
				path = "login.jsp";
				//request.getRequestDispatcher(path).forward(request, response);
				resultStr = "��֤����������������!";
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
