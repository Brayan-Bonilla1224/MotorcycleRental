var username = new URL(location.href).searchParams.get("username");
var user;

$(document).ready(function () {

    getUsuario().then(function () {

        $("#mi-perfil-btn").attr("href", "profile.html?username=" + username);

        $("#user-saldo").html("Nivel Premium: " + user.premium)

        getMotocicletas(false, "ASC");

//        $("#ordenar-genero").click(ordenarPeliculas);
    });
});


async function getUsuario() {

    await $.ajax({
        type: "GET",
        dataType: "html",
        url: "./UsuarioFindServlet",
        data: $.param({
            username: username
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult !== false) {
                user = parsedResult;
            } else {
                console.log("Error recuperando los datos del usuario");
            }
        }
    });

}
function getMotocicletas(ordenar, orden) {

    $.ajax({
        type: "GET",
        dataType: "html",
        url: "./PeliculaFindAllServlet",
        data: $.param({
            ordenar: ordenar,
            orden: orden
        }),
        success: function (result) {
            let parsedResult = JSON.parse(result);

            if (parsedResult !== false) {
                mostrarMotocicletas(parsedResult);
            } else {
                console.log("Error recuperando los datos de las motocicleta");
            }
        }
    });
}
function mostrarMotocicletas(motocicletas) {

    let contenido = "";

    $.each(motocicletas, function (index, motocicleta) {

        motocicleta = JSON.parse(motocicleta);
        let precio;

        if (motocicleta.disponibles > 0) {

            if (user.premium <= 1) {

                precio = motocicleta.valor;
            } else {
                precio = motocicleta.valor;
            }

            contenido += '<tr><th scope="row">' + motocicleta.id + '</th>' +
                    '<td>' + motocicleta.marca + '</td>' +
                    '<td>' + motocicleta.modelo + '</td>' +
                    '<td>' + motocicleta.disponibles + '</td>' +
                    '<td>' + motocicleta.valor + '</td>'  ;
            contenido += '<td><button onclick="alquilarPelicula(' + motocicleta.id + ',' + precio + ');" class="btn btn-success" ';


            contenido += '>Reservar</button></td></tr>';

        }
    });
    $("#motocicletas-tbody").html(contenido);
}

function ordenarPeliculas() {

    if ($("#icono-ordenar").hasClass("fa-sort")) {
        getPeliculas(true, "ASC");
        $("#icono-ordenar").removeClass("fa-sort");
        $("#icono-ordenar").addClass("fa-sort-down");
    } else if ($("#icono-ordenar").hasClass("fa-sort-down")) {
        getPeliculas(true, "DESC");
        $("#icono-ordenar").removeClass("fa-sort-down");
        $("#icono-ordenar").addClass("fa-sort-up");
    } else if ($("#icono-ordenar").hasClass("fa-sort-up")) {
        getPeliculas(false, "ASC");
        $("#icono-ordenar").removeClass("fa-sort-up");
        $("#icono-ordenar").addClass("fa-sort");
    }
}