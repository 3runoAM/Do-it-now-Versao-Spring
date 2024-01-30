package com.doitnow.doitnow.controllers;

import com.doitnow.doitnow.entities.Tarefa;
import com.doitnow.doitnow.repositorios.TarefasRepo;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@Controller
@Slf4j
@RequestMapping({"/", "/home"})
public class TarefasController {
    private final TarefasRepo tarefasRepo;

    public TarefasController(TarefasRepo tarefasRepo) {
        this.tarefasRepo = tarefasRepo;
    }

    @GetMapping
    public String tarefas(){
        return "home";
    }

    @PostMapping
    public String adicionarTarefa(@Valid @ModelAttribute Tarefa tarefa, Errors errors){
        if(errors.hasErrors()){
            log.error("Erro de validação na tarefa: " + tarefa.toString());
            log.error("Erros: " + errors.toString());
            return "home";
        }
        tarefasRepo.save(tarefa);
        log.info("Tarefa criada e salva na basa de dados: " + tarefa);
        return "redirect:/home";
    }

    @PatchMapping
    public String concluirTarefa(String id){
        Tarefa tarefa = tarefasRepo.findTarefaById(Long.parseLong(id));
        tarefa.concluirTarefa();
        tarefasRepo.save(tarefa);
        log.info("Tarefa concluída: " + tarefa);
        return "redirect:/home";
    }

    @PutMapping
    public String editarTarefa(@Valid @ModelAttribute Tarefa tarefa, Errors errors){
        if(errors.hasErrors()){
            log.error("Erro de validação ao editar " + tarefa.toString());
            log.error("Erros: " + errors.toString());
            return "edicao";
        }
        tarefasRepo.save(tarefa);
        log.info("Tarefa salva com sucesso" + tarefa);
        return "redirect:/home";
    }

    @DeleteMapping
    public String deletarTarefa(@ModelAttribute Tarefa tarefa, String id){
        log.info("Deletando Tarefa: " + tarefa.toString());
        tarefasRepo.deleteById(Long.parseLong(id));
        log.info("Tarefa deletada com sucesso.");
        return "redirect:/home";
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
