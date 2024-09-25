<ul class="nav nav-tabs">
    <li><a href="index.jsp">Home</a></li>
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">View All<b class="caret"></b></a>
        <ul class="dropdown-menu">
            <li><a href="ViewAll">Unsorted</a></li>
            <li><a href="ViewAll?sortType=title">By Title</a></li>
            <%--<li><a href="ViewAll?sortType=director">By Director</a></li>--%>
            <li><a href="ViewAll?sortType=lengthInMinutes">By Length</a></li>
        </ul>
    </li>
    <li><a href="search.jsp">Search</a></li>
    <li><a href="populate.jsp">Populate DB</a></li>
    <li><a href="add-movie.jsp">Add New Movie</a></li>
</ul>