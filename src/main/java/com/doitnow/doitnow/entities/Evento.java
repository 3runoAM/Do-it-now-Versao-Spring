package com.doitnow.doitnow.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
    private LocalDate dataFinal;
    private LocalTime horaInicio;
    private LocalTime horaFinal;
    @ElementCollection // Indica que diasDaSemana não é uma coleção de entidade, mas sim uma coleção de valores simples
    private List<Integer> diasDaSemana; // 0 = domingo, 1 = segunda, 2 = terça, 3 = quarta, 4 = quinta, 5 = sexta, 6...
    private String corDeBackground;

    public Evento() {
        this.dataCriacao = LocalDateTime.now();
    }

    /**/
    public static List<Integer> getDiasDaSemanaEntreDatas(LocalDate dataInicial, LocalDate dataFinal) {
        List<Integer> diasDaSemana = new ArrayList<>();
        while (!dataInicial.isAfter(dataFinal)) {
            int diaDaSemana = dataInicial.getDayOfWeek().getValue() % 7;
            diasDaSemana.add(diaDaSemana);
            dataInicial = dataInicial.plusDays(1);
        }
        return diasDaSemana;
    }
}
