package com.doitnow.doitnow.repositorios;

import com.doitnow.doitnow.entities.Tarefa;
import io.micrometer.core.lang.NonNullApi;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TarefasRepo extends CrudRepository<Tarefa, Long> {
     List<Tarefa> findTarefasByConcluido(Boolean concluido);
     @Override
     @NonNull
     List<Tarefa> findAll();
     Tarefa findTarefaById(Long id);

}
