<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
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
		<div class="login-form p-4 mx-auto shadow" style="width:500px;transform: translate(0%, 80%);">
            <h1 class="text-center">login</h1>
            <form action="/ecom/loginctrl" method="POST">
            	<div class="form-group">
                <input type="text" class="form-control" name="email" placeholder="enter email">
                </div>
                <div class="form-group">
                <input type="password" class="form-control" name="password" placeholder="enter password">
                </div>
                <hr/>
                <input type="submit" class="btn btn-primary mx-auto">
            </form>
        </div>
	</body>
</html>