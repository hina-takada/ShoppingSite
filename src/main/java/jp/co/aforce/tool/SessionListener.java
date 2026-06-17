package jp.co.aforce.tool;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener{
	
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
		
		String userId = (String)se.getSession().getAttribute("userId");
		
		if(userId != null) {
			SessionManager.loginUsers.remove(userId);
		}
		
	}
}
