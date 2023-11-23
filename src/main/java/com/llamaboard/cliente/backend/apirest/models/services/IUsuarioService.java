package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.auth.AuthResponse;
import com.llamaboard.cliente.backend.apirest.auth.LoginRequest;
import com.llamaboard.cliente.backend.apirest.models.entity.Usuario;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUsuarioService {

    public List<Usuario> findAll();
    public AuthResponse crear(@RequestBody Usuario usuario);

    public AuthResponse verificar(@RequestBody LoginRequest loginRequest) throws AuthenticationException;

}
