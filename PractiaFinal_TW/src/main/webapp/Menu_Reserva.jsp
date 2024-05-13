<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="Menu-reserva">
	<form id="form3" action="${pageContext.request.contextPath}/Restringido/Action" method="post">
		<a href="javascript:;" onclick="document.getElementById('form3').submit();">Ver Mis Reservas</a> 
			<input type="hidden" name="action" value="MisReservas" />
	</form>
	<form id="form2" action="${pageContext.request.contextPath}/Restringido/Action" method="post">
		<a href="javascript:;"
			onclick="document.getElementById('form2').submit();">Hacer Reserva</a> 
			<input type="hidden" name="action" value="Reserva" />
	</form>
</div>
