package com.example.trashit.modelo;

public class Material {
    private int id;
    private String nombre;
    private String tipo;
    private String imagen;
    private String informacion;
    private Ubicacion ubicacion;

    public Material(String material, int idMaterial, Ubicacion ubicacion) {
        this.nombre = material;
        this.id = idMaterial;
        this.ubicacion = ubicacion;
    }

    public Material(int id, String nombre, String tipo, String imagen, String informacion, Ubicacion ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.nombre = nombre;
        this.tipo = tipo;
        this.imagen = imagen;
        this.informacion = informacion;
    }


    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getInformacion() {
        return informacion;
    }

    public void setInformacion(String informacion) {
        this.informacion = informacion;
    }
}
