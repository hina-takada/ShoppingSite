package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.SessionManager;

public class LoginAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		//入力バリデーション
		if (id == null || id.isBlank() ||id.length() < 4 || id.length() > 10) {
			request.getRequestDispatcher("login-error.jsp")
					.forward(request, response);
		}

		if (pass == null || pass.isBlank() || pass.length() < 5 || pass.length() > 32) {
			request.getRequestDispatcher("login-error.jsp")
					.forward(request, response);
		}

		
		UserDAO dao = new UserDAO();
		User user = dao.login(id, pass);

		String url = validation(request, response, user,session);
		return url;
	}

	//ログインのバリデーション
	private String validation(HttpServletRequest request, HttpServletResponse response,
			User user, HttpSession session) throws Exception {
		final String ADMIN = "ADMIN";
		
		if(user == null) {
			return "login-error.jsp";
		}

		//別ブラウザで同じIDがログイン中(今後クッキー追加)
		HttpSession oldSession = SessionManager.loginUsers.get(user.getId());
		if (oldSession != null && oldSession != session)
			return "test-error.jsp";

		
		//ログイン成功処理
		session.setAttribute("user", user);//セッションスコープ
		session.setMaxInactiveInterval(10);//仮置き
		SessionManager.loginUsers.put(user.getId(), session);//セッションを登録

		//メニュー処理
		if (ADMIN.equals(user.getRole()))
			return "admin-menu.jsp";
		
		return "user-menu.jsp";

	}

	
}
