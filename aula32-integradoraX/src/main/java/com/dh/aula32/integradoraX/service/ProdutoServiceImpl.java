package com.dh.aula32.integradoraX.service;

import com.dh.aula32.integradoraX.model.Produto;
import com.dh.aula32.integradoraX.repository.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService{

    private final ProdutoRepositorio produtoRepositorio;

    @Autowired
    public ProdutoServiceImpl(ProdutoRepositorio produtoRepositorio) {
        this.produtoRepositorio = produtoRepositorio;
    }

    @Override
    public void salvar(Produto produto){

        produtoRepositorio.save(produto);
    }

    @Override
    public Optional<Produto> buscar(Integer id) {
        return produtoRepositorio.findById(id);

    }

    @Override
    public void deletar(Integer id){
        produtoRepositorio.delete(produtoRepositorio.getById(id));
    }

    @Override
    public List<Produto> buscarTodos(){
        return produtoRepositorio.findAll();
    }
}
