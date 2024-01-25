package com.doitnow.doitnow.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titulo = "Sem título";
    private String descricao = "Sem descrição";
    private LocalDateTime dataCriacao = LocalDateTime.now();
    private boolean diaTodo;
    private LocalDateTime DataInicio;
    private LocalDateTime DataFim;
    private String cor;
}
