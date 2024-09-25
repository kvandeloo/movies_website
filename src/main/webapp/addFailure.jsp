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
    <title>Movie Not Added</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">
    <div class="hero-unit">
        <%@ include file="includes/titleBar.jsp"%>
        <h1>Movie Not Added!</h1>
    </div>

    <%@ include file="includes/navigation.jsp"%>

    <div class="container">
        <h2>Your movie could not be added to the database.</h2>
        <p>${message}</p>
        <p><a href="add-movie.jsp">Try again</a> or view the <a href="ViewAll">movies list</a>.</p>

    </div>

    <%@ include file="includes/footer.jsp"%>
</div>
</body>
</html>
