package controller.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/product/CartManager/*")
public class CartManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if(request.getParameter("_method")!=null && request.getParameter("_method").equals("PUT")) {
			doPut(request,response);
		}else {
			String ids = (request.getPathInfo());
			
			int id = 0;
			if(ids.length()<=1) {
				response.sendError(HttpServletResponse.SC_CONFLICT);
				return;
			}else {
				if(ids.lastIndexOf("/")!=0) {
					id  = Integer.parseInt(ids.substring(1,ids.indexOf("/",1)));
				}else {
					id  = Integer.parseInt(ids.substring(1));
				}
			}
			CartList ob = CartList.getInstance();
			ob.cartListAdd(id);
		}
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 Enumeration<String> enumeration = request.getParameterNames();
		    while (enumeration.hasMoreElements()) {
		        String parameterName = (String) enumeration.nextElement();
		        
		        if(!parameterName.equals("_method")) {
		        	
		        	//form name and value id as name quantity as value
		        	int inputlist[] = {Integer.parseInt(parameterName) ,Integer.parseInt(request.getParameter(parameterName))}; 
		        	
		        	CartList ob = CartList.getInstance();
		        	ArrayList<int []> list =ob.getList();
		        	
		        	for(int i = 0 ; i<list.size();i++) {
		        		
		        		int item[] = list.get(i);
		        		
		        		//0 index has id of product 1 has quantity 
		        		//comparing int array item of arraylist and of user form input
		        		
		        		if(item[0]==inputlist[0] && inputlist[1]<=0) {
		        			list.remove(i);
		        		}else if(item[0]==inputlist[0]) {
		        			list.set(i, inputlist);
		        		}
		        	}
		        	
		        	ob.setList(list);
		        }
		    }
		    response.sendRedirect("/ecom/cart");
	}
}
