<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.Product,pojo.Category,databaseservice.crud.DBDisplay"%>

<%@ include file="/admin/inc/header.jsp" %>
<%
	DBDisplay ob = new DBDisplay("product");
	ArrayList<Product> result = ob.displayAllProduct();	
%>
		<div class="col-10">
			<h1>product List</h1>	
			<h3><a href="/ecom/product/add-post">add-post</a></h3>	
			<table border="1">
				<tr class="text-center">
					<th class="p-1">sn</th>
					<th class="p-1">name</th>
					<th class="p-1">category</th>
					<th class="p-1">status</th>
					<th class="p-1">discount</th>
					<th class="p-1">remaningQty</th>
					<th colspan="2" class="p-1">action</th>
				</tr>
				<% 
					for(int i = 0 ; i<result.size() ;i++){ 
						Product p = result.get(i);
				%>
					<tr class="text-center">
						<td><%=(i+1) %></td>
						<td><%=p.getName() %></td>
						<td>
							<% 
								ob.setTable("category");
								Category c = ob.displayOneCategory(p.getCategory_id());
								out.print(c.getName());
								c=null;
							%>
						</td>
						<td>
							<%
								if(p.isStatus()){
									out.println("active");				
								}else{
									out.print("not active");
								}
							%>	
						</td>
						<td><%=p.getDiscount() %></td>
						<td><%=p.getQuantity_left() %></td>	
						<td>update</td>
						<td>delete</td>
					</tr>
				<%
					}
				%>
			</table>	
		</div>
<%@ include file="/admin/inc/footer.jsp" %>