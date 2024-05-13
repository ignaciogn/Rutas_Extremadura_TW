package es.unex.cum.tw.reyesmagos.model;

import java.sql.Date;

public class Valoracion {
    private int idValoracion;
    private int idUsuario;
    private int idRuta;
    private String comentario;
    private Date fechaValoracion;
    private int valor;

    public Valoracion() {
        // Constructor vacío
    }

    public Valoracion(int idValoracion, int idUsuario, int idRuta, String comentario, Date fechaValoracion, int valor) {
        this.idValoracion = idValoracion;
        this.idUsuario = idUsuario;
        this.idRuta = idRuta;
        this.comentario = comentario;
        this.fechaValoracion = fechaValoracion;
        this.valor = valor;
    }

    // Getters y Setters para los atributos de Valoracion

    public int getIdValoracion() {
        return idValoracion;
    }

    public void setIdValoracion(int idValoracion) {
        this.idValoracion = idValoracion;
    }

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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFechaValoracion() {
        return fechaValoracion;
    }

    public void setFechaValoracion(Date fechaValoracion) {
        this.fechaValoracion = fechaValoracion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
