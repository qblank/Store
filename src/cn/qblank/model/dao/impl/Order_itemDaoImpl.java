package cn.qblank.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;





import cn.qblank.model.dao.IOrder_itemDao;
import cn.qblank.model.entity.Order_item;
import cn.qblank.model.entity.Product;
import cn.qblank.util.ConnectionFactory;

public class Order_itemDaoImpl implements IOrder_itemDao {

	//插入订单列表项
	@SuppressWarnings("resource")
	@Override
	public boolean insertOrder_item(List<Order_item> order_items) {
		// TODO Auto-generated method stub
		boolean tag=false;
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String id="";
			try {
				conn.setAutoCommit(false);
				for (Order_item order_item : order_items) {
					//首先查询订单列表项的id
					String sql="select s_order_item_seq.nextval from dual";
					pstmt=conn.prepareStatement(sql);
					rs=pstmt.executeQuery();
					if(rs.next()){
						id=rs.getString(1);
					}
					//插入订单列表项
					sql="insert into s_order_item values(?,?,?,?)";
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, id);
					pstmt.setString(2, order_item.getO_id());
					pstmt.setString(3, order_item.getP_id());
					pstmt.setDouble(4, order_item.getSubtotal());
					if(pstmt.executeUpdate()>0){
						tag = true;
					}
				}
				conn.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				e.printStackTrace();
			}finally {
				ConnectionFactory.close(conn, pstmt, null, rs);
			}
			
		return tag;
	}

	//根据订单编号删除订单列表项
	@Override
	public boolean deleteOrder_item(String order_id) {
		// TODO Auto-generated method stub
		boolean tag=false;
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		String sql="delete s_order_item where o_id= ?";
		try {
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, order_id);
			if(pstmt.executeUpdate()>0){
				tag= true;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			ConnectionFactory.close(conn, pstmt, null, null);
		}
		return tag;
	}
	

	//根据订单编号得到订单列表项，封装列表项对应的商品信息
	@Override
	public List<Order_item> getOrder_items(String order_id) {
		// TODO Auto-generated method stub
		List<Order_item> order_items=new ArrayList<Order_item>();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Order_item order_item=null;
		Product product=null;
		String sql="select id,o_id,p_id,subtotal from s_order_item where o_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, order_id);
			rs=pstmt.executeQuery();
			while(rs.next()){
				//获得order_item的信息
				order_item=new Order_item();
				order_item.setId(rs.getString("id"));
				order_item.setO_id(rs.getString("o_id"));
				order_item.setP_id(rs.getString("p_id"));
				order_item.setSubtotal(rs.getDouble("subtotal"));
				//获取对应的商品信息
				product=new CategoryImpl().getProduct(order_item.getP_id());
				order_item.setProduct(product);
				order_items.add(order_item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			ConnectionFactory.close(conn, pstmt, null, rs);
		}
		return order_items;
	}

	@Override
	public boolean deleteOrderItem(String itemId) {
		boolean tag=false;
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		String sql="delete s_order_item where id = ?";
		try {
			conn.setAutoCommit(false);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, itemId);
			if(pstmt.executeUpdate()>0){
				tag= true;
			}
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally{
			ConnectionFactory.close(conn, pstmt, null, null);
		}
		return tag;
	}

	@Override
	public boolean updateOid(String o_id1,String o_id) {
		boolean tag=false;
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		String sql = "update s_order_item  set o_id= ?  where id = ?";
		
		try {
			conn = ConnectionFactory.getConnection();
			pstmt = conn.prepareStatement(sql);
			//修改后的id
			pstmt.setString(1, o_id1);
			//查询到的id
			pstmt.setString(2, o_id);
			int rows = pstmt.executeUpdate();
			if (rows > 0) {
				tag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.close(conn, pstmt, null, null);
		}
		return tag;
	}

	@Override
	public List<Order_item> getOrderList(String[] itemIds) {
		List<Order_item> order_items=new ArrayList<Order_item>();
		Connection conn=ConnectionFactory.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Order_item order_item=null;
		Product product=null;
		String sql="select id,o_id,p_id,subtotal from s_order_item where id = ?";
			try {
				for (int i = 0; i < itemIds.length; i++) {
					pstmt=conn.prepareStatement(sql);
					pstmt.setString(1, itemIds[i]);
					rs=pstmt.executeQuery();
					while(rs.next()){
						//获得order_item的信息
						order_item=new Order_item();
						order_item.setId(rs.getString("id"));
						order_item.setO_id(rs.getString("o_id"));
						order_item.setP_id(rs.getString("p_id"));
						order_item.setSubtotal(rs.getDouble("subtotal"));
						//获取对应的商品信息
						product=new CategoryImpl().getProduct(order_item.getP_id());
						order_item.setProduct(product);
						order_items.add(order_item);
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally{
				ConnectionFactory.close(conn, pstmt, null, rs);
			}
		return order_items;
		
	}

}
