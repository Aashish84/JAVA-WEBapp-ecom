package controller.customer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.product.CartList;
import databaseservice.crud.DBAddpost;
import pojo.Customer;

@WebServlet("/customer/ctrl/*")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.getWriter().print("hellow");
		}

	   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   String name = request.getParameter("customername");
		   double number = Double.parseDouble(request.getParameter("customernumber"));
		   String email = request.getParameter("customeremail");
		   String address = request.getParameter("customeraddress");
		   if(name ==null || email==null || request.getParameter("customernumber")==null || address==null || CartList.getInstance().getList().size()==0) {
			   response.sendRedirect("/ecom/cart");
			   return;
		   }else {
			   Customer cs = new Customer(name,number,email,address);
			   
			   DBAddpost ob = new DBAddpost(cs);
			   if(ob.addReport()) {
				   CartList.getInstance().getList().clear();
				   response.getWriter().print("you will be reached by through contact provided");
			   }
		   }
	   }
}
