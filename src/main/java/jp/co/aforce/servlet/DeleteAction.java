package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class DeleteAction extends Action{

	@SuppressWarnings("unused")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		UserDAO dao = new UserDAO();
		
		User user = (User)session.getAttribute("user");
		String id = user.getId();
		String role = user.getRole();
		
		if(user == null || user.getId() == null || user.getId().isBlank()) {
			return "user-delete-success.jsp";
		}
		
		
		boolean line = dao.delete(user.getId());
		if(line == false) {
			return "delete-error.jsp";
		}
		
		
		session.removeAttribute("user");
		if(user == null) {
			return "delete-error.jsp";
		}

		return "delete-success.jsp";
	}

}
