package com.jishan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jishan.dao.IOrderDao;
import com.jishan.entity.Order;
import com.jishan.util.JdbcUtilTemp;

public class OrderDaoImpl implements IOrderDao{
	JdbcUtilTemp jdbcUtilTemp = new JdbcUtilTemp() ;
	
	@Override
	public void saveOrder(Order order){
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt = null;
		String sql = "insert into t_order(ordernum,userid,bname,)";
	}
}
