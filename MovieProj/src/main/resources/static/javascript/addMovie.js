$(document).ready(function() {

  $('#addMovieForm').submit(function(event) {

      var title = $('#title').val();
      var genre = $('#genre').val();
      var json = { "title" : title, "genre" : genre, "discriminator": "simpleMoviee"};


      console.log(JSON.stringify(json));


    $.ajax({
        url: $("#addMovieForm").attr("action"),
        data: JSON.stringify(json),
        type: "POST",

        beforeSend: function(xhr) {
            xhr.setRequestHeader("Accept", "application/json");
            xhr.setRequestHeader("Content-Type", "application/json");
        },
        success: function(movie) {
            var respContent = "";
            respContent += "<div class='success'><span>Well done! </span>" + movie.title + "was added.</div>"
            $("#movieAdded").html(respContent);
        }
    });
    event.preventDefault();
  });
});