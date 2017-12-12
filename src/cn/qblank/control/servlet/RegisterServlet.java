package cn.qblank.control.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.qblank.model.dao.impl.LoginRegImpl;
import cn.qblank.model.entity.User;
import cn.qblank.service.impl.LoginRegServiceImpl;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			String name = req.getParameter("username");
			String psw = req.getParameter("password");
			String psws = req.getParameter("passwords");
			String six = req.getParameter("man");
			int age = Integer.parseInt(req.getParameter("age"));
			String tel = req.getParameter("phone");
			String add = req.getParameter("add");
			String agreen = req.getParameter("agreen").trim();
			//把获取到的数据封装到用户的实体类中
			User users = new User();
			users.setName(name);
			users.setPassword(psw);
			users.setAddress(add);
			users.setAge(age);
			users.setGender(six);
			users.setPhone(tel);
			//用户名是否已注册
			String username = new LoginRegServiceImpl().getUserName(name);
			
			if (psw.equals(psws)&&agreen.equals("T")&&username==null) {
				//2次密码输入不一致
				//没有勾选同意条例
				new LoginRegServiceImpl().registerUser(users);
				resp.sendRedirect("/Store/pages/webStore/html/login.jsp");
			}else{
				resp.sendRedirect("/Store/pages/webStore/html/register.jsp");
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
