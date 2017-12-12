package cn.qblank.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import cn.qblank.model.dao.impl.OrderDaoImpl;
import cn.qblank.model.entity.Order;
import cn.qblank.model.entity.Order_item;
import cn.qblank.service.IOrderService;

public class OrderServiceImpl implements IOrderService {

	/**
	 * 删除订单
	 */
	@Override
	public boolean deleteOrder(String order_id) {
		return new OrderDaoImpl().deleteOrder(order_id);
	}

	/**
	 * 得到所有的订单
	 */
	@Override
	public List<Order> getOrderList(int user_id) {
		// TODO Auto-generated method stub
		return new OrderDaoImpl().getOrderList(user_id);
	}

	/**
	 * 根据订单的状态来获取指定的订单
	 */
	@Override
	public List<Order> getOrderList(int order_status, int user_id) {
		return new OrderDaoImpl().getOrderList(order_status, user_id);
	}

	/**
	 * 插入订单记录并返回订单的id号
	 */
	@Override
	public String insertOrder(Order order) {
		return new OrderDaoImpl().insertOrder(order);
	}

	/**
	 * 根据用户id查找购物车信息
	 */
	@Override
	public Order getShppingCarList(int user_id) {
		// TODO Auto-generated method stub
		return new OrderDaoImpl().getShppingCarList(user_id);
	}

	/**
	 * 得到传入的订单列表的价格总和
	 */
	@Override
	public Map<String, String> getShoppingCarInfo(Order shoppingList) {
		// TODO Auto-generated method stub
		Map<String, String> shoppingCarInfo = new TreeMap<String, String>();
		int num = 0;
		double price = 0;
		if (null!=shoppingList) {
			for (Order_item order_item : shoppingList.getOrder_items()) {
				price += order_item.getSubtotal();
				num++;
			}
		}
		shoppingCarInfo.put("num", num + "");
		shoppingCarInfo.put("price", price + "");
		return shoppingCarInfo;
	}

	/**
	 * 根据订单编号修改订单的状态
	 */
	@Override
	public boolean updateOrderStatus(String order_id, int order_status) {
		// TODO Auto-generated method stub
		return new OrderDaoImpl().updateOrderStatus(order_id, order_status);
	}

	/**
	 * 根据传过来的blur来将相关的订单找出
	 */
	@Override
	public List<Order> listFilter(List<Order> orders, String blur) {
		List<Order> filterList = new ArrayList<Order>();
		for (Order order : orders) {
			for (Order_item order_item : order.getOrder_items()) {
				if (order_item.getProduct().getName().contains(blur)) {
					filterList.add(order);
					break;
				}
			}
		}
		return filterList;
	}

	/**
	 * 根据订单状态来筛选订单
	 */
	@Override
	public List<Order> listFilter(List<Order> orders, int order_status) {
		List<Order> filterList = new ArrayList<Order>();
		for (Order order : orders) {
			if (order.getOrder_status() == order_status) {
				filterList.add(order);
			}
		}
		return filterList;
	}

	@Override
	public boolean postOrder(Order order) {
		return new OrderDaoImpl().postOrder(order);
	}

	@Override
	public String findIdByStatus(int status, int u_id) {
		return new OrderDaoImpl().findIdByStatus(status, u_id);
	}

	/**
	 * 根据id得到指定的一个订单
	 */
	@Override
	public Order getOrder(List<Order> orders, String order_id) {
		Order commentOrder = null;
		for (Order order : orders) {
			if (order.getId().equals(order_id)) {
				commentOrder = order;
			}
		}
		return commentOrder;
	}

	@Override
	public Order getOrder(String o_id) {
		return new OrderDaoImpl().getOrder(o_id);
	}

}
