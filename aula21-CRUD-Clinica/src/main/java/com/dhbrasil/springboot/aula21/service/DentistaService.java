package com.dhbrasil.springboot.aula21.service;

import com.dhbrasil.springboot.aula21.model.Dentista;
import dao.IDao;

import java.util.List;

public class DentistaService {

    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    private IDao<Dentista> dentistaIDao;

    public Dentista salvar(Dentista dentista){
        dentistaIDao.salvar(dentista);
        return dentista;
    }

    public List<Dentista> buscarTodos(){
        return dentistaIDao.buscarTodos();

    }


}
