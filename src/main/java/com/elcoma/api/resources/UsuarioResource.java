package com.elcoma.api.resources;

import com.elcoma.api.domain.Usuario;
import com.elcoma.api.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

    @Autowired
    private UsuarioService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@Valid @RequestBody Usuario usuario) {
        usuario = service.insert(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> find(@PathVariable Integer id) {

        Usuario usuario = service.findById(id);
        return ResponseEntity.ok().body(usuario);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Usuario>> findAll() {
        List<Usuario> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@Valid @RequestBody Usuario usuario, @PathVariable Integer id) {
        usuario.setId(id);
        usuario = service.update(usuario);
        return ResponseEntity.noContent().build();
    }
}

