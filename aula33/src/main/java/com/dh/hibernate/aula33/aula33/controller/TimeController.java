package com.dh.hibernate.aula33.aula33.controller;

import com.dh.hibernate.aula33.aula33.model.Jogador;
import com.dh.hibernate.aula33.aula33.model.Time;
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
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;

    @Autowired
    public TimeController(TimeService timeService) {
        this.timeService = timeService;
    }

    @PostMapping
    public ResponseEntity<?> salvarTime(@RequestBody Time time){
        timeService.salvarTime(time);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> buscar(@PathVariable Integer id){
        return ResponseEntity.ok(timeService.buscar(id).orElseThrow(
                ()-> new ResponseStatusException(NOT_FOUND, "Produto não encontrado")
        ));
    }

    @GetMapping
    public ResponseEntity<List<Time>> buscarTodos(){

        return ResponseEntity.ok(timeService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar (@PathVariable Integer id){
        ResponseEntity<String> response = null;
        Optional<Time> t = timeService.buscar(id);

        if(timeService.buscar(id).isPresent()){
            timeService.deletar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Time excluído");
        } else {
            response = ResponseEntity.status(NOT_FOUND).build();
        }
        return response;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizar(@RequestBody Time time, @PathVariable Integer id){
        ResponseEntity<Time> response = null;
        if (time.getId() != null && timeService.buscar(time.getId()).isPresent()){
            response = ResponseEntity.ok(timeService.atualizar(time));
        } else{
            response = ResponseEntity.status(NOT_FOUND).build();
        }
        return response;
    }

}
