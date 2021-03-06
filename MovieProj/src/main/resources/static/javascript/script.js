var script = document.createElement('script');
script.src = 'http://code.jquery.com/jquery-1.11.0.min.js';

$(document).ready(function() {
    $("#searchMovie").validate({
        rules: {
            "name": {
                required: true,
                minlength: 4,
                maxlength: 40
            },
        },
        messages: {
            "name": {
                required: "name is required!",
                minlength: "name must be at least 4 characters long"
            }
        }
    });
});