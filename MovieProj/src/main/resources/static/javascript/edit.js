$(document).ready(function() {
    var editLink = $("a[id='EDIT']");
    var name = $("input[id='edit_name']").val();
    var genre = $("input[id='edit_genre']").val();
    var json = {"name" : name, "genre" : genre};

    $(editLink).click(function(event) {
        console.log(name + " " + genre);
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