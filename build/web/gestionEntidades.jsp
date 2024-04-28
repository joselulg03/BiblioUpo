<%@taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Área Admin</title>
    </head>
    <body>
        <h1><s:property value="rol.tipo" />: <s:property value="usuario.nombre" /> <s:property value="usuario.apellidos" /></h1>

        <nav>

            <s:if test="rol.tipo.equals('Estudiante') || rol.tipo.equals('Invitado')">
                <%-- ROL != Estudiante o Invitado--%>
            </s:if>
            <s:else>
                <s:form action="gestion" method="post">
                    <s:hidden name="rol" value="%{rol.tipo}" />
                    <s:hidden name="entidad" value="usuarios" />
                    <s:submit value="Usuarios" />
                </s:form>
            </s:else>


            <s:if test="rol.tipo.equals('Invitado')">
                <%-- ROL != Invitado--%>
            </s:if>
            <s:else>
                <s:form action="gestion" method="post">
                    <s:hidden name="rol" value="%{rol.tipo}" />
                    <s:hidden name="entidad" value="libros" />
                    <s:submit value="Libros" />
                </s:form>
            </s:else>

            <s:form action="gestion" method="post">
                <s:hidden name="rol" value="%{rol.tipo}" />
                <s:hidden name="entidad" value="salas" />
                <s:submit value="Salas" />
            </s:form>

            <s:form action="gestion" method="post">
                <s:hidden name="rol" value="%{rol.tipo}" />
                <s:hidden name="entidad" value="ordenadores" />
                <s:submit value="Ordenadores" />
            </s:form>

            <s:if test="rol.tipo.equals('Invitado')">
                <%-- ROL != Invitado--%>
            </s:if>
            <s:else>
                <s:form action="gestion" method="post">
                    <s:hidden name="rol" value="%{rol.tipo}" />
                    <s:hidden name="entidad" value="portatiles" />
                    <s:submit value="Portátiles" />
                </s:form>
            </s:else>

            <s:form action="gestion" method="post">
                <s:hidden name="rol" value="%{rol.tipo}" />
                <s:hidden name="entidad" value="reservas" />
                <s:submit value="Reservas" />
            </s:form>

        </nav>
    </body>
</html>
