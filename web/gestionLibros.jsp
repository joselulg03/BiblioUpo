<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión Libros</title>
    </head>
    <body>
        <h1>Área de Gestión de Libros</h1>
        
        <s:form action="volverGestionEntidades" method="post">
            <s:submit value="Volver" />
        </s:form>
        
        <s:url action="volverGestionEntidades" var="url" />
        <h5><a href="${url}"/>Volver</h5>
    </body>
</html>
