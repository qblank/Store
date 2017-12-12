package cn.qblank.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qblank.service.impl.OrderItemServiceImpl;
import cn.qblank.service.impl.OrderServiceImpl;

@SuppressWarnings("serial")
public class ShopCarDelete extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//删除
		String itemId = req.getParameter("itemId");
		boolean isDelete = new OrderItemServiceImpl().deleteOrderItem(itemId);
		
		if (isDelete) {
			System.out.println("删除成功");
		}else{
			System.out.println("删除失败");
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
