package cn.qblank.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆验证过滤器
 * @author Administrator
 *
 */
public class LoginFilter implements Filter {

    public LoginFilter() {
    	
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//先转型
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		if (session == null) {
			resp.sendRedirect("/Store/pages/webStore/html/login.jsp");
		}
		String userName = (String) session.getAttribute("username");
		
		if (userName == null || "".equals(userName)) {
			resp.sendRedirect("/Store/pages/webStore/html/login.jsp?username= " + userName);
			return;
		}
		//传入的状态码
		/*switch(request.getParameter("status")){
		case "1":
			//表示由订单页面跳转过来，直接转到评价页面
			resp.sendRedirect("/Store/pages/webStore/html/Comment.jsp");
		}*/
		chain.doFilter(req, resp);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
