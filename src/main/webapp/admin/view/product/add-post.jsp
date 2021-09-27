<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.ArrayList" %>
 <%@ page import="pojo.Category,databaseservice.crud.DBDisplay" %>
<!DOCTYPE html>
<%@ include file="/admin/inc/header.jsp" %>
	<div class = "col-6">
		<h2>add new product</h2>
		<form action="/ecom/product/ctrl" method="post" enctype="multipart/form-data">
		 
			<div class="form-group">
				<label for="title" >product name</label>
				<input type="text" id="title" class="form-control" name="productname" placeholder="enter product name" />
			</div>
			<div class="from-group">
				<label for="dd">category :</label>
				<select class="form-control" name="productcategory" id="dd">
					<% 
						DBDisplay ob = new DBDisplay("category","where status = '1'");
						ArrayList<Category> result = ob.displayAllCategory();
						for (int i = 0 ; i < result.size() ; i++){
							Category c = result.get(i);
					%>
						<option value='<%=c.getId()%>'><%=c.getName() %></option>
					<% } %>
				</select>
			</div>
			<div class="form-group">
				<br/>status:<br/>
				<input type="radio" name="status" value="active" checked=checked id="a"/>
				<label for="a">active</label>
				<input type="radio" name="status" value="notactive" id="b"/>
				<label for="b">not active</label>
			</div>
			<div class="form-group">
				<label>
					discount :
					<input class="form-control" type="number"  name="discount" />
				</label>
			</div>
			<div class="form-group">
				<label>
					total inventory :
					<input class="form-control" type="number"  name="inventory" />
				</label>
			</div>
			<div class="form-group">
				<input type="file" name="file"/>
			</div>
			<input type="submit" value="insert" />
		</form>
	</div>
<%@ include file="/admin/inc/footer.jsp"%>