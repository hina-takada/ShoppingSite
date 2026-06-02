/*package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class AddAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		
		
		UserDAO dao = new UserDAO();
		int line = dao.insert(id, pass, lastName, firstName, address, mailAddress);
		
		
		if(url == null || line < 0){
			url = "useradd-error.jsp";
			return url;
		}
		
		return url;
	}
	
	

}
*/