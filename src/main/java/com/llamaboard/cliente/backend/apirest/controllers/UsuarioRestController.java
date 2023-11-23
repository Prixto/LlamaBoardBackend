package com.llamaboard.cliente.backend.apirest.controllers;

import com.llamaboard.cliente.backend.apirest.auth.AuthResponse;
import com.llamaboard.cliente.backend.apirest.auth.LoginRequest;
import com.llamaboard.cliente.backend.apirest.models.entity.Usuario;
import com.llamaboard.cliente.backend.apirest.models.services.IUsuarioService;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
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
    public ResponseEntity<AuthResponse> registerUser(@RequestBody Usuario usuario) {
        AuthResponse responseMessage = usuarioService.crear(usuario);
        return new ResponseEntity<>(responseMessage, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            AuthResponse authResponse = usuarioService.verificar(loginRequest);
            return ResponseEntity.ok(authResponse);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

}
