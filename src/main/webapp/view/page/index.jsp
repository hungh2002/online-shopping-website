<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
    https://jakarta.ee/specifications/tags/3.0/tagdocs/index.html
    --> How to use Jakarta Standard Tag Library (JSTL)
 --%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title></title>
</head>
<body>

    <%-- inclue header component --%>
	<%@ include file="../component/header.jsp" %>

	<div id= "container">
    <%-- test --%>
    <c:set var="hello" value="Hello World" />
    <h2> <c:out value="${hello}" /> </h2>
    </div>

    <%-- inclue footer component --%>
    <%@ include file="../component/footer.jsp" %>
</body>
</html>