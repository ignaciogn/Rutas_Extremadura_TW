package es.unex.cum.tw.reyesmagos.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.mysql.cj.Session;

import es.unex.cum.tw.reyesmagos.model.Producto;
import es.unex.cum.tw.reyesmagos.model.Reserva;
import es.unex.cum.tw.reyesmagos.model.Ruta;
import es.unex.cum.tw.reyesmagos.service.ReservaService;
import es.unex.cum.tw.reyesmagos.service.ReservaServiceBD;
import es.unex.cum.tw.reyesmagos.service.RutaService;
import es.unex.cum.tw.reyesmagos.service.RutasServiceBD;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns="/Restringido/ReservaController")
public class ReservaController extends HttpServlet{
	private ReservaService s = new ReservaServiceBD();
	private RutaService aux = new RutasServiceBD();
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
			if (accion.equals("Reserva")) {
				verTodos(req, res);
			} else if (accion.equals("MisReservas")) {
				verProducto(req, res);
			} else if (accion.equals("BorrarReserva")) {
				borrar(req, res);
			} else if (accion.equals("Hacer Reserva")) {
				reserva(req, res);
			}else {
				req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=No hay acción").forward(req, res);
			}

		/*} else {
			res.sendRedirect("Error.jsp?error=Problemas con la sesión");
		}*/
	}

	public void verTodos(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		try {
			List<Ruta> l = aux.verTodos();
			if(l!=null) {
				req.getRequestDispatcher("../WEB-INF/Reserva.jsp").forward(req, res);
			}else {
				req.getRequestDispatcher("WEB-INF/Principal.jsp?mensaje=NO HAY RUTAS AÑADIDAS").forward(req, res);

			}

		} catch (Exception e2) {
			req.getRequestDispatcher("WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}

	}
	public void reserva(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession(false);
			String idP = (String) session.getAttribute("id");
			String  fecha= (String) req.getParameter("Fecha de la reserva");
			String idR= (String) req.getParameter("metodo");
			String  numP= (String) req.getParameter("Numero de personas");

			Reserva aux = s.verReservaH(idP, fecha, idR);
			if(aux!=null) {
				req.getRequestDispatcher("../WEB-INF/NOHacerReserva.jsp").forward(req, res);

			}else {
			boolean result = (boolean) s.doReserva(idP, fecha, idR, numP);
			if (result == false) {
				req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=ERROR: No hay productos").forward(req, res);
				return;
			} else {
				req.setAttribute("lista", result);
				req.getRequestDispatcher("../WEB-INF/HacerReserva.jsp").forward(req, res);
			}
			}

		} catch (Exception e2) {
			req.getRequestDispatcher("WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}

	}
	
	public void borrar(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		try {
			HttpSession session = req.getSession(false);
			String idP = (String) session.getAttribute("id");
			String  fecha= (String) req.getParameter("fecha");
			String idR= (String) req.getParameter("idR");

			
			boolean result = (boolean) s.verReserva(idP, fecha, idR);
			if (result == false) {
				req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=ERROR: No hay productos").forward(req, res);
				return;
			} else {
				req.setAttribute("lista", result);
				req.getRequestDispatcher("../WEB-INF/BorrarReserva.jsp").forward(req, res);
			}

		} catch (Exception e2) {
			req.getRequestDispatcher("WEB-INF/Principal.jsp?mensaje=Error en la consulta. Hable con administrador").forward(req, res);

		}

	}

	public void verProducto(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String idP = (String) session.getAttribute("id");
		try {
			List<Reserva> result = s.verReservas(idP);
			if (result == null) {
				req.getRequestDispatcher("../WEB-INF/Principal.jsp?mensaje=NO HAY RESERVAS REALIZADAS").forward(req, res);
				return;
			} else {
				req.setAttribute("lista", result);
				req.getRequestDispatcher("../WEB-INF/MisReservas.jsp").forward(req, res);
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
