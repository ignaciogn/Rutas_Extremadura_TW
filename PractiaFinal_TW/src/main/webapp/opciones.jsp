 <%@page import="es.unex.cum.tw.reyesmagos.service.RutasServiceBD"%>
<%@page import="es.unex.cum.tw.reyesmagos.service.RutaService"%>
<%@page import="es.unex.cum.tw.reyesmagos.model.Ruta"%>
<%@page import="java.util.List"%>
 <%
    RutaService r = new RutasServiceBD();	
    List<Ruta> result = r.verTodos();
    if(result!=null){
    for (Ruta ruta2 : result) {
        %>
        <option value="<%= ruta2.getIdRuta() %>"><%= ruta2.getNombre() %></option>
        <%
    }
    }
%>