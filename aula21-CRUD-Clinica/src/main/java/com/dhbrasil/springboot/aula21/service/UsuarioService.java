package com.dhbrasil.springboot.aula21.service;

import com.dhbrasil.springboot.aula21.model.Dentista;
import com.dhbrasil.springboot.aula21.model.Usuario;
import dao.IDao;

import java.util.List;
import java.util.Optional;

public class UsuarioService {

    private IDao<Usuario> usuarioIDao;

    public UsuarioService(IDao<Usuario> usuarioIDao) {
        this.usuarioIDao = usuarioIDao;
    }

    public Usuario salvar(Usuario usuario){
        usuarioIDao.salvar(usuario);
        return usuario;
    }

    public List<Usuario> buscarTodos(){
        return usuarioIDao.buscarTodos();
    }

    public void excluir(Integer id){
        usuarioIDao.excluir(id);
    }

    public Optional<Usuario> buscar(Integer id){
        return  usuarioIDao.buscar(id);
    }

    public Usuario atualizar(Usuario usuario){
        return usuarioIDao.atualizar(usuario);
    }

}
