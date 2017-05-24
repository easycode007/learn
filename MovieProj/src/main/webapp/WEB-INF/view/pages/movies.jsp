<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2> Moviess results </h2>
<div id="fromResponse"></div>
<div id="movieTable">
    <table id="listMovies" class="table table-bordered">
        <thead>
            <tr>
                <th>Title</th>
                <th>Genre</th>
                <th>Option</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${simpleMovieList}" var="simpleMovie">
                <tr>
                    <td class="movie_name">${simpleMovie.title}</td>
                    <td class="movie_genre">${simpleMovie.genre}</td>
                    <td>
                        <a class="btn btn-default" id='DELETE' href="/movie/${simpleMovie.id}">DELETE</a>
                        <a class="btn btn-default" id='GET' data-toggle="modal" data-target="#myModal" href="/movie/${simpleMovie.id}">
                        EDIT
                        <input type="hidden" name="movieType" value="simpleMovie">
                        </a>
                        <a class="btn btn-default" data-toggle="collapse" data-parent="#accordion" href="#collapse-${simpleMovie.id}">Info</a>
                        <div id="collapse-${simpleMovie.id}" class="panel-collapse collapse">
                            <br>
                            <p>  Movie Genre: ${simpleMovie.genre} </p>
                        </div>
                    </td>
                </tr>
            </c:forEach>
            <c:forEach items="${imdbMovieList}" var="imdbMovie">
                <tr>
                    <td class="movie_name">${imdbMovie.title}</td>
                    <td class="movie_genre">${imdbMovie.genre}</td>
                    <td>
                        <a class="btn btn-default" id='DELETE' href="/movie/${imdbMovie.id}">DELETE</a>
                        <a class="btn btn-default" id='GET' data-toggle="modal" data-target="#myModal" href="/movie/${imdbMovie.id}">
                        EDIT
                        <input type="hidden" name="movieType" value="imdbMovie">
                        </a>
                        <a class="btn btn-default" data-toggle="collapse" data-parent="#accordion" href="#collapse-${imdbMovie.id}">Info</a>
                        <div id="collapse-${imdbMovie.id}" class="panel-collapse collapse">
                            <br>
                            <p>  Movie plot: ${imdbMovie.plot}</p>
                        </div>
                    </td>
                </tr>
            </c:forEach>


        </tbody>
    </table>
</div>

<!-- Modal -->
<div class="modal fade" id="myModal" role="dialog">
<div class="modal-dialog">
  <!-- Modal content-->
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal">&times;</button>
      <h4 class="modal-title">Movie Information</h4>
    </div>
    <div class="modal-body">
      <input id="edit_name" type="text" value=""/>
      <input id="edit_genre" type="text" value=""/>
      <input id="movie_id" type="hidden" value=""/>
    </div>
    <div class="modal-footer">
      <a class="btn btn-default" id='EDIT' data-dismiss="modal" href="movie">Apply</a>
      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
    </div>
  </div>
</div>
</div>


<!-- Modal -->
<div class="modal fade" id="imdbMovie" role="dialog">
<div class="modal-dialog">
  <!-- Modal content-->
  <div class="modal-content">
    <div class="modal-header">
      <button type="button" class="close" data-dismiss="modal">&times;</button>
      <h4 class="modal-title">Movie Information</h4>
    </div>
    <div class="modal-body">
      <input id="imdb_name" type="text" value=""/>
      <input id="imdb_genre" type="text" value=""/>
      <input id="imdb_id" type="hidden" value=""/>
      <input id="imdb_plot" type="hidden" value=""/>
      <input id="imdbRating" type="hidden" value=""/>
      <input id="" type="hidden" value=""/>
      <input id="" type="hidden" value=""/>
      <input id="" type="hidden" value=""/>
    </div>
    <div class="modal-footer">
      <a class="btn btn-default" id='EDIT' data-dismiss="modal" href="movie">Apply</a>
      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
    </div>
  </div>
</div>
</div>