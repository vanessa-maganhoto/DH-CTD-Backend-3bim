package com.dh.hibernate.aula33.aula33.controller;

import com.dh.hibernate.aula33.aula33.model.Jogador;
import com.dh.hibernate.aula33.aula33.model.Time;
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
    public ResponseEntity<?> salvar(@RequestBody Jogador jogador) {
        //timeService.salvarTime(jogador.getTime());
//        return ResponseEntity.ok(jogadorService.salvarJogador(jogador));

        jogadorService.salvarJogador(jogador);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarId(@PathVariable Integer id){
//        timeService.buscar(id);
        return ResponseEntity.ok(jogadorService.buscarId(id).orElseThrow(
                ()-> new ResponseStatusException(NOT_FOUND, "Jogador não encontrado")
        ));
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> buscarTodosJogadores(){
        timeService.buscarTodos();
        return ResponseEntity.ok(jogadorService.buscarTodosJogadores());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar (@PathVariable Integer id){
        ResponseEntity<String> response = null;
        Optional<Jogador> j = jogadorService.buscarId(id);


        if(jogadorService.buscarId(id).isPresent()){
            jogadorService.deletar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Jogador excluído");
        } else {
            response = ResponseEntity.status(NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizar(@RequestBody Jogador jogador, @PathVariable Integer id){
        ResponseEntity<Jogador> response = null;
        if(jogador.getId() != null && jogadorService.buscarId(jogador.getId()).isPresent()) {
            response = ResponseEntity.ok(jogadorService.atualizar(jogador));
        } else {
            response = ResponseEntity.status(NOT_FOUND).build();
        }
        return response;
    }


}
