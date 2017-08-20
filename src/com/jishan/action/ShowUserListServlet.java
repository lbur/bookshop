package com.jishan.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jishan.biz.IUserBiz;
import com.jishan.biz.impl.UserBizImpl;
import com.jishan.entity.User;

/**
 * Servlet implementation class ShowUserListServlet
 */
public class ShowUserListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowUserListServlet() {
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
		//规定每页最多显示多少条数据
		int pageSize =10;
		/*三元表达式   表达式？a:b
		 * pageNo对应的情况 为 ： 点击管理员左侧界面的《用户列表》按钮，会默认显示第一页pageSize条数据
		 * 由于跳转之前并不存在名为pageNo的控件，所以此时request.getParameter("pageNo")获取值为null ;
		 */
		//int pageNo = request.getParameter("pageNo")==null?1: Integer.parseInt(request.getParameter("pageNo"));
		int pageNo ;
		String pageNoPlus = request.getParameter("pageNo") ;
		if(pageNoPlus==null){
			pageNo=1 ;
		}else{
			pageNo =Integer.parseInt( pageNoPlus );
		}
		
		IUserBiz biz = new UserBizImpl() ;
		//调用方法获取符合条件的第多少条到多少条记录
		List<User> userList = biz.showUserListByPage(pageNo, pageSize);
		System.out.println("this userList is: "+userList.size());
		
		/*设置需要前台页面显示的数据：
		 * 1.userList  前台需要显示的用户列表（主体）
		 * 2.pageNo 点击上一页，下一页这样的超链接以后，跳转的页面里的pageNo（第几页）产生了变化
		 * 3.maxPageNo 最大多少页
		 * 4.
		 */
		request.setAttribute("userList", userList) ;
		request.setAttribute("pageNo", pageNo) ;
		//最多多少条记录
		int maxSize =biz.showUserList().size() ;
		int maxPageNo = maxSize%pageSize ==0?maxSize/pageSize :maxSize/pageSize+1 ;
		request.setAttribute("maxPageNo", maxPageNo) ;
		
		//最后跳转页面
		String path = "userlist.jsp" ;
		request.getRequestDispatcher(path).forward(request, response) ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
