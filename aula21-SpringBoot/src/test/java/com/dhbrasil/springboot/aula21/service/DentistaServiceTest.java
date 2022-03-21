package com.dhbrasil.springboot.aula21.service;

import com.dhbrasil.springboot.aula21.model.Dentista;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DentistaServiceTest {

    @Autowired
    private DentistaService dentistaService;

    @Test
    public void testCreate() {
        Dentista dentista = new Dentista("Renan", "Tranbique", 171);

        Dentista dentistaSalvo = dentistaService.salvar(dentista);
        Assertions.assertNotNull(dentistaSalvo.getId());

    }

}