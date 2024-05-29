<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Usuario - <s:property value="usuario.dni" /></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>webwing</title>
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
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
                <s:textfield label="ISBN" name="isbnLibro" value="%{libro.isbn}" disabled="true" />
                <s:textfield label="Titulo" name="titulo" value="%{libro.titulo}" />
                <s:textfield label="Descripción" name="descripcion" value="%{libro.descripcion}" />
                <s:textfield label="Cantidad" name="cantidad" value="%{libro.cantidad}" />
                <s:textfield label="Fecha de Lanzamiento" name="fecha" value="%{libro.fecha}" type="date" />
                <div class="form-group">
                    <label>Disponible</label>
                    <s:radio name="disponible"
                             list="#{'true':'Sí', 'false':'No'}"
                             value="%{libro.recurso.disponible}" />
                </div>
                <div class="form-group">
                    <label>Autor</label>
                    <s:select name="idAutor" 
                              list="autores" 
                              listKey="id" 
                              listValue="nombre" 
                              value="%{libro.autor.id}" 
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona un autor"/>
                </div>
                <div class="form-group">
                    <label>Editorial</label>
                    <s:select name="idEditorial" 
                              list="editoriales" 
                              listKey="id" 
                              listValue="nombre" 
                              value="%{libro.editorial.id}" 
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona una editorial"/>
                </div>
                <div class="form-group">
                    <label>Categoría</label>
                    <s:select name="idCategoria" 
                              list="categorias" 
                              listKey="id" 
                              listValue="nombre" 
                              value="%{libro.categoria.id}" 
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona una categoría"/>
                </div>
                <div class="form-group">
                    <label>Idioma</label>
                    <s:select name="idIdioma" 
                              list="idiomas" 
                              listKey="id" 
                              listValue="nombre" 
                              value="%{libro.idioma.id}" 
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona un idioma"/>
                </div>
                <s:submit value="Guardar" />
            </s:form>
        </div>
    </body>
</html>
