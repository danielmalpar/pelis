package com.example.PELIS.modelo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;



public class PeliculaDto implements Serializable{//se implementa el Serializable para la conversion a objetos los Json
    @NotNull
    private int id;
    @NotBlank
    private String titulo;
    @NotBlank
    private String genero;
    @NotNull
    private int anio;
    @NotNull
    private int oscars;
    @NotBlank
    private String actores;

    public PeliculaDto(){


    }
    public PeliculaDto(int id,String titulo,String genero,int anio,int oscars,String actores){
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
    @Override
    public boolean equals(Object other){
        if(this.getTitulo().equals(((Pelicula) other).getTitulo())){
            return true;
        }
        else return false;
    }
}
