$(document).ready(function() {
    var editLink = $("a[id='EDIT']");
    $(editLink).click(function(event) {
        console.log("Am dat click")
        $.ajax({
            url: $(event.target).attr("href"),
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