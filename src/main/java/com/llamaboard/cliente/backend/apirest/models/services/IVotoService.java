package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.models.entity.Cancion;
import com.llamaboard.cliente.backend.apirest.models.entity.Usuario;
import com.llamaboard.cliente.backend.apirest.models.entity.Voto;

import java.util.List;

public interface IVotoService {
    public List<Voto> findAll();
    public void registrarVoto(Usuario usuario, Cancion cancion, int voto);
}
