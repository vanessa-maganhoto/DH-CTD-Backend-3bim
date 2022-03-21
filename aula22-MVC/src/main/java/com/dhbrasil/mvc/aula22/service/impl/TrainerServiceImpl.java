package com.dhbrasil.mvc.aula22.service.impl;

import com.dhbrasil.mvc.aula22.model.Trainer;
import com.dhbrasil.mvc.aula22.service.TrainerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class TrainerServiceImpl implements TrainerService {

    @Override
    public List<Trainer> listTrainer(){
        return Arrays.asList(
                new Trainer("Paulo"),
                new Trainer("Luiz"),
                new Trainer("Marcos")
        );
    }
}
