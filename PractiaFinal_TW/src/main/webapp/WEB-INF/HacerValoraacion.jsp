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
		
	</div>
	    <div class="formulario">
        <h1 id="valoracion">HAZ TU VALORACION</h1>
    </div>
    <div class="cuerpo-formulario">
        <form action="${pageContext.request.contextPath}/Restringido/Action" method="post" onsubmit="return validacion();">
            <fieldset>
                <legend>Valoracion</legend>
                <b>Nombre de la ruta:</b>
				<input type="text" value="<%=request.getParameter("nombreR")%>" name="Nombre" size="30" maxlength="25" id="nombre" readonly/>    
				<br/>
				 <b>ID de la ruta:</b>
				<input type="text" value="<%=request.getParameter("idR")%>" name="idR" size="30" maxlength="25" id="nombre" readonly/>    
				<br/>
				<b>Puntuación:</b>
				<input type="number" id="valoracion" name="valoracion" min="1" max="5" required>
				<br/>                
            </fieldset>
            <fieldset>
            <legend>Comentarios</legend>
                    <textarea id="comentario" name="comentario" rows="4" cols="50" required></textarea><br><br>
            </fieldset>
            <input type="submit" name="action" value="Hacer Valoracion" />
            <input type="reset" name="limpiar" value="Borrar los datos introducidos" />
        </form>
    </div>
<%
   }
%>
</body>
</html>
