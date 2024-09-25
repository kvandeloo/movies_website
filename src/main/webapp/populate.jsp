<%--
  Created by IntelliJ IDEA.
  User: kates
  Date: 4/20/24
  Time: 10:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movies Application: Populate DB</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">
    <div class="hero-unit">
        <%@ include file="includes/titleBar.jsp"%>
        <h1>Populate the Database</h1>
    </div>
    <%@ include file="includes/navigation.jsp"%>

    <p>WARNING: This action will over-write the existing database.</p>
    <div class="container">
        <form action="Populate" method="post">
            <input type="submit" value="Populate DB">
        </form>
        <p>${message}</p>
    </div>

    <%@ include file="includes/footer.jsp"%>
</div>
</body>
</html>
