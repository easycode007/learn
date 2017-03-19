$(document).ready(function() {
    $("#searchMovie").validate({
        rules: {
            "searchName": {
                required: true,
                minlength: 4,
                maxlength: 40
            },
            /*"userRegistration.password": {
                required: true,
                minlength: 6,
                maxlength: 40
            }*/
        },
        messages: {
            "searchName": {
                required: "name is required!",
                minlength: "name must be at least 4 characters long"
            }/*,
            "userRegistration.password": {
                required: "Please enter a password",
                minlength: "Password must be at least 6 characters long"
            }*/
        }
    });
});