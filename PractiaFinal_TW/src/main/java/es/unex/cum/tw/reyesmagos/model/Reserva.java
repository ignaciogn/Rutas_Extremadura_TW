package es.unex.cum.tw.reyesmagos.model;

import java.sql.Date;

public class Reserva {
    private int idUsuario;
    private int idRuta;
    private Date fechaReserva;
    private int Usuarios;



	public int getUsuarios() {
		return Usuarios;
	}

	public void setUsuarios(int usuarios) {
		Usuarios = usuarios;
	}

	public Reserva() {
        // Constructor vacío
    }

    public Reserva(int idUsuario, int idRuta, Date fechaReserva,int usuarios) {
        this.idUsuario = idUsuario;
        this.idRuta = idRuta;
        this.fechaReserva = fechaReserva;
        this.Usuarios = usuarios;
    }

    // Getters y Setters para los atributos de Reserva

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }
}