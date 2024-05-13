package es.unex.cum.tw.reyesmagos.model;

import java.sql.Date;

public class Ruta {
    private int idRuta;
    private String nombre;
    private String pathImagen;
    private Date fechaIncorporacion;
    private int maximoUsuario;
    private int dificultad;
    private int metros;

    public Ruta() {
        // Constructor vacío
    }

    public Ruta(int idRuta, String nombre, String pathImagen, Date fechaIncorporacion, int maximoUsuario, int dificultad, int metros) {
        this.idRuta = idRuta;
        this.nombre = nombre;
        this.pathImagen = pathImagen;
        this.fechaIncorporacion = fechaIncorporacion;
        this.maximoUsuario = maximoUsuario;
        this.dificultad = dificultad;
        this.metros = metros;
    }

    // Getters y Setters para los atributos de Ruta

    public int getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(int idRuta) {
        this.idRuta = idRuta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPathImagen() {
        return pathImagen;
    }

    public void setPathImagen(String pathImagen) {
        this.pathImagen = pathImagen;
    }

    public Date getFechaIncorporacion() {
        return fechaIncorporacion;
    }

    public void setFechaIncorporacion(Date fechaIncorporacion) {
        this.fechaIncorporacion = fechaIncorporacion;
    }

    public int getMaximoUsuario() {
        return maximoUsuario;
    }

    public void setMaximoUsuario(int maximoUsuario) {
        this.maximoUsuario = maximoUsuario;
    }

    public int getDificultad() {
        return dificultad;
    }

    public void setDificultad(int dificultad) {
        this.dificultad = dificultad;
    }

    public int getMetros() {
        return metros;
    }

    public void setMetros(int metros) {
        this.metros = metros;
    }
}
