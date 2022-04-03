package com.dhbrasil.springboot.aula21.controller;

import com.dhbrasil.springboot.aula21.model.Paciente;
import com.dhbrasil.springboot.aula21.model.Usuario;
import com.dhbrasil.springboot.aula21.service.EnderecoService;
import com.dhbrasil.springboot.aula21.service.PacienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import resources.config.ConfiguracaoJDBC;
import resources.impl.EnderecoDaoH2;
import resources.impl.PacienteDaoH2;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private ConfiguracaoJDBC configuracaoJDBC;
    private PacienteService pacienteService = new PacienteService(
            new PacienteDaoH2(new EnderecoDaoH2()));
    private EnderecoService enderecoService = new EnderecoService(
            new EnderecoDaoH2());

    @PostMapping()
    public ResponseEntity<Paciente> salvar(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.salvar(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(@PathVariable Integer id){
        return ResponseEntity.ok(pacienteService.buscar(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> buscarTodos(){

        return ResponseEntity.ok(pacienteService.buscarTodos());
    }

    @PutMapping
    public ResponseEntity<Paciente> atualizar(@RequestBody Paciente paciente){
        ResponseEntity<Paciente> response = null;
        if(paciente.getId() != null && pacienteService.buscar(paciente.getId()).isPresent()){
            response = ResponseEntity.ok(pacienteService.atualizar(paciente));
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id){
        ResponseEntity<String> response = null;

        Optional<Paciente> p = pacienteService.buscar(id);
        Integer endId = p.get().getEndereco().getId();

        if(pacienteService.buscar(id).isPresent()){
            pacienteService.excluir(id);
            enderecoService.excluir(endId);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Paciente excluído");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return response;
    }


}
