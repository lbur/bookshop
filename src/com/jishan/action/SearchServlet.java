package com.jishan.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishan.biz.IBookBiz;
import com.jishan.biz.impl.BookBizImpl;
import com.jishan.entity.Book;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		String bname =request.getParameter("search_word") ;
		bname = new String(bname.getBytes("ISO-8859-1"),"UTF-8") ;
		//System.out.print(bname);
		IBookBiz biz= new BookBizImpl() ;
		List<Book> searchbookList = biz.showSearchBookList(bname) ;
		//Book book = biz.showBookByName(bname) ;
		if(searchbookList!=null){
			request.setAttribute("searchbookList", searchbookList) ;
			//request.setAttribute("book", book);
			//System.out.println(book.getBname());
			String path = "search_result.jsp" ;
			request.getRequestDispatcher(path).forward(request, response);	
		}  else {
			
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
