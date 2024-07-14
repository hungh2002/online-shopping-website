<c:if test="${sessionScope.username != null}">
    <form class="add-product-to-cart" method="post">
        <input type="hidden" name="product-id" value="${products[0].productId}">
        <input type="hidden" name="customer-id" value="${sessionScope.customerId}">
        <input type="hidden" name="quantity" value="1">
        <button type="submit">Add to Cart</button>
    </form>
</c:if>

<script type="module"
		src="${pageContext.request.contextPath}/view/resources/js/Cart.js"></script>
