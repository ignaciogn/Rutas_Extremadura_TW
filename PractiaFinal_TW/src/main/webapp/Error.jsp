<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true" import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/CSS.css" />
<title>ERRROR</title>
</head>
<body>
	<%@ include file="Cabecera_autenticada.jsp"%>
	<div id="contenedor">
		<%@ include file="Cabecera.jsp"%>
		<div id="Content"><p class="Borrar">
			<%
				if (request.getParameter("error") != null) {
					out.println(request.getParameter("error"));
				}
			%>
			</p>
		</div>
	</div>
</body>
</html>