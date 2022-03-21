package com.dhbrasil.mvc.aula22.controller;

import com.dhbrasil.mvc.aula22.model.Paciente;
import com.dhbrasil.mvc.aula22.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/index")
public class PacienteController {


    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping
    public List<Paciente> buscarPacientes(){
        return pacienteService.listPaciente();
    }
}
