package com.dhbrasil.springboot.aula21.dao;

import com.dhbrasil.springboot.aula21.model.Dentista;

import java.util.List;

public interface IDao <T>{
    T salvar(T t);

    /*List<Dentista> listar();*/

}
