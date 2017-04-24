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
    <a class="btn btn-default" id='addImdbMovie' data-dismiss="modal" href="imdbmovie">ADD</a>
    <div id="imdbMovieAdded"></div>
    <div id="Title"> <h2> </h2> </div>
    <div id="Year"> <p> </p> </div>
    <div id="Rated"> <p> </p> </div>
    <div id="Votes"> <p> </p> </div>
    <div id="Released"> <p> </p> </div>
    <div id="Runtime"> <p> </p> </div>
    <div id="Genre"> <p> </p> </div>
    <div id="Director"> <p> </p> </div>
    <div id="Writer"> <p> </p> </div>
    <div id="Actors"> <p> </p> </div>
    <div id="Plot"> <p> </p> </div>
    <div id="Language"> <p> </p> </div>
    <div id="Country"> <p> </p> </div>
    <div id="Awards"> <p> </p> </div>
    <div id="Metascore"> <p> </p> </div>
    <div id="imdbRating"> <p> </p> </div>
    <div id="imdbVotes"> <p> </p> </div>
    <div id="imdbID"> <p> </p> </div>
    <div id="Type"> <p> </p> </div>
    <div id="DVD"> <p> </p> </div>
    <div id="BoxOffice"> <p> </p> </div>
    <div id="Production"> <p> </p> </div>
    <div id="Website"> <p> </p> </div>
</div>