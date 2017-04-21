$(document).ready(function() {
    var addImdbMovie = $("a[id='addImdbMovie']");

    addImdbMovie.click(function(event) {
        var title = $("#Title h2").val();
        var year = $("#Year p").val();
        var rated = $("#Rated p").val();
        var released = $("#Released p").val();
        var runtime = $("#Runtime p").val();
        var genre = $("#Genre p").val();
        var director = $("#Director p").val();
        var writer = $("#Writer p").val();
        var actors = $("#Actors p").val();
        var plot = $("#Plot p").val();
        var language = $("#Language p").val();
        var country = $("#Country p").val();
        var awards = $("#Awards p").val();
        var rating = $("#Ratings p").val();
        var metascore = $("#Metascore p").val();
        var imdbRating = $("#imdbRating p").val();
        var imdbVotes = $("#imdbVotes p").val();
        var imdbID = $("#imdbID p").val();
        var type = $("#Type p").val();
        var dvd = $("#DVD p").val();
        var boxOffice = $("#BoxOffice p").val();
        var production = $("#Production p").val();
        var website = $("#Website p").val();

        var json = {
            "title": title,
            "year": year,
            "rated": rated,
            "released": released,
            "runtime": runtime,
            "genre": genre,
            "director": director,
            "writer": writer,
            "actors": actors,
            "plot": plot,
            "language": language,
            "country": country,
            "awards": awards,
            "rating": rating,
            "metascore": metascore,
            "imdbRating": imdbRating,
            "imdbVotes": imdbVotes,
            "imdbID": imdbID,
            "type": type,
            "dvd": dvd,
            "boxOffice": boxOffice,
            "production": production,
            "website": website
        };

        $.ajax({
            url: $(event.target).attr("href"),
            data: JSON.stringify(json),
            type: POST,

            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },

            success: function(movie) {
                console.log("Movie added successfully");
                var respContent = "";
                    respContent += "<div class='success'><span>Well done! </span>Movie was added.</div>"
                    $("#movieAdded").html(respContent);
            }
        })
    });
});