package com.example.PELIS.servicio;


import com.example.PELIS.modelo.Pelicula;
import com.example.PELIS.modelo.PeliculaDto;
import com.example.PELIS.modelo.PeliculaResponse;
import com.example.PELIS.repositorio.PeliculaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class PeliculaServicio implements IPeliculaServicio {

    @Autowired
   private PeliculaRepositorio peliculaRepositorio;

    @Override
    public ArrayList<PeliculaResponse> consultarPeliculas() {
        ArrayList<Pelicula> arraydepelis;
       arraydepelis = (ArrayList<Pelicula>) peliculaRepositorio.findAll();
        ArrayList<PeliculaResponse> arraydepelisResponse = new ArrayList<PeliculaResponse>();
        for (Pelicula pelicula1 : arraydepelis) {
            PeliculaResponse pResponse = new PeliculaResponse(pelicula1.getId(), pelicula1.getTitulo(), pelicula1.getGenero(), pelicula1.getAnio(), pelicula1.getOscars(), pelicula1.getActores());
            arraydepelisResponse.add(pResponse);
        }
        return arraydepelisResponse;

    }

    @Override
    public PeliculaResponse consultarPorId(int id) {
        Optional<Pelicula> byId = peliculaRepositorio.findById(id);
        Pelicula p;
        if (byId.isPresent()) {
            p = byId.get();
            PeliculaResponse pResponse = new PeliculaResponse(p.getId(), p.getTitulo(), p.getGenero(), p.getAnio(), p.getOscars(), p.getActores());
            return pResponse;

        } else {
            PeliculaResponse pResponseVacio = new PeliculaResponse();
            return pResponseVacio;

        }
    }

    @Override
    public PeliculaResponse insertarPelicula(PeliculaDto p) {
        Pelicula pelicula = new Pelicula(p.getId(), p.getTitulo(), p.getGenero(), p.getAnio(), p.getOscars(), p.getActores());
        Pelicula pelicula1 = peliculaRepositorio.save(pelicula);
        PeliculaResponse pResponse = new PeliculaResponse(pelicula1.getId(), pelicula1.getTitulo(), pelicula1.getGenero(), pelicula1.getAnio(), pelicula1.getOscars(), pelicula1.getActores());
        return pResponse;

    }

    @Override
    public ArrayList<PeliculaResponse> consultarPorTitulo(String titulo) {
        ArrayList<Pelicula> listaPelicula = peliculaRepositorio.findBytitulo(titulo);
       ArrayList<PeliculaResponse>listaPeliculaRespone=new ArrayList<PeliculaResponse>();
        for(Pelicula p:listaPelicula){
            listaPeliculaRespone.add(new PeliculaResponse(p.getId(),p.getTitulo(),p.getGenero(),p.getAnio(),p.getOscars(),p.getActores()));
        }
        return listaPeliculaRespone;
    }
}
