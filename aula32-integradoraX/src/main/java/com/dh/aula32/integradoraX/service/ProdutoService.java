package com.dh.aula32.integradoraX.service;

import com.dh.aula32.integradoraX.model.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    List<Produto> buscarTodos();
    public Optional <Produto> buscar(Integer id);
    void salvar(Produto produto);
    void deletar (Integer id);

}
