package jp.co.aforce.servlet;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.tool.Action;
import jp.co.aforce.tool.SessionManager;

public class LogoutAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		if(user != null) {
			SessionManager.removeUser(user.getId());
			session.invalidate();
			return "logout-in.jsp";
		}
		
		return "logout-error.jsp";
	}


	

}
