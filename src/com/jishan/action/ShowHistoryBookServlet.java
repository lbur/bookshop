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
 * Servlet implementation class ShowBookListServlet
 */
public class ShowHistoryBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowHistoryBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8") ;
		
		//创建Biz对象，查询所有的书籍列表
		IBookBiz biz = new BookBizImpl() ;
		List<Book> historybookList = biz.showHistoryBookList() ;
		
		//System.out.println(bookList.size());
		request.setAttribute("historybookList", historybookList) ;
		//跳转
		String path ="book_history.jsp" ;
		request.getRequestDispatcher(path).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
