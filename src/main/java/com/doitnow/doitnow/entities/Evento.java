package com.doitnow.doitnow.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCriacao;
    private boolean diaTodo;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalTime horaInicio;
    private LocalTime horaFim;
    @ElementCollection // Indica que diasDaSemana não é uma coleção de entidade, mas sim uma coleção de valores simples
    private List<Integer> diasDaSemana; // 0 = domingo, 1 = segunda, 2 = terça, 3 = quarta, 4 = quinta, 5 = sexta, 6...
    private String corDeBackground;

    public Evento() {
        this.dataCriacao = LocalDateTime.now();
        this.titulo = "Sem título";
        this.descricao = "Sem descrição";
    }
}
