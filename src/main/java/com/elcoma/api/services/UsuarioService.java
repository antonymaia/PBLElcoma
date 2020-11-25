package com.elcoma.api.services;

import com.elcoma.api.domain.Cupom;
import com.elcoma.api.domain.Loja;
import com.elcoma.api.domain.Usuario;
import com.elcoma.api.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// Anotação usada para especificar que essa classe é um service, aqui é onde se implementa a regra de negocioo
@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    // Método para cadastrar usuario
    public Usuario insert(Usuario usuario){
        usuario.setId(null);
        usuario = repository.save(usuario);
        return usuario;
    }
}
