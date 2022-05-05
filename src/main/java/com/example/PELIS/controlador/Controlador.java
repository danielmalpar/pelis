package com.example.PELIS.controlador;

import com.example.PELIS.modelo.PeliculaDto;
import com.example.PELIS.modelo.PeliculaResponse;
import com.example.PELIS.servicio.PeliculaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RequestMapping(value = "/pelicula")
@RestController
public class Controlador {
    @Autowired
    private PeliculaServicio peliculaServicio;


    @RequestMapping( method = RequestMethod.GET)
    public ArrayList<PeliculaResponse> consultarPeliculas() {
        System.out.println(peliculaServicio.consultarPeliculas());
        return peliculaServicio.consultarPeliculas();

    }

    @RequestMapping(value = "/buscarPorID/{id}", method = RequestMethod.GET)//
    public PeliculaResponse consultarPorId(@PathVariable("id") int id) {
        return peliculaServicio.consultarPorId(id);

    }

    @RequestMapping( method = RequestMethod.POST)
//se añade post en vez de get ya que añadimos a la BBDD gracias a un Json
    public PeliculaResponse insertarPelicula(@Valid @RequestBody PeliculaDto peliculaDto) {//usamos el @requestParam ya que el requestBody me da error y me devuelve null
        return peliculaServicio.insertarPelicula(peliculaDto);
    }

    @RequestMapping(value = "/BuscarPorTitulo/{titulo}", method = RequestMethod.GET)
//se tiene que cambiar la url,en este caso se añade una barra para que no entre en conflicto con el id
    public ArrayList<PeliculaResponse> consultarPorTitulo(@PathVariable("titulo") String titulo) {
        return peliculaServicio.consultarPorTitulo(titulo);
    }
}


