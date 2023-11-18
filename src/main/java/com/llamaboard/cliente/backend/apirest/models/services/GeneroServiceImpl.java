package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.models.repository.IGeneroRepository;
import com.llamaboard.cliente.backend.apirest.models.entity.Genero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GeneroServiceImpl implements IGeneroService {
    @Autowired
    private IGeneroRepository generoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Genero> findAll(){
        return (List<Genero>) generoDao.findAll();
    }
}
