package cn.qblank.service;

import java.util.List;

import cn.qblank.model.entity.Order_item;

public interface IOrderItemService {
	/**
	 * 插入订单列表项
	 * @param order_items
	 * @return
	 */
	public abstract boolean insertOrder_item(List<Order_item> order_items);
	
	/**
	 * 根据订单编号删除订单列表项
	 * @param order_id
	 * @return
	 */
	public abstract boolean deleteOrder_item(String order_id);
	
	/**
	 * 根据订单的编号得到订单列表项
	 * @param order_id
	 * @return
	 */
	public abstract List<Order_item> getOrder_items(String order_id);
	
	/**
	 * 根据订单id删除订单项
	 * @param order_id
	 * @return
	 */
	public abstract boolean deleteOrderItem(String itemId);
	
	/**
	 * 修改订单号
	 */
	public boolean updateOid(String o_id1,String o_id);
	
	/**
	 * 通过一串数组查出对应的item项
	 * @param itemIds
	 * @return
	 */
	public List<Order_item> getOrderList(String[] itemIds); 
}
