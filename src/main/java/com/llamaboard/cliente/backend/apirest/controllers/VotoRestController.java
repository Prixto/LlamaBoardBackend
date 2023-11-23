package com.llamaboard.cliente.backend.apirest.controllers;

import com.llamaboard.cliente.backend.apirest.auth.VotoRequest;
import com.llamaboard.cliente.backend.apirest.models.entity.Cancion;
import com.llamaboard.cliente.backend.apirest.models.entity.Usuario;
import com.llamaboard.cliente.backend.apirest.models.entity.Voto;
import com.llamaboard.cliente.backend.apirest.models.repository.ICancionRepository;
import com.llamaboard.cliente.backend.apirest.models.repository.IUsuarioRepository;
import com.llamaboard.cliente.backend.apirest.models.services.IVotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/votos")
public class VotoRestController {

    @Autowired
    private IVotoService votoService;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private ICancionRepository cancionRepository;

    @GetMapping("/index")
    public List<Voto> index(){
        return votoService.findAll();
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registrarVoto(@RequestBody VotoRequest votoRequest) {
        Long usuarioId = votoRequest.getUsuarioId();
        Long cancionId = votoRequest.getCancionId();
        int voto = votoRequest.getVoto();

        try {
            Optional<Usuario> usuarioOptional = usuarioRepository.findById(usuarioId);
            Usuario usuario = usuarioOptional.orElseThrow(() -> new NoSuchElementException("Usuario no encontrado con ID: " + usuarioId));

            Optional<Cancion> cancionOptional = cancionRepository.findById(cancionId);
            Cancion cancion = cancionOptional.orElseThrow(() -> new NoSuchElementException("Canción no encontrada con ID: " + cancionId));

            votoService.registrarVoto(usuario, cancion, voto);

            return ResponseEntity.ok("Voto registrado con éxito");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

}
