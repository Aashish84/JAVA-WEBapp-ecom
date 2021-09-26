package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCheck {
	HttpServletRequest request;
	HttpSession session;
	String adminEmail;
	public LoginCheck(HttpServletRequest request){
		this.request = request;
		this.session = request.getSession();
		adminEmail = (String)session.getAttribute("adminEmail");
	}
	
	public boolean isAdminEmailSet() {
		if(adminEmail!=null){
			return true;
		}
		return false;
	}
	
}
