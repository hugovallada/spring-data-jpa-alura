package com.github.hugovallada.springdata.repositories;

import com.github.hugovallada.springdata.entities.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepository extends CrudRepository<Funcionario, Long> {
}
