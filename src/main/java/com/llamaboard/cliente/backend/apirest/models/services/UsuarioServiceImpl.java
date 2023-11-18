package com.llamaboard.cliente.backend.apirest.models.services;

import com.llamaboard.cliente.backend.apirest.models.repository.IUsuarioRepository;
import com.llamaboard.cliente.backend.apirest.models.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class UsuarioServiceImpl implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioDao;

    @Override
    @Transactional(readOnly = true)
    public List<Usuario> findAll(){
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    public Usuario crear(Usuario usuario) {
        Usuario newUser = new Usuario();
        newUser.setId(null);
        newUser.setNombre(usuario.getNombre());
        newUser.setApellido(usuario.getApellido());
        newUser.setPassword(usuario.getPassword());
        newUser.setEmail(usuario.getEmail());
        newUser.setTipoUsuario(false);
        return usuarioDao.save(newUser);
    }
}
