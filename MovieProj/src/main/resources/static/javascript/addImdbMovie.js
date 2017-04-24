$(document).ready(function() {
    var addImdbMovie = $("a[id='addImdbMovie']");

    $(addImdbMovie).click(function(event) {
		var title = $("#Title h2").html();
        var year = $("#Year p").text();
        var rated = $("#Rated p").text();
        var released = $("#Released p").text();
        var runtime = $("#Runtime p").text();
        var genre = $("#Genre p").text();
        var director = $("#Director p").text();
        var writer = $("#Writer p").text();
        var actors = $("#Actors p").text();
        var plot = $("#Plot p").text();
        var language = $("#Language p").text();
        var country = $("#Country p").text();
        var awards = $("#Awards p").text();
        var metascore = $("#Metascore p").text();
        var imdbRating = $("#imdbRating p").text();
        var imdbVotes = $("#imdbVotes p").text();
        var imdbID = $("#imdbID p").text();
        var type = $("#Type p").text();
        var dvd = $("#DVD p").text();
        var boxOffice = $("#BoxOffice p").text();
        var production = $("#Production p").text();
        var website = $("#Website p").text();
		var poster = $("poster").attr("src");
		var votes = $("Votes p").text();

/*
		console.log(title + " " + year + " " + rated + " " + released + " " + runtime
		    + " " + genre + " " + director + " " + writer + " " +actors + " " +  plot  + " " + language
		     + " " + language  + " " + country  + " " + awards  + " " + metascore  + " " + imdbRating
		      + " " +  imdbVotes  + " " + imdbID  + " " + type  + " " + dvd  + " " + boxOffice  + " " +
		      production  + " " + website  + " " + poster  + " " +  votes);

*/
        var json = {
            "Title": title,
            "Year": year,
            "Rated": rated,
            "Released": released,
            "Runtime": runtime,
            "Genre": genre,
            "Director": director,
            "Writer": writer,
            "Actors": actors,
            "Plot": plot,
            "Language": language,
            "Country": country,
            "Awards": awards,
			"Poster": poster,
            "Metascore": metascore,
            "imdbRating": imdbRating,
            "imdbVotes": imdbVotes,
            "imdbID": imdbID,
            "Type": type,
            "DVD": dvd,
            "BoxOffice": boxOffice,
            "Production": production,
            "Website": website,
			"Votes": votes
        };

//        console.log("OBJECT:" + JSON.stringify(json));

		$.ajax({
            url: $(event.target).attr("href"),
            data: JSON.stringify(json),
            type: "POST",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },

            success: function(movie) {
                console.log("Movie added successfully");
                console.log(movie);
                var respContent = "";
                    respContent += "<div class='success'><span>Well done! </span>Movie was added.</div>"
                    $("#imdbMovieAdded").html(respContent);
            }
        });
		event.preventDefault();
    });
});