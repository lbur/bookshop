package com.jishan.entity;

public class Collection {
	private int collectionid ;//购物车id
	private int userid ;//用户id
	private int bnum;//书籍id
	private Book book;
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public int getCollectionid() {
		return collectionid;
	}
	public void setCollectionid(int collectionid) {
		this.collectionid = collectionid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
