<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libro-Alta</title>
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
            <h1>Alta Libro</h1>
            <s:form action="altaLibro" method="post">
                <div class="form-group">
                    <s:label for="isbn" value="ISBN" />
                    <s:textfield name="isbn" id="isbn" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="titulo" value="Título" />
                    <s:textfield name="titulo" id="titulo" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="descripcion" value="Descripción" />
                    <s:textfield name="descripcion" id="descripcion" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="cantidad" value="Cantidad" />
                    <s:textfield name="cantidad" id="cantidad" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="fecha" value="Fecha de Lanzamiento" />
                    <s:textfield name="fecha" type="date" id="fecha" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="idAutor" value="Autor" />
                    <s:select name="idAutor" list="autores" listKey="id" listValue="nombre" cssClass="form-control" headerKey="" headerValue="Selecciona un autor"/>
                </div>
                <div class="form-group">
                    <s:label for="idEditorial" value="Editorial" />
                    <s:select name="idEditorial" list="editoriales" listKey="id" listValue="nombre" cssClass="form-control" headerKey="" headerValue="Selecciona una editorial"/>
                </div>
                <div class="form-group">
                    <s:label for="idCategoria" value="Categoría" />
                    <s:select name="idCategoria" list="categorias" listKey="id" listValue="nombre" cssClass="form-control" headerKey="" headerValue="Selecciona una categoría"/>
                </div>
                <div class="form-group">
                    <s:label for="idIdioma" value="Idioma" />
                    <s:select name="idIdioma" list="idiomas" listKey="id" listValue="nombre" cssClass="form-control" headerKey="" headerValue="Selecciona un idioma"/>
                </div>
                    <s:submit cssClass="btn btn-primary" value="Guardar" />
            </s:form>
        </div>
    </body>
</html>
