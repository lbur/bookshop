package com.jishan.entity;

public class Book {
	private int bnum;//书籍id
	private String bname ; //书籍名
	private String bphoto;//书籍封面图片的路径
	private String bauthor ;//作者
	private String bintro ;//简介
	private float bprice;//原价
	private String bcate ;//书籍类别
	private String bpdate ;//出版日期
	private String bpcom;//出版社
	private int bword;//书籍字数
	
	public int getBnum() {
		return bnum;
	}
	public void setBnum(int bnum) {
		this.bnum = bnum;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBphoto() {
		return bphoto;
	}
	public void setBphoto(String bphoto) {
		this.bphoto = bphoto;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	public String getBintro() {
		return bintro;
	}
	public void setBintro(String bintro) {
		this.bintro = bintro;
	}
	public float getBprice() {
		return bprice;
	}
	public void setBprice(float bprice) {
		this.bprice = bprice;
	}
	public String getBcate() {
		return bcate;
	}
	public void setBcate(String bcate) {
		this.bcate = bcate;
	}
	public String getBpdate() {
		return bpdate;
	}
	public void setBpdate(String bpdate) {
		this.bpdate = bpdate;
	}
	public String getBpcom() {
		return bpcom;
	}
	public void setBpcom(String bpcom) {
		this.bpcom = bpcom;
	}
	public int getBword() {
		return bword;
	}
	public void setBword(int bword) {
		this.bword = bword;
	}
	
	
	
//	public int getBookid() {
//		return bnum;
//	}
//	public void setBookid(int bnum) {
//		this.bnum = bnum;
//	}	
//	public String getBookname() {
//		return bname;
//	}
//	public void setBookname(String bname) {
//		this.bname = bname;
//	}
//	public String getCoverphoto() {
//		return bphoto;
//	}
//	public void setCoverphoto(String bphoto) {
//		this.bphoto = bphoto;
//	}
//	public String getAuthor() {
//		return bauthor;
//	}
//	public void setAuthor(String bauthor) {
//		this.bauthor = bauthor;
//	}
//	public String getBrief_intr() {
//		return bintro;
//	}
//	public void setBrief_intr(String bintro) {
//		this.bintro = bintro;
//	}
//	public float getPresentprice() {
//		return bprice;
//	}
//	public void setPresentprice(float bprice) {
//		this.bprice = bprice;
//	}
//	public String getBookcategory() {
//		return bcate;
//	}
//	public void setBookcategory(String bcate) {
//		this.bcate = bcate;
//	}
//	public String getBookpcom() {
//		return bpcom;
//	}
//	public void setBookpcom(String bpcom) {
//		this.bpcom = bpcom;
//	}
//	public String getBookpdate() {
//		return bpdate;
//	}
//	public void setBookpdate(String bpdate) {
//		this.bpdate = bpdate;
//	}
//	public int getBookword() {
//		return bword;
//	}
//	public void setBookword(int bword) {
//		this.bword = bword;
//	}	
}

