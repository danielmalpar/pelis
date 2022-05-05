package com.example.PELIS.servicio;

import com.example.PELIS.modelo.PeliculaDto;
import com.example.PELIS.modelo.PeliculaResponse;
import com.example.PELIS.repositorio.PeliculaRepositorio;

import java.util.ArrayList;


public interface IPeliculaServicio {





     ArrayList<PeliculaResponse> consultarPeliculas();

     PeliculaResponse consultarPorId(int id);
     PeliculaResponse insertarPelicula(PeliculaDto p);


     ArrayList<PeliculaResponse> consultarPorTitulo(String titulo);


}
