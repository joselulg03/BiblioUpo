<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión Salas</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="icon" href="images/upo2.png" type="image/gif" />
        <!-- Custom CSS -->
        <style>
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #f2f2f2;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <h1>Área de Gestión de Salas</h1>
            <h2>Rol: <s:property value="#session.rol.tipo" /></h2>


            <s:if test="#session.rol.tipo.equals('Administrador')">
                <s:form action="formGestionSala" method="post" class="form-inline">
                    <s:hidden name="operacion" value="alta" />
                    <s:submit value="Alta" cssClass="btn btn-primary mr-2" />
                </s:form>
            </s:if>
            <s:form action="volverGestionEntidades" method="post">
                <s:submit value="Volver" cssClass="btn btn-secondary mt-3" />
            </s:form>

            <h2>Buscar</h2>
            <s:form action="filtrarSala" method="post">
                <s:textfield name="filtro" />
                <s:select label="Filtrar por" name="aforo" list="{'1', '2', '3'}" />
                <s:submit value="Buscar" cssClass="btn btn-primary" />
            </s:form>

            <hr>
            <s:if test="salas != null">
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                        </tr>
                        <tr>
                            <th>Aforo</th>
                        </tr>
                    </thead>

                    <tbody>
                        <s:iterator value="salas">
                            <tr>
                                <td><s:property value="nombre" /></td>
                                <td><s:property value="aforo" /></td>
                                <td>
                                    <s:if test="#session.rol.tipo.equals('Administrador')">
                                        <s:form action="bajaSala" method="post" cssClass="form-inline">
                                            <s:hidden name="nombre" value="%{nombre}" />
                                            <s:submit value="Baja" cssClass="btn btn-danger mr-2" />
                                        </s:form>

                                        <s:form action="formGestionSala" method="post" cssClass="form-inline">
                                            <s:hidden name="nombre" value="%{nombre}" />
                                            <s:hidden name="operacion" value="modificacion" />
                                            <s:submit value="Modificar" cssClass="btn btn-warning mr-2" />
                                        </s:form>
                                    </s:if>
                                    <s:form action="consultarSala" method="post" cssClass="form-inline">
                                        <s:hidden name="nombre" value="%{nombre}" />
                                        <s:submit value="Consultar" cssClass="btn btn-info" />
                                    </s:form>
                                    <s:if test="%{#libro.cantidad > 0}">
                                        <s:form action="altaReserva" method="post" cssClass="list-unstyled d-flex justify-content-center mb-1">
                                            <s:hidden name="idRecurso" value="%{sala.recurso.id}" />
                                            <s:submit value="Reservar" cssClass="text-center mb-0" />
                                        </s:form>
                                    </s:if>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                <p>No hay salas que mostrar.</p>
            </s:else>


        </div>

        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>