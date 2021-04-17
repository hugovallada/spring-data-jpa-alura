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

    @ManyToMany(mappedBy = "unidades")
    private List<Funcionario> funcionarios;

}
