$(document).ready(function() {
    var getLink = $("a[id='GET']");
    $(getLink).click(function(event) {
        $.ajax({
            url: $(event.target).attr("href"),
            type: "GET",
            dataType: 'json',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },

            success: function(movie) {
                $("#edit_name").val(movie.Title);
                $("#edit_genre").val(movie.Genre);
                $("#movie_id").val(movie.id);
            }
        });
        event.preventDefault();
    });
});