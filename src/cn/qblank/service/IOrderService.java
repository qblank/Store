package cn.qblank.service;

import java.util.List;
import java.util.Map;

import cn.qblank.model.entity.Order;

public interface IOrderService {
	/**
	 * 插入订单信息,并返回订单的id
	 * @param order
	 * @return
	 */
	public abstract String insertOrder(Order order);
	
	/**
	 * 
	 * 删除订单
	 * @param order_id
	 * @return
	 */
	public boolean deleteOrder(String order_id);
	
	/**
	 * 根据订单编号来修改订单的状态
	 * @param order_id
	 * @param order_status
	 * @return
	 */
	public abstract boolean updateOrderStatus(String order_id,int order_status);
	
	
	/**
	 * 得到指定订单id的订单
	 * @param orders
	 * @param order_id
	 * @return
	 */
	public abstract Order getOrder(List<Order> orders,String order_id);
	
	/**
	 * 得到所有的订单
	 * @param user_id
	 * @return
	 */
	public List<Order> getOrderList(int user_id);
	
	/**
	 * 通过订单id查找对应的订单
	 * @param o_id
	 * @return
	 */
	public Order getOrder(String o_id);
	
	/**
	 * 根据订单的状态来获取指定的订单	
	 * @param order_status
	 * @param user_id
	 * @return
	 */
	public abstract List<Order> getOrderList(int order_status,int user_id);
	
	/**
	 * 根据用户id查找购物车信息
	 * @param user_id
	 * @return
	 */
	public abstract Order getShppingCarList(int user_id);
	
	/**
	 * 得到传入的订单列表的价格总和
	 * @param shoppingList
	 * @return
	 */
	public abstract Map<String, String> getShoppingCarInfo(Order shoppingList);
	
	/**
	 * 根据用户id和商品名字模糊查询
	 * @param user_id
	 * @param blur
	 * @return
	 */
	public abstract List<Order> listFilter(List<Order> orders, String blur);
	
	/**
	 * 根据订单状态来筛选订单
	 * @param orders
	 * @param order_status
	 * @return
	 */
	public abstract List<Order> listFilter(List<Order> orders,int order_status);
	
	
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
	public String findIdByStatus(int status,int u_id);
}
