package com.example.gestionlibros.Model;

public class Libro {
    private String nombre;
    private int codigo;
    private String editorial;
    private String categoria;
    private int año;
    private String tipoLibro;

    public Libro(String nombre, String editorial,int año, String categoria, String tipoLibro){
        setNombre(nombre);
        setEditorial(editorial);
        setAño(año);
        setCategoria(categoria);
        setTipoLibro(tipoLibro);
    }

    public String getNombre() {
        return nombre;
    }
    private void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getEditorial() {
        return editorial;
    }
    private void setEditorial(String editorial) {
        this.editorial = editorial;
    }
    public String getCategoria() {
        return categoria;
    }
    private void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getAño() {
        return año;
    }
    private void setAño(int año) {
        this.año = año;
    }
    public String getTipoLibro() {
        return tipoLibro;
    }
    private void setTipoLibro(String tipoLibro) {
        this.tipoLibro = tipoLibro;
    }
}
