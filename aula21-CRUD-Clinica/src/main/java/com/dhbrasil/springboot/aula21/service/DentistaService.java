package com.dhbrasil.springboot.aula21.service;

import com.dhbrasil.springboot.aula21.model.Dentista;
import dao.IDao;

import java.util.List;

public class DentistaService {

    private IDao<Dentista> dentistaIDao;

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }


    public Dentista salvar(Dentista dentista){
        dentistaIDao.salvar(dentista);
        return dentista;
    }

    public List<Dentista> buscarTodos(){
        return dentistaIDao.buscarTodos();

    }

    public void excluir(Integer id){
        dentistaIDao.excluir(id);
    }


}
