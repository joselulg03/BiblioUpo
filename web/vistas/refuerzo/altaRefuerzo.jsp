<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portatil-Alta</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <!-- Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="../../js/form.js" type="text/javascript"></script>
        <link href="../../css/form.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Alta Refuerzo</h1>
            <s:form action="altaRefuerzo" method="post">
                <div class="form-group">
                    <s:label for="id" value="ID:" />
                    <s:textfield name="id" id="id" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="asignatura" value="Asignatura:" />
                    <s:textfield name="asignatura" id="asignatura" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="descripcion" value="Descripcion:" />
                    <s:textfield name="descripcion" id="descripcion" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="dniUsuario" value="Usuario:" />
                    <s:select name="dniUsuario" list="usuarios" listKey="dni" listValue="nombre" cssClass="form-control" headerKey="" headerValue="Selecciona un usuario:"/>
                </div>
                <div class="form-group">
                    <s:label for="nombreSala" value="Sala:" />
                    <s:select name="nombreSala" list="salas" listKey="nombre" listValue="nombre" cssClass="form-control" headerKey="" headerValue="Selecciona una sala:"/>
                </div>
                <div class="form-group">
                    <s:label for="tipo" value="Tipo:" />
                    <s:textfield name="tipo" id="tipo" cssClass="form-control" />
                </div>
                    <s:submit cssClass="btn btn-primary" value="Guardar" />
            </s:form>
        </div>
    </body>
</html>

