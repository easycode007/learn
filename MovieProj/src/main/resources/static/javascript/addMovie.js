$(document).ready(function() {

  $('#addMovieForm').submit(function(event) {

      var title = $('#title').val();
      var genre = $('#genre').val();
      var json = { "Title" : title, "Genre" : genre};

    $.ajax({
        url: $("#addMovieForm").attr("action"),
        data: JSON.stringify(json),
        type: "POST",

        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function(movie) {
            console.log("Movie Description: " + movie.Title + " " + movie.Genre + " ");
            var respContent = "";
            respContent += "<div class='success'><span>Well done! </span>" + movie.Title + " was added.</div>"
            $("#movieAdded").html(respContent);
        }
    });
    event.preventDefault();
  });
});