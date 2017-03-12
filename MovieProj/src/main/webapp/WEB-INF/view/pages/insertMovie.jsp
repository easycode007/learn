<form:form method="POST" action="/movie"
	modelAttribute="employee">
	<table>
		<tr>
			<td><form:label path="name">Name</form:label></td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td><form:label path="genre">Contact Number</form:label></td>
			<td><form:input path="genre" /></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit" /></td>
		</tr>
	</table>
</form:form>