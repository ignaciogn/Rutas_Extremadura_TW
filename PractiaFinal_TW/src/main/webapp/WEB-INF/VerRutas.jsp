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
		
<%-- <%
   if (session.getAttribute("nombre")==null)   {
	   response.sendRedirect("../Login.jsp");
   } else {
%> --%>
	<%@ include file="../Cabecera.jsp"%>
	<div id="contenedor">
<%-- 		<jsp:include page ="../Menu_Autenticado.jsp"/> --%>
		<%
			if (request.getParameter("error") != null) {
				out.println(request.getParameter("error"));
			}
		%>
		<div id="Content">
		<%
			ArrayList lista=(ArrayList)request.getAttribute("lista");%>			
			<h1 class="tabla">RUTAS</h1>
			<p><table border='1' class="rutas">
<tr>
    <td><b>Ruta</b></td>
    <td><b>Fecha Incorporacion</b></td>
    <td><b>Usuarios Maximos</b></td>
    <td><b>Dificultad</b></td>
    <td><b>Metros</b></td>

</tr>
<%
for (int i=0; i<lista.size(); i++) {
	Ruta r=(Ruta)lista.get(i);
%>
<tr>
	<td><%= r.getNombre() %></td>
	<td><%= r.getFechaIncorporacion() %></td>
	<td><%= r.getMaximoUsuario() %></td>
	<td><%= r.getDificultad() %></td>
	<td><%= r.getMetros() %></td>
</tr>
<%
}
%>
		<%-- 	<%
			
			for (int i=0;i<lista.size();i++){
				 Ruta r=(Ruta)lista.get(i);
				 
				%>
				<tr><td><%=r.getNombre() %></td><td><%=r.getFechaIncorporacion()%></td><td><%=r.getMaximoUsuario()%></td><td><%=r.getDificultad()%></td><td><%=r.getMetros()%>
			<%}%>
			</td></tr> --%>
			
			</table>
			</div>
	</div>
<%-- 	<%} %> --%>
</body>
</html>