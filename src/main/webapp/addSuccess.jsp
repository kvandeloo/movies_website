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
    <title>Movie Added</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">
    <div class="hero-unit">
        <%@ include file="includes/titleBar.jsp"%>
        <h1>Success!</h1>
    </div>

    <%@ include file="includes/navigation.jsp"%>

    <div class="container">
        <h2>Your movie was added to the database.</h2>
        <p>View it in the <a href="ViewAll">list</a> or <a href="add-movie.jsp">add another movie</a>.</p>
    </div>

    <%@ include file="includes/footer.jsp"%>
</div>
</body>
</html>
