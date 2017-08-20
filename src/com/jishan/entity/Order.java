package com.jishan.entity;

public class Order {
	private int orderid ;  //订单id
	private int ordernum ;  //订单编号
	private int userid ;   //用户id
	private int username ;  //用户姓名
	private int bname;    //书籍名
	private int bprice ; //书籍单价
	private int bcount ;  //书籍数量
	private int ballprice ;//总价
	private int addr;     //收货地址（用户地址）
	private Order order;
	public int getOrderid() {
		return orderid;
	}
	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getUsername() {
		return username;
	}
	public void setUsername(int username) {
		this.username = username;
	}
	public int getBname() {
		return bname;
	}
	public void setBname(int bname) {
		this.bname = bname;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public int getBcount() {
		return bcount;
	}
	public void setBcount(int bcount) {
		this.bcount = bcount;
	}
	public int getBallprice() {
		return ballprice;
	}
	public void setBallprice(int ballprice) {
		this.ballprice = ballprice;
	}
	public int getAddr() {
		return addr;
	}
	public void setAddr(int addr) {
		this.addr = addr;
	}
	public Order getOrder(){
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
}
	
	

