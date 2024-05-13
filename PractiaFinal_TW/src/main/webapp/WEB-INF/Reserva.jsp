<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true" import="java.util.*,es.unex.cum.tw.reyesmagos.model.*" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Rutas Por Extremadura</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/CSS.css" />

</head>
<body>
<%
   if (session.getAttribute("nombre")==null)   {
	   response.sendRedirect("../Login.jsp");
   } else {
%>
	<%@ include file="../Cabecera_autenticada.jsp"%>
	<div id="contenedor">
		<jsp:include page ="../Menu_Autenticado.jsp"/>
		<jsp:include page ="../Menu_Reserva.jsp"/>
		
	</div>
	    <div class="formulario">
	    <br/>
        <h1 class="MISreservas">Reserva tu lugar ahora</h1>
    </div>
    <div class="cuerpo-formulario">
        <form action="${pageContext.request.contextPath}/Restringido/Action" method="post" onsubmit="return validacion();">
            <fieldset>
                <legend>Datos Personales</legend>
                <b><b>Nombre:</b>
				<input type="text" value="<%=session.getAttribute("nombre")%>" name="Nombre" size="30" maxlength="25" id="nombre" readonly/>                
            </fieldset>
            <fieldset>
                <legend>Datos de Ruta</legend>
                <b>Fecha de la reserva:</b>
                <input type="date" name="Fecha de la reserva" value="2023-04-01" min="2023-04-01" max="2025-12-31"
                 required />
                <b>Número de Personas:</b>
                <input type="number" name="Numero de personas" value="2" required />
                    <b>Lugar de la reserva:</b>
                    <!-- Añadir un jsp para añadir las diferentes rutas de forma dinamica -->
                    <select id="metodo" name="metodo">

                    		<jsp:include page="../opciones.jsp" />
       
                    </select>
            </fieldset>
            <input type="submit" name="action" value="Hacer Reserva" />
            <input type="reset" name="limpiar" value="Borrar los datos introducidos" />
        </form>
    </div>
<%
   }
%>
</body>
</html>
