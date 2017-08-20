package com.jishan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jishan.dao.ICartDao;
import com.jishan.entity.Cart;
import com.jishan.util.JdbcUtilTemp;

public class CartDaoImpl implements ICartDao {
	JdbcUtilTemp jdbcUtilTemp = new JdbcUtilTemp() ;
	
	@Override
	public void saveCart(Cart cart) {
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		
		String sql = "insert into t_cart(userid,bnum,bcount) values(?,?,?)" ;
		try {
			pstmt =conn.prepareStatement(sql) ;
			pstmt.setInt(1, cart.getUserid());
			pstmt.setInt(2, cart.getBnum());
			pstmt.setInt(3, cart.getBcount());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(null, pstmt, conn);
		}
		
	}

	@Override
	public Cart showCartById(int userId, int bNum) {
		Cart cart = null ;
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select cartid ,userid ,bnum ,bcount from t_cart where userid=? and bnum =?" ;
		ResultSet rs = null ;
		try {
			pstmt =conn.prepareStatement(sql) ;
			pstmt.setInt(1, userId);
			pstmt.setInt(2, bNum);
			rs= pstmt.executeQuery() ;
			if(rs.next()){
				cart = new Cart() ;
				cart.setCartid(rs.getInt("cartid"));
				cart.setUserid(rs.getInt("userid"));
				cart.setBnum(rs.getInt("bnum")) ;
				cart.setBcount(rs.getInt("bcount"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return cart;
	}

	@Override
	public void updateCart(Cart cart) {
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql ="update t_cart set cartid=?,userid=? ,bcount=? where bnum=?" ;
		try {
			pstmt =conn.prepareStatement(sql) ;
			pstmt.setLong(1, cart.getCartid());
			pstmt.setLong(2, cart.getUserid());
			pstmt.setInt(3, cart.getBcount());
			pstmt.setLong(4, cart.getBnum());
			pstmt.executeUpdate() ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtilTemp.closeAll(null, pstmt, conn);
		}
		
	}

	@Override
	public List<Cart> showCartList(int userid) {
		List<Cart> list = new ArrayList<Cart>() ;
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select cartid ,userid ,bnum ,bcount from t_cart where userid = ?" ;
		ResultSet rs = null ;
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
			rs =pstmt.executeQuery() ;
			while(rs.next()){
				Cart cart = new Cart() ;
				cart.setCartid(rs.getInt("cartid"));
				cart.setUserid(rs.getInt("userid"));
				cart.setBnum(rs.getInt("bnum")) ;
				cart.setBcount(rs.getInt("bcount"));
				list.add(cart) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return list ;
	}

	@Override
	public void deleteCart(int userid, int bnum) {
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "delete from t_cart where userid=? and bnum=?" ;
		try {
			pstmt = conn.prepareStatement(sql) ;
			pstmt.setInt(1, userid);
			pstmt.setInt(2, bnum);
			pstmt.executeUpdate() ;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(null, pstmt, conn);
		}
		
	}
}
