package com.jishan.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jishan.biz.IBookBiz;
//import com.jishan.biz.IBookTypeBiz;
import com.jishan.biz.impl.BookBizImpl;
//import com.jishan.biz.impl.BookTypeBizImpl;
import com.jishan.entity.Book;
//import com.jishan.entity.BookType;
import com.jishan.util.DateTools;

/**
 * Servlet implementation class AddNewBookServlet
 */
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
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
		
		
		//int booktypeid = 0 ;
		String bname = null ;
		String bphoto = null ;
		String bauthor  = null ;
		String bintro = null ;
		float bprice = 0.0f ;
		String bcate=null;
		String bpcom=null;
		int bword=0;
		//float presentprice = 0.0f;
		String bpdate = DateTools.dateToString(new Date()) ;
//		int shelfstate = Integer.parseInt(request.getParameter("shelfstate")) ;
//		System.out.println("�ϼ�״̬Ϊ�� "+shelfstate);
//		int shelfstate = -1 ;
		
		//����Ӳ���ļ��ؼ������࣬���������ؼ�����
		DiskFileItemFactory dfif = new DiskFileItemFactory() ;
		//����ļ��ϴ��࣬���ؿؼ�������
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		try {
			//��ǰ�˷��͵�request����ת��Ϊ�ؼ����󼯺�
			List<FileItem> fileItems =  sfu.parseRequest(request);
			
			//�������ϣ�������ÿһ��Ԫ�ص����������ж�
			for(FileItem item :fileItems){
				//���Ԫ��item����������
				if(item.isFormField()){
					String name =item.getFieldName();
				//	if("booktypename".equals(name)){
					//	String booktypename = item.getString("UTF-8");
					//	System.out.println("�鼮������Ϊ�� "+booktypename);
						//IBookTypeBiz typeBiz = new BookTypeBizImpl();
					//	BookType booktype =typeBiz.showBookTypeByName(booktypename) ;
					//	if(booktype!=null){
					//		booktypeid = booktype.getBooktypeid();
					//	}
					if("bname".equals(name)){
						bname = item.getString("UTF-8");
					}else if("bauthor".equals(name)){
						bauthor =item.getString("UTF-8");
					}else if("bintro".equals(name)){
						bintro = item.getString("UTF-8");
					}else if("bprice".equals(name)){
						bprice = Float.parseFloat(item.getString("UTF-8"));
					}else if("bcate".equals(name)){
						bcate = item.getString("UTF-8");
					}else if("bpcom".equals(name)){
						bpcom = item.getString("UTF-8");
					}else if("bpcom".equals(name)){
						bpcom = item.getString("UTF-8");
					}else if("bword".equals(name)){
						bword = Integer.parseInt(item.getString("UTF-8"));
					}
//					}else if("shelfstate".equals(name)){
//						System.out.println("�ϼ�״̬Ϊ��"+item.getString("UTF-8"));
//						shelfstate = Integer.parseInt(item.getString("UTF-8"));
						/*��ѡ�еĵ�ѡ��ͨ��item.getString("UTF-8")������õ�ֵΪ0
						 * ����nameΪshelfstate�Ŀؼ�Ϊ��ѡ�򣬼���2��name=shelfstate��<option>��ǩ��
						 * ����item.getString("UTF-8")�ó���ֵ��ʾ���Ǻ�һ����ѡ���Ƿ�ѡ��
						 * ��ѡ���� item.getString("UTF-8") = "on" ,����Ϊoff
						 * */
//						if("on".equals(item.getString("UTF-8"))){
//							shelfstate = 0 ;
//						}else{
//							shelfstate = 1 ;
//						}
						
					
					
				}else {
					/* ��ȡ���͵��ļ�·��
					 * �˴�ע�⣺��ͬ�������õ�·����ͬ��
					 * �е��������õ�һ������·��
					 * �е������ֻ��õ�һ���ļ���
					 * */
					String name = item.getName();
					System.out.println("name: "+name);
					String name2 = name.substring(name.lastIndexOf("\\")+1);
					try {
						//String realPath = this.getServletContext().getRealPath("upload") ;
						String realPath = request.getSession().getServletContext().getRealPath("upload") ;
						//String realPath = this.getServletContext().getRealPath("/");
						System.out.println("realPath: "+realPath);
						bphoto = "upload"+"\\"+name2 ;
						/**1.�˴���new File("/upload")����new File("upload"),����ʵ·��ΪE:/Tomcat6.0/bin/upload������ʵ·����binĿ¼��
						 * ����ʹ��this.getServletContext().getRealPath("upload")
						 * ����request.getSession().getServletContext().getRealPath("upload")
						 * ������·��ӳ�����ʵ����·�����������ļ��� E:/Tomcat6.0/webapps/bookcity/upload
						 * ������io����д�ļ���txt��properties�ȣ��Ĵ�ͳ��ʽʱ����Ҫע������·��������
						 * 
						 * 2.ת�����ض��� request.getRequestDispatcher(path) response.sendRedirect(path)
						 * ����path���������request��response��·������
						 * ��request.getContextPath()Ϊ/bookcity��ע�ⷵ�ؽ�����Ǿ���·���� ���Եó���·����Ϊ��Ŀ��·��
						*/
						File file = new File(realPath) ;
						
						if(!file.exists()){
							file.mkdirs() ;
						}
						item.write(new File(realPath,name2));
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//ȡֵ��ϣ������������ݷ�װ��book�ಢ�浽���ݿ�
		Book book = new Book() ;
		book.setBname(bname);
		book.setBphoto(bphoto);
		book.setBauthor(bauthor);
		book.setBintro(bintro);
		book.setBprice(bprice);
		book.setBcate(bcate);
		book.setBpdate(bpdate);
		book.setBpcom(bpcom);
		book.setBword(bword);
		IBookBiz biz = new BookBizImpl() ;
		biz.saveBook(book);
		
		//��ʾ���ӳɹ�
		PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet exercise</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<script>alert('�����ɹ���');window.location.href='book_add.jsp'</script>");
        out.println("</body>");
        out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
