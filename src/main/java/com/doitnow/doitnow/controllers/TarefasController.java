package com.doitnow.doitnow.controllers;

import com.doitnow.doitnow.entities.Tarefa;
import com.doitnow.doitnow.enums.Prioridade;
import com.doitnow.doitnow.repositorios.TarefasRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String adicionarTarefa(String descricao, String prioridade, String method) {
        Tarefa tarefa = prioridade == null ? new Tarefa(descricao, Prioridade.BAIXA) :
                new Tarefa(descricao, Prioridade.valueOf(prioridade));
        log.info("Tarefa criada: " + tarefa.toString());
        tarefasRepo.save(tarefa);
        return "redirect:/tarefas";
    }

    @PutMapping
    public String atualizarTarefa(String id){
        Tarefa tarefa = tarefasRepo.findTarefaById(Long.parseLong(id));
        tarefa.setConcluido(true);
        tarefasRepo.save(tarefa);
        return "redirect:/tarefas";
    }

    @DeleteMapping
    public String deletarTarefa(String id){
        tarefasRepo.deleteById(Long.parseLong(id));
        return "redirect:/tarefas";
    }

    @ModelAttribute("listaDeTarefas")
    public List<Tarefa> addTarefasToModel(Model model) {
        List<Tarefa> tarefa = tarefasRepo.findTarefasByConcluido(false);
        tarefa.sort(Comparator.comparing(Tarefa::getPrioridade));
        return tarefa;
    }
}

