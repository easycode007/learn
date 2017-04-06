$(document).ready(function() {
    var editLink = $("a[id='EDIT']");
    $(editLink).click(function(event) {
        $.ajax({
            url: $(event.target).attr("href"),
            type: "GET",

              beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
              },

              success: function(movie) {
                console.log(movie);
//                $("#fromResponse").html(respContent);
              }
        });
        event.preventDefault();
    });
});