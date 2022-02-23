package com.dh.aula02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FuncionarioTest {
    @Test
    void Calculos(){
        Funcionario func = new Efetivo ("Pedro", "Maciel", "56116",3000.0, 1000.0, 500.0);

        func.pagamentoSalario();

        func = new Contratado("Marluce", "Dias", "51987", 50.0, 30);
        func.pagamentoSalario();
    }
}