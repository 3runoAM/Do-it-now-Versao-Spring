package com.doitnow.doitnow.controllers;

import com.doitnow.doitnow.entities.Tarefa;
import com.doitnow.doitnow.repositorios.TarefasRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edicao")
public class EdicaoController {
    private final TarefasRepo tarefasRepo;
    public EdicaoController(TarefasRepo tarefasRepo) {
        this.tarefasRepo = tarefasRepo;
    }

    @GetMapping
    public String edicao(Model model){
        return "edicao";
    }

    @ModelAttribute("tarefa")
    public Tarefa addTarefaToModel(String id){
        return tarefasRepo.findTarefaById(Long.parseLong(id));
    }
}
