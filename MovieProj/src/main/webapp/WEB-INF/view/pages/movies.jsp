<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h2> Moviess results </h2>
<div id="fromResponse"></div>
<div id="movieTable">
    <table id="listMovies" class="table table-bordered">
        <thead>
            <tr>
                <th>Name</th>
                <th>Genre</th>
                <th>Option</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${movieList}" var="movie">
                <tr>
                    <td>${movie.name}</td>
                    <td>${movie.genre}</td>
                    <td>
                        <%--
                            <form:form method="DELETE" action="/movie/${movie.id}">
                                <input type="submit" value="DELETE" class="btn-danger"/>
                            </form:form>
                        --%>
                        <a class="btn btn-default" id='DELETE' href="/movie/${movie.id}">DELETE</a>
                        <a class="btn btn-default" id='EDIT' data-toggle="modal" data-target="#myModal" href="/movie/${movie.id}">EDIT</a>
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
      <h4 class="modal-title">Modal Header</h4>
    </div>
    <div class="modal-body">
      <p>Some text in the modal.</p>
    </div>
    <div class="modal-footer">
      <button type="button" class="btn btn-default" data-dismiss="modal">Apply</button>
      <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
    </div>
  </div>

</div>
</div>
