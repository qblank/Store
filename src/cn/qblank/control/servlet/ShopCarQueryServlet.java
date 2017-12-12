package cn.qblank.control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Order;
import cn.qblank.service.impl.OrderServiceImpl;
import cn.qblank.service.impl.UserServiceImpl;
import cn.qblank.util.OrderStatus;

@SuppressWarnings("serial")
public class ShopCarQueryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		HttpSession session = req.getSession();
		//获取用户id
		String username  = (String)session.getAttribute("username");
		Integer user_id = new UserServiceImpl().findIdByName(username);
		
		//通过数据库，将该用户所有订单查询出来
		List<Order> orderList = new OrderServiceImpl().getOrderList(OrderStatus.SHOPCAR,user_id);
		System.out.println(orderList);
		
		//将这个所有购物车的信息保存到session域中
		session.setAttribute("orderInfo", orderList);
		
		//转发
		resp.sendRedirect( req.getContextPath()+"/pages/webStore/html/shopcar.jsp");
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
