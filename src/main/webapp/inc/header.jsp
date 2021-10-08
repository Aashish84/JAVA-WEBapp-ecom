<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="pojo.Product,pojo.Category,databaseservice.crud.DBDisplay,controller.product.CartList"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Document</title>
    <link rel="stylesheet" href="/ecom/assets/css/style.css">
    <link rel="stylesheet" href="/ecom/assets/css/header.css">
    <link rel="stylesheet" href="/ecom/assets/css/cart.css">
    <link rel="stylesheet" href="/ecom/assets/css/banner.css">
    <link rel="stylesheet" href="/ecom/assets/css/grid.css">
    <link rel="stylesheet" href="/ecom/assets/css/product.css">
    <script defer src="/ecom/assets/js/header.js"></script>
    <script defer src="/ecom/assets/js/cart.js"></script>
</head>
<body>
    <div class="wrapper"></div>
    	 <div class="header">
            <div class="header-link-section">        
                <div class="nav">
                    <div class="icon">
                        <div id="b-1" class="bar"></div>
                        <div id="b-2" class="bar"></div>
                        <div id="b-3" class="bar"></div>
                    </div>
                    <div class="nav-links">
                        <div class="nav-link-first">
                            <ol>
                                <li id="xyz">catagory</li>
                                <a href="#"><li>new&nbsp;arrivals</li></a>
                                <a href="#"><li>about&nbsp;us</li></a>
                            </ol>
                            <div class="nav-links-second" id="category-links">
                                <ol>
                                	<%
                                		DBDisplay obc = new DBDisplay("category","where status=true");
                                		ArrayList<Category> res = obc.displayAllCategory();
                                		for (int i=0 ; i<res.size();i++){
                                			Category c = res.get(i);
                                	%>
                                		<a href="/ecom/product/<%=c.getId() %>/"><li><%=c.getName() %></li></a>
                                	<%
                                			
                                		}
                                	%>
                                </ol>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="logo">
                    <h1><a href="/ecom" >xyz store</a></h1>
                </div>
            </div>

            <div class="header-link-section">
                <div class="other-section">
                    <a href="/ecom/cart"><h2 id="cart">cart</h2></a>
                </div>
            </div>
            
        </div>
