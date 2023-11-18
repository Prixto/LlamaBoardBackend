package com.llamaboard.cliente.backend.apirest.models.repository;

import com.llamaboard.cliente.backend.apirest.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository <Usuario, Long> {
}
