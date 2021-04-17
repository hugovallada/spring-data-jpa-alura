package com.github.hugovallada.springdata.services;

import com.github.hugovallada.springdata.entities.UnidadeDeTrabalho;
import com.github.hugovallada.springdata.repositories.UnidadeDeTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnidadeDeTrabalhoService {

    private final UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository;

    @Autowired
    public UnidadeDeTrabalhoService(UnidadeDeTrabalhoRepository unidadeDeTrabalhoRepository) {
        this.unidadeDeTrabalhoRepository = unidadeDeTrabalhoRepository;
    }

    public UnidadeDeTrabalho cadastrar(UnidadeDeTrabalho unidadeDeTrabalho){
        return unidadeDeTrabalhoRepository.save(unidadeDeTrabalho);
    }
}
