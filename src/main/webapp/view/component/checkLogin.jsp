<c:if test="${cookie.rememberMe.value == 'true'}">
    <span id="check-login"></span>
    <script type="module"
        src="${pageContext.request.contextPath}/view/resources/js/checkLogin.js"></script>
</c:if>
<c:choose>
    <c:when test="${sessionScope.username != null}">
        <a class="nav-link" href="#">${sessionScope.username}</a>
        <a class="nav-link"
            href="${pageContext.request.contextPath}/api/customer?auth=sign-out">Sign
            out</a>
    </c:when>
    <c:otherwise>
        <a class="nav-link" href="/auth">Sign in</a>
    </c:otherwise>
</c:choose>