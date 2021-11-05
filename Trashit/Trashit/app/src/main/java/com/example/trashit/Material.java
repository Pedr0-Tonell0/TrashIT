package com.example.trashit;

public class Material {
    private int id;
    private String nombre;
    private String tipo;
    private String imagen;
    private String informacion;

    public int getId()
    {
        return this.id;
    }

    public String getNombre()
    {
        return this.nombre;
    }

    public String getTipo()
    {
        return this.tipo;
    }

    public String getImagen()
    {
        return this.imagen;
    }

    public String getInformacion()
    {
        return this.informacion;
    }

    public void setModel(int id, String nombre, String tipo, String imagen, String informacion)
    {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.imagen = imagen;
        this.informacion = informacion;
    }
}
