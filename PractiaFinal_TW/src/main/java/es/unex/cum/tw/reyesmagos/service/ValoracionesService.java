package es.unex.cum.tw.reyesmagos.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


import es.unex.cum.tw.reyesmagos.model.Ruta;
import es.unex.cum.tw.reyesmagos.model.Valoracion;
import es.unex.cum.tw.reyesmagos.model.media;


public interface ValoracionesService {
	public media val(String idRuta) throws IOException, SQLException;
	public boolean valoracion(String idU, String idR, String comen,String fecha, String valor);
	public Valoracion comprobarval(String idRuta, String idU) throws IOException, SQLException;
	}