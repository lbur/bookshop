package com.jishan.action;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ImageServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		
		BufferedImage image=new BufferedImage(80, 40, BufferedImage.TYPE_INT_RGB);
		//Graphics画笔对象.
		Graphics g=image.getGraphics();
		//随机对象
		Random r=new Random();
		//为图片添加不同颜色的背景
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
		g.fillRect(0, 0, 80, 40);
		g.setColor(Color.green);
		//int num=r.nextInt(999999);
		//随机字符
		String[] sum={"A","B","C","D","E","F","G","H","R","J","K","L"};
		
		String num="";
		for(int i=0;i<4;i++){
//			String n=r.nextInt(10);
			String n = sum[r.nextInt(sum.length)];
			num =num+n;
		}
		//获取装载验证码的对象 session.会话对象
		HttpSession session=request.getSession();

		session.setAttribute("yanzhengma", num);
		
		g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

		g.setFont(new Font("黑体",20,20));
		g.drawString(num, 10, 24);
		//得到一个输出流
		OutputStream dest=response.getOutputStream();
		//通过输出流构建输出图片的对象JPEGImageEncoder
		JPEGImageEncoder encoder=JPEGCodec.createJPEGEncoder(dest);
		//通过JPEGImageEncoder.encode可以将内存中的图片传输出去。
		encoder.encode(image);
	}

}
