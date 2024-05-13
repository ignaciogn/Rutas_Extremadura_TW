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
<%
   if (session.getAttribute("nombre")==null)   {
	   response.sendRedirect("../Login.jsp");
   } else {
%>
	<%@ include file="../Cabecera_autenticada.jsp"%>
	<div id="contenedor">
		<jsp:include page ="../Menu_Autenticado.jsp"/>
		<div id="Content">
  <% Valoracion r=(Valoracion) request.getAttribute("valor");%>
  <h1 class="valoracionT">VALORACION</h1>
  <br/>
  <br/>
<table class="valoraciones">
  <tr>
    <th>Fecha valoración</th>
    <th>Nota de Valoración</th>
    <th>Comentarios</th>
  </tr>
  <tr>
    <td><%= r.getFechaValoracion() %></td>
    <td><%= r.getValor() %></td>
    <td><%= r.getComentario() %></td>
  </tr>
</table>
</div>

	</div>
	<%} %>
</body>
</html>