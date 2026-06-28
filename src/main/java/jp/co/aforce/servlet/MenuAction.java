package jp.co.aforce.servlet;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jp.co.aforce.beans.PurchaseProductBean;
import jp.co.aforce.beans.User;
import jp.co.aforce.dao.PurchaseDAO;
import jp.co.aforce.tool.Action;

public class MenuAction extends Action {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();

		User user = (User) session.getAttribute("user");
		if (user == null)
			return "home.jsp";

		/**
		 * 
		 */
		PurchaseDAO dao = new PurchaseDAO();
		List<PurchaseProductBean> history = dao.historySerch(user.getId());
		
		Map<String, Map<String, List<PurchaseProductBean>>> historyMap = new LinkedHashMap<>();

		for (PurchaseProductBean p : history) {
		    String date =
		        p.getRegistdate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

		    String time =
		    		 p.getRegistdate().format(DateTimeFormatter.ofPattern("HH:mm"));

		    historyMap
		        .computeIfAbsent(date,
		            k -> new LinkedHashMap<>())
		        .computeIfAbsent(time,
		            k -> new ArrayList<>())
		        .add(p);
		}
		
		session.setAttribute("historyMap", historyMap);

		if ("ADMIN".equals(user.getRole()))
			return "admin-menu.jsp";

		return "user-menu.jsp";
	}
}
