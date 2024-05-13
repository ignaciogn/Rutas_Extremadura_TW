package es.unex.cum.tw.reyesmagos.service;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import es.unex.cum.tw.reyesmagos.controller.ProductosController;
import es.unex.cum.tw.reyesmagos.controller.RutasController;
import es.unex.cum.tw.reyesmagos.model.Producto;
import es.unex.cum.tw.reyesmagos.model.Ruta;
import util.ConexionUtil;

public class RutasServiceBD implements RutaService {
	public List<Ruta> verTodos() throws SQLException {
		ResultSet resultados = null;// Objeto para guardar los resultados
		List<Ruta> l = null;
		try {
			Statement sentencia = ConexionUtil.openConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultados = sentencia.executeQuery("select * from rutas");
			if (!resultados.next()) {
				return null;
			} else {
				l = new ArrayList<Ruta>();
				resultados.beforeFirst();
				while (resultados.next()) {
					l.add(new Ruta(Integer.parseInt(resultados.getString(1)), resultados.getString(2),
						resultados.getString(3), resultados.getDate(4), Integer.parseInt(resultados.getString(5)), Integer.parseInt(resultados.getString(6)), Integer.parseInt(resultados.getString(7)) ));
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
					Logger.getLogger(RutasController.class.getName()).log(Level.SEVERE,
							"No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return l;
	}
	public List<Ruta> verTodosD() throws SQLException {
		ResultSet resultados = null;// Objeto para guardar los resultados
		List<Ruta> l = null;
		try {
			Statement sentencia = ConexionUtil.openConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultados = sentencia.executeQuery("SELECT * FROM rutas ORDER BY dificultad DESC");
			if (!resultados.next()) {
				return null;
			} else {
				l = new ArrayList<Ruta>();
				resultados.beforeFirst();
				while (resultados.next()) {
					l.add(new Ruta(Integer.parseInt(resultados.getString(1)), resultados.getString(2),
						resultados.getString(3), resultados.getDate(4), Integer.parseInt(resultados.getString(5)), Integer.parseInt(resultados.getString(6)), Integer.parseInt(resultados.getString(7)) ));
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
					Logger.getLogger(RutasController.class.getName()).log(Level.SEVERE,
							"No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return l;
	}
	public List<Ruta> novedades() throws SQLException {
		ResultSet resultados = null;// Objeto para guardar los resultados
		List<Ruta> l = null;
		try {
			Statement sentencia = ConexionUtil.openConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultados = sentencia.executeQuery("SELECT * FROM rutas ORDER BY fechaIncorporacion DESC LIMIT 5;");
			if (!resultados.next()) {
				return null;
			} else {
				l = new ArrayList<Ruta>();
				resultados.beforeFirst();
				while (resultados.next()) {
					l.add(new Ruta(Integer.parseInt(resultados.getString(1)), resultados.getString(2),
						resultados.getString(3), resultados.getDate(4), Integer.parseInt(resultados.getString(5)), Integer.parseInt(resultados.getString(6)), Integer.parseInt(resultados.getString(7)) ));
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
					Logger.getLogger(RutasController.class.getName()).log(Level.SEVERE,
							"No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return l;
	}
	public List<Ruta> verTodosM() throws SQLException {
		ResultSet resultados = null;// Objeto para guardar los resultados
		List<Ruta> l = null;
		try {
			Statement sentencia = ConexionUtil.openConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			resultados = sentencia.executeQuery("SELECT * FROM rutas ORDER BY metros DESC");
			if (!resultados.next()) {
				return null;
			} else {
				l = new ArrayList<Ruta>();
				resultados.beforeFirst();
				while (resultados.next()) {
					l.add(new Ruta(Integer.parseInt(resultados.getString(1)), resultados.getString(2),
						resultados.getString(3), resultados.getDate(4), Integer.parseInt(resultados.getString(5)), Integer.parseInt(resultados.getString(6)), Integer.parseInt(resultados.getString(7)) ));
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
					Logger.getLogger(RutasController.class.getName()).log(Level.SEVERE,
							"No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return l;
	}

	@Override
	public Ruta verProducto(String idRuta) throws IOException, SQLException {
		ResultSet resultados = null;// Objeto para guardar los resultados
		Ruta aux = null;
		try {
			String query="SELECT * FROM rutas where idRuta=?";
			PreparedStatement sentencia=(PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			sentencia.setString(1,idRuta);
			resultados = sentencia.executeQuery();
			
			if (resultados.next() == false) {
				return null;
			} else {
				aux= new Ruta(Integer.parseInt(resultados.getString(1)), resultados.getString(2),
						resultados.getString(3), resultados.getDate(4), Integer.parseInt(resultados.getString(5)), Integer.parseInt(resultados.getString(6)), Integer.parseInt(resultados.getString(7)));
			}
		} catch (Exception e) {
			e.printStackTrace();

			// TODO

//		} catch (SQLException e2) {
//			throw e2;

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
		return aux;
	}
	}
