package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.models.entity.Voto;

import java.util.List;

public interface IVotoService {
    public List<Voto> findAll();
}
