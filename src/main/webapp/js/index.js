$(document).ready(function(){
    
    $("#form-login").submit(function(event){
        event.preventDefault();
        authenticateUser();
    });
});

function authenticateUser(){
    let username = $("#username").val();
    let contrasena = $("#contrasena").val();
    
    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./UsuarioLoginServlet",
        data: $.param({
            username: username,
            contrasena: contrasena
        }),
        success: function(result){
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                $("#login-error").addClass("d-none");
                let userNameR = parsedResult['userName'];
                document.location.href = "home.html?username=" + userNameR;
            }else{
                $("#login-error").removeClass("d-none");
            }
        }
    });
}
