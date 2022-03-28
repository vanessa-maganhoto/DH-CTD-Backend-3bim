package com.dhbrasil.springboot.aula21.controller;

import com.dhbrasil.springboot.aula21.model.Dentista;
import com.dhbrasil.springboot.aula21.service.DentistaService;
import dao.impl.DentistaDaoH2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    private DentistaService dentistaService = new DentistaService(new DentistaDaoH2());

    @PostMapping
    public ResponseEntity<Dentista> cadastrar(@RequestBody Dentista dentista){
        return ResponseEntity.ok(dentistaService.salvar(dentista));
    }



}
