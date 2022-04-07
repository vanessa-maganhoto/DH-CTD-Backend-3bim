package com.dhbrasil.aula36Mesa.aula36mesa.controller;

import com.dhbrasil.aula36Mesa.aula36mesa.dto.DentistaDto;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Dentista;
import com.dhbrasil.aula36Mesa.aula36mesa.service.DentistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/dentistas")
public class DentistaController {

    private DentistaService dentistaService;

    @Autowired
    public DentistaController(DentistaService dentistaService) {
        this.dentistaService = dentistaService;
    }

    @PostMapping
    public ResponseEntity<?> salvarDentista( @Valid @RequestBody DentistaDto dentistaDto){
        dentistaService.salvarDentista(dentistaDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<DentistaDto> buscarDentistas(){
        return dentistaService.buscarTodosDentistas();
    }

    @GetMapping(value ="/{id}")
    public Optional<DentistaDto> buscaDentistaPorId(@PathVariable Integer id){
        return  dentistaService.buscarDentistaId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarDentista(@PathVariable Integer id){
        dentistaService.excluirDentista(id);
    }

    @PutMapping(value ="/{id}")
        public Optional<Dentista> atualizarCadDentista(@Valid @RequestBody DentistaDto dentistaDto, @PathVariable Integer id){
            dentistaDto.setId(id);
            return dentistaService.atualizarDentista(dentistaDto);
    }

}
