package com.jishan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jishan.dao.IBookDao;
import com.jishan.entity.Book;
import com.jishan.util.JdbcUtilTemp;

public class BookDaoImpl implements IBookDao {

	private JdbcUtilTemp jdbcUtilTemp  = new JdbcUtilTemp() ;
	@Override
	public List<Book> showBookList() {
		//����һ������
		List<Book> list = new ArrayList<Book>() ;
		//1.��������
		//2����ȡ����
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select * from t_books" ;
		ResultSet rs = null ;
		try {
			//3.��ȡ�Ự����
			pstmt =conn.prepareStatement(sql);
			
			//4.ִ��sql���,��ý����
			rs =pstmt.executeQuery() ;
			//5.���������
			
			while(rs.next()){
				Book book = new Book() ;
				book.setBnum(rs.getInt("bnum"));
				book.setBname(rs.getString("bname")) ;
				book.setBphoto(rs.getString("bphoto")) ;
				book.setBauthor(rs.getString("bauthor"));
				book.setBintro(rs.getString("bintro"));
				book.setBprice(rs.getFloat("bprice"));
				book.setBcate(rs.getString("bcate"));
				book.setBpcom(rs.getString("bpcom"));
				book.setBpdate(rs.getString("bpdate")) ;
				book.setBword(rs.getInt("bword")) ;
				list.add(book) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//6.�ر���Դ
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return list ;
	}
	
	@Override
	public void deleteBookById(int bnum) {
		Connection conn = jdbcUtilTemp.getConnection() ;
		PreparedStatement pstmt = null ;
		String sql = "delete from t_books where bnum=?" ;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1 ,bnum) ;
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(null, pstmt, conn);
		}
		
	}



	@Override
	public Book showBookById(int bnum) {
		Book book = null ;
		Connection conn = jdbcUtilTemp.getConnection() ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql ="select * from t_books where bnum = ?" ;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1 ,bnum) ;
			rs = pstmt.executeQuery();
			while(rs.next()){
				book = new Book() ;
				book.setBnum(rs.getInt("bnum"));
				book.setBname(rs.getString("bname")) ;
				book.setBphoto(rs.getString("bphoto")) ;
				book.setBauthor(rs.getString("bauthor"));
				book.setBintro(rs.getString("bintro"));
				book.setBprice(rs.getFloat("bprice"));
				book.setBcate(rs.getString("bcate"));
				book.setBpcom(rs.getString("bpcom"));
				book.setBpdate(rs.getString("bpdate")) ;
				book.setBword(rs.getInt("bword")) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return book;
	}

