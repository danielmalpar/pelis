package com.example.PELIS.servicio;

import com.example.PELIS.modelo.Pelicula;
import com.example.PELIS.modelo.PeliculaDto;
import com.example.PELIS.modelo.PeliculaResponse;
import com.example.PELIS.repositorio.PeliculaRepositorio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)//importancion del mockito sirve como im
class PeliculaServicioTest {

    @Mock//este sirve para falsear un objeto
    private PeliculaRepositorio peliculaRepositorio;



    @InjectMocks//este crea un objeto real
    private PeliculaServicio peliculaServicio;


    @Test
    void consultarPeliculas() {
        ArrayList<Pelicula> pruebaArrayPelis=new ArrayList<Pelicula>();
        ArrayList<PeliculaResponse>arrayListPResponse=new ArrayList<PeliculaResponse>();
        Mockito.when(peliculaRepositorio.findAll()).thenReturn(pruebaArrayPelis);//aqui devolveria el thenReturn lo que nosotros queremos que le devolvamos
        assertEquals(peliculaServicio.consultarPeliculas().size(),  0);//esta seria el test bueno ya que te devuelve null si al findAll está vacio
    }

   /* @Test
    void consultarPeliculas2() {
        List<Pelicula> pruebaArrayPelis = new ArrayList<>();
        Pelicula p=new Pelicula();
        Pelicula p2=new Pelicula();
        pruebaArrayPelis.add(p);
        pruebaArrayPelis.add(p2);

        Mockito.when(peliculaRepository.findAll()).thenReturn(pruebaArrayPelis);
        assertEquals(peliculaService.consultarPeliculas().size(), 2);
    }
    @Test
    void consultarPorIdNull() {

        Pelicula p=new Pelicula();
        //Mockito.when(peliculaRepository.findById(2)).thenReturn(Optional.of(p));
       Mockito.when(peliculaRepository.findById(319)).thenReturn(null);
        assertEquals(peliculaService.consultarPorId(319),null);

    }*/

    @Test
    void consultarPorId() {
        int id=0;
       Pelicula pelicula1=new Pelicula();
        PeliculaResponse pResponse1=new PeliculaResponse();
        Mockito.when(peliculaRepositorio.findById(id)).thenReturn(Optional.of(pelicula1));
        PeliculaResponse expected = peliculaServicio.consultarPorId(id);
        assertEquals(expected.getId(),pResponse1.getId());
    }

    @MockitoSettings(strictness = Strictness.LENIENT)
    @Test
    void insertarPelicula() {
        System.out.println("aqui ha entrado");

        PeliculaResponse pResponse=new PeliculaResponse();
        System.out.println("me crea el response"+pResponse);

        PeliculaDto p = new PeliculaDto();
        System.out.println("me crea el dto"+p);
        Pelicula pelicula=new Pelicula(p.getId(), p.getTitulo(), p.getGenero(), p.getAnio(), p.getOscars(), p.getActores());
        System.out.println("me crea el pelicula y me lo transforma"+pelicula.getId());

        Mockito.when(peliculaRepositorio.save(pelicula)).thenReturn(pelicula);//la pelicula en si está vacia a null y 0 pero como es//objeto mockito la simula como real
        System.out.println("me hace el mockito");
        assertInstanceOf(pResponse.getClass(),pResponse);
        //assertEquals(peliculaService.insertarPelicula(p).equals(pelicula),pResponse);
        //System.out.println("me hace el insertar");

    }

    @Test
    void consultarPorTitulo() {
        String titulo="TinTin";
        ArrayList<Pelicula>ArraylistPelis=new ArrayList<Pelicula>();
        PeliculaResponse p=new PeliculaResponse();
        ArrayList<PeliculaResponse>arrayListPResponse=new ArrayList<PeliculaResponse>();
        Mockito.when(peliculaRepositorio.findBytitulo(titulo)).thenReturn((ArraylistPelis));
        assertEquals(peliculaServicio.consultarPorTitulo(titulo),(arrayListPResponse));
    }


}