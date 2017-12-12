package cn.qblank.control.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Order;
import cn.qblank.model.entity.Order_item;
import cn.qblank.model.entity.Product;
import cn.qblank.service.impl.CategoryServiceImpl;
import cn.qblank.service.impl.OrderItemServiceImpl;
import cn.qblank.service.impl.OrderServiceImpl;
import cn.qblank.service.impl.UserServiceImpl;
import cn.qblank.util.OrderStatus;
import cn.qblank.util.MyUtils;

@SuppressWarnings("serial")
public class ShopCarServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//这个Servlet应该是由商品详情页跳转过来的  点击加入购物车则获取对应商品的id,然后再通过id,获取商品详情
		//获取商品的id
		String p_id = req.getParameter("p_id");
		//获取商品的数量
		String p_num = req.getParameter("pro_num");
		
		//获取用户名
		HttpSession session = req.getSession();
		String userName = (String)session.getAttribute("username");
		
		CategoryServiceImpl cs = new CategoryServiceImpl();
		OrderServiceImpl orderService = new OrderServiceImpl();
		
		//获取商品的详细信息
		Product product = cs.getProduct(p_id);
		//通过姓名将用户id查出来
		Integer user_id = new UserServiceImpl().findIdByName(userName);
		//创建购物车对象
		Order order = new Order();
		//通过当前时间的毫秒值产生订单名字
		String o_name = new Date(System.currentTimeMillis()).getTime()+ "";
		/**
		 * 设置购物车对象里面的值并将信息插入到order表中  插入一个购物车
		 */
		//通过数据库，将该用户所有订单查询出来
		List<Order> orderList = orderService.getOrderList(OrderStatus.SHOPCAR,user_id);
		String o_id = "";
		if (orderList.size() == 0) {
			//如果为空，就插入一条购物车项
			o_id = setOrdermessage(userName, user_id, order, o_name, orderService);
		}
		List<Order> orders = orderService.getOrderList(OrderStatus.SHOPCAR, user_id);
		for (Order o : orders) {
			//将购物车统一
			o_id = o.getId();
		}
		//将id设置为一个用户的订单id
		//创建购物项对象
		Order_item orderItem = new  Order_item();
		//将商品信息添加到购物项中
		orderItem.setProduct(product);
		/**
		 * 设置订单项的值并将其插入到订单项的表中
		 */
		setOrderItem(p_id, p_num, product, o_id,orderItem,user_id);
		//将信息插入到数据库中
		//将购物项的信息添加到购物车中
		//将这个所有购物车的信息保存到session域中
		session.setAttribute("orderInfo", orderList);
		//转发
//		resp.sendRedirect( req.getContextPath()+"/control/shopCar");
		req.getRequestDispatcher("shopCar").forward(req, resp);
//		return;
//		req.getRequestDispatcher(req.getContextPath()+"/pages/webStore/html/product.jsp");
	}

	/**
	 * 设置订单项的值并将其插入到订单项的表中
	 * @param p_id  商品id
	 * @param p_num	商品数量
	 * @param product	商品对象
	 * @param o_id	订单id
	 * @param orderItem	订单项
	 * @return
	 */
	private List<Order_item> setOrderItem(String p_id, String p_num,
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
	}

	/**
	 * 设置购物车对象里面的值并将信息插入到order表中
	 */
	private String setOrdermessage(String userName, Integer user_id, Order order,
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
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
