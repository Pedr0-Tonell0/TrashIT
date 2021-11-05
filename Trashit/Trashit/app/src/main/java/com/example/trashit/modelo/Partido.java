package com.example.trashit.modelo;

public class Partido {
    private Integer idPartido;
    private String partido;

    public Partido(String partido, int idPartido) {
        this.partido = partido;
        this.idPartido = idPartido;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }
}
