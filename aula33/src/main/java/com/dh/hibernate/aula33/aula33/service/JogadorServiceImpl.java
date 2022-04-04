package com.dh.hibernate.aula33.aula33.service;

import com.dh.hibernate.aula33.aula33.model.Jogador;
import com.dh.hibernate.aula33.aula33.model.Time;
import com.dh.hibernate.aula33.aula33.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JogadorServiceImpl implements JogadorService{

    private final JogadorRepository jogadorRepository;

    @Autowired
    public JogadorServiceImpl(JogadorRepository jogadorRepository) {
        this.jogadorRepository = jogadorRepository;
    }

    @Override
    public void salvar(Jogador jogador){
        jogadorRepository.save(jogador);
    }

    @Override
    public Optional<Jogador> buscar(Integer id){
        return jogadorRepository.findById(id);
    }

    @Override
    public List<Jogador> buscarTodos(){
        return jogadorRepository.findAll();
    }

    @Override
    public void deletar(Integer id){
        jogadorRepository.delete(jogadorRepository.getById(id));
    }

    @Override
    public Jogador atualizar(Jogador jogadorAtualizado){
        Jogador jogadorAtual = jogadorRepository.findById(jogadorAtualizado.getId()).orElse(null);

        jogadorAtual.setNome(jogadorAtualizado.getNome());
        jogadorAtual.setAltura(jogadorAtualizado.getAltura());
        jogadorAtual.setPosicao(jogadorAtualizado.getPosicao());
        jogadorAtual.setPeso(jogadorAtualizado.getPeso());
        jogadorAtual.setTime(jogadorAtualizado.getTime());


            return jogadorRepository.save(jogadorAtual);
    }
}
