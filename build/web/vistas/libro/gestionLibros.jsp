<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión Libros</title>
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
        <link rel="stylesheet" href="css/templatemo.css">
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
        <h1>Área de Gestión de Libros</h1>

        <s:if test="#session.rol.tipo.equals('Administrador')">
            <div>
                <h2>Administrador</h2>
                <s:form method="post" action="formGestionLibro">
                    <s:hidden name="operacion" value="alta" />
                    <s:submit value="Dar de alta un libro" />
                </s:form>
            </div>       
        </s:if>

        <h2>Buscar</h2>
        <s:form action="filtrarLibro" method="post">
            <s:textfield name="filtro" />
            <s:select label="Filtrar por" name="seleccion" list="{'Titulo', 'Autor', 'Editorial'}"/>
            <s:submit value="Buscar" />
        </s:form>

        <hr>

        <s:if test="libros != null || libro != null">
            <div class="row">
                <s:iterator value="libros" var="libro">
                    <div class="col-md-4">
                        <div class="card mb-4 product-wap rounded-0">
                            <div class="card rounded-0">
                                <img class="card-img rounded-4 img-fluid" src="images/<s:property value="#libro.isbn" />.jpg" />
                                <div class="card-body">
                                    <p class="h3 text-decoration-none"><strong>ISBN: </strong><s:property value="#libro.isbn" /></p>
                                    <p><strong>Titulo: </strong><s:property value="#libro.titulo" /></p>
                                    <p><strong>Descripción: </strong><s:property value="#libro.descripcion" /></p>
                                    <p><strong>Autor: </strong><s:property value="#libro.autor.nombre" /></p>
                                    <p><strong>Categoría: </strong><s:property value="#libro.categoria.nombre" /></p>
                                    <p><strong>Editorial: </strong><s:property value="#libro.editorial.nombre" /></p>
                                    <p><strong>Idioma: </strong><s:property value="#libro.idioma.nombre" /></p>
                                    <p><strong>Recurso disponible: </strong><s:property value="#libro.recurso.disponible" /></p>
                                    <p><strong>Fecha lanzamiento: </strong><s:property value="#libro.fecha" /></p>
                                    <p><strong>Cantidad disponible: </strong><s:property value="#libro.cantidad" /></p>
                                    <s:if test="%{#libro.cantidad > 0}">
                                        <s:form action="altaReserva" method="post" cssClass="list-unstyled d-flex justify-content-center mb-1">
                                            <s:hidden name="idRecurso" value="%{#libro.recurso.id}" />
                                            <s:submit value="Reservar" cssClass="text-center mb-0" />
                                        </s:form>
                                    </s:if>
                                    <s:if test="#session.rol.tipo.equals('Administrador')">
                                        <s:form action="bajaLibro" method="post" cssClass="list-unstyled d-flex justify-content-center mb-1">
                                            <s:hidden name="isbnLibro" value="%{#libro.isbn}" />
                                            <s:submit value="Borrar" cssClass="text-center mb-0" />
                                        </s:form>
                                        <s:form action="formGestionLibro" method="post" cssClass="list-unstyled d-flex justify-content-center mb-1">
                                            <s:hidden name="isbnLibro" value="%{#libro.isbn}" />
                                            <s:hidden name="operacion" value="modificacion" />
                                            <s:submit value="Modificar" cssClass="text-center mb-0" />
                                        </s:form>
                                    </s:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </div>
        </s:if>

        <s:url action="volverGestionEntidades" var="url" />
        <h5><a href="${url}"/>Volver</h5>
    </body>
</html>
