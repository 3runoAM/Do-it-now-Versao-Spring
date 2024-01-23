package com.doitnow.doitnow.controllers;


import com.doitnow.doitnow.entities.Tarefa;
import com.doitnow.doitnow.repositorios.TarefasRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Comparator;
import java.util.List;

@Controller
@Slf4j
@RequestMapping("/historico")
public class HistoricoController {
    private final TarefasRepo tarefasRepo;
    public HistoricoController(TarefasRepo tarefasRepo) {
        this.tarefasRepo = tarefasRepo;
    }

    @GetMapping
    public String historico(){
        return "historico";
    }

    @ModelAttribute("tarefas")
    public List<Tarefa> addTarefasToModel(){
        List<Tarefa> tarefas = tarefasRepo.findAll();
        tarefas.sort(Comparator.comparing(Tarefa::getDataCriacao).reversed());
        return tarefas;
    }
}
