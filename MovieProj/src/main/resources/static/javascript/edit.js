$(document).ready(function() {
    var editLink = $("a[id='EDIT']");

    $(editLink).click(function(event) {
        var name = $("input[id='edit_name']").val();
        var genre = $("input[id='edit_genre']").val();
        var id = $("input[id='movie_id']").val();
        var json = {"id": id, "name" : name, "genre" : genre};

        $.ajax({
            url: $(event.target).attr("href"),
            data: JSON.stringify(json),
            dataType: 'json',
            type: "PUT",
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            success: function(movie) {
                console.log("Movie successfully modified");
                console.log("name: " + name + " genre: " + genre);
                $("a[href='/movie/" + movie.id + "']").parent().siblings('.movie_name').text(movie.name);
                $("a[href='/movie/" + movie.id + "']").parent().siblings('.movie_genre').text(movie.genre);
                $("#display_result").html("<svg class='checkmark' xmlns='http://www.w3.org/2000/svg' viewBox='0 0 52 52'><circle class='checkmark__circle' cx='26' cy='26' r='25' fill='none'/><path class='checkmark__check' fill='none' d='M14.1 27.2l7.1 7.2 16.7-16.8'/></svg>");
            }
        });
        event.preventDefault();
    });
});