package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.InsertUserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class AddAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		InsertUserBean insertUser = (InsertUserBean)session.getAttribute("insertUser");
		UserDAO dao = new UserDAO();
		boolean line = dao.insert(insertUser.getId(), insertUser.getPass(), insertUser.getLastName(), 
				insertUser.getFirstName(), insertUser.getAddress(), insertUser.getMailAddress());
		
		if(line == false) return "session-error.jsp";
		
		session.removeAttribute("insertUser");
		
		return "user-success.jsp";
	}
	
	

}