	@Override
	public void updateBook(Book book) {
		Connection conn = jdbcUtilTemp.getConnection() ;
		PreparedStatement pstmt = null ;
		//System.out.println(book.getBname());
	String sql = "update t_books set bname=?,bauthor=?,bprice=?,bcate=?,bpdate=?,bpcom=?,bword=?,bintro=?,bphoto=? where bnum=?" ;
		try {
			pstmt = conn.prepareStatement(sql);
			int i = 1 ;
			//pstmt.setInt(i++, book.getBnum());
			pstmt.setString(i++, book.getBname());
			pstmt.setString(i++, book.getBauthor());
	     	pstmt.setFloat(i++, book.getBprice());
			pstmt.setString(i++, book.getBcate());
			pstmt.setString(i++, book.getBpdate());
			pstmt.setString(i++, book.getBpcom());			
			pstmt.setInt(i++, book.getBword());
			pstmt.setString(i++, book.getBintro());
			pstmt.setString(i++, book.getBphoto());
			pstmt.setInt(i++, book.getBnum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(null, pstmt, conn);
		}
	}
	
	@Override
	public void saveBook(Book book) {
		Connection conn = jdbcUtilTemp.getConnection() ;
		PreparedStatement pstmt = null ;
		String sql = "insert into t_books(bname,bauthor,bprice,bcate,bpdate,bpcom,bword,bintro,bphoto) values(?,?,?,?,?,?,?,?,?)" ;
		try {
			pstmt = conn.prepareStatement(sql);
			int i = 1 ;
			pstmt.setString(i++, book.getBname());
			pstmt.setString(i++, book.getBauthor());
	     	pstmt.setFloat(i++, book.getBprice());
			pstmt.setString(i++, book.getBcate());
			pstmt.setString(i++, book.getBpdate());
			pstmt.setString(i++, book.getBpcom());			
			pstmt.setInt(i++, book.getBword());
			pstmt.setString(i++, book.getBintro());
			pstmt.setString(i++, book.getBphoto());
			System.out.print("������"+book.getBname());
			pstmt.executeUpdate() ;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(null, pstmt, conn);
		}
	}

	@Override
	public List<Book> showChildrenBookList() {
		//����һ������
				List<Book> list = new ArrayList<Book>() ;
				//1.��������
				//2����ȡ����
				Connection conn = jdbcUtilTemp.getConnection();
				PreparedStatement pstmt= null ;
				String sql = "select * from t_books where bcate='ͯ��'" ;
				ResultSet rs = null ;
				try {
					//3.��ȡ�Ự����
					pstmt =conn.prepareStatement(sql);
					
					//4.ִ��sql���,��ý����
					rs =pstmt.executeQuery() ;
					//5.���������
					
					while(rs.next()){
						Book book = new Book() ;
						book.setBnum(rs.getInt("bnum"));
						book.setBname(rs.getString("bname")) ;
						book.setBphoto(rs.getString("bphoto")) ;
						book.setBauthor(rs.getString("bauthor"));
						book.setBintro(rs.getString("bintro"));
						book.setBprice(rs.getFloat("bprice"));
						book.setBcate(rs.getString("bcate"));
						book.setBpcom(rs.getString("bpcom"));
						book.setBpdate(rs.getString("bpdate")) ;
						book.setBword(rs.getInt("bword")) ;
						list.add(book) ;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					//6.�ر���Դ
					jdbcUtilTemp.closeAll(rs, pstmt, conn);
				}
				return list ;
			}

	@Override
	public List<Book> showNovelBookList() {
		//����һ������
		List<Book> list = new ArrayList<Book>() ;
		//1.��������
		//2����ȡ����
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select * from t_books where bcate='С˵'" ;
		ResultSet rs = null ;
		try {
			//3.��ȡ�Ự����
			pstmt =conn.prepareStatement(sql);
			
			//4.ִ��sql���,��ý����
			rs =pstmt.executeQuery() ;
			//5.���������
			
			while(rs.next()){
				Book book = new Book() ;
				book.setBnum(rs.getInt("bnum"));
				book.setBname(rs.getString("bname")) ;
				book.setBphoto(rs.getString("bphoto")) ;
				book.setBauthor(rs.getString("bauthor"));
				book.setBintro(rs.getString("bintro"));
				book.setBprice(rs.getFloat("bprice"));
				book.setBcate(rs.getString("bcate"));
				book.setBpcom(rs.getString("bpcom"));
				book.setBpdate(rs.getString("bpdate")) ;
				book.setBword(rs.getInt("bword")) ;
				list.add(book) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//6.�ر���Դ
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return list ;
	}

	@Override
	public List<Book> showTeachBookList() {
		//����һ������
				List<Book> list = new ArrayList<Book>() ;
				//1.��������
				//2����ȡ����
				Connection conn = jdbcUtilTemp.getConnection();
				PreparedStatement pstmt= null ;
				String sql = "select * from t_books where bcate='�̸�'" ;
				ResultSet rs = null ;
				try {
					//3.��ȡ�Ự����
					pstmt =conn.prepareStatement(sql);
					
					//4.ִ��sql���,��ý����
					rs =pstmt.executeQuery() ;
					//5.���������
					
					while(rs.next()){
						Book book = new Book() ;
						book.setBnum(rs.getInt("bnum"));
						book.setBname(rs.getString("bname")) ;
						book.setBphoto(rs.getString("bphoto")) ;
						book.setBauthor(rs.getString("bauthor"));
						book.setBintro(rs.getString("bintro"));
						book.setBprice(rs.getFloat("bprice"));
						book.setBcate(rs.getString("bcate"));
						book.setBpcom(rs.getString("bpcom"));
						book.setBpdate(rs.getString("bpdate")) ;
						book.setBword(rs.getInt("bword")) ;
						list.add(book) ;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally{
					//6.�ر���Դ
					jdbcUtilTemp.closeAll(rs, pstmt, conn);
				}
				return list ;
	}

	@Override
	public List<Book> showHistoryBookList() {
		//����һ������
		List<Book> list = new ArrayList<Book>() ;
		//1.��������
		//2����ȡ����
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select * from t_books where bcate='��ʷ'" ;
		ResultSet rs = null ;
		try {
			//3.��ȡ�Ự����
			pstmt =conn.prepareStatement(sql);
			
			//4.ִ��sql���,��ý����
			rs =pstmt.executeQuery() ;
			//5.���������
			
			while(rs.next()){
				Book book = new Book() ;
				book.setBnum(rs.getInt("bnum"));
				book.setBname(rs.getString("bname")) ;
				book.setBphoto(rs.getString("bphoto")) ;
				book.setBauthor(rs.getString("bauthor"));
				book.setBintro(rs.getString("bintro"));
				book.setBprice(rs.getFloat("bprice"));
				book.setBcate(rs.getString("bcate"));
				book.setBpcom(rs.getString("bpcom"));
				book.setBpdate(rs.getString("bpdate")) ;
				book.setBword(rs.getInt("bword")) ;
				list.add(book) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//6.�ر���Դ
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return list ;
	}

	@Override
	public List<Book> showYoungBookList() {
		//����һ������
		List<Book> list = new ArrayList<Book>() ;
		//1.��������
		//2����ȡ����
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select * from t_books where bcate='�ഺ��ѧ'" ;
		ResultSet rs = null ;
		try {
			//3.��ȡ�Ự����
			pstmt =conn.prepareStatement(sql);
			
			//4.ִ��sql���,��ý����
			rs =pstmt.executeQuery() ;
			//5.���������
			
			while(rs.next()){
				Book book = new Book() ;
				book.setBnum(rs.getInt("bnum"));
				book.setBname(rs.getString("bname")) ;
				book.setBphoto(rs.getString("bphoto")) ;
				book.setBauthor(rs.getString("bauthor"));
				book.setBintro(rs.getString("bintro"));
				book.setBprice(rs.getFloat("bprice"));
				book.setBcate(rs.getString("bcate"));
				book.setBpcom(rs.getString("bpcom"));
				book.setBpdate(rs.getString("bpdate")) ;
				book.setBword(rs.getInt("bword")) ;
				list.add(book) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//6.�ر���Դ
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return list ;
	}

	@Override
	public List<Book> showSuccessBookList() {
		//����һ������
		List<Book> list = new ArrayList<Book>() ;
		//1.��������
		//2����ȡ����
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select * from t_books where bcate='�ɹ���־'" ;
		ResultSet rs = null ;
		try {
			//3.��ȡ�Ự����
			pstmt =conn.prepareStatement(sql);
			
			//4.ִ��sql���,��ý����
			rs =pstmt.executeQuery() ;
			//5.���������
			
			while(rs.next()){
				Book book = new Book() ;
				book.setBnum(rs.getInt("bnum"));
				book.setBname(rs.getString("bname")) ;
				book.setBphoto(rs.getString("bphoto")) ;
				book.setBauthor(rs.getString("bauthor"));
				book.setBintro(rs.getString("bintro"));
				book.setBprice(rs.getFloat("bprice"));
				book.setBcate(rs.getString("bcate"));
				book.setBpcom(rs.getString("bpcom"));
				book.setBpdate(rs.getString("bpdate")) ;
				book.setBword(rs.getInt("bword")) ;
				list.add(book) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//6.�ر���Դ
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return list ;
	}

	@Override
	public List<Book> showTechnologyBookList() {
		//����һ������
		List<Book> list = new ArrayList<Book>() ;
		//1.��������
		//2����ȡ����
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select * from t_books where bcate='�Ƽ�'" ;
		ResultSet rs = null ;
		try {
			//3.��ȡ�Ự����
			pstmt =conn.prepareStatement(sql);
			
			//4.ִ��sql���,��ý����
			rs =pstmt.executeQuery() ;
			//5.���������
			
			while(rs.next()){
				Book book = new Book() ;
				book.setBnum(rs.getInt("bnum"));
				book.setBname(rs.getString("bname")) ;
				book.setBphoto(rs.getString("bphoto")) ;
				book.setBauthor(rs.getString("bauthor"));
				book.setBintro(rs.getString("bintro"));
				book.setBprice(rs.getFloat("bprice"));
				book.setBcate(rs.getString("bcate"));
				book.setBpcom(rs.getString("bpcom"));
				book.setBpdate(rs.getString("bpdate")) ;
				book.setBword(rs.getInt("bword")) ;
				list.add(book) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//6.�ر���Դ
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return list ;
	}

	@Override
	public List<Book> showReligionBookList() {
		//����һ������
		List<Book> list = new ArrayList<Book>() ;
		//1.��������
		//2����ȡ����
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select * from t_books where bcate='��ѧ�ڽ�'" ;
		ResultSet rs = null ;
		try {
			//3.��ȡ�Ự����
			pstmt =conn.prepareStatement(sql);
			
			//4.ִ��sql���,��ý����
			rs =pstmt.executeQuery() ;
			//5.���������
			
			while(rs.next()){
				Book book = new Book() ;
				book.setBnum(rs.getInt("bnum"));
				book.setBname(rs.getString("bname")) ;
				book.setBphoto(rs.getString("bphoto")) ;
				book.setBauthor(rs.getString("bauthor"));
				book.setBintro(rs.getString("bintro"));
				book.setBprice(rs.getFloat("bprice"));
				book.setBcate(rs.getString("bcate"));
				book.setBpcom(rs.getString("bpcom"));
				book.setBpdate(rs.getString("bpdate")) ;
				book.setBword(rs.getInt("bword")) ;
				list.add(book) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//6.�ر���Դ
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return list ;
	}
	
	@Override
	public List<Book> showSearchBookList(String bname) {
		//����һ������
		List<Book> list = new ArrayList<Book>() ;
		//1.��������
		//2����ȡ����
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select * from t_books where bname like ?" ;
		ResultSet rs = null ;
		try {
			//3.��ȡ�Ự����
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1 ,"%"+bname+"%") ;
			//4.ִ��sql���,��ý����
			rs =pstmt.executeQuery() ;
			//5.���������
			
			while(rs.next()){
				Book book = new Book() ;
				book.setBnum(rs.getInt("bnum"));
				book.setBname(rs.getString("bname")) ;
				book.setBphoto(rs.getString("bphoto")) ;
				book.setBauthor(rs.getString("bauthor"));
				book.setBintro(rs.getString("bintro"));
				book.setBprice(rs.getFloat("bprice"));
				book.setBcate(rs.getString("bcate"));
				book.setBpcom(rs.getString("bpcom"));
				book.setBpdate(rs.getString("bpdate")) ;
				book.setBword(rs.getInt("bword")) ;
				list.add(book) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//6.�ر���Դ
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return list ;
	}

	@Override
	public Book showBookByName(String bname) {
		Book book = null ;
		Connection conn = jdbcUtilTemp.getConnection() ;
		PreparedStatement pstmt = null ;
		ResultSet rs = null ;
		String sql ="select * from t_books where bname like ? ";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1 ,"%"+bname+"%") ;
			rs = pstmt.executeQuery();
			while(rs.next()){
				book = new Book() ;
				book.setBnum(rs.getInt("bnum"));
				book.setBname(rs.getString("bname")) ;
				book.setBphoto(rs.getString("bphoto")) ;
				book.setBauthor(rs.getString("bauthor"));
				book.setBintro(rs.getString("bintro"));
				book.setBprice(rs.getFloat("bprice"));
				book.setBcate(rs.getString("bcate"));
				book.setBpcom(rs.getString("bpcom"));
				book.setBpdate(rs.getString("bpdate")) ;
				book.setBword(rs.getInt("bword")) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return book;
	}
			
}
