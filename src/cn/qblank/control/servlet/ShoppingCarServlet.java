package cn.qblank.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Order;
import cn.qblank.service.impl.OrderServiceImpl;
import cn.qblank.service.impl.UserServiceImpl;

/**
 * Servlet implementation class ShoppingCarServlet
 */
@WebServlet("/shoppingCarServlet")
public class ShoppingCarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCarServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取用户名
		HttpSession session = request.getSession();
//		String username = (String) session.getAttribute("username");
//		// 获取用户id
//		Integer user_id = new UserServiceImpl().findIdByName(username);
		//登陆后预加载购物车
		//查询该用户最新的购物车的信息
		Order shoppingCar=new OrderServiceImpl().getShppingCarList(new UserServiceImpl().findIdByName((String)session.getAttribute("username")));
		session.setAttribute("shoppingCar", shoppingCar);
		//将购物车的信息传入session
		session.setAttribute("shoppingCarInfo",new OrderServiceImpl().getShoppingCarInfo(shoppingCar));
		response.sendRedirect( request.getContextPath()+"/pages/webStore/html/ShoppingCarPage.jsp");

	}

}
