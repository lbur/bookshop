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
		//�涨ÿҳ�����ʾ����������
		int pageSize =10;
		/*��Ԫ���ʽ   ���ʽ��a:b
		 * pageNo��Ӧ����� Ϊ �� �������Ա������ġ��û��б���ť����Ĭ����ʾ��һҳpageSize������
		 * ������ת֮ǰ����������ΪpageNo�Ŀؼ������Դ�ʱrequest.getParameter("pageNo")��ȡֵΪnull ;
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
		//���÷�����ȡ���������ĵڶ���������������¼
		List<User> userList = biz.showUserListByPage(pageNo, pageSize);
		System.out.println("this userList is: "+userList.size());
		
		/*������Ҫǰ̨ҳ����ʾ�����ݣ�
		 * 1.userList  ǰ̨��Ҫ��ʾ���û��б����壩
		 * 2.pageNo �����һҳ����һҳ�����ĳ������Ժ���ת��ҳ�����pageNo���ڼ�ҳ�������˱仯
		 * 3.maxPageNo ������ҳ
		 * 4.
		 */
		request.setAttribute("userList", userList) ;
		request.setAttribute("pageNo", pageNo) ;
		//����������¼
		int maxSize =biz.showUserList().size() ;
		int maxPageNo = maxSize%pageSize ==0?maxSize/pageSize :maxSize/pageSize+1 ;
		request.setAttribute("maxPageNo", maxPageNo) ;
		
		//�����תҳ��
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
