package com.doitnow.doitnow.controllers;

import com.doitnow.doitnow.entities.Tarefa;
import com.doitnow.doitnow.repositorios.TarefasRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/edicao")
public class EdicaoController {
    private final TarefasRepo tarefasRepo;

    public EdicaoController(TarefasRepo tarefasRepo) {
        this.tarefasRepo = tarefasRepo;
    }

    @GetMapping
    public String edicao(){
        return "edicao";
    }

    @ModelAttribute("tarefa")
    public Tarefa addTarefaToModelForEditing(String id){
        Tarefa tarefa = tarefasRepo.findTarefaById(Long.parseLong(id));
        log.info("Tarefa requisitada para edição: " + tarefa);
        return tarefa;
    }

}
