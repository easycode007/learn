$(document).ready(function() {
    var editLink = $("a[id='EDIT']");
    $(editLink).click(function(event) {

        var name = $("#edit_name").val();
        var genre = $("#edit_genre").val();
        var json = {"name" : name, "genre" : genre};

        $.ajax({
            url: $(event.target).attr("href"),
            data: JSON.stringify(json),
            type: "PUT",

              beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
              },

              success: function(movie) {
                console.log(movie);
                console.log("MOVIE SUCCESSFULLY EDITED");
              }
        });
        event.preventDefault();
    });
});