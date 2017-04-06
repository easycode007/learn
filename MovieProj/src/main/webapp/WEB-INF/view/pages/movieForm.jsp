<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form id="addMovieForm" method="POST" action="/movie" modelAttribute="movie">
	<table>
		<tr>
			<td><form:label path="name">Name</form:label></td>
			<td><form:input path="name" class="form-control"/></td>
		</tr>
		<tr>
			<td><form:label path="genre">Genre</form:label></td>
			<td><form:input path="genre" class="form-control"/></td>
		</tr>
		<tr>
			<td><input class="btn btn-primary" type="submit" value="Add"/></td>
		</tr>
	</table>
</form:form>
<div id="movieAdded"></div>