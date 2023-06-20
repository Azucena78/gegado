<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta name="autor"content="Trabajo equipo">
    <meta charset="UTF-8">
    <title>GeGaDo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container container-sm my-4">

    <form action="controlador" class="row g-3 needs-validation" novalidate method="post">
        <fieldset>
            <div class="row">
                <div class="col-sm-12 col-xl-3 mb-3 m-auto">
            <legend class="text-light">Datos Personales</legend>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12 col-xl-3 mb-3 m-auto">
                    <label for="userN"class="form-label text-light">Nombre Usuario</label>
                    <input type="text" class="form-control" id="userN" name="userN" required maxlength="50" autocomplete autofocus placeholder="Indica tu nombre">
                    <div id="nombreU" class="form-text"></div>
                    </div>
                </div>

            <div class="row" >
                <div class="col-sm-12 col-xl-3 mb-3 m-auto">
                    <label for="passU" class="form-label text-light">Password</label>
                    <input type="password" class="form-control" id="passU" name="passU" required>
                    </div>
                </div>

        </fieldset>

        <div class="row mb-1">
            <div class="p-2 col-6 m-auto text-center col-sm-12">
                <button type="submit" class="btn btn-dark mx-4" >Enviar</button>
                <a href="registro.jsp" class="btn btn-dark mx-4" type="button">Registrar</a>
                <a href="actualizacion.jsp" class="btn btn-dark mx-4" type="button">Olvidé contraseña</a>
            </div>
        </div>

    </form>
</div>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (() => {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        const forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.from(forms).forEach(form => {
            form.addEventListener('submit', event => {
                if (!form.checkValidity()) {
                    event.preventDefault()
                    event.stopPropagation()
                }

                form.classList.add('was-validated')
            }, false)
        })
    })()

</script>
</body>
</html>