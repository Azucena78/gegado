
<%--
  Created by IntelliJ IDEA.
  User: irina
  Date: 14/6/23
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Categorias</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>

  <link type="text/css" rel="stylesheet" href="css/style.css">
</head>
<jsp:include page="header.jsp"></jsp:include>
<body>
<div class="container-sm-fluid mx-auto text-center my-4 container-xl">
  <form action="ControllerCateg" method="post" class="container-sm-fluid mx-auto text-center my-4 container-xl">
    <div class="row" >
      <div class="col-xl-3 col-sm-6 m-auto" >
        <input type="radio" class="btn-check" name="idT" id="option1"  value="1">
        <label class="btn btn-success" for="option1">Ingreso</label>
      </div>
      <div class="col-xl-3 col-sm-6 m-auto" >
        <input type="radio" class="btn-check" name="idT" id="option2" value='2'>
        <label class="btn btn-danger" for="option2">Gastos</label>
      </div>
    </div>
    <div class="row" >
      <div class="col-xl-3">
        <div class="invalid-feedback">
          El nombre de la Categoria es requerido
        </div>
      </div>
    </div>

    <div class="col-xl-6 my-4 col-sm-12 m-auto">
      <label for="nombreC" class="form-label">Nombre de la Categoria</label>
      <input type="text" class="form-control" id="nombreC"  name="nombreC" required>
      <div class="invalid-feedback">
        El nombre de la Categoria es requerido
      </div>
    </div>
    <div class="row my-4">
      <div class="col-xl-6  col-sm-12 m-auto">
        <c:forEach items="${icon}" var="icon">

          <input type="radio" class="btn-check" name="icon" id="<c:out value="${icon}"/>" value="<c:out value="${icon}"/>">
          <label class="btn btn-light  m-2" for="<c:out value="${icon}"/>">
            <img src="<c:out value="${icon}"/>" width="30" class="rounded-circle">
          </label>

        </c:forEach>
      </div>
    </div>

    <!--   <img  class="btn" src="" alt="icono" width="70" > -->


    <div class="col-md-6 col-sm-12 m-auto">
      <button class="btn btn-primary" type="submit">Crear Categoría</button>
    </div>
  </form>
</div>
</body>
</html>