package controller.order;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ordereditem/ctrl/*")
public class OrderedItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ids = (request.getPathInfo());
		int id = 0;
		if(ids==null || ids.length()==1) {
			response.sendRedirect("/ecom/order/ctrl");
			return;
		}else {
			if(ids.lastIndexOf("/")!=0) {
				id  = Integer.parseInt(ids.substring(1,ids.indexOf("/",1)));
			}else {
				id  = Integer.parseInt(ids.substring(1));
			}
		}		
		response.sendRedirect("/ecom/ordereditem/view-post/"+id);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
