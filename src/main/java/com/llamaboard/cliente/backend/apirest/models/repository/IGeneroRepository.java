package com.llamaboard.cliente.backend.apirest.models.repository;

import com.llamaboard.cliente.backend.apirest.models.entity.Genero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGeneroRepository extends CrudRepository<Genero, Long> {
}
