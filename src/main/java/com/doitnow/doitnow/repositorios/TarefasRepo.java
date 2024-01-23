package com.doitnow.doitnow.repositorios;

import com.doitnow.doitnow.entities.Tarefa;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TarefasRepo extends CrudRepository<Tarefa, Long> {
     List<Tarefa> findTarefasByConcluido(Boolean concluido);
     @Override
     List<Tarefa> findAll();
     Tarefa findTarefaById(Long id);

}
