<%@ page
	import="com.hungh2002.service.utils.jspUtils.JsonUtils
    , java.util.List
    , com.hungh2002.model.product.Product
	, com.hungh2002.config.environmentVariable.Env
    , jakarta.servlet.http.HttpSession
"%>



		<div class="row row-cols-1 row-cols-md-1 g-4"	>
	<%
    	try {
            String customerId = (String) request.getSession().getAttribute("customer-id");
            List<Product> products = JsonUtils.<Product>Serialization(Env.BASE_URL+"/api/cart?customer-id=" + customerId);
            pageContext.setAttribute("products", products);
    	} catch (Exception e) {
        	System.out.println("ERROR: newReleases.jsp" + e);
    	}
	%>
			<c:forEach var="item" items="${products}">
				<div class="col">
                    <div class="card mb-3">
                        <div class="row g-0">
                          <div class="col-md-2">
                            <img src="${item.image }" class="img-fluid rounded-start" alt="...">
                          </div>
                          <div class="col-md-8">
                            <div class="card-body">
                                <a href="/product?product-id=${ item.id }" class="card-title">${item.name}: ${item.price}$ ${item.quantity}</a>
                            </div>
                          </div>
                        </div>
                      </div>
				</div>
			</c:forEach>
		</div>