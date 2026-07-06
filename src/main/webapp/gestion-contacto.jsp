<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ include file="layout/header.jsp" %>
<div class="row g-4">
    <div class="col-12">
        <h1 class="mb-4">Gestion de contactos</h1>
    </div>

    <div class="col-md-7">
        <div class="row">
            <h4 class="text-secondary col-6">Contactos registrados</h4>
            <a href="contacto" class="btn btn-primary col-6 align-content-center text-center carga">
                <i class="bi bi-arrow-clockwise"></i> Cargar contactos
            </a>
        </div>

        <c:choose>
            <c:when test="${empty listaContacto}">
                <div class="alert alert-info text-center mt-4" role="alert">
                    <i class="bi bi-info-circle-fill"></i> No hay contactos registrados en este momento.
                </div>
            </c:when>

            <c:otherwise>
                <div class="table-responsive">
                    <table class="table table-striped table-hover mt-4 align-middle">
                        <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Telefono</th>
                            <th>Telefono alternativo</th>
                            <th>Correo electronico</th>
                            <th>Red social</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${listaContacto}" var="contacto">
                            <tr>
                                <td><strong>${contacto.id}</strong></td>
                                <td>${contacto.nombre}</td>
                                <td><span class="badge bg-secondary">${contacto.apellidos}</span></td>
                                <td>${contacto.telefono}</td>
                                <td>${contacto.telefono_alternativo}</td>
                                <td>${contacto.correo}</td>
                                <td>${contacto.red_social}</td>
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
                <h4 class="card-title text-primary mb-4">
                    <i class="bi bi-plus-circle-fill"></i> Registra un contacto
                </h4>

                <form action="contacto" method="POST">
                    <input type="hidden" name="action" value="create">

                    <div class="mb-3">
                        <label for="nombre" class="form-label">Nombre del contacto</label>
                        <input type="text" class="form-control" id="nombre" name="nombre" placeholder="Ej: Rodrigo Adrian" required>
                    </div>

                    <div class="mb-3">
                        <label for="apellidos" class="form-label">Apellidos</label>
                        <input type="text" class="form-control" id="apellidos" name="apellidos" placeholder="Ej: Soto Sanchez" required>
                    </div>

                    <div class="mb-3">
                        <label for="telefono" class="form-label">Telefono</label>
                        <input type="number" class="form-control" id="telefono" name="telefono" placeholder="Ej: 7775329234" required>
                    </div>

                    <div class="mb-3">
                        <label for="telefono_alternativo" class="form-label">Telefono alternativo</label>
                        <input type="text" class="form-control" id="telefono_alternativo" name="telefono_alternativo" placeholder="Ej: 777225911">
                    </div>

                    <div class="mb-3">
                        <label for="correo" class="form-label">Correo electronico</label>
                        <input type="email" class="form-control" id="correo" name="correo" placeholder="Ej: ejemplo@correo.com" required>
                    </div>

                    <div class="mb-3">
                        <label for="red_social" class="form-label">Red social</label>
                        <select class="form-select" id="red_social" name="red_social" required>
                            <option value="" selected disabled>Selecciona una opcion...</option>
                            <option value="facebook">Facebook</option>
                            <option value="instagram">Instagram</option>
                            <option value="twitter">Twitter</option>
                            <option value="tiktok">TikTok</option>
                            <option value="youtube">YouTube</option>
                        </select>
                    </div>

                    <button type="submit" class="btn btn-primary carga">Guardar contacto</button>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="layout/footer.jsp" %>
