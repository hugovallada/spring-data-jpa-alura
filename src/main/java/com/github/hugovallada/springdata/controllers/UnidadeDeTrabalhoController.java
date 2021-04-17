package com.github.hugovallada.springdata.controllers;

import com.github.hugovallada.springdata.entities.UnidadeDeTrabalho;
import com.github.hugovallada.springdata.services.UnidadeDeTrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("unidades")
public class UnidadeDeTrabalhoController {

    private final UnidadeDeTrabalhoService unidadeDeTrabalhoService;

    @Autowired
    public UnidadeDeTrabalhoController(UnidadeDeTrabalhoService unidadeDeTrabalhoService) {
        this.unidadeDeTrabalhoService = unidadeDeTrabalhoService;
    }

    @PostMapping
    public UnidadeDeTrabalho cadastrar(@RequestBody UnidadeDeTrabalho unidadeDeTrabalho){
        return unidadeDeTrabalhoService.cadastrar(unidadeDeTrabalho);
    }
}
