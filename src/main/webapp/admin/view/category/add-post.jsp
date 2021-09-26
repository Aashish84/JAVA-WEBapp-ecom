<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/admin/inc/header.jsp" %>
	<div class="col-6">			
		<h2>Add new content</h2>
		<form action="/ecom/category/ctrl" method="post">
			<div class="form-group">
				<label for="title">category name:</label>
				<input type="text" id="title" class="form-control" name="categoryname" placeholder="enter new category"/>
			</div>
			<div class="from-group">
				<input type="radio" name="status" id="a" value="active" checked=checked/>
				<label for="a">active:</label>
				<input type="radio" name="status" id="na" value="notactive"/>
				<label for="na">InActive</label>
			</div>
			
			<input type="submit" value="submit" class="btn btn-primary"/>
		</form>
	</div>
<%@ include file="../../inc/footer.jsp" %>