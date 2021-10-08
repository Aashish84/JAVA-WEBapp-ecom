package controller.product;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/product/file/*")
public class ImageFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ServletContext cntx= request.getServletContext();
////	       Get the absolute path of the image
//	      String filename = cntx.getRealPath("\\files\\deer.jpg");
////	       retrieve mimeType dynamically
//	      String mime = cntx.getMimeType(filename);
//	      response.getWriter().print(mime);
//	      if (mime == null) {
//	        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//	        return;
//	      }
//
//	      response.setContentType(mime);
//	      File file = new File(filename);
		
	      String image = request.getPathInfo().replaceAll("/","");
	      
	      File file = new File("D:\\\\5th sem\\\\java_ii\\\\project\\\\src\\\\main\\\\webapp\\\\files\\"+image);
	      response.setContentType("image/jpg");
	      response.setContentLength((int)file.length());
	      
	      FileInputStream in = new FileInputStream(file);
	      OutputStream out = response.getOutputStream();
	      
	      // Copy the contents of the file to the output stream
	       byte[] buf = new byte[(int)file.length()];
	       int count = 0;
	       while ((count = in.read(buf)) >= 0) {
	         out.write(buf, 0, count);
	      }
	    out.close();
	    in.close();
	}

}
