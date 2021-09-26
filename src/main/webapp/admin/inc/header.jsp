<%
	String adminEmail = (String)session.getAttribute("adminEmail");
	if(adminEmail==null){
		response.sendRedirect("/ecom/login");
		out.print(adminEmail);
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<title>ecom</title>
		
		<!-- Latest compiled and minified CSS -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
		
		<!-- jQuery library -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
		
		<!-- Popper JS -->
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
		
		<!-- Latest compiled JavaScript -->
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
		
	</head>
	<body>
		<div class="container-fluid">
		<div class="row">
			<div class="col-2 bg-dark" style="min-height:100vh;min-width:200px">
				<h2 class="text-light">welcome</h2>
				
				<ul class="nav flex-column">
					<li class="nav-item">
				    	<a class="nav-link" href="/ecom/category/ctrl" >category</a>
					</li>
				    <li class="nav-item">
				    	<a class="nav-link" href="/ecom/product/ctrl">product</a>
				    </li>
				   	<li class="nav-item">
				    	<a class="nav-link" href="#">Link</a>
				   	</li>
				    <li class="nav-item">
				      <a class="nav-link disabled" href="#">Disabled</a>
				    </li>
 				</ul>
				
			</div>
		
		