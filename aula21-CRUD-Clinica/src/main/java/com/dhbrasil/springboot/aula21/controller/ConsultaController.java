package com.dhbrasil.springboot.aula21.controller;

import com.dhbrasil.springboot.aula21.model.Consulta;
import com.dhbrasil.springboot.aula21.service.ConsultaService;
import com.dhbrasil.springboot.aula21.service.DentistaService;
import com.dhbrasil.springboot.aula21.service.PacienteService;
import com.dhbrasil.springboot.aula21.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import resources.impl.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private ConsultaService consultaService;

    {
        ConsultaDaoH2 consultaIDao = new ConsultaDaoH2(new DentistaDaoH2(), new PacienteDaoH2(new EnderecoDaoH2()), new UsuarioDaoH2());

        consultaService = new ConsultaService(consultaIDao, new DentistaDaoH2(), new UsuarioDaoH2(), new PacienteDaoH2(new EnderecoDaoH2()));
    }

    private DentistaService dentistaService = new DentistaService(new DentistaDaoH2());
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2(new EnderecoDaoH2()));
    private UsuarioService usuarioService = new UsuarioService(new UsuarioDaoH2());

    @PostMapping()
    public ResponseEntity<Consulta> salvar(@RequestBody Consulta consulta){

        Consulta consultaSalva = consultaService.salvar(consulta);
        return ResponseEntity.ok(consultaService.buscar(consultaSalva.getId()).orElse(null));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscar(@PathVariable Integer id){
        return ResponseEntity.ok(consultaService.buscar(id).orElseThrow(
                () -> new ResponseStatusException(NOT_FOUND, "nao encontrado")
        ));
//        return ResponseEntity.ok(consultaService.buscar(id).orElse(null));
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> buscarTodos(){

        return ResponseEntity.ok(consultaService.buscarTodos());
    }

    @PutMapping
    public ResponseEntity<Consulta> atualizar(@RequestBody Consulta consulta){
        ResponseEntity<Consulta> response = null;
        if(consulta.getId() != null && consultaService.buscar(consulta.getId()).isPresent()){
            response = ResponseEntity.ok(consultaService.atualizar(consulta));
        } else {
            response = ResponseEntity.status(NOT_FOUND).build();
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluir(@PathVariable Integer id){
        ResponseEntity<String> response = null;

        Optional<Consulta> c = consultaService.buscar(id);

        Integer dentId = c.get().getDentista().getId();
        Integer pacId = c.get().getPaciente().getId();
        Integer usId = c.get().getUsuario().getId();

        if(consultaService.buscar(id).isPresent()){
            consultaService.excluir(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Consulta excluída");
        } else {
            response = ResponseEntity.status(NOT_FOUND).build();
        }
        return response;
    }

}
