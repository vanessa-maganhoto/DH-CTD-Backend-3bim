package dao;

import model.Filial;

import java.util.List;

public interface IDao <T>{

    T salvar(T t);

    List<Filial> listar();

}
