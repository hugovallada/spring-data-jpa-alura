package com.github.hugovallada.springdata.services;

import com.github.hugovallada.springdata.entities.Funcionario;
import com.github.hugovallada.springdata.repositories.FuncionarioRepository;
import com.github.hugovallada.springdata.specification.SpecificationFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class RelatorioFuncionarioDinamico {

    private final FuncionarioRepository funcionarioRepository;

    @Autowired
    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }


    public List<Funcionario> consulta(String nome){
        return funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.nome(nome)));
    }

    public List<Funcionario> consultaPorMaiorSalario(BigDecimal salario){
        return funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.salario(salario)));
    }

    public List<Funcionario> consultaPorDataContratacao(LocalDate data){
        return funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.contratacao(data)));
    }

    public List<Funcionario> consultaPorCpf(String cpf) {
        return funcionarioRepository.findAll(Specification.where(SpecificationFuncionario.cpf(cpf)));
    }
}
