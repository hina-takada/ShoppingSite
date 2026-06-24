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

import jp.co.aforce.beans.User;

/**
	* Servlet Filter implementation class LoginCheck
	* http://localhost:8080/ShoppingSite/views/HomeProduct.action
	*/

@WebFilter(urlPatterns = {
	"/views/admin-menu.jsp",
	"/views/Product.action",
	"/views/ProductAdd.action",
	"/views/ProductEdit.action",
	"/views/ProductDelete.action",
	"/views/product-menu.jsp",
	"/views/product-add.jsp",
	"/views/product-edit.jsp",
	"/views/product-delete.jsp"
	
})
public class AdminCheckFilter extends HttpFilter {
    
/**
	* @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	*/
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
			
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		
		HttpSession session = req.getSession(false);
		
		if(session == null) {
			res.sendRedirect(req.getContextPath() + "HomeProduct.action");
			return;
		}
				
		if(session.getAttribute("user") == null) {
			res.sendRedirect(req.getContextPath() + "/views/not-logged-in.jsp");
			return;
		}
		
		User user = (User) session.getAttribute("user");
		
		if(!"ADMIN".equals(user.getRole())) {
			res.sendRedirect("user-menu.jsp");
			return;
		}
		
		chain.doFilter(request, response);
		}
		
		}
		