package cn.qblank.control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Order;
import cn.qblank.model.entity.Order_item;
import cn.qblank.service.impl.OrderItemServiceImpl;
import cn.qblank.service.impl.OrderServiceImpl;
import cn.qblank.service.impl.UserServiceImpl;
import cn.qblank.util.OrderStatus;

@SuppressWarnings("serial")
public class PostServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean isSussess = false;
		/**
		 * 创建session对象，获取对应信息
		 */
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("username");
		Integer user_id = new UserServiceImpl().findIdByName(username);
		OrderServiceImpl orderService = new OrderServiceImpl();
		OrderItemServiceImpl itemService = new OrderItemServiceImpl();
		//创建一个购物车
		//获取订单的id
		String[] itemIds = req.getParameterValues("itemIds");
		
		/**
		 * 重新插入一条购物车用于提交信息
		 */
		List<Order> orderList = orderService.getOrderList(OrderStatus.SHOPCAR,user_id);
//		List<Order> orderList = orderService.getOrderList(OrderStatus.SHOPCAR,user_id);
//		String order_id1 = "";
//		order_id1 = orderList.get(0).getId();
//		List<Order_item> order_items = itemService.getOrder_items(order_id1);
		String order_id = orderService.insertOrder(orderList.get(0));
		//改变订单的状态
		orderService.updateOrderStatus(order_id, OrderStatus.COMMENTED);
		List<Order_item> items = itemService.getOrderList(itemIds);
//		for (int i = 0; i < itemIds.length; i++) {
////			orderList.get(0).setOrder_items(items);
//			//获取总价
//			String total = req.getParameter("order_total");
//			System.out.println(total);
//			double totalD = 0.0; 
//			if (total != null) {
//				totalD = Double.parseDouble(total);
//			}
//			//设置总价格
//			orderService.getOrder(order_id).setOrder_price(totalD);
//		}
		String total = req.getParameter("order_total");
		System.out.println(total);
//		double totalD = 0.0;
//		if (total != null) {
		//转型
		double totalD = Double.parseDouble(total);
//		}
		//在order逻辑层通过id获取到订单新消息
		Order order = orderService.getOrder(order_id);
		//设置金额
		order.setOrder_price(totalD);
		
		//提交购物车
		isSussess = orderService.postOrder(order);
		for (Order_item o : items) {
			//fore循环通过订单id该百年
			itemService.updateOid(order_id, o.getId());
		}
		
		//更新订单项的订单号
		/**
		 *  通过选中的购物项传过来的id,来查找对应的购物项的信息，然后再将其的order_id设置为最新的order
		 */
		
		/**
		 * 插入购物项信息
		 */
		//先获取需要添加的订单信息
//		boolean fag = itemService.insertOrder_item(order_items);
		
			if (isSussess) {
				resp.sendRedirect("/Store/control/orderServlet?status=0");
			}else{
				resp.sendRedirect("/Store/control/shopCar");
			}
			return;
			
	}
	
	/*private List<Order_item> setOrderItem(String p_id, String p_num,
			Product product, String o_id,Order_item orderItem,int user_id) {
		//计算小计
		orderItem.setSubtotal(Double.parseDouble(p_num)*product.getPrice());
		//设置商品的id
		orderItem.setP_id(p_id);
		//设置订单id
		orderItem.setO_id(o_id);
		//将商品的详细信息提加到购物项中
		orderItem.setProduct(product);
		List<Order_item> orderItems = new ArrayList<>();
		//将信息添加到集合中
		orderItems.add(orderItem);
		
		new OrderItemServiceImpl().insertOrder_item(orderItems);
		return orderItems;
	}*/
	
	
	/*private String setOrdermessage(String userName, Integer user_id, Order order,
			String o_name,OrderServiceImpl orderService) {
		order.setName(o_name);
		order.setUser_id(user_id+"");
		order.setComment_status(OrderStatus.NOCOMMENT);
		order.setOrder_status(OrderStatus.SHOPCAR);
		order.setOrder_price(0.0);
		//将当前时间插入进去
		order.setOrder_time(MyUtils.getCurTimes());
		//设置名字
		order.setUser_name(userName);
		//然后将购物车的所需的信息插入到数据库中
//		new OrderServiceImpl().getOrderList(OrderStatus.SHOPCAR,user_id);
		String order_id = orderService.insertOrder(order);
		return order_id;
	}*/
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
