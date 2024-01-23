package com.doitnow.doitnow.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/planejamento")
public class PlanejamentoController {
    @GetMapping
    public String planejamento() {
        return "planejamento";
    }
}
