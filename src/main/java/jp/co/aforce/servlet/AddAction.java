package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class AddAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		User user = (User)session.getAttribute("user");
		UserDAO dao = new UserDAO();
		boolean line = dao.insert(user.getId(), user.getPass(), user.getLastName(), 
				user.getFirstName(), user.getAddress(), user.getMailAddress());
		
		if(line == false) return "registered-error.jsp";
		
		session.removeAttribute("user");
		
		return "user-success.jsp";
	}
	
	

}
