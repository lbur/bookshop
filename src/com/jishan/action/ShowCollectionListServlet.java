package com.jishan.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishan.biz.ICollectionBiz;
import com.jishan.biz.impl.CollectionBizImpl;
import com.jishan.entity.Collection;
import com.jishan.entity.User;

/**
 * Servlet implementation class ShowCollectionListServlet
 */
public class ShowCollectionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCollectionListServlet() {
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
			
			
			ICollectionBiz collectionBiz = new CollectionBizImpl() ;
			List<Collection> collectionList =collectionBiz.showCollectionList(user.getUid()) ;
			request.setAttribute("collectionList", collectionList) ;
			String path = "my_collection.jsp" ;
			request.getRequestDispatcher(path).forward(request, response);
			//System.out.println("collectionList的长度是：" +collectionList.size());
			
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
