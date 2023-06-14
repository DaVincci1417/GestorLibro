<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/13/2023
  Time: 12:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Agregar Categoria</title>
</head>
<body>
<h1 class="encabezado"> Agregar Categoría</h1>
<h2 class="subtitulo">La categoria ya existe</h2>
<form action="agregarCategoria" method="post">
    <div class="centrado">
        <label> Nombre: </label>
        <input name="nombre" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="Agregar" class="boton">
        <a class="boton" href="index.jsp">Volver</a>
    </div>
</form>
</body>
</html>
