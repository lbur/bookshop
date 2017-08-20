package com.jishan.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.jishan.dao.IUserDao;
import com.jishan.entity.User;
import com.jishan.util.JdbcUtilTemp;

public class IUserDaoImpl implements IUserDao{
private JdbcUtilTemp jdbcUtilTemp = new JdbcUtilTemp();
	
@Override
	public void AddUser(User user) {
		Connection conn = jdbcUtilTemp.getConnection();
		
		String sql = "insert into t_user(user_name,password,realname,"
				+ "sex,idcard,email,addr,phone)values(?,?,?,?,?,?,?,?)";
		PreparedStatement psmt = null;
		try {
			psmt=conn.prepareStatement(sql);
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			psmt.setString(3, user.getRealname());
			psmt.setString(4, user.getSex());
			psmt.setString(5, user.getIdcard());
			psmt.setString(6, user.getEmail());
			psmt.setString(7, user.getAddr());
			psmt.setString(8, user.getPhone());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtilTemp.closeAll(null, psmt, conn);
		}
		
	}

@Override
public User showUserByName(String username) {
	User user = null ;
	//1.加载驱动
	//2.获取连接
	Connection conn = null ;
	PreparedStatement pstmt = null ;
	//String sql ="select * from t_user where username =?" ;
	//以上等价于
	String sqlplus ="select uid,username,password,realname,sex,idcard,email,addr,phone from t_user where username =?" ;
	ResultSet rs = null ;
	conn = jdbcUtilTemp.getConnection() ;
	try {
	//3.创建会话对象，预编译sql语句
		pstmt = conn.prepareStatement(sqlplus) ;
		pstmt.setString(1, username) ;
	//4.执行sql语句	
		rs = pstmt.executeQuery() ;
	//5.获取并操作结果集
		while(rs.next()){
			user = new User() ;
			user.setUid(rs.getInt("uid")) ;
			user.setUsername(rs.getString("username")) ;
			user.setPassword(rs.getString("password"));
			user.setRealname(rs.getString("realname")) ;
			user.setSex(rs.getString("sex"));
			user.setIdcard(rs.getString("idcard"));
			user.setEmail(rs.getString("email"));
			user.setAddr(rs.getString("addr"));
			user.setPhone(rs.getString("phone"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
	//6.关闭结果集	
		jdbcUtilTemp.closeAll(rs, pstmt, conn);
	}
	
	
	return user;
	
}

@Override
public List<User> showUserListByPage(int pageNo, int pageSize) {
	//创建一个List集合
	List<User> userList = new ArrayList<User>() ;
	Connection conn = jdbcUtilTemp.getConnection() ;
	PreparedStatement pstmt = null ;
	/*分页查询，使用limit语句。
	如    SELECT * FROM table LIMIT 5,10; // 检索记录行 6-15 
	*/
	String sql = "select uid,user_name,password,realname,sex,idcard,email,addr,phone from t_user limit ?, ?" ;
	ResultSet rs = null ;
	try {
		pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,(pageNo-1)*pageSize);//第一个参数为第(pageNo-1)页的最后一条记录
		pstmt.setInt(2,pageSize) ; //第二个参数为每页最大显示多少条记录
		rs = pstmt.executeQuery();
		while(rs.next()){
			User user = new User() ;
			user.setUid(rs.getInt("uid")) ;
			user.setUsername(rs.getString("user_name")) ;
			user.setPassword(rs.getString("password"));
			user.setRealname(rs.getString("realname")) ;
			user.setSex(rs.getString("sex"));
			user.setIdcard(rs.getString("idcard"));
			user.setEmail(rs.getString("email"));
			user.setAddr(rs.getString("addr"));
			user.setPhone(rs.getString("phone"));
			//将装载好的user对象加入到userList里
			userList.add(user) ;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		jdbcUtilTemp.closeAll(rs, pstmt, conn);
	}
	
	return userList ;
}

@Override
public List<User> showUserList() {
	List<User> userList = new ArrayList<User>() ;
	//1.加载驱动
	//2.获取连接
	Connection conn = jdbcUtilTemp.getConnection() ;
	PreparedStatement pstmt = null ;
	String sql ="select * from t_user " ;
	String sqlplus = "select uid,user_name,password,realname,sex,idcard,email,addr,phone from t_user" ;
	ResultSet rs = null ;
	
	try {
		//3.获取会话对象
		pstmt = conn.prepareStatement(sql);
		//4.执行sql语句，获得结果集
		rs =pstmt.executeQuery() ;
		//5.操作结果集
		while(rs.next()){
			User user = new User() ;
			user.setUid(rs.getInt("uid")) ;
			user.setUsername(rs.getString("user_name")) ;
			user.setPassword(rs.getString("password"));
			user.setRealname(rs.getString("realname")) ;
			user.setSex(rs.getString("sex"));
			user.setIdcard(rs.getString("idcard"));
			user.setEmail(rs.getString("email"));
			user.setAddr(rs.getString("addr"));
			user.setPhone(rs.getString("phone"));
			
			userList.add(user) ;
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally{
		jdbcUtilTemp.closeAll(rs, pstmt, conn);
	}
	
	return userList;
}
@Override
public void deleteUser(int uid) {
	//1.加载驱动
	//2.获取连接
	Connection conn = null ;
	PreparedStatement pstmt = null ;
	//String sql ="select * from t_user where username =?" ;
	//以上等价于
	String sqlplus ="delete from t_user where uid=?" ;
	conn = jdbcUtilTemp.getConnection() ;
	try {
	//3.创建会话对象，预编译sql语句
		pstmt = conn.prepareStatement(sqlplus) ;
		pstmt.setInt(1, uid) ;
		pstmt.executeUpdate();
		System.out.println("通过id:"+uid+"删除成功");
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
	//6.关闭结果集	
		jdbcUtilTemp.closeAll(null, pstmt, conn);
	}
	
}

@Override
public void updateUser(User user) {
	Connection conn=jdbcUtilTemp.getConnection();
	PreparedStatement pstmt=null;
	String sql="update t_user set user_name=?,password=?,realname=?,sex=?,"
			+ " idcard=?,email=?,addr=?,phone=? where uid=? ";
	try {
		 pstmt=conn.prepareStatement(sql);
		 pstmt.setString(1, user.getUsername());
		 pstmt.setString(2, user.getPassword());
		 pstmt.setString(3, user.getRealname());
		 pstmt.setString(4, user.getSex());
		 pstmt.setString(5, user.getIdcard());
		 pstmt.setString(6, user.getEmail());
		 pstmt.setString(7, user.getAddr());
		 pstmt.setString(8, user.getPhone());
		 pstmt.setInt(9, user.getUid());
		 
		 pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		jdbcUtilTemp.closeAll(null, pstmt, conn);
	}
	
}

@Override
public User showUserById(int uid) {
	//连接数据
	Connection conn=jdbcUtilTemp.getConnection();
	PreparedStatement pstmt=null;
	//创建对象
	User user = null;
	String sql="select uid,user_name,password,realname,sex,"
			+ " idcard,email,addr,phone from t_user where uid = ?";
	ResultSet rs=null;
	try {
		 pstmt=conn.prepareStatement(sql);
		 pstmt.setInt(1,uid);
		 rs=pstmt.executeQuery();
		 if(rs.next()){
			 user = new User();
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
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		//关闭资源
		jdbcUtilTemp.closeAll(null, pstmt, conn);
	}
	System.out.println("通过id查询成功,并返回user对象：" + user);
	return user;
}
}
