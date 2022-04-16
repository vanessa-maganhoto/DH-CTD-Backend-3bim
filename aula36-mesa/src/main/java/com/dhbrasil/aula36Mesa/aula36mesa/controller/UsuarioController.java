package com.dhbrasil.aula36Mesa.aula36mesa.controller;

import com.dhbrasil.aula36Mesa.aula36mesa.dto.EnderecoDto;
import com.dhbrasil.aula36Mesa.aula36mesa.dto.UsuarioDto;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Endereco;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Usuario;
import com.dhbrasil.aula36Mesa.aula36mesa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    //Salvar
    @PostMapping
    public UsuarioDto inserirCadastro(@RequestBody UsuarioDto dto){

        return usuarioService.cadastrar(dto);
    }

    //Excluir
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) throws Exception{
        usuarioService.excluir(id);
        return ResponseEntity.noContent().build();
    }

    //Buscar todos
    @GetMapping
    public List<UsuarioDto> buscarUsuarios(){
        return usuarioService.buscarTodos();
    }

    //BuscaPorId
    @GetMapping(value ="/{id}")
    public Optional<UsuarioDto> buscaEnderecoPorId(@PathVariable Integer id){
        return  usuarioService.buscarUsuarioId(id);
    }

    //Alterar
    @PutMapping(value ="/{id}")
    public Optional<Usuario> atualizarUsuario(@Valid @RequestBody UsuarioDto usuarioDto, @PathVariable Integer id){
        usuarioDto.setId(id);
        return usuarioService.atualizarUsuario(usuarioDto);
    }
}
