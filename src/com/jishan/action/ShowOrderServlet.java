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
public class ShowOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrderServlet() {
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
		//request.getSession().getAttribute("username");
		//�ж��û��Ƿ��½
		if(user == null){
			String path = "login.jsp";
			request.getRequestDispatcher(path).forward(request, response);
		} else{
			
			
			ICartBiz cartBiz = new CartBizImpl() ;
			List<Cart> cartList =cartBiz.showCartList(user.getUid()) ;
			request.setAttribute("cartList", cartList) ;
			
			String username=(String) request.getSession().getAttribute("username");
			
			String dingdan=System.currentTimeMillis()+"";
			request.setAttribute("dingdan", dingdan) ;
			String path = "order.jsp" ;
			request.getRequestDispatcher(path).forward(request, response);
			//response.sendRedirect(path);
			//System.out.println("cartList�ĳ����ǣ�" +cartList.size());
			
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