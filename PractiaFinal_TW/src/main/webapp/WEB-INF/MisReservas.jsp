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
		<jsp:include page ="../Menu_Reserva.jsp"/>
		<br/>
		
		<%
			if (request.getParameter("error") != null) {
				out.println(request.getParameter("error"));
			}
		%>
		<div id="Content">
		<%
			ArrayList lista=(ArrayList)request.getAttribute("lista");
			
		%>			
			<h1 class=MISreservas>Reservas</h1>
			
			<p><table border='1' class="Misreservas">
			<tr><td><b>ID RUTA</b></td><td><b>Fecha Reserva</b></td><td><b>Usuarios</b></td><td><b>ANULAR</b></td></tr>
			<%
			
			for (int i=0;i<lista.size();i++){
				 Reserva r=(Reserva)lista.get(i);
				%>
				<tr><td><%=r.getIdRuta()%> </td><td><%=r.getFechaReserva()%>
				</td><td><%=r.getUsuarios()%> </td><td><a class="boton" href="ReservaController?action=BorrarReserva&idR=<%= r.getIdRuta()%>&fecha=<%= r.getFechaReserva()%>">Anular Reserva</a>
			<%}%>
			</td></tr>
			
			</table>
			</div>
	</div>
	<%} %>
</body>
</html>