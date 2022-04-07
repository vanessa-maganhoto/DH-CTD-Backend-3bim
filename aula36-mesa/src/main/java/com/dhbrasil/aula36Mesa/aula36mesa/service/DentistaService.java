package com.dhbrasil.aula36Mesa.aula36mesa.service;

import com.dhbrasil.aula36Mesa.aula36mesa.dto.DentistaDto;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Dentista;
import com.dhbrasil.aula36Mesa.aula36mesa.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DentistaService {

    private DentistaRepository dentistaRepository;

    @Autowired
    public DentistaService(DentistaRepository dentistaRepository) {

        this.dentistaRepository = dentistaRepository;
    }

    @Transactional
    public DentistaDto salvarDentista(DentistaDto dentistaDto) {
        Dentista d = new Dentista();
        d.setNome(dentistaDto.getNome());
        d.setEmail(dentistaDto.getEmail());
        d.setNumMatricula(dentistaDto.getNumMatricula());
        d.setAtendeConvenio(dentistaDto.getAtendeConvenio());
        d = dentistaRepository.save(d);
        return new DentistaDto(d);
    }

    @Transactional
    public void excluirDentista(Integer id) {
        if (dentistaRepository.existsById(id)) {
            dentistaRepository.deleteById(id);
        }
    }

    @Transactional(readOnly = true)
    public List<DentistaDto> buscarTodosDentistas() {

        return dentistaRepository.findAll()
                .stream()
                .map(d -> new DentistaDto(d))
                .collect(Collectors.toList());

//        List<DentistaDto> dentistasDtos = new ArrayList<>();
//        List<Dentista> dentistas = dentistaRepository.findAll();
//        for (Dentista d : dentistas) {
//            dentistasDtos.add(new DentistaDto(d));
//        }
//        return dentistasDtos;
    }

    @Transactional(readOnly = true)
    public Optional<DentistaDto> buscarDentistaId(Integer id) {
        return dentistaRepository.findById(id)
                .map(d -> new DentistaDto(d));

    }

    @Transactional
    public Optional<Dentista> atualizarDentista(DentistaDto dentistaDto) {
        return dentistaRepository.findById(dentistaDto.getId())
                .map(d -> {
                    d.setNome(dentistaDto.getNome());
                    d.setEmail(dentistaDto.getEmail());
                    d.setNumMatricula(dentistaDto.getNumMatricula());
                    d.setAtendeConvenio(dentistaDto.getAtendeConvenio());

                    return dentistaRepository.save(d);
                });
    }

}
