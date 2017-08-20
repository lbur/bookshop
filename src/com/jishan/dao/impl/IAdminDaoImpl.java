package com.jishan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jishan.dao.IAdminDao;
import com.jishan.entity.Admin;
import com.jishan.util.JdbcUtilTemp;

public class IAdminDaoImpl implements IAdminDao {
	JdbcUtilTemp jdbcUtilTemp = new JdbcUtilTemp() ;
	@Override
	public Admin showAdminByName(String adminname) {
		Admin admin = null ;
		Connection conn = null ;
		PreparedStatement pstmt = null ;
		String sql = "select aid,adminname,password,realname from t_admin where adminname=?";
		ResultSet rs = null ;
		try {
			conn = jdbcUtilTemp.getConnection() ;
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminname);
			rs= pstmt.executeQuery() ;
			while(rs.next()){
				admin = new Admin() ;
				admin.setAid(rs.getInt("aid"));
				admin.setAdminname(rs.getString("adminname"));
				admin.setPassword(rs.getString("password"));
				admin.setRealname(rs.getString("realname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return admin;
	}
	
}
