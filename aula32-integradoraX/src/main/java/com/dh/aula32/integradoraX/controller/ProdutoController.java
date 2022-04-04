package com.dh.aula32.integradoraX.controller;

import com.dh.aula32.integradoraX.model.Produto;
import com.dh.aula32.integradoraX.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<?> salvarProduto(@RequestBody Produto produto){
        produtoService.salvar(produto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Integer id){

       return ResponseEntity.ok(produtoService.buscar(id).orElseThrow(
               ()-> new ResponseStatusException(NOT_FOUND, "Produto não encontrado")
       ));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar (@PathVariable Integer id){
        ResponseEntity<String> response = null;
        Optional<Produto> p = produtoService.buscar(id);

        if(produtoService.buscar(id).isPresent()){
            produtoService.deletar(id);
            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Produto excluído");
        } else {
            response = ResponseEntity.status(NOT_FOUND).build();
        }
        return response;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> buscarTodos(){

        return ResponseEntity.ok(produtoService.buscarTodos());
    }
}
