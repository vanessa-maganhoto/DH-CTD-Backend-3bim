package com.dhbrasil.mvc.aula22.controller;

import com.dhbrasil.mvc.aula22.model.Trainer;
import com.dhbrasil.mvc.aula22.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/trainer")
public class TrainerController {

    private TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @GetMapping
    public List<Trainer> buscarTodos(){
        return trainerService.listTrainer();
    }
}
