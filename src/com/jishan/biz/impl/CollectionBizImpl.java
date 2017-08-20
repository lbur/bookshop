package com.jishan.biz.impl;

import java.util.List;

import com.jishan.biz.IBookBiz;
import com.jishan.biz.ICollectionBiz;
import com.jishan.dao.IBookDao;
import com.jishan.dao.ICollectionDao;
import com.jishan.dao.impl.BookDaoImpl;
import com.jishan.dao.impl.CollectionDaoImpl;
import com.jishan.entity.Book;
import com.jishan.entity.Collection;

public class CollectionBizImpl implements ICollectionBiz {
	ICollectionDao dao;
	public CollectionBizImpl(){
		dao = new CollectionDaoImpl() ;
	}
	@Override
	public void saveCollection(Collection Collection){
		dao.saveCollection(Collection);
	}
	@Override
	public Collection showCollectionById(int userId, int bookId) {
		Collection Collection = dao.showCollectionById(userId, bookId);
		if(Collection!=null){
			int bookid = Collection.getBnum() ;
			IBookDao bookDao = new BookDaoImpl();
			Book book =bookDao.showBookById(bookid) ;
			Collection.setBook(book);
		}
		return Collection ;
	}
	@Override
	public void updateCollection(Collection Collection) {
		dao.updateCollection(Collection);
	}
	
	//在Biz层为每个Collection对象添加Book这一成员变量
	@Override
	public List<Collection> showCollectionList(int userid) {
		 List<Collection> CollectionList = dao.showCollectionList(userid) ;
		 for(Collection Collection:CollectionList){
			 int bnum =Collection.getBnum() ;
			 IBookBiz bookBiz = new BookBizImpl() ;
			 Book book = bookBiz.showBookById(bnum) ;
			 Collection.setBook(book);
		 }
		return CollectionList;
	}
	@Override
	public void deleteCollection(int userid, int bookid) {
		dao.deleteCollection(userid, bookid);
	}
	
}
