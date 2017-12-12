package cn.qblank.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EncodingFilter implements Filter {
	private FilterConfig config;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		String encoding = config.getInitParameter("encoding");
		if (encoding == null) {
			encoding = "utf-8";
		}
		request.setCharacterEncoding(encoding);
		response.setContentType("text/html;charset= '"+encoding+"'");
		response.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.config = fConfig;
	}

	@Override
	public void destroy() {
		
	}


}
