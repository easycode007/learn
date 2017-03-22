<table id="listMovies">
    <tr>
        <td> NAME </td>
        <td> GENRE </td>
        <td> OPTION </td>
    </tr>
    <tr>
        <td> ${name} </td>
        <td> ${genre} </td>
        <td>
            <form:form id="deleteMovie" method="POST" action="/delete" modelAttribute="movie">
                <input type="submit" value="DELETE"/>
            </form:form>
            <form:form id="editMovie" method="POST" action="/edit" modelAttribute="movie">
                <input type="submit" value="EDIT"/>
            </form:form>
        </td>
    </tr>
</table>
