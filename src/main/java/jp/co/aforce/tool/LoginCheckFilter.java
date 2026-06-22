package jp.co.aforce.tool;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
	* Servlet Filter implementation class LoginCheck
	* http://localhost:8080/ShoppingSite/views/HomeProduct.action
	*/

@WebFilter(urlPatterns = {
	"/views/Menu.action",
	"/views/purchase-in.jsp",
	"/views/OrderHistory.action"
})
public class LoginCheckFilter extends HttpFilter {
    
/**
	* @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	*/
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession(false);
		
		if(session == null) {
			res.sendRedirect(req.getContextPath() + "/views/HomeProduct.action");
			return;
		}
		
		if(session.getAttribute("user") == null) {
			//試し
				if("true".equals(req.getParameter("fromCart"))) {
					session.setAttribute("returnUrl", "cart.jsp");
				}else {
					session.setAttribute("returnUrl", "HomeProduct.action");
				}
			//試し
			
			res.sendRedirect(req.getContextPath() + "/views/not-logged-in.jsp");
			return;
		}
		
		
		
		chain.doFilter(request, response);
		}
		
		}
		