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
        <h1>Modificación del Usuario con DNI: <s:property value="usuario.dni" /></h1>
        <div class="container">
            <s:form action="modificacionUsuario" method="post">
                <s:hidden name="dni" value="%{usuario.dni}" />
                <s:textfield label="DNI" name="dniUsuario" value="%{usuario.dni}" disabled="true" />
                <s:textfield label="Nombre" name="nombre" value="%{usuario.nombre}" />
                <s:textfield label="Apellidos" name="apellidos" value="%{usuario.apellidos}" />
                <s:textfield label="Correo" name="correo" value="%{usuario.correo}" />
                <s:textfield label="Fecha de Nacimiento" name="fechaNacimiento" value="%{usuario.fechaNacimiento}" type="date" />
                <s:textfield label="Contraseña" name="password" value="%{usuario.password}" />
                <s:submit value="Guardar" />
            </s:form>
        </div>
    </body>
</html>
