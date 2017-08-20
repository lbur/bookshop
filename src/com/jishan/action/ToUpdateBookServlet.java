package com.jishan.action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishan.biz.IBookBiz;
import com.jishan.biz.impl.BookBizImpl;
import com.jishan.entity.Book;

/**
 * Servlet implementation class ToUpdateBookServlet
 */
public class ToUpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToUpdateBookServlet() {
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
		System.out.print("222222"+request.getParameter("bnum"));
		int bnum =Integer.parseInt(request.getParameter("bnum")) ;
		IBookBiz biz= new BookBizImpl() ;
		Book book = biz.showBookById(bnum) ;
		
		request.setAttribute("book", book);
		System.out.println(book.getBnum());
		String path = "updateBook.jsp" ;
		request.getRequestDispatcher(path).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
