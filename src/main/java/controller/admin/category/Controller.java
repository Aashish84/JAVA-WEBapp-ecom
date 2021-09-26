package controller.admin.category;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import databaseservice.crud.DBAddpost;
import databaseservice.crud.DBDelete;
import databaseservice.crud.DBDisplay;
import databaseservice.crud.DBUpdatepost;
import pojo.Category;

@SuppressWarnings("serial")
//@WebServlet("/category/ctrl/*")
public class Controller extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
		response.sendRedirect("/ecom/category/view-post");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
		if(request.getParameter("_method")!=null && request.getParameter("_method").equals("PUT")) {
			doPut(request,response);
		}else if(request.getParameter("_method")!=null && request.getParameter("_method").equals("DELETE")){
			doDelete(request,response);
		}else {
			String name = request.getParameter("categoryname");
			String status = request.getParameter("status");
			PrintWriter out = response.getWriter();
			if(name.length()==0 || status == null) {
				response.sendRedirect("/ecom/category/add-post");
				
			}
			else {
				Category c;
				
				if(status.equals("active")) {
					c = new Category(name , true);
				}else {
					c = new Category(name , false);
				}
				
				DBAddpost ob = new DBAddpost(c);
				
				if(ob.addReport()) {
					response.sendRedirect("/ecom/category/ctrl");
				}else {
					out.print("insertion error");
				}
			}
		}
	}
	
	protected void doPut(HttpServletRequest request , HttpServletResponse response)throws ServletException,IOException{
		PrintWriter out = response.getWriter();
		String i = (request.getPathInfo());
		int id;
		if(i.lastIndexOf("/")!=0) {
			id  = Integer.parseInt(i.substring(1,i.indexOf("/",1)));
		}else {
			id  = Integer.parseInt(i.substring(1));
		}
		
		String name = request.getParameter("newname");
		String status = request.getParameter("newstatus");
		if(name==null || status == null) {
			response.sendRedirect("/ecom/category/update-post/"+id+"/");
		}else {
			Category c ;
			if(status.equals("active")) {  
				c = new Category(id,name,true);
			}else {
				c = new Category(id,name,false);
			}
			DBUpdatepost ob = new DBUpdatepost(c);
			if(ob.updateReport()) {
				response.sendRedirect("/ecom/category/view-post");
			}else {
				out.print("no update");
			}
		}
	}
	
	protected void doDelete(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
		PrintWriter out = response.getWriter();	
		String i = (request.getPathInfo());
		int id;
		if(i.lastIndexOf("/")!=0) {
			id  = Integer.parseInt(i.substring(1,i.indexOf("/",1)));
		}else {
			id  = Integer.parseInt(i.substring(1));
		}
		DBDisplay ob = new DBDisplay("category");
		Category c = ob.displayOneCategory(id);
		DBDelete obd = new DBDelete(c);
		if (obd.deleteReport()) {
			response.sendRedirect("/ecom/category/view-post");
		}else {
			out.print("deleteion error");
		}
	}
}
