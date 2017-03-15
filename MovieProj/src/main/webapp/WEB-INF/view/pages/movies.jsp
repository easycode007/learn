<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2> Movies results </h2>
<table>
    <thead>
        <tr>
            <th>Name</th>
            <th>Genre</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${movieList}" var="movie">
            <tr>
                <td>${movie.name}</td>
                <td>${movie.genre}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>