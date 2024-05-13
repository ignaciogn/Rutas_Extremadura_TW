package es.unex.cum.tw.reyesmagos.controller;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import es.unex.cum.tw.reyesmagos.model.Producto;
import es.unex.cum.tw.reyesmagos.model.Ruta;
import es.unex.cum.tw.reyesmagos.model.media;
import es.unex.cum.tw.reyesmagos.service.RutaService;
import es.unex.cum.tw.reyesmagos.service.RutasServiceBD;
import es.unex.cum.tw.reyesmagos.service.ValoracionesService;
import es.unex.cum.tw.reyesmagos.service.ValoracionesServiceBD;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Configuracion
 */
@WebServlet(urlPatterns="/RutasController")
public class RutasController extends HttpServlet{
	private RutaService r = new RutasServiceBD();
	private ValoracionesService s = new ValoracionesServiceBD();
	
	
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
			if (accion.equals("VerRutas")) {
				verTodos(req, res);
			} else if (accion.equals("VerRuta")) {
				verProducto(req, res);
			} else if (accion.equals("VerRuta_A")) {
				verProducto_A(req, res);
			}else if (accion.equals("VerRutas_A")) {
				verTodos_A(req, res);
			}else if (accion.equals("VerRutas_AD")) {
				verTodos_AD(req, res);
			}else if (accion.equals("VerRutas_AM")) {
				verTodos_AM(req, res);
			}else if (accion.equals("RutasNoved")) {
				novedades(req, res);
			}else {
				req.getRequestDispatcher("./WEB-INF/Principal.jsp?mensaje=No hay acción").forward(req, res);
			}

		/*} else {
			res.sendRedirect("Error.jsp?error=Problemas con la sesión");
		}*/
	}
	public void verTodos(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			
			List<Ruta> result = r.verTodos();
			if (result == null) {
				req.getRequestDispatcher("WEB-INF/Principal.jsp?mensaje=NO HAY RUTAS AÑADIDAS").forward(req, res);
			return;
			} else {
				req.setAttribute("lista", result);
				req.getRequestDispatcher("./WEB-INF/VerRutas.jsp").forward(req, res);
			}

		} catch (SQLException e2) {
			req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}
		

	}
	public void verTodos_A(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			
			List<Ruta> result = r.verTodos();
			if (result == null) {
				req.getRequestDispatcher("./WEB-INF/Principal.jsp?mensaje=NO HAY RUTAS AÑADIDAS").forward(req, res);
				return;
			} else {
				req.setAttribute("lista", result);
				req.getRequestDispatcher("./WEB-INF/VerRutas_Auten.jsp").forward(req, res);
			}

		} catch (SQLException e2) {
			req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}
		

	}
	public void novedades(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			
			List<Ruta> result = r.novedades();
			if (result == null) {
				req.getRequestDispatcher("./WEB-INF/Principal.jsp?mensaje=NO HAY RUTAS AÑADIDAS").forward(req, res);
				return;
			} else {
				req.setAttribute("lista", result);
				req.getRequestDispatcher("./WEB-INF/VerRutas_AutenD.jsp").forward(req, res);
			}

		} catch (SQLException e2) {
			req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}
		

	}
	public void verTodos_AD(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			
			List<Ruta> result = r.verTodosD();
			if (result == null) {
				req.getRequestDispatcher("./WEB-INF/Principal.jsp?mensaje=NO HAY RUTAS AÑADIDAS").forward(req, res);
				return;
			} else {
				req.setAttribute("lista", result);
				req.getRequestDispatcher("./WEB-INF/VerRutas_Auten.jsp").forward(req, res);
			}

		} catch (SQLException e2) {
			req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}
		

	}
	public void verTodos_AM(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			
			List<Ruta> result = r.verTodosM();
			if (result == null) {
				req.getRequestDispatcher("./WEB-INF/Principal.jsp?mensaje=ERROR: No hay productos").forward(req, res);
				return;
			} else {
				req.setAttribute("lista", result);
				req.getRequestDispatcher("./WEB-INF/VerRutas_Auten.jsp").forward(req, res);
			}

		} catch (SQLException e2) {
			req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}
		

	}
	
	public void verProducto(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String idRuta = (String) req.getParameter("idRuta");
		try {
			
			Ruta result = r.verProducto(idRuta);
			
			if (result == null) {
				req.getRequestDispatcher("./WEB-INF/Principal.jsp?mensaje=ERROR: No hay productos").forward(req, res);
				return;
			} else {
				
				req.setAttribute("ruta", result);
				req.getRequestDispatcher("./WEB-INF/VerRuta.jsp").forward(req, res);
			}

		} catch (SQLException e2) {
			req.getRequestDispatcher("./WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}
	}
	public void verProducto_A(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		String idRuta = (String) req.getParameter("idRuta");
		
		try {
			media num = s.val(idRuta);
			Ruta result = r.verProducto(idRuta);
//			Aqui declarar la media, para la cual se necesita crear un ValoracionServiceBD y hacer el metodo ahi.
			if (result == null) {
				req.getRequestDispatcher("./WEB-INF/Principal.jsp?mensaje=ERROR: No hay productos").forward(req, res);
				return;
			} else {
				req.setAttribute("media", num);
				req.setAttribute("ruta", result);
				req.getRequestDispatcher("./WEB-INF/VerRuta_Auten.jsp").forward(req, res);
			}

		} catch (SQLException e2) {
			req.getRequestDispatcher("./WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)

			throws ServletException, IOException {

			processRequest(req, res);

			}

			public void doGet(HttpServletRequest req, HttpServletResponse res)

			throws ServletException, IOException {

			processRequest(req, res);

			}



	
}