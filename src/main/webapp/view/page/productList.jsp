<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page
	import="com.hungh2002.service.utils.jspUtils.JsonUtils
    , java.util.List
    , com.hungh2002.model.product.Product
"%>

<!-- https://jakarta.ee/specifications/tags/3.0/jakarta-tags-spec-3.0#overview
         -> How to use Jakarta Standard Tag Library (JSTL)
    -->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Show list products</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath}/view/resources/css/style.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>

<body>
	<header class="container-fluid">
		<%@ include file="../component/header.jsp"%>
	</header>

	<section class="container">


			<div class="row row-cols-1 row-cols-md-5 g-4"	>
		<%
			try {
				List<Product> products = JsonUtils.<Product>Serialization("http://localhost:8080/api/product?order-by=create_at-desc");
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


	</section>

	<footer class="container-fluid">
		<%@ include file="../component/footer.jsp"%>
	</footer>

	<!-- include js -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
	<script src="https://kit.fontawesome.com/c069b593b7.js"
		crossorigin="anonymous"></script>
	<script type="module"
		src="${pageContext.request.contextPath}/view/resources/js/listProducts.js"></script>
</body>

</html>