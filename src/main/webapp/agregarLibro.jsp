<%@ page import="com.example.gestionlibros.Model.Categoria" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Agregar Libro</title>
</head>
<body>
<h1 class="encabezado"> Agregar Libro</h1>
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
            <optgroup label="Seleccionar Categoria"></optgroup>
            <option>Terror</option>
            <option>Aventura</option>
            <option>Accion</option>
            <option>Romance</option>
            <option>Fantasia</option>
        </select>

        <label> Tipo de Libro: </label>
        <input name="tipoLibro" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="Agregar" class="boton">
    </div>
</form>
</body>
</html>
