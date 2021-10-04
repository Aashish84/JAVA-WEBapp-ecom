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
		
		<link rel="stylesheet" href="http://localhost:8080/ecom/assets/css/bootstrap.css">
		
		
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
		
		