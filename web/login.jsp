<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPO-Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <s:form action="iniciarSesion" method="post">
            <s:textfield label="Correo Electrónico" name="correo" />
            <s:password label="Contraseña" name="password" />
            <s:submit value="Iniciar Sesión" />
        </s:form>
    </body>
</html>
