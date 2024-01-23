package com.doitnow.doitnow.entities;

import com.doitnow.doitnow.enums.Prioridade;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "A descrição não pode estar vazia")
    @Size(min = 3, max = 15, message = "A descrição deve conter entre 3 e 15 caracteres")
    private String descricao;

    private Prioridade prioridade;
    private LocalDate dataCriacao = LocalDate.now();
    private String dataConclusao = null;
    private boolean concluido = false;

    public void concluirTarefa(){
        this.concluido = true;
        this.dataConclusao = LocalDate.now().toString();
    }
}
