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
	* Servlet Filter implementation class LoginCheckFilter
	*/

@WebFilter("/")
public class LoginCheckFilter extends HttpFilter implements Filter {
/**
	@see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	*/
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request2 = (HttpServletRequest)request;
		HttpServletResponse response2 = (HttpServletResponse)response;
		
		String uri = request2.getRequestURI();
		
		if(uri.endsWith("login-in.jsp") || uri.endsWith("Login.action")) {
		chain.doFilter(request, response);
		return;
		}
		
		HttpSession session = request2.getSession(false);
		
		if(session == null || session.getAttribute("user") == null) {
		response2.sendRedirect("login-in.jsp");
		return;
		}
		
		chain.doFilter(request, response);
		
		}
		
		}
		