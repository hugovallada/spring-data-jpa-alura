package com.github.hugovallada.springdata.services;

import com.github.hugovallada.springdata.entities.Funcionario;
import com.github.hugovallada.springdata.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioService {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public RelatorioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarTodosPorNome(String nome){
        return funcionarioRepository.findByNome(nome);
    }

    public List<Funcionario> buscarPoeNomeSalarioMaiorData(String nome, BigDecimal salario, LocalDate data){
        return funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, data);
    }
}
