package es.unex.cum.tw.reyesmagos.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Configuracion
 */
@WebServlet(urlPatterns="/Restringido/Action")
public class Action extends HttpServlet {
	
	public void processRequest(HttpServletRequest req, HttpServletResponse res)
			throws IOException, ServletException {
				String accion = req.getParameter("action");
		if (accion.contains("Ruta")) {
			RequestDispatcher productos= getServletContext().getRequestDispatcher("/RutasController");
			productos.forward(req, res);
		}else if(accion.contains("Reserva")) {
			RequestDispatcher reservas= getServletContext().getRequestDispatcher("/Restringido/ReservaController");
			reservas.forward(req, res);
		}else if(accion.contains("Valoracion")) {
			RequestDispatcher reservas= getServletContext().getRequestDispatcher("/Restringido/ValoracionController");
			reservas.forward(req, res);
		}
		else {
			req.getRequestDispatcher("./WEB-INF/Principal.jsp?mensaje=No hay acción").forward(req, res);
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
