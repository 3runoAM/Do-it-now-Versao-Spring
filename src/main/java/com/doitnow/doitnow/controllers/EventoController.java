package com.doitnow.doitnow.controllers;

import com.doitnow.doitnow.dto.EventoDto;
//import com.doitnow.doitnow.mappers.EventoMapper;
import com.doitnow.doitnow.entities.Evento;
import com.doitnow.doitnow.mappers.EventoMapper;
import com.doitnow.doitnow.repositorios.EventosRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/evento")
public class EventoController {
    private final EventoMapper mapper;
    private final EventosRepo eventosRepo;

    public EventoController(EventoMapper mapper, EventosRepo eventosRepo) {
        this.mapper = mapper;
        this.eventosRepo = eventosRepo;
    }
    /**/

    @GetMapping
    public String eventos(){
        return "planejamento";
    }

    @PostMapping
    public String adicionarEvento(@ModelAttribute EventoDto eventoDto){
        log.info("Evento recebido: " + eventoDto.toString());
        eventosRepo.save(mapper.toEvento(eventoDto));
        log.info("Evento salvo");
        return "redirect:/evento";
    }
    
    @ModelAttribute("evento")
    public EventoDto eventoDto(){
        return new EventoDto();
    }
}
