package cn.qblank.model.dao;

import java.util.List;

import cn.qblank.model.entity.Order;

public interface IOrderDao {
	/**
	 * 插入订单信息,并返回订单的id
	 * @param order
	 * @return
	 */
	public abstract String insertOrder(Order order);
	
	/**
	 * 根据订单的编号删除指定的订单记录
	 * @param order_id
	 * @return
	 */
	public abstract boolean deleteOrder(String order_id);

	
	/**
	 * 修改订单的状态
	 * @param order_status
	 * @return
	 */
	public abstract boolean updateOrderStatus(String order_id,int order_status);
	
	/**
	 * 得到该用户所有可见的订单
	 * @param user_id
	 * @return
	 */
	public abstract List<Order> getOrderList(int user_id); 
	
	/**
	 * 通过订单id查找对应的购物车
	 * @param o_id
	 * @return
	 */
	public Order getOrder(String o_id);
	
	/**
	 * 根据状态查找该用户指定状态的订单
	 * @param order_status
	 * @param user_id
	 * @return
	 */
	public abstract List<Order> getOrderList(int order_status,int user_id);
	
	/**
	 * 根据用户id模糊查询订单的页面
	 * @param user_id
	 * @param blur
	 * @return
	 */
//	public abstract List<Order> getOrderList(int user_id,String blur);
	/**
	 * 根据用户id查找购物车信息
	 * @param user_id
	 * @return
	 */
	public abstract Order getShppingCarList(int user_id);
	
	/**
	 * 提交订单
	 * @param orderStatus
	 * @param total
	 * @return
	 */
	public boolean postOrder(Order order);
	
	/**
	 * 通过状态查找对应的id
	 * @param id
	 * @return
	 */
	public String findIdByStatus(int istatus,int u_id);

	
}
