<%--
  Created by IntelliJ IDEA.
  User: kates
  Date: 4/22/24
  Time: 10:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Movies Application: Search</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">
    <div class="hero-unit">
        <%@ include file="includes/titleBar.jsp"%>
        <h1>Search</h1>
    </div>

    <%@ include file="includes/navigation.jsp"%>

    <div class="container">
        <form action="Search" method="get">
            <label for="title">Search by title:</label>
            <input type="text" name="title" id="title">
            <label for="director">Search by director (first name + last name):</label>
            <input type="text" name="director" id="director">
            <%--<label for="lengthInMinutes">Search by length (in minutes):</label>
            <input type="text" name="lengthInMinutes" id="lengthInMinutes">--%>
            <br>
            <input type="submit">
        </form>
    </div>

    <%@ include file="includes/footer.jsp"%>
</div>

</html>
