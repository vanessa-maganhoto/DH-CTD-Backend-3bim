package com.dhbrasil.aula36Mesa.aula36mesa.controller;

import com.dhbrasil.aula36Mesa.aula36mesa.dto.DentistaDto;
import com.dhbrasil.aula36Mesa.aula36mesa.dto.EnderecoDto;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Dentista;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Endereco;
import com.dhbrasil.aula36Mesa.aula36mesa.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    private final EnderecoService enderecoService;

    @Autowired
    public EnderecoController(EnderecoService enderecoService) {
        this.enderecoService = enderecoService;
    }

    //Salvar
    @PostMapping
    public EnderecoDto inserirCadastro(@RequestBody EnderecoDto dto){

        return enderecoService.cadastrar(dto);
    }

    //Excluir
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) throws Exception{
        enderecoService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    //Buscar todos
    @GetMapping
    public List<EnderecoDto> buscarEnderecos(){
        return enderecoService.buscarTodos();
    }

    //BuscaPorId
    @GetMapping(value ="/{id}")
    public Optional<EnderecoDto> buscaEnderecoPorId(@PathVariable Integer id){
        return  enderecoService.buscarEnderecoId(id);
    }

    //Alterar
    @PutMapping(value ="/{id}")
    public Optional<Endereco> atualizarEndereco(@Valid @RequestBody EnderecoDto enderecoDto, @PathVariable Integer id){
        enderecoDto.setId(id);
        return enderecoService.atualizarEndereco(enderecoDto);
    }
}
