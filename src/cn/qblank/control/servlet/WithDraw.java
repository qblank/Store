package cn.qblank.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class WithDraw extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//获取session
		HttpSession session = req.getSession();
		session.removeAttribute("username");
//		req.getRequestDispatcher(req.getContextPath() + "/pages/webStore/html/index.jsp");
		resp.sendRedirect(req.getContextPath() + "//pages/webStore/html/index.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
