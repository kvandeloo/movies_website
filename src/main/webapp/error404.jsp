<%--
  Created by IntelliJ IDEA.
  User: kates
  Date: 4/2/24
  Time: 10:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error 404 - Resource not found</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">
    <div class="hero-unit">
        <%@ include file="includes/titleBar.jsp"%>
        <h1>Page Not Found</h1>
    </div>

    <%@ include file="includes/navigation.jsp"%>

    <div class="container">
        <h2>The page you're looking for could not be found.</h2>
        <p>Return to the <a href="index.jsp">home</a> page.</p>
    </div>

    <%@ include file="includes/footer.jsp"%>
</div>
</body>
</html>
