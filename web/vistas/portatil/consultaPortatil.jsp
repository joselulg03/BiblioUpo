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
        <title>Portatil <s:property value="portatil.marca" /> <s:property value="portatil.modelo" /></title>
    </head>
    <body>
        <h1>Portatil <s:property value="portatil.marca" /> <s:property value="portatil.modelo" /></h1>
        <div class="container">
            <h2>Marca</h2>
            <p><s:property value="portatil.marca" /></p>
        </div>
        <div class="container">
            <h2>Modelo</h2>
            <p><s:property value="portatil.modelo" /></p>
        </div>
        <div class="container">
            <h2>Número de serie</h2>
            <p><s:property value="portatil.numSerie" /></p>
        </div>
        <div class="container">
            <h2>Sistema Operativo</h2>
            <p><s:property value="portatil.idSistemaOperativo.nombre" /></p>
        </div>
        <div class="container">
            <h2>Disponible</h2>
            <p><s:property value="portatil.idRecurso.disponible" /></p>
        </div>
    </body>
</html>
