<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="databaseservice.crud.DBDisplay,pojo.Category,pojo.Product" %>
<%
	String ids = (request.getPathInfo());
	
	if(ids==null || ids.length()==1){
		response.sendRedirect("/ecom/category/view-post");
	}else{
		int id;
		if(ids.lastIndexOf("/")!=0) {
			id  = Integer.parseInt(ids.substring(1,ids.indexOf("/",1)));
		}else {
			id  = Integer.parseInt(ids.substring(1));
		}
		DBDisplay ob = new DBDisplay("product");
		Product p = ob.displayOneProduct(id);
%>

<%@ include file="/admin/inc/header.jsp" %>
	<div class = "col-6">
		<h2>update product</h2>
		<form action="/ecom/product/ctrl/<%=id %>/" method="post" enctype="multipart/form-data">
		 	<input type="hidden"  name="_method" value="PUT"/>
			<div class="form-group">
				<label for="title" >product name</label>
				<input type="text" id="title" class="form-control" name="newproductname" value="<%=p.getName() %>" placeholder="enter product name" />
			</div>
			
			<div class="from-group">
				<label for="dd">category :</label>
				<select class="form-control" name="newproductcategory" id="dd">
					<% 
						DBDisplay obj = new DBDisplay("category","where status = '1'");
						ArrayList<Category> result = obj.displayAllCategory();
						for (int i = 0 ; i < result.size() ; i++){
							Category c = result.get(i);
					%>
						<option value='<%=c.getId()%>' <%if(c.getId()==p.getCategory_id()){out.print("selected");} %> ><%=c.getName() %></option>
					<% } %>
				</select>
			</div>
			
			<div class="form-group">
				<br/>status:<br/>
				<input type="radio" name="newstatus" value="active" <% if(p.isStatus()){out.print("checked=checked"); } %> id="a"/>
				<label for="a">active</label>
				<input type="radio" name="newstatus" value="notactive" <% if(!p.isStatus()){out.print("checked=checked"); } %> id="b"/>
				<label for="b">not active</label>
			</div>
			
			<div class="form-group">
				<label>
					discount :
					<input class="form-control" type="number"  name="newdiscount" value="<%=p.getDiscount()%>" />
				</label>
			</div>
			
			<div class="form-group">
				<label>
					total inventory :
					<input class="form-control" type="number"  name="newinventory" value="<%=p.getInventory()%>" />
				</label>
			</div>
			<a href="/ecom/product/file/<%=p.getImage()%>" target="_blank" class="btn btn-primary">view image</a>
			<div class="form-group">
				<input type="file" name="newfile"/>
			</div>
			
			<input type="submit" value="update" />
		</form>
		<%} %>
	</div>
<%@ include file="/admin/inc/footer.jsp" %>