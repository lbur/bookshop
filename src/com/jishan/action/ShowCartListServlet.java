package com.jishan.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishan.biz.ICartBiz;
import com.jishan.biz.impl.CartBizImpl;
import com.jishan.entity.Cart;
import com.jishan.entity.User;

/**
 * Servlet implementation class ShowCartListServlet
 */
public class ShowCartListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartListServlet() {
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
		//判断用户是否登陆
		if(user == null){
			String path = "login.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		} else{
			
			
			ICartBiz cartBiz = new CartBizImpl() ;
			List<Cart> cartList =cartBiz.showCartList(user.getUid()) ;
			request.setAttribute("cartList", cartList) ;
			String path = "my_cart.jsp" ;
			request.getRequestDispatcher(path).forward(request, response);
			//System.out.println("cartList的长度是：" +cartList.size());
			
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
