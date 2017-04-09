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
                console.log("SUCCESS-URI!!!");
                $("#imdbResults").show();
                console.log("POSTER: " + movie.Poster);
                $("#poster").attr('src', movie.Poster);
            }
        });
        event.preventDefault();
    });
});