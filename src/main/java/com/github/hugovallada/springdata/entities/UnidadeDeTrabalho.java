package com.github.hugovallada.springdata.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "unidade_de_trabalho")
public class UnidadeDeTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private String endereco;

    @ManyToMany(mappedBy = "unidades", fetch = FetchType.EAGER)
    private List<Funcionario> funcionarios;

    public UnidadeDeTrabalho(Long id) {
        this.id = id;
    }

    public UnidadeDeTrabalho() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
