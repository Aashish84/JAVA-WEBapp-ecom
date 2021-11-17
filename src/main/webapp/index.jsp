<%@ include file="/inc/header.jsp" %>
       
		<%
        	DBDisplay obb = new DBDisplay("product"," WHERE created_at in (select max(created_at) from product)");
        	ArrayList<Product> bannerresult = obb.displayAllProduct();
        %>
		<div class="banner">
            <div class="row">
            	<%
            		Product bannerp = bannerresult.get(0);
            	%>
                <div class="col-7">
                    <h1 class="banner-tag">new arrivals</h1>
                    <div class="banner-desc">
                        <div class="product">
                            <div class="contents banner-contents">
                                <h1 class="title"><%=bannerp.getName() %></h1>
                                <h4 class="price">
                                <%
	                            	if(bannerp.getDiscount()!=0){
	                            		out.print("<span>Rs"+bannerp.getPrice()+"</span>");
	                            		double priceafterdis =(double)(bannerp.getPrice()-(bannerp.getDiscount()/100.0*bannerp.getPrice()));
	                            		out.print(" Rs "+priceafterdis);
	                            	}else{
	                            		out.print(" Rs "+bannerp.getPrice());
	                            	}
                            	%>
                                </h4>
                                <h3 class="addtocart purchase-btn">add to cart</h3><span style="display:none"><%=bannerp.getId() %></span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-5">
                    <div class="banner-image bg-image" style="background-image: url(/ecom/product/file/<%=bannerp.getImage()%>);"></div>
                </div>
            </div>
        </div>
        
        <%
        	DBDisplay ob = new DBDisplay("product","WHERE discount!=0");
        	ArrayList<Product> result = ob.displayAllProduct();
        %>
        <div class="container">
            <h1 class="title">Top offers</h1>
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
                            <h3 class="addtocart">add to cart</h3><span style="display:none"><%=p.getId() %></span>
                        </div>
                    </div>
                </div>
                <%
            		}
                %>
            </div>
        </div>
   <%@ include file="/inc/footer.jsp" %>