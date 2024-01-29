package com.doitnow.doitnow.repositorios;

import com.doitnow.doitnow.entities.Evento;
import lombok.NonNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventosRepo extends CrudRepository<Evento, Long> {

    @Override
    @NonNull
    List<Evento> findAll();

    Evento findTarefaById(Long id);
}