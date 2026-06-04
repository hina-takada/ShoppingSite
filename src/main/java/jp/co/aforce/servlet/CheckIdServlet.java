package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jp.co.aforce.dao.UserDAO;

/**
 * Servlet implementation class CheckIdServlet
 */
@WebServlet("/checkid")
public class CheckIdServlet extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = (String) request.getParameter("id");
		
		try {
			UserDAO dao = new UserDAO();
			boolean userId = dao.serchId(id);
			
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().write("{\"exists\":" + userId + "}");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
