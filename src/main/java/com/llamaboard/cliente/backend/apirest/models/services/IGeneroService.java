package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.models.entity.Genero;

import java.util.List;

public interface IGeneroService {
    public List<Genero> findAll();
}
