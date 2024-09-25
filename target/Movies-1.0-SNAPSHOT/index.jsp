<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="description" content="This is a servlet example that uses IO to output movies data from an excel spreadsheet to a web page."/>
    <title>Movies: Index</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
    <div class="container">
        <div class="hero-unit">
            <%@ include file="includes/titleBar.jsp"%>
            <h1>Welcome!</h1>
        </div>

        <%@ include file="includes/navigation.jsp"%>

        <div class="container">
            <p>On this web application, you can view some basic information about a few famous movies.
            I have enjoyed watching some of them, and I hope you have, too! </p>
            <br>
            <%--<p><a href="index2.jsp">broken link</a></p>--%>
        </div>

        <%@ include file="includes/footer.jsp"%>
    </div>
</body>
</html>