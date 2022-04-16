package com.dhbrasil.aula36Mesa.aula36mesa.service;

import com.dhbrasil.aula36Mesa.aula36mesa.dto.EnderecoDto;
import com.dhbrasil.aula36Mesa.aula36mesa.dto.PacienteDto;
import com.dhbrasil.aula36Mesa.aula36mesa.dto.UsuarioDto;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Endereco;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Paciente;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Usuario;
import com.dhbrasil.aula36Mesa.aula36mesa.repository.EnderecoRepository;
import com.dhbrasil.aula36Mesa.aula36mesa.repository.PacienteRepository;
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
public class PacienteService {

    private final PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    //Salvar
    @Transactional
    public PacienteDto cadastrar(PacienteDto pacienteDto) {
        Paciente paciente = pacienteRepository.save(pacienteDto.toEntity());
        return new PacienteDto(paciente);
    }
    //Excluir
    @Transactional
    public void excluir(Integer id){
        try{
            pacienteRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResponseStatusException(NOT_FOUND, "Paciente não encontrado: " + id);
        }
    }

    //Buscar todos
    @Transactional(readOnly = true)
    public List<PacienteDto> buscarTodos(){
        return pacienteRepository.findAll()
                .stream()
                .map(p-> new PacienteDto(p))
                .collect(Collectors.toList());

    }

    //BuscaPorId
    @Transactional(readOnly = true)
    public Optional<PacienteDto> buscarPacienteId(Integer id) {
        return pacienteRepository.findById(id)
                .map(p-> new PacienteDto(p));

    }

    @Transactional
    public Optional<Paciente> atualizarPaciente(PacienteDto dto) {
        return pacienteRepository.findById(dto.getId())
                .map(p -> {
                    p.setNome(dto.getNome());
                    p.setCpf(dto.getCpf());
                    p.setDataCad(dto.getDataCad());
                    p.setEndereco(dto.getEndereco().toEntity());
                    return pacienteRepository.save(p);
                });
    }
}
