package es.unex.cum.tw.reyesmagos.controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.Session;

import es.unex.cum.tw.reyesmagos.model.Producto;
import es.unex.cum.tw.reyesmagos.model.Reserva;
import es.unex.cum.tw.reyesmagos.model.Ruta;
import es.unex.cum.tw.reyesmagos.model.Valoracion;
import es.unex.cum.tw.reyesmagos.service.ReservaService;
import es.unex.cum.tw.reyesmagos.service.ReservaServiceBD;
import es.unex.cum.tw.reyesmagos.service.ValoracionesService;
import es.unex.cum.tw.reyesmagos.service.ValoracionesServiceBD;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.ConexionUtil;

@WebServlet(urlPatterns="/Restringido/ValoracionController")
public class ValoracionController extends HttpServlet{
	private ValoracionesService v = new ValoracionesServiceBD();
	//private ProductoService s = new ProductoServiceMemory();

	@Override
	public void init(ServletConfig config) throws ServletException {

	}

	public void processRequest(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {

		/*
		 // Realizado por el filter
		HttpSession session = req.getSession();

		String id = (String) session.getAttribute("Id");
		if (id != null) {*/
			String accion = req.getParameter("action");
			if (accion.equals("HacerValoracion")) {
				valorarP(req, res);
			}  else if (accion.equals("Hacer Valoracion")) {
				valorarD(req, res);
			}else {
				req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=No hay acción").forward(req, res);
			}

		/*} else {
			res.sendRedirect("Error.jsp?error=Problemas con la sesión");
		}*/
	}

	public void valorarP(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	try {
		HttpSession session = req.getSession(false);
		String idU = (String) session.getAttribute("id");
		String  idR= (String) req.getParameter("idR");
		
		Valoracion auxV = v.comprobarval(idR, idU);
		if(auxV==null) {
		req.getRequestDispatcher("../WEB-INF/HacerValoraacion.jsp").forward(req, res);
		}else {
			req.setAttribute("valor", auxV);
			req.getRequestDispatcher("../WEB-INF/MostrarValoracion.jsp").forward(req, res);

		}
	} catch (Exception e2) {
		req.getRequestDispatcher("WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

}

	}
	
	

	public void valorarD(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession(false);
			String idU = (String) session.getAttribute("id");
			String  idR= (String) req.getParameter("idR");
			String comen= (String) req.getParameter("comentario");
	        LocalDate fechaActual = LocalDate.now();

	        // Crea un formateador de fecha con el patrón deseado
	        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	        // Formatea la fecha actual utilizando el formateador
	        String fecha = fechaActual.format(formateador);
			String  valor= (String) req.getParameter("valoracion");
			

			boolean result= v.valoracion(idU, idR, comen, fecha, valor);
			if (result == false) {
				req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=ERROR: No hay productos").forward(req, res);
				return;
			} else {
				req.setAttribute("lista", result);
				req.getRequestDispatcher("../WEB-INF/HacerValoracion.jsp").forward(req, res);
			}

		} catch (Exception e2) {
			req.getRequestDispatcher("WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}

	}
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

}
