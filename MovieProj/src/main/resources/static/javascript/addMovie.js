$(document).ready(function() {

  $('#addMovieForm').submit(function(event) {

      var name = $('#name').val();
      var genre = $('#genre').val();
      var json = { "name" : name, "genre" : genre};

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
            respContent += "<div class='success'><span>Well done! </span>" + movie.name + "was added.</div>"
            $("#movieAdded").html(respContent);
        }
    });
    event.preventDefault();
  });
});