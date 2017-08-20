package com.jishan.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.jishan.biz.IBookBiz;
import com.jishan.biz.impl.BookBizImpl;
import com.jishan.entity.Book;
import com.jishan.util.DateTools;

/**
 * Servlet implementation class UpdateBookServlet
 */
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBookServlet() {
        super();
        
    }
    
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int bnum = 0 ;
//		int booktypeid = 0 ;
		int bword=0;
		String bname = null ;
		String bphoto = null ;
		String bauthor  = null ;
		String bintro = null ;
		String bcate = null ;
		float bprice = 0.0f;
//		String bpdate = null ;
		String bpcom = null ;
		
		String bpdate = DateTools.dateToString(new Date()) ;
//		int shelfstate = Integer.parseInt(request.getParameter("shelfstate")) ;
//		System.out.println("上架状态为： "+shelfstate);
		int shelfstate = -1 ;
		
		//创建硬盘文件控件工厂类，用来解析控件对象
		DiskFileItemFactory dfif = new DiskFileItemFactory() ;
		//获得文件上传类，加载控件工厂类
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		try {
			//将前端发送的request对象转换为控件对象集合
			List<FileItem> fileItems =  sfu.parseRequest(request);
			
			//遍历集合，并根据每一个元素的类型作出判断
			for(FileItem item :fileItems){
				//如果元素item是正常表单域
				if(item.isFormField()){
					
//					System.out.println(item.getString("UTF-8")+"\n");

					String name =item.getFieldName();
					if("bnum".equals(name)){
						bnum = Integer.parseInt(item.getString("UTF-8"));
						System.out.println("booknumber: "+bnum);
					}else if("bword".equals(name)){
						bword = Integer.parseInt(item.getString("UTF-8"));
					}else if("bname".equals(name)){
						bname = item.getString("UTF-8");
					}else if("bauthor".equals(name)){
						bauthor =item.getString("UTF-8");
					}else if("bintro".equals(name)){
						bintro = item.getString("UTF-8");
					}else if("bprice".equals(name)){
						bprice = Float.parseFloat(item.getString("UTF-8"));
					}else if("bcate".equals(name)){
						bcate = item.getString("UTF-8");
					}
					else if("bpcom".equals(name)){
						bpcom = item.getString("UTF-8");
					
//					}else if("shelfstate".equals(name)){
//						System.out.println("上架状态为："+item.getString("UTF-8"));
//						shelfstate = Integer.parseInt(item.getString("UTF-8"));
						/*如果是单选框，通过item.getString("UTF-8")方法获得的值都为on
						 * 
						 * */
//						
						
					}
					
				}else {
					/* 获取发送的文件路径
					 * 此处注意：不同浏览器获得的路径不同。
					 * 有的浏览器会得到一个完整路径
					 * 有的浏览器只会得到一个文件名
					 * */
					String name = item.getName();
					System.out.println("name: "+name);
					String name2 = name.substring(name.indexOf("\\")+1);
					try {
						//String realPath = this.getServletContext().getRealPath("upload") ;
						String realPath = request.getSession().getServletContext().getRealPath("upload") ;
						System.out.println("realPath: "+realPath);
						bphoto = "upload"+"\\"+name2 ;
						/**1.此处若new File("/upload")或者new File("upload"),其真实路径为E:/Tomcat6.0/bin/upload，其真实路径在bin目录下
						 * 必须使用this.getServletContext().getRealPath("upload")
						 * 或者request.getSession().getServletContext().getRealPath("upload")
						 * 将虚拟路径映射成真实物理路径，即创建文件夹 E:/Tomcat6.0/webapps/bookcity/upload
						 * 这是用io流读写文件（txt，properties等）的传统方式时，需要注意的相对路径的问题
						 * 
						 * 2.转发和重定向 request.getRequestDispatcher(path) response.sendRedirect(path)
						 * 参数path都是相对于request和response的路径而言
						 * 从request.getContextPath()为/bookcity（注意返回结果不是绝对路径） 可以得出其路径即为项目根路径
						*/
						item.write(new File(realPath,name2));
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//取值完毕，接下来将数据封装成book类并存到数据库
		Book book = new Book() ;
		book.setBnum(bnum);
		book.setBname(bname);
		book.setBphoto(bphoto);
		book.setBauthor(bauthor);
		book.setBintro(bintro);
		book.setBprice(bprice);
		book.setBcate(bcate);
		book.setBpdate(bpdate);
		book.setBpcom(bpcom);
		book.setBword(bword);
		
		//System.out.println(book.getBname());
		IBookBiz biz = new BookBizImpl() ;
		biz.updateBook(book);
		//显示增加成功
		PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet exercise</title>");            
        out.println("</head>");
        out.println("<body>");
        out.println("<script>alert('修改成功！');</script>");
        out.println("</body>");
        out.println("</html>");
		//跳转回去，显示更改后的书籍列表
		String path = "ShowBookListServlet" ;
		response.sendRedirect(path);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
