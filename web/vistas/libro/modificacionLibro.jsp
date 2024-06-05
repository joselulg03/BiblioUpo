<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Usuario - <s:property value="usuario.dni" /></title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- style css -->
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <!-- fevicon -->
        <link rel="icon" href="images/upo2.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <body>
        <h1>Modificación del Libro con ISBN: <s:property value="libro.isbn" /></h1>
        <div class="container">
            <s:form action="modificacionLibro" method="post">
                <s:hidden name="isbn" value="%{libro.isbn}" />
                <div class="form-group">
                    <s:label for="isbnLibro" value="ISBN" />
                    <s:textfield name="isbnLibro" id="isbnLibro" value="%{libro.isbn}" disabled="true" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="titulo" value="Título" />
                    <s:textfield name="titulo" id="titulo" value="%{libro.titulo}" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="descripcion" value="Descripción" />
                    <s:textfield name="descripcion" id="descripcion" value="%{libro.descripcion}" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="cantidad" value="Cantidad" />
                    <s:textfield name="cantidad" id="cantidad" value="%{libro.cantidad}" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="fecha" value="Fecha de Lanzamiento" />
                    <s:textfield name="fecha" id="fecha" value="%{libro.fecha}" type="date" class="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="disponible" value="Disponible" />
                    <s:radio name="disponible" list="#{'true':'Sí', 'false':'No'}" value="%{libro.idRecurso.disponible}"  />
                </div>
                <div class="form-group">
                    <s:label for="idAutor" value="Autor" />
                    <s:select name="idAutor" list="autores" listKey="id" listValue="nombre" value="%{libro.idAutor.id}" cssClass="form-control" headerKey="" headerValue="Selecciona un autor"/>
                </div>
                <div class="form-group">
                    <s:label for="idEditorial" value="Editorial" />
                    <s:select name="idEditorial" list="editoriales" listKey="id" listValue="nombre" value="%{libro.idEditorial.id}" cssClass="form-control" headerKey="" headerValue="Selecciona una editorial"/>
                </div>
                <div class="form-group">
                    <s:label for="idCategoria" value="Categoría" />
                    <s:select name="idCategoria" list="categorias" listKey="id" listValue="nombre" value="%{libro.idCategoria.id}" cssClass="form-control" headerKey="" headerValue="Selecciona una categoría"/>
                </div>
                <div class="form-group">
                    <s:label for="idIdioma" value="Idioma" />
                    <s:select name="idIdioma" list="idiomas" listKey="id" listValue="nombre" value="%{libro.idIdioma.id}" cssClass="form-control" headerKey="" headerValue="Selecciona un idioma"/>
                </div>
                <s:submit value="Guardar" cssClass="btn btn-primary"/>
            </s:form>

            <hr>

            <h1>Subir Imagen del Libro con ISBN: <s:property value="%{libro.isbn}" /></h1>
            <s:form action="subirImagen" method="post" enctype="multipart/form-data">
                <s:hidden name="isbnLibro" value="%{libro.isbn}" />
                    <div class="form-group">
                        <label for="imagen">Seleccione la imagen:</label>
                        <input type="file" name="imagen" id="imagen" cssClass="form-control">
                    </div>
                    <s:submit value="Subir" cssClass="btn btn-primary" />
            </s:form>
        </div>
    </body>
</html>
