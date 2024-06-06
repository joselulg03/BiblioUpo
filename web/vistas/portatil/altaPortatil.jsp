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
            <h1>Alta Portatil</h1>
            <s:form action="altaPortatil" method="post">
                <div class="form-group">
                    <s:label for="numSerie" value="Numero de Serie" />
                    <s:textfield name="numSerie" id="numSerie" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="marca" value="Marca" />
                    <s:textfield name="marca" id="marca" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="modelo" value="Modelo" />
                    <s:textfield name="modelo" id="modelo" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="idSistemaOperativo" value="SistemaOperativo" />
                    <s:select name="idSistemaOperativo" list="sistemasOperativos" listKey="id" listValue="nombre" cssClass="form-control" headerKey="" headerValue="Selecciona un sistema operativo"/>
                </div>
                    <s:submit cssClass="btn btn-primary" value="Guardar" />
            </s:form>
        </div>
    </body>
</html>
