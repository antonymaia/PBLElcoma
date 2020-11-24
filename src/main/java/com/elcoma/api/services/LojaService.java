package com.elcoma.api.services;

import com.elcoma.api.domain.Cupom;
import com.elcoma.api.domain.Loja;
import com.elcoma.api.repositories.LojaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LojaService {
    @Autowired
    private LojaRepository repository;
    // Cadastrando a loja
    public Loja insert(Loja loja){
        loja.setId(null);
        loja = repository.save(loja);
        return loja;
    }
    // Metodo para buscar a loja pelo id
    public Loja buscar(Integer id) {
        Optional<Loja> obj = repository.findById(id);
        return obj.orElse(null);
    }

    public Object update(Loja loja) {
        buscar(loja.getId());
        return repository.save(loja);
    }
}
