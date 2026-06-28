package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.UpdateUserBeen;
import jp.co.aforce.beans.User;
import jp.co.aforce.tool.Action;

public class EditValidationAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String mode = request.getParameter("model");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String passConfirm = request.getParameter("passConfirm");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String address = request.getParameter("address");
		String mailAddress = request.getParameter("mailAddress");
		
		User user = (User)session.getAttribute("user");
		if(user == null) {
			System.out.println("userエラー");
			return "edit-error.jsp";
		}
		
		boolean isValid = validation(user.getId(),id,passConfirm,pass,lastName, firstName, address, mailAddress);
		if(isValid == false) {
			System.out.println("edit-errorエラー");
			return "edit-error.jsp";
		}
		
		UpdateUserBeen upUser = new UpdateUserBeen();
		
		upUser.setId(id);
		upUser.setPass(pass);
		upUser.setPassConfirm(passConfirm);
		upUser.setLastName(lastName);
		upUser.setFirstName(firstName);
		upUser.setAddress(address);
		upUser.setMailAddress(mailAddress);
		
		
		session.setAttribute("upUser", upUser);
		session.setMaxInactiveInterval(60*3);
		
		if("admin".equals(mode)) return "admin-edit-validation.jsp";
		
		return "edit-validation.jsp";
	}
	
	
	//入力バリデーション
		private boolean validation(String uid,String id,String passConfirm, String pass, String lastName, String firstName, String address,
				String mailAddress) {

			if (id == null || id.isBlank() || id.length() < 4 || id.length() > 10 || !id.matches("^[a-zA-Z0-9][a-zA-Z0-9@#$%&]*$")) {
				System.out.println("idエラー");
				return false;
			}
			
			if (pass == null || pass.isBlank() || pass.length() < 8 || pass.length() > 32 || !pass.matches("^[a-zA-Z0-9][a-zA-Z0-9@#$%&]*$")) {
				System.out.println("passエラー");
				return false;
			}
			
			if (passConfirm == null || passConfirm.isBlank() || passConfirm.length() < 8 || passConfirm.length() > 32 || !passConfirm.matches("^[a-zA-Z0-9][a-zA-Z0-9@#$%&]*$")) {
				System.out.println("passエラー");
				return false;
			}
			
			if (lastName == null || lastName.isBlank() || lastName.isEmpty() || lastName.length() > 32 || !lastName.matches("^[ぁ-んァ-ヶ一-龠々A-Za-z]+$")) {
				System.out.println("lastNameエラー");
				return false;
			}

			if (firstName == null || firstName.isBlank() || firstName.isEmpty() || firstName.length() > 32 || !firstName.matches("^[ぁ-んァ-ヶ一-龠々A-Za-z]+$")) {
				System.out.println("lastNameエラー");
				return false;
			}

			if (address == null || address.isBlank() || address.isEmpty() || address.length() > 128 || !address.matches("^[^<>]+$")) {
				System.out.println("addressエラー");
				return false;
			}

			if (mailAddress == null || mailAddress.isBlank() || mailAddress.isEmpty() || mailAddress.length() > 128 || !mailAddress.matches("^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
				System.out.println("mailAddressエラー");
				return false;
			}
				
			return true;
		}
}
