package com.llamaboard.cliente.backend.apirest.controllers;

import com.llamaboard.cliente.backend.apirest.models.entity.Genero;
import com.llamaboard.cliente.backend.apirest.models.services.IGeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/generos")
public class GeneroRestController {
    @Autowired
    private IGeneroService generoService;

    @GetMapping("/index")
    public List<Genero> index(){
        return generoService.findAll();
    }
}