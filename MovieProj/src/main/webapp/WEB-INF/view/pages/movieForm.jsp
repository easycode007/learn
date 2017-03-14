<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form method="POST" action="/movie" modelAttribute="movie">
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