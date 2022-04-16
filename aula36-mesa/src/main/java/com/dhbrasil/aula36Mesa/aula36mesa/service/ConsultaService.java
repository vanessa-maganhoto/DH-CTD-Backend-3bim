package com.dhbrasil.aula36Mesa.aula36mesa.service;

import com.dhbrasil.aula36Mesa.aula36mesa.dto.ConsultaDto;
import com.dhbrasil.aula36Mesa.aula36mesa.dto.PacienteDto;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Consulta;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Paciente;
import com.dhbrasil.aula36Mesa.aula36mesa.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ConsultaService {

    @Autowired
    private final ConsultaRepository consultaRepository;

    public ConsultaService(ConsultaRepository consultaRepository) {
        this.consultaRepository = consultaRepository;
    }

    //Salvar
    @Transactional
    public ConsultaDto cadastrar(ConsultaDto consultaDto) {
        Consulta consulta = consultaRepository.save(consultaDto.toEntity());
        return new ConsultaDto(consulta);
    }
    //Excluir
    @Transactional
    public void excluir(Integer id){
        try{
            consultaRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResponseStatusException(NOT_FOUND, "Consulta não encontrada: " + id);
        }
    }

    //Buscar todos
    @Transactional(readOnly = true)
    public List<ConsultaDto> buscarTodos(){
        return consultaRepository.findAll()
                .stream()
                .map(c-> new ConsultaDto(c))
                .collect(Collectors.toList());

    }

    //BuscaPorId
    @Transactional(readOnly = true)
    public Optional<ConsultaDto> buscarConsultaId(Integer id) {
        return consultaRepository.findById(id)
                .map(c-> new ConsultaDto(c));

    }

    @Transactional
    public Optional<Consulta> atualizarPaciente(ConsultaDto dto) {
        return consultaRepository.findById(dto.getId())
                .map(c -> {
                    c.setDataCad(dto.getDataCad());
                    c.setDataAtend(dto.getDataAtend());
                    c.setPaciente(dto.getPaciente().toEntity());
                    c.setDentista(dto.getDentista().toEntity());
                    c.setUsuario(dto.getUsuario().toEntity());

                    return consultaRepository.save(c);
                });
    }

}

