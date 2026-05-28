package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.UserDAO;

/**
 * Servlet implementation class UserBeen
 */
@WebServlet("/views/loginaction")
public class LoginAction extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unlikely-arg-type")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		if (id == null || id.isBlank() || id.length() > 10) {
			request.getRequestDispatcher("login-error.jsp")
			.forward(request, response);
		}

		if (pass == null || pass.isBlank() || pass.length() > 32) {
			request.getRequestDispatcher("login-error.jsp")
			.forward(request, response);
		}

		try {
			
			UserDAO dao = new UserDAO();
			User u = dao.login(id, pass);
			String lastName = u.getLastName(); 
			
			
			//このＩＤとパスワードはありませんみたいなのをコードで書く
			if( lastName != null) {
				session.setAttribute("lastName", lastName);
				request.getRequestDispatcher("user-menu.jsp")
				.forward(request, response);
			}else {
				request.getRequestDispatcher("login-error.jsp")
				.forward(request, response);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
