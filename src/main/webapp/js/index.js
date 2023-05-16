$(document).ready(function () {

    $("#form-login").submit(function (event) {
        event.preventDefault();
        authenticateUser();
    });

    $("#form-register").submit(function (event) {
        event.preventDefault();
        registerUser();
    });
});

function authenticateUser() {
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
        success: function (result) {
            let parsedResult = JSON.parse(result);
            if (parsedResult !== false) {
                $("#login-error").addClass("d-none");
                let userNameR = parsedResult['userName'];
                document.location.href = "home.html?username=" + userNameR;
            } else {
                $("#login-error").removeClass("d-none");
            }
        }
    });
}

function registerUser() {
    let username = $("#input-username").val();
    let contrasena = $("#input-contrasena").val();
    let repetirContrasena = $("#input-repetir-contrasena").val();
    let nombres = $("#input-nombres").val();
    let apellidos = $("#input-apellidos").val();
    let email = $("#input-email").val();
    let celular = $("#input-celular").val();

    if (contrasena === repetirContrasena) {
        $.ajax({
            type: "GET",
            dataType: "html",
            url: "./UsuarioRegisterServlet",
            data: $.param({
                username: username,
                contrasena: contrasena,
                nombres: nombres,
                apellidos: apellidos,
                email: email,
                celular: celular
            }),
            success: function (result) {
                let parsedResult = JSON.parse(result);
                if (parsedResult !== false) {
                    $("#register-error").addClass("d-none");
                    let userNameR = parsedResult['userName'];
                    document.location.href = "home.html?username=" + userNameR;
                } else {
                    $("#register-error").removeClass("d-none");
                    $("#register-error").html("Error en el registro, intente de nuevo");
                }
            }
        });
    } else {
        $("#register-error").removeClass("d-none");
        $("#register-error").html("Las contraseñas no coinciden");
    }


}