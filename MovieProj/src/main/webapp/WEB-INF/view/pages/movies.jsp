<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2> Movies results </h2>
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
                    <form:form id="editMovie" method="POST" action="/edit" modelAttribute="movie">
                        <input type="submit" value="EDIT"/>
                    </form:form>
                    <form:form id="deleteMovie" method="POST" action="/delete" modelAttribute="movie">
                        <input type="submit" value="DELETE"/>
                    </form:form>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>