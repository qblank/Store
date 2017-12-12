package cn.qblank.control.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.qblank.model.entity.Order;
import cn.qblank.model.entity.PCategory;
import cn.qblank.model.entity.Product;
import cn.qblank.model.entity.TowPCategory;
import cn.qblank.model.entity.User;
import cn.qblank.service.impl.CategoryServiceImpl;
import cn.qblank.service.impl.OrderServiceImpl;
import cn.qblank.service.impl.RechargeServiceImpl;
import cn.qblank.service.impl.UserServiceImpl;

@SuppressWarnings("serial")
//主页加载是显示商品分类
public class CategoryServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//创建一个CategoryServiceImpl对象
		CategoryServiceImpl cs = new CategoryServiceImpl();
		ArrayList<PCategory> pCategory = cs.getPCategory();
		String onePC = null;//大类商品名
		String picurl = null;//小类图片地址
		ArrayList<TowPCategory> towPC = null;
		ArrayList<Product> pic = null;
		//获取Session对象
		HttpSession session = req.getSession();
		//遍历最大的那个对象
		for (PCategory p : pCategory) {
			onePC = p.getName();
			//获取二级类的集合
			towPC = cs.getTowPCategory(onePC);
			//遍历二级类的集合获取对应的名字和图像集合
			for(TowPCategory two :  towPC){
				picurl = two.getName();
				//获取图像集合
				pic = cs.getPicURL(picurl,1);
				//将图像的集合存入二级类中  
				two.setProduct(pic);
			}
			//将存储了图像的二级类存入一级类中
			p.setTowPCategory(towPC);
		}
		//将获取到的集合存到域中  将一级类的集合存入域对象中
		 session.setAttribute("list",pCategory);
		 //获取用户名查询用户余额
		 String username = null;
			HttpSession sessions = req.getSession(false);
			username = (String)sessions.getAttribute("username");
			if (username == null) {
				resp.sendRedirect("/Store/pages/webStore/html/index.jsp");
			}else{
				RechargeServiceImpl recService = new RechargeServiceImpl();
				User user = recService.getUserMessage(username);
				sessions.setAttribute("userMoney", user.getMoney());
			 resp.sendRedirect("/Store/pages/webStore/html/index.jsp");
			}
			//登陆后预加载购物车
			//查询该用户最新的购物车的信息
			Order shoppingCar=new OrderServiceImpl().getShppingCarList(new UserServiceImpl().findIdByName((String)session.getAttribute("username")));
			session.setAttribute("shoppingCar", shoppingCar);
			//将购物车的信息传入session
			session.setAttribute("shoppingCarInfo",new OrderServiceImpl().getShoppingCarInfo(shoppingCar));
				
		return;
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}
