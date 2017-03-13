<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<form:form method="POST" action="/addMovie" modelAttribute="movie">
	<table>
		<tr>
			<td><form:label path="name">Name</form:label></td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td><form:label path="genre">Genre</form:label></td>
			<td><form:input path="genre" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Add" /></td>
		</tr>
	</table>
</form:form>