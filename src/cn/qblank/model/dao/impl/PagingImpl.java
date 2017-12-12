package cn.qblank.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qblank.model.dao.IPagingDao;
import cn.qblank.model.entity.Order;
import cn.qblank.util.ConnectionFactory;

public class PagingImpl implements IPagingDao {
	Connection conn = null;
	PreparedStatement pstmt = null;

	@Override
	public Integer getAllNum(int status,int user_id) {
		ResultSet rs = null;
		String sql = "select count(id) from s_order where order_status = ? and user_id = ?";
		Integer num = 0;
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setInt(2, user_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				num = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return num;
	}

	@Override
	public List<Order> pagingShopCar(int pageNum, int pageSize,int status,int user_id) {
		List<Order> orders=new ArrayList<Order>();
		Order order = null;
		ResultSet rs = null;
		//计算开始位置
		int start = (pageNum -1) * pageSize;
		int end = pageSize * pageNum;
		
		String sql = "select * from (select o.*,rownum rn from s_order o "
				+ "where rownum <= ? and order_status = ? and user_id = ?) where rn > ? ";
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, end);
			pstmt.setInt(2, status);
			pstmt.setInt(3, user_id);
			pstmt.setInt(4, start);
			rs = pstmt.executeQuery();
			while(rs.next()){
				order=new Order();
				order.setId(rs.getString("id"));
				order.setName(rs.getString("name"));
				order.setUser_id(rs.getString("user_id"));
				order.setComment_status(rs.getInt("comment_status"));
				order.setOrder_status(rs.getInt("order_status"));
				order.setOrder_price(rs.getDouble("order_price"));
				order.setOrder_time(rs.getDate("order_time"));
				order.setUser_name(rs.getString("user_name"));
				order.setOrder_items(new Order_itemDaoImpl().getOrder_items(order.getId()));
				orders.add(order);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return orders;
	}

}
