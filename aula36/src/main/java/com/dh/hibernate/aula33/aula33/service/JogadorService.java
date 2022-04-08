package com.dh.hibernate.aula33.aula33.service;

import com.dh.hibernate.aula33.aula33.model.Jogador;
import com.dh.hibernate.aula33.aula33.model.Time;
import com.dh.hibernate.aula33.aula33.repository.JogadorRepository;
import com.dh.hibernate.aula33.aula33.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    JogadorRepository jogadorRepository;
    TimeRepository timeRepository;

    @Autowired
    public JogadorService(JogadorRepository jogadorRepository, TimeRepository timeRepository) {
        this.jogadorRepository = jogadorRepository;
        this.timeRepository = timeRepository;
    }

    public Jogador salvarJogador(Jogador jogador) {
        return jogadorRepository.save(jogador);
    }

    public Optional<Jogador> buscarId(Integer id){
        return jogadorRepository.findById(id);
    }

    public List<Jogador> buscarTodosJogadores(){
        return jogadorRepository.findAll();
    }

    public void deletar(Integer id){
        jogadorRepository.delete(jogadorRepository.getById(id));
    }

    public Jogador atualizar(Jogador jogadorAtualizado){
        Jogador jogadorAtual = jogadorRepository.findById(jogadorAtualizado.getId()).orElse(null);

        jogadorAtual.setNome(jogadorAtualizado.getNome());
        jogadorAtual.setPosicao(jogadorAtualizado.getPosicao());
        jogadorAtual.setPeso(jogadorAtualizado.getPeso());


        Time timeAtualizado = jogadorAtual.getTime();
        timeAtualizado.setNome(timeAtualizado.getNome());
        timeAtualizado.setEstado(timeAtualizado.getEstado());
        timeAtualizado.setCidade(timeAtualizado.getCidade());


        return jogadorRepository.save(jogadorAtual);
    }
}

