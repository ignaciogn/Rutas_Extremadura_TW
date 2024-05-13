<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true" import="java.util.*,es.unex.cum.tw.reyesmagos.model.*"%>
	<%@ page import="java.text.DecimalFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf8" />
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
		<br/>
		<div id="Content">
		<% Ruta r=(Ruta) request.getAttribute("ruta");%>
		<% media  m= (media)request.getAttribute("media");%>
			<h1 class="rutaU"><%=r.getNombre() %></h1>
			<br/>
			<p><table border='1' class="ruta">
			<tr><td>
			<p><b>Fecha Incorporación: <%= r.getFechaIncorporacion() %></b></p>
			<p><b>Maximo de Usuarios: <%= r.getMaximoUsuario() %></b></p>
			<p><b>Dificultad: <%= r.getDificultad() %></b></p>
			<p><b>Metros: <%= r.getMetros() %></b></p>
			<%
    double media = m.getMedia();
    String mensaje = "";
    if (media == 0) {
        mensaje = "No ha recibido valoraciones aún";
    } else {
        DecimalFormat df = new DecimalFormat("#.##");
        mensaje = "Valoración Media: " + df.format(media);
    }
%>
			<p><b><%= mensaje %></b></p><br/>
			<td><img border='0'  src="<%=r.getPathImagen() %> " width='300' height='200'/></td>			
			</table>
			</div>
	</div>
	<%} %>
</body>
</html>