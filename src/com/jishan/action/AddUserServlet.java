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
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		//�����ַ�����
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//ע���߼�
		//���ǰ��ҳ������
		
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		String realname = request.getParameter("realname");
		String sex  = request.getParameter("sex");
		String idcard  = request.getParameter("idcard");
		String email  = request.getParameter("email");
		String addr  = request.getParameter("addr");
		String phone  = request.getParameter("phone");
		//��������User�������һһ��Ӧ������һ��User��Ķ���
		//uid����user����������ݿ�ʱ�Զ����
		User user = new User() ;
		user.setUsername(username);
		user.setPassword(password);
		user.setRealname(realname);
		user.setSex(sex);
		user.setIdcard(idcard);
		user.setEmail(email);
		user.setAddr(addr);
		user.setPhone(phone);
		//�����������ݿ��IUserBiz���󣬲������ݿ⣬��user��������ݲ������ݿ�
		IUserBiz biz = new UserBizImpl();
		biz.AddUser(user);
		PrintWriter out = response.getWriter();
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet exercise</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<script>alert('�����ɹ���');window.location.href='user_add.jsp'</script>");
            out.println("</body>");
            out.println("</html>");
    		//�ض��򵽵�½����
    		//String path = "user_add.jsp" ;
    		//response.sendRedirect(path);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
