package cn.qblank.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class ConnectionFactory {
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static{
		Properties pro = new Properties();
		InputStream in = ConnectionFactory.class.getResourceAsStream("./db.properties");
		try {
			pro.load(in);
			driver = pro.getProperty("jdbc.driver");
			url = pro.getProperty("jdbc.url");
			user = pro.getProperty("jdbc.user");
			password = pro.getProperty("jdbc.password");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConnection(){
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
	/**
	 * 关闭资源
	 * @param conn
	 * @param pstmt
	 * @param stmt
	 * @param rs
	 */
	public static void close(Connection conn,PreparedStatement pstmt,Statement stmt,ResultSet rs){
			
			try {
				if (conn != null) {	
					conn.close();
				}
				
				if (pstmt != null) {
					pstmt.close();
				}
				
				if (stmt != null) {
					stmt.close();
				}
				
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		
	}
	
}
