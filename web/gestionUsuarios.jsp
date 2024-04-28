<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión Usuarios</title>
    </head>
    <body>
        <h1>Área de Gestión de Usuarios</h1>
        <h2>Rol: <s:property value="rol" /> </h2>

        <s:form action="formGestionUsuario" method="post">
            <s:hidden name="operacion" value="alta" />
            <s:submit value="Alta" />
        </s:form>

        <%--<s:form action="formGestionUsuario" method="post">
            <s:hidden name="operacion" value="baja" />
            <s:submit value="Baja" />
        </s:form>
        
        <s:form action="formGestionUsuario" method="post">
            <s:hidden name="operacion" value="modificacion" />
            <s:submit value="Modificar" />
        </s:form>
        
        <s:form action="formGestionUsuario" method="post">
            <s:hidden name="operacion" value="consulta" />
            <s:submit value="Consultar" />
        </s:form>
        
        <s:form action="formGestionUsuario" method="post">
            <s:hidden name="operacion" value="lista" />
            <s:submit value="Listar" />
        </s:form>--%>

        <s:if test="usuarios != null">
            <table border="1">
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
                                <s:form action="formGestionUsuario" method="post">
                                    <s:hidden name="operacion" value="baja" />
                                    <s:submit value="Baja" />
                                </s:form>

                                <s:form action="formGestionUsuario" method="post">
                                    <s:hidden name="operacion" value="modificacion" />
                                    <s:submit value="Modificar" />
                                </s:form>

                                <s:form action="formGestionUsuario" method="post">
                                    <s:hidden name="operacion" value="consulta" />
                                    <s:submit value="Consultar" />
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
    </body>
</html>
