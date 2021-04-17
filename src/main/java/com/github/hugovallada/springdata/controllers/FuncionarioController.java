package com.github.hugovallada.springdata.controllers;

import com.github.hugovallada.springdata.entities.Funcionario;
import com.github.hugovallada.springdata.services.FuncionarioService;
import com.github.hugovallada.springdata.services.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    private final RelatorioService relatorioService;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService, RelatorioService relatorioService) {
        this.funcionarioService = funcionarioService;
        this.relatorioService = relatorioService;
    }

    @PostMapping
    public Funcionario cadastrar(@RequestBody Funcionario funcionario){
        return funcionarioService.cadastrar(funcionario);
    }

    @GetMapping
    public Page<Funcionario> buscarTodos(Pageable paginacao){
        return  funcionarioService.listarTodos(paginacao);
    }

    @GetMapping("/{nome}")
    public List<Funcionario> buscarPorNome(@PathVariable String nome){
        return relatorioService.listarTodosPorNome(nome);
    }

    @GetMapping("/{nome}/{salario}/{data}")
    public List<Funcionario> buscarPorNomeSalarioEData(
            @PathVariable String nome,
            @PathVariable String salario,
            @PathVariable String data
            ){

        return relatorioService.buscarPoeNomeSalarioMaiorData(nome, new BigDecimal(salario), LocalDate.parse(data));
    }

}

