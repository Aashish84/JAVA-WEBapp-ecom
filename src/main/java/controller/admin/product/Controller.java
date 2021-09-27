package controller.admin.product;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet("/product/ctrl/*")
@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("/ecom/product/view-post");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Part filepart = request.getPart("file");
		String fn = filepart.getSubmittedFileName();
		
		String UPLOAD_DIR = "public/uploads";
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
		
		File fileSavePath = new File(uploadFilePath);
		if(!fileSavePath.exists()) {
			response.getWriter().print("no_file_directory");
			return;
		}
		
		filepart.write(uploadFilePath+File.separator+fn);
		response.getWriter().print("sucessful");
	}
}
