<%--
  Created by IntelliJ IDEA.
  User: kates
  Date: 4/9/24
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Movies List</title>
    <%@include file="includes/header.jsp"%>
</head>
<body>
    <div class="container">
        <div class="hero-unit">
            <%@ include file="includes/titleBar.jsp"%>
            <h1>Movies List</h1>
        </div>

        <%@include file="includes/navigation.jsp"%>

        <div class="container">
            <c:choose>
                <c:when test="${empty movies}">
                    <p>Sorry, the list of movies is empty. Please make sure you've populated the DB and entered appropriate search terms.</p>
                </c:when>
                <c:otherwise>
                    <c:forEach var="movie" items="${movies}">
                        <h2 style="color:Tomato">${movie.title}</h2>
                        <p><i>Directed by ${movie.director}</i></p>
                        <p>Length: ${movie.lengthInMinutes} minutes</p>
                        <br>
                    </c:forEach>
                </c:otherwise>
            </c:choose>
            <br>
            <p><i>${invalidInputMessage}</i></p>
        </div>

        <%@include file="includes/footer.jsp"%>
    </div>

</body>
</html>
