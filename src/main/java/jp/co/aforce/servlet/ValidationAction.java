package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.tool.Action;

public class ValidationAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String address = request.getParameter("address");
		String mailAddress = request.getParameter("mailAddress");

		String url = validation(id, pass, lastName, firstName, address, mailAddress);

		System.out.println(url);
		
		session.setAttribute("id", id);
		session.setAttribute("pass", pass);
		session.setAttribute("lastName", lastName);
		session.setAttribute("firstName", firstName);
		session.setAttribute("address", address);
		session.setAttribute("mailAddress", mailAddress);
		

		return url;
	}

	//入力バリデーション
	private String validation(String id, String pass, String lastName, String firstName, String address,
			String mailAddress) {
		String url = "useradd-error.jsp";

		if (id == null || id.isBlank() || id.length() < 4 || id.length() > 10)
			return url;

		if (pass == null || pass.isBlank() || pass.length() < 8 || pass.length() > 32)
			return url;

		if (lastName == null || lastName.isBlank() || lastName.isEmpty() || lastName.length() > 32)
			return url;

		if (firstName == null || firstName.isBlank() || firstName.isEmpty() || firstName.length() > 32)
			return url;

		if (address == null || address.isBlank() || address.isEmpty() || id.length() > 128)
			return url;

		if (mailAddress == null || mailAddress.isBlank() || mailAddress.isEmpty() || mailAddress.length() > 128)
			return url;

		url = "user-validation.jsp";
		return url;
	}
}
