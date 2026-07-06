<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Gestion de Contactos</title>
</head>
<body>

<h2>Agregar Nuevo Contacto</h2>

<form action="contacto" method="POST">
    <div>
        <label for="nombres">Nombre(s):</label>
        <input type="text" id="nombres" name="nombres" placeholder="Ej: Rodrigo Adrian" required>
    </div>
    <div>
        <label for="apellidos">Apellidos:</label>
        <input type="text" id="apellidos" name="apellidos" placeholder="Ej: Soto Sanchez" required>
    </div>
    <div>
        <label for="telefono">Telefono:</label>
        <input type="text" id="telefono" name="telefono" placeholder="Ej: 7770000000" required>
    </div>
    <div>
        <label for="telefono_alternativo">Telefono alternativo:</label>
        <input type="number" id="telefono_alternativo" name="telefono_alternativo" placeholder="Ej: 7771111111">
    </div>
    <div>
        <label for="correo_electronico">Correo electronico:</label>
        <input type="email" id="correo_electronico" name="correo_electronico" placeholder="Ej: example@gmail.com" required>
    </div>
    <div>
        <label for="red_social">Red Social:</label>
        <input type="text" id="red_social" name="red_social" placeholder="Ej: Eriis_Eriss" required>
    </div>

    <button type="submit">Guardar Contacto</button>
</form>

<hr>

<h2>Lista de Contactos</h2>

<table border="1">
    <thead>
    <tr>
        <th>Nombre(s)</th>
        <th>Apellidos</th>
        <th>Telefono</th>
        <th>Telefono Alternativo</th>
        <th>Correo Electronico</th>
        <th>Red social</th>
    </tr>
    </thead>
    <tbody>
    <c:choose>
        <c:when test="${empty listaContacto}">
            <tr>
                <td colspan="6">No hay contactos registrados.</td>
            </tr>
        </c:when>

        <c:otherwise>
            <c:forEach var="contacto" items="${listaContacto}">
                <tr>
                    <td>${contacto.nombres}</td>
                    <td>${contacto.apellidos}</td>
                    <td>${contacto.telefono}</td>
                    <td>${contacto.telefono_alternativo}</td>
                    <td>${contacto.correo_electronico}</td>
                    <td>${contacto.red_social}</td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
    </tbody>
</table>

</body>
</html>
