package cn.qblank.control.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Comment;
import cn.qblank.model.entity.User;
import cn.qblank.model.entity.Product;
import cn.qblank.service.impl.CategoryServiceImpl;
import cn.qblank.service.impl.CommentServiceImpl;

@SuppressWarnings("serial")
public class DetailProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String p_id = req.getParameter("p_id");
		//获取session
		HttpSession session = req.getSession();
		
		/*String name = (String) session.getAttribute("username");*/
		
 		
		//调用service层的通过id获取商品信息的方法
		CategoryServiceImpl cate = new CategoryServiceImpl();
		Product pro = cate.getProduct(p_id);
		
	
		//通过p_id获得该商品所有评论
		CommentServiceImpl comment =new CommentServiceImpl();
		 List<Comment> comm = comment.getComments(p_id);
		 
			List<User> user = new ArrayList<User>();
		 //通过评论获取该条评论的用户名
		 for (Comment comment2 : comm) {
			String com = comment2.getUser_id();
			User u = new User();
			u.setName(comment.findusernameByComment(com));
			/*user = comment.findusernameByComment(com);*/
			u.setAge(10);
			user.add(u);
			/*String name =comment.findusernameByComment(comment2.getComment());*/
			
		}
		//将获取到的商品和评论存到session域中
		session.setAttribute("names", user);
		session.setAttribute("product", pro);
		session.setAttribute("comment", comm);
		
		//跳转 
		resp.sendRedirect(req.getContextPath()+"/pages/webStore/html/product.jsp");
		return;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
