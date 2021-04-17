package com.github.hugovallada.springdata.services;

import com.github.hugovallada.springdata.entities.Funcionario;
import com.github.hugovallada.springdata.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario cadastrar(Funcionario funcionario){
        return funcionarioRepository.save(funcionario);
    }
}
