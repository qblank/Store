package cn.qblank.control.servlet;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Comment;
import cn.qblank.model.entity.Order;
import cn.qblank.service.impl.CommentServiceImpl;
import cn.qblank.service.impl.OrderServiceImpl;
import cn.qblank.util.OrderStatus;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * 评论
     */
    public CommentServlet() {
        super();
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
		//得到订单
		OrderServiceImpl osi=new OrderServiceImpl();
		String order_id=request.getParameter("order_id");
		System.out.println("order_id:"+order_id);
		HttpSession session=request.getSession();
		@SuppressWarnings("unchecked")
		
		//获取session中的orders
		List<Order> orders=(List<Order>) session.getAttribute("orders");
		//筛选出所需要的order
		Order order=osi.getOrder(orders, order_id);
//		System.out.println("订单列表："+order);
		//将购物车的order放入session中
		session.setAttribute("commentOrder", order);
		//获取判断的属性
		switch(request.getParameter("activity")){
		case "0":
			//0为跳转到评论页面
			response.sendRedirect("/Store/pages/webStore/html/Comment.jsp");
			break;
		case "1":
			//1为提交评论
			List<Comment> comments=new ArrayList<Comment>();
			Comment comment=null;
			String text="";
			for(int i=0;i<order.getOrder_items().size();i++){
				text=new String(request.getParameter("comment"+i).getBytes("ISO-8859-1"),"utf-8");
				/*text = request.getParameter("comment"+i);*/
			/*	System.out.println(text);
				System.out.println(orders);
				System.out.println(order);*/
				comment=new Comment();
				comment.setComment(text);
				comment.setP_id(order.getOrder_items().get(i).getProduct().getId());
//				System.out.println("p_id:"+order.getOrder_items().get(i).getProduct().getId());
				comment.setTime(new Date(System.currentTimeMillis()));
				comment.setUser_id(order.getUser_id());
				comments.add(comment);
			}
//			System.out.println("comments:"+comments);
			//评论完修改评论状态
			System.out.println("修改订单状态："+new OrderServiceImpl().updateOrderStatus(order_id, OrderStatus.CANREMOVE));
			System.out.println("插入评论："+new CommentServiceImpl().insertComment(comments));
			response.sendRedirect("/Store/control/orderServlet?status=0");
			break;
		}
	}

}
