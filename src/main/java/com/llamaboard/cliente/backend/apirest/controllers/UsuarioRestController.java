package com.llamaboard.cliente.backend.apirest.controllers;

import com.llamaboard.cliente.backend.apirest.models.entity.Usuario;
import com.llamaboard.cliente.backend.apirest.models.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/usuarios")
public class UsuarioRestController {
    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/index")
    public List<Usuario> index(){
        return usuarioService.findAll();
    }

    @PostMapping("/signup")
    public ResponseEntity<Usuario> registerUser(@RequestBody Usuario usuario){
        usuario = usuarioService.crear(usuario);
        return new ResponseEntity<>(usuario, HttpStatus.CREATED);
    }
}
