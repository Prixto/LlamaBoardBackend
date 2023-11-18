package com.llamaboard.cliente.backend.apirest.controllers;

import com.llamaboard.cliente.backend.apirest.models.entity.Voto;
import com.llamaboard.cliente.backend.apirest.models.services.IVotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/votos")
public class VotoRestController {
    @Autowired
    private IVotoService votoService;

    @GetMapping("/index")
    public List<Voto> index(){
        return votoService.findAll();
    }
}
