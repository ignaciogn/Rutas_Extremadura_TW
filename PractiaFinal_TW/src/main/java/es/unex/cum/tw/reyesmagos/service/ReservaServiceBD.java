package es.unex.cum.tw.reyesmagos.service;

import java.io.IOException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.unex.cum.tw.reyesmagos.controller.ProductosController;
import es.unex.cum.tw.reyesmagos.model.Producto;
import es.unex.cum.tw.reyesmagos.model.Reserva;
import es.unex.cum.tw.reyesmagos.model.Ruta;
import util.ConexionUtil;

public class ReservaServiceBD implements ReservaService {

	@Override
	public List<Reserva> verReservas(String idU) throws SQLException {
		ResultSet resultados = null;// Objeto para guardar los resultados
		List<Reserva> l = null;
		try {
			String query = "SELECT * from reservas where idUsuario=?";
			PreparedStatement sentencia = (PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			sentencia.setString(1, idU);
			resultados = sentencia.executeQuery();
			if (!resultados.next()) {
				return null;
			} else {
				l = new ArrayList<Reserva>();
				resultados.beforeFirst();
				while (resultados.next()) {
					l.add(new Reserva(Integer.parseInt(resultados.getString(1)),
							Integer.parseInt(resultados.getString(2)), resultados.getDate(3),
							Integer.parseInt(resultados.getString(4))));
				}

			}

		} catch (SQLException e2) {
			throw e2;

		} finally {
			// Se cierra resultSet
			if (resultados != null) {
				try {
					resultados.close();
				} catch (SQLException ex) {
					Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE,
							"No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return l;
	}

	@Override
	public Reserva verReservaH(String idU, String fecha, String idR) throws SQLException {
		ResultSet resultados = null;// Objeto para guardar los resultados
		Reserva auxR = null;
		try {
//			String query2 = "DELETE FROM Reservas WHERE idRuta = ? AND idUsuario = ? AND fechaReserva = ?";
			String query = "SELECT * FROM Reservas WHERE idRuta = ? AND idUsuario = ? AND fechaReserva = ?";
			PreparedStatement sentencia = ConexionUtil.openConnection().prepareStatement(query);
			sentencia.setString(1, idR);
			sentencia.setString(2, idU);
			sentencia.setString(3, fecha);
			resultados = sentencia.executeQuery();

			if (resultados.next() == false) {
				return null;
			} else {
				auxR = new Reserva(Integer.parseInt(resultados.getString(1)),
						Integer.parseInt(resultados.getString(2)), resultados.getDate(3),
						Integer.parseInt(resultados.getString(4)));
			}

		} catch (SQLException e2) {
			throw e2;

		} finally {
			// Se cierra resultSet
			if (resultados != null) {
				try {
					resultados.close();
				} catch (SQLException ex) {
					Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE,
							"No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return auxR;

	}

	@Override
	public boolean verReserva(String idU, String fecha, String idR) throws SQLException {
		ResultSet resultados = null;// Objeto para guardar los resultados
		try {
//			String query2 = "DELETE FROM Reservas WHERE idRuta = ? AND idUsuario = ? AND fechaReserva = ?";
			String query = "DELETE FROM Reservas WHERE idRuta = ? AND idUsuario = ? AND fechaReserva = ?";
			PreparedStatement sentencia = ConexionUtil.openConnection().prepareStatement(query);
			sentencia.setString(1, idR);
			sentencia.setString(2, idU);
			sentencia.setString(3, fecha);

			int filasAfectadas = sentencia.executeUpdate();

			return filasAfectadas > 0;

		} catch (SQLException e2) {
			throw e2;

		} finally {
			// Se cierra resultSet
			if (resultados != null) {
				try {
					resultados.close();
					return true;
				} catch (SQLException ex) {
					Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE,
							"No se pudo cerrar el Resulset", ex);
				}
			}
		}

	}

	@Override
	public boolean doReserva(String idU, String fecha, String idR, String numP) {
		ResultSet resultados = null;
		try {

			String query = "INSERT INTO Reservas (idUsuario, idRuta, fechaReserva, usuariosM)" + "VALUES (?, ?, ?, ?);";
			PreparedStatement sentencia = (PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			synchronized (sentencia) {
				sentencia.setString(1, idU);
				sentencia.setString(2, idR);
				sentencia.setString(3, fecha);
				sentencia.setString(4, numP);
				sentencia.executeUpdate();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Se cierra resultSet
			if (resultados != null) {
				try {
					resultados.close();
				} catch (SQLException ex) {
					Logger.getLogger(ProductosController.class.getName()).log(Level.SEVERE,
							"No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return true;
	}
}
