package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.models.repository.ICancionRepository;
import com.llamaboard.cliente.backend.apirest.models.entity.Cancion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CancionServiceImpl implements ICancionService{

    @Autowired
    private ICancionRepository cancionDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cancion>findAll(){
        return (List<Cancion>) cancionDao.findAll();
    }
}
