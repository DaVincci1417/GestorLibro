package com.example.gestionlibros.Model;

public class Categoria {
    public String nombre;

    public Categoria(String nombre){
        setNombre(nombre);
    }

    public String getNombre() {
        return nombre;
    }
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
