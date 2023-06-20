<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta name="autor"content="Trabajo Equipo">
    <meta charset="UTF-8">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <title>Balance</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container container-sm my-4">

    <h2 class="text-light">Gastos: <c:out value="${gastosTotal}"></c:out>€</h2>
    <div class="progress" role="progressbar" aria-label="Danger example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
        <div class="progress-bar bg-danger" style="width: 100%"></div>
    </div>
<table class="table mt-3">
     <tr>
        <th>Detalles</th>
        <th>Fecha</th>
        <th>Importe</th>
        <th>Categorias</th>
    </tr>

    <c:forEach var="gastos" items="${gastos}">
        <tr>
            <td><c:out value="${gastos.detallesG}"></c:out></td>
            <td><c:out value="${gastos.fechaG}"></c:out></td>
            <td><c:out value="${gastos.importeG}"></c:out></td>
            <td><c:out value="${gastos.idC}"></c:out></td>
        </tr>
    </c:forEach>
</table>

    <h2 class="text-light">Ingresos: <c:out value="${ingresoTotal}"></c:out>€</h2>
    <div class="progress" role="progressbar" aria-label="Success example" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100">
        <div class="progress-bar bg-success" style="width: 100%"></div>
    </div>
    <table class="table mt-3">
        <tr>
            <th>Detalles</th>
            <th>Fecha</th>
            <th>Importe</th>
            <th>Categorias</th>
        </tr>
    <c:forEach var="ingresos" items="${ingresos}">
        <tr>
            <td><c:out value="${ingresos.detallesG}"></c:out></td>
            <td><c:out value="${ingresos.fechaG}"></c:out></td>
            <td><c:out value="${ingresos.importeG}"></c:out></td>
            <td><c:out value="${ingresos.idC}"></c:out></td>
        </tr>
    </c:forEach>



</table>

<footer class="row">
    <div class="text-end">
    <a href="gestion.jsp"><span class="color-light fs-3 btn btn-danger">+</span></a>
    </div>
</footer>

</div>

</body>

</html>