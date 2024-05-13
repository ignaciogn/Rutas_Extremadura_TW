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
import es.unex.cum.tw.reyesmagos.model.Valoracion;
import es.unex.cum.tw.reyesmagos.model.media;
import util.ConexionUtil;

public class ValoracionesServiceBD implements ValoracionesService {

	public media val(String idRuta) throws IOException, SQLException {
		float num = 0;
		int valor=0;
		ResultSet resultados = null;// Objeto para guardar los resultados
		Valoracion aux = null;
		media aux2=null;
		
		try {
			String query = "SELECT * FROM valoraciones where idRuta=?";
			PreparedStatement sentencia = (PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			sentencia.setString(1, idRuta);
			resultados = sentencia.executeQuery();

			while (resultados.next()) {
				valor++;
				aux = new Valoracion(Integer.parseInt(resultados.getString(1)),
						Integer.parseInt(resultados.getString(2)), Integer.parseInt(resultados.getString(3)),
						resultados.getString(4), resultados.getDate(5), Integer.parseInt(resultados.getString(6)));
				num = num+aux.getValor();
			}
			if(num!=0) {
				num = num/valor;
			}
			
		} catch (Exception e) {
			e.printStackTrace();

			// TODO

//	} catch (SQLException e2) {
//		throw e2;

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
		aux2 = new media(num);
		return aux2;
	}

	@Override
	public boolean valoracion(String idU, String idR, String comen,String fecha, String valor) {
		
		ResultSet resultados = null;
		try {
		
			String query = "INSERT INTO Valoraciones (idUsuario, idRuta, comentario, fechaValoracion, valor)" + "VALUES (?, ?, ?, ?, ?);";
			PreparedStatement sentencia=(PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			synchronized (sentencia) {
				sentencia.setString(1, idU);
				sentencia.setString(2, idR);
				sentencia.setString(3, comen);
				sentencia.setString(4, fecha);
				sentencia.setString(5, valor);
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
					Logger.getLogger(ProductosController.class.getName()).log(
							Level.SEVERE, "No se pudo cerrar el Resulset", ex);
				}
			}
		}
		return true;
	}
	@Override
	public Valoracion comprobarval(String idRuta, String idU) throws IOException, SQLException {
		ResultSet resultados = null;// Objeto para guardar los resultados
		Valoracion aux = null;
		try {
			String query="SELECT * FROM Valoraciones where idRuta=? AND idUsuario=?";
			PreparedStatement sentencia=(PreparedStatement) ConexionUtil.openConnection().prepareStatement(query);
			sentencia.setString(1,idRuta);
			sentencia.setString(2, idU);
			resultados = sentencia.executeQuery();
			
			if (resultados.next() == false) {
				return null;
			} else {
				aux= new Valoracion(Integer.parseInt(resultados.getString(1)), Integer.parseInt(resultados.getString(2)),
						Integer.parseInt(resultados.getString(3)), resultados.getString(4), resultados.getDate(5), Integer.parseInt(resultados.getString(6)));
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
