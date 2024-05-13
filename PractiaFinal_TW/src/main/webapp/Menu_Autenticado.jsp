<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="Menu">
	<form id="form1" action="${pageContext.request.contextPath}/RutasController" method="post">
		<a href="javascript:;" onclick="document.getElementById('form1').submit();">Ver Rutas</a> 
			<input type="hidden" name="action" value="VerRutas_A" />
	</form>
	<form id="form2" action="${pageContext.request.contextPath}/Restringido/Action" method="post">
		<a href="javascript:;"
			onclick="document.getElementById('form2').submit();">Reserva</a> 
			<input type="hidden" name="action" value="Reserva" />
	</form>
	<form id="form4" action="${pageContext.request.contextPath}/RutasController" method="post">
		<a href="javascript:;"
			onclick="document.getElementById('form4').submit();">Novedades</a> 
			<input type="hidden" name="action" value="RutasNoved" />
	</form>
	<a href='${pageContext.request.contextPath}/Logout.jsp' title=''>Logout</a><br /> 
	<p class="info">Usuario:<%=session.getAttribute("nombre")%></p>
</div>
