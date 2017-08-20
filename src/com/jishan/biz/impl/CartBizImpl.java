package com.jishan.biz.impl;

import java.util.List;

import com.jishan.biz.IBookBiz;
import com.jishan.biz.ICartBiz;
import com.jishan.dao.IBookDao;
import com.jishan.dao.ICartDao;
import com.jishan.dao.impl.BookDaoImpl;
import com.jishan.dao.impl.CartDaoImpl;
import com.jishan.entity.Book;
import com.jishan.entity.Cart;

public class CartBizImpl implements ICartBiz {
	ICartDao dao;
	public CartBizImpl(){
		dao = new CartDaoImpl() ;
	}
	@Override
	public void saveCart(Cart cart){
		dao.saveCart(cart);
	}
	@Override
	public Cart showCartById(int userId, int bookId) {
		Cart cart = dao.showCartById(userId, bookId);
		if(cart!=null){
			int bookid = cart.getBnum() ;
			IBookDao bookDao = new BookDaoImpl();
			Book book =bookDao.showBookById(bookid) ;
			cart.setBook(book);
		}
		return cart ;
	}
	@Override
	public void updateCart(Cart cart) {
		dao.updateCart(cart);
	}
	
	//在Biz层为每个Cart对象添加Book这一成员变量
	@Override
	public List<Cart> showCartList(int userid) {
		 List<Cart> cartList = dao.showCartList(userid) ;
		 for(Cart cart:cartList){
			 int bnum =cart.getBnum() ;
			 IBookBiz bookBiz = new BookBizImpl() ;
			 Book book = bookBiz.showBookById(bnum) ;
			 cart.setBook(book);
		 }
		return cartList;
	}
	@Override
	public void deleteCart(int userid, int bookid) {
		dao.deleteCart(userid, bookid);
	}
	
}
