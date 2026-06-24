package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class LoginAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pass = request.getParameter("pass");

		//入力バリデーション
		if (id == null || id.isBlank() || id.length() < 4 || id.length() > 10 || !id.matches("^[a-zA-Z0-9][a-zA-Z0-9@#$%&]*$")) {
			return "login-error.jsp";
		}

		if (pass == null || pass.isBlank() || pass.length() < 8 || pass.length() > 32
				|| !pass.matches("^[a-zA-Z0-9][a-zA-Z0-9@#$%&]*$")) {
			return "login-error.jsp";
		}

		UserDAO dao = new UserDAO();
		User users = dao.serch(id, pass);
		
		String url = validation(request, response, users, session);
		return url;
	}

	//ログインのバリデーション
	private String validation(HttpServletRequest request, HttpServletResponse response,
			User users, HttpSession session) throws Exception {
		final String ADMIN = "ADMIN";

		if (users == null) {
			return "login-error.jsp";
		}

		/*//別ブラウザで同じIDがログイン中(今後クッキー追加?)
		HttpSession oldSession = SessionManager.loginUsers.get(users.getId());
		if (oldSession != null && oldSession != session)
			return "registered-login-error.jsp";*/

		//ログイン成功処理
		session.setAttribute("user", users);//セッションスコープ
		session.setMaxInactiveInterval(60*60*24);//仮置き時間

		session.setAttribute("userId", users.getId());//セッション破棄時にMapから削除するキー
		/*SessionManager.loginUsers.put(users.getId(), session);*///キー：ユーザー名、値：セッション

		//メニュー処理
		if (ADMIN.equals(users.getRole()))
			return "admin-menu.jsp";
		
		/**
		 * 試し
		 */
		String retunUrl = (String)session.getAttribute("returnUrl");
		if(retunUrl != null) {
			session.removeAttribute("returnUrl");
			
			return retunUrl;
		}
		
		/**
		 * 試し
		 */
		

		return "HomeProduct.action";

	}

}
