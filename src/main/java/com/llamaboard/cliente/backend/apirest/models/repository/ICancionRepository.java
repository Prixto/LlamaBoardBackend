package com.llamaboard.cliente.backend.apirest.models.repository;

import com.llamaboard.cliente.backend.apirest.models.entity.Cancion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICancionRepository extends CrudRepository<Cancion, Long> {
}
