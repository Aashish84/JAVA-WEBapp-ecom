<%@ include file="/inc/header.jsp" %>
<div class="container-cart">
	<div class="row col-center">
		<div class="col-8">		
			<form action="/ecom/product/CartManager" method="post" id="cartdetail">
            	<table>
            		<thead>
            			<tr>
            				<th></th>
            				<th>product</th>
            				<th>price</th>
            				<th>quantity</th>
            				<th>sub total</th>
            			</tr>
            		</thead>
            		<tbody>
            		<%  
            			int count=0;
            			CartList ob = CartList.getInstance();
            			ArrayList<int []> list = ob.getList();
            			//System.out.println(list.size());
            			for(int i[] : list){
            				DBDisplay obp = new DBDisplay("product");
            				Product p = obp.displayOneProduct(i[0]);
            				count ++;
            		%>
            			<tr>
            				<td>
            					<div class="icon cross carticon" id="<%=count%>">
				                    <div id="b-1" class="bar x"></div>
				                    <div id="b-2" class="bar y"></div>
				                </div>
            				</td>
            				
            					
            				
            				<td><%=p.getName() %></td>
            				<td><%=p.getPrice()-(p.getDiscount()*(p.getPrice()/100)) %></td>
            				<td><input id="idqty<%=count %>" type="number" size="2" name="<%=p.getId()%>" value="<%=i[1]%>"/></td>
            				<td class="subtotal"><%=(p.getPrice()-(p.getDiscount()*(p.getPrice()/100)))*i[1] %></td>
            			</tr>
            		<%
            			}
            		%>		
            			<tr>
            				<td colspan="3"></td>
            				<td>total</td>
            				<td id="total">
            					
            				</td>
            			</tr>
            			<tr>
            				<td colspan="4">click on update if quantity is changed</td>
            				<td>
            					<input type="hidden" name="_method" value="PUT"/>
            					<input type="submit" value="update"/>
            				</td>
            			</tr>
            		</tbody>
            	</table>
            </form>
            <hr/>
            <h2>checkout details</h2>
            <div class="consumer-detail">
	            <form action="customer/ctrl" method="post">
	            	<table>
	            		<tr>
	            			<td>name<span style="color:red">*</span></td>
	            			<td><input type="text" name="customername" required/></td>
	            		</tr>
	            		<tr>
	            			<td>contact<span style="color:red">*</span></td>
	            			<td><input type="number" name="customernumber" required/></td>
	            		</tr>
	            		<tr>
	            			<td>email<span style="color:red">*</span></td>
	            			<td><input type="email" name="customeremail" required/></td>
	            		</tr>
	            		<tr>
	            			<td>address<span style="color:red">*</span></td>
	            			<td><input type="text" name="customeraddress" required/></td>
	            		</tr>
	            		<tr>
	            			<td></td>
	            			<td><input type="submit" value="placeorder"/></td>
	            		</tr>
	            		<tr>
	            			<td colspan="2">we will reach you through your email and contact provided</td>
	            		</tr>
	            		
	            	</table>
	            </form>
			</div>
		</div>
	</div>
</div>
<%@ include file="/inc/footer.jsp" %>