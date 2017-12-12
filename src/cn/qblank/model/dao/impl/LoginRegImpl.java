package cn.qblank.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.qblank.model.dao.LoginRegDao;
import cn.qblank.model.entity.User;
import cn.qblank.util.ConnectionFactory;

public class LoginRegImpl implements LoginRegDao {
	/*public static void main(String[] args) {
		String user = new LoginRegImpi().getUserName("admin");
		System.out.println(user);
	}
	*/
	Connection conn =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	@Override
	public String getUserName(String name) {
		String username = null;
				
		try {
			conn = ConnectionFactory.getConnection();
			/*System.out.println(conn);*/
			String sql ="select name from s_user where name = ?";
			pstmt =conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				username = rs.getString(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		
		return username;
	}

	@Override
	public String getPassword(String name) {
		
		String password = null;
		
	
		try {
			conn = ConnectionFactory.getConnection();
			String sql = "select password from s_user where name = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				password = rs.getString(1);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return password;
	}

	@Override
	public void registerUser(User users) {
		
		try {
			conn = ConnectionFactory.getConnection();
			String sql ="insert into s_user values(s_user_seq.nextval,?,?,?,?,?,?,?)";
			/*insert into s_user values(s_user_seq.nextval,name,password,age,性别,tel,地址,余额)*/
			//获得预编译sql
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, users.getName());
			pstmt.setString(2, users.getPassword());
			pstmt.setInt(3, users.getAge());
			pstmt.setString(4, users.getGender());
			pstmt.setString(5, users.getPhone());
			pstmt.setString(6, users.getAddress());
			pstmt.setDouble(7, 2000);
			
			//执行sql
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		
	}

}

