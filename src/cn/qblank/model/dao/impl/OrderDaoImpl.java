package cn.qblank.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.qblank.model.dao.IOrderDao;
import cn.qblank.model.entity.Order;
import cn.qblank.util.ConnectionFactory;

public class OrderDaoImpl implements IOrderDao {
	
	/**
	 * 插入订单记录并返回订单的id号
	 */
	@SuppressWarnings("resource")
	@Override
	public String insertOrder(Order order) {
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String id=null;
		String sql="select s_order_seq.nextval from dual";
		try {
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){
				id=rs.getString(1);
			}
			sql="insert into s_order values(?,?,?,?,?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, order.getName());
			pstmt.setString(3, order.getUser_id());
			pstmt.setInt(4, order.getComment_status());
			pstmt.setInt(5, order.getOrder_status());
			pstmt.setDouble(6, order.getOrder_price());
			pstmt.setDate(7, order.getOrder_time());
			pstmt.setString(8, order.getUser_name());
			pstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return id;
	}

	/**
	 * 根据订单编号来删除订单记录
	 */
	@Override
	public boolean deleteOrder(String order_id) {
		// TODO Auto-generated method stub
		boolean tag=false;
		Connection conn =ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		String sql="delete s_order where id= ? ";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, order_id);
			if(pstmt.executeUpdate()>0&&new Order_itemDaoImpl().deleteOrder_item(order_id)){
				tag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionFactory.close(conn, pstmt, null, null);
		}
		return tag;
	}

	/**
	 * 得到所有的订单记录
	 */
	@Override
	public List<Order> getOrderList(int user_id) {
		// TODO Auto-generated method stub
		List<Order> orders=new ArrayList<Order>();
		Order order=null;
		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs=null;
//		String id=user_id+"";
		PreparedStatement pstmt=null;
		String sql="select id,name,user_id,comment_status,order_status,order_price,order_time,user_name from s_order where order_status < 5 and user_id = ? order by id desc"; 
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			rs=pstmt.executeQuery();
			while (rs.next()) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return orders;
	}

	/**
	 * 根据订单的状态来获取指定的订单
	 */
	@Override
	public List<Order> getOrderList(int order_status,int user_id) {
		// TODO Auto-generated method stub
		List<Order> orders=new ArrayList<Order>();
		Order order=null;
		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String sql="select id,name,user_id,comment_status,order_status,order_price,order_time,user_name from s_order where order_status = ? and user_id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, order_status);
			pstmt.setInt(2, user_id);
			rs=pstmt.executeQuery();
			while (rs.next()) {
				order=new Order();
				order.setId(rs.getString("id"));
				order.setName(rs.getString("name"));
				order.setUser_id(rs.getString("user_id"));
				order.setComment_status(rs.getInt("comment_status"));
				order.setComment_status(rs.getInt("order_status"));
				order.setOrder_price(rs.getDouble("order_price"));
				order.setOrder_time(rs.getDate("order_time"));
				order.setUser_name(rs.getString("user_name"));
				order.setOrder_items(new Order_itemDaoImpl().getOrder_items(order.getId()));
				orders.add(order);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return orders;
	}

	/**
	 * 根据用户id查询到该用户最新的购物车信息
	 */
	@Override
	public Order getShppingCarList(int user_id) {
		Order order=null;
		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String id=user_id+"";
		String sql="select id,name,user_id,comment_status,order_status,order_price,order_time,user_name from (select * from s_order order by id desc) where order_status = 5 and user_id = ? "; 
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if (rs.next()) {
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
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return order;
	}

	
	/**
	 * 修改指定订单的订单状态
	 */
	@Override
	public boolean updateOrderStatus(String order_id,int order_status) {
		boolean tag=false;
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		String sql="update s_order set order_status = ? where id = ?";
		try {
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, order_status);
			pstmt.setString(2, order_id);
			if(pstmt.executeUpdate()>0){
				tag=true;
			}
			conn.commit();
		} catch (SQLException e) {

			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, pstmt, null, null);
		}
		
		return tag;
	}

	@Override
	public boolean postOrder(Order order) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update s_order set order_price = ?,order_time = sysdate,order_status = ? where id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, order.getOrder_price());
			pstmt.setInt(2, order.getOrder_status());
			pstmt.setString(3, order.getId());
			
			int row = pstmt.executeUpdate();
			
			if (row >= 1) {
				return true;
			}
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, null);
		}
		return false;
	}

	@Override
	public String findIdByStatus(int status,int u_id) {
		ResultSet rs = null;
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		String o_id = null;
		String sql="select id from s_order where order_status = ? and user_id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, status);
			pstmt.setInt(2, u_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				o_id = rs.getString(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, pstmt, null, null);
		}
		return o_id;
	}

	@Override
	public Order getOrder(String o_id) {
		ResultSet rs = null;
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		Order order = null;
		String sql="select * from s_order where id = ?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, o_id);
			rs = pstmt.executeQuery();
			while(rs.next()){
				order = new Order();
				order.setId(rs.getString("id"));
				order.setName(rs.getString("name"));
				order.setUser_id(rs.getString("user_id"));
				order.setComment_status(rs.getInt("comment_status"));
				order.setOrder_status(rs.getInt("order_status"));
				order.setOrder_price(rs.getDouble("order_price"));
				order.setOrder_time(rs.getDate("order_time"));
				order.setUser_name(rs.getString("user_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, pstmt, null, null);
		}
		return order;
	}

	/**
	 * 根据用户id模糊查询订单的页面
	 */
	/*@Override
	public List<Order> getOrderList(int user_id, String blur) {
		List<Order> orders=new ArrayList<Order>();
		Order order=null;
		Connection conn = ConnectionFactory.getConnection();
		ResultSet rs=null;
		PreparedStatement pstmt=null;
		String sql="select id,name,user_id,comment_status,order_status,order_price,order_time,user_name from s_order where (order_status !=5 and user_id = ?) and name like ?"; 
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, user_id);
			pstmt.setString(2, blur);
			rs=pstmt.executeQuery();
			while (rs.next()) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return orders;
	}*/

}
