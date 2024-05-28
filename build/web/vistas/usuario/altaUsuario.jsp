<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario-Alta</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Alta Usuario</h1>
            <s:form action="altaUsuario" method="post">
                <div class="form-group">
                    <label for="dni">DNI</label>
                    <s:textfield name="dni" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <s:textfield name="nombre" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="apellidos">Apellidos</label>
                    <s:textfield name="apellidos" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="fechaNacimiento">Fecha de Nacimiento</label>
                    <s:textfield name="fechaNacimiento" type="date" class="form-control" />
                </div>
                <div class="form-group">
                    <label>Rol</label>
                    <s:select name="idRol" 
                              list="roles" 
                              listKey="id" 
                              listValue="tipo" 
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona un rol"/>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña</label>
                    <s:password name="password" class="form-control" />
                </div>
                <button type="submit" class="btn btn-primary">Guardar</button>
            </s:form>
        </div>

        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
