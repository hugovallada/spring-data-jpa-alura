package com.github.hugovallada.springdata.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    private BigDecimal salario;

    private LocalDate dataContratacao;

    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "funcionarios_unidades", joinColumns = {
            @JoinColumn(name = "fk_funcionario")
    }, inverseJoinColumns = {
            @JoinColumn(name = "fk_unidade")
    })
    private List<UnidadeDeTrabalho> unidades;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getDataContratacao() {
        return dataContratacao;
    }

    public void setDataContratacao(LocalDate dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
