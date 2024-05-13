<%-- <div id="Header">
	<img src="${pageContext.request.contextPath}/img/11818262-navidad-reyes-magos.jpg"></img>
</div> --%>

<div id="Header">
<!--   <div class="cabecera"><a id="inicio"></a>
        <h1 class="cabeza">RUTAS POR EXTREMADURA</h1>
    </div> --> 
<div id="Menu">
	<form id="form5" action="${pageContext.request.contextPath}/RutasController" method="post">
		<a href="javascript:;" onclick="document.getElementById('form5').submit();">Ver Rutas</a> 
			<input type="hidden" name="action" value="VerRutas" />
	</form>
		<a href='${pageContext.request.contextPath}/Login.jsp' title=''>Login</a>
</div>

</div>