package cn.qblank.service.impl;

import java.util.List;

import cn.qblank.model.dao.impl.Order_itemDaoImpl;
import cn.qblank.model.entity.Order_item;
import cn.qblank.service.IOrderItemService;

public class OrderItemServiceImpl implements IOrderItemService{
	
	
	@Override
	public boolean insertOrder_item(List<Order_item> order_items) {
		return new Order_itemDaoImpl().insertOrder_item(order_items);
	}

	@Override
	public boolean deleteOrder_item(String order_id) {
		return new Order_itemDaoImpl().deleteOrder_item(order_id);
	}

	@Override
	public List<Order_item> getOrder_items(String order_id) {
		return new Order_itemDaoImpl().getOrder_items(order_id);
	}

	@Override
	public boolean deleteOrderItem(String itemId) {
		return new Order_itemDaoImpl().deleteOrderItem(itemId);
	}

	@Override
	public boolean updateOid(String o_id1, String o_id) {
		return new Order_itemDaoImpl().updateOid(o_id1, o_id);
	}

	@Override
	public List<Order_item> getOrderList(String[] itemIds) {
		return new Order_itemDaoImpl().getOrderList(itemIds);
	}
	
}
