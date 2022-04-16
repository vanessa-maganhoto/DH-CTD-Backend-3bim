package com.dhbrasil.aula36Mesa.aula36mesa.controller;

import com.dhbrasil.aula36Mesa.aula36mesa.dto.DentistaDto;
import com.dhbrasil.aula36Mesa.aula36mesa.dto.EnderecoDto;
import com.dhbrasil.aula36Mesa.aula36mesa.dto.PacienteDto;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Endereco;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Paciente;
import com.dhbrasil.aula36Mesa.aula36mesa.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private PacienteService pacienteService;
    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }




    //Salvar
    @PostMapping
    public PacienteDto cadastrarPaciente(@RequestBody PacienteDto pacienteDto){
        return pacienteService.cadastrar(pacienteDto);
    }

    //Excluir
    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable Integer id) {
        pacienteService.excluir(id);
    }

    //Buscar todos
    @GetMapping
    public List<PacienteDto> buscarPacientes(){
        return pacienteService.buscarTodos();
    }

    //BuscaPorId
    @GetMapping(value ="/{id}")
    public Optional<PacienteDto> buscaPacientePorId(@PathVariable Integer id){
        return  pacienteService.buscarPacienteId(id);
    }

    //Alterar
    @PutMapping(value ="/{id}")
    public Optional<Paciente> atualizarPaciente(@Valid @RequestBody PacienteDto pacienteDto, @PathVariable Integer id){
        pacienteDto.setId(id);
        return pacienteService.atualizarPaciente(pacienteDto);
    }

}
