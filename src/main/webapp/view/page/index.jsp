<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>

    <%-- https://jakarta.ee/specifications/tags/3.0/tagdocs/index.html --> How
        to use Jakarta Standard Tag Library (JSTL)
        --%>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>


            <!DOCTYPE html>
            <html lang="en">

                <head>
                    <title>HomePage</title>
                    <meta charset="UTF-8">
                    <meta name="viewport"
                        content="width=device-width, initial-scale=1.0">
                    <%-- inclue css --%>
                        <%@ include file="../component/cssLink.jsp" %>
                </head>

                <body>
                    <header class="container-fluid">
                        <%@ include file="../component/header.jsp" %>
                    </header>

                    <section class="container">
                        <%@ include file="../component/newReleases.jsp" %>
                    </section>

                    <header class="container-fluid">
                        <%@ include file="../component/footer.jsp" %>
                    </header>

                    <%-- inclue jsp --%>
                        <%@ include file="../component/jsLink.jsp" %>

                </body>

            </html>