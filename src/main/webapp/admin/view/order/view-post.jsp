<%@ include file="/admin/inc/header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.Customer,databaseservice.crud.DBDisplay" %>
	
	<%
		String ids = (request.getPathInfo());
		String status;
		if(ids ==null){
			status = "where status=false";
		}else if(ids.equalsIgnoreCase("/all")){
			status="";
		}else{
			status="where status=true";
		}
		DBDisplay ob = new DBDisplay("customer",status);
		ArrayList<Customer> result = ob.displayAllCustomer();
	%>
	<div class="col-10">	
		<h1>order view</h1>
				<table border="1" class='card-body'>
					<tr class="text-center">
						<th>NO.</th>
						<th>name</th>
						<th>status</th>
						<th colspan="2">action</th>
					</tr>
					
					<%
							for(int i=0;i<result.size();i++){
							Customer cs = result.get(i);
					%>
					<tr>
					<%
							out.print("<td>"+(i+1)+"</td>");
							out.println("<td>"+cs.getName()+"</td>");
							if(cs.isStatus()){
								out.println("<td>complete</td>");				
							}else{
								out.print("<td>on process</td>");
							}
					%>	
						<td>
							<form action="/ecom/ordereditem/ctrl/<%=cs.getId() %>" method="get">
								<input type="submit" value="view" class="btn btn-primary"/>
							</form>
						</td>	
						<td>
							<form action="/ecom/order/ctrl/<%=cs.getId() %>" method="post">
								<input type="submit" <%if(cs.isStatus()){out.println("style='display:none'");} %> onclick="javascript:return confirm('are you sure?');" value="complete" class="btn btn-warning"/>		
							</form>
						</td>
					</tr>
					<%		
						}
					%>
				</table>
	</div>
<%@ include file="/admin/inc/footer.jsp" %>