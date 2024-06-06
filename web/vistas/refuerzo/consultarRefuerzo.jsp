<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <meta name="keywords" content="">
        <meta name="description" content="">
        <meta name="author" content="">
        <!-- bootstrap css -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- style css -->
        <link rel="stylesheet" href="css/style.css">
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
        <title>Refuerzo</title>
    </head>
    <body>
        <h1>Refuerzo</h1>
        <div class="container">
            <h2>ID</h2>
            <p><s:property value="refuerzo.id" /></p>
        </div>
        <div class="container">
            <h2>Asignatura</h2>
            <p><s:property value="refuerzo.asignatura" /></p>
        </div>
        <div class="container">
            <h2>Descripcion</h2>
            <p><s:property value="refuerzo.descripcion" /></p>
        </div>
        <div class="container">
            <h2>Tipo</h2>
            <p><s:property value="refuerzo.tipo" /></p>
        </div>
        <div class="container">
            <h2>Usuario</h2>
            <p><s:property value="refuerzo.dniUsuario.nombre" /><s:property value="refuerzo.dniUsuario.apellido" /></p>
        </div>
        <div class="container">
            <h2>Sala</h2>
            <p><s:property value="refuerzo.nombreSala.nombre" /></p>
        </div>
        <div class="container">
            <h2>¿Disponible?</h2>
            <p><s:property value="refuerzo.idRecurso.disponible" /></p>
        </div>
    </body>
</html>

