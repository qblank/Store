package cn.qblank.control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Order;
import cn.qblank.service.impl.PagingServiceImpl;
import cn.qblank.service.impl.UserServiceImpl;
import cn.qblank.util.OrderStatus;

@SuppressWarnings("serial")
public class ShopCarPagingServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取用户名
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("username");
		//获取用户id
		Integer user_id = new UserServiceImpl().findIdByName(username);
		PagingServiceImpl pgService = new PagingServiceImpl();
		
		//获取要总页数页数
		Integer allNum = pgService.getAllNum(OrderStatus.SHOPCAR,user_id);
		//获取总页数
		Integer page = (int) Math.ceil(allNum / 4.0);
		
		//获取当前的页数
		String currPage = req.getParameter("page");
		int curPage = 0;
		if (currPage == null) {
			curPage = 1;
		}else{
			curPage = Integer.parseInt(currPage);
		}
		//调用分页的方法
		List<Order> orders = pgService.pagingShopCar(curPage,4,OrderStatus.SHOPCAR,user_id);
		
		//将其保存到session域中
		session.setAttribute("page", page);
		session.setAttribute("orders", orders);
		//转发到购物车中
		resp.sendRedirect( req.getContextPath()+"/pages/webStore/html/shopcar.jsp");
//		req.getRequestDispatcher("../pages/webStore/html/shopcar.jsp").forward(req, resp);
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
