<%--
  Created by IntelliJ IDEA.
  User: kates
  Date: 4/22/24
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java Web Programming: Add A New Movie</title>
    <%@ include file="includes/header.jsp"%>
</head>
<body>
<div class="container">
    <div class="hero-unit">
        <%@ include file="includes/titleBar.jsp"%>
        <h1>Add A New Movie</h1>
    </div>

    <%@ include file="includes/navigation.jsp"%>

    <p>${message}</p>
    <div class="container">
        <form action="AddNewMovie" method="post">
            <label for="title">Title:</label>
            <input type="text" name="title" id="title">
            <label for="director">Director (First Name + Last Name):</label>
            <input type="text" name="director" id="director">
            <label for="lengthInMinutes">Length (in minutes):</label>
            <input type="text" name="lengthInMinutes" id="lengthInMinutes">
            <br>
            <input type="submit">
        </form>
    </div>

    <%@ include file="includes/footer.jsp"%>
</div>
</body>
</html>
