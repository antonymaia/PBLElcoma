package com.elcoma.api.services;

import com.elcoma.api.domain.Usuario;
import com.elcoma.api.repositories.UsuarioRepository;
import com.elcoma.api.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
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

    public Usuario findById(Integer id){
        Optional<Usuario> usuario = repository.findById(id);
        return usuario.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado: Id: " + id + ", Tipo: " + Usuario.class.getName()));
    }

    public List<Usuario> findAll(){
        return repository.findAll();
    }


    public Usuario update(Usuario usuario){
        Usuario newUsuario = findById(usuario.getId());
        newUsuario.setCpf(usuario.getCpf());
        newUsuario.setEmail(usuario.getEmail());
        newUsuario.setNascimento(usuario.getNascimento());
        newUsuario.setSexo(usuario.getSexo());
        newUsuario.setNome(usuario.getNome());
        newUsuario.setEndereco(usuario.getEndereco());
        return repository.save(newUsuario);
    }
}
