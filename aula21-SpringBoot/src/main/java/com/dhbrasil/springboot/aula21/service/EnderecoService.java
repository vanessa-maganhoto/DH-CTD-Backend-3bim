package com.dhbrasil.springboot.aula21.service;

import com.dhbrasil.springboot.aula21.dao.IDao;
import com.dhbrasil.springboot.aula21.model.Endereco;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    private IDao<Endereco> enderecoIDao;

    public EnderecoService(IDao<Endereco> enderecoIDao) {
        this.enderecoIDao = enderecoIDao;
    }

    public Endereco salvar(Endereco endereco) {
        System.out.println("Salvando endereco...");
        Endereco salvar = enderecoIDao.salvar(endereco);

        return salvar;
    }
}
