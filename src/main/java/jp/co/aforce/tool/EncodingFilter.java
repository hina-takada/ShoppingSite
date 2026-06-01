package jp.co.aforce.tool;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

/**
	* Servlet Filter implementation class EncodingFilter
	*/

@WebFilter("/*")
public class EncodingFilter extends HttpFilter implements Filter {
    
/**
	* @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	*/
		public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		/*		response.setContentType("text/html; charset=UTF-8");*/
		
		System.out.println("フィルターの前処理");
		
		chain.doFilter(request, response);
		
		System.out.println("フィルターの後処理");
		
		
		}
		
		
		}
		