package com.elcoma.api.services;

import com.elcoma.api.domain.Cupom;
import com.elcoma.api.repositories.CupomRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CupomService {
    @Autowired
    private CupomRepository repository;

    public Cupom insert(Cupom cupom){
        cupom.setId(null);
        cupom = repository.save(cupom);
        return cupom;
    }

    public Cupom buscar(Integer id){
        Optional<Cupom> cupom = repository.findById(id);
        return cupom.orElse(null);
    }

    public Object update(Cupom cupom) {
        buscar(cupom.getId());
        return repository.save(cupom);
    }
}
