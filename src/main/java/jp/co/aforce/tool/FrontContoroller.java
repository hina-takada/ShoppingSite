package jp.co.aforce.tool;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontContoroller
 */
@WebServlet("*.action")
@MultipartConfig
public class FrontContoroller extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			String path = request.getServletPath().substring(1);
			String name = path.replace(".a", "A").replace("views/", "jp.co.aforce.servlet.");
			Action action = (Action)Class.forName(name).
								getDeclaredConstructor().newInstance(); 
			String url = action.execute(request, response);
			
			if(url.contains("-error") || url.contains("-validation") ) {
				request.getRequestDispatcher(url).forward(request, response);
				return;
			}
			
			response.sendRedirect(url);
			return;
				
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	
}
