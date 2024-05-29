<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión Usuarios</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="icon" href="images/upo2.png" type="image/gif" />
        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
            <h1>Área de Gestión de Usuarios</h1>
            <h2>Rol: <s:property value="#session.rol.tipo" /></h2>

            <s:form action="volverGestionEntidades" method="post">
                <s:submit value="Volver" cssClass="btn btn-secondary mt-3" />
            </s:form>
            
            <s:form action="formGestionUsuario" method="post" class="form-inline">
                <s:hidden name="operacion" value="alta" />
                <s:submit value="Alta" cssClass="btn btn-primary mr-2" />
            </s:form>

            <s:if test="usuarios != null">
                <table>
                    <thead>
                        <tr>
                            <th>DNI</th>
                            <th>Nombre</th>
                            <th>Apellidos</th>
                            <th>Correo</th>
                            <th>Fecha de Nacimiento</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <s:iterator value="usuarios">
                            <tr>
                                <td><s:property value="dni" /></td>
                                <td><s:property value="nombre" /></td>
                                <td><s:property value="apellidos" /></td>
                                <td><s:property value="correo" /></td>
                                <td><s:property value="fechaNacimiento" /></td>
                                <td>
                                    <s:form action="bajaUsuario" method="post" cssClass="form-inline">
                                        <s:hidden name="dni" value="%{dni}" />
                                        <s:submit value="Baja" cssClass="btn btn-danger mr-2" />
                                    </s:form>

                                    <s:form action="formGestionUsuario" method="post" cssClass="form-inline">
                                        <s:hidden name="dni" value="%{dni}" />
                                        <s:hidden name="operacion" value="modificacion" />
                                        <s:submit value="Modificar" cssClass="btn btn-warning mr-2" />
                                    </s:form>

                                    <s:form action="consultarUsuario" method="post" cssClass="form-inline">
                                        <s:hidden name="dni" value="%{dni}" />
                                        <s:submit value="Consultar" cssClass="btn btn-info" />
                                    </s:form>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                <p>No hay usuarios que mostrar.</p>
            </s:else> 
        </div>
    </body>
</html>
