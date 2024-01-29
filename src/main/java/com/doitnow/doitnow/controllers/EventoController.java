package com.doitnow.doitnow.controllers;

import com.doitnow.doitnow.dto.EventoDto;
//import com.doitnow.doitnow.mappers.EventoMapper;
import com.doitnow.doitnow.mappers.EventoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/evento")
public class EventoController {
    private final EventoMapper mapper;

    public EventoController(EventoMapper mapper) {
        this.mapper = mapper;
    }
    /**/

    @GetMapping
    public String eventos(){
        return "planejamento";
    }

    @PostMapping
    public String adicionarEvento(@ModelAttribute EventoDto eventoDto){
        log.info("Evento recebido: " + eventoDto.toString());
//        mapper.toEvento(eventoDto);
        return "redirect:/evento";
    }

    @ModelAttribute("eventoDto")
    public EventoDto addEventoDtoToModel(){
        return new EventoDto();
    }
}
