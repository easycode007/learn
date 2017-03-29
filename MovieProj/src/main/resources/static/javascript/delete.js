$(document).ready(function() {

    var deleteLink = $("a[id='DELETE']");

    $(deleteLink).click(function(event) {
        console.log('something smart - in click event method')
        $.ajax({
            url: $(event.target).attr("href"),
            type: "DELETE",

              beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
              },

              success: function(movie) {
                console.log(movie);
                var respContent = "";
                respContent += "<span id='fromResponse'>Movie was deleted: [";
                respContent += movie.id + " : ";
                respContent += movie.name + " : " ;
                respContent += movie.genre + "]</span>";

                $("#fromResponse").html(respContent);
              }
        });
        event.preventDefault();
    });
});