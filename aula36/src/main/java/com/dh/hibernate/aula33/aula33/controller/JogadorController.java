package com.dh.hibernate.aula33.aula33.controller;

import com.dh.hibernate.aula33.aula33.model.Jogador;
import com.dh.hibernate.aula33.aula33.service.JogadorService;
import com.dh.hibernate.aula33.aula33.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private JogadorService jogadorService;
    private TimeService timeService;

    @Autowired
    public JogadorController(JogadorService jogadorService, TimeService timeService) {
        this.jogadorService = jogadorService;
        this.timeService = timeService;
    }

    @PostMapping
    public ResponseEntity<Jogador> salvar(@RequestBody Jogador jogador) {
        timeService.salvarTime(jogador.getTime());
        return ResponseEntity.ok(jogadorService.salvarJogador(jogador));
    }

}
