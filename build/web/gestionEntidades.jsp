<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Área de Gestión</title>
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
    <body class="container">
        <h1><s:property value="#session.rol.tipo" />: <s:property value="#session.usuario.nombre" /> <s:property value="#session.usuario.apellidos" /></h1>

        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarsExample04">
                <ul class="navbar-nav mr-auto">
                    <s:if test="#session.rol.tipo.equals('Estudiante') || #session.rol.tipo.equals('Invitado')">
                        <%-- ROL != Estudiante o Invitado--%>
                    </s:if>
                    <s:else>
                        <li class="nav-item">
                            <s:form action="gestion" method="post">
                                <s:hidden name="rol" value="%{#session.rol.tipo}" />
                                <s:hidden name="entidad" value="usuarios" />
                                <s:submit value="Usuarios" class="nav-link" />
                            </s:form>
                        </li>
                    </s:else>

                    <s:if test="#session.rol.tipo.equals('Invitado')">
                        <%-- ROL != Invitado--%>
                    </s:if>
                    <s:else>
                        <li class="nav-item">
                            <s:form action="gestion" method="post">
                                <s:hidden name="rol" value="%{#session.rol.tipo}" />
                                <s:hidden name="entidad" value="libros" />
                                <s:submit value="Libros" class="nav-link" />
                            </s:form>
                        </li>
                    </s:else>

                    <li class="nav-item">
                        <s:form action="gestion" method="post">
                            <s:hidden name="rol" value="%{#session.rol.tipo}" />
                            <s:hidden name="entidad" value="salas" />
                            <s:submit value="Salas" class="nav-link" />
                        </s:form>
                    </li>

                    <li class="nav-item">
                        <s:form action="gestion" method="post">
                            <s:hidden name="rol" value="%{#session.rol.tipo}" />
                            <s:hidden name="entidad" value="ordenadores" />
                            <s:submit value="Ordenadores" class="nav-link" />
                        </s:form>
                    </li>

                    <s:if test="#session.rol.tipo.equals('Invitado')">
                        <%-- ROL != Invitado--%>
                    </s:if>
                    <s:else>
                        <li class="nav-item">
                            <s:form action="gestion" method="post">
                                <s:hidden name="rol" value="%{#session.rol.tipo}" />
                                <s:hidden name="entidad" value="portatiles" />
                                <s:submit value="Portátiles" class="nav-link" />
                            </s:form>
                        </li>
                    </s:else>

                    <s:if test="#session.rol.tipo.equals('Invitado')">
                        <%-- ROL != Invitado--%>
                    </s:if>
                    <s:else>
                        <li class="nav-item">
                            <s:form action="gestion" method="post">
                                <s:hidden name="rol" value="%{#session.rol.tipo}" />
                                <s:hidden name="entidad" value="refuerzos" />
                                <s:submit value="Refuerzos" class="nav-link" />
                            </s:form>
                        </li>
                    </s:else>

                    <li class="nav-item">
                        <s:form action="gestion" method="post">
                            <s:hidden name="rol" value="%{#session.rol.tipo}" />
                            <s:hidden name="entidad" value="reservas" />
                            <s:submit value="Reservas" class="nav-link" />
                        </s:form>
                    </li>

                    <li class="nav-item">
                        <s:form action="logout" method="post">
                            <button type="submit" class="btn btn-danger">Cerrar Sesión</button>
                        </s:form>
                    </li>
                </ul>
            </div>
        </nav>




        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
