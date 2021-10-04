<%@ include file="/inc/header.jsp" %>

	<%
		String ids = request.getPathInfo();
		int id;
		if(ids.lastIndexOf("/")!=0) {
			id  = Integer.parseInt(ids.substring(1,ids.indexOf("/",1)));
		}else {
			id  = Integer.parseInt(ids.substring(1));
		}
        DBDisplay ob = new DBDisplay("product","where status=true and category_id="+id);
        ArrayList<Product> result = ob.displayAllProduct();
        DBDisplay obtest = new DBDisplay("category");
        Category c = obtest.displayOneCategory(id);
    %>
	<div class="container">
            <h1 class="title"><%=c.getName() %></h1>
            <div class="row">
            	<%
            		for (int i =0;i<result.size();i++){
            			Product p = result.get(i);
            	%>
                <div class="col-3">
                    <div class="product">
                        <div class="product-image bg-image" style="background-image: url(/ecom/product/file/<%=p.getImage()%>);"></div>
                        <div class="contents">
                            <h2><%=p.getName() %></h2>
                            <h4>
                            <%
                            	if(p.getDiscount()!=0){
                            		out.print("<span>Rs"+p.getPrice()+"</span>");
                            		double priceafterdis =(double)(p.getPrice()-(p.getDiscount()/100.0*p.getPrice()));
                            		out.print(" Rs "+priceafterdis);
                            	}else{
                            		out.print(" Rs "+p.getPrice());
                            	}
                            %>
                            </h4>
                            <h3 class="addtocart" onclick="cartadd()">add to cart</h3>
                            <script type="text/javascript">
	                            function cartadd(){
	                            	 xhr= new XMLHttpRequest();
	                                    xhr.onreadystatechange = function (){
	                                        if (this.readyState == 4 && this.status == 200){
	                                        	alert("added");
	                                        }
	                                    };
	                                    xhr.open('post',"/ecom/product/CartManager",true);
	                                    xhr.send("productid="+<%=p.getId() %>);
	                            }
                            </script>
                        </div>
                    </div>
                </div>
                <%
            		}
                %>
            </div>
        </div>

<%@ include file="/inc/footer.jsp" %>