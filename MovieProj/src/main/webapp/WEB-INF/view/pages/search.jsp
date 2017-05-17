<h2> Search a movie </h2>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form id="searchMovie" method="POST" action="/search" modelAttribute="title">
    <table>
        <tr>
            <td><form:label path="title">Name</form:label></td>
            <td><form:input path="title" class="form-control"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Search" class="btn btn-success"/></td>
        </tr>
    </table>
</form:form>