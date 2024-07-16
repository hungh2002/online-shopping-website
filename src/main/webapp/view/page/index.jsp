<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- https://jakarta.ee/specifications/tags/3.0/jakarta-tags-spec-3.0#overview
         -> How to use Jakarta Standard Tag Library (JSTL)
    -->
<%@ taglib prefix="c" uri="jakarta.tags.core"%>


<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>HomePage</title>
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
		<%@ include file="../component/newReleases.jsp"%>
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
		src="${pageContext.request.contextPath}/view/resources/js/index.js"></script>
</body>

</html>
;
