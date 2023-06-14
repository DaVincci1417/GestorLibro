<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/8/2023
  Time: 6:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Agregar Libro</title>
</head>
<body>
<h1 class="encabezado"> Agregar Libro</h1>
<h2 class="subtitulo"> Datos incorrectos, favor comprobar nuevamente</h2>
<form action="agregarLibro" method="post">
    <div class="centrado">
        <label> Nombre: </label>
        <input name="nombre" type="text" class="campoTexto">

        <label> Editorial: </label>
        <input name="editorial" type="text" class="campoTexto">

        <label> Año: </label>
        <input name="año" type="number" class="campoTexto">

        <label> Categoria: </label>
        <select name="categoria">
            <option value="selecciona">
                Selecciona Categoria
            </option>
        </select>

        <label> Tipo de Libro: </label>
        <input name="tipoLibro" type="text" class="campoTexto">

        <br><br>
        <input type="submit" value="Agregar" class="boton">
    </div>
</form>
</body>
</html>
