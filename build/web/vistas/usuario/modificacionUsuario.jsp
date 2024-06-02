<%--<%@taglib prefix="s" uri="/struts-tags" %>
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

                <div class="form-group">
                    <label>Autor</label>
                    <s:select name="idAutor" 
                              list="autores" 
                              listKey="id" 
                              listValue="nombre" 
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
                              class="form-control" 
                              headerKey="" 
                              headerValue="Selecciona un idioma"/>
                </div>
                <s:submit value="Guardar" />
            </s:form>
        </div>
    </body>
</html>--%>


<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar Usuario - <s:property value="usuario.dni" /></title>
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
                <s:hidden name="operacion" value="modificacion" />
                <div class="form-group">
                    <s:label for="dniUsuario" value="DNI" />
                    <s:textfield name="dniUsuario" id="dniUsuario" value="%{usuario.dni}" disabled="true" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="nombre" value="Nombre" />
                    <s:textfield name="nombre" id="nombre" value="%{usuario.nombre}" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="apellidos" value="Apellidos" />
                    <s:textfield name="apellidos" id="apellidos" value="%{usuario.apellidos}" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="fechaNacimiento" value="Fecha de Nacimiento" />
                    <s:textfield name="fechaNacimiento" id="fechaNacimiento" value="%{usuario.fechaNacimiento}" type="date" cssClass="form-control" />
                </div>
                <div class="form-group">
                    <s:label for="idRol" value="Rol" />
                    <s:select name="idRol" list="roles" listKey="id" listValue="tipo" cssClass="form-control" value="%{usuario.rol.id}" headerValue="Selecciona un rol"/>
                </div>
                <div class="form-group">
                    <s:label for="password" value="Contraseña" />
                    <s:textfield name="password" id="password" value="%{usuario.password}" cssClass="form-control" />
                </div>

                    <s:submit value="Guardar" cssClass="btn btn-primary" />
            </s:form>
        </div>
    </body>
</html>
