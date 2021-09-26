package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import databaseservice.crud.DBSearch;
import pojo.User;

public class Login extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		response.sendRedirect("/ecom/login");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User u = new User(email,password);
		DBSearch ob = new DBSearch();
		
		if(ob.isAdmin(u)) {
			HttpSession session = request.getSession();
			session.setAttribute("adminEmail", email);
			response.sendRedirect("/ecom/admin");
		}else if(ob.isUser(u)) {
			response.sendRedirect("/ecom");	
		}else {
			response.sendRedirect("/ecom/login");
		}
	}
}	
