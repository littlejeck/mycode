package com.atguigu.atcrowdfunding.filter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.atguigu.atcrowdfunding.bean.TAdmin;
import com.atguigu.atcrowdfunding.constant.AppConstant;

/**
 * 1、编写一个Filter
 * 2、在web.xml中配置
 * @author lfy
 *
 */
public class PermissionFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI();
		// http://localhost:8080/atcrowdingfunding-web/user/get/1
		//URL：URI
		//URL：（Location）:资源的完整路径;http://localhost:8080/atcrowdingfunding-web/user/get/1
		//URI：（Identity）:资源的标识;/user/get/1；
		
		HttpSession session = req.getSession();
		HttpServletResponse resp = (HttpServletResponse) response;
		TAdmin admin = (TAdmin) session.getAttribute(AppConstant.LOGIN_USER_SESSION_KEY);
		
		//1、去数据库查询，这个用户对于这个访问路径是否有权限；获取到用户所有可以访问的资源url列表
		Set<String> urls = new HashSet<String>();
		if(urls.contains(uri)) {
			//有权限就放行
			chain.doFilter(req, response);
		}else {
			resp.sendRedirect("/无权.jsp");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
