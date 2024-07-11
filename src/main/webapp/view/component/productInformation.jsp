<%@ page
	import="com.hungh2002.service.utils.jspUtils.JsonUtils
    , java.util.List
    , com.hungh2002.model.product.Product
	,com.hungh2002.config.environmentVariable.Env
"%>

<!-- https://jakarta.ee/specifications/tags/3.0/jakarta-tags-spec-3.0#overview
         -> How to use Jakarta Standard Tag Library (JSTL)
    -->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<div class="row">
	<div class="row row-cols-1 row-cols-md-3 g-4" id="product-information">
		<%
			try {
				String productId = request.getParameter("product-id");
				List<Product> products = JsonUtils.<Product>Serialization(Env.BASE_URL + "/api/product?product-id=" + productId);
				pageContext.setAttribute("products", products);
			} catch (Exception e) {
				System.out.println("ERROR: productList.jsp" + e);
			}
		%>

				<c:forEach var="item" items="${products}">
					<div class="col">
						<a href="/product?product-id=${ item.id }" class="card h-100 card-size">
						  <img src=${ item.image } class="card-img-top" alt="...">
						  <div class="card-body">
							<h5 class="card-title"> ${ item.name } (${ item.price }$) </h5>
						  </div>
						</a>
					  </div>
				</c:forEach>
	</div>
</div>