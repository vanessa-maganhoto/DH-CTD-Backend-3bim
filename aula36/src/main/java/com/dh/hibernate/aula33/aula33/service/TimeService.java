package com.dh.hibernate.aula33.aula33.service;

import com.dh.hibernate.aula33.aula33.model.Time;
import com.dh.hibernate.aula33.aula33.repository.TimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeService{


    private final TimeRepository timeRepository;

    @Autowired
    public TimeService(TimeRepository timeRepository) {
        this.timeRepository = timeRepository;
    }

    public void salvarTime(Time time){
        timeRepository.save(time);
    }

    public Optional<Time> buscar(Integer id){
        return timeRepository.findById(id);
    }

    public List<Time> buscarTodos(){
        return timeRepository.findAll();
    }

    public void deletar(Integer id){
        timeRepository.delete(timeRepository.getById(id));
    }

    public Time atualizar(Time timeAtualizado){
        Time timeAtual = timeRepository.findById(timeAtualizado.getId()).orElse(null);

        timeAtual.setNome(timeAtualizado.getNome());
        timeAtual.setCidade(timeAtualizado.getCidade());
        timeAtual.setEstado(timeAtualizado.getEstado());

        return timeRepository.save(timeAtual);
    }

}
