<%--
  Created by IntelliJ IDEA.
  User: PROGRAMACION
  Date: 14/06/2023
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="shortcut icon" href="Oil, money, dollas, water, currency.png"type="image/x-icon">
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="autor"content="Trabajo equipo">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <link type="text/css" rel="stylesheet" href="css/style.css">

    <title>GEGADO</title>
</head>

<body>
<div class="container container-sm">
    <h2 class="text-light">GEGADO</h2>
    <form action="Controlador" class="row g-3 needs-validation" novalidate method="get">
        <fieldset>
    <input type="hidden" name="opcion" value="crearGasto">
            <legend class="text-light">Gastos</legend>

            <div class="row">
                <div class="col-sm-12 col-xl-3 mb-3">
                    <label for="detalleG"class="form-label text-light">Detalles</label>
                    <input type="text" class="form-control" id="detalleG" name="detalleG" required maxlength="50">
                    <div id="detalles" class="form-text"></div>
                </div>
            </div>

            <div class="row" >
                <div class="col-sm-12 col-xl-3 mb-3">
                    <label for="fechaHora" class="form-label text-light">Fecha</label>
                    <input type="Date" class="form-control" id="fechaHora" name="fechaHora" required>
                </div>
            </div>

            <div class="row" >
                <div class="col-sm-12 col-xl-3 mb-3">
                    <label for="importe" class="form-label text-light">Importe</label>
                    <input type="number" class="form-control" id="importe" name="importe" required>
                </div>
            </div>

            <div class="row" >
                <div class="col-sm-12 col-xl-3 mb-3">
                    <label for="idC" class="form-label text-light">Transacción</label>
                    <input type="number" class="form-control" id="idC" name="idC" required>
                </div>
            </div>
        </fieldset>

        <div class="row mb-1">
            <div class="p-2 col-2">
                <button type="submit" class="btn btn-primary " >Guardar</button></div>
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