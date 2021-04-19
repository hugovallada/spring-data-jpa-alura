package com.github.hugovallada.springdata.controllers;

import com.github.hugovallada.springdata.entities.Funcionario;
import com.github.hugovallada.springdata.entities.FuncionarioProjecao;
import com.github.hugovallada.springdata.services.FuncionarioService;
import com.github.hugovallada.springdata.services.RelatorioFuncionarioDinamico;
import com.github.hugovallada.springdata.services.RelatorioService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    private final RelatorioService relatorioService;

    private final RelatorioFuncionarioDinamico rfDinamico;

    @Autowired
    public FuncionarioController(FuncionarioService funcionarioService, RelatorioService relatorioService, RelatorioFuncionarioDinamico rfDinamico) {
        this.funcionarioService = funcionarioService;
        this.relatorioService = relatorioService;
        this.rfDinamico = rfDinamico;
    }

    @PostMapping
    public Funcionario cadastrar(@RequestBody Funcionario funcionario) {
        return funcionarioService.cadastrar(funcionario);
    }

    @GetMapping
    public Page<Funcionario> buscarTodos(Pageable paginacao) {
        return funcionarioService.listarTodos(paginacao);
    }

    @GetMapping("/{nome}")
    public List<Funcionario> buscarPorNome(@PathVariable String nome) {
        return relatorioService.listarTodosPorNome(nome);
    }

    @GetMapping("/{nome}/{salario}/{data}")
    public List<Funcionario> buscarPorNomeSalarioEData(
            @PathVariable String nome,
            @PathVariable String salario,
            @PathVariable String data
    ) {

        return relatorioService.buscarPoeNomeSalarioMaiorData(nome, new BigDecimal(salario), LocalDate.parse(data));
    }

    @GetMapping("/salario")
    public List<FuncionarioProjecao> buscarPorSalario() {
        return funcionarioService.buscarSalario();
    }

    @GetMapping("/relatorio")
    public List<Funcionario> buscaDinamica(
            @RequestParam(required = false) String nome,
            @RequestParam(required = false) String salario,
            @RequestParam(required = false) String data,
            @RequestParam(required = false) String cpf
    ) {

//        BigDecimal salarioD = null;
//        LocalDate dataContratacao = null;
//        if(salario != null) {
//            salarioD = new BigDecimal(salario);
//        }
//
//        if(data != null){
//            dataContratacao = LocalDate.parse(data);
//        }

        return rfDinamico.consultaDinamica(nome, salario != null ? new BigDecimal(salario) : null, data != null ? LocalDate.parse(data) : null, cpf);
    }
}



