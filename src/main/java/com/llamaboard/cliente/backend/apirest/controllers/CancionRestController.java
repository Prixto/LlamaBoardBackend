package com.llamaboard.cliente.backend.apirest.controllers;

import com.llamaboard.cliente.backend.apirest.models.dto.CancionDTO;
import com.llamaboard.cliente.backend.apirest.models.entity.Cancion;
import com.llamaboard.cliente.backend.apirest.models.entity.Genero;
import com.llamaboard.cliente.backend.apirest.models.services.ICancionService;
import com.llamaboard.cliente.backend.apirest.models.services.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/canciones")
public class CancionRestController {
    @Autowired
    private ICancionService cancionService;

    @GetMapping("/index")
    public List<Cancion> index(){
        return cancionService.findAll();
    }

    @GetMapping("/conGenero")
    public List<CancionDTO> getCancionesConGenero() {
        List<Cancion> canciones = cancionService.findAll();

        return canciones.stream()
                .map(cancion -> new CancionDTO(cancion, cancion.getGenero()))
                .collect(Collectors.toList());
    }

}