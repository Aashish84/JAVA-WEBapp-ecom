<%@ include file="/inc/header.jsp" %>
       

        <div class="banner">
            <div class="row">
                <div class="col-7">
                    <div class="demo"></div>
                </div>
            </div>
        </div>
        <%
        	DBDisplay ob = new DBDisplay("product","where status=true");
        	ArrayList<Product> result = ob.displayAllProduct();
        %>
        <div class="container">
            <h1 class="title">products</h1>
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
                            <h3 class="addtocart">add to cart</h3>
                        </div>
                    </div>
                </div>
                <%
            		}
                %>
            </div>
        </div>
   <%@ include file="/inc/footer.jsp" %>