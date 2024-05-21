<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sala-Alta</title>
    </head>
    <body>
        <h1>Alta Sala</h1>
        <s:form action="altaSala" method="post">
            <s:textfield label="Nombre" name="nombre" />
            <s:password label="aforo" name="aforo" />
            <s:submit value="Guardar" />
        </s:form>
    </body>
</html>--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sala-Alta</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Alta Sala</h1>
            <s:form action="altaSala" method="post">
                <div class="form-group">
                    <label for="nombre">Nombre</label>
                    <s:textfield name="nombre" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="password">Aforo</label>
                    <s:password name="aforo" class="form-control" />
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

