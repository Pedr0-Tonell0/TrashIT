package com.example.trashit.modelo;

public class Ubicacion {

    private Partido partido;
    private Direccion direccion;
    private Puntos punto;

    public Ubicacion(Partido partido, Direccion direccion, Puntos punto) {
        this.partido = partido;
        this.direccion = direccion;
        this.punto = punto;
    }

    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public Puntos getPunto() {
        return punto;
    }

    public void setPunto(Puntos punto) {
        this.punto = punto;
    }
}
