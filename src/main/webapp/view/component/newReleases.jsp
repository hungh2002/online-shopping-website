<%@ page
	import="com.hungh2002.service.utils.jspUtils.JsonUtils
    , java.util.List
    , com.hungh2002.model.product.Product
	, com.hungh2002.config.environmentVariable.Env
"%>


<div class="row">
	<div class="d-flex justify-content-between">
		<h2>NEW RELEASES</h2>

		<a href="/productList" class="btn btn-link">GO TO SHOP</a>
	</div>
	<div>
		<div class="row row-cols-1 row-cols-md-5 g-4"	>
	<%
    	try {
            List<Product> products = JsonUtils.<Product>Serialization(Env.BASE_URL+"/api/product?limit=5&order-by=create_at-desc");
            pageContext.setAttribute("products", products);
    	} catch (Exception e) {
        	System.out.println("ERROR: newReleases.jsp" + e);
    	}
	%>
			<c:forEach var="item" items="${products}">
				<div class="col">
					<div class="card h-100 card-size">
						<img src="${item.image }" class="card-img-top" alt="...">
						<div class="card-body">
							<a href="/product?product-id=${ item.id }" class="card-title">${item.name}(${item.price}$)</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>