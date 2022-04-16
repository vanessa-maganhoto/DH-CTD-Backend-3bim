package com.dhbrasil.aula36Mesa.aula36mesa.controller;

import com.dhbrasil.aula36Mesa.aula36mesa.dto.ConsultaDto;
import com.dhbrasil.aula36Mesa.aula36mesa.dto.PacienteDto;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Consulta;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Paciente;
import com.dhbrasil.aula36Mesa.aula36mesa.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private ConsultaService consultaService;

    @Autowired

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    //Salvar
    @PostMapping
    public ConsultaDto cadastrarConsulta(@RequestBody ConsultaDto consultaDto){
        return consultaService.cadastrar(consultaDto);
    }

    //Excluir
    @DeleteMapping("/{id}")
    public void deletarPaciente(@PathVariable Integer id) {
        consultaService.excluir(id);
    }

    //Buscar todos
    @GetMapping
    public List<ConsultaDto> buscarConsultas(){
        return consultaService.buscarTodos();
    }

    //BuscaPorId
    @GetMapping(value ="/{id}")
    public Optional<ConsultaDto> buscaPacientePorId(@PathVariable Integer id){
        return  consultaService.buscarConsultaId(id);
    }

    //Alterar
    @PutMapping(value ="/{id}")
    public Optional<Consulta> atualizarPaciente(@Valid @RequestBody ConsultaDto consultaDto, @PathVariable Integer id){
        consultaDto.setId(id);
        return consultaService.atualizarPaciente(consultaDto);
    }

}
