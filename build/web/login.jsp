<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPO-Login</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        
        <section>
            <h1>Login</h1>
            <s:form action="iniciarSesion" method="post">
                <s:textfield label="Correo Electrónico" name="correo" />
                <s:password label="Contraseña" name="password" />
                <s:submit value="Iniciar Sesión" />
            </s:form>
            <a href="landing.jsp"><h2>Volver</h2></a>
        </section>
    </body>
</html>
