package com.dh.hibernate.aula33.aula33.service;

import com.dh.hibernate.aula33.aula33.model.Jogador;

import java.util.List;
import java.util.Optional;

public interface JogadorService {

    void salvar(Jogador jogador);
    List<Jogador> buscarTodos();
    public Optional<Jogador> buscar(Integer id);
    void deletar (Integer id);
    public Jogador atualizar (Jogador jogador);
}
