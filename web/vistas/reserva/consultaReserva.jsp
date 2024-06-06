<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Detalles de la Reserva - <s:property value="reserva.id" /></title>
    
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Custom CSS -->
    <link href="../../css/form.css" rel="stylesheet" type="text/css"/>
    <link rel="icon" href="images/upo2.png" type="image/gif" />
    
    <!-- Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

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
            max-width: 800px;
            margin: 40px auto;
        }
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn-warning {
            background-color: #ffc107;
            border: none;
        }
        .btn-warning:hover {
            background-color: #e0a800;
        }
        .btn-primary {
            background-color: #007bff;
            border: none;
        }
        .btn-primary:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Detalles de la Reserva con ID: <s:property value="reserva.id" /></h1>
        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <label>Fecha de Reserva:</label>
                    <p class="form-control-plaintext"><s:property value="reserva.fecha" /></p>
                </div>
                <div class="form-group">
                    <label>Duración en Horas:</label>
                    <p class="form-control-plaintext"><s:property value="reserva.duracionHoras" /></p>
                </div>
                <div class="form-group">
                    <label>Recurso:</label>
                    <p class="form-control-plaintext"><s:property value="reserva.recurso.id" /></p>
                </div>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <label>Usuario (DNI):</label>
                    <p class="form-control-plaintext"><s:property value="reserva.usuario.dni" /></p>
                </div>
                <div class="form-group">
                    <label>Nombre del Usuario:</label>
                    <p class="form-control-plaintext"><s:property value="reserva.usuario.nombre" /></p>
                </div>
                <div class="form-group">
                    <label>Entregado:</label>
                    <p class="form-control-plaintext">
                        <s:if test="reserva.entregado">Sí</s:if>
                        <s:else>No</s:else>
                    </p>
                </div>
            </div>
        </div>
        <div class="text-center">
            <s:form action="formGestionReserva" method="post" class="d-inline-block mr-2">
                <s:hidden name="id" value="reserva.id" />
                <s:hidden name="operacion" value="formModificacion" />
                <s:submit value="Modificar" cssClass="btn btn-warning" />
            </s:form>
            <a href="listaReservas" class="btn btn-primary">Volver a la Lista</a>
        </div>
    </div>
</body>
</html>
