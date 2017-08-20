package com.jishan.dao.impl;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	import com.jishan.dao.IUserloginDao;
	import com.jishan.entity.User;
	import com.jishan.util.JdbcUtilTemp;

	public class IUserloginDaoImpl implements IUserloginDao{ 
		JdbcUtilTemp jdbcUtilTemp = new JdbcUtilTemp() ;
		@Override
		public User showUserByName(String username) {
			User user = null ;
			Connection conn = null ;
			PreparedStatement pstmt = null ;
			String sql = "select uid,user_name,password,realname,sex,idcard,email,addr,phone from t_user where user_name=?";
			ResultSet rs = null ;
			try {
				conn = jdbcUtilTemp.getConnection() ;
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				rs= pstmt.executeQuery() ;
				while(rs.next()){
					user = new User() ;
					user.setUid(rs.getInt("uid"));
					user.setUsername(rs.getString("user_name"));
					user.setPassword(rs.getString("password"));
					user.setRealname(rs.getString("realname"));
					user.setSex(rs.getString("sex"));
					user.setIdcard(rs.getString("idcard"));
					user.setEmail(rs.getString("email"));
					user.setAddr(rs.getString("addr"));
					user.setPhone(rs.getString("phone"));					
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				jdbcUtilTemp.closeAll(rs, pstmt, conn);
			}
			return user;
		}
		
	}
