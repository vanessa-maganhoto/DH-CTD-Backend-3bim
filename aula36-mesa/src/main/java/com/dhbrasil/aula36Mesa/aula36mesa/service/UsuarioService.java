package com.dhbrasil.aula36Mesa.aula36mesa.service;

import com.dhbrasil.aula36Mesa.aula36mesa.dto.EnderecoDto;
import com.dhbrasil.aula36Mesa.aula36mesa.dto.UsuarioDto;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Endereco;
import com.dhbrasil.aula36Mesa.aula36mesa.model.Usuario;
import com.dhbrasil.aula36Mesa.aula36mesa.repository.UsuarioRepository;
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
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Salvar
    @Transactional
    public UsuarioDto cadastrar(UsuarioDto usuarioDto) {
        Usuario usuario = usuarioRepository.save(usuarioDto.toEntity());
        return new UsuarioDto(usuario);
    }
    //Excluir
    @Transactional
    public void excluir(Integer id){
        try{
            usuarioRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e){
            throw new ResponseStatusException(NOT_FOUND, "Usuário não encontrado: " + id);
        }
    }

    //Buscar todos
    @Transactional(readOnly = true)
    public List<UsuarioDto> buscarTodos(){
        return usuarioRepository.findAll()
                .stream()
                .map(u-> new UsuarioDto(u))
                .collect(Collectors.toList());

    }

    //BuscaPorId
    @Transactional(readOnly = true)
    public Optional<UsuarioDto> buscarUsuarioId(Integer id) {
        return usuarioRepository.findById(id)
                .map(u-> new UsuarioDto(u));

    }

    //Alterar
    @Transactional
    public Optional<Usuario> atualizarUsuario(UsuarioDto dto) {
        return usuarioRepository.findById(dto.getId())
                .map(u -> {
                    u.setNome(dto.getNome());
                    u.setEmail(dto.getEmail());
                    u.setSenha(dto.getSenha());
                    u.setAcesso(dto.getAcesso());

                    return usuarioRepository.save(u);
                });
    }

}


