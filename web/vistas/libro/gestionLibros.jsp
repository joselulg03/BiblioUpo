<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Gestión Libros</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/templatemo.css">
    <link rel="stylesheet" href="css/responsive.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="icon" href="images/upo2.png" type="image/gif" />
    <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link href="../../css/cards.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <h1>Área de Gestión de Libros</h1>

    <s:if test="#session.rol.tipo.equals('Administrador')">
        <div>
            <h2>Administrador</h2>
            <s:form method="post" action="formGestionLibro">
                <s:hidden name="operacion" value="alta" />
                <s:submit value="Dar de alta un libro" cssClass="btn btn-primary" />
            </s:form>
        </div>
    </s:if>

    <h2>Buscar</h2>
    <s:form action="filtrarLibro" method="post">
        <s:textfield name="filtro" />
        <s:select label="Filtrar por" name="seleccion" list="{'Titulo', 'Autor', 'Editorial'}" />
        <s:submit value="Buscar" cssClass="btn btn-primary" />
    </s:form>

    <hr>

    <s:if test="libros != null || libro != null">
        <div class="container mx-auto mt-4">
            <div class="row">
                <s:iterator value="libros" var="libro">
                    <div class="col-md-4">
                        <div class="card" style="width: 18rem;">
                            <img class="card-img-top" src="images/<s:property value="#libro.isbn" />.jpg" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title"><s:property value="#libro.titulo" /></h5>
                                <p class="card-text"><strong>ISBN: </strong><s:property value="#libro.isbn" /></p>
                                <p class="card-text"><strong>Descripción: </strong><s:property value="#libro.descripcion" /></p>
                                <p class="card-text"><strong>Autor: </strong><s:property value="#libro.autor.nombre" /></p>
                                <p class="card-text"><strong>Categoría: </strong><s:property value="#libro.categoria.nombre" /></p>
                                <p class="card-text"><strong>Editorial: </strong><s:property value="#libro.editorial.nombre" /></p>
                                <p class="card-text"><strong>Idioma: </strong><s:property value="#libro.idioma.nombre" /></p>
                                <p class="card-text"><strong>Recurso disponible: </strong><s:property value="#libro.recurso.disponible" /></p>
                                <p class="card-text"><strong>Fecha lanzamiento: </strong><s:property value="#libro.fecha" /></p>
                                <p class="card-text"><strong>Cantidad disponible: </strong><s:property value="#libro.cantidad" /></p>
                                <s:if test="%{#libro.cantidad > 0}">
                                    <s:form action="altaReserva" method="post" cssClass="list-unstyled d-flex justify-content-center mb-1">
                                        <s:hidden name="idRecurso" value="%{#libro.recurso.id}" />
                                        <s:hidden name="dniUsuario" value="%{#session.usuario.dni}" />
                                        <s:hidden name="fecha" value="<s:date name='%{#attr.now}' format='yyyy-MM-dd' />" />
                                        <s:hidden name="duracionHoras" value="2" />
                                        <s:submit value="Reservar" cssClass="btn btn-info" />
                                    </s:form>
                                </s:if>
                                <s:if test="#session.rol.tipo.equals('Administrador')">
                                    <s:form action="bajaLibro" method="post" cssClass="list-unstyled d-flex justify-content-center mb-1">
                                        <s:hidden name="isbnLibro" value="%{#libro.isbn}" />
                                        <s:submit value="Borrar" cssClass="btn btn-danger mr-2" />
                                    </s:form>
                                    <s:form action="formGestionLibro" method="post" cssClass="list-unstyled d-flex justify-content-center mb-1">
                                        <s:hidden name="isbnLibro" value="%{#libro.isbn}" />
                                        <s:hidden name="operacion" value="modificacion" />
                                        <s:submit value="Modificar" cssClass="btn btn-warning mr-2" />
                                    </s:form>
                                </s:if>
                            </div>
                        </div>
                    </div>
                </s:iterator>
            </div>
        </div>
    </s:if>

    <s:url action="volverGestionEntidades" var="url" />
    <h5><a href="${url}"/>Volver</h5>
</body>
</html>