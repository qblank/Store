package cn.qblank.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.qblank.model.dao.IUserDao;
import cn.qblank.util.ConnectionFactory;

public class UserDaoImpl implements IUserDao {
	Connection conn = null;
	PreparedStatement pstmt = null;

	@Override
	public Integer findIdByName(String name) {
		ResultSet rs = null;
		Integer user_id = 0;
		String sql = "select id from s_user where name = ?";
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			while(rs.next()){
				user_id = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		
		return user_id;
	}

}
