package com.doitnow.doitnow.controllers;

import com.doitnow.doitnow.entities.Tarefa;
import com.doitnow.doitnow.enums.Prioridade;
import com.doitnow.doitnow.repositorios.TarefasRepo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;


@Controller
@Slf4j
@RequestMapping("/tarefas")
public class TarefasController {
    private final TarefasRepo tarefasRepo;

    public TarefasController(TarefasRepo tarefasRepo) {
        this.tarefasRepo = tarefasRepo;
    }

    @GetMapping
    public String tarefas() {
        return "tarefas";
    }

    @PostMapping
    public String adicionarTarefa(@Valid @ModelAttribute Tarefa tarefa, Errors errors){
        if(errors.hasErrors()){
            return "tarefas";
        }
        log.info("Tarefa criada: " + tarefa.toString());
        tarefasRepo.save(tarefa);
        return "redirect:/tarefas";
    }

    @PatchMapping
    public String concluirTarefa(String id){
        Tarefa tarefa = tarefasRepo.findTarefaById(Long.parseLong(id));
        tarefa.concluirTarefa();
        tarefasRepo.save(tarefa);
        return "redirect:/tarefas";
    }

    @PutMapping
    public String editarTarefa(@Valid @ModelAttribute Tarefa tarefa, Errors errors, Model model){
        if(errors.hasErrors()){
            return "edicao";
        }
        log.info("Tarefa editada: " + tarefa.toString());
        tarefasRepo.save(tarefa);
        return "redirect:/tarefas";
    }

    @DeleteMapping
    public String deletarTarefa(String id){
        tarefasRepo.deleteById(Long.parseLong(id));
        return "redirect:/tarefas";
    }

    @ModelAttribute("listaDeTarefas")
    public List<Tarefa> addTarefasToModel() {
        List<Tarefa> tarefa = tarefasRepo.findTarefasByConcluido(false);
        tarefa.sort(Comparator.comparing(Tarefa::getPrioridade));
        return tarefa;
    }

    @ModelAttribute("tarefa")
    public Tarefa addTarefaToModel(){
        return new Tarefa();
    }
}

