package cn.qblank.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.User;
import cn.qblank.service.impl.RechargeServiceImpl;
/**
 * 充值
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
public class RechargeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//首先获取充值的数值
		String recharge = req.getParameter("recharge");
		//需要获取到账户的总金额
		RechargeServiceImpl recService = new RechargeServiceImpl();
		/**
		 * 通过名字获取用户信息
		 * 获取session值
		 */
		String username = null;
		HttpSession session = req.getSession(false);
		if (session == null || "".equals(session)) {
			resp.sendRedirect("/Store/pages/webStore/html/login.jsp");
		}else{
			username = (String)session.getAttribute("username");
		}
		
		if (username == null) {
			resp.sendRedirect("/Store/pages/webStore/html/login.jsp");
		}
		User user = recService.getUserMessage(username);
		//进行充值的操作
		recService.updateMoney(user,recharge,true);
		
		session.setAttribute("userMoney", user.getMoney());
		session.setAttribute("username", username);
		resp.sendRedirect("/Store/pages/webStore/html/index.jsp");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
