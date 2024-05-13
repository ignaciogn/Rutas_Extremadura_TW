package es.unex.cum.tw.reyesmagos.service;


import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import es.unex.cum.tw.reyesmagos.model.Reserva;

public interface ReservaService {
	public List<Reserva> verReservas(String idU) throws IOException, SQLException;
	public boolean verReserva(String idU, String fecha, String idR) throws SQLException;
	public boolean doReserva(String idU, String fecha, String idR, String numP);
	public Reserva verReservaH(String idU, String fecha, String idR) throws SQLException;

}
