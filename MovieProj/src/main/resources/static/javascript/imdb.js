$(document).ready(function() {

    $('#imdbSearchForm').submit(function(event) {

        var title = $('#title').val();
        var json = {'title': title};

        $.ajax({
            url: $("#imdbSearchForm").attr("action"),
            data: JSON.stringify(json),
            type: "POST",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function(movie) {
                console.log(movie);
                $("#imdbResults").show();
                $("#poster").attr('src', movie.Poster);
                $("#Title").text(movie.Title);
                $("#Year span").text(movie.Year);
                $("#Rated").html(movie.Rated);
                $("#Released").html(movie.Released);
                $("#Runtime").html(movie.Runtime);
                $("#Genre").text(movie.Genre);
                $("#Director span").html(movie.Director);
                $("#Writer span").text(movie.Writer);
                $("#Actors span").html(movie.Actors);
                $("#Plot").html(movie.Plot);
                $("#Awards span").html(movie.Awards);
                $("#imdbRating span").html(movie.imdbRating);
                $("#Metascore span").html(movie.Metascore);
                $("#imdbVotes").html(movie.imdbVotes);
                $("#Language span").html(movie.Language);
                $("#Country span").html(movie.Country);
                $("#imdbID span").html(movie.imdbID);
                $("DVD span").html(movie.DVD);
                $("#BoxOffice span").html(movie.BoxOffice);
                $("#Production span").html(movie.Production);
                $("#Website a").html(movie.Website)
                $("#Type span").html(movie.Type);
            }
        });
        event.preventDefault();
    });
});