package jp.co.aforce.servlet;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.InsertUserBean;
import jp.co.aforce.dao.UserDAO;
import jp.co.aforce.tool.Action;

public class AddValidationAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String passConfirm = request.getParameter("passConfirm");
		String lastName = request.getParameter("lastName");
		String firstName = request.getParameter("firstName");
		String address = request.getParameter("address");
		String mailAddress = request.getParameter("mailAddress");

		String url = validation(id, pass,passConfirm,lastName, firstName, address, mailAddress);
		if(url.equals("user-add-error.jsp")) return url;
		
		InsertUserBean insertUser = new InsertUserBean();
		//追加
		insertUser.setId(id);
		insertUser.setPass(pass);
		insertUser.setPassConfirm(passConfirm);
		insertUser.setLastName(lastName);
		insertUser.setFirstName(firstName);
		insertUser.setAddress(address);
		insertUser.setMailAddress(mailAddress);
		
		
		//セッション
		session.setAttribute("insertUser", insertUser);
		
		return url;
	}

	//入力バリデーション
	private String validation(String id, String pass,String passConfirm, String lastName, String firstName, String address,
			String mailAddress) throws Exception {
		String url = "user-add-error.jsp";
		UserDAO dao = new UserDAO();
		boolean exeit = dao.userCheck(id);
	

		if (id == null || id.isBlank() || id.length() < 4 || id.length() > 10 || exeit == true || !id.matches("^[a-zA-Z0-9][a-zA-Z0-9@#$%&]*$")) {
			System.out.println("IDエラー");
			return url;
		}

		if (pass == null || pass.isBlank() || pass.length() < 8 || pass.length() > 32 || !pass.matches("^[a-zA-Z0-9][a-zA-Z0-9@#$%&]*$")){
			System.out.println("passエラー");
			return url;
		}
		
		if (passConfirm == null || !passConfirm.equals(pass) || passConfirm.isBlank() || passConfirm.length() < 8 || passConfirm.length() > 32 || !passConfirm.matches("^[a-zA-Z0-9][a-zA-Z0-9@#$%&]*$")){
			System.out.println("passエラー");
			return url;
		}
		
		if (lastName == null || lastName.isBlank() || lastName.isEmpty() || lastName.length() > 32 || !lastName.matches("^[ぁ-んァ-ヶ一-龠々A-Za-z]+$")){
			System.out.println("lnameエラー");
			return url;
		}

		if (firstName == null || firstName.isBlank() || firstName.length() > 32 || !firstName.matches("^[ぁ-んァ-ヶ一-龠々A-Za-z]+$") ){
			System.out.println("fnameエラー");
			return url;
		}

		if (address == null || address.isBlank() || address.isEmpty() || address.length() > 128 || !address.matches("^[^<>]+$")){
			System.out.println("addエラー");
			return url;
		}
		if (mailAddress == null || mailAddress.isBlank() || mailAddress.isEmpty() || address.isEmpty() || mailAddress.length() > 128 || !mailAddress.matches("^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){
			System.out.println("mailエラー");
			return url;
		}

		url = "user-add-validation.jsp";
		return url;
	}

}
