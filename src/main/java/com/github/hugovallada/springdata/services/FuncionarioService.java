package com.github.hugovallada.springdata.services;

import com.github.hugovallada.springdata.entities.Funcionario;
import com.github.hugovallada.springdata.entities.FuncionarioProjecao;
import com.github.hugovallada.springdata.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Page<Funcionario> listarTodos(Pageable paginacao){
        return funcionarioRepository.findAll(paginacao);
    }

    public List<FuncionarioProjecao> buscarSalario(){
        return funcionarioRepository.findFuncionSalario();
    }
}
