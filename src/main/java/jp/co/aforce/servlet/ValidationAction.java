package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.User;
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
		if(url.equals("useradd-error.jsp")) return url;
		
		User user = new User();
		//追加
		user.setId(id);
		user.setPass(pass);
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setAddress(address);
		user.setMailAddress(mailAddress);
		
		
		//セッション
		session.setAttribute("user", user);
		session.setMaxInactiveInterval(60*3);
		
		return url;
	}

	//入力バリデーション
	private String validation(String id, String pass, String lastName, String firstName, String address,
			String mailAddress) {
		String url = "useradd-error.jsp";

		if (id == null || id.isBlank() || id.length() < 4 || id.length() > 10 || !id.matches("^(?=.*[a-zA-Z0-9]).+$"))
			return url;

		if (pass == null || pass.isBlank() || pass.length() < 8 || pass.length() > 32 || !pass.matches("^(?=.*[a-zA-Z0-9]).+$"))
			return url;

		if (lastName == null || lastName.isBlank() || lastName.isEmpty() || lastName.length() > 32 || !lastName.matches("^[ぁ-んア-ケ一-龠々A-Za-z]"))
			return url;

		if (firstName == null || firstName.isBlank() || firstName.length() > 32 || !lastName.matches("^[ぁ-んア-ケ一-龠々A-Za-z]") )
			return url;

		if (address == null || address.isBlank() || address.isEmpty() || address.length() > 128)
			return url;

		if (mailAddress == null || mailAddress.isBlank() || mailAddress.isEmpty() || address.isEmpty() || mailAddress.length() > 128 || !mailAddress.matches("^[A-Za-z0-9]+@([A-Za-z0-9.-]+)$"))
			return url;

		url = "user-validation.jsp";
		return url;
	}
}
