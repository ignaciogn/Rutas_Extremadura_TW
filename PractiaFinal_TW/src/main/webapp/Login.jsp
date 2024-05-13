<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=utf8" />
<title>Carta a los reyes Magos</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/CSS.css" />
</head>
<body>
   <div class="cabecera"><a id="inicio"></a>
        <h1 class="cabeza">RUTAS POR EXTREMADURA</h1>
    </div> 
		
<%
   if (session.getAttribute("nombre")!=null)   {
	   response.sendRedirect("WEB-INF/Principal.jsp");
   } else {
%>
	<%@ include file="Cabecera.jsp"%>
	<div id="contenedor">
		<%
			if (request.getParameter("mensaje") != null) {
				out.println(request.getParameter("error"));
			}
		%>
		<div id="Content">
			<form class=login action="UsuarioController" method="post">
				<label>Usuario: </label> <input type="text" name="user" id="user" />
				<br /> <label>Password:</label> <input type="password"
					name="password" id="password" /><br /> <input type="submit"
					value="Validar" />
					<input type="hidden" name="action" value="UsuarioLogin" />
			</form>
			<p class=login>Si no estas dado de alta, pincha <a  href="Registro.html">aqui</a></p>
		</div>
	</div>
	<%} %>
</body>
</html>