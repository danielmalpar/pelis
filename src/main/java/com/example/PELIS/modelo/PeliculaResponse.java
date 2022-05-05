package com.example.PELIS.modelo;

import javax.persistence.*;
import java.io.Serializable;


@Table(name="BBDDpelis")//definimos el nombre de la tabla donde guardaremos los campos
public class PeliculaResponse implements Serializable{//se implementa el Serializable para la conversion a objetos los Json
    @Id//anotacion que indica que este campo es la clave primaria
    @Column(nullable = true,name="ID")
    private int id;
    @Column(nullable = false,name="Titulo")
    private String titulo;
    @Column(nullable = false,name="Genero")
    private String genero;
    @Column(nullable = false,name="Año")
    private int anio;
    @Column(nullable = true,name="Oscars")
    private int oscars;
    @Column(nullable = false,name="Actores")
    private String actores;

    public PeliculaResponse(){


    }


    public PeliculaResponse(int id,String titulo,String genero,int anio,int oscars,String actores){
        this.id=id;
        this.titulo=titulo;
        this.genero=genero;
        this.anio =anio;
        this.oscars=oscars;
        this.actores=actores;


    }
//se crean los getters y setters

    public int getId() {
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public int getAnio() {
        return anio;
    }

    public int getOscars() {
        return oscars;
    }

    public String getActores() {
        return actores;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setOscars(int oscars) {
        this.oscars = oscars;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", año=" + anio +
                ", oscars=" + oscars +
                ", actores='" + actores + '\'' +
                '}';
    }

}