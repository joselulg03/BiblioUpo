<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario-Alta</title>
    </head>
    <body>
        <h1>Alta Usuario</h1>
        <s:form action="altaUsuario" method="post">
            <s:textfield label="DNI" name="dni" />
            <s:textfield label="Nombre" name="nombre" />
            <s:textfield label="Apellidos" name="apellidos" />
            <s:textfield label="Correo" name="correo" />
            <s:textfield label="Fecha de Nacimiento" name="fechaNacimiento" type="date" />
            <s:password label="Contraseña" name="password" />
            <s:submit value="Guardar" />
        </s:form>
    </body>
</html>
