package cn.qblank.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import cn.qblank.model.dao.RechargeDao;
import cn.qblank.model.entity.User;
import cn.qblank.util.ConnectionFactory;

public class RechargeDaoImpl implements RechargeDao {
	PreparedStatement pstmt = null;
	Connection conn = null;
	private User user;
	

	@Override
	public User getUserMessage(String username) {
		ResultSet rs = null;
		String sql  = "select name,age,gender,address,money from s_user where name = ?";
		conn = ConnectionFactory.getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			rs = pstmt.executeQuery();
			while(rs.next()){
				user = new User();
				user.setName(rs.getString(1));
				user.setAge(rs.getInt(2));
				user.setGender(rs.getString(3));
				user.setAddress(rs.getString(4));
				user.setMoney(rs.getDouble(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return user;
	}


	@Override
	public void updateMoney(User user) {
		Savepoint s = null;
		String sql = "update s_user set money = ? where name = ?";
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, user.getMoney());
			pstmt.setString(2, user.getName());
			//设置回滚事件
			conn.setAutoCommit(false);
			s = conn.setSavepoint();
			
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				conn.commit();
			}
		} catch (SQLException e) {
			try {
				conn.rollback(s);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, null);
		}
	}


	

}
