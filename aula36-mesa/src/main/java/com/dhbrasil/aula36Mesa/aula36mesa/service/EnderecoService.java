package com.dhbrasil.aula36Mesa.aula36mesa.service;

import com.dhbrasil.aula36Mesa.aula36mesa.dto.DentistaDto;
import com.dhbrasil.aula36Mesa.aula36mesa.dto.EnderecoDto;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Dentista;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Endereco;
import com.dhbrasil.aula36Mesa.aula36mesa.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.management.AttributeNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class EnderecoService {

    private final EnderecoRepository enderecoRepository;

    @Autowired
    public EnderecoService(EnderecoRepository enderecoRepository) {
        this.enderecoRepository = enderecoRepository;
    }

    //Salvar
    @Transactional
    public EnderecoDto cadastrar(EnderecoDto enderecoDto) {
        Endereco endereco = enderecoRepository.save(enderecoDto.toEntity());
        return new EnderecoDto(endereco);
    }
    //Excluir
    @Transactional
    public void excluir(Integer id){
        try{
            enderecoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResponseStatusException(NOT_FOUND, "Endereço não encontrado: " + id);
        }
    }

    //Buscar todos
    @Transactional(readOnly = true)
    public List<EnderecoDto> buscarTodos(){
        return enderecoRepository.findAll()
                .stream()
                .map(e-> new EnderecoDto(e))
                .collect(Collectors.toList());

    }

    //BuscaPorId
    @Transactional(readOnly = true)
    public Optional<EnderecoDto> buscarEnderecoId(Integer id) {
        return enderecoRepository.findById(id)
                .map(e -> new EnderecoDto(e));

    }

    //Alterar
    @Transactional
    public Optional<Endereco> atualizarEndereco(EnderecoDto dto) {
        return enderecoRepository.findById(dto.getId())
                .map(e -> {
                    e.setRua(dto.getRua());
                    e.setNumero(dto.getNumero());
                    e.setBairro(dto.getBairro());
                    e.setCidade(dto.getCidade());
                    e.setEstado(dto.getEstado());

                    return enderecoRepository.save(e);
                });
    }
}
