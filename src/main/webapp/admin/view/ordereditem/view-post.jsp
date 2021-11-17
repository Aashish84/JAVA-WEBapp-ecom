<%@ include file="/admin/inc/header.jsp" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.Ordereditem,pojo.Product,pojo.Customer,databaseservice.crud.DBDisplay" %>
	<%
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
	%>
	
		<div class="col-8">
			<h1>ordered item view<%= " "+id %></h1>
				
				<%
					Customer cs =  new Customer(id);
					DBDisplay obcs = new DBDisplay("Customer","where id="+id);
					ArrayList<Customer> res = obcs.displayAllCustomer();
					cs =  res.get(0);
				%>
					<table border="1" class='card-body'>
						<tr>
							<td colspan="2" style="text-align:center;"><b>Customer details</b></td>
						</tr>
						<tr class="text-center">
							<td>customer name :</td>
							<td><%=cs.getName() %></td>
						</tr>
						<tr class="text-center">
							<td>customer email :</td>
							<td><%=cs.getEmail() %></td>
						</tr>
						<tr class="text-center">
							<td>contact no :</td>
							<td><%=cs.getContact() %></td>
						</tr>
						<tr class="text-center">
							<td>status :</td>
							<td><%if(cs.isStatus()){out.print("complete");}else{out.print("on process");} %></td>
						</tr>
					</table>
					<hr/>
				<%
					DBDisplay ob = new DBDisplay("ordereditem");
					ArrayList<Ordereditem> result = ob.displayProductOfCustomer(cs);
					if(result.size()==0){
						response.sendRedirect("/ecom/order/ctrl");
						return;
					}
				%>
				<table border="1" class='card-body'>
					<tr class="text-center">
						<th>NO.</th>
						<th>product</th>
						<th>quantity</th>
					</tr>
					
					<%
							for(int i=0;i<result.size();i++){
								Ordereditem oi = result.get(i);
					%>
					<tr>
						<td><%=(i+1) %></td>
					<%
							DBDisplay obp = new DBDisplay("product");
							Product p = obp.displayOneProduct(oi.getProduct_id());
							
					%>	
						<td><%=p.getName() %></td>
						<td><%=oi.getQuantity() %></td>
					</tr>
					<%		
						}
					%>
					<tr>
						<td>
							<form action="/ecom/order/ctrl/<%=cs.getId() %>" method="post">
								<input type="submit" <%if(cs.isStatus()){out.println("style='display:none'");} %> onclick="javascript:return confirm('are you sure?');" value="complete" class="btn btn-warning"/>		
							</form>
						</td>
					</tr>
				</table>
		</div>
<%@ include file="/admin/inc/footer.jsp" %>