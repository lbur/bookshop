package com.jishan.test;


import com.jishan.biz.IUserBiz;
import com.jishan.biz.impl.UserBizImpl;
import com.jishan.util.JdbcUtilTemp;
public class Demotest {
public static void main(String[] args){
	IUserBiz biz = new UserBizImpl();
	/* test the connection of datebase*/
	JdbcUtilTemp jdbcUtilTemp = new JdbcUtilTemp();
	jdbcUtilTemp.getConnection();
	String dingdan="1111"+System.currentTimeMillis();
	System.out.print(dingdan);
 }
}
