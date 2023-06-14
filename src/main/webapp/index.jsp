<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title></title>
</head>
<body>
<h1 class="encabezado">
    Gestion de Libros UFRO
</h1>
<table>
    <form action="agregarLibro.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Agregar Libro" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="agregarCategoria.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Agregar Categoría" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="buscarLibro.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Buscar Libro" class="boton">
        </div>
    </form>
    <p>

    </p>
    <form action="eliminarLibro.jsp" method="get">
        <div class="centrado">
            <input type="submit" value="Eliminar Libro" class="boton" width="max-width" >
        </div>
    </form>
</table>
</body>
</html>