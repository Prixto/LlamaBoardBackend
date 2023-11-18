package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.models.entity.Cancion;
import com.llamaboard.cliente.backend.apirest.models.entity.Genero;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICancionService {
    public List<Cancion> findAll();
}
