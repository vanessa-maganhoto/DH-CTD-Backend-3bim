package com.dhbrasil.mvc.aula22.service.impl;

import com.dhbrasil.mvc.aula22.model.Paciente;
import com.dhbrasil.mvc.aula22.service.PacienteService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Override
    public List<Paciente> listPaciente(){
        return Arrays.asList(
                new Paciente("AAAA"),
                new Paciente("LLLL"),
                new Paciente("telegram")
        );
    }
}
