package com.jishan.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishan.biz.ICollectionBiz;
import com.jishan.biz.impl.CollectionBizImpl;
import com.jishan.entity.Collection;
import com.jishan.entity.User;

/**
 * Servlet implementation class AddToCollectionServlet
 */
public class AddToCollectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToCollectionServlet() {
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
		//如果user对象为null，表示用户未登录
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
	        out.println("<script>alert('请先登录哦~');window.parent.location.href='login.jsp'</script>");
	        out.println("</body>");
	        out.println("</html>");
			//String path ="login.jsp" ;
			//request.getRequestDispatcher(path).forward(request, response);
		}else{
			int bnum = Integer.parseInt(request.getParameter("bnum")) ;
			ICollectionBiz collectionBiz = new CollectionBizImpl() ;
			Collection collection = collectionBiz.showCollectionById(user.getUid(), bnum) ;
			
			if(collection == null){//如果购物车表里面已经有记录，则执行数据插入操作
				collection = new Collection() ;
				collection.setUserid(user.getUid()) ;
				collection.setBnum(bnum) ;
				collectionBiz.saveCollection(collection) ;
				
			} else{//如果购物车表里面没有记录，则执行更新数据操作
				collectionBiz.updateCollection(collection) ;
				
			}
			String path ="ShowCollectionListServlet" ;
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
