<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Reserva - Alta</title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <link href="../../css/form.css" rel="stylesheet" type="text/css"/>
    
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <!-- Custom JS -->
    <script src="../../js/form.js" type="text/javascript"></script>

    <style>
        body {
            background-color: #f8f9fa;
            font-family: Arial, sans-serif;
        }
        .container {
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            max-width: 600px;
            margin: 40px auto;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
        .btn-secondary {
            background-color: #6c757d;
            border: none;
        }
        .btn-secondary:hover {
            background-color: #5a6268;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Alta Reserva</h1>
        <s:form action="altaReserva" method="post">
            <div class="form-group">
                <s:label for="fecha" value="Fecha de Reserva" />
                <s:textfield name="fecha" type="date" id="fecha" cssClass="form-control" />
            </div>
            <div class="form-group">
                <s:label for="duracionHoras" value="Duración en Horas" />
                <s:textfield name="duracionHoras" id="duracionHoras" cssClass="form-control" />
            </div>
            <div class="form-group">
                <s:label for="idRecurso" value="Recurso" />
                <s:select name="idRecurso" list="recursos" listKey="id" listValue="id" cssClass="form-control" headerKey="" headerValue="Selecciona un recurso"/>
            </div>
            <div class="form-group">
                <s:label for="dniUsuario" value="Usuario (DNI)" />
                <s:select name="dniUsuario" list="usuarios" listKey="dni" listValue="dni" cssClass="form-control" headerKey="" headerValue="Selecciona un usuario"/>
            </div>
            <div class="form-group form-check">
                <s:checkbox name="entregado" label="Entregado" cssClass="form-check-input" id="entregado" />
                <label class="form-check-label" for="entregado">Entregado</label>
            </div>
            <div class="text-center">
                <s:submit cssClass="btn btn-primary" value="Guardar" />
            </div>
        </s:form>

        <hr>

        <div class="text-center">
            <a href="listaReservas" class="btn btn-secondary">Volver a la Lista</a>
        </div>
    </div>
</body>
</html>
