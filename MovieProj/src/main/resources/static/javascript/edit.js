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
            }
        });
        event.preventDefault();
    });
});