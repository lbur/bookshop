package com.jishan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtilTemp {
	private String url;//地址
	private String user;//账号
	private String password;//密码

	public JdbcUtilTemp() {
		Properties pro = new Properties();
		try {
			pro.load(JdbcUtilTemp.class.getClassLoader().getResourceAsStream("com/jishan/config/db.properties"));//去这个路径加载里面的内容
			url = pro.getProperty("url");
			
			user = pro.getProperty("username");
			
			password = pro.getProperty("password");
			String driverName = pro.getProperty("driver");
			
			
			System.out.println(url + "," + user + "," + "password" + "," + driverName);
			Class.forName(driverName);//加载驱动

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			//获取数据库的连接
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public void closeAll(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
