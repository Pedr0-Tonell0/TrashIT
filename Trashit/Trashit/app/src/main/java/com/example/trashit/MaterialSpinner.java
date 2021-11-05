package com.example.trashit;

public class MaterialSpinner {
    public Integer id;
    public String nombre;

    public MaterialSpinner(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
