<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión Ordenadores</title>
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
            <h1>Área de Gestión de Ordenadores</h1>
            <h2>Rol: <s:property value="#session.rol.tipo" /></h2>

            <s:form action="volverGestionEntidades" method="post">
                <s:submit value="Volver" cssClass="btn btn-secondary mt-3" />
            </s:form>

            <s:form action="formGestionOrdenador" method="post" class="form-inline">
                <s:hidden name="operacion" value="alta" />
                <s:submit value="Alta" cssClass="btn btn-primary mr-2" />
            </s:form>

            <s:if test="ordenadores != null">
                <table>
                    <thead>
                        <tr>
                            <th>Nombre</th>
                        </tr>
                    </thead>

                    <tbody>
                        <s:iterator value="ordenadores">
                            <tr>
                                <td><s:property value="nombre" /></td>
                                <td>
                                    <s:form action="bajaOrdenador" method="post" cssClass="form-inline">
                                        <s:hidden name="nombre" value="%{nombre}" />
                                        <s:submit value="Baja" cssClass="btn btn-danger mr-2" />
                                    </s:form>

                                    <s:form action="formGestionOrdenador" method="post" cssClass="form-inline">
                                        <s:hidden name="nombre" value="%{nombre}" />
                                        <s:hidden name="operacion" value="modificacion" />
                                        <s:submit value="Modificar" cssClass="btn btn-warning mr-2" />
                                    </s:form>

                                    <s:form action="consultarOrdenador" method="post" cssClass="form-inline">
                                        <s:hidden name="nombre" value="%{nombre}" />
                                        <s:submit value="Consultar" cssClass="btn btn-info" />
                                    </s:form>

                                    <s:form action="altaReserva" method="post" cssClass="list-unstyled d-flex justify-content-center mb-1">
                                        <s:hidden name="idRecurso" value="%{ordenador.recurso.id}" />
                                        <s:submit value="Reservar" cssClass="text-center mb-0" />
                                    </s:form>
                                    
                                                                        <s:form action="altaReserva" method="post" cssClass="list-unstyled d-flex justify-content-center mb-1">
                                        <s:hidden name="idRecurso" value="%{#libro.recurso.id}" />
                                        <s:hidden name="dniUsuario" value="%{#session.usuario.dni}" />
                                        <s:hidden name="fecha" value="<s:date name='%{#attr.now}' format='yyyy-MM-dd' />" />
                                        <s:hidden name="duracionHoras" value="2" />
                                        <s:submit value="Reservar" cssClass="btn btn-info" />
                                    </s:form>
                                    
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                <p>No hay ordenadores que mostrar.</p>
            </s:else>


        </div>

        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>