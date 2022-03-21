package com.dhbrasil.springboot.aula21.service;


import com.dhbrasil.springboot.aula21.dao.IDao;
import com.dhbrasil.springboot.aula21.model.Dentista;
import org.springframework.stereotype.Service;

@Service
public class DentistaService {

    private IDao<Dentista> dentistaIDao;


    public DentistaService(IDao<Dentista> dentistaIDao) {
        this.dentistaIDao = dentistaIDao;
    }

    public Dentista salvar(Dentista dentista) {
        System.out.println("Salvando dentista...");
        Dentista salvar = dentistaIDao.salvar(dentista);
        System.out.println(String.format("Dentista salvo com o id: [%s]", dentista.getId()));

        return salvar;
    }

    /*public List<Dentista> listar(){
        System.out.println("Listando dentistas");
        List<Dentista> dentistas = dentistaIDao.listar();
        System.out.println(String.format("Foram encontras [%s] filiais", dentistas.size()));
        return dentistas;
    }*/

}
