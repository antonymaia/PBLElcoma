package com.elcoma.api.resources;

import com.elcoma.api.domain.Cupom;
import com.elcoma.api.domain.Loja;
import com.elcoma.api.services.LojaService;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping(value = "/lojas")
public class LojaResource {
    @Autowired
    private LojaService service;


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody Loja loja){
        loja = service.insert(loja);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(loja.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
    //Metodo  get para uma loja específica

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Integer id){
        Loja obj = service.buscar(id);
        return ResponseEntity.ok().body(obj);
    }

    //Metodo put para att uma loja
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Void> update(@RequestBody Loja loja, @PathVariable Integer id) {
        loja.setId(id);
        service.update(loja);
        return ResponseEntity.noContent().build();
    }





}
