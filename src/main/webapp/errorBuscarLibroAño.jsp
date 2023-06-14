<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/8/2023
  Time: 2:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link rel="stylesheet" type="text/css" href="estilos.css">
  <title>Title</title>
</head>
<body>
<h1 class="encabezado">
  Buscar Libro
</h1>
<h2 class="subtitulo">
  Datos incorrectos, favor comprobar nuevamente
</h2>
<form action="buscarLibroYear" method="get">
  <div class="centrado">
    <label> Año: </label>
    <input name="año" type="number" class="campoTexto">
    <br><br>
    <input type="submit" value="Buscar" class="boton">
  </div>
</form>
</body>
</html>
