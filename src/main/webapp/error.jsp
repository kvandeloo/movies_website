<%--
  Created by IntelliJ IDEA.
  User: kates
  Date: 4/2/24
  Time: 10:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Internal Server Error</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">
    <div class="hero-unit">
        <%@ include file="includes/titleBar.jsp"%>
        <h1>Internal Server Error</h1>
    </div>

    <%@ include file="includes/navigation.jsp"%>

    <div class="container">
        <h1>Whoops! There's been an error.</h1>
        <h2>Error Details:</h2>
        <p>Type: ${pageContext.exception["class"]}</p>
        <p>Message: ${pageContext.exception.stackTrace}</p>
        <p>Return to the <a href="index.jsp">home</a> page.</p>
    </div>

    <%@ include file="includes/footer.jsp"%>
</div>
</body>
</html>