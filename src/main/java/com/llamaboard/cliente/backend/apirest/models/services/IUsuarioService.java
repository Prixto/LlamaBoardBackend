package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.models.entity.Usuario;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> findAll();
    public Usuario crear(@RequestBody Usuario usuario);
}
