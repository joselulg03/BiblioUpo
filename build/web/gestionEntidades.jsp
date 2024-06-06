<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>Área de Gestión</title>
        
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <!-- Custom CSS -->
        <link rel="stylesheet" href="css/custom.css">
        <!-- FontAwesome -->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <!-- Google Fonts -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Allerta+Stencil&display=swap">
        <!-- Favicon -->
        <link rel="icon" href="images/upo2.png" type="image/gif" />
        
        <!-- jQuery, Popper.js, Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        
        <style>
            body {
                background: #f0f0f0;
                font-family: Arial, sans-serif;
                margin: 0;
                padding: 0;
                height: 100%;
            }
            .full-height {
                height: 100vh;
                display: flex;
                flex-direction: column;
            }
            header {
                background: #343a40;
                color: #fff;
                padding: 20px 0;
                text-align: center;
                font-family: 'Allerta Stencil', sans-serif;
            }
            nav {
                background: #343a40;
            }
            .navbar-dark .navbar-nav .nav-link {
                color: #fff;
            }
            .navbar-brand {
                font-family: 'Allerta Stencil', sans-serif;
                color: #83ff00;
            }
            .navbar-brand:hover {
                color: #fff;
            }
            .navbar-nav .nav-item {
                margin-left: 15px;
            }
            .navbar-nav .nav-item .nav-link {
                font-size: 16px;
                font-weight: bold;
                text-transform: uppercase;
                padding: 8px 15px;
                border-radius: 30px;
                transition: background 0.3s, color 0.3s;
            }
            .navbar-nav .nav-item .nav-link:hover {
                background: #83ff00;
                color: #343a40;
            }
            .btn-danger {
                margin-left: 15px;
            }
            .content {
                flex: 1;
                display: flex;
                justify-content: center;
                align-items: center;
                padding: 20px;
            }
            .content h1 {
                font-family: 'Allerta Stencil', sans-serif;
                font-size: 2.4em;
                text-align: center;
                color: #343a40;
            }
        </style>
    </head>
    <body class="full-height">
        <header>
            <h1>Área de Gestión</h1>
            <h2><s:property value="#session.rol.tipo" />: <s:property value="#session.usuario.nombre" /> <s:property value="#session.usuario.apellidos" /></h2>
        </header>
        
        <nav class="navbar navbar-expand-md navbar-dark">
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarContent" aria-controls="navbarContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarContent">
                <ul class="navbar-nav mr-auto">
                    <s:if test="#session.rol.tipo != 'Estudiante' && #session.rol.tipo != 'Invitado'">
                        <li class="nav-item">
                            <s:form action="gestion" method="post">
                                <s:hidden name="rol" value="%{#session.rol.tipo}" />
                                <s:hidden name="entidad" value="usuarios" />
                                <s:submit value="Usuarios" cssClass="nav-link btn btn-outline-light" />
                            </s:form>
                        </li>
                    </s:if>

                    <s:if test="#session.rol.tipo != 'Invitado'">
                        <li class="nav-item">
                            <s:form action="gestion" method="post">
                                <s:hidden name="rol" value="%{#session.rol.tipo}" />
                                <s:hidden name="entidad" value="libros" />
                                <s:submit value="Libros" cssClass="nav-link btn btn-outline-light" />
                            </s:form>
                        </li>
                    </s:if>

                    <li class="nav-item">
                        <s:form action="gestion" method="post">
                            <s:hidden name="rol" value="%{#session.rol.tipo}" />
                            <s:hidden name="entidad" value="salas" />
                            <s:submit value="Salas" cssClass="nav-link btn btn-outline-light" />
                        </s:form>
                    </li>

                    <li class="nav-item">
                        <s:form action="gestion" method="post">
                            <s:hidden name="rol" value="%{#session.rol.tipo}" />
                            <s:hidden name="entidad" value="ordenadores" />
                            <s:submit value="Ordenadores" cssClass="nav-link btn btn-outline-light" />
                        </s:form>
                    </li>

                    <s:if test="#session.rol.tipo != 'Invitado'">
                        <li class="nav-item">
                            <s:form action="gestion" method="post">
                                <s:hidden name="rol" value="%{#session.rol.tipo}" />
                                <s:hidden name="entidad" value="portatiles" />
                                <s:submit value="Portátiles" cssClass="nav-link btn btn-outline-light" />
                            </s:form>
                        </li>
                    </s:if>

                    <s:if test="#session.rol.tipo != 'Invitado'">
                        <li class="nav-item">
                            <s:form action="gestion" method="post">
                                <s:hidden name="rol" value="%{#session.rol.tipo}" />
                                <s:hidden name="entidad" value="refuerzos" />
                                <s:submit value="Refuerzos" cssClass="nav-link btn btn-outline-light" />
                            </s:form>
                        </li>
                    </s:if>

                    <li class="nav-item">
                        <s:form action="gestion" method="post">
                            <s:hidden name="rol" value="%{#session.rol.tipo}" />
                            <s:hidden name="entidad" value="reservas" />
                            <s:submit value="Reservas" cssClass="nav-link btn btn-outline-light" />
                        </s:form>
                    </li>

                    <li class="nav-item">
                        <s:form action="logout" method="post">
                            <s:submit value="Cerrar Sesión" cssClass="btn btn-danger nav-link" />
                        </s:form>
                    </li>
                </ul>
            </div>
        </nav>
        
        <div class="content">
            <h1>Bienvenido al Área de Gestión</h1>
        </div>
    </body>
</html>

