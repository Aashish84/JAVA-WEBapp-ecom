package controller.admin.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import databaseservice.crud.DBAddpost;
import databaseservice.crud.DBDelete;
import databaseservice.crud.DBDisplay;
import databaseservice.crud.DBUpdatepost;
import pojo.Product;

@WebServlet("/product/ctrl/*")
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ecom/product/view-post");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("_method")!=null && request.getParameter("_method").equals("PUT")) {
			doPut(request,response);
		}else if(request.getParameter("_method")!=null && request.getParameter("_method").equals("DELETE")){
			doDelete(request,response);
		}else {
			String arr[]= {"jpg","jpeg","png"};
			boolean extflag = false;
			
			String productname = request.getParameter("productname");
			int productcategory = Integer.parseInt(request.getParameter("productcategory"));
			boolean status;
			if(request.getParameter("status").equals("active")) {
				status = true;
			}else {
				status = false;
			}
			int price = Integer.parseInt(request.getParameter("price"));
			int discount = Integer.parseInt(request.getParameter("discount"));
			int inventory = Integer.parseInt(request.getParameter("inventory"));
			
			Part filepart = request.getPart("file");
			String fn = filepart.getSubmittedFileName();
			String mime = filepart.getContentType();
			String extension = mime.substring(mime.indexOf("/",1)+1);
			for(String a : arr) {
				if(a.equals(extension)) {
					extflag = true;
				}
			}
			
			if(extflag==false ||  productname.length()==0 ) {	
				response.sendRedirect("/ecom/product/add-post");
			}else {
				Product p = new Product(productname,productcategory, status,price, discount, inventory, fn);
				DBAddpost ob = new DBAddpost(p);
				if(ob.addReport()) {
					filepart.write("D:\\5th sem\\java_ii\\project\\src\\main\\webapp\\files\\"+fn);
					response.sendRedirect("/ecom/product/view-post");
				}else {
					response.sendRedirect("/ecom/product/add-post");
				}
			}
		}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		id from path 
		String ids = (request.getPathInfo());
		if(ids.length()<2) {
			response.sendRedirect("/ecom/product/view-post");
			return;
		}
		int id;
		if(ids.lastIndexOf("/")!=0) {
			id  = Integer.parseInt(ids.substring(1,ids.indexOf("/",1)));
		}else {
			id  = Integer.parseInt(ids.substring(1));
		}

		if(request.getParameter("newproductname")==null || request.getParameter("newproductcategory")==null) {
			response.sendRedirect("/ecom/product/update-post/"+id);
		}else {
//			form elements
			String productname = request.getParameter("newproductname");
			int productcategory = Integer.parseInt(request.getParameter("newproductcategory"));
			boolean status;
			if(request.getParameter("newstatus").equals("active")) {
				status = true;
			}else {
				status = false;
			}
						
			int price = Integer.parseInt(request.getParameter("newprice"));
			int discount = Integer.parseInt(request.getParameter("newdiscount"));
			int inventory = Integer.parseInt(request.getParameter("newinventory"));
			
			Part filepart = request.getPart("newfile");
			String fn = filepart.getSubmittedFileName();
			if( fn==null || fn.length()==0 ) {
				fn = null;	
			}else {
				String arr[]= {"jpg","jpeg","png"};
				boolean extflag = false;
				String mime = filepart.getContentType();
				String extension = mime.substring(mime.indexOf("/",1)+1);
				for(String a : arr) {
					if(a.equals(extension)) {
						extflag = true;
					}
				}
				if(extflag==false ) {
					response.sendRedirect("/ecom/product/view-post?upderr=true");
				}	
			}
			
			Product p = new Product(id,productname,productcategory,status,price,discount,inventory,fn);
			DBUpdatepost ob = new DBUpdatepost(p);
			if(ob.updateReport()) {
				if(fn!=null) {
					//writing file 
					filepart.write("D:\\5th sem\\java_ii\\project\\src\\main\\webapp\\files\\"+fn);
				}
				response.sendRedirect("/ecom/product/view-post");
			}else {
				response.getWriter().print("update error");
			}
		}	
	}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = (request.getPathInfo());
		if(ids.length()<2) {
			response.sendRedirect("/ecom/product/view-post");
			return;
		}
		int id;
		if(ids.lastIndexOf("/")!=0) {
			id  = Integer.parseInt(ids.substring(1,ids.indexOf("/",1)));
		}else {
			id  = Integer.parseInt(ids.substring(1));
		}
		DBDisplay ob = new DBDisplay("product");
		Product p = ob.displayOneProduct(id);
		DBDelete obd = new DBDelete(p);
		if(obd.deleteReport()) {
			response.sendRedirect("/ecom/product/view-post");
		}else {
			response.getWriter().print("deletion error");
		}
	}
}
