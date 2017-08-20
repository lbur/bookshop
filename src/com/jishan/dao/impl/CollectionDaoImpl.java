package com.jishan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jishan.dao.ICollectionDao;
import com.jishan.entity.Collection;
import com.jishan.util.JdbcUtilTemp;

public class CollectionDaoImpl implements ICollectionDao {
	JdbcUtilTemp jdbcUtilTemp = new JdbcUtilTemp() ;
	
	@Override
	public void saveCollection(Collection collection) {
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		
		String sql = "insert into t_collection(userid,bnum) values(?,?)" ;
		try {
			pstmt =conn.prepareStatement(sql) ;
			pstmt.setInt(1,collection.getUserid());
			pstmt.setInt(2,collection.getBnum());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(null, pstmt, conn);
		}
		
	}

	@Override
	public Collection showCollectionById(int userId, int bNum) {
		Collection collection = null ;
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select collectionid ,userid ,bnum  from t_collection where userid=? and bnum =?" ;
		ResultSet rs = null ;
		try {
			pstmt =conn.prepareStatement(sql) ;
			pstmt.setInt(1, userId);
			pstmt.setInt(2, bNum);
			rs= pstmt.executeQuery() ;
			if(rs.next()){
				collection = new Collection() ;
				collection.setCollectionid(rs.getInt("collectionid"));
				collection.setUserid(rs.getInt("userid"));
				collection.setBnum(rs.getInt("bnum")) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return collection;
	}

	@Override
	public void updateCollection(Collection collection) {
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql ="update t_collection set collectionid=?,userid=? where bnum=?" ;
		try {
			pstmt =conn.prepareStatement(sql) ;
			pstmt.setLong(1,collection.getCollectionid());
			pstmt.setLong(2,collection.getUserid());
			pstmt.setLong(3,collection.getBnum());
			pstmt.executeUpdate() ;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtilTemp.closeAll(null, pstmt, conn);
		}
		
	}

	@Override
	public List<Collection> showCollectionList(int userid) {
		List<Collection> list = new ArrayList<Collection>() ;
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "select collectionid ,userid ,bnum from t_collection where userid = ?" ;
		ResultSet rs = null ;
		try {
			pstmt =conn.prepareStatement(sql);
			pstmt.setInt(1, userid);
			rs =pstmt.executeQuery() ;
			while(rs.next()){
				Collection collection = new Collection() ;
				collection.setCollectionid(rs.getInt("collectionid"));
				collection.setUserid(rs.getInt("userid"));
				collection.setBnum(rs.getInt("bnum")) ;
				list.add(collection) ;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtilTemp.closeAll(rs, pstmt, conn);
		}
		return list ;
	}

	@Override
	public void deleteCollection(int userid, int bnum) {
		Connection conn = jdbcUtilTemp.getConnection();
		PreparedStatement pstmt= null ;
		String sql = "delete from t_collection where userid=? and bnum=?" ;
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
