<h2> Search a movie </h2>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form id="searchMovie" method="POST" action="/search" modelAttribute="name">
    <table>
        <tr>
            <td><form:label path="name">Name</form:label></td>
            <td><form:input name="searchName" path="name" /></td>
        </tr>
        <tr>
            <td><input type="submit" value="Search"/></td>
        </tr>
    </table>
</form:form>