<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Libro-Alta</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h1>Alta Libro</h1>
            <s:form action="altaLibro" method="post">
                <div class="form-group">
                    <label for="isbn">ISBN</label>
                    <s:textfield name="isbn" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="titulo">Título</label>
                    <s:textfield name="titulo" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="descripcion">Descripción</label>
                    <s:textfield name="descripcion" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="cantidad">Cantidad</label>
                    <s:textfield name="cantidad" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="fecha">Fecha de Lanzamiento</label>
                    <s:textfield name="fecha" type="date" class="form-control" />
                </div>
                <div class="form-group">
                    <label for="autor">Autor</label>
                    <s:select name="id" 
                              list="autores" 
                              listKey="id" 
                              listValue="nombre" 
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona un autor"/>
                </div>
                <div class="form-group">
                    <label for="editorial">Editorial</label>
                    <s:select name="id" 
                              list="editoriales" 
                              listKey="id" 
                              listValue="nombre" 
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona una editorial"/>
                </div>
                <div class="form-group">
                    <label for="categoria">Categoría</label>
                    <s:select name="id" 
                              list="categorias" 
                              listKey="id" 
                              listValue="nombre" 
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona una categoría"/>
                </div>
                <div class="form-group">
                    <label for="idioma">Idioma</label>
                    <s:select name="id" 
                              list="idiomas" 
                              listKey="id" 
                              listValue="nombre" 
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona un idioma"/>
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
