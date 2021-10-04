<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import ="pojo.Category,databaseservice.crud.DBDisplay" %>
<%@ page import ="controller.LoginCheck" %>

			<%@ include file="/admin/inc/header.jsp" %>
			
<%
	if(request.getParameter("val")!=null){
		out.println("<script>alert('update error category exist in product')</script>");
	}
	DBDisplay ob = new DBDisplay("category");
	ArrayList<Category> result = ob.displayAllCategory();
%>
			
			
			<div class="col-10" style="height:100vh;overflow-y:scroll;">
				<h1>post view here</h1>
				<h3><a href="/ecom/category/add-post" >add post</a></h3>
				<table border="1" class='card-body'>
					<tr class="text-center">
						<th>NO.</th>
						<th>name</th>
						<th>status</th>
						<th colspan="2">action</th>
					</tr>
					
					<%
							for(int i=0;i<result.size();i++){
							Category c = result.get(i);
					%>
					<tr>
					<%
							out.print("<td>"+(i+1)+"</td>");
							out.println("<td>"+c.getName()+"</td>");
							if(c.isStatus()){
								out.println("<td>active</td>");				
							}else{
								out.print("<td>not active</td>");
							}
					%>	
						<td>
							<form action="/ecom/category/ctrl/<% out.print(c.getId()); %>/" method="post">
								<input type="hidden" name="_method" value="PUT"/>
								<input type="submit" value="update" class="btn btn-warning"/>
							</form>	
						</td>	
						<td>		
							<form action="/ecom/category/ctrl/<% out.print(c.getId()); %>/" method="post" >
								<input type="hidden" name="_method" value="DELETE"/>
								<input type="submit" value="delete" onclick="javascript:return confirm('are you sure?');" class="btn btn-danger"/>
							</form>
						</td>
					</tr>
					<%		
						}
					%>
				</table>
			</div>
		
			<%@ include file="/admin/inc/footer.jsp" %>