package com.llamaboard.cliente.backend.apirest.models.repository;

import com.llamaboard.cliente.backend.apirest.models.entity.Voto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVotoRepository extends CrudRepository<Voto, Long> {
}
