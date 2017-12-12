package cn.qblank.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Order;
import cn.qblank.service.impl.LoginRegServiceImpl;
import cn.qblank.service.impl.OrderServiceImpl;
import cn.qblank.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse resp)
	
			throws ServletException, IOException {
		String name = req.getParameter("name");
		String user = new LoginRegServiceImpl().getUserName(name);
		String password = req.getParameter("password");
		String passwords = new LoginRegServiceImpl().getPassword(name);
		//判断用户是否存在
		if (user!=null) {
			if (passwords.equals(password)) {
				//登陆成功, 创建会话
				HttpSession session = req.getSession();
				session.setMaxInactiveInterval(60*60*24);
				session.setAttribute("username", name);
				
				
				
				//跳转到上一个页面
				resp.sendRedirect("/Store/CategoryServlet");
				
			}else{
				//刷新页面
				/*resp.sendRedirect("/Store/pages/webStore/html/login.html");*/
				resp.getWriter().write("登录失败 请重新登录");
				resp.getWriter().close();
				resp.sendRedirect("/Store/pages/webStore/html/login.jsp");
//				resp.setHeader("refresh", "2;url=/Store/pages/webStore/html/login.html");
			}
		}else{
			/*resp.sendRedirect("");*/
			//刷新页面
			/*resp.sendRedirect("/Store/pages/webStore/html/login.html");*/
			
			
			resp.sendRedirect("/Store/pages/webStore/html/login.jsp");
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);

	}

}
