package com.dhbrasil.springboot.aula21.service;

import com.dhbrasil.springboot.aula21.model.Endereco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EnderecoServiceTest {

    @Autowired
    private EnderecoService enderecoService;

    @Test
    public void createEndereco(){
        Endereco endereco = new Endereco("Glicerio", "301", "Sao", "Liberdade");

        Endereco enderecoSalvo = enderecoService.salvar(endereco);
        Assertions.assertNotNull(enderecoSalvo.getId());

        System.out.println(enderecoSalvo);

    }

}