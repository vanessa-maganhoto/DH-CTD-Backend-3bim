package com.dh.hibernate.aula33.aula33.controller;

import com.dh.hibernate.aula33.aula33.model.Jogador;
import com.dh.hibernate.aula33.aula33.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/jogadores")
public class JogadorController {

    private final JogadorService jogadorService;

    @Autowired
    public JogadorController(JogadorService jogadorService) {
        this.jogadorService = jogadorService;
    }

    @PostMapping
    public ResponseEntity<?> salvarJogador(@RequestBody Jogador jogador){
        jogadorService.salvar(jogador);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscar(@PathVariable Integer id){

        return ResponseEntity.ok(jogadorService.buscar(id).orElseThrow(
                ()-> new ResponseStatusException(NOT_FOUND, "Produto não encontrado")
        ));
    }

    @GetMapping
    public ResponseEntity<List<Jogador>> buscarTodos(){

        return ResponseEntity.ok(jogadorService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar (@PathVariable Integer id){
        ResponseEntity<String> response = null;
        Optional<Jogador> p = jogadorService.buscar(id);

        if(jogadorService.buscar(id).isPresent()){
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
        if (jogador.getId() != null && jogadorService.buscar(jogador.getId()).isPresent()){
            response = ResponseEntity.ok(jogadorService.atualizar(jogador));
        } else{
            response = ResponseEntity.status(NOT_FOUND).build();
        }
        return response;
    }

}
