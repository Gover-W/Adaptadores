package com.example.adaptadores.clase;

public class Usuario {
    private String imagen;
    private String nombre;
    private String genero;

    public Usuario(String imagen, String nombre, String genero) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.genero = genero;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
