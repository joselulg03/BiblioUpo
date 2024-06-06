<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Gestión de Reservas</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Favicon -->
    <link rel="icon" href="images/upo2.png" type="image/gif" />

    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            padding: 20px;
        }
        h1, h2 {
            text-align: center;
        }
        .btn-group {
            display: flex;
            justify-content: center;
        }
        .btn {
            margin: 5px;
        }
        .no-reservas {
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1 class="mb-4">Área de Gestión de Reservas</h1>
        <h2>Rol: <s:property value="#session.rol.tipo" /></h2>

        <div class="text-center mt-4">
            <s:form action="volverGestionEntidades" method="post" class="d-inline-block mr-2">
                <s:submit value="Volver" cssClass="btn btn-secondary" />
            </s:form>

            <s:if test="#session.rol.tipo.equals('Administrador') || #session.rol.tipo.equals('Empleado')">
                <s:form action="formGestionReserva" method="post" class="d-inline-block">
                    <s:hidden name="operacion" value="formAlta" />
                    <s:submit value="Crear Reserva" cssClass="btn btn-primary" />
                </s:form>
            </s:if>
        </div>

        <s:if test="reservas != null">
            <table class="table mt-4">
                <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Fecha</th>
                        <th scope="col">Duración (Horas)</th>
                        <th scope="col">Entregado</th>
                        <th scope="col">Recurso</th>
                        <th scope="col">Usuario</th>
                        <th scope="col">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="reservas">
                        <tr>
                            <td><s:property value="id" /></td>
                            <td><s:property value="fecha" /></td>
                            <td><s:property value="duracionHoras" /></td>
                            <td><s:if test="entregado">Sí</s:if>
                                <s:else>No</s:else></td>
                            <td><s:property value="idRecurso.id" /></td>
                            <td><s:property value="dniUsuario.dni" /></td>
                            <td class="btn-group">
                                <s:if test="#session.rol.tipo.equals('Administrador')">
                                    <s:form action="bajaReserva" method="post" class="d-inline-block mr-2">
                                        <s:hidden name="id" value="%{id}" />
                                        <s:submit value="Eliminar" cssClass="btn btn-danger" />
                                    </s:form>
                                </s:if>

                                <s:if test="#session.rol.tipo.equals('Administrador') || #session.rol.tipo.equals('Empleado') || #session.rol.tipo.equals('Profesor')">
                                    <s:form action="formGestionReserva" method="post" class="d-inline-block mr-2">
                                        <s:hidden name="id" value="%{id}" />
                                        <s:hidden name="operacion" value="formModificacion" />
                                        <s:submit value="Modificar" cssClass="btn btn-warning" />
                                    </s:form>
                                </s:if>

                                <s:form action="consultarReserva" method="post" class="d-inline-block">
                                    <s:hidden name="id" value="%{id}" />
                                    <s:submit value="Consultar" cssClass="btn btn-info" />
                                </s:form>
                            </td>
                        </tr>
                    </s:iterator>
                </tbody>
            </table>
        </s:if>
        <s:else>
            <p class="no-reservas">No hay reservas que mostrar.</p>
        </s:else>
    </div>
</body>
</html>
