package es.unex.cum.tw.reyesmagos.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import es.unex.cum.tw.reyesmagos.model.Ruta;


public interface RutaService {
	public List<Ruta> verTodos() throws SQLException;
	public List<Ruta> verTodosD() throws SQLException;
	public List<Ruta> verTodosM() throws SQLException;
	public List<Ruta> novedades() throws SQLException;
	public Ruta verProducto(String idRuta) throws IOException, SQLException;
}