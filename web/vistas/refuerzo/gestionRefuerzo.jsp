<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestión Refuerzos</title>
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
        <link rel="stylesheet" href="css/templatemo.css">
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
        <link href="../../css/cards.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <h1>Área Gestión de Refuerzos</h1>
            <h2>Rol: <s:property value="#session.rol.tipo" /></h2>

            <s:form action="volverGestionEntidades" method="post">
                <s:submit value="Volver" cssClass="btn btn-secondary mt-3" />
            </s:form>

            <s:form action="formGestionRefuerzo" method="post" class="form-inline">
                <s:hidden name="operacion" value="alta" />
                <s:submit value="Alta" cssClass="btn btn-primary mr-2" />
            </s:form>

            <s:if test="refuerzos != null">
                <table border="1">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Asignatura</th>
                            <th>Descripcion</th>
                            <th>Usuario</th>
                            <th>¿Disponible?</th>
                            <th>Sala</th>
                            <th>Tipo</th>
                        </tr>
                    </thead>

                    <tbody>
                        <s:iterator value="refuerzos">
                            <tr>
                                <td><s:property value="id" /></td>
                                <td><s:property value="asignatura" /></td>
                                <td><s:property value="descripcion" /></td>
                                <td><s:property value="dniUsuario.nombre" /></td>
                                <td><s:property value="idRecurso.disponible" /></td>
                                <td><s:property value="nombreSala.nombre" /></td>
                                <td><s:property value="tipo" /></td>
                                <td>
                                    <s:form action="bajaRefuerzo" method="post" cssClass="form-inline">
                                        <s:hidden name="id" value="%{id}" />
                                        <s:submit value="Baja" cssClass="btn btn-danger mr-2" />
                                    </s:form>

                                    <s:form action="formGestionRefuerzo" method="post" cssClass="form-inline">
                                        <s:hidden name="id" value="%{id}" />
                                        <s:hidden name="operacion" value="modificacion" />
                                        <s:submit value="Modificar" cssClass="btn btn-warning mr-2" />
                                    </s:form>

                                    <s:form action="consultarRefuerzo" method="post" cssClass="form-inline">
                                        <s:hidden name="id" value="%{id}" />
                                        <s:submit value="Consultar" cssClass="btn btn-info" />
                                    </s:form>
                                </td>
                            </tr>
                        </s:iterator>
                    </tbody>
                </table>
            </s:if>
            <s:else>
                <p>No hay refuerzos que mostrar.</p>
            </s:else>
        </div>
    </body>
</html>
