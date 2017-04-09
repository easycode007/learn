<h2> IMDB Integration </h2>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<form:form id="imdbSearchForm" method="POST" action="/imdb" modelAttribute="title">
    <table>
        <tr>
            <td><form:label path="title">Title</form:label></td>
            <td><form:input path="title" class="form-control"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Search" class="btn btn-success"/></td>
        </tr>
    </table>
</form:form>

<div id="imdbResults" style="display: none;">
    <img id="poster" src="" alt="MoviePoster" style="width:304px;height:228px;">
</div>