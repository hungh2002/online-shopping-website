<!-- https://jakarta.ee/specifications/tags/3.0/jakarta-tags-spec-3.0#overview
         -> How to use Jakarta Standard Tag Library (JSTL)
    -->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:choose>
	<c:when test="${sessionScope.username != null}">
		<li class="nav-item">
			<a class="nav-link" href="/auth">${sessionScope.username}</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="/cart">Cart</a>
		</li>
			<li class="nav-item">
			<button class="nav-link" id="sign-out-button">Sign out</button>
			</li>
	</c:when>
<c:otherwise>
		<li class="nav-item">
			<a class="nav-link" href="/auth?auth=sign-in">Sign in</a>
		</li>
	</c:otherwise>
</c:choose>

<script type="module"
		src="${pageContext.request.contextPath}/view/resources/js/SignOut.js"></script>