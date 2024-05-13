<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" import="java.util.*,es.unex.cum.tw.reyesmagos.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf8" />
<title>Rutas Por Extremadura</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/CSS.css" />
</head>
<body>
   <div class="cabecera"><a id="inicio"></a>
        <h1 class="cabeza">RUTAS POR EXTREMADURA</h1>
    </div> 
		
<%
   if (session.getAttribute("nombre")==null)   {
	   response.sendRedirect("../Login.jsp");
   } else {
%>
	<%@ include file="../Cabecera_autenticada.jsp"%>
	<div id="contenedor">
		<jsp:include page ="../Menu_Autenticado.jsp"/>
		<div id="Content">
		<% Ruta r=(Ruta) request.getAttribute("ruta");%>
			<h1 class="rutaU">Ruta</h1>
			<br/>
			<p><table border=1 class="ruta">
			<tr><td><p><b>Nombre:<%=r.getNombre() %></b></p>
			<p><b>Fecha Incorporación: <%= r.getFechaIncorporacion() %></b></p>
			<p><b>Maximo de Usuarios: <%= r.getMaximoUsuario() %></b></p>
			<p><b>Dificultad: <%= r.getDificultad() %></b></p>
			<p><b>Metros: <%= r.getMetros() %></b></p><br/>
			<td><img border='0'  src="<%=r.getPathImagen() %> " width='200' height='150'/></td>			
			</table>
			</div>
	</div>
	<%} %>
</body>
</html>