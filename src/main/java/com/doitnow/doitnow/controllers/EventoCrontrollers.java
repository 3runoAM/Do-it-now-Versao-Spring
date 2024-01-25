package com.doitnow.doitnow.controllers;

import com.doitnow.doitnow.entities.Evento;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/evento")
public class EventoCrontrollers {
    @GetMapping
    public String eventos(Model model){
        model.addAttribute("evento", new Evento());
        return "planejamento";
    }
}
