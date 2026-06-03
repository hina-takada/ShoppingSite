package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
import jp.co.aforce.tool.Action;

public class EditValidationAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String address = request.getParameter("address");
		String mailAddress = request.getParameter("mailAddress");
		
		String url = validation(lastName, firstName, address, mailAddress);
		if(url.equals("-error.jsp"))return url;
		
		User user = (User)session.getAttribute("user");
		if(user == null) return "-error.jsp";
		
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setAddress(address);
		user.setMailAddress(mailAddress);
		
		session.setAttribute("user", user);
		session.setMaxInactiveInterval(60*3);
		
		return url;
	}
	
	
	//入力バリデーション
		private String validation(String lastName, String firstName, String address,
				String mailAddress) {
			String url = "-error.jsp";

			if (lastName == null || lastName.isBlank() || lastName.isEmpty() || lastName.length() > 32)
				return url;

			if (firstName == null || firstName.isBlank() || firstName.isEmpty() || firstName.length() > 32)
				return url;

			if (address == null || address.isBlank() || address.isEmpty() || address.length() > 128)
				return url;

			if (mailAddress == null || mailAddress.isBlank() || mailAddress.isEmpty() || mailAddress.length() > 128)
				return url;

			url = "edit-validation.jsp";
			return url;
		}
}
