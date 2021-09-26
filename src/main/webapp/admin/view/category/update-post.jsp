<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="databaseservice.crud.DBDisplay,pojo.Category" %>
<% 
	String i = (request.getPathInfo());
	
	if(i==null || i.length()==1){
		response.sendRedirect("/ecom/category/view-post");
	}else{
		int id;
		if(i.lastIndexOf("/")!=0) {
			id  = Integer.parseInt(i.substring(1,i.indexOf("/",1)));
		}else {
			id  = Integer.parseInt(i.substring(1));
		}
		DBDisplay ob = new DBDisplay("category");
		Category c = ob.displayOneCategory(id);
%>
	<%@ include file="/admin/inc/header.jsp" %>
	<div class="col-6">
		<h2>category update</h2>
		
	<%
		if(c==null){
			out.println("not found");
		}else{
	%>
	
		<form action="/ecom/category/ctrl/<% out.print(id); %>" method="post">
			<input type="hidden"  name="_method" value="PUT"/>	
			<div class="form-group">
				<label for="title">category name:</label>
				<input type="text" id="title" class="form-control" name="newname" value="<% out.println(c.getName()); %>"/>
			</div>
			<div class="from-group">
				<input type="radio" name="newstatus" id="a" value="active" <% if(c.isStatus()){out.print("checked=checked"); } %>/>
				<label for="a">active:</label>
				<input type="radio" name="newstatus" id="na" value="notactive" <% if(!c.isStatus()){out.print("checked=checked"); } %> />
				<label for="na">InActive</label>
			</div>
			
			<input type="submit" value="submit" class="btn btn-primary"/>
		</form>
		
	<% 	} %>
	
	<hr/>
	
	<h1><% out.print(id); }%></h1>
	
	</div>
	
	<%@ include file="/admin/inc/footer.jsp" %>