<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2> Moviess results </h2>
<div id="fromResponse"></div>
<table id="listMovies">
    <thead>
        <tr>
            <th>Name</th>
            <th>Genre</th>
            <th>Option</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${movieList}" var="movie">
            <tr>
                <td>${movie.name}</td>
                <td>${movie.genre}</td>
                <td>
                    <%--
                        <form:form method="DELETE" action="/movie/${movie.id}">
                            <input type="submit" value="DELETE"/>
                        </form:form>
                    --%>
                    <a id='DELETE' href="/movie/${movie.id}">DELETE</a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>