package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class UpdateAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		
		if(user == null) return "-error.jsp";
		
		UserDAO dao = new UserDAO();
		int line = dao.update(user.getId(),user.getLastName(),user.getFirstName()
				,user.getAddress(),user.getMailAddress());
		
		if(line < 0) return "-error.jsp";
		
		session.setAttribute("user", user);
		
		return "edit-success.jsp";
	}

}
