package com.jishan.entity;

public class Order {
	private int orderid ;  //����id
	private int ordernum ;  //�������
	private int userid ;   //�û�id
	private int username ;  //�û�����
	private int bname;    //�鼮��
	private int bprice ; //�鼮����
	private int bcount ;  //�鼮����
	private int ballprice ;//�ܼ�
	private int addr;     //�ջ���ַ���û���ַ��
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
	
	

