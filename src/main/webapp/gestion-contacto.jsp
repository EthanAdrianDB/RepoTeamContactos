<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="layout/header.jsp" %>
<div class="row g-4">
    <div class="col-12">
        <h1 class="mb-4">Bienvenidos CONTACTOS Bonitos,Hermosos,Bellos.</h1>
    </div>

    <div class="col-md-7">
        <div class="row">
        <h4 class="text-secondary col-6">Aquí están todos los contactos</h4>
        <a href="mascota" class="btn btn-primary col-6 align-content-center text-center carga"><i class="bi bi-arrow-clockwise"></i> Cargar mascotas</a>
        </div>

        <c:choose>
            <%-- Condición 1: Si la lista es nula o está vacía --%>
            <c:when test="${empty listaContacto}">
                <div class="alert alert-info text-center mt-4" role="alert">
                    <i class="bi bi-info-circle-fill"></i> No hay contactos registradas en este momento.
                </div>
            </c:when>

            <%-- Condición por defecto: Si la lista SÍ tiene datos --%>
            <c:otherwise>
                <div class="table-responsive">
                    <table class="table table-striped table-hover mt-4 align-middle">
                        <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>Telefono</th>
                            <th>Telefono Alternativo</th>
                            <th>Correo Electronico</th>
                            <th>Red Social</th>

                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaContacto}" var="contacto">
                            <tr>
                                <td><strong>${contacto.id}</strong></td>
                                <td>${contacto.nombre}</td>
                                <td><span class="badge bg-secondary">${contacto.apellidos}</span></td>
                                <td>${contacto.telefono} años</td>
                                <td>${contacto.telefono_alternativo}</td>
                                <td>${contacto.correo}</td>
                                <td>${contacto.red_social}</td>
                                <td>
                                    <c:choose>
                                        <c:when test="${contacto.vacunada}">
                                            <span class="text-success"><i class="bi bi-check-circle-fill"></i> Sí</span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="text-danger"><i class="bi bi-x-circle-fill"></i> No</span>
                                        </c:otherwise>
                                    </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="col-md-5">
        <div class="card shadow-sm">
            <div class="card-body">
                <h4 class="card-title text-primary mb-4"><i class="bi bi-plus-circle-fill"></i> ¡Registra a tu mascota!</h4>

                <form action="mascota" method="POST">
                    <input type="hidden" name="action" value="create">

                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre del contacto</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ej: Firulais" required>
                    </div>


                    <div class="mb-3">
                        <label for="telefono" class="form-label">telefono</label>
                        <input type="number" class="form-control" id="telefono" name="telefono" placeholder="Ej: 7775329234" >
                    </div>

                    <div class="mb-3">
                        <label for="telefono_alternativo" class="form-label">telefono_alternativo</label>
                        <input type="text" class="form-control" id="telefono_alternativo" name="telefono_alternativo" placeholder="Ej: 777225911" >
                    </div>


                    <div class="mb-3">
                        <label for="correo" class="form-label">Correo Electronico</label>
                        <input type="text" class="form-control" id="correo" name="correo" placeholder="Ej:el_mas_pro_del_mundo@algopuntocom.com" required>
                    </div>
                    <div class="mb-3">
                        <label for="red_social" class="form-label">Red Social</label>
                        <select class="form-select" id="red_social" name="red_social" required>
                            <option value="" selected disabled>Selecciona una opción...</option>
                            <option value="Feisbuk">facebook</option>
                            <option value="instagram">instagram</option>
                            <option value="twitter">twitter</option>
                            <option value="tistos">tistos</option>
                            <option value="tutube">tutube</option>
                        </select>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="layout/footer.jsp" %>