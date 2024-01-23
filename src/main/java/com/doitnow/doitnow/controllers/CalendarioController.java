package com.doitnow.doitnow.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
@Slf4j
@RequestMapping("/calendario")
public class CalendarioController {
    @GetMapping
    public String calendario(Model model) {
        model.addAttribute("standardDate", LocalDateTime.now());
        return "calendario";
    }
}
