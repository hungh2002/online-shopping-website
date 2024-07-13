<%@ page
	import="com.hungh2002.service.utils.jspUtils.JsonUtils
    , java.util.List
    , com.hungh2002.model.product.Product
	, com.hungh2002.config.environmentVariable.Env
    , jakarta.servlet.http.HttpSession
"%>

<!-- https://jakarta.ee/specifications/tags/3.0/jakarta-tags-spec-3.0#overview
         -> How to use Jakarta Standard Tag Library (JSTL)
    -->
    <%@ taglib prefix="c" uri="jakarta.tags.core"%>



		<div class="row row-cols-1 row-cols-md-1 g-4"	>
	<%
    	try {
            String customerId = (String) request.getSession().getAttribute("customer-id");
            List<Product> products = JsonUtils.<Product>Serialization(Env.BASE_URL+"/api/cart?customer-id=" + customerId);
            pageContext.setAttribute("products", products);
    	} catch (Exception e) {
        	System.out.println("ERROR: showMyCart.jsp" + e);
    	}
	%>
			<c:forEach var="item" items="${products}">
				<div class="col">
                    <div class="card mb-3">
                        <div class="row g-0">
                          <div class="col-md-1">
                            <img src="${item.product.image }" class="img-fluid rounded-start" alt="...">
                          </div>
                          <div class="col-md-8">
                            <div class="card-body">
                                <a href="/product?product-id=${ item.product.id }" class="card-title">${item.product.name}: ${item.product.price}$ ${item.product.quantity}</a>
                            </div>
                          </div>
                        </div>
                      </div>
				</div>
			</c:forEach>
		</div>