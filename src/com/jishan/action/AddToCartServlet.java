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
 * Servlet implementation class AddToCartServlet
 */
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		User user = (User) request.getSession().getAttribute("users") ;
		//���user����Ϊnull����ʾ�û�δ��¼
		if(user == null){
			//
			PrintWriter out = response.getWriter();
	        /* TODO output your page here. You may use following sample code. */
	        out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Servlet exercise</title>");            
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<script>alert('���ȵ�¼Ŷ~');window.parent.location.href='login.jsp'</script>");
	        out.println("</body>");
	        out.println("</html>");
			//String path ="login.jsp" ;
			//request.getRequestDispatcher(path).forward(request, response);
		}else{
			int bnum = Integer.parseInt(request.getParameter("bnum")) ;
			ICartBiz cartBiz = new CartBizImpl() ;
			Cart cart = cartBiz.showCartById(user.getUid(), bnum) ;
			
			if(cart == null){//������ﳵ�������Ѿ��м�¼����ִ�����ݲ������
				cart = new Cart() ;
				cart.setUserid(user.getUid()) ;
				cart.setBnum(bnum) ;
				cart.setBcount(1) ;
				cartBiz.saveCart(cart) ;
				
			} else{//������ﳵ������û�м�¼����ִ�и������ݲ���
				cart.setBcount(cart.getBcount()+1) ;
				cartBiz.updateCart(cart) ;
				
			}
			String path ="ShowCartListServlet" ;
			response.sendRedirect(path) ;
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
