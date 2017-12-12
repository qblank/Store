package cn.qblank.control.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Order;
import cn.qblank.model.entity.User;
import cn.qblank.service.impl.OrderServiceImpl;
import cn.qblank.service.impl.RechargeServiceImpl;
import cn.qblank.service.impl.UserServiceImpl;
import cn.qblank.util.OrderStatus;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//得到session对象
		OrderServiceImpl osi=new OrderServiceImpl();
		HttpSession session = request.getSession();
		int user_id=new UserServiceImpl().findIdByName((String)session.getAttribute("username"));
		//创建订单列表项
		List<Order> orders=osi.getOrderList(user_id);
		System.out.println("length:"+orders.size());
		System.out.println("user_id="+user_id);
		System.out.println("user_name:"+session.getAttribute("username"));
		//创建订单筛选表
		List<Order> listFilter=null;
		//查询该用户最新的购物车的信息
		Order shoppingCar=osi.getShppingCarList(user_id);
		session.setAttribute("shoppingCar", shoppingCar);
		//将购物车的信息传入session
		session.setAttribute("shoppingCarInfo",osi.getShoppingCarInfo(shoppingCar));
		System.out.println("shoppingCarInfo:"+osi.getShoppingCarInfo(shoppingCar));
		System.out.println("user_id:"+user_id);
		System.out.println("shoppingCar:"+shoppingCar);
		
		//分页的页面
		if(null==request.getParameter("page")){
			session.setAttribute("page", 1);
		}else{
			session.setAttribute("page", request.getParameter("page"));
		}
		switch(request.getParameter("status")){
		case "0":
			//编码为0时为查询所有的订单
			session.setAttribute("orders", orders);
			session.setAttribute("status", "0");
			System.out.println("orders:"+orders.size());
			response.sendRedirect("/Store/pages/webStore/html/Order.jsp");
			break;
		case "1":
			//编码为1时为查询待付款的订单
			listFilter= osi.listFilter(orders, OrderStatus.NOPAY);
			session.setAttribute("orders",listFilter);
			session.setAttribute("status", "1");
			System.out.println("listfilter:"+osi.listFilter(orders, OrderStatus.NOPAY));
			response.sendRedirect("/Store/pages/webStore/html/Order.jsp");
			break;
		case "2":
			//编码为2时为查询待收货的订单
			listFilter= osi.listFilter(orders, OrderStatus.PAYNORECE);
			session.setAttribute("orders",listFilter);
			session.setAttribute("status", "2");
			System.out.println(osi.listFilter(orders, OrderStatus.PAYNORECE));
			response.sendRedirect("/Store/pages/webStore/html/Order.jsp");
			break;
		case "3":
			//编码为3时为查询待评价的订单
			listFilter= osi.listFilter(orders, OrderStatus.RECECOMMENT);
			session.setAttribute("orders",listFilter);
			session.setAttribute("status", "3");
			System.out.println(osi.listFilter(orders, OrderStatus.RECECOMMENT));
			response.sendRedirect("/Store/pages/webStore/html/Order.jsp");
			break;
		case "4":
			//模糊查询
//			String text=URLEncoder.encode(request.getParameter("blur"),"utf-8");
			String text=new String(request.getParameter("blur").getBytes("ISO-8859-1"), "utf-8");
			System.out.println(text);
			session.setAttribute("orders", osi.listFilter(orders, text));
			response.sendRedirect("/Store/pages/webStore/html/Order.jsp");
			break;
		case "delete":
			//删除订单
			System.out.println("删除订单："+osi.deleteOrder(request.getParameter("order_id")));
			break;
		case "gotgoods":
			//确认收货
			System.out.println("确认收货："+osi.updateOrderStatus(request.getParameter("order_id"), OrderStatus.RECECOMMENT));
			break;
		case "paynow":
			//立即付款
			double money=(double)session.getAttribute("userMoney");
			String name=(String)session.getAttribute("username");
			User user=new User();
			user.setName(name);
			user.setMoney(money);
			String price=(osi.getOrder(orders, request.getParameter("order_id")).getOrder_price())+"";
			//修改用户金额
			new RechargeServiceImpl().updateMoney(user, price, false);
			System.out.println("确认付款："+osi.updateOrderStatus(request.getParameter("order_id"), OrderStatus.PAYNORECE));
		}
		
	}

}
