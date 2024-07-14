<%@ page
	import="com.hungh2002.service.utils.jspUtils.JsonUtils
    , java.util.List
    , com.hungh2002.model.cart.Cart
	, com.hungh2002.config.environmentVariable.Env
    , jakarta.servlet.http.HttpSession
"%>

		<div class="row row-cols-1 row-cols-md-1 g-4"	>
	<%
    	try {
            long customerId = (long) request.getSession().getAttribute("customerId");
            List<Cart> cart = JsonUtils.<Cart>Serialization(Env.BASE_URL + "/api/cart?customer-id=" + customerId);
            pageContext.setAttribute("cart", cart);
    	} catch (Exception e) {
        	System.out.println("ERROR: showMyCart.jsp" + e);
    	}
	%>
			<c:forEach var="item" items="${cart}">
				<div class="col">
                    <div class="card mb-3">
                        <div class="row g-0">
                          <div class="col-md-1">
                            <a href="/product?product-id=${ item.product.productId }">
                             <img src="${item.product.image }" class="img-fluid rounded-start" alt="${item.product.name }">
                            </a>
                          </div>
                          <div class="col-md-8">
                            <div class="card-body">
                              <a href="/product?product-id=${ item.product.productId }">
                                <div class="card-title">${item.product.name}: ${item.product.price}$ ${item.product.quantity}</div>
                              </a>
                                <form class="add-product-to-cart" method="post">
                                  <input type="hidden" name="product-id" value="${item.product.productId}">
                                  <input type="hidden" name="customer-id" value="${sessionScope.customerId}">
                                  <input type="hidden" name="quantity" value="1">
                                  <button type="submit">+</button>
                              </form>
                                ${item.product.productId}
                              <form class="add-product-to-cart" method="post">
                                  <input type="hidden" name="product-id" value="${item.product.productId}">
                                  <input type="hidden" name="customer-id" value="${sessionScope.customerId}">
                                  <input type="hidden" name="quantity" value="-1">
                                  <button type="submit">-</button>
                              </form>
                              </div>
                          </div>
                        </div>
                      </div>
				</div>
			</c:forEach>
		</div>

    <script type="module"
		src="${pageContext.request.contextPath}/view/resources/js/Cart.js"></script>