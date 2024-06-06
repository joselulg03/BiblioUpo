<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Refuerzo</title>
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
        <h1>Modificar Refuerzo</h1>
        <div class="container">
            <s:form action="modificacionRefuerzo" method="post">
                <s:hidden name="id" value="%{refuerzo.id}" />
                <div class="form-group">
                    <s:label for="idRefuerzo" value="ID Refuerzo:" />
                    <s:textfield name="idRefuerzo" id = "idRefuerzo" value="%{refuerzo.id}" />
                </div>
                <div class="form-group">
                    <s:label for="descripcion" value="Descripcion:" />
                    <s:textfield name="descripcion" id = "descripcion" value="%{refuerzo.descripcion}" />
                </div>
                <div class="form-group">
                    <s:label for="asignatura" value="Asignatura:" />
                    <s:textfield name="asignatura" id = "asignatura" value="%{refuerzo.asignatura}" />
                </div>
                <div class="form-group">
                    <s:label for="tipo" value="Tipo:" />
                    <s:textfield name="tipo" id = "tipo" value="%{refuerzo.tipo}" />
                </div>
                <div class="form-group">
                    <s:label for="dniUsuario" value="Usuario: " />
                    <s:select name="dniUsuario" list="usuarios" listKey="dni" listValue="nombre" value="%{refuerzo.dniUsuario.nombre}" cssClass="form-control" headerKey="" headerValue="Selecciona un Usuario"/>
                </div>
                <div class="form-group">
                    <s:label for="nombreSala" value="Sala: " />
                    <s:select name="nombreSala" list="salas" listKey="nombre" listValue="nombre" value="%{refuerzo.nombreSala.nombre}" cssClass="form-control" headerKey="" headerValue="Selecciona una Sala"/>
                </div>
                <div class="form-group">
                    <s:label for="disponible" value="Disponible" />
                    <s:radio name="idRecurso" list="#{'true':'Sí', 'false':'No'}" value="%{portatil.iDrecurso.disponible}"  />
                </div>
                <s:submit value="Guardar" />
            </s:form>
        </div>
    </body>
</html>