$(document).ready(function() {
    var editLink = $("a[id='EDIT']");

    $(editLink).click(function(event) {
        var name = $("input[id='edit_name']").val();
        var genre = $("input[id='edit_genre']").val();
        var id = $("input[id='movie_id']").val();
        var json = {"id": id, "Title" : name, "Genre" : genre};
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
                $("a[href='/movie/" + movie.id + "']").parent().siblings('.movie_name').text(movie.title);
                $("a[href='/movie/" + movie.id + "']").parent().siblings('.movie_genre').text(movie.genre);
                $("a[href='/movie/" + movie.id + "']").parent().parent().removeClass('highlight');
                //$("a[href='/movie/" + movie.id + "']").parent().parent().addClass('highlight');
                // use setTimeout to add the highlight class
                setTimeout(function () {
                    $("a[href='/movie/" + movie.id + "']").parent().parent().addClass('highlight');
                }, 0);
            }
        });
        event.preventDefault();
    });
});