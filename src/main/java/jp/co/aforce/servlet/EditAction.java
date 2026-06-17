package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UpdateUserBeen;
import jp.co.aforce.beans.User;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class EditAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String mode = request.getParameter("model");
		
		UpdateUserBeen upUser = (UpdateUserBeen)session.getAttribute("upUser");
		User user = (User)session.getAttribute("user");
		
		if(upUser == null || user == null) return "edit-error.jsp";
		
		UserDAO dao = new UserDAO();
		boolean line = dao.update(user.getId(),upUser.getId(),upUser.getPass(),upUser.getLastName(),upUser.getFirstName()
				,upUser.getAddress(),upUser.getMailAddress());
		
		if(line == false) return "edit-error.jsp";
		
		user.setId(upUser.getId());
		user.setPass(upUser.getPass());
		user.setLastName(upUser.getLastName());
		user.setFirstName(upUser.getFirstName());
		user.setAddress(upUser.getAddress());
		user.setMailAddress(upUser.getMailAddress());
		
		session.setAttribute("user", user);
		
		if("ADMIN".equals(user.getRole()))return "admin-edit-success.jsp";
		
		return "edit-success.jsp";
	}

}
