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
    <div class="container">
        <div class="row">
            <div class="col-sm-8"></div>
            <br>
        </div>
        <div class="row">
            <div class="col-sm-12 mid">
                <div class="row">
                    <div class="col-sm-3" >
                        <img src=""  id="poster"  alt="Responsive image" >
                    </div>
                    <div class="col-sm-5 one" >
                        <h1 class="movieTitle" id="Title"></h1><span>  </span>
                        <h2 class="movieTitle" id="Year" >  (<span></span>) </h2>
                        <br><hr>
                        <p class="movieList" id="Rated"></p><span>  |  </span>
                        <p class="movieList" id="Runtime"></p><span>  |  </span>
                        <p class="movieList" id="Genre"></p> <span>|</span>
                        <p class="movieList" id="Released"></p>
                        <br>
                        <p  id="Director"> <b>Director:</b> <span></span></p>
                        <p  id="Writer"> <b>Writers:</b> <span></span></p>
                        <p id="Actors"> <b>Stars:</b> <span></span></p>
                    </div>
                    <div class="col-sm-2">
                        <div class="movieNote" id="imdbRating"  >
                            <img class="starImage" src="/imgs/star.ico"/>
                            <span class="maxNote"></span>/10<br>
                            <span id="imdbVotes"></span>
                        </div>
                        <div class="col-sm-2"> </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <br>
                        <div class="score">
                            <h4 id="Metascore"><span></span> Metascore from <a href="http://www.metacritic.com/"> metacritic.com</a></h4>
                        </div>
                        <!-- <div id="Plot" class="well well-sm"> </div> -->
                        <div class="panel panel-default">
                            <div class="panel-heading">
                                <h4 class="panel-title">
                                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Plot</a>
                                </h4>
                            </div>
                            <div id="collapse1" class="panel-collapse collapse">
                                <div class="panel-body" id="Plot"></div>
                            </div>
                        </div>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-sm-1"></div>
                    <div class="col-sm-8">
                        <div class="well well-sm" class="movieInfo">
                            <p id="Type"><b>Type:</b>  <span></span></p>
                            <p id="Production"><b>Production:</b> <span></span></p>
                            <p id="Awards"><b>Awards</b> <span></span></p>
                            <p id="imdbID">  <b>imdbID:</b> <span></span></p>
                            <p id="Language"> <b>Language:</b> <span></span></p>
                            <p id="Country"><b>Country:</b> <span></span></p>
                            <p id="DVD "><b>DVD :</b>  <span></span></p>
                            <p id="BoxOffice"><b>BoxOffice:</b>   <span></span></p>
                            <p id="Website"><b>Website:</b>  <a href=""></a></p>
                        </div>
                    </div>
                    <div class="col-sm-3"></div>
                </div>
            </div>
        </div>
    </div>
</div>