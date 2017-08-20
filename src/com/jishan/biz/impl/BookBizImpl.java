package com.jishan.biz.impl;

import java.util.List;

import com.jishan.biz.IBookBiz;
import com.jishan.dao.IBookDao;
import com.jishan.dao.impl.BookDaoImpl;
import com.jishan.entity.Book;

public class BookBizImpl implements IBookBiz{
	IBookDao  dao  ;
	public BookBizImpl(){
		dao = new BookDaoImpl() ;
	}
	@Override
	public List<Book> showBookList() {
		return dao.showBookList() ;
	}
	@Override
	public void deleteBookById(int bnum) {
		dao.deleteBookById(bnum);
	}
	@Override
	public Book showBookById(int bnum) {
		return dao.showBookById(bnum);
	}
	@Override
	public void updateBook(Book book) {
		dao.updateBook(book);
	}
	@Override
	public void saveBook(Book book) {
		dao.saveBook(book);
		
	}
	@Override
	public List<Book> showChildrenBookList() {
		// TODO Auto-generated method stub
		return dao.showChildrenBookList() ;
	}
	@Override
	public List<Book> showNovelBookList() {
		// TODO Auto-generated method stub
		return dao.showNovelBookList() ;
	}
	@Override
	public List<Book> showTeachBookList() {
		// TODO Auto-generated method stub
		return dao.showTeachBookList() ;
	}
	@Override
	public List<Book> showHistoryBookList() {
		// TODO Auto-generated method stub
		return dao.showHistoryBookList() ;
	}
	@Override
	public List<Book> showYoungBookList() {
		// TODO Auto-generated method stub
		return dao.showYoungBookList() ;
	}
	@Override
	public List<Book> showSuccessBookList() {
		// TODO Auto-generated method stub
		return dao.showSuccessBookList() ;
	}
	@Override
	public List<Book> showTechnologyBookList() {
		// TODO Auto-generated method stub
		return dao.showTechnologyBookList() ;
	}
	@Override
	public List<Book> showReligionBookList() {
		// TODO Auto-generated method stub
		return dao.showReligionBookList() ;
	}
	@Override
	public Book showBookByName(String bname) {

		return dao.showBookByName(bname);
	}
	@Override
	public List<Book> showSearchBookList(String bname) {
		// TODO Auto-generated method stub
		return dao.showSearchBookList(bname);
	}

}
