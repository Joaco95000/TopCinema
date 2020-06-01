package com.example.topcinema.modelos;

public class Pelicula {

    private String nombre, genero, compania; //TODO: ver si necesitamos director, recaudacion, presupuesto, fecha de estreno, premios :v
    private int puntuacion, duracion; //TODO: esto es un double?
    private String foto;


    public Pelicula(){}

    public Pelicula(String nombre, String compania)
    {
        this.nombre = nombre;
        this.compania = compania;
    }

    public Pelicula(String nombre, String genero, String compania, int duracion, int puntuacion,String foto)
    {
        this.nombre = nombre;
        this.genero = genero;
        this.compania = compania;
        this.duracion = duracion;
        this.puntuacion = puntuacion;
        this.foto = foto;
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

    public String getCompania() {
        return compania;
    }
    public void setCompania(String compania) {
        this.compania = compania;
    }

    public double getDuracion() {
        return duracion;
    }
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }


    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
