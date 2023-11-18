package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.models.repository.IVotoRepository;
import com.llamaboard.cliente.backend.apirest.models.entity.Voto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VotoServiceImpl implements IVotoService{

    @Autowired
    private IVotoRepository votoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Voto> findAll(){
        return (List<Voto>) votoDao.findAll();
    }
}
