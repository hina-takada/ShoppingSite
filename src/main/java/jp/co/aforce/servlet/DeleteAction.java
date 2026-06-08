package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class DeleteAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		UserDAO dao = new UserDAO();
		
		User user = (User)session.getAttribute("user");
		String id = user.getId();
		
		if(user == null || id == null || id.isBlank()) {
			return "userDelete-error";
		}
		
		boolean line = dao.delete(user.getId());
		
		if(line == false)return "userDelete-error";
		
		return "userDeleteSuccess.jsp";
	}

}
