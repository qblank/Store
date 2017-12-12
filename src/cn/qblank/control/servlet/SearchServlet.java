package cn.qblank.control.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Product;
import cn.qblank.service.impl.CategoryServiceImpl;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
	@Override
	//商品展示页面
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

			//获取用户输入得信息
			String input_text = req.getParameter("input_text");
			//Product集合
			ArrayList<Product> pro = new CategoryServiceImpl().findByInput(input_text);
			//创建session对象
			HttpSession session = req.getSession();
			
			session.setAttribute("proList", pro);
			session.setAttribute("input_text", input_text);
			
			ArrayList<Product> pros = new CategoryServiceImpl().getProducts();
			session.setAttribute("prosList", pros);
			
			resp.sendRedirect("/Store/pages/webStore/html/search_result.jsp");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
