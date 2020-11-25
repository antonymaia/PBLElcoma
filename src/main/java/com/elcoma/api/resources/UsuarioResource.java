package com.elcoma.api.resources;

import com.elcoma.api.domain.Loja;
import com.elcoma.api.domain.Usuario;
import com.elcoma.api.repositories.UsuarioRepository;
import com.elcoma.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

//Anotação usada para especificar que essa classse é o restController
@RestController
// Anotação usada para especificar o caminho da uri
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    //Anotação para criar um endPoint de méotodo Post, no qual vai inserir um usuario no banco
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Usuario usuario){
        usuario = service.insert(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}

