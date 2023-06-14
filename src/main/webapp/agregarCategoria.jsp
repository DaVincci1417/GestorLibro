<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Agregar Categoria</title>
</head>
<body>
<h1 class="encabezado"> Agregar Categoría</h1>
<form action="agregarCategoria" method="post">
    <div class="centrado">
        <label> Nombre: </label>
        <input name="nombre" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="Agregar" class="boton">
    </div>
</form>
</body>
</html>
