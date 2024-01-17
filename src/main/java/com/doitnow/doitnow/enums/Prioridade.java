package com.doitnow.doitnow.enums;

public enum Prioridade {
    ALTA(1),
    MEDIA(2),
    BAIXA(3);
    private final int prioridade;
    Prioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}