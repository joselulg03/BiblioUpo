<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UPO-Login</title>
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
        <link rel="stylesheet" href="css/style.css">
        <!-- Responsive-->
        <link rel="stylesheet" href="css/responsive.css">
        <link rel="stylesheet" href="css/owl.carousel.min.css">
        <!-- fevicon -->
        <link rel="icon" href="images/fevicon.png" type="image/gif" />
        <!-- Scrollbar Custom CSS -->
        <link rel="stylesheet" href="css/jquery.mCustomScrollbar.min.css">
        <!-- Tweaks for older IEs-->
        <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/fancybox/2.1.5/jquery.fancybox.min.css" media="screen">
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
    </head>
    <body class="main-layout">

        <section class="contact">
            <h1>Login</h1>
            <s:form action="iniciarSesion" method="post">
                <s:textfield label="Correo Electrónico" name="correo" cssClass="contact_control" />
                <s:password label="Contraseña" name="password" />
                <s:submit value="Iniciar Sesión" />
            </s:form>
            <a href="landing.jsp"><h2>Volver</h2></a>
        </section>
    </body>
</html>--%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
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
        <style>
            .btn-color{
                background-color: #0e1c36;
                color: #fff;

            }

            .profile-image-pic{
                height: 200px;
                width: 200px;
                object-fit: cover;
            }



            .cardbody-color{
                background-color: #ebf2fa;
            }

            a{
                text-decoration: none;
            }
        </style>
    </head>
    <%--<body>
        <div class="container">
            <h1>Login</h1>
            <s:form action="iniciarSesion" method="post">
                <s:textfield label="Correo" name="correo" />
                <s:password label="Contraseña" name="password" />
                <s:submit value="Iniciar Sesión" />
            </s:form>
            <a href="landing.jsp"><h2>Volver</h2></a>
        </div>
    </body>--%>
    <body>
        <div class="container">
            <h1 class="text-center text-dark mt-5">Iniciar Sesión</h1>
            <div class="card my-5">
                <form class="card-body cardbody-color p-lg-5" action="iniciarSesion" method="post">

                    <div class="text-center">
                        <img src="images/upo2.png"
                             class="img-fluid profile-image-pic img-thumbnail rounded-circle my-3" width="200px"
                             alt="profile">
                    </div>

                    <div class="mb-3">
                        <input type="text" class="form-control" id="Username" aria-describedby="emailHelp"
                               placeholder="Correo" name="correo">
                    </div>

                    <div class="mb-3">
                        <input type="password" class="form-control" id="password" placeholder="Contraseña"
                               name="password">
                    </div>

                    <div class="text-center">
                        <button type="submit" class="btn btn-color px-5 mb-5 w-100">Iniciar Sesión</button>
                    </div>
                </form>
            </div>
        </div>
    </body>

</html>

