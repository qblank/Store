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

public class ProductServlet extends HttpServlet {

	int num = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取传过来的id
		String pro_id = request.getParameter("pro_id");
		//通过id查找出这一类商品
		ArrayList<Product> proList = new CategoryServiceImpl().findById(pro_id);
		//存入域中
		HttpSession session = request.getSession();
		
		ArrayList<Product> pros = new CategoryServiceImpl().getProducts();
		session.setAttribute("pro_id", pro_id);
		session.setAttribute("prosList", pros);
		session.setAttribute("proList", proList);
		response.sendRedirect(request.getContextPath()+"/pages/webStore/html/search_result.jsp");
		return;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
