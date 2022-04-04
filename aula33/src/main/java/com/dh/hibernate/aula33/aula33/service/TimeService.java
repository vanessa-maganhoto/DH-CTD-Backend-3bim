package com.dh.hibernate.aula33.aula33.service;

import com.dh.hibernate.aula33.aula33.model.Jogador;
import com.dh.hibernate.aula33.aula33.model.Time;

import java.util.List;
import java.util.Optional;

public interface TimeService{

    void salvarTime(Time time);
    List<Time> buscarTodos();
    public Optional<Time> buscar(Integer id);
    void deletar (Integer id);
    public Time atualizar (Time time);

}
