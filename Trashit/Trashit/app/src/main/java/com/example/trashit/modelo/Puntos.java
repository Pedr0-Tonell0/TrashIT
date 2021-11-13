package com.example.trashit.modelo;

public class Puntos {
    private double latitud;
    private double longitud;
    private String descripcion;
    private String direccion;

    public Puntos() {
    }

    public Puntos(double longitud, double latitud, String descripcion, String direccion) {
        this.longitud = longitud;
        this.latitud = latitud;
        this.descripcion = descripcion;
        this.direccion = direccion;
    }

    public Puntos(double longitud, double latitud) {
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
