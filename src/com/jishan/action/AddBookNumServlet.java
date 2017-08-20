package com.jishan.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishan.biz.ICartBiz;
import com.jishan.biz.impl.CartBizImpl;
import com.jishan.entity.Cart;
import com.jishan.entity.User;

/**
 * Servlet implementation class AddBookNumServlet
 */
public class AddBookNumServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookNumServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8") ;
		response.setCharacterEncoding("UTF-8") ;
		
		
		User user = (User) request.getSession().getAttribute("users") ;
		if(user ==null){
			PrintWriter out = response.getWriter();
	        /* TODO output your page here. You may use following sample code. */
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Servlet exercise</title>");            
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<script>alert('ÇëÏÈµÇÂ¼Å¶~');window.parent.location.href='login.jsp'</script>");
	        out.println("</body>");
	        out.println("</html>");
			//String path ="login.jsp" ;
			//response.sendRedirect(path);
		}else{
			int bookid = Integer.parseInt(request.getParameter("bnum")) ;
			ICartBiz cartBiz = new CartBizImpl() ;
			Cart cart = cartBiz.showCartById(user.getUid(), bookid);
			cart.setBcount(cart.getBcount()+1) ;
			cartBiz.updateCart(cart);
			String path ="ShowCartListServlet" ;
			response.sendRedirect(path);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
