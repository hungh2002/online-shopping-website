<!-- https://jakarta.ee/specifications/tags/3.0/jakarta-tags-spec-3.0#overview
         -> How to use Jakarta Standard Tag Library (JSTL)
    -->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<c:choose>
	<c:when test="${sessionScope.username != null}">
		<li class="nav-item">
			<a class="nav-link" href="#">${sessionScope.username}</a>
		</li>
			<li class="nav-item">
			<a class="nav-link"
				href="${pageContext.request.contextPath}/api/customer?auth=sign-out">Sign
				out</a>
			</li>
	</c:when>
<c:otherwise>
		<li class="nav-item">
			<a class="nav-link" href="/signIn">Sign in</a>
		</li>
	</c:otherwise>
</c:choose>