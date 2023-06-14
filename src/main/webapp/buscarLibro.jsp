<%--
  Created by IntelliJ IDEA.
  User: 56976
  Date: 6/6/2023
  Time: 11:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Buscar Libro</title>
</head>
<body>
<h1 class="encabezado">
    Buscar Libro
</h1>
<table>
    <form action="buscarLibroNombre.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Por Nombre" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="buscarLibroCategoria.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Por Categoria" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="buscarLibroAño.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Por año" class="boton">
        </div>
    </form>
</table>
</body>
</html>
