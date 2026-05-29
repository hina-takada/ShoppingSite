package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletContext;
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
 * 
 * ログイン画面の遷移
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
		
		/**
		 * ログイン処理
		 * 
		 */
		try {
			browser(request, response, session, id);
			
			UserDAO dao = new UserDAO();
			User user = dao.login(id, pass);

			validation(request, response, user, session);

		} catch (Exception e) {
			e.printStackTrace();
			
		}

	}
	
	//ログインのバリデーション
	private void validation(HttpServletRequest request,HttpServletResponse response,
			User u,HttpSession session) throws Exception {
		final String ADMIN = "ADMIN";
		
		if(u == null) {
			request.getRequestDispatcher("login-error.jsp")
			.forward(request, response);
			return;
		}
		
		session.setAttribute("user", u);
		
		if (ADMIN.equals(u.getRole())) {
			response.sendRedirect("admin-menu.jsp");
		}
			response.sendRedirect("user-menu.jsp");;
		
	}
	
	
	/**
	 * 異なるブラウザが同じIDにログインする場合の処理
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @param id
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private void browser(HttpServletRequest request,HttpServletResponse response,
			HttpSession session,String id) throws Exception{
		ServletContext application = getServletContext();
		
		Map<String, HttpSession> loginUsers = 
				(Map<String, HttpSession>)application.getAttribute("loginUsers");
		
		if(loginUsers == null) {
			loginUsers = new HashMap<>();
			application.setAttribute("loginUsers", loginUsers);
		}
		
		if(loginUsers.containsKey(id)) {
			request.setAttribute("error","既にログイン中です");
			request.getRequestDispatcher("browser-error.jsp").forward(request, response);
			return;
		}
		
	}

}
