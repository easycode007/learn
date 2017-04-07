$(document).ready(function() {
    var getLink = $("a[id='GET']");
    $(getLink).click(function(event) {
        $.ajax({
            url: $(event.target).attr("href"),
            type: "GET",

              beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
              },

              success: function(movie) {
                $("#edit_name").val(movie.name);
                $("#edit_genre").val(movie.genre);
                $("#movie_id").val(movie.id);
              }
        });
        event.preventDefault();
    });
});