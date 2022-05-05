package com.example.PELIS.repositorio;


import com.example.PELIS.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.ArrayList;


public interface PeliculaRepositorio extends JpaRepository<Pelicula,Integer>{//extendemos de JPA para poder tr

    ArrayList<Pelicula> findBytitulo(String name);//creamos nuestro propio metodo con la palabra clave findBy + la columna
                                                //por la que queramos hacer el get
}
