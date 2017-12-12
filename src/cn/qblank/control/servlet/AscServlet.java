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
//降序
public class AscServlet extends HttpServlet {
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			HttpSession session = req.getSession();
			String input_text = (String) session.getAttribute("input_text"); 
				ArrayList<Product> pr = new CategoryServiceImpl().findByInputAsc(input_text);
				session.setAttribute("proList", pr);
				session.setAttribute("input_text", input_text);
				if(pr.size()== 0){
					String id = (String) session.getAttribute("pro_id");
					ArrayList<Product> p = new CategoryServiceImpl().findByIdAsc(id);
					session.setAttribute("pro_id",id);
					session.setAttribute("proList", p);
					resp.sendRedirect("/Store/pages/webStore/html/search_result.jsp");
				}else{
					resp.sendRedirect("/Store/pages/webStore/html/search_result.jsp");
				}
				
				
			
		}
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
		}
}
