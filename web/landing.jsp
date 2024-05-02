<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <!-- basic -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <!-- mobile metas -->
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="viewport" content="initial-scale=1, maximum-scale=1">
        <!-- site metas -->
        <title>CRAI UPO</title>
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
    </head>
    <!-- body -->

    <body class="main-layout">
        <!-- loader  -->
        <div class="loader_bg">
            <div class="loader"><img src="images/loading.gif" alt="#" /></div>
        </div>
        <!-- end loader -->
        <!-- header -->
        <header>
            <!-- header inner -->
            <div class="header">
                <div class="header_to d_none">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 col-sm-6 ">
                                <ul class="social_icon1">
                                    <li> F0llow Us
                                    </li>
                                    <li> <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i>
                                        </a>
                                    </li>
                                    <li> <a href="#"><i class="fa fa-twitter"></i></a></li>
                                    <li> <a href="#"> <i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                                    <li> <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i>
                                        </a>
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="header_midil">
                    <div class="container">
                        <div class="row d_flex">
                            <div class="col-md-4 col-sm-4 d_none">
                                <ul class="conta_icon">
                                    <li><a href="#"><i class="fa fa-phone" aria-hidden="true"></i> Contacto : 954 34 92 00</a> </li>
                                </ul>
                            </div>
                            <div class="col-md-4 col-sm-4 ">
                                <a class="logo" href="#"><img src="images/upo.png" alt="#" /></a>
                            </div>
                            <div class="col-md-4 col-sm-4 d_none">
                                <ul class="conta_icon ">
                                    <li><a href="#"><i class="fa fa-envelope" aria-hidden="true"></i> upo@upo.es</a> </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="header_bo">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-9 col-sm-7">
                                <nav class="navigation navbar navbar-expand-md navbar-dark ">
                                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample04" aria-controls="navbarsExample04" aria-expanded="false" aria-label="Toggle navigation">
                                        <span class="navbar-toggler-icon"></span>
                                    </button>
                                    <div class="collapse navbar-collapse" id="navbarsExample04">
                                        <ul class="navbar-nav mr-auto">
                                            <li class="nav-item active">
                                                <a class="nav-link" href="index.html"> inicio </a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="about.html">acceso personalizado</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="service.html">aula virtual</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="team.html">correo web </a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="client.html">tika</a>
                                            </li>
                                            <li class="nav-item">
                                                <a class="nav-link" href="contact.html"> estudiar </a>
                                            </li>
                                            <li class="nav-item">
                                                <s:form action="formIniciarSesion" method="post">
                                                    <s:submit value="Iniciar Sesión" cssClass="sign_btn"/>
                                                </s:form>
                                            </li>
                                            </li>
                                        </ul>
                                    </div>
                                </nav>
                            </div>
                            <%--<div class="col-md-3 col-sm-5 d_none">
                                <ul class="sign">
                                    <li>
                                        <s:form action="formIniciarSesion" method="post">
                                            <s:submit value="Iniciar Sesión" cssClass="sign_btn"/>
                                        </s:form>
                                    </li>
                                </ul>
                            </div>--%>
                        </div>
                    </div>
                </div>
            </div>
        </header>
        <!-- end header inner -->
        <!-- end header -->
        <!-- banner -->
        <section class="banner_main">
            <div class="container">
                <div class="row">
                    <div class="col-md-7 col-lg-7">
                        <div class="text-bg">
                            <h1>CRAI UPO<br>Biblioteca Universidad Pablo de Olavide</h1>
                            <span>Ctra. de Utrera, 1, 41013 Sevilla</span>
                            <p>Estudios de Grado y Postgrado. Centros y Departamentos. Oferta científica y tecnológica.</p>
                            <%--<a href="#">About us</a>--%>
                        </div>
                    </div>
                    <div class="col-md-5 col-lg-5">
                        <div class="ban_img">
                            <figure><img src="images/ba_ing.png" alt="#" /></figure>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- end banner -->
        <!-- about section -->
        <div id="about" class="about">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12 col-lg-7">
                        <div class="about_box">
                            <div class="titlepage">
                                <h2><strong class="yellow">Bienvenidos</strong><br>¡Ven a estudiar con nosotros!</h2>
                            </div>
                            <h3>TODO LO QUE NECESITAS EN UN SOLO LUGAR</h3>
                            <span>¡Facilita tu próximo paso en tu carrera de forma más suave y eficiente!</span>
                            <p>En la biblioteca de la Universidad Pablo de Olavide, te ofrecemos un entorno ideal para concentrarte y alcanzar tus metas académicas. Nuestras instalaciones están diseñadas para tu comodidad y productividad.</p>
                            <span class="try">¡Explora nuestra amplia colección de recursos académicos y herramientas de investigación!</span>
                            <%--<a class="read_morea" href="#">Comenzar <i class="fa fa-angle-right" aria-hidden="true"></i></a>--%>
                        </div>

                    </div>
                    <div class="col-md-12 col-lg-5">
                        <div class="about_img">
                            <figure><img src="images/about_img2.jpg" alt="#" /></figure>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- about section -->
        <!-- service section -->
        <div id="service" class="service">
            <div class="container">
                <div class="row">
                    <div class="col-md-7">
                        <div class="titlepage">
                            <h2><strong class="yellow">Servicios</strong><br>¡Te ayudamos a alcanzar tus objetivos académicos!</h2>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 col-sm-6">
                        <div id="ho_color" class="service_box">
                            <img src="images/service_icon1.png" alt="#" />
                            <h3>Reserva de libros</h3>
                            <p>Accede a nuestra amplia colección y reserva los libros que necesites para tus estudios.</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div id="ho_color" class="service_box">
                            <img src="images/service_icon2.png" alt="#" />
                            <h3>Salas de estudio</h3>
                            <p>Disfruta de espacios tranquilos y equipados para concentrarte en tu trabajo académico.</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div id="ho_color" class="service_box">
                            <img src="images/service_icon6.png" alt="#" />
                            <h3>Ordenadores</h3>
                            <p>Accede a ordenadores fijos y portátiles para realizar tus tareas y proyectos.</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div id="ho_color" class="service_box">
                            <img src="images/service_icon4.png" alt="#" />
                            <h3>Clases particulares</h3>
                            <p>Recibe apoyo académico personalizado con nuestros tutores especializados.</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div id="ho_color" class="service_box">
                            <img src="images/service_icon5.png" alt="#" />
                            <h3>Estudia conmigo</h3>
                            <p>Participa en sesiones de estudio en grupo organizadas por otros estudiantes como tú.</p>
                        </div>
                    </div>
                    <div class="col-md-4 col-sm-6">
                        <div id="ho_color" class="service_box">
                            <img src="images/service_icon3.png" alt="#" />
                            <h3>Talleres y eventos</h3>
                            <p>Participa en nuestros talleres y eventos diseñados para mejorar tus habilidades de estudio.</p>
                        </div>
                    </div>
                    <div class="col-md-12">
                        <a class="read_more" href="#">Leer más</a>
                    </div>
                </div>
            </div>
        </div>

    </div>
    <!-- service section -->
    <!-- portfolio -->
    <%--<div class="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-md-12 ">
                    <div class="titlepage">
                        <h2><strong class="yellow">PORTFOLIO</strong><br> CHOOSE A PROFESSIONAL DESIGN</h2>
                        <span>Websites</span>
                        <p>It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distrib</p>
                    </div>
                </div>
            </div>
        </div>
        <div id="myCarousel" class="carousel slide portfolio_Carousel " data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="container">
                        <div class="carousel-caption ">
                            <div class="row">
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf1.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf2.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf3.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf4.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <a class="read_more" href="#">Read More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="container">
                        <div class="carousel-caption">
                            <div class="row">
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf1.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf2.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf3.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf4.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <a class="read_more" href="#">Read More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="container">
                        <div class="carousel-caption">
                            <div class="row">
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf1.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf2.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf3.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-3 col-sm-6">
                                    <div class="portfolio_img">
                                        <img src="images/potf4.jpg" alt="#" />
                                        <div class="middle">
                                            <div class="text2">View More</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-12">
                                    <a class="read_more" href="#">Read More</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                <i class="fa fa-chevron-left" aria-hidden="true"></i>
            </a>
            <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                <i class="fa fa-chevron-right" aria-hidden="true"></i>
            </a>
        </div>
    </div>--%>
    <div class="portfolio">
        <div class="container">
            <div class="row">
                <div class="col-md-12 ">
                    <div class="titlepage">
                        <h2><strong class="yellow">RECURSOS</strong><br> ELIGE UN ESPACIO DE ESTUDIO</h2>
                        <span>Recursos disponibles</span>
                        <p>Descubre los espacios y servicios que ofrecemos para apoyar tu aprendizaje y crecimiento académico.</p>
                    </div>
                </div>
            </div>
            <div id="myCarousel" class="carousel slide portfolio_Carousel " data-ride="carousel">
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <div class="container">
                            <div class="carousel-caption ">
                                <div class="row">
                                    <div class="col-md-3 col-sm-6">
                                        <div class="portfolio_img">
                                            <img src="images/potf3.jpg" alt="#" />
                                            <div class="middle">
                                                <div class="text2">Reserva de libros</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-6">
                                        <div class="portfolio_img">
                                            <img src="images/potf4.jpg" alt="#" />
                                            <div class="middle">
                                                <div class="text2">Salas de estudio</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-6">
                                        <div class="portfolio_img">
                                            <img src="images/potf2.jpg" alt="#" />
                                            <div class="middle">
                                                <div class="text2">Ordenadores</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-3 col-sm-6">
                                        <div class="portfolio_img">
                                            <img src="images/potf1.jpg" alt="#" />
                                            <div class="middle">
                                                <div class="text2">Clases particulares</div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12">
                                        <a class="read_more" href="#">Leer más</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Agrega más elementos del carrusel aquí según sea necesario -->
                </div>
                <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
                    <i class="fa fa-chevron-left" aria-hidden="true"></i>
                </a>
                <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
                    <i class="fa fa-chevron-right" aria-hidden="true"></i>
                </a>
            </div>
        </div>
    </div>

    <!-- end portfolio section -->
    <!-- business  section -->
    <div class="business">
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <div class="titlepage">
                        <h2><strong class="yellow">LOGROS</strong><br>DESCUBRE LO QUE HEMOS LOGRADO</h2>
                        <p>Conoce nuestros logros y recursos que están disponibles para apoyar tu éxito académico.</p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-3 col-sm-6">
                    <div id="ho_color" class="business_box">
                        <i><img src="images/business_icon1.png" alt="#" /></i>
                        <h3>23</h3>
                        <p>NOMINACIONES</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div id="ho_color" class="business_box">
                        <i><img src="images/business_icon2.png" alt="#" /></i>
                        <h3>31</h3>
                        <p>AGENCIAS</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div id="ho_color" class="business_box">
                        <i><img src="images/business_icon3.png" alt="#" /></i>
                        <h3>7</h3>
                        <p>PREMIOS</p>
                    </div>
                </div>
                <div class="col-md-3 col-sm-6">
                    <div id="ho_color" class="business_box">
                        <i><img src="images/business_icon4.png" alt="#" /></i>
                        <h3>8</h3>
                        <p>SOPORTADOS</p>
                    </div>
                </div>
                <div class="col-md-12">
                    <a class="read_more" href="#">Leer más</a>
                </div>
            </div>
        </div>
    </div>

    <!-- end business  section -->
    <!-- team  section -->
    <div id="team" class="team">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="titlepage">
                        <h2><strong class="yellow">Equipo</strong><br>Tenemos un Equipo Profesional de Colaboradores.</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <div id="team" class="carousel slide team_Carousel " data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#team" data-slide-to="0" class="active"></li>
                            <li data-target="#team" data-slide-to="1"></li>
                            <li data-target="#team" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item active">
                                <div class="container">
                                    <div class="carousel-caption ">
                                        <div class="row">
                                            <div class="col-md-4 col-sm-6">
                                                <div id="ho_bg" class="team_img">
                                                    <img src="images/team1.png" alt="#" />
                                                    <div class="ho_socal">
                                                        <ul class="social_icont">
                                                            <li><a href="#"><i class="fa fa-facebook-f"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 col-sm-6">
                                                <div id="ho_bg" class="team_img">
                                                    <img src="images/team2.png" alt="#" />
                                                    <div class="ho_socal">
                                                        <ul class="social_icont">
                                                            <li><a href="#"><i class="fa fa-facebook-f"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-md-4 col-sm-6">
                                                <div id="ho_bg" class="team_img">
                                                    <img src="images/team3.png" alt="#" />
                                                    <div class="ho_socal">
                                                        <ul class="social_icont">
                                                            <li><a href="#"><i class="fa fa-facebook-f"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                                                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <!-- Agrega más miembros del equipo aquí según sea necesario -->
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <!-- Agrega más carruseles de elementos del equipo aquí según sea necesario -->
                        </div>
                        <a class="carousel-control-prev" href="#team" role="button" data-slide="prev">
                            <i class="fa fa-chevron-left" aria-hidden="true"></i>
                        </a>
                        <a class="carousel-control-next" href="#team" role="button" data-slide="next">
                            <i class="fa fa-chevron-right" aria-hidden="true"></i>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- end team  section -->
    <!-- testimonial -->
    <div id="client" class="testimonial">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="titlepage">
                        <h2><strong class="yellow">Testimonios</strong><br>Lo que dicen nuestros clientes</h2>
                    </div>
                </div>
            </div>
        </div>
        <div id="testimo" class="carousel slide testimonial_Carousel" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#testimo" data-slide-to="0" class="active"></li>
                <li data-target="#testimo" data-slide-to="1"></li>
                <li data-target="#testimo" data-slide-to="2"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <div class="container">
                        <div class="carousel-caption">
                            <div class="row">
                                <div class="col-md-6 offset-md-3">
                                    <div class="test_box">
                                        <p>"La biblioteca de la Universidad Pablo de Olavide es un lugar increíble para estudiar. Siempre encuentro los recursos que necesito y el ambiente es muy acogedor."</p>
                                        <i><img src="images/cos2.jpg" alt="#" /></i> <span>María Romero</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="container">
                        <div class="carousel-caption">
                            <div class="row">
                                <div class="col-md-6 offset-md-3">
                                    <div class="test_box">
                                        <p>"La biblioteca ofrece una amplia variedad de recursos que han sido muy útiles para mi investigación. El personal siempre está dispuesto a ayudar. ¡Altamente recomendado!"</p>
                                        <i><img src="images/cos.jpg" alt="#" /></i> <span>Juan García</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="carousel-item">
                    <div class="container">
                        <div class="carousel-caption">
                            <div class="row">
                                <div class="col-md-6 offset-md-3">
                                    <div class="test_box">
                                        <p>"La biblioteca de la Universidad Pablo de Olavide ha sido un recurso invaluable para mis estudios. Siempre encuentro un lugar tranquilo para concentrarme y estudiar en paz."</p>
                                        <i><img src="images/cos1.jpg" alt="#" /></i> <span>Carlos Martínez</span>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <a class="carousel-control-prev" href="#testimo" role="button" data-slide="prev">
                <i class="fa fa-chevron-left" aria-hidden="true"></i>
            </a>
            <a class="carousel-control-next" href="#testimo" role="button" data-slide="next">
                <i class="fa fa-chevron-right" aria-hidden="true"></i>
            </a>
        </div>
    </div>

    <!-- end testimonial -->
    <!-- contact  section -->
    <div id="contact" class="contact">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="titlepage">
                        <h2><strong class="yellow">Contáctanos</strong><br>Solicita una llamada de vuelta</h2>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-8 offset-md-2">
                    <form id="post_form" class="contact_form" action="#" method="post">
                        <div class="row">
                            <div class="col-md-12">
                                <input class="contact_control" placeholder="Nombre" type="text" name="Name">
                            </div>
                            <div class="col-md-12">
                                <input class="contact_control" placeholder="Correo Electrónico" type="email" name="Email">
                            </div>
                            <div class="col-md-12">
                                <input class="contact_control" placeholder="Número de Teléfono" type="tel" name="Phone Number">
                            </div>
                            <div class="col-md-12">
                                <textarea class="textarea" placeholder="Mensaje" name="Message"></textarea>
                            </div>
                            <div class="col-md-12">
                                <button type="submit" class="send_btn">Enviar</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- end contact  section -->
    <!--  footer -->
    <footer>
        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <a class="logo2" href="#"><img src="images/upo1.png" alt="#" /></a>
                    </div>
                    <div class="col-lg-5 col-md-6 col-sm-6">
                        <h3>Contacto</h3>
                        <ul class="location_icon">
                            <li><a href="#"><i class="fa fa-map-marker" aria-hidden="true"></i></a> Ctra. de Utrera, 1<br>41013 Sevilla</li>
                            <li><a href="#"><i class="fa fa-envelope" aria-hidden="true"></i></a> upo@upo.es</li>
                            <li><a href="#"><i class="fa fa-volume-control-phone" aria-hidden="true"></i></a>954 34 92 00</li>
                        </ul>
                        <ul class="social_icon">
                            <li> <a href="#"><i class="fa fa-facebook-f"></i></a></li>
                            <li> <a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li> <a href="#"> <i class="fa fa-linkedin" aria-hidden="true"></i></a></li>
                            <li> <a href="#"><i class="fa fa-instagram"></i></a></li>
                        </ul>
                    </div>
                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <h3>Menús</h3>
                        <ul class="link_icon">
                            <li class="active"> <a href="index.html"> Inicio</a></li>
                            <li> <a href="about.html"> Acerca de nosotros</a></li>
                            <li> <a href="service.html"> Servicios</a></li>
                            <li> <a href="team.html"> Equipo</a></li>
                            <li> <a href="client.html"> Clientes</a></li>
                            <li> <a href="contact.html"> Contáctanos</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-2 col-md-6 col-sm-6">
                        <h3>Publicaciones Recientes</h3>
                        <ul class="link_icon">
                            <li> <a href="#"> Participar en reuniones de personal</a></li>
                            <li> <a href="#"> Gestionar reuniones</a></li>
                            <li> <a href="#"> Dedicado al marketing</a></li>
                            <li> <a href="#"> 2 de mayo de 2024</a></li>
                        </ul>
                    </div>
                    <div class="col-lg-3 col-md-6 col-sm-6">
                        <h3>Boletín de Noticias</h3>
                        <form id="request" class="main_form">
                            <div class="row">
                                <div class="col-md-12 ">
                                    <input class="news" placeholder="Tu Email" type="email" name="Your Email">
                                </div>
                                <div class="col-md-12">
                                    <button class="send_btn">Enviar</button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <p>© 2024 Todos los derechos reservados. <a href="https://upo.es/">BiblioUpo</a></p>
                    </div>
                </div>
            </div>
        </div>
    </footer>

    <!-- end footer -->
    <!-- Javascript files-->
    <script src="js/jquery.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/jquery-3.0.0.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <!-- sidebar -->
    <script src="js/jquery.mCustomScrollbar.concat.min.js"></script>
    <script src="js/custom.js"></script>
</body>

</html>
