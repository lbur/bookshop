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
			ICollectionBiz collectionBiz = new CollectionBizImpl() ;
			Collection collection = collectionBiz.showCollectionById(user.getUid(), bnum) ;
			
			if(collection == null){//������ﳵ�������Ѿ��м�¼����ִ�����ݲ������
				collection = new Collection() ;
				collection.setUserid(user.getUid()) ;
				collection.setBnum(bnum) ;
				collectionBiz.saveCollection(collection) ;
				
			} else{//������ﳵ������û�м�¼����ִ�и������ݲ���
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
