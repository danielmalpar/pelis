package com.example.PELIS.controlador;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.PELIS.modelo.PeliculaDto;
import com.example.PELIS.modelo.PeliculaResponse;
import com.example.PELIS.servicio.PeliculaServicio;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = Controlador.class)

class ControladorTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;



    @MockBean
    private PeliculaServicio peliculaServicio;



    @Test
    void consultarPeliculas() throws Exception {

         mockMvc.perform(get("/pelicula/listar")
                    .contentType("application/json")).andExpect(status().isOk());

    }


    @Test
    void consultarPorId() throws Exception {
        int id=0;
            mockMvc.perform(get("/pelicula/buscarPorID/{id}",0)
                    .contentType("application/json")).andExpect(status().isOk());
    }


    @Test
    void insertarPelicula() throws Exception {
        PeliculaDto pDto=new PeliculaDto();
        PeliculaResponse pResponse=new PeliculaResponse();
            when(peliculaServicio.insertarPelicula(pDto)).thenReturn(pResponse);

            /*MvcResult llamadaResult=  mockMvc.perform(post("/pelicula").param("peliculaInsertar","ff")
                    .contentType("application/json")).andExpect(status().isOk()).andReturn();
            assertTrue(llamadaResult.getResponse().getContentAsString().length()>10);*/





    }

    @Test
    void consultarPorTitulo() throws Exception {
        String titulo="star wars";

       mockMvc.perform(get("/pelicula/BuscarPorTitulo/{titulo}",titulo)
                    .contentType("application/json")).andExpect(status().isOk());

    }

    @Test
    void consultarPorTituloMal() throws Exception {

        String titulo="star wars";

        mockMvc.perform(get("/pelicula/BuscarPorTitulo/{titulo}",titulo)
                .contentType("application/json")).andExpect(status().isOk());//seria con el isbadrequest
    }
}