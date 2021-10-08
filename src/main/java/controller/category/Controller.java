package controller.category;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

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
import pojo.Product;

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
		String ids = (request.getPathInfo());
		int id = 0;
		if(ids==null) {
			response.sendRedirect("/ecom");
		}else {
			if(ids.lastIndexOf("/")!=0) {
				id  = Integer.parseInt(ids.substring(1,ids.indexOf("/",1)));
			}else {
				id  = Integer.parseInt(ids.substring(1));
			}
		}
		
			String name = request.getParameter("newname");
			
			if(name==null) {
				response.sendRedirect("/ecom/category/update-post/"+id+"/");
			}else {
				boolean status;
				if(request.getParameter("newstatus").equals("active")) {
					status = true;
				}else {
					status = false;
				}
				
				Category c = new Category(id,name,status);
				
				DBUpdatepost updateob = new DBUpdatepost(c);
				if(updateob.updateReport()) {
					//if category updated, checking if it is linked with product
					//if category status is updated to notactive, changing all product status to not active linked with that category
					DBDisplay obsearch = new DBDisplay("product","where category_id="+id);
					if(!obsearch.isEmpty() && c.isStatus()==false) {
						ArrayList<Product> result = obsearch.displayAllProduct();
						for (int i = 0;i<result.size();i++) {
							Product p = result.get(i);
							p.setStatus(false);
							p.setImage(null);
							updateob = new DBUpdatepost(p);
						}
					}
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
		
		//searching if product have category id before delete
		DBDisplay obsearch = new DBDisplay("product","where category_id = "+c.getId());
		if(obsearch.isEmpty()) {
			DBDelete obd = new DBDelete(c);
			if (obd.deleteReport()) {
				response.sendRedirect("/ecom/category/view-post");
			}else {
				out.print("deleteion error");
			}
		}else {
			response.sendRedirect("/ecom/category/view-post?val=deleteerr");
		}
	}
}
